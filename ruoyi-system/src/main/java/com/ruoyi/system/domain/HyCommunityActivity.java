package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社区活动对象 hy_community_activity
 * 
 * @author Administrator
 * @date 2021-04-12
 */
public class HyCommunityActivity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 社区活动id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 信息内容 */
    @Excel(name = "信息内容")
    private String informationContent;

    /** 活动日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "活动日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date activityDate;

    /** 活动地点 */
    @Excel(name = "活动地点")
    private String activityAddress;

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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setInformationContent(String informationContent) 
    {
        this.informationContent = informationContent;
    }

    public String getInformationContent() 
    {
        return informationContent;
    }
    public void setActivityDate(Date activityDate) 
    {
        this.activityDate = activityDate;
    }

    public Date getActivityDate() 
    {
        return activityDate;
    }
    public void setActivityAddress(String activityAddress) 
    {
        this.activityAddress = activityAddress;
    }

    public String getActivityAddress() 
    {
        return activityAddress;
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
		return "HyCommunityActivity [id=" + id + ", title=" + title + ", informationContent=" + informationContent
				+ ", activityDate=" + activityDate + ", activityAddress=" + activityAddress + ", communityId="
				+ communityId + ", hyCommunity=" + hyCommunity + "]";
	}

}
