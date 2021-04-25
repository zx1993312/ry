package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyCheckeNodeMapper;
import com.ruoyi.system.domain.HyCheckeNode;
import com.ruoyi.system.service.IHyCheckeNodeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检节点Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Service
public class HyCheckeNodeServiceImpl implements IHyCheckeNodeService 
{
    @Autowired
    private HyCheckeNodeMapper hyCheckeNodeMapper;

    /**
     * 查询巡检节点
     * 
     * @param id 巡检节点ID
     * @return 巡检节点
     */
    @Override
    public HyCheckeNode selectHyCheckeNodeById(Long id)
    {
        return hyCheckeNodeMapper.selectHyCheckeNodeById(id);
    }

    /**
     * 查询巡检节点列表
     * 
     * @param hyCheckeNode 巡检节点
     * @return 巡检节点
     */
    @Override
    public List<HyCheckeNode> selectHyCheckeNodeList(HyCheckeNode hyCheckeNode)
    {
        return hyCheckeNodeMapper.selectHyCheckeNodeList(hyCheckeNode);
    }

    /**
     * 新增巡检节点
     * 
     * @param hyCheckeNode 巡检节点
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCheckeNode(HyCheckeNode hyCheckeNode)
    {
        return hyCheckeNodeMapper.insertHyCheckeNode(hyCheckeNode);
    }

    /**
     * 修改巡检节点
     * 
     * @param hyCheckeNode 巡检节点
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCheckeNode(HyCheckeNode hyCheckeNode)
    {
        return hyCheckeNodeMapper.updateHyCheckeNode(hyCheckeNode);
    }

    /**
     * 删除巡检节点对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCheckeNodeByIds(String ids)
    {
        return hyCheckeNodeMapper.deleteHyCheckeNodeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检节点信息
     * 
     * @param id 巡检节点ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCheckeNodeById(Long id)
    {
        return hyCheckeNodeMapper.deleteHyCheckeNodeById(id);
    }
}
