package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.OrderAndProductMapper;
import com.ruoyi.system.domain.OrderAndProduct;
import com.ruoyi.system.service.IOrderAndProductService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单商品中间Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-15
 */
@Service
public class OrderAndProductServiceImpl implements IOrderAndProductService 
{
    @Autowired
    private OrderAndProductMapper orderAndProductMapper;

    /**
     * 查询订单商品中间
     * 
     * @param orderId 订单商品中间ID
     * @return 订单商品中间
     */
    @Override
    public OrderAndProduct selectOrderAndProductById(Long orderId)
    {
        return orderAndProductMapper.selectOrderAndProductById(orderId);
    }

    /**
     * 查询订单商品中间列表
     * 
     * @param orderAndProduct 订单商品中间
     * @return 订单商品中间
     */
    @Override
    public List<OrderAndProduct> selectOrderAndProductList(OrderAndProduct orderAndProduct)
    {
        return orderAndProductMapper.selectOrderAndProductList(orderAndProduct);
    }

    /**
     * 新增订单商品中间
     * 
     * @param orderAndProduct 订单商品中间
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertOrderAndProduct(OrderAndProduct orderAndProduct)
    {
        return orderAndProductMapper.insertOrderAndProduct(orderAndProduct);
    }

    /**
     * 修改订单商品中间
     * 
     * @param orderAndProduct 订单商品中间
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateOrderAndProduct(OrderAndProduct orderAndProduct)
    {
        return orderAndProductMapper.updateOrderAndProduct(orderAndProduct);
    }

    /**
     * 删除订单商品中间对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteOrderAndProductByIds(String ids)
    {
        return orderAndProductMapper.deleteOrderAndProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单商品中间信息
     * 
     * @param orderId 订单商品中间ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteOrderAndProductById(Long orderId)
    {
        return orderAndProductMapper.deleteOrderAndProductById(orderId);
    }
}
