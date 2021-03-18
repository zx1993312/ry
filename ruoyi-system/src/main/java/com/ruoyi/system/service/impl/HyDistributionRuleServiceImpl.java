package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyDistributionRuleMapper;
import com.ruoyi.system.domain.HyDistributionRule;
import com.ruoyi.system.service.IHyDistributionRuleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 分销规则Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-09
 */
@Service
public class HyDistributionRuleServiceImpl implements IHyDistributionRuleService 
{
    @Autowired
    private HyDistributionRuleMapper hyDistributionRuleMapper;

    /**
     * 查询分销规则
     * 
     * @param id 分销规则ID
     * @return 分销规则
     */
    @Override
    public HyDistributionRule selectHyDistributionRuleById(Long id)
    {
        return hyDistributionRuleMapper.selectHyDistributionRuleById(id);
    }

    /**
     * 查询分销规则列表
     * 
     * @param hyDistributionRule 分销规则
     * @return 分销规则
     */
    @Override
    public List<HyDistributionRule> selectHyDistributionRuleList(HyDistributionRule hyDistributionRule)
    {
        return hyDistributionRuleMapper.selectHyDistributionRuleList(hyDistributionRule);
    }

    /**
     * 新增分销规则
     * 
     * @param hyDistributionRule 分销规则
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyDistributionRule(HyDistributionRule hyDistributionRule)
    {
        return hyDistributionRuleMapper.insertHyDistributionRule(hyDistributionRule);
    }

    /**
     * 修改分销规则
     * 
     * @param hyDistributionRule 分销规则
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyDistributionRule(HyDistributionRule hyDistributionRule)
    {
        return hyDistributionRuleMapper.updateHyDistributionRule(hyDistributionRule);
    }

    /**
     * 删除分销规则对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDistributionRuleByIds(String ids)
    {
        return hyDistributionRuleMapper.deleteHyDistributionRuleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分销规则信息
     * 
     * @param id 分销规则ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDistributionRuleById(Long id)
    {
        return hyDistributionRuleMapper.deleteHyDistributionRuleById(id);
    }
}
