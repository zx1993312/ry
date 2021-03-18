package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyWechatPaymentMapper;
import com.ruoyi.system.domain.HyWechatPayment;
import com.ruoyi.system.service.IHyWechatPaymentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 微信支付Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyWechatPaymentServiceImpl implements IHyWechatPaymentService 
{
    @Autowired
    private HyWechatPaymentMapper hyWechatPaymentMapper;

    /**
     * 查询微信支付
     * 
     * @param id 微信支付ID
     * @return 微信支付
     */
    @Override
    public HyWechatPayment selectHyWechatPaymentById(Long id)
    {
        return hyWechatPaymentMapper.selectHyWechatPaymentById(id);
    }

    /**
     * 查询微信支付列表
     * 
     * @param hyWechatPayment 微信支付
     * @return 微信支付
     */
    @Override
    public List<HyWechatPayment> selectHyWechatPaymentList(HyWechatPayment hyWechatPayment)
    {
        return hyWechatPaymentMapper.selectHyWechatPaymentList(hyWechatPayment);
    }

    /**
     * 新增微信支付
     * 
     * @param hyWechatPayment 微信支付
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyWechatPayment(HyWechatPayment hyWechatPayment)
    {
        return hyWechatPaymentMapper.insertHyWechatPayment(hyWechatPayment);
    }

    /**
     * 修改微信支付
     * 
     * @param hyWechatPayment 微信支付
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyWechatPayment(HyWechatPayment hyWechatPayment)
    {
        return hyWechatPaymentMapper.updateHyWechatPayment(hyWechatPayment);
    }

    /**
     * 删除微信支付对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyWechatPaymentByIds(String ids)
    {
        return hyWechatPaymentMapper.deleteHyWechatPaymentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除微信支付信息
     * 
     * @param id 微信支付ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyWechatPaymentById(Long id)
    {
        return hyWechatPaymentMapper.deleteHyWechatPaymentById(id);
    }
}
