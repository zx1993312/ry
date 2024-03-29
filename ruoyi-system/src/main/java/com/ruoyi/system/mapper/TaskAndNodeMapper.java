package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.system.domain.TaskAndNode;

/**
 * 巡检任务和巡检节点关联Mapper接口
 * 
 * @author Administrator
 * @date 2021-07-21
 */
public interface TaskAndNodeMapper 
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
     * 修改是否巡检状态通过任务id和节点id
     * 
     * @param taskAndNode 巡检任务和巡检节点关联
     * @return 结果
     */
    public int updateTaskAndNodeByTaskIdAndNodeId(TaskAndNode taskAndNode);

    /**
     * 删除巡检任务和巡检节点关联
     * 
     * @param taskId 巡检任务和巡检节点关联ID
     * @return 结果
     */
    public int deleteTaskAndNodeById(Long taskId);
    
    
    /**
     * 删除巡检任务和巡检节点关联通过巡检节点和巡检任务id
     * 
     * @param taskId 巡检任务和巡检节点关联ID
     * @return 结果
     */
    public int deleteTaskAndNodeByNodeIdAndTaskId(@Param("nodeId") Long nodeId,@Param("taskId") Long taskId);

    /**
     * 批量删除巡检任务和巡检节点关联
     * 
     * @param taskIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaskAndNodeByIds(String[] taskIds);
}