package com.ruoyi.system.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.HyOrder;

/**
 * 订单Service接口
 * 
 * @author Administrator
 * @date 2021-07-15
 */
public interface IHyOrderService 
{
    /**
     * 查询订单
     * 
     * @param id 订单ID
     * @return 订单
     */
    public HyOrder selectHyOrderById(Long id);

    /**
     * 查询订单列表
     * 
     * @param hyOrder 订单
     * @return 订单集合
     */
    public List<HyOrder> selectHyOrderList(HyOrder hyOrder);
    
    /**
     * 查询订单待付款列表
     * 
     * @param hyOrder 订单
     * @return 订单集合
     */
    public List<HyOrder> selectHyOrderListByObligation(HyOrder hyOrder);
    
    /**
     * 查询订单待发货列表
     * 
     * @param hyOrder 订单
     * @return 订单集合
     */
    public List<HyOrder> selectHyOrderListBySend(HyOrder hyOrder);
    
    /**
     * 查询订单待收货列表
     * 
     * @param hyOrder 订单
     * @return 订单集合
     */
    public List<HyOrder> selectHyOrderListByCollect(HyOrder hyOrder);
    
    /**
     * 查询订单已完成列表
     * 
     * @param hyOrder 订单
     * @return 订单集合
     */
    public List<HyOrder> selectHyOrderListByFinished(HyOrder hyOrder);
    
    /**
     * 查询订单已完成列表
     * 
     * @param hyOrder 订单
     * @return 订单集合
     */
    public List<HyOrder> selectHyOrderListByRefunded(HyOrder hyOrder);

    /**
     * 新增订单
     * 
     * @param hyOrder 订单
     * @return 结果
     */
    public int insertHyOrder(HyOrder hyOrder);

    /**
     * 修改订单
     * 
     * @param hyOrder 订单
     * @return 结果
     */
    public int updateHyOrder(HyOrder hyOrder);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyOrderByIds(String ids);

    /**
     * 删除订单信息
     * 
     * @param id 订单ID
     * @return 结果
     */
    public int deleteHyOrderById(Long id);
	/**
	 * 导出PDF
	 * @param response
	 * @throws Exception 
	 */
	public int downloadPDF(HttpServletResponse response) throws Exception;


}
