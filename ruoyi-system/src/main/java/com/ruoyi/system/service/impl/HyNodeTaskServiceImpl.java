package com.ruoyi.system.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyCheckNodeMapper;
import com.ruoyi.system.mapper.HyNodeTaskMapper;
import com.ruoyi.system.mapper.TaskAndNodeMapper;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyCheckNode;
import com.ruoyi.system.domain.HyNodeTask;
import com.ruoyi.system.domain.TaskAndNode;
import com.ruoyi.system.service.IHyNodeTaskService;
import com.ruoyi.common.constant.ScheduleConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.job.TaskException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.quartz.domain.SysJob;
import com.ruoyi.quartz.mapper.SysJobMapper;
import com.ruoyi.quartz.util.ScheduleUtils;

/**
 * 节点巡检任务Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-21
 */
@Service
public class HyNodeTaskServiceImpl implements IHyNodeTaskService {
	@Autowired
	private HyNodeTaskMapper hyNodeTaskMapper;

	@Autowired
	private TaskAndNodeMapper taskAndNodeMapper;

	@Autowired
	private HyCheckNodeMapper hyCheckNodeMapper;

	@Autowired
	private SysJobMapper jobMapper;

	@Autowired
	private Scheduler scheduler;

	/**
	 * 查询节点巡检任务
	 * 
	 * @param id 节点巡检任务ID
	 * @return 节点巡检任务
	 */
	@Override
	public HyNodeTask selectHyNodeTaskById(Long id) {
		return hyNodeTaskMapper.selectHyNodeTaskById(id);
	}

	/**
	 * 查询节点巡检任务列表
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 节点巡检任务
	 */
	@Override
	public List<HyNodeTask> selectHyNodeTaskList(HyNodeTask hyNodeTask) {
		return hyNodeTaskMapper.selectHyNodeTaskList(hyNodeTask);
	}

	/**
	 * 查询节点巡检任务未完成列表
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 节点巡检任务
	 */
	@Override
	public List<HyNodeTask> selectHyNodeTaskListByUnfinished(HyNodeTask hyNodeTask) {
		return hyNodeTaskMapper.selectHyNodeTaskListByUnfinished(hyNodeTask);
	}

	/**
	 * 查询节点巡检任务进行中列表
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 节点巡检任务
	 */
	@Override
	public List<HyNodeTask> selectHyNodeTaskListByUnderway(HyNodeTask hyNodeTask) {
		return hyNodeTaskMapper.selectHyNodeTaskListByUnderway(hyNodeTask);
	}

	/**
	 * 查询节点巡检任务已完成列表
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 节点巡检任务
	 */
	@Override
	public List<HyNodeTask> selectHyNodeTaskListByFinished(HyNodeTask hyNodeTask) {
		return hyNodeTaskMapper.selectHyNodeTaskListByFinished(hyNodeTask);
	}

