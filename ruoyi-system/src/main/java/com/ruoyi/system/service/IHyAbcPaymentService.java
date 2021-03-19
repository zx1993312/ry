package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyAbcPayment;

/**
 * 农行支付Service接口
 * 
 * @author Administrator
 * @date 2021-03-19
 */
public interface IHyAbcPaymentService 
{
    /**
     * 查询农行支付
     * 
     * @param id 农行支付ID
     * @return 农行支付
     */
    public HyAbcPayment selectHyAbcPaymentById(Long id);

    /**
     * 查询农行支付列表
     * 
     * @param hyAbcPayment 农行支付
     * @return 农行支付集合
     */
    public List<HyAbcPayment> selectHyAbcPaymentList(HyAbcPayment hyAbcPayment);

    /**
     * 新增农行支付
     * 
     * @param hyAbcPayment 农行支付
     * @return 结果
     */
    public int insertHyAbcPayment(HyAbcPayment hyAbcPayment);

    /**
     * 修改农行支付
     * 
     * @param hyAbcPayment 农行支付
     * @return 结果
     */
    public int updateHyAbcPayment(HyAbcPayment hyAbcPayment);

    /**
     * 批量删除农行支付
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyAbcPaymentByIds(String ids);

    /**
     * 删除农行支付信息
     * 
     * @param id 农行支付ID
     * @return 结果
     */
    public int deleteHyAbcPaymentById(Long id);
}
