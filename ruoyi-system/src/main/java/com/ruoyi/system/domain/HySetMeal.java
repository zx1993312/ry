package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 套餐对象 hy_set_meal
 * 
 * @author Administrator
 * @date 2021-03-06
 */
public class HySetMeal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 套餐id */
    private Long id;

    /** 套餐内容 */
    @Excel(name = "套餐内容")
    private String setMealContent;

    /** 零售价 */
    @Excel(name = "零售价")
    private BigDecimal retailPrice;

    /** 门市价 */
    @Excel(name = "门市价")
    private BigDecimal marketPrice;

    /** 套餐名称 */
    @Excel(name = "套餐名称")
    private String setMealName;

    /** 产品id */
    @Excel(name = "产品id")
    private Long productId;
    /**产品表*/
    @Excel(name="产品表")
    private HyProduct hyProduct;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSetMealContent(String setMealContent) 
    {
        this.setMealContent = setMealContent;
    }

    public String getSetMealContent() 
    {
        return setMealContent;
    }
    public void setRetailPrice(BigDecimal retailPrice) 
    {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getRetailPrice() 
    {
        return retailPrice;
    }
    public void setMarketPrice(BigDecimal marketPrice) 
    {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getMarketPrice() 
    {
        return marketPrice;
    }
    public void setSetMealName(String setMealName) 
    {
        this.setMealName = setMealName;
    }

    public String getSetMealName() 
    {
        return setMealName;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public HyProduct getHyProduct() {
		return hyProduct;
	}

	public void setHyProduct(HyProduct hyProduct) {
		this.hyProduct = hyProduct;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("setMealContent", getSetMealContent())
            .append("retailPrice", getRetailPrice())
            .append("marketPrice", getMarketPrice())
            .append("setMealName", getSetMealName())
            .append("productId", getProductId())
            .toString();
    }
}
