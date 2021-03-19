package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyThirdPayment;

/**
 * 微信支付第三方Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface HyThirdPaymentMapper 
{
    /**
     * 查询微信支付第三方
     * 
     * @param id 微信支付第三方ID
     * @return 微信支付第三方
     */
    public HyThirdPayment selectHyThirdPaymentById(Long id);

    /**
     * 查询微信支付第三方列表
     * 
     * @param hyThirdPayment 微信支付第三方
     * @return 微信支付第三方集合
     */
    public List<HyThirdPayment> selectHyThirdPaymentList(HyThirdPayment hyThirdPayment);

    /**
     * 新增微信支付第三方
     * 
     * @param hyThirdPayment 微信支付第三方
     * @return 结果
     */
    public int insertHyThirdPayment(HyThirdPayment hyThirdPayment);

    /**
     * 修改微信支付第三方
     * 
     * @param hyThirdPayment 微信支付第三方
     * @return 结果
     */
    public int updateHyThirdPayment(HyThirdPayment hyThirdPayment);

    /**
     * 删除微信支付第三方
     * 
     * @param id 微信支付第三方ID
     * @return 结果
     */
    public int deleteHyThirdPaymentById(Long id);

    /**
     * 批量删除微信支付第三方
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyThirdPaymentByIds(String[] ids);
}
