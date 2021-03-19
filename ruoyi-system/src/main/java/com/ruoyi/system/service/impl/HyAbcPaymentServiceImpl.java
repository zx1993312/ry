package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyAbcPaymentMapper;
import com.ruoyi.system.domain.HyAbcPayment;
import com.ruoyi.system.service.IHyAbcPaymentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 农行支付Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-19
 */
@Service
public class HyAbcPaymentServiceImpl implements IHyAbcPaymentService 
{
    @Autowired
    private HyAbcPaymentMapper hyAbcPaymentMapper;

    /**
     * 查询农行支付
     * 
     * @param id 农行支付ID
     * @return 农行支付
     */
    @Override
    public HyAbcPayment selectHyAbcPaymentById(Long id)
    {
        return hyAbcPaymentMapper.selectHyAbcPaymentById(id);
    }

    /**
     * 查询农行支付列表
     * 
     * @param hyAbcPayment 农行支付
     * @return 农行支付
     */
    @Override
    public List<HyAbcPayment> selectHyAbcPaymentList(HyAbcPayment hyAbcPayment)
    {
        return hyAbcPaymentMapper.selectHyAbcPaymentList(hyAbcPayment);
    }

    /**
     * 新增农行支付
     * 
     * @param hyAbcPayment 农行支付
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyAbcPayment(HyAbcPayment hyAbcPayment)
    {
        return hyAbcPaymentMapper.insertHyAbcPayment(hyAbcPayment);
    }

    /**
     * 修改农行支付
     * 
     * @param hyAbcPayment 农行支付
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyAbcPayment(HyAbcPayment hyAbcPayment)
    {
        return hyAbcPaymentMapper.updateHyAbcPayment(hyAbcPayment);
    }

    /**
     * 删除农行支付对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAbcPaymentByIds(String ids)
    {
        return hyAbcPaymentMapper.deleteHyAbcPaymentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除农行支付信息
     * 
     * @param id 农行支付ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAbcPaymentById(Long id)
    {
        return hyAbcPaymentMapper.deleteHyAbcPaymentById(id);
    }
}
