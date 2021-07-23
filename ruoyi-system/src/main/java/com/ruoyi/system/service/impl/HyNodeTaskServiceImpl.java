package com.ruoyi.system.service.impl;

import java.util.List;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.constant.ScheduleConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.job.TaskException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.quartz.domain.SysJob;
import com.ruoyi.quartz.mapper.SysJobMapper;
import com.ruoyi.quartz.util.ScheduleUtils;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyCheckNode;
import com.ruoyi.system.domain.HyNodeTask;
import com.ruoyi.system.domain.TaskAndNode;
import com.ruoyi.system.mapper.HyCheckNodeMapper;
import com.ruoyi.system.mapper.HyNodeTaskMapper;
import com.ruoyi.system.mapper.TaskAndNodeMapper;
import com.ruoyi.system.service.IHyNodeTaskService;
import com.ruoyi.system.utils.HyListUtil;

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
	 * @param id
	 *            节点巡检任务ID
	 * @return 节点巡检任务
	 */
	@Override
	public HyNodeTask selectHyNodeTaskById(Long id) {
		return hyNodeTaskMapper.selectHyNodeTaskById(id);
	}

	/**
	 * 查询节点巡检任务列表
	 * 
	 * @param hyNodeTask
	 *            节点巡检任务
	 * @return 节点巡检任务
	 */
	@Override
	public List<HyNodeTask> selectHyNodeTaskList(HyNodeTask hyNodeTask) {
		return hyNodeTaskMapper.selectHyNodeTaskList(hyNodeTask);
	}

	/**
	 * 查询节点巡检任务未完成列表
	 * 
	 * @param hyNodeTask
	 *            节点巡检任务
	 * @return 节点巡检任务
	 */
	@Override
	public List<HyNodeTask> selectHyNodeTaskListByUnfinished(HyNodeTask hyNodeTask) {
		return hyNodeTaskMapper.selectHyNodeTaskListByUnfinished(hyNodeTask);
	}

	/**
	 * 查询节点巡检任务进行中列表
	 * 
	 * @param hyNodeTask
	 *            节点巡检任务
	 * @return 节点巡检任务
	 */
	@Override
	public List<HyNodeTask> selectHyNodeTaskListByUnderway(HyNodeTask hyNodeTask) {
		return hyNodeTaskMapper.selectHyNodeTaskListByUnderway(hyNodeTask);
	}

	/**
	 * 查询节点巡检任务已完成列表
	 * 
	 * @param hyNodeTask
	 *            节点巡检任务
	 * @return 节点巡检任务
	 */
	@Override
	public List<HyNodeTask> selectHyNodeTaskListByFinished(HyNodeTask hyNodeTask) {
		return hyNodeTaskMapper.selectHyNodeTaskListByFinished(hyNodeTask);
	}

	/**
	 * 新增节点巡检任务
	 * 
	 * @param hyNodeTask
	 *            节点巡检任务
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
					job.setInvokeTarget("hangYuTaskUtil.updateTaskAndNode(" + hyNodeTask.getId() + ")");
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
	 * @param hyNodeTask
	 *            节点巡检任务
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
			String[] iii = HyListUtil.minus(nodeIds, id);
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
		
		SysJob job = new SysJob();
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
		
		job.setInvokeTarget("hangYuTaskUtil.updateTaskAndNode(" + hyNodeTask.getId() + ")");
		jobMapper.updateJobByInvokeTarget(job);
		
		return hyNodeTaskMapper.updateHyNodeTask(hyNodeTask);
	}

	/**
	 * 删除节点巡检任务对象
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyNodeTaskByIds(String ids) {
		String[] id = Convert.toStrArray(ids);
		for (String taskId : id) {
			jobMapper.deleteJobByInvokeTarget("hangYuTaskUtil.updateTaskAndNode(" + taskId + ")");// 删除定时调度任务
		}
		taskAndNodeMapper.deleteTaskAndNodeByIds(Convert.toStrArray(ids));
		return hyNodeTaskMapper.deleteHyNodeTaskByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除节点巡检任务信息
	 * 
	 * @param id
	 *            节点巡检任务ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyNodeTaskById(Long id) {
		jobMapper.deleteJobByInvokeTarget("hangYuTaskUtil.updateTaskAndNode(" + id + ")");// 删除定时调度任务
		taskAndNodeMapper.deleteTaskAndNodeById(id);
		return hyNodeTaskMapper.deleteHyNodeTaskById(id);
	}
}
