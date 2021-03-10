package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyDistributionRule;

/**
 * 分销规则Service接口
 * 
 * @author Administrator
 * @date 2021-03-09
 */
public interface IHyDistributionRuleService 
{
    /**
     * 查询分销规则
     * 
     * @param id 分销规则ID
     * @return 分销规则
     */
    public HyDistributionRule selectHyDistributionRuleById(Long id);

    /**
     * 查询分销规则列表
     * 
     * @param hyDistributionRule 分销规则
     * @return 分销规则集合
     */
    public List<HyDistributionRule> selectHyDistributionRuleList(HyDistributionRule hyDistributionRule);

    /**
     * 新增分销规则
     * 
     * @param hyDistributionRule 分销规则
     * @return 结果
     */
    public int insertHyDistributionRule(HyDistributionRule hyDistributionRule);

    /**
     * 修改分销规则
     * 
     * @param hyDistributionRule 分销规则
     * @return 结果
     */
    public int updateHyDistributionRule(HyDistributionRule hyDistributionRule);

    /**
     * 批量删除分销规则
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyDistributionRuleByIds(String ids);

    /**
     * 删除分销规则信息
     * 
     * @param id 分销规则ID
     * @return 结果
     */
    public int deleteHyDistributionRuleById(Long id);
}
