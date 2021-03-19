package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyAlipayMapper;
import com.ruoyi.system.domain.HyAlipay;
import com.ruoyi.system.service.IHyAlipayService;
import com.ruoyi.common.core.text.Convert;

/**
 * 支付宝Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyAlipayServiceImpl implements IHyAlipayService 
{
    @Autowired
    private HyAlipayMapper hyAlipayMapper;

    /**
     * 查询支付宝
     * 
     * @param id 支付宝ID
     * @return 支付宝
     */
    @Override
    public HyAlipay selectHyAlipayById(Long id)
    {
        return hyAlipayMapper.selectHyAlipayById(id);
    }

    /**
     * 查询支付宝列表
     * 
     * @param hyAlipay 支付宝
     * @return 支付宝
     */
    @Override
    public List<HyAlipay> selectHyAlipayList(HyAlipay hyAlipay)
    {
        return hyAlipayMapper.selectHyAlipayList(hyAlipay);
    }

    /**
     * 新增支付宝
     * 
     * @param hyAlipay 支付宝
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyAlipay(HyAlipay hyAlipay)
    {
        return hyAlipayMapper.insertHyAlipay(hyAlipay);
    }

    /**
     * 修改支付宝
     * 
     * @param hyAlipay 支付宝
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyAlipay(HyAlipay hyAlipay)
    {
        return hyAlipayMapper.updateHyAlipay(hyAlipay);
    }

    /**
     * 删除支付宝对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAlipayByIds(String ids)
    {
        return hyAlipayMapper.deleteHyAlipayByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除支付宝信息
     * 
     * @param id 支付宝ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyAlipayById(Long id)
    {
        return hyAlipayMapper.deleteHyAlipayById(id);
    }
}
