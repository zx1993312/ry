package com.ruoyi.system.service;

import java.util.List;

import org.quartz.SchedulerException;

import com.ruoyi.common.exception.job.TaskException;
import com.ruoyi.system.domain.HyNodeTask;

/**
 * 节点巡检任务Service接口
 * 
 * @author Administrator
 * @date 2021-07-21
 */
public interface IHyNodeTaskService {
	/**
	 * 查询节点巡检任务
	 * 
	 * @param id 节点巡检任务ID
	 * @return 节点巡检任务
	 */
	public HyNodeTask selectHyNodeTaskById(Long id);

	/**
	 * 查询节点巡检任务列表
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 节点巡检任务集合
	 */
	public List<HyNodeTask> selectHyNodeTaskList(HyNodeTask hyNodeTask);

	/**
	 * 查询节点巡检任务未完成列表
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 节点巡检任务集合
	 */
	public List<HyNodeTask> selectHyNodeTaskListByUnfinished(HyNodeTask hyNodeTask);

	/**
	 * 查询节点巡检任务进行中列表
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 节点巡检任务集合
	 */
	public List<HyNodeTask> selectHyNodeTaskListByUnderway(HyNodeTask hyNodeTask);

	/**
	 * 查询节点巡检任务已完成列表
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 节点巡检任务集合
	 */
	public List<HyNodeTask> selectHyNodeTaskListByFinished(HyNodeTask hyNodeTask);

	/**
	 * 新增节点巡检任务
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 结果
	 */
	public int insertHyNodeTask(HyNodeTask hyNodeTask) throws SchedulerException, TaskException;

	/**
	 * 修改节点巡检任务
	 * 
	 * @param hyNodeTask 节点巡检任务
	 * @return 结果
	 */
	public int updateHyNodeTask(HyNodeTask hyNodeTask);

	/**
	 * 批量删除节点巡检任务
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyNodeTaskByIds(String ids);

	/**
	 * 删除节点巡检任务信息
	 * 
	 * @param id 节点巡检任务ID
	 * @return 结果
	 */
	public int deleteHyNodeTaskById(Long id);
}
