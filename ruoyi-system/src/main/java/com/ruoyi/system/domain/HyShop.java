package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 店铺对象 hy_shop
 * 
 * @author Administrator
 * @date 2021-03-05
 */
public class HyShop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 店铺id */
    private Long id;

    /** 店铺名称 */
    @Excel(name = "店铺名称")
    private String shopName;

    /** 店铺地址 */
    @Excel(name = "店铺地址")
    private String shopAddress;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private Long contactNumber;

    /** 营业时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "营业时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date businessHours;

    /** 商家id */
    @Excel(name = "商家id")
    private Long businessId;
    
    /**商家表*/
    @Excel(name="商家表")
    private HyBusiness hyBusiness;
    

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }
    public void setShopAddress(String shopAddress) 
    {
        this.shopAddress = shopAddress;
    }

    public String getShopAddress() 
    {
        return shopAddress;
    }
    public void setContactNumber(Long contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public Long getContactNumber() 
    {
        return contactNumber;
    }
    public void setBusinessHours(Date businessHours) 
    {
        this.businessHours = businessHours;
    }

    public Date getBusinessHours() 
    {
        return businessHours;
    }
    public void setBusinessId(Long businessId) 
    {
        this.businessId = businessId;
    }

    public Long getBusinessId() 
    {
        return businessId;
    }

    public HyBusiness getHyBusiness() {
		return hyBusiness;
	}

	public void setHyBusiness(HyBusiness hyBusiness) {
		this.hyBusiness = hyBusiness;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopName", getShopName())
            .append("shopAddress", getShopAddress())
            .append("contactNumber", getContactNumber())
            .append("businessHours", getBusinessHours())
            .append("businessId", getBusinessId())
            .toString();
    }
}
