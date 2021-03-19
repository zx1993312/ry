package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyUnionpayBusinessMapper;
import com.ruoyi.system.domain.HyUnionpayBusiness;
import com.ruoyi.system.service.IHyUnionpayBusinessService;
import com.ruoyi.common.core.text.Convert;

/**
 * 银联商务Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyUnionpayBusinessServiceImpl implements IHyUnionpayBusinessService 
{
    @Autowired
    private HyUnionpayBusinessMapper hyUnionpayBusinessMapper;

    /**
     * 查询银联商务
     * 
     * @param id 银联商务ID
     * @return 银联商务
     */
    @Override
    public HyUnionpayBusiness selectHyUnionpayBusinessById(Long id)
    {
        return hyUnionpayBusinessMapper.selectHyUnionpayBusinessById(id);
    }

    /**
     * 查询银联商务列表
     * 
     * @param hyUnionpayBusiness 银联商务
     * @return 银联商务
     */
    @Override
    public List<HyUnionpayBusiness> selectHyUnionpayBusinessList(HyUnionpayBusiness hyUnionpayBusiness)
    {
        return hyUnionpayBusinessMapper.selectHyUnionpayBusinessList(hyUnionpayBusiness);
    }

    /**
     * 新增银联商务
     * 
     * @param hyUnionpayBusiness 银联商务
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyUnionpayBusiness(HyUnionpayBusiness hyUnionpayBusiness)
    {
        return hyUnionpayBusinessMapper.insertHyUnionpayBusiness(hyUnionpayBusiness);
    }

    /**
     * 修改银联商务
     * 
     * @param hyUnionpayBusiness 银联商务
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyUnionpayBusiness(HyUnionpayBusiness hyUnionpayBusiness)
    {
        return hyUnionpayBusinessMapper.updateHyUnionpayBusiness(hyUnionpayBusiness);
    }

    /**
     * 删除银联商务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyUnionpayBusinessByIds(String ids)
    {
        return hyUnionpayBusinessMapper.deleteHyUnionpayBusinessByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除银联商务信息
     * 
     * @param id 银联商务ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyUnionpayBusinessById(Long id)
    {
        return hyUnionpayBusinessMapper.deleteHyUnionpayBusinessById(id);
    }
}
