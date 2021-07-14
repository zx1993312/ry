package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 催缴通知对象 hy_reminder_notice
 * 
 * @author Administrator
 * @date 2021-07-14
 */
public class HyReminderNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 催缴通知id */
    private Long id;

    /** 欠款 */
    @Excel(name = "欠款")
    private String noticeArrearage;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date noticeDate;

    /** 逻辑删除 */
    private String delFlag;

    /** 接收员id */
    @Excel(name = "接收员id")
    private Long recipientsId;
    
    /** 接收员表 */
    @Excel(name = "接收员表")
    private HyRecipients hyRecipients;

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
    
    public String getNoticeArrearage() {
		return noticeArrearage;
	}

	public void setNoticeArrearage(String noticeArrearage) {
		this.noticeArrearage = noticeArrearage;
	}

	public void setNoticeDate(Date noticeDate) 
    {
        this.noticeDate = noticeDate;
    }

    public Date getNoticeDate() 
    {
        return noticeDate;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setRecipientsId(Long recipientsId) 
    {
        this.recipientsId = recipientsId;
    }

    public Long getRecipientsId() 
    {
        return recipientsId;
    }
    public void setOwnerId(Long ownerId) 
    {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() 
    {
        return ownerId;
    }

    public HyRecipients getHyRecipients() {
		return hyRecipients;
	}

	public void setHyRecipients(HyRecipients hyRecipients) {
		this.hyRecipients = hyRecipients;
	}

	public HyOwnerRegistration getHyOwnerRegistration() {
		return hyOwnerRegistration;
	}

	public void setHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		this.hyOwnerRegistration = hyOwnerRegistration;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("noticeArrearage", getNoticeArrearage())
            .append("noticeDate", getNoticeDate())
            .append("delFlag", getDelFlag())
            .append("recipientsId", getRecipientsId())
            .append("ownerId", getOwnerId())
            .append("hyRecipients", getHyRecipients())
            .append("hyOwnerRegistration", getHyOwnerRegistration())
            .toString();
    }
}
