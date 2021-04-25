package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyCheckeNode;

/**
 * 巡检节点Service接口
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public interface IHyCheckeNodeService 
{
    /**
     * 查询巡检节点
     * 
     * @param id 巡检节点ID
     * @return 巡检节点
     */
    public HyCheckeNode selectHyCheckeNodeById(Long id);

    /**
     * 查询巡检节点列表
     * 
     * @param hyCheckeNode 巡检节点
     * @return 巡检节点集合
     */
    public List<HyCheckeNode> selectHyCheckeNodeList(HyCheckeNode hyCheckeNode);

    /**
     * 新增巡检节点
     * 
     * @param hyCheckeNode 巡检节点
     * @return 结果
     */
    public int insertHyCheckeNode(HyCheckeNode hyCheckeNode);

    /**
     * 修改巡检节点
     * 
     * @param hyCheckeNode 巡检节点
     * @return 结果
     */
    public int updateHyCheckeNode(HyCheckeNode hyCheckeNode);

    /**
     * 批量删除巡检节点
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCheckeNodeByIds(String ids);

    /**
     * 删除巡检节点信息
     * 
     * @param id 巡检节点ID
     * @return 结果
     */
    public int deleteHyCheckeNodeById(Long id);
}
