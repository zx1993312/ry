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

    /** 编号 */
    @Excel(name = "编号")
    private String reportNumber;
    
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
    
    /** 耗材费用 */
    @Excel(name = "耗材费用")
    private BigDecimal reportConsumable;
    
    /** 合计 */
    @Excel(name = "合计")
    private BigDecimal reportTotal;

    /** 回访 */
    @Excel(name = "回访")
    private String reportVisit;
    
    /** 推送 */
    @Excel(name = "推送")
    private String reportPush;
    
    /** 图片 */
    @Excel(name = "图片")
    private String reportPicture;
    
    /** 时长 */
    @Excel(name = "时长")
    private String reportDuration;
    
    /** 维修难度 */
    @Excel(name = "维修难度")
    private String maintenanceDifficulty;

    /** 业主id */
    @Excel(name = "业主id")
    private Long ownerId;
    
    /** 业主表 */
    @Excel(name = "业主表")
    private HyOwnerRegistration hyOwnerRegistration;
    
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
    
    public String getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
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
    
    public BigDecimal getReportConsumable() {
		return reportConsumable;
	}

	public void setReportConsumable(BigDecimal reportConsumable) {
		this.reportConsumable = reportConsumable;
	}

	public BigDecimal getReportTotal() {
		return reportTotal;
	}

	public void setReportTotal(BigDecimal reportTotal) {
		this.reportTotal = reportTotal;
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

	public String getReportDuration() {
		return reportDuration;
	}

	public void setReportDuration(String reportDuration) {
		this.reportDuration = reportDuration;
	}

	public String getMaintenanceDifficulty() {
		return maintenanceDifficulty;
	}

	public void setMaintenanceDifficulty(String maintenanceDifficulty) {
		this.maintenanceDifficulty = maintenanceDifficulty;
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

	public Long getQuartersId() {
		return quartersId;
	}

	public void setQuartersId(Long quartersId) {
		this.quartersId = quartersId;
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
		return "HyReport [id=" + id + ", reportNumber=" + reportNumber + ", reportAddress=" + reportAddress
				+ ", reportArea=" + reportArea + ", reportLevel=" + reportLevel + ", reportClassify=" + reportClassify
				+ ", reportContent=" + reportContent + ", reportDescription=" + reportDescription + ", reportDate="
				+ reportDate + ", reportQuality=" + reportQuality + ", reportState=" + reportState + ", reportAudit="
				+ reportAudit + ", reportEvaluate=" + reportEvaluate + ", reportCost=" + reportCost
				+ ", reportConsumable=" + reportConsumable + ", reportTotal=" + reportTotal + ", reportVisit="
				+ reportVisit + ", reportPush=" + reportPush + ", reportPicture=" + reportPicture + ", reportDuration="
				+ reportDuration + ", maintenanceDifficulty=" + maintenanceDifficulty + ", ownerId=" + ownerId
				+ ", hyOwnerRegistration=" + hyOwnerRegistration + ", quartersId=" + quartersId
				+ ", hyResidentialQuarters=" + hyResidentialQuarters + ", recipientsId=" + recipientsId
				+ ", hyRecipients=" + hyRecipients + ", sysUser=" + sysUser + "]";
	}

	
}
