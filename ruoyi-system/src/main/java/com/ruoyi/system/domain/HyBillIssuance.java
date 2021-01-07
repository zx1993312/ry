package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 票据发放对象 hy_bill_issuance
 * 
 * @author Administrator
 * @date 2021-01-06 
 */
public class HyBillIssuance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 票据种类 */
    @Excel(name = "票据种类")
    private String billType;

    /** 起号 */
    @Excel(name = "起号")
    private Long billNumStr;

    /** 止号 */
    @Excel(name = "止号")
    private Long billNumEnd;

    /** 份数 */
    @Excel(name = "份数")
    private Integer copies;

    /** 起号样票 */
    @Excel(name = "起号样票")
    private String ticketSampleStr;

    /** 止号样票 */
    @Excel(name = "止号样票")
    private String ticketSampleEnd;

    /** 使用小区 */
    @Excel(name = "使用小区")
    private String community;

    /** 领用人 */
    @Excel(name = "领用人")
    private String receiver;

    /** 使用人 */
    @Excel(name = "使用人")
    private String user;

    /** 发放时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发放时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    /** 使用范围 */
    @Excel(name = "使用范围")
    private String applicationScope;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBillType(String billType) 
    {
        this.billType = billType;
    }

    public String getBillType() 
    {
        return billType;
    }
    public void setBillNumStr(Long billNumStr) 
    {
        this.billNumStr = billNumStr;
    }

    public Long getBillNumStr() 
    {
        return billNumStr;
    }
    public void setBillNumEnd(Long billNumEnd) 
    {
        this.billNumEnd = billNumEnd;
    }

    public Long getBillNumEnd() 
    {
        return billNumEnd;
    }
    public void setCopies(Integer copies) 
    {
        this.copies = copies;
    }

    public Integer getCopies() 
    {
        return copies;
    }
    public void setTicketSampleStr(String ticketSampleStr) 
    {
        this.ticketSampleStr = ticketSampleStr;
    }

    public String getTicketSampleStr() 
    {
        return ticketSampleStr;
    }
    public void setTicketSampleEnd(String ticketSampleEnd) 
    {
        this.ticketSampleEnd = ticketSampleEnd;
    }

    public String getTicketSampleEnd() 
    {
        return ticketSampleEnd;
    }
    public void setCommunity(String community) 
    {
        this.community = community;
    }

    public String getCommunity() 
    {
        return community;
    }
    public void setReceiver(String receiver) 
    {
        this.receiver = receiver;
    }

    public String getReceiver() 
    {
        return receiver;
    }
    public void setUser(String user) 
    {
        this.user = user;
    }

    public String getUser() 
    {
        return user;
    }
    public void setReleaseTime(Date releaseTime) 
    {
        this.releaseTime = releaseTime;
    }

    public Date getReleaseTime() 
    {
        return releaseTime;
    }
    public void setApplicationScope(String applicationScope) 
    {
        this.applicationScope = applicationScope;
    }

    public String getApplicationScope() 
    {
        return applicationScope;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("billType", getBillType())
            .append("billNumStr", getBillNumStr())
            .append("billNumEnd", getBillNumEnd())
            .append("copies", getCopies())
            .append("ticketSampleStr", getTicketSampleStr())
            .append("ticketSampleEnd", getTicketSampleEnd())
            .append("community", getCommunity())
            .append("receiver", getReceiver())
            .append("user", getUser())
            .append("releaseTime", getReleaseTime())
            .append("applicationScope", getApplicationScope())
            .toString();
    }
}
