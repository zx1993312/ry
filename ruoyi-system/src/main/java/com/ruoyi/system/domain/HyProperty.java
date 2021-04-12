package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物业对象 hy_property
 * 
 * @author Administrator
 * @date 2021-03-17
 */
public class HyProperty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物业id */
    private Long id;

    /** 物业名称 */
    @Excel(name = "物业名称")
    private String propertyName;

    /** 物业电话 */
    @Excel(name = "物业电话")
    private Long propertyPhone;

    /** 物业介绍 */
    @Excel(name = "物业介绍")
    private String propertyIntroduce;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationTime;

    /** 物业图片地址 */
    @Excel(name = "物业图片地址")
    private String propertyPictureAddress;
    
    /** 社区id */
    @Excel(name = "社区id")
    private Long communityId;
    
    /** 社区表 */
    @Excel(name = "社区表")
    private HyCommunity hyCommunity;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPropertyName(String propertyName) 
    {
        this.propertyName = propertyName;
    }

    public String getPropertyName() 
    {
        return propertyName;
    }
    public void setPropertyPhone(Long propertyPhone) 
    {
        this.propertyPhone = propertyPhone;
    }

    public Long getPropertyPhone() 
    {
        return propertyPhone;
    }
    public void setPropertyIntroduce(String propertyIntroduce) 
    {
        this.propertyIntroduce = propertyIntroduce;
    }

    public String getPropertyIntroduce() 
    {
        return propertyIntroduce;
    }
    public void setCreationTime(Date creationTime) 
    {
        this.creationTime = creationTime;
    }

    public Date getCreationTime() 
    {
        return creationTime;
    }
    public void setPropertyPictureAddress(String propertyPictureAddress) 
    {
        this.propertyPictureAddress = propertyPictureAddress;
    }

    public String getPropertyPictureAddress() 
    {
        return propertyPictureAddress;
    }

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	public HyCommunity getHyCommunity() {
		return hyCommunity;
	}

	public void setHyCommunity(HyCommunity hyCommunity) {
		this.hyCommunity = hyCommunity;
	}

	@Override
	public String toString() {
		return "HyProperty [id=" + id + ", propertyName=" + propertyName + ", propertyPhone=" + propertyPhone
				+ ", propertyIntroduce=" + propertyIntroduce + ", creationTime=" + creationTime
				+ ", propertyPictureAddress=" + propertyPictureAddress + ", communityId=" + communityId
				+ ", hyCommunity=" + hyCommunity + "]";
	}

	
}
