package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单商品中间对象 order_and_product
 * 
 * @author Administrator
 * @date 2021-07-15
 */
public class OrderAndProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    @Excel(name = "订单id")
    private Long orderId;

    /** 产品id */
    @Excel(name = "产品id")
    private Long productId;

    /** 数量 */
    @Excel(name = "数量")
    private int number;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setNumber(int number) 
    {
        this.number = number;
    }

    public int getNumber() 
    {
        return number;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("productId", getProductId())
            .append("number", getNumber())
            .toString();
    }
}