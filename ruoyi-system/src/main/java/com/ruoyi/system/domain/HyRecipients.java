package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 接收员对象 hy_recipients
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public class HyRecipients extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 接收员id */
    private Long id;

    /** 人员类型 */
    @Excel(name = "人员类型")
    private String personType;

    /** 选择部门 */
    @Excel(name = "选择部门")
    private String recipientsDept;

    /** 选择员工 */
    @Excel(name = "选择员工")
    private String recipientsEmployee;

    /** 姓名 */
    @Excel(name = "姓名")
    private String recipientsName;

    /** 通知方式 */
    @Excel(name = "通知方式")
    private String notificationWay;

    /** 省/直辖市 */
    @Excel(name = "省/直辖市")
    private String recipientsProvince;

    /** 市/直辖区 */
    @Excel(name = "市/直辖区")
    private String recipientsCity;

    /** 区/县 */
    @Excel(name = "区/县")
    private String recipientsArea;

    /** 报事管理id */
    @Excel(name = "报事管理id")
    private Long reportId;
    
    /** 报事管理表 */
    @Excel(name = "报事管理表")
    private HyReport hyReport;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPersonType(String personType) 
    {
        this.personType = personType;
    }

    public String getPersonType() 
    {
        return personType;
    }
    public void setRecipientsDept(String recipientsDept) 
    {
        this.recipientsDept = recipientsDept;
    }

    public String getRecipientsDept() 
    {
        return recipientsDept;
    }
    public void setRecipientsEmployee(String recipientsEmployee) 
    {
        this.recipientsEmployee = recipientsEmployee;
    }

    public String getRecipientsEmployee() 
    {
        return recipientsEmployee;
    }
    public void setRecipientsName(String recipientsName) 
    {
        this.recipientsName = recipientsName;
    }

    public String getRecipientsName() 
    {
        return recipientsName;
    }
    public void setNotificationWay(String notificationWay) 
    {
        this.notificationWay = notificationWay;
    }

    public String getNotificationWay() 
    {
        return notificationWay;
    }
    public void setRecipientsProvince(String recipientsProvince) 
    {
        this.recipientsProvince = recipientsProvince;
    }

    public String getRecipientsProvince() 
    {
        return recipientsProvince;
    }
    public void setRecipientsCity(String recipientsCity) 
    {
        this.recipientsCity = recipientsCity;
    }

    public String getRecipientsCity() 
    {
        return recipientsCity;
    }
    public void setRecipientsArea(String recipientsArea) 
    {
        this.recipientsArea = recipientsArea;
    }

    public String getRecipientsArea() 
    {
        return recipientsArea;
    }
    public void setReportId(Long reportId) 
    {
        this.reportId = reportId;
    }

    public Long getReportId() 
    {
        return reportId;
    }

    public HyReport getHyReport() {
		return hyReport;
	}

	public void setHyReport(HyReport hyReport) {
		this.hyReport = hyReport;
	}

	@Override
	public String toString() {
		return "HyRecipients [id=" + id + ", personType=" + personType + ", recipientsDept=" + recipientsDept
				+ ", recipientsEmployee=" + recipientsEmployee + ", recipientsName=" + recipientsName
				+ ", notificationWay=" + notificationWay + ", recipientsProvince=" + recipientsProvince
				+ ", recipientsCity=" + recipientsCity + ", recipientsArea=" + recipientsArea + ", reportId=" + reportId
				+ ", hyReport=" + hyReport + "]";
	}

	
}
