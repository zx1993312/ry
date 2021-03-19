package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyWechatPayment;

/**
 * 微信支付Service接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface IHyWechatPaymentService 
{
    /**
     * 查询微信支付
     * 
     * @param id 微信支付ID
     * @return 微信支付
     */
    public HyWechatPayment selectHyWechatPaymentById(Long id);

    /**
     * 查询微信支付列表
     * 
     * @param hyWechatPayment 微信支付
     * @return 微信支付集合
     */
    public List<HyWechatPayment> selectHyWechatPaymentList(HyWechatPayment hyWechatPayment);

    /**
     * 新增微信支付
     * 
     * @param hyWechatPayment 微信支付
     * @return 结果
     */
    public int insertHyWechatPayment(HyWechatPayment hyWechatPayment);

    /**
     * 修改微信支付
     * 
     * @param hyWechatPayment 微信支付
     * @return 结果
     */
    public int updateHyWechatPayment(HyWechatPayment hyWechatPayment);

    /**
     * 批量删除微信支付
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyWechatPaymentByIds(String ids);

    /**
     * 删除微信支付信息
     * 
     * @param id 微信支付ID
     * @return 结果
     */
    public int deleteHyWechatPaymentById(Long id);
}
