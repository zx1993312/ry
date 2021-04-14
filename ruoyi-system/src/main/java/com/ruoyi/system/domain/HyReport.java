package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

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

    /** 姓名 */
    @Excel(name = "姓名")
    private String reportName;

    /** 手机 */
    @Excel(name = "手机")
    private String reportPhone;

    /** 地址 */
    @Excel(name = "地址")
    private String reportAddress;

    /** 分类 */
    @Excel(name = "分类")
    private String reportClassify;

    /** 报修内容 */
    @Excel(name = "报修内容")
    private String reportContent;

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

    /** 小区id */
    @Excel(name = "小区id")
    private Long quartersId;
    
    /** 小区表 */
    @Excel(name = "小区表")
    private HyResidentialQuarters hyResidentialQuarters;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setReportName(String reportName) 
    {
        this.reportName = reportName;
    }

    public String getReportName() 
    {
        return reportName;
    }
    public void setReportPhone(String reportPhone) 
    {
        this.reportPhone = reportPhone;
    }

    public String getReportPhone() 
    {
        return reportPhone;
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

	@Override
	public String toString() {
		return "HyReport [id=" + id + ", reportName=" + reportName + ", reportPhone=" + reportPhone + ", reportAddress="
				+ reportAddress + ", reportClassify=" + reportClassify + ", reportContent=" + reportContent
				+ ", reportDate=" + reportDate + ", reportQuality=" + reportQuality + ", reportState=" + reportState
				+ ", reportAudit=" + reportAudit + ", reportEvaluate=" + reportEvaluate + ", reportCost=" + reportCost
				+ ", reportVisit=" + reportVisit + ", quartersId=" + quartersId + ", hyResidentialQuarters="
				+ hyResidentialQuarters + "]";
	}

	
}
