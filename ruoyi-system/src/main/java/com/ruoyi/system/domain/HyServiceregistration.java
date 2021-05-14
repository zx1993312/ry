package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 设备维修登记对象 hy_serviceregistration
 * 
 * @author Administrator
 * @date 2021-05-13
 */
public class HyServiceregistration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备维修登记id */
    private Long id;

    /** 维修单号 */
    @Excel(name = "维修单号")
    private Long repairOrder;

    /** 维修类别 */
    @Excel(name = "维修类别")
    private String serviceCategory;

    /** 故障类别 */
    @Excel(name = "故障类别")
    private String faultCategory;

    /** 故障发生时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "故障发生时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date failureTime;

    /** 故障情况 */
    @Excel(name = "故障情况")
    private String faultCondition;

    /** 维修开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "维修开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 维修结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "维修结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 故障原因类别 */
    @Excel(name = "故障原因类别")
    private String causeType;

    /** 维修单位 */
    @Excel(name = "维修单位")
    private String serviceUnit;

    /** 原因分析 */
    @Excel(name = "原因分析")
    private String reasonAnalysis;

    /** 维修结果 */
    @Excel(name = "维修结果")
    private String serviceResults;

    /** 维修费用 */
    @Excel(name = "维修费用")
    private BigDecimal serviceCosts;

    /** 是否审核 */
    @Excel(name = "是否审核")
    private String isAudit;

    /** 验收时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "验收时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receptionTime;

    /** 验收人 */
    @Excel(name = "验收人")
    private String acceptor;

    /** 检查验收情况 */
    @Excel(name = "检查验收情况")
    private String inspectionAcceptance;

    /** 问题整改情况 */
    @Excel(name = "问题整改情况")
    private String problemRectification;

    /** 当前周期 */
    @Excel(name = "当前周期")
    private String currentCycle;

    /** 当前年限 */
    @Excel(name = "当前年限")
    private BigDecimal currentYear;

    /** 调整年限 */
    @Excel(name = "调整年限")
    private String adjustmentYear;

    /** 备注 */
    @Excel(name = "备注")
    private String serviceRemark;

    /** 设备档案id */
    @Excel(name = "设备档案id")
    private Long archivesId;
    
    /** 设备档案表 */
    @Excel(name = "设备档案表")
    private HyEquipmentArchives hyEquipmentArchives;

    /** 设备类别id */
    @Excel(name = "设备类别id")
    private Long equipmentId;
    
    /** 设备类别表 */
    @Excel(name = "设备类别表")
    private HyEquipment hyEquipment;

    /** 员工id */
    @Excel(name = "员工id")
    private Long userId;
    
    /** 员工表 */
    @Excel(name = "员工表")
    private SysUser sysUser;
    
    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;
    
    /** 部门表 */
    @Excel(name = "部门表")
    private SysDept sysDept;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRepairOrder(Long repairOrder) 
    {
        this.repairOrder = repairOrder;
    }

    public Long getRepairOrder() 
    {
        return repairOrder;
    }
    public void setServiceCategory(String serviceCategory) 
    {
        this.serviceCategory = serviceCategory;
    }

    public String getServiceCategory() 
    {
        return serviceCategory;
    }
    public void setFaultCategory(String faultCategory) 
    {
        this.faultCategory = faultCategory;
    }

    public String getFaultCategory() 
    {
        return faultCategory;
    }
    public void setFailureTime(Date failureTime) 
    {
        this.failureTime = failureTime;
    }

    public Date getFailureTime() 
    {
        return failureTime;
    }
    public void setFaultCondition(String faultCondition) 
    {
        this.faultCondition = faultCondition;
    }

    public String getFaultCondition() 
    {
        return faultCondition;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setCauseType(String causeType) 
    {
        this.causeType = causeType;
    }

    public String getCauseType() 
    {
        return causeType;
    }
    public void setServiceUnit(String serviceUnit) 
    {
        this.serviceUnit = serviceUnit;
    }

    public String getServiceUnit() 
    {
        return serviceUnit;
    }
    public void setReasonAnalysis(String reasonAnalysis) 
    {
        this.reasonAnalysis = reasonAnalysis;
    }

    public String getReasonAnalysis() 
    {
        return reasonAnalysis;
    }
    public void setServiceResults(String serviceResults) 
    {
        this.serviceResults = serviceResults;
    }

    public String getServiceResults() 
    {
        return serviceResults;
    }
    public void setServiceCosts(BigDecimal serviceCosts) 
    {
        this.serviceCosts = serviceCosts;
    }

    public BigDecimal getServiceCosts() 
    {
        return serviceCosts;
    }
    public void setIsAudit(String isAudit) 
    {
        this.isAudit = isAudit;
    }

    public String getIsAudit() 
    {
        return isAudit;
    }
    public void setReceptionTime(Date receptionTime) 
    {
        this.receptionTime = receptionTime;
    }

    public Date getReceptionTime() 
    {
        return receptionTime;
    }
    public void setAcceptor(String acceptor) 
    {
        this.acceptor = acceptor;
    }

    public String getAcceptor() 
    {
        return acceptor;
    }
    public void setInspectionAcceptance(String inspectionAcceptance) 
    {
        this.inspectionAcceptance = inspectionAcceptance;
    }

    public String getInspectionAcceptance() 
    {
        return inspectionAcceptance;
    }
    public void setProblemRectification(String problemRectification) 
    {
        this.problemRectification = problemRectification;
    }

    public String getProblemRectification() 
    {
        return problemRectification;
    }
    public void setCurrentCycle(String currentCycle) 
    {
        this.currentCycle = currentCycle;
    }

    public String getCurrentCycle() 
    {
        return currentCycle;
    }
    public void setCurrentYear(BigDecimal currentYear) 
    {
        this.currentYear = currentYear;
    }

    public BigDecimal getCurrentYear() 
    {
        return currentYear;
    }
    public void setAdjustmentYear(String adjustmentYear) 
    {
        this.adjustmentYear = adjustmentYear;
    }

    public String getAdjustmentYear() 
    {
        return adjustmentYear;
    }
    public void setServiceRemark(String serviceRemark) 
    {
        this.serviceRemark = serviceRemark;
    }

    public String getServiceRemark() 
    {
        return serviceRemark;
    }
    public void setArchivesId(Long archivesId) 
    {
        this.archivesId = archivesId;
    }

    public Long getArchivesId() 
    {
        return archivesId;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public HyEquipmentArchives getHyEquipmentArchives() {
		return hyEquipmentArchives;
	}

	public void setHyEquipmentArchives(HyEquipmentArchives hyEquipmentArchives) {
		this.hyEquipmentArchives = hyEquipmentArchives;
	}

	public HyEquipment getHyEquipment() {
		return hyEquipment;
	}

	public void setHyEquipment(HyEquipment hyEquipment) {
		this.hyEquipment = hyEquipment;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
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
            .append("repairOrder", getRepairOrder())
            .append("serviceCategory", getServiceCategory())
            .append("faultCategory", getFaultCategory())
            .append("failureTime", getFailureTime())
            .append("faultCondition", getFaultCondition())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("causeType", getCauseType())
            .append("serviceUnit", getServiceUnit())
            .append("reasonAnalysis", getReasonAnalysis())
            .append("serviceResults", getServiceResults())
            .append("serviceCosts", getServiceCosts())
            .append("isAudit", getIsAudit())
            .append("receptionTime", getReceptionTime())
            .append("acceptor", getAcceptor())
            .append("inspectionAcceptance", getInspectionAcceptance())
            .append("problemRectification", getProblemRectification())
            .append("currentCycle", getCurrentCycle())
            .append("currentYear", getCurrentYear())
            .append("adjustmentYear", getAdjustmentYear())
            .append("serviceRemark", getServiceRemark())
            .append("archivesId", getArchivesId())
            .append("equipmentId", getEquipmentId())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("hyEquipmentArchives", getHyEquipmentArchives())
            .append("hyEquipment", getHyEquipment())
            .append("sysUser", getSysUser())
            .append("sysDept", getSysDept())
            .toString();
    }
}
