package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TaskAndNode;

/**
 * 巡检任务和巡检节点关联Service接口
 * 
 * @author Administrator
 * @date 2021-07-21
 */
public interface ITaskAndNodeService 
{
    /**
     * 查询巡检任务和巡检节点关联
     * 
     * @param taskId 巡检任务和巡检节点关联ID
     * @return 巡检任务和巡检节点关联
     */
    public TaskAndNode selectTaskAndNodeById(Long taskId);

    /**
     * 查询巡检任务和巡检节点关联列表
     * 
     * @param taskAndNode 巡检任务和巡检节点关联
     * @return 巡检任务和巡检节点关联集合
     */
    public List<TaskAndNode> selectTaskAndNodeList(TaskAndNode taskAndNode);

    /**
     * 新增巡检任务和巡检节点关联
     * 
     * @param taskAndNode 巡检任务和巡检节点关联
     * @return 结果
     */
    public int insertTaskAndNode(TaskAndNode taskAndNode);

    /**
     * 修改巡检任务和巡检节点关联
     * 
     * @param taskAndNode 巡检任务和巡检节点关联
     * @return 结果
     */
    public int updateTaskAndNode(TaskAndNode taskAndNode);

    /**
     * 批量删除巡检任务和巡检节点关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaskAndNodeByIds(String ids);

    /**
     * 删除巡检任务和巡检节点关联信息
     * 
     * @param taskId 巡检任务和巡检节点关联ID
     * @return 结果
     */
    public int deleteTaskAndNodeById(Long taskId);
}