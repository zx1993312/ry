package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyThirdPaymentMapper;
import com.ruoyi.system.domain.HyThirdPayment;
import com.ruoyi.system.service.IHyThirdPaymentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 微信支付第三方Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyThirdPaymentServiceImpl implements IHyThirdPaymentService 
{
    @Autowired
    private HyThirdPaymentMapper hyThirdPaymentMapper;

    /**
     * 查询微信支付第三方
     * 
     * @param id 微信支付第三方ID
     * @return 微信支付第三方
     */
    @Override
    public HyThirdPayment selectHyThirdPaymentById(Long id)
    {
        return hyThirdPaymentMapper.selectHyThirdPaymentById(id);
    }

    /**
     * 查询微信支付第三方列表
     * 
     * @param hyThirdPayment 微信支付第三方
     * @return 微信支付第三方
     */
    @Override
    public List<HyThirdPayment> selectHyThirdPaymentList(HyThirdPayment hyThirdPayment)
    {
        return hyThirdPaymentMapper.selectHyThirdPaymentList(hyThirdPayment);
    }

    /**
     * 新增微信支付第三方
     * 
     * @param hyThirdPayment 微信支付第三方
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyThirdPayment(HyThirdPayment hyThirdPayment)
    {
        return hyThirdPaymentMapper.insertHyThirdPayment(hyThirdPayment);
    }

    /**
     * 修改微信支付第三方
     * 
     * @param hyThirdPayment 微信支付第三方
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyThirdPayment(HyThirdPayment hyThirdPayment)
    {
        return hyThirdPaymentMapper.updateHyThirdPayment(hyThirdPayment);
    }

    /**
     * 删除微信支付第三方对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyThirdPaymentByIds(String ids)
    {
        return hyThirdPaymentMapper.deleteHyThirdPaymentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除微信支付第三方信息
     * 
     * @param id 微信支付第三方ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyThirdPaymentById(Long id)
    {
        return hyThirdPaymentMapper.deleteHyThirdPaymentById(id);
    }
}
