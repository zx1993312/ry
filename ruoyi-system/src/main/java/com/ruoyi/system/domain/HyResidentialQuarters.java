package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小区对象 hy_residential_quarters
 * 
 * @author Administrator
 * @date 2021-03-17
 */
/**
 * @author Administrator
 *
 */
public class HyResidentialQuarters extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  小区id */
    private Long id;

    /** 小区地址 */
    @Excel(name = "小区地址")
    private String communityAddress;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String communityName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private Long contactNumber;

    /** 联系QQ */
    @Excel(name = "联系QQ")
    private String contactQq;

    /** 省/直辖市 */
    @Excel(name = "省/直辖市")
    private String city;

    /** 市/市辖区 */
    @Excel(name = "市/市辖区")
    private String area;

    /** 区/县 */
    @Excel(name = "区/县")
    private String county;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 客户链接 */
    @Excel(name = "客户链接")
    private String customerLink;

    /** 外部链接 */
    @Excel(name = "外部链接")
    private String externalLinks;
    
    /**物业id*/
    @Excel(name="物业id")
    private Long propertyId;
    /**物业表*/
    private HyProperty hyProperty;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCommunityAddress(String communityAddress) 
    {
        this.communityAddress = communityAddress;
    }

    public String getCommunityAddress() 
    {
        return communityAddress;
    }
    public void setCommunityName(String communityName) 
    {
        this.communityName = communityName;
    }

    public String getCommunityName() 
    {
        return communityName;
    }
    public void setContacts(String contacts) 
    {
        this.contacts = contacts;
    }

    public String getContacts() 
    {
        return contacts;
    }
    public void setContactNumber(Long contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public Long getContactNumber() 
    {
        return contactNumber;
    }
    public void setContactQq(String contactQq) 
    {
        this.contactQq = contactQq;
    }

    public String getContactQq() 
    {
        return contactQq;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setCounty(String county) 
    {
        this.county = county;
    }

    public String getCounty() 
    {
        return county;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setLongitude(String longitude) 
    {
        this.longitude = longitude;
    }

    public String getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(String latitude) 
    {
        this.latitude = latitude;
    }

    public String getLatitude() 
    {
        return latitude;
    }
    public void setCustomerLink(String customerLink) 
    {
        this.customerLink = customerLink;
    }

    public String getCustomerLink() 
    {
        return customerLink;
    }
    public void setExternalLinks(String externalLinks) 
    {
        this.externalLinks = externalLinks;
    }

    public String getExternalLinks() 
    {
        return externalLinks;
    }

    public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public HyProperty getHyProperty() {
		return hyProperty;
	}

	public void setHyProperty(HyProperty hyProperty) {
		this.hyProperty = hyProperty;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("communityAddress", getCommunityAddress())
            .append("communityName", getCommunityName())
            .append("contacts", getContacts())
            .append("contactNumber", getContactNumber())
            .append("contactQq", getContactQq())
            .append("city", getCity())
            .append("area", getArea())
            .append("county", getCounty())
            .append("address", getAddress())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("customerLink", getCustomerLink())
            .append("externalLinks", getExternalLinks())
            .append("propertyId", getPropertyId())
            .toString();
    }
}
