package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyEverbrightBankPaymentMapper;
import com.ruoyi.system.domain.HyEverbrightBankPayment;
import com.ruoyi.system.service.IHyEverbrightBankPaymentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 光大银行支付Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-19
 */
@Service
public class HyEverbrightBankPaymentServiceImpl implements IHyEverbrightBankPaymentService 
{
    @Autowired
    private HyEverbrightBankPaymentMapper hyEverbrightBankPaymentMapper;

    /**
     * 查询光大银行支付
     * 
     * @param id 光大银行支付ID
     * @return 光大银行支付
     */
    @Override
    public HyEverbrightBankPayment selectHyEverbrightBankPaymentById(Long id)
    {
        return hyEverbrightBankPaymentMapper.selectHyEverbrightBankPaymentById(id);
    }

    /**
     * 查询光大银行支付列表
     * 
     * @param hyEverbrightBankPayment 光大银行支付
     * @return 光大银行支付
     */
    @Override
    public List<HyEverbrightBankPayment> selectHyEverbrightBankPaymentList(HyEverbrightBankPayment hyEverbrightBankPayment)
    {
        return hyEverbrightBankPaymentMapper.selectHyEverbrightBankPaymentList(hyEverbrightBankPayment);
    }

    /**
     * 新增光大银行支付
     * 
     * @param hyEverbrightBankPayment 光大银行支付
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyEverbrightBankPayment(HyEverbrightBankPayment hyEverbrightBankPayment)
    {
        return hyEverbrightBankPaymentMapper.insertHyEverbrightBankPayment(hyEverbrightBankPayment);
    }

    /**
     * 修改光大银行支付
     * 
     * @param hyEverbrightBankPayment 光大银行支付
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyEverbrightBankPayment(HyEverbrightBankPayment hyEverbrightBankPayment)
    {
        return hyEverbrightBankPaymentMapper.updateHyEverbrightBankPayment(hyEverbrightBankPayment);
    }

    /**
     * 删除光大银行支付对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyEverbrightBankPaymentByIds(String ids)
    {
        return hyEverbrightBankPaymentMapper.deleteHyEverbrightBankPaymentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除光大银行支付信息
     * 
     * @param id 光大银行支付ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyEverbrightBankPaymentById(Long id)
    {
        return hyEverbrightBankPaymentMapper.deleteHyEverbrightBankPaymentById(id);
    }
}
