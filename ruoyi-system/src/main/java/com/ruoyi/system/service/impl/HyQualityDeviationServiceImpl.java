package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyQualityDeviationMapper;
import com.ruoyi.system.domain.HyQualityDeviation;
import com.ruoyi.system.service.IHyQualityDeviationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 品质异常Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-13
 */
@Service
public class HyQualityDeviationServiceImpl implements IHyQualityDeviationService 
{
    @Autowired
    private HyQualityDeviationMapper hyQualityDeviationMapper;

    /**
     * 查询品质异常
     * 
     * @param id 品质异常ID
     * @return 品质异常
     */
    @Override
    public HyQualityDeviation selectHyQualityDeviationById(Long id)
    {
        return hyQualityDeviationMapper.selectHyQualityDeviationById(id);
    }

    /**
     * 查询品质异常列表
     * 
     * @param hyQualityDeviation 品质异常
     * @return 品质异常
     */
    @Override
    public List<HyQualityDeviation> selectHyQualityDeviationList(HyQualityDeviation hyQualityDeviation)
    {
        return hyQualityDeviationMapper.selectHyQualityDeviationList(hyQualityDeviation);
    }
    
    /**
     * 查询品质异常待审核列表
     * 
     * @param hyQualityDeviation 品质异常
     * @return 品质异常
     */
    @Override
    public List<HyQualityDeviation> selectHyQualityDeviationListByAudit(HyQualityDeviation hyQualityDeviation)
    {
    	return hyQualityDeviationMapper.selectHyQualityDeviationListByAudit(hyQualityDeviation);
    }
    
    /**
     * 查询品质异常已通过列表
     * 
     * @param hyQualityDeviation 品质异常
     * @return 品质异常
     */
    @Override
    public List<HyQualityDeviation> selectHyQualityDeviationListByThrough(HyQualityDeviation hyQualityDeviation)
    {
    	return hyQualityDeviationMapper.selectHyQualityDeviationListByThrough(hyQualityDeviation);
    }
    
    /**
     * 查询品质异常已拒绝列表
     * 
     * @param hyQualityDeviation 品质异常
     * @return 品质异常
     */
    @Override
    public List<HyQualityDeviation> selectHyQualityDeviationListByRefusal(HyQualityDeviation hyQualityDeviation)
    {
    	return hyQualityDeviationMapper.selectHyQualityDeviationListByRefusal(hyQualityDeviation);
    }

    /**
     * 新增品质异常
     * 
     * @param hyQualityDeviation 品质异常
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyQualityDeviation(HyQualityDeviation hyQualityDeviation)
    {
        return hyQualityDeviationMapper.insertHyQualityDeviation(hyQualityDeviation);
    }

    /**
     * 修改品质异常
     * 
     * @param hyQualityDeviation 品质异常
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyQualityDeviation(HyQualityDeviation hyQualityDeviation)
    {
        return hyQualityDeviationMapper.updateHyQualityDeviation(hyQualityDeviation);
    }

    /**
     * 删除品质异常对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyQualityDeviationByIds(String ids)
    {
        return hyQualityDeviationMapper.deleteHyQualityDeviationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除品质异常信息
     * 
     * @param id 品质异常ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyQualityDeviationById(Long id)
    {
        return hyQualityDeviationMapper.deleteHyQualityDeviationById(id);
    }
}
