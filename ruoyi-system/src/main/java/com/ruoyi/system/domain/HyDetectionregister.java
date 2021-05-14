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
 * 设备检测登记对象 hy_detectionregister
 * 
 * @author Administrator
 * @date 2021-05-14
 */
public class HyDetectionregister extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备检测登记id */
    private Long id;

    /** 单据号 */
    @Excel(name = "单据号")
    private String documentNumber;

    /** 检测人 */
    @Excel(name = "检测人")
    private String inspector;

    /** 检测日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "检测日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inspectionDate;

    /** 检测周期 */
    @Excel(name = "检测周期")
    private String inspectionPeriod;

    /** 检测单位 */
    @Excel(name = "检测单位")
    private String inspectionUnit;

    /** 检测内容 */
    @Excel(name = "检测内容")
    private String inspectionContent;

    /** 检测结果 */
    @Excel(name = "检测结果")
    private String inspectionResult;

    /** 检测费用 */
    @Excel(name = "检测费用")
    private BigDecimal inspectionCost;

    /** 检测备注 */
    @Excel(name = "检测备注")
    private String inspectionRemark;

    /** 是否审核 */
    @Excel(name = "是否审核")
    private String isAudit;

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
    public void setDocumentNumber(String documentNumber) 
    {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber() 
    {
        return documentNumber;
    }
    public void setInspector(String inspector) 
    {
        this.inspector = inspector;
    }

    public String getInspector() 
    {
        return inspector;
    }
    public void setInspectionDate(Date inspectionDate) 
    {
        this.inspectionDate = inspectionDate;
    }

    public Date getInspectionDate() 
    {
        return inspectionDate;
    }
    public void setInspectionPeriod(String inspectionPeriod) 
    {
        this.inspectionPeriod = inspectionPeriod;
    }

    public String getInspectionPeriod() 
    {
        return inspectionPeriod;
    }
    public void setInspectionUnit(String inspectionUnit) 
    {
        this.inspectionUnit = inspectionUnit;
    }

    public String getInspectionUnit() 
    {
        return inspectionUnit;
    }
    public void setInspectionContent(String inspectionContent) 
    {
        this.inspectionContent = inspectionContent;
    }

    public String getInspectionContent() 
    {
        return inspectionContent;
    }
    public void setInspectionResult(String inspectionResult) 
    {
        this.inspectionResult = inspectionResult;
    }

    public String getInspectionResult() 
    {
        return inspectionResult;
    }
    public void setInspectionCost(BigDecimal inspectionCost) 
    {
        this.inspectionCost = inspectionCost;
    }

    public BigDecimal getInspectionCost() 
    {
        return inspectionCost;
    }
    public void setInspectionRemark(String inspectionRemark) 
    {
        this.inspectionRemark = inspectionRemark;
    }

    public String getInspectionRemark() 
    {
        return inspectionRemark;
    }
    public void setIsAudit(String isAudit) 
    {
        this.isAudit = isAudit;
    }

    public String getIsAudit() 
    {
        return isAudit;
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
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
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
            .append("inspector", getInspector())
            .append("inspectionDate", getInspectionDate())
            .append("inspectionPeriod", getInspectionPeriod())
            .append("inspectionUnit", getInspectionUnit())
            .append("inspectionContent", getInspectionContent())
            .append("inspectionResult", getInspectionResult())
            .append("inspectionCost", getInspectionCost())
            .append("inspectionRemark", getInspectionRemark())
            .append("isAudit", getIsAudit())
            .append("equipmentId", getEquipmentId())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("hyEquipment", getHyEquipment())
            .append("sysUser", getSysUser())
            .append("sysDept", getSysDept())
            .toString();
    }
}
