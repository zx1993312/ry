package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyPaymentInterface;

/**
 * 支付接口设置Service接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface IHyPaymentInterfaceService 
{
    /**
     * 查询支付接口设置
     * 
     * @param id 支付接口设置ID
     * @return 支付接口设置
     */
    public HyPaymentInterface selectHyPaymentInterfaceById(Long id);

    /**
     * 查询支付接口设置列表
     * 
     * @param hyPaymentInterface 支付接口设置
     * @return 支付接口设置集合
     */
    public List<HyPaymentInterface> selectHyPaymentInterfaceList(HyPaymentInterface hyPaymentInterface);

    /**
     * 新增支付接口设置
     * 
     * @param hyPaymentInterface 支付接口设置
     * @return 结果
     */
    public int insertHyPaymentInterface(HyPaymentInterface hyPaymentInterface);

    /**
     * 修改支付接口设置
     * 
     * @param hyPaymentInterface 支付接口设置
     * @return 结果
     */
    public int updateHyPaymentInterface(HyPaymentInterface hyPaymentInterface);

    /**
     * 批量删除支付接口设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyPaymentInterfaceByIds(String ids);

    /**
     * 删除支付接口设置信息
     * 
     * @param id 支付接口设置ID
     * @return 结果
     */
    public int deleteHyPaymentInterfaceById(Long id);
}
