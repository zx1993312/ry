package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.annotation.EnumAnn;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.enums.AuditEnum;
import com.ruoyi.system.enums.ControlEnum;

/**
 * 增值税率审核对象 hy_vat_audit
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public class HyVatAudit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 区域名称 */
    @Excel(name = "区域名称")
    private String areaName;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectNum;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String entryName;

    /** 纳税人规模 */
    @Excel(name = "纳税人规模")
    private String taxScale;

    /** 费用科目 */
    @Excel(name = "费用科目")
    private String expenseAccount;

    /** 税率 */
    @Excel(name = "税率")
    private String taxRate;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date timeStr;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date timeEnd;

    /** 审核状态 */
    @Excel(name = "审核状态")
    @EnumAnn(enumClass=AuditEnum.class)
    private Integer auditStatus;

    /** 是否需要不动产备案 */
    @Excel(name = "是否需要不动产备案")
    @EnumAnn(enumClass=ControlEnum.class)
    private Integer estateRecord;

    /** 是否需要合同违约金含税率 */
    @Excel(name = "是否需要合同违约金含税率")
    @EnumAnn(enumClass=ControlEnum.class)
    private Integer taxRateRecord;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setProjectNum(String projectNum) 
    {
        this.projectNum = projectNum;
    }

    public String getProjectNum() 
    {
        return projectNum;
    }
    public void setEntryName(String entryName) 
    {
        this.entryName = entryName;
    }

    public String getEntryName() 
    {
        return entryName;
    }
    public void setTaxScale(String taxScale) 
    {
        this.taxScale = taxScale;
    }

    public String getTaxScale() 
    {
        return taxScale;
    }
    public void setExpenseAccount(String expenseAccount) 
    {
        this.expenseAccount = expenseAccount;
    }

    public String getExpenseAccount() 
    {
        return expenseAccount;
    }
    public void setTaxRate(String taxRate) 
    {
        this.taxRate = taxRate;
    }

    public String getTaxRate() 
    {
        return taxRate;
    }
    public void setTimeStr(Date timeStr) 
    {
        this.timeStr = timeStr;
    }

    public Date getTimeStr() 
    {
        return timeStr;
    }
    public void setTimeEnd(Date timeEnd) 
    {
        this.timeEnd = timeEnd;
    }

    public Date getTimeEnd() 
    {
        return timeEnd;
    }
    public void setAuditStatus(Integer auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus() 
    {
        return auditStatus;
    }
    public void setEstateRecord(Integer estateRecord) 
    {
        this.estateRecord = estateRecord;
    }

    public Integer getEstateRecord() 
    {
        return estateRecord;
    }
    public void setTaxRateRecord(Integer taxRateRecord) 
    {
        this.taxRateRecord = taxRateRecord;
    }

    public Integer getTaxRateRecord() 
    {
        return taxRateRecord;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("areaName", getAreaName())
            .append("projectNum", getProjectNum())
            .append("entryName", getEntryName())
            .append("taxScale", getTaxScale())
            .append("expenseAccount", getExpenseAccount())
            .append("taxRate", getTaxRate())
            .append("timeStr", getTimeStr())
            .append("timeEnd", getTimeEnd())
            .append("auditStatus", getAuditStatus())
            .append("estateRecord", getEstateRecord())
            .append("taxRateRecord", getTaxRateRecord())
            .toString();
    }
}