	/**
	 * 新增节点巡检任务
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 结果
	 * @throws TaskException
	 * @throws SchedulerException
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertHyNodeTask(HyNodeTask hyNodeTask) throws SchedulerException, TaskException {
		int row = 0;
		row = hyNodeTaskMapper.insertHyNodeTask(hyNodeTask);
		if (row > 0) {
			if (hyNodeTask.getNodeIds() != null && !"".equals(hyNodeTask.getNodeIds())) {
				String[] nodeIds = hyNodeTask.getNodeIds().split(",");
				hyNodeTask = hyNodeTaskMapper.selectHyNodeTaskList(hyNodeTask).get(0);
				Long taskId = hyNodeTask.getId();
				for (String nodeId : nodeIds) {
					TaskAndNode taskAndNode = new TaskAndNode();
					taskAndNode.setNodeId(Long.valueOf(nodeId));
					taskAndNode.setTaskId(taskId);
					List<TaskAndNode> list = taskAndNodeMapper.selectTaskAndNodeList(taskAndNode);
					if (list.size() == 0) {
						taskAndNode.setIsInspection("0");
						taskAndNodeMapper.insertTaskAndNode(taskAndNode);
					}
				}
				if (StringUtils.isNotEmpty(hyNodeTask.getTaskName())) {
					SysJob job = new SysJob();
					job.setJobName(hyNodeTask.getTaskName());
					job.setJobGroup("DEFAULT");
					job.setInvokeTarget("hangYuTask.update");
					job.setMisfirePolicy("1");
					job.setConcurrent("1");
					job.setStatus("0");
					switch (hyNodeTask.getTaskTime()) {
					case "1":
						job.setCronExpression(Constants.CRON_DAY);
						break;
					case "2":
						job.setCronExpression(Constants.CRON_WEEK);
						break;
					case "3":
						job.setCronExpression(Constants.CRON_MONTH);
						break;
					}

					row = jobMapper.insertJob(job);
					if (ScheduleConstants.Status.NORMAL.getValue().equals(job.getStatus())) {
						Long jobId = job.getJobId();
						String jobGroup = job.getJobGroup();
						job.setStatus(ScheduleConstants.Status.NORMAL.getValue());
						row = jobMapper.updateJob(job);
						if (row > 0) {
							scheduler.resumeJob(ScheduleUtils.getJobKey(jobId, jobGroup));
						}
					}
					if (row > 0) {
						ScheduleUtils.createScheduleJob(scheduler, job);
					}
				}

			}
		}

		return row;

	}

	/**
	 * 修改节点巡检任务
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateHyNodeTask(HyNodeTask hyNodeTask) {
		if (hyNodeTask.getNodeIds() != null && !"".equals(hyNodeTask.getNodeIds())) {
			String[] nodeIds = hyNodeTask.getNodeIds().split(",");
			Long taskId = hyNodeTask.getId();
			List<HyCheckNode> checkNodeList = hyCheckNodeMapper.selectHyCheckNodeList(new HyCheckNode());
			String ids = "";
			for (HyCheckNode checkNode : checkNodeList) {
				Long nodeId = checkNode.getId();
				ids = ids + nodeId + ",";
			}
			String[] id = ids.split(",");
			String[] iii = minus(nodeIds, id);
			for (String i : iii) {
				TaskAndNode taskAndNode = new TaskAndNode();
				taskAndNode.setTaskId(taskId);
				taskAndNode.setNodeId(Long.valueOf(i));
				List<TaskAndNode> list = taskAndNodeMapper.selectTaskAndNodeList(taskAndNode);
				if (list != null) {
					taskAndNodeMapper.deleteTaskAndNodeByNodeIdAndTaskId(Long.valueOf(i), taskId);
				}
			}
			for (String nodeId : nodeIds) {
				TaskAndNode taskAndNode = new TaskAndNode();
				taskAndNode.setTaskId(taskId);
				taskAndNode.setNodeId(Long.valueOf(nodeId));
				List<TaskAndNode> list = taskAndNodeMapper.selectTaskAndNodeList(taskAndNode);

				if (list.size() == 0) {
					taskAndNode.setIsInspection("0");
					taskAndNodeMapper.insertTaskAndNode(taskAndNode);
				}

			}
		}
		return hyNodeTaskMapper.updateHyNodeTask(hyNodeTask);
	}

	// 求两个数组的差集
	public static String[] minus(String[] arr1, String[] arr2) {
		LinkedList<String> list = new LinkedList<>();
		LinkedList<String> history = new LinkedList<>();
		String[] longerArr = arr1;
		String[] shorterArr = arr2;
		// 找出较长的数组来减较短的数组
		if (arr1.length > arr2.length) {
			longerArr = arr2;
			shorterArr = arr1;
		}
		for (String str : longerArr) {
			if (!list.contains(str)) {
				list.add(str);
			}
		}
		for (String str : shorterArr) {
			if (list.contains(str)) {
				history.add(str);
				list.remove(str);
			} else {
				if (!history.contains(str)) {
					list.add(str);
				}
			}
		}

		String[] result = {};
		return list.toArray(result);
	}

	/**
	 * 删除节点巡检任务对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyNodeTaskByIds(String ids) {
		taskAndNodeMapper.deleteTaskAndNodeByIds(Convert.toStrArray(ids));
		return hyNodeTaskMapper.deleteHyNodeTaskByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除节点巡检任务信息
	 * 
	 * @param id 节点巡检任务ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyNodeTaskById(Long id) {
		taskAndNodeMapper.deleteTaskAndNodeById(id);
		return hyNodeTaskMapper.deleteHyNodeTaskById(id);
	}
}
