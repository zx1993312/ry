package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品和规格关联对象 product_and_specification
 * 
 * @author Administrator
 * @date 2021-07-26
 */
public class ProductAndSpecification extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    /** 规格id */
    @Excel(name = "规格id")
    private Long specificationId;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setSpecificationId(Long specificationId) 
    {
        this.specificationId = specificationId;
    }

    public Long getSpecificationId() 
    {
        return specificationId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("specificationId", getSpecificationId())
            .toString();
    }
}
