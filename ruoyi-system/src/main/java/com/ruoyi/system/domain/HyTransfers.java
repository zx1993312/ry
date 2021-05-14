package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 设备调拨一览对象 hy_transfers
 * 
 * @author Administrator
 * @date 2021-05-14
 */
public class HyTransfers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备调拨id */
    private Long id;

    /** 单据号 */
    @Excel(name = "单据号")
    private String documentNumber;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicationDate;

    /** 调拨日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "调拨日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date allocationDate;

    /** 是否审核 */
    @Excel(name = "是否审核")
    private String isAudit;

    /** 申请人 */
    @Excel(name = "申请人")
    private String proposer;

    /** 审核人 */
    @Excel(name = "审核人")
    private String auditor;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 制单人 */
    @Excel(name = "制单人")
    private String preparedBy;

    /** 制单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "制单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date makeTime;

    /** 修订人 */
    @Excel(name = "修订人")
    private String reviser;

    /** 修订时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修订时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date revisionTime;

    /** 备注 */
    @Excel(name = "备注")
    private String transfersRemark;

    /** 组织id */
    @Excel(name = "组织id")
    private Long deptId;
    
    /** 组织表 */
    @Excel(name = "组织表")
    private SysDept sysDept;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDocumentNumber(String documentNumber) 
    {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber() 
    {
        return documentNumber;
    }
    public void setApplicationDate(Date applicationDate) 
    {
        this.applicationDate = applicationDate;
    }

    public Date getApplicationDate() 
    {
        return applicationDate;
    }
    public void setAllocationDate(Date allocationDate) 
    {
        this.allocationDate = allocationDate;
    }

    public Date getAllocationDate() 
    {
        return allocationDate;
    }
    public void setIsAudit(String isAudit) 
    {
        this.isAudit = isAudit;
    }

    public String getIsAudit() 
    {
        return isAudit;
    }
    public void setProposer(String proposer) 
    {
        this.proposer = proposer;
    }

    public String getProposer() 
    {
        return proposer;
    }
    public void setAuditor(String auditor) 
    {
        this.auditor = auditor;
    }

    public String getAuditor() 
    {
        return auditor;
    }
    public void setAuditTime(Date auditTime) 
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime() 
    {
        return auditTime;
    }
    public void setPreparedBy(String preparedBy) 
    {
        this.preparedBy = preparedBy;
    }

    public String getPreparedBy() 
    {
        return preparedBy;
    }
    public void setMakeTime(Date makeTime) 
    {
        this.makeTime = makeTime;
    }

    public Date getMakeTime() 
    {
        return makeTime;
    }
    public void setReviser(String reviser) 
    {
        this.reviser = reviser;
    }

    public String getReviser() 
    {
        return reviser;
    }
    public void setRevisionTime(Date revisionTime) 
    {
        this.revisionTime = revisionTime;
    }

    public Date getRevisionTime() 
    {
        return revisionTime;
    }
    public void setTransfersRemark(String transfersRemark) 
    {
        this.transfersRemark = transfersRemark;
    }

    public String getTransfersRemark() 
    {
        return transfersRemark;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public SysDept getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("documentNumber", getDocumentNumber())
            .append("applicationDate", getApplicationDate())
            .append("allocationDate", getAllocationDate())
            .append("isAudit", getIsAudit())
            .append("proposer", getProposer())
            .append("auditor", getAuditor())
            .append("auditTime", getAuditTime())
            .append("preparedBy", getPreparedBy())
            .append("makeTime", getMakeTime())
            .append("reviser", getReviser())
            .append("revisionTime", getRevisionTime())
            .append("transfersRemark", getTransfersRemark())
            .append("deptId", getDeptId())
            .append("sysDept", getSysDept())
            .toString();
    }
}
