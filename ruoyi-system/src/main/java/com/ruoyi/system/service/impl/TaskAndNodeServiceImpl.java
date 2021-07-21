package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.TaskAndNodeMapper;
import com.ruoyi.system.domain.TaskAndNode;
import com.ruoyi.system.service.ITaskAndNodeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检任务和巡检节点关联Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-21
 */
@Service
public class TaskAndNodeServiceImpl implements ITaskAndNodeService 
{
    @Autowired
    private TaskAndNodeMapper taskAndNodeMapper;

    /**
     * 查询巡检任务和巡检节点关联
     * 
     * @param taskId 巡检任务和巡检节点关联ID
     * @return 巡检任务和巡检节点关联
     */
    @Override
    public TaskAndNode selectTaskAndNodeById(Long taskId)
    {
        return taskAndNodeMapper.selectTaskAndNodeById(taskId);
    }

    /**
     * 查询巡检任务和巡检节点关联列表
     * 
     * @param taskAndNode 巡检任务和巡检节点关联
     * @return 巡检任务和巡检节点关联
     */
    @Override
    public List<TaskAndNode> selectTaskAndNodeList(TaskAndNode taskAndNode)
    {
        return taskAndNodeMapper.selectTaskAndNodeList(taskAndNode);
    }

    /**
     * 新增巡检任务和巡检节点关联
     * 
     * @param taskAndNode 巡检任务和巡检节点关联
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertTaskAndNode(TaskAndNode taskAndNode)
    {
        return taskAndNodeMapper.insertTaskAndNode(taskAndNode);
    }

    /**
     * 修改巡检任务和巡检节点关联
     * 
     * @param taskAndNode 巡检任务和巡检节点关联
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateTaskAndNode(TaskAndNode taskAndNode)
    {
        return taskAndNodeMapper.updateTaskAndNode(taskAndNode);
    }

    /**
     * 删除巡检任务和巡检节点关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteTaskAndNodeByIds(String ids)
    {
        return taskAndNodeMapper.deleteTaskAndNodeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检任务和巡检节点关联信息
     * 
     * @param taskId 巡检任务和巡检节点关联ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteTaskAndNodeById(Long nodeId)
    {
        return taskAndNodeMapper.deleteTaskAndNodeById(nodeId);
    }
}