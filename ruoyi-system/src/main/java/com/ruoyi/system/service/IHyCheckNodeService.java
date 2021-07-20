package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.HyCheckNode;

/**
 * 巡检节点Service接口
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public interface IHyCheckNodeService 
{
    /**
     * 查询巡检节点
     * 
     * @param id 巡检节点ID
     * @return 巡检节点
     */
    public HyCheckNode selectHyCheckNodeById(Long id);

    /**
     * 查询巡检节点列表
     * 
     * @param HyCheckNode 巡检节点
     * @return 巡检节点集合
     */
    public List<HyCheckNode> selectHyCheckNodeList(HyCheckNode HyCheckNode);

    /**
     * 新增巡检节点
     * 
     * @param HyCheckNode 巡检节点
     * @return 结果
     */
    public int insertHyCheckNode(HyCheckNode HyCheckNode);

    /**
     * 修改巡检节点
     * 
     * @param HyCheckNode 巡检节点
     * @return 结果
     */
    public int updateHyCheckNode(HyCheckNode HyCheckNode);

    /**
     * 批量删除巡检节点
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCheckNodeByIds(String ids);

    /**
     * 删除巡检节点信息
     * 
     * @param id 巡检节点ID
     * @return 结果
     */
    public int deleteHyCheckNodeById(Long id);
}
