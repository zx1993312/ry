package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OrderAndProduct;

/**
 * 订单商品中间Service接口
 * 
 * @author Administrator
 * @date 2021-07-15
 */
public interface IOrderAndProductService 
{
    /**
     * 查询订单商品中间
     * 
     * @param orderId 订单商品中间ID
     * @return 订单商品中间
     */
    public OrderAndProduct selectOrderAndProductById(Long orderId);

    /**
     * 查询订单商品中间列表
     * 
     * @param orderAndProduct 订单商品中间
     * @return 订单商品中间集合
     */
    public List<OrderAndProduct> selectOrderAndProductList(OrderAndProduct orderAndProduct);

    /**
     * 新增订单商品中间
     * 
     * @param orderAndProduct 订单商品中间
     * @return 结果
     */
    public int insertOrderAndProduct(OrderAndProduct orderAndProduct);

    /**
     * 修改订单商品中间
     * 
     * @param orderAndProduct 订单商品中间
     * @return 结果
     */
    public int updateOrderAndProduct(OrderAndProduct orderAndProduct);

    /**
     * 批量删除订单商品中间
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderAndProductByIds(String ids);

    /**
     * 删除订单商品中间信息
     * 
     * @param orderId 订单商品中间ID
     * @return 结果
     */
    public int deleteOrderAndProductById(Long orderId);
}
