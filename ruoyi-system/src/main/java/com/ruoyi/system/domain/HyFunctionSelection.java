package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 功能选择对象 hy_function_selection
 * 
 * @author Administrator
 * @date 2021-03-16
 */
public class HyFunctionSelection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 功能选择id */
    private Long id;

    /** 商品状态 */
    @Excel(name = "商品状态")
    private String productState;

    /** 首页推荐 */
    @Excel(name = "首页推荐")
    private String homePageRecommendation;

    /** 地图展示 */
    @Excel(name = "地图展示")
    private String showMap;

    /** 地图导航单个商品 */
    @Excel(name = "地图导航单个商品")
    private String singleCommodity;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String productType;

    /** 是否开启日期选择 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "是否开启日期选择", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 是否开启邮寄 */
    @Excel(name = "是否开启邮寄")
    private String startMail;

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
    public void setProductState(String productState) 
    {
        this.productState = productState;
    }

    public String getProductState() 
    {
        return productState;
    }
    public void setHomePageRecommendation(String homePageRecommendation) 
    {
        this.homePageRecommendation = homePageRecommendation;
    }

    public String getHomePageRecommendation() 
    {
        return homePageRecommendation;
    }
    public void setShowMap(String showMap) 
    {
        this.showMap = showMap;
    }

    public String getShowMap() 
    {
        return showMap;
    }
    public void setSingleCommodity(String singleCommodity) 
    {
        this.singleCommodity = singleCommodity;
    }

    public String getSingleCommodity() 
    {
        return singleCommodity;
    }
    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setStartMail(String startMail) 
    {
        this.startMail = startMail;
    }

    public String getStartMail() 
    {
        return startMail;
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
            .append("productState", getProductState())
            .append("homePageRecommendation", getHomePageRecommendation())
            .append("showMap", getShowMap())
            .append("singleCommodity", getSingleCommodity())
            .append("productType", getProductType())
            .append("startDate", getStartDate())
            .append("startMail", getStartMail())
            .append("productId", getProductId())
            .toString();
    }
}
