package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社区活动对象 hy_community_activity
 * 
 * @author Administrator
 * @date 2021-07-14
 */
public class HyCommunityActivity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 社区活动id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String activityTitle;

    /** 信息内容 */
    @Excel(name = "信息内容")
    private String informationContent;

    /** 活动时间 */
    @Excel(name = "活动时间")
    private String activityDate;

    /** 活动地点 */
    @Excel(name = "活动地点")
    private String activityAddress;
    
    /** 限制人数 */
    @Excel(name = "限制人数")
    private int activityPopulation;
    
    

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setActivityTitle(String activityTitle) 
    {
        this.activityTitle = activityTitle;
    }

    public String getActivityTitle() 
    {
        return activityTitle;
    }
    public void setInformationContent(String informationContent) 
    {
        this.informationContent = informationContent;
    }

    public String getInformationContent() 
    {
        return informationContent;
    }
    public void setActivityDate(String activityDate) 
    {
        this.activityDate = activityDate;
    }

    public String getActivityDate() 
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

    public int getActivityPopulation() {
		return activityPopulation;
	}

	public void setActivityPopulation(int activityPopulation) {
		this.activityPopulation = activityPopulation;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("activityTitle", getActivityTitle())
            .append("informationContent", getInformationContent())
            .append("activityDate", getActivityDate())
            .append("activityAddress", getActivityAddress())
            .append("activityPopulation", getActivityPopulation())
            .append("createTime", getCreateTime())
            .toString();
    }
}