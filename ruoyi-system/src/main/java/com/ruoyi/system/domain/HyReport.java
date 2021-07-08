package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 报事管理对象 hy_report
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public class HyReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报事管理id */
    private Long id;

    /** 地址/所在位置 */
    @Excel(name = "地址")
    private String reportAddress;
    
    /** 报事区域 */
    @Excel(name = "报事区域")
    private String reportArea;
    
    /** 报事等级 */
    @Excel(name = "报事等级")
    private String reportLevel;

    /** 分类 */
    @Excel(name = "分类")
    private String reportClassify;

    /** 报修内容 */
    @Excel(name = "报修内容")
    private String reportContent;
    
    /** 详情描述 */
    @Excel(name = "详情描述")
    private String reportDescription;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reportDate;

    /** 质保 */
    @Excel(name = "质保")
    private String reportQuality;

    /** 状态 */
    @Excel(name = "状态")
    private String reportState;

    /** 审核 */
    @Excel(name = "审核")
    private String reportAudit;

    /** 评价 */
    @Excel(name = "评价")
    private String reportEvaluate;

    /** 维修费用 */
    @Excel(name = "维修费用")
    private BigDecimal reportCost;

    /** 回访 */
    @Excel(name = "回访")
    private String reportVisit;
    
    /** 推送 */
    @Excel(name = "推送")
    private String reportPush;
    
    /** 图片 */
    @Excel(name = "图片")
    private String reportPicture;

    /** 小区id */
    @Excel(name = "小区id")
    private Long quartersId;
    
    /** 小区表 */
    @Excel(name = "小区表")
    private HyResidentialQuarters hyResidentialQuarters;
    
    /** 接收员id */
    @Excel(name = "接收员id")
    private Long recipientsId;
    
    /** 接收员表 */
    @Excel(name = "接收员表")
    private HyRecipients hyRecipients;
    
    /** 员工表 */
    @Excel(name = "员工表")
    private SysUser sysUser;
    

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setReportAddress(String reportAddress) 
    {
        this.reportAddress = reportAddress;
    }

    public String getReportAddress() 
    {
        return reportAddress;
    }
    public void setReportClassify(String reportClassify) 
    {
        this.reportClassify = reportClassify;
    }

    public String getReportClassify() 
    {
        return reportClassify;
    }
    public void setReportContent(String reportContent) 
    {
        this.reportContent = reportContent;
    }

    public String getReportContent() 
    {
        return reportContent;
    }
    public void setReportDate(Date reportDate) 
    {
        this.reportDate = reportDate;
    }

    public Date getReportDate() 
    {
        return reportDate;
    }
    public void setReportQuality(String reportQuality) 
    {
        this.reportQuality = reportQuality;
    }

    public String getReportQuality() 
    {
        return reportQuality;
    }
    public void setReportState(String reportState) 
    {
        this.reportState = reportState;
    }

    public String getReportState() 
    {
        return reportState;
    }
    public void setReportAudit(String reportAudit) 
    {
        this.reportAudit = reportAudit;
    }

    public String getReportAudit() 
    {
        return reportAudit;
    }
    public void setReportEvaluate(String reportEvaluate) 
    {
        this.reportEvaluate = reportEvaluate;
    }

    public String getReportEvaluate() 
    {
        return reportEvaluate;
    }
    public void setReportCost(BigDecimal reportCost) 
    {
        this.reportCost = reportCost;
    }

    public BigDecimal getReportCost() 
    {
        return reportCost;
    }
    public void setReportVisit(String reportVisit) 
    {
        this.reportVisit = reportVisit;
    }

    public String getReportVisit() 
    {
        return reportVisit;
    }
    public String getReportPush() {
		return reportPush;
	}

	public void setReportPush(String reportPush) {
		this.reportPush = reportPush;
	}

	public void setQuartersId(Long quartersId) 
    {
        this.quartersId = quartersId;
    }

    public Long getQuartersId() 
    {
        return quartersId;
    }

    public HyResidentialQuarters getHyResidentialQuarters() {
		return hyResidentialQuarters;
	}

	public void setHyResidentialQuarters(HyResidentialQuarters hyResidentialQuarters) {
		this.hyResidentialQuarters = hyResidentialQuarters;
	}
	
	public Long getRecipientsId() {
		return recipientsId;
	}

	public void setRecipientsId(Long recipientsId) {
		this.recipientsId = recipientsId;
	}

	public HyRecipients getHyRecipients() {
		return hyRecipients;
	}

	public void setHyRecipients(HyRecipients hyRecipients) {
		this.hyRecipients = hyRecipients;
	}

	public String getReportArea() {
		return reportArea;
	}

	public void setReportArea(String reportArea) {
		this.reportArea = reportArea;
	}

	public String getReportLevel() {
		return reportLevel;
	}

	public void setReportLevel(String reportLevel) {
		this.reportLevel = reportLevel;
	}

	public String getReportDescription() {
		return reportDescription;
	}

	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}

	public String getReportPicture() {
		return reportPicture;
	}

	public void setReportPicture(String reportPicture) {
		this.reportPicture = reportPicture;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Override
	public String toString() {
		return "HyReport [id=" + id + ", reportAddress=" + reportAddress + ", reportArea=" + reportArea
				+ ", reportLevel=" + reportLevel + ", reportClassify=" + reportClassify + ", reportContent="
				+ reportContent + ", reportDescription=" + reportDescription + ", reportDate=" + reportDate
				+ ", reportQuality=" + reportQuality + ", reportState=" + reportState + ", reportAudit=" + reportAudit
				+ ", reportEvaluate=" + reportEvaluate + ", reportCost=" + reportCost + ", reportVisit=" + reportVisit
				+ ", reportPush=" + reportPush + ", reportPicture=" + reportPicture + ", quartersId=" + quartersId
				+ ", hyResidentialQuarters=" + hyResidentialQuarters + ", recipientsId=" + recipientsId
				+ ", hyRecipients=" + hyRecipients + ", sysUser=" + sysUser + "]";
	}


	

	

	
	

	
}
