package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyNodeTaskMapper;
import com.ruoyi.system.domain.HyNodeTask;
import com.ruoyi.system.service.IHyNodeTaskService;
import com.ruoyi.common.core.text.Convert;

/**
 * 节点巡检任务Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Service
public class HyNodeTaskServiceImpl implements IHyNodeTaskService 
{
    @Autowired
    private HyNodeTaskMapper hyNodeTaskMapper;

    /**
     * 查询节点巡检任务
     * 
     * @param id 节点巡检任务ID
     * @return 节点巡检任务
     */
    @Override
    public HyNodeTask selectHyNodeTaskById(Long id)
    {
        return hyNodeTaskMapper.selectHyNodeTaskById(id);
    }

    /**
     * 查询节点巡检任务列表
     * 
     * @param hyNodeTask 节点巡检任务
     * @return 节点巡检任务
     */
    @Override
    public List<HyNodeTask> selectHyNodeTaskList(HyNodeTask hyNodeTask)
    {
        return hyNodeTaskMapper.selectHyNodeTaskList(hyNodeTask);
    }

    /**
     * 新增节点巡检任务
     * 
     * @param hyNodeTask 节点巡检任务
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyNodeTask(HyNodeTask hyNodeTask)
    {
        return hyNodeTaskMapper.insertHyNodeTask(hyNodeTask);
    }

    /**
     * 修改节点巡检任务
     * 
     * @param hyNodeTask 节点巡检任务
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyNodeTask(HyNodeTask hyNodeTask)
    {
        return hyNodeTaskMapper.updateHyNodeTask(hyNodeTask);
    }

    /**
     * 删除节点巡检任务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyNodeTaskByIds(String ids)
    {
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
    public int deleteHyNodeTaskById(Long id)
    {
        return hyNodeTaskMapper.deleteHyNodeTaskById(id);
    }
}
