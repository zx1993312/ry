package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyNodeTask;

/**
 * 节点巡检任务Mapper接口
 * 
 * @author Administrator
 * @date 2021-07-21
 */
public interface HyNodeTaskMapper 
{
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
     * 新增节点巡检任务
     * 
     * @param hyNodeTask 节点巡检任务
     * @return 结果
     */
    public int insertHyNodeTask(HyNodeTask hyNodeTask);

    /**
     * 修改节点巡检任务
     * 
     * @param hyNodeTask 节点巡检任务
     * @return 结果
     */
    public int updateHyNodeTask(HyNodeTask hyNodeTask);

    /**
     * 删除节点巡检任务
     * 
     * @param id 节点巡检任务ID
     * @return 结果
     */
    public int deleteHyNodeTaskById(Long id);

    /**
     * 批量删除节点巡检任务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyNodeTaskByIds(String[] ids);
}
