package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社区咨询对象 hy_community_information
 * 
 * @author Administrator
 * @date 2021-03-15
 */
public class HyCommunityInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  社区咨询id */
    private Long id;

    /** 咨询类型 */
    @Excel(name = "咨询类型")
    private String informationType;

    /** 来源 */
    @Excel(name = "来源")
    private String source;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 有效时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date effectiveTime;

    /** 是否重要公告 */
    @Excel(name = "是否重要公告")
    private String importantAnnouncement;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** 上次操作人 */
    @Excel(name = "上次操作人")
    private String historyOperator;

    /** 上次操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上次操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date historyOperationTime;

    /** 公告范围项目 */
    @Excel(name = "公告范围项目")
    private String announcementScopeItems;

    /** 公告范围楼栋 */
    @Excel(name = "公告范围楼栋")
    private String noticeScopeBuilding;

    /** 信息内容 */
    @Excel(name = "信息内容")
    private String informationContent;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInformationType(String informationType) 
    {
        this.informationType = informationType;
    }

    public String getInformationType() 
    {
        return informationType;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEffectiveTime(Date effectiveTime) 
    {
        this.effectiveTime = effectiveTime;
    }

    public Date getEffectiveTime() 
    {
        return effectiveTime;
    }
    public void setImportantAnnouncement(String importantAnnouncement) 
    {
        this.importantAnnouncement = importantAnnouncement;
    }

    public String getImportantAnnouncement() 
    {
        return importantAnnouncement;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setHistoryOperator(String historyOperator) 
    {
        this.historyOperator = historyOperator;
    }

    public String getHistoryOperator() 
    {
        return historyOperator;
    }
    public void setHistoryOperationTime(Date historyOperationTime) 
    {
        this.historyOperationTime = historyOperationTime;
    }

    public Date getHistoryOperationTime() 
    {
        return historyOperationTime;
    }
    public void setAnnouncementScopeItems(String announcementScopeItems) 
    {
        this.announcementScopeItems = announcementScopeItems;
    }

    public String getAnnouncementScopeItems() 
    {
        return announcementScopeItems;
    }
    public void setNoticeScopeBuilding(String noticeScopeBuilding) 
    {
        this.noticeScopeBuilding = noticeScopeBuilding;
    }

    public String getNoticeScopeBuilding() 
    {
        return noticeScopeBuilding;
    }
    public void setInformationContent(String informationContent) 
    {
        this.informationContent = informationContent;
    }

    public String getInformationContent() 
    {
        return informationContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("informationType", getInformationType())
            .append("source", getSource())
            .append("title", getTitle())
            .append("startTime", getStartTime())
            .append("effectiveTime", getEffectiveTime())
            .append("importantAnnouncement", getImportantAnnouncement())
            .append("state", getState())
            .append("historyOperator", getHistoryOperator())
            .append("historyOperationTime", getHistoryOperationTime())
            .append("announcementScopeItems", getAnnouncementScopeItems())
            .append("noticeScopeBuilding", getNoticeScopeBuilding())
            .append("informationContent", getInformationContent())
            .toString();
    }
}
