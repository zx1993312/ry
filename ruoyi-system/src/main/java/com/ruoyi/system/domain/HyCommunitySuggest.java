package com.ruoyi.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    /** 建议标题 */
    @Excel(name = "建议标题")
    private String suggestTitle;
    
    /** 建议类别 */
    @Excel(name = "建议类别")
    private String suggestType;

    /** 建议内容 */
    @Excel(name = "建议内容")
    private String informationContent;

    /** 建议日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "建议日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date suggestDate;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contactInformation;
    
    /** 审核人 */
    @Excel(name = "审核人")
    private String suggestAuditor;
    
    /** 审核状态 */
    @Excel(name = "审核状态")
    private String suggestStatus;
    
    /** 拒绝原因 */
    @Excel(name = "拒绝原因")
    private String refusalReason;
    
    /** 通过原因 */
    @Excel(name = "通过原因")
    private String throughReason;

    /** 业主id */
    @Excel(name = "业主id")
    private Long ownerId;
    
    /** 业主表 */
    @Excel(name = "业主表")
    private HyOwnerRegistration hyOwnerRegistration;
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    
    public String getSuggestTitle() {
		return suggestTitle;
	}

	public void setSuggestTitle(String suggestTitle) {
		this.suggestTitle = suggestTitle;
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
    
    public String getSuggestAuditor() {
		return suggestAuditor;
	}

	public void setSuggestAuditor(String suggestAuditor) {
		this.suggestAuditor = suggestAuditor;
	}

	public String getSuggestStatus() {
		return suggestStatus;
	}

	public void setSuggestStatus(String suggestStatus) {
		this.suggestStatus = suggestStatus;
	}

	public String getRefusalReason() {
		return refusalReason;
	}

	public void setRefusalReason(String refusalReason) {
		this.refusalReason = refusalReason;
	}

	public String getThroughReason() {
		return throughReason;
	}

	public void setThroughReason(String throughReason) {
		this.throughReason = throughReason;
	}


	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public HyOwnerRegistration getHyOwnerRegistration() {
		return hyOwnerRegistration;
	}

	public void setHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		this.hyOwnerRegistration = hyOwnerRegistration;
	}

	@Override
	public String toString() {
		return "HyCommunitySuggest [id=" + id + ", suggestTitle=" + suggestTitle + ", suggestType=" + suggestType
				+ ", informationContent=" + informationContent + ", suggestDate=" + suggestDate
				+ ", contactInformation=" + contactInformation + ", suggestAuditor=" + suggestAuditor
				+ ", suggestStatus=" + suggestStatus + ", refusalReason=" + refusalReason + ", throughReason="
				+ throughReason + ", ownerId=" + ownerId + ", hyOwnerRegistration=" + hyOwnerRegistration + "]";
	}



	
}
