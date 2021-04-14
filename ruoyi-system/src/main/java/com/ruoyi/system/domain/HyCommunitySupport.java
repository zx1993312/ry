package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社区配套对象 hy_community_support
 * 
 * @author Administrator
 * @date 2021-03-12
 */
public class HyCommunitySupport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 社区配套id */
    private Long id;

    /** 配套种类
 */
    @Excel(name = "配套种类")
    private Long matchingTypes;

    /** 配套类型 */
    @Excel(name = "配套类型")
    private Long matchingType;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 配套名称 */
    @Excel(name = "配套名称")
    private String matchingName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private Long contactNumber;

    /** 所在地址 */
    @Excel(name = "所在地址")
    private String address;

    /** 备注 */
    @Excel(name = "备注")
    private String abreak;

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
    public void setMatchingTypes(Long matchingTypes) 
    {
        this.matchingTypes = matchingTypes;
    }

    public Long getMatchingTypes() 
    {
        return matchingTypes;
    }
    public void setMatchingType(Long matchingType) 
    {
        this.matchingType = matchingType;
    }

    public Long getMatchingType() 
    {
        return matchingType;
    }
    public void setContacts(String contacts) 
    {
        this.contacts = contacts;
    }

    public String getContacts() 
    {
        return contacts;
    }
    public void setMatchingName(String matchingName) 
    {
        this.matchingName = matchingName;
    }

    public String getMatchingName() 
    {
        return matchingName;
    }
    public void setContactNumber(Long contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public Long getContactNumber() 
    {
        return contactNumber;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setAbreak(String abreak) 
    {
        this.abreak = abreak;
    }

    public String getAbreak() 
    {
        return abreak;
    }
    public void setCommunityId(Long communityId) 
    {
        this.communityId = communityId;
    }

    public Long getCommunityId() 
    {
        return communityId;
    }

    public HyCommunity getHyCommunity() {
		return hyCommunity;
	}

	public void setHyCommunity(HyCommunity hyCommunity) {
		this.hyCommunity = hyCommunity;
	}

	@Override
	public String toString() {
		return "HyCommunitySupport [id=" + id + ", matchingTypes=" + matchingTypes + ", matchingType=" + matchingType
				+ ", contacts=" + contacts + ", matchingName=" + matchingName + ", contactNumber=" + contactNumber
				+ ", address=" + address + ", abreak=" + abreak + ", communityId=" + communityId + ", hyCommunity="
				+ hyCommunity + "]";
	}

	
}
