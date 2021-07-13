package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社区资询对象 hy_community_information
 * 
 * @author Administrator
 * @date 2021-07-13
 */
public class HyCommunityInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 社区资询id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String informationTitle;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operationTime;

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
    public void setInformationTitle(String informationTitle) 
    {
        this.informationTitle = informationTitle;
    }

    public String getInformationTitle() 
    {
        return informationTitle;
    }
    public void setOperationTime(Date operationTime) 
    {
        this.operationTime = operationTime;
    }

    public Date getOperationTime() 
    {
        return operationTime;
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
            .append("informationTitle", getInformationTitle())
            .append("operationTime", getOperationTime())
            .append("informationContent", getInformationContent())
            .toString();
    }
}