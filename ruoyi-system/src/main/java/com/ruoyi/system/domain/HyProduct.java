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

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productName", getProductName())
            .append("briefIntroduction", getBriefIntroduction())
            .append("soldNumber", getSoldNumber())
            .append("stockNumber", getStockNumber())
            .append("state", getState())
            .append("snapUpDate", getSnapUpDate())
            .append("sendCodeDate", getSendCodeDate())
            .append(" appointmentDate", getAppointmentDate())
            .append(" appointmentMode", getAppointmentMode())
            .append("useDate", getUseDate())
            .append("shopId", getShopId())
            .toString();
    }
}
