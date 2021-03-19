package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyAlipay;

/**
 * 支付宝Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface HyAlipayMapper 
{
    /**
     * 查询支付宝
     * 
     * @param id 支付宝ID
     * @return 支付宝
     */
    public HyAlipay selectHyAlipayById(Long id);

    /**
     * 查询支付宝列表
     * 
     * @param hyAlipay 支付宝
     * @return 支付宝集合
     */
    public List<HyAlipay> selectHyAlipayList(HyAlipay hyAlipay);

    /**
     * 新增支付宝
     * 
     * @param hyAlipay 支付宝
     * @return 结果
     */
    public int insertHyAlipay(HyAlipay hyAlipay);

    /**
     * 修改支付宝
     * 
     * @param hyAlipay 支付宝
     * @return 结果
     */
    public int updateHyAlipay(HyAlipay hyAlipay);

    /**
     * 删除支付宝
     * 
     * @param id 支付宝ID
     * @return 结果
     */
    public int deleteHyAlipayById(Long id);

    /**
     * 批量删除支付宝
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyAlipayByIds(String[] ids);
}
