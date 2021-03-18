package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyDistribution;

/**
 * 分销Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-09
 */
public interface HyDistributionMapper 
{
    /**
     * 查询分销
     * 
     * @param id 分销ID
     * @return 分销
     */
    public HyDistribution selectHyDistributionById(Long id);

    /**
     * 查询分销列表
     * 
     * @param hyDistribution 分销
     * @return 分销集合
     */
    public List<HyDistribution> selectHyDistributionList(HyDistribution hyDistribution);

    /**
     * 新增分销
     * 
     * @param hyDistribution 分销
     * @return 结果
     */
    public int insertHyDistribution(HyDistribution hyDistribution);

    /**
     * 修改分销
     * 
     * @param hyDistribution 分销
     * @return 结果
     */
    public int updateHyDistribution(HyDistribution hyDistribution);

    /**
     * 删除分销
     * 
     * @param id 分销ID
     * @return 结果
     */
    public int deleteHyDistributionById(Long id);

    /**
     * 批量删除分销
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyDistributionByIds(String[] ids);
}
