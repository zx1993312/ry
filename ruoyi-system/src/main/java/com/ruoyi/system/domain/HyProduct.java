package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 hy_product
 * 
 * @author Administrator
 * @date 2021-07-16
 */
public class HyProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long id;

    /** 商品编号 */
    @Excel(name = "商品编号")
    private String productNumber;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 简介 */
    @Excel(name = "简介")
    private String briefIntroduction;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String productType;
    
    /** 原价 */
    @Excel(name = "原价")
    private BigDecimal originalPrice;

    /** 现价 */
    @Excel(name = "现价")
    private BigDecimal currentPrice;

    /** 已售数量 */
    @Excel(name = "已售数量")
    private Long soldNumber;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long stockNumber;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** 商品排序权重 */
    @Excel(name = "商品排序权重")
    private Long productOrderBy;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Long shopId;
    
    /**店铺表*/
    private HyShop hyShop;
    
    /** 标签id */
    @Excel(name = "标签id")
    private Long lableId;
    
    /**标签表*/
    private HyLable hyLable;
    
    /**图片表*/
    private HyPicture hyPicture;
    
    /**商品详情的图片表*/
    private HyDeatilPicture hyDeatilPicture;
    
    /**商品缩略图地址*/
    private String fileName;
    
    /**商品多图地址*/
    private String deleteFiles;
    
    /**商品id组*/
    private String ids;
    
    /**数量组*/
    private String numbers;
    
    /** 商品规格id组 */
    private String specificationIds;
    
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductNumber(String productNumber) 
    {
        this.productNumber = productNumber;
    }

    public String getProductNumber() 
    {
        return productNumber;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setBriefIntroduction(String briefIntroduction) 
    {
        this.briefIntroduction = briefIntroduction;
    }

    public String getBriefIntroduction() 
    {
        return briefIntroduction;
    }
    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
    }
    public void setOriginalPrice(BigDecimal originalPrice) 
    {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getOriginalPrice() 
    {
        return originalPrice;
    }
    public void setCurrentPrice(BigDecimal currentPrice) 
    {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getCurrentPrice() 
    {
        return currentPrice;
    }
    public void setSoldNumber(Long soldNumber) 
    {
        this.soldNumber = soldNumber;
    }

    public Long getSoldNumber() 
    {
        return soldNumber;
    }
    public void setStockNumber(Long stockNumber) 
    {
        this.stockNumber = stockNumber;
    }

    public Long getStockNumber() 
    {
        return stockNumber;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setProductOrderBy(Long productOrderBy) 
    {
        this.productOrderBy = productOrderBy;
    }

    public Long getProductOrderBy() 
    {
        return productOrderBy;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setLableId(Long lableId) 
    {
        this.lableId = lableId;
    }

    public Long getLableId() 
    {
        return lableId;
    }

    public HyShop getHyShop() {
		return hyShop;
	}

	public void setHyShop(HyShop hyShop) {
		this.hyShop = hyShop;
	}

	public HyLable getHyLable() {
		return hyLable;
	}

	public void setHyLable(HyLable hyLable) {
		this.hyLable = hyLable;
	}

	public HyPicture getHyPicture() {
		return hyPicture;
	}

	public void setHyPicture(HyPicture hyPicture) {
		this.hyPicture = hyPicture;
	}

	public HyDeatilPicture getHyDeatilPicture() {
		return hyDeatilPicture;
	}

	public void setHyDeatilPicture(HyDeatilPicture hyDeatilPicture) {
		this.hyDeatilPicture = hyDeatilPicture;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDeleteFiles() {
		return deleteFiles;
	}

	public void setDeleteFiles(String deleteFiles) {
		this.deleteFiles = deleteFiles;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public String getSpecificationIds() {
		return specificationIds;
	}

	public void setSpecificationIds(String specificationIds) {
		this.specificationIds = specificationIds;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productNumber", getProductNumber())
            .append("productName", getProductName())
            .append("briefIntroduction", getBriefIntroduction())
            .append("productType", getProductType())
            .append("originalPrice", getOriginalPrice())
            .append("currentPrice", getCurrentPrice())
            .append("soldNumber", getSoldNumber())
            .append("stockNumber", getStockNumber())
            .append("state", getState())
            .append("productOrderBy", getProductOrderBy())
            .append("shopId", getShopId())
            .append("lableId", getLableId())
            .append("hyShop", getHyShop())
            .append("hyLable", getHyLable())
            .append("hyPicture", getHyPicture())
            .append("fileName", getFileName())
            .append("deleteFiles", getDeleteFiles())
            .append("ids", getIds())
            .append("numbers", getNumbers())
            .append("specificationIds", getSpecificationIds())
            .toString();
    }
}