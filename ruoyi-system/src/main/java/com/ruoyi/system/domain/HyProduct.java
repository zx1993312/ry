package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品对象 hy_product
 * 
 * @author Administrator
 * @date 2021-03-06
 */
/**
 * @author Administrator
 *
 */
public class HyProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    
    /** 产品id */
    private Long id;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 简介 */
    @Excel(name = "简介")
    private String briefIntroduction;

    /** 已售数量 */
    @Excel(name = "已售数量")
    private Long soldNumber;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long stockNumber;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;

    /** 抢购日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "抢购日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date snapUpDate;

    /** 发码日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发码日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendCodeDate;

    /** 预约日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预约日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date  appointmentDate;

    /** 预约方式 */
    @Excel(name = "预约方式")
    private String  appointmentMode;

    /** 使用日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "使用日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date useDate;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Long shopId;
    /**店铺表*/
    @Excel(name="店铺表")
    private HyShop hyShop;
    /**图片表*/
    @Excel(name="图片表")
    private HyPicture hyPicture;
    /**详细信息表（海报表）*/
    @Excel(name="详细信息表（海报表）")
    private HyPoster hyPoster;
    /**限购数量*/
    @Excel(name="限购数量")
    private Integer limitedQuantity;
    /**产品排序权重*/
    @Excel(name="产品排序权重")
    private Integer productOrderBy;
    /**客服电话*/
    @Excel(name="客服电话")
    private String customerServiceTel;
    /**分享标题*/
    @Excel(name="分享标题")
    private String shareTitle;
    /**销售状态*/
    @Excel(name="销售状态")
    private String salState;
    
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }
    public void setSnapUpDate(Date snapUpDate) 
    {
        this.snapUpDate = snapUpDate;
    }

    public Date getSnapUpDate() 
    {
        return snapUpDate;
    }
    public void setSendCodeDate(Date sendCodeDate) 
    {
        this.sendCodeDate = sendCodeDate;
    }

    public Date getSendCodeDate() 
    {
        return sendCodeDate;
    }
    public void setAppointmentDate(Date  appointmentDate) 
    {
        this. appointmentDate =  appointmentDate;
    }

    public Date getAppointmentDate() 
    {
        return  appointmentDate;
    }
    public void setAppointmentMode(String  appointmentMode) 
    {
        this. appointmentMode =  appointmentMode;
    }

    public String getAppointmentMode() 
    {
        return  appointmentMode;
    }
    public void setUseDate(Date useDate) 
    {
        this.useDate = useDate;
    }

    public Date getUseDate() 
    {
        return useDate;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }

    public HyShop getHyShop() {
		return hyShop;
	}

	public void setHyShop(HyShop hyShop) {
		this.hyShop = hyShop;
	}

	public HyPicture getHyPicture() {
		return hyPicture;
	}

	public void setHyPicture(HyPicture hyPicture) {
		this.hyPicture = hyPicture;
	}

	public HyPoster getHyPoster() {
		return hyPoster;
	}

	public void setHyPoster(HyPoster hyPoster) {
		this.hyPoster = hyPoster;
	}

	public Integer getLimitedQuantity() {
		return limitedQuantity;
	}

	public void setLimitedQuantity(Integer limitedQuantity) {
		this.limitedQuantity = limitedQuantity;
	}

	public Integer getProductOrderBy() {
		return productOrderBy;
	}

	public void setProductOrderBy(Integer productOrderBy) {
		this.productOrderBy = productOrderBy;
	}

	public String getCustomerServiceTel() {
		return customerServiceTel;
	}

	public void setCustomerServiceTel(String customerServiceTel) {
		this.customerServiceTel = customerServiceTel;
	}
	
	public String getShareTitle() {
		return shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public String getSalState() {
		return salState;
	}

	public void setSalState(String salState) {
		this.salState = salState;
	}

	@Override
	public String toString() {
		return "HyProduct [id=" + id + ", productName=" + productName + ", briefIntroduction=" + briefIntroduction
				+ ", soldNumber=" + soldNumber + ", stockNumber=" + stockNumber + ", state=" + state + ", snapUpDate="
				+ snapUpDate + ", sendCodeDate=" + sendCodeDate + ", appointmentDate=" + appointmentDate
				+ ", appointmentMode=" + appointmentMode + ", useDate=" + useDate + ", shopId=" + shopId + ", hyShop="
				+ hyShop + ", hyPicture=" + hyPicture + ", hyPoster=" + hyPoster + ", limitedQuantity="
				+ limitedQuantity + ", productOrderBy=" + productOrderBy + ", customerServiceTel=" + customerServiceTel
				+ ", shareTitle=" + shareTitle + ", getId()=" + getId() + ", getProductName()=" + getProductName()
				+ ", getBriefIntroduction()=" + getBriefIntroduction() + ", getSoldNumber()=" + getSoldNumber()
				+ ", getStockNumber()=" + getStockNumber() + ", getState()=" + getState() + ", getSnapUpDate()="
				+ getSnapUpDate() + ", getSendCodeDate()=" + getSendCodeDate() + ", getAppointmentDate()="
				+ getAppointmentDate() + ", getAppointmentMode()=" + getAppointmentMode() + ", getUseDate()="
				+ getUseDate() + ", getShopId()=" + getShopId() + ", getHyShop()=" + getHyShop() + ", getHyPicture()="
				+ getHyPicture() + ", getHyPoster()=" + getHyPoster() + ", getLimitedQuantity()=" + getLimitedQuantity()
				+ ", getProductOrderBy()=" + getProductOrderBy() + ", getCustomerServiceTel()="
				+ getCustomerServiceTel() + ", getShareTitle()=" + getShareTitle() + ", getSearchValue()="
				+ getSearchValue() + ", getCreateBy()=" + getCreateBy() + ", getCreateTime()=" + getCreateTime()
				+ ", getUpdateBy()=" + getUpdateBy() + ", getUpdateTime()=" + getUpdateTime() + ", getRemark()="
				+ getRemark() + ", getParams()=" + getParams() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


}
