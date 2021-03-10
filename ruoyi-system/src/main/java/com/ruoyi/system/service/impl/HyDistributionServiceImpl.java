package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyDistributionMapper;
import com.ruoyi.system.domain.HyDistribution;
import com.ruoyi.system.service.IHyDistributionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 分销Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-09
 */
@Service
public class HyDistributionServiceImpl implements IHyDistributionService 
{
    @Autowired
    private HyDistributionMapper hyDistributionMapper;

    /**
     * 查询分销
     * 
     * @param id 分销ID
     * @return 分销
     */
    @Override
    public HyDistribution selectHyDistributionById(Long id)
    {
        return hyDistributionMapper.selectHyDistributionById(id);
    }

    /**
     * 查询分销列表
     * 
     * @param hyDistribution 分销
     * @return 分销
     */
    @Override
    public List<HyDistribution> selectHyDistributionList(HyDistribution hyDistribution)
    {
        return hyDistributionMapper.selectHyDistributionList(hyDistribution);
    }

    /**
     * 新增分销
     * 
     * @param hyDistribution 分销
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyDistribution(HyDistribution hyDistribution)
    {
        return hyDistributionMapper.insertHyDistribution(hyDistribution);
    }

    /**
     * 修改分销
     * 
     * @param hyDistribution 分销
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyDistribution(HyDistribution hyDistribution)
    {
        return hyDistributionMapper.updateHyDistribution(hyDistribution);
    }

    /**
     * 删除分销对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDistributionByIds(String ids)
    {
        return hyDistributionMapper.deleteHyDistributionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分销信息
     * 
     * @param id 分销ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDistributionById(Long id)
    {
        return hyDistributionMapper.deleteHyDistributionById(id);
    }
}
