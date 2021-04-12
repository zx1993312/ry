package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社区建议对象 hy_community_suggest
 * 
 * @author Administrator
 * @date 2021-04-12
 */
public class HyCommunitySuggest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 社区建议id */
    private Long id;

    /** 建议类别 */
    @Excel(name = "建议类别")
    private String suggestType;

    /** 建议内容 */
    @Excel(name = "建议内容")
    private String informationContent;

    /** 建议人姓名 */
    @Excel(name = "建议人姓名")
    private String suggestName;

    /** 建议日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "建议日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date suggestDate;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contactInformation;

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
    public void setSuggestType(String suggestType) 
    {
        this.suggestType = suggestType;
    }

    public String getSuggestType() 
    {
        return suggestType;
    }
    public void setInformationContent(String informationContent) 
    {
        this.informationContent = informationContent;
    }

    public String getInformationContent() 
    {
        return informationContent;
    }
    public void setSuggestName(String suggestName) 
    {
        this.suggestName = suggestName;
    }

    public String getSuggestName() 
    {
        return suggestName;
    }
    public void setSuggestDate(Date suggestDate) 
    {
        this.suggestDate = suggestDate;
    }

    public Date getSuggestDate() 
    {
        return suggestDate;
    }
    public void setContactInformation(String contactInformation) 
    {
        this.contactInformation = contactInformation;
    }

    public String getContactInformation() 
    {
        return contactInformation;
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
		return "HyCommunitySuggest [id=" + id + ", suggestType=" + suggestType + ", informationContent="
				+ informationContent + ", suggestName=" + suggestName + ", suggestDate=" + suggestDate
				+ ", contactInformation=" + contactInformation + ", communityId=" + communityId + ", hyCommunity="
				+ hyCommunity + "]";
	}

	
}
