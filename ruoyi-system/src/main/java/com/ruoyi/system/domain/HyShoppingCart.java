package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 购物车对象 hy_shopping_cart
 * 
 * @author Administrator
 * @date 2021-07-16
 */
public class HyShoppingCart extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 购物车id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long ownerId;

    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOwnerId(Long ownerId) 
    {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() 
    {
        return ownerId;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ownerId", getOwnerId())
            .append("productId", getProductId())
            .toString();
    }
}
