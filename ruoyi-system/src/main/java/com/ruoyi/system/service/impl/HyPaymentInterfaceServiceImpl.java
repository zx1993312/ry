package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyPaymentInterfaceMapper;
import com.ruoyi.system.domain.HyPaymentInterface;
import com.ruoyi.system.service.IHyPaymentInterfaceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 支付接口设置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyPaymentInterfaceServiceImpl implements IHyPaymentInterfaceService 
{
    @Autowired
    private HyPaymentInterfaceMapper hyPaymentInterfaceMapper;

    /**
     * 查询支付接口设置
     * 
     * @param id 支付接口设置ID
     * @return 支付接口设置
     */
    @Override
    public HyPaymentInterface selectHyPaymentInterfaceById(Long id)
    {
        return hyPaymentInterfaceMapper.selectHyPaymentInterfaceById(id);
    }

    /**
     * 查询支付接口设置列表
     * 
     * @param hyPaymentInterface 支付接口设置
     * @return 支付接口设置
     */
    @Override
    public List<HyPaymentInterface> selectHyPaymentInterfaceList(HyPaymentInterface hyPaymentInterface)
    {
        return hyPaymentInterfaceMapper.selectHyPaymentInterfaceList(hyPaymentInterface);
    }

    /**
     * 新增支付接口设置
     * 
     * @param hyPaymentInterface 支付接口设置
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyPaymentInterface(HyPaymentInterface hyPaymentInterface)
    {
        return hyPaymentInterfaceMapper.insertHyPaymentInterface(hyPaymentInterface);
    }

    /**
     * 修改支付接口设置
     * 
     * @param hyPaymentInterface 支付接口设置
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyPaymentInterface(HyPaymentInterface hyPaymentInterface)
    {
        return hyPaymentInterfaceMapper.updateHyPaymentInterface(hyPaymentInterface);
    }

    /**
     * 删除支付接口设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPaymentInterfaceByIds(String ids)
    {
        return hyPaymentInterfaceMapper.deleteHyPaymentInterfaceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除支付接口设置信息
     * 
     * @param id 支付接口设置ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPaymentInterfaceById(Long id)
    {
        return hyPaymentInterfaceMapper.deleteHyPaymentInterfaceById(id);
    }
}
