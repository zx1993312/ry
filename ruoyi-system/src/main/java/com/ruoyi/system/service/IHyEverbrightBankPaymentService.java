package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyEverbrightBankPayment;

/**
 * 光大银行支付Service接口
 * 
 * @author Administrator
 * @date 2021-03-19
 */
public interface IHyEverbrightBankPaymentService 
{
    /**
     * 查询光大银行支付
     * 
     * @param id 光大银行支付ID
     * @return 光大银行支付
     */
    public HyEverbrightBankPayment selectHyEverbrightBankPaymentById(Long id);

    /**
     * 查询光大银行支付列表
     * 
     * @param hyEverbrightBankPayment 光大银行支付
     * @return 光大银行支付集合
     */
    public List<HyEverbrightBankPayment> selectHyEverbrightBankPaymentList(HyEverbrightBankPayment hyEverbrightBankPayment);

    /**
     * 新增光大银行支付
     * 
     * @param hyEverbrightBankPayment 光大银行支付
     * @return 结果
     */
    public int insertHyEverbrightBankPayment(HyEverbrightBankPayment hyEverbrightBankPayment);

    /**
     * 修改光大银行支付
     * 
     * @param hyEverbrightBankPayment 光大银行支付
     * @return 结果
     */
    public int updateHyEverbrightBankPayment(HyEverbrightBankPayment hyEverbrightBankPayment);

    /**
     * 批量删除光大银行支付
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyEverbrightBankPaymentByIds(String ids);

    /**
     * 删除光大银行支付信息
     * 
     * @param id 光大银行支付ID
     * @return 结果
     */
    public int deleteHyEverbrightBankPaymentById(Long id);
}
