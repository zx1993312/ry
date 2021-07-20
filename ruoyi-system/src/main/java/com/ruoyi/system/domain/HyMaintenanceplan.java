package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 设备保养计划对象 hy_maintenanceplan
 * 
 * @author Administrator
 * @date 2021-05-11
 */
/**
 * @author Administrator
 *
 */
public class HyMaintenanceplan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备保养计划id */
    private Long id;

    /** 计划编号 */
    @Excel(name = "计划编号")
    private Long planCode;

    /** 计划名称 */
    @Excel(name = "计划名称")
    private String planName;

    /** 计划日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planDate;

    /** 计划状态 */
    @Excel(name = "计划状态")
    private String planStatus;

    /** 设备保养类别 */
    @Excel(name = "设备保养类别")
    private String maintainType;

    /** 设备保养等级 */
    @Excel(name = "设备保养等级")
    private String maintainLevel;

    /** 设备保养周期 */
    @Excel(name = "设备保养周期")
    private String maintainPeriod;

    /** 备注 */
    @Excel(name = "备注")
    private String planRemark;
    
    /** 是否审核 */
    @Excel(name = "是否审核")
    private String isAudit;

    /** 计划关闭 */
    @Excel(name = "计划关闭")
    private String plansClose;

    /** 关闭类型 */
    @Excel(name = "关闭类型")
    private String closedType;

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

    /** 设备保养项目内容 */
    @Excel(name = "设备保养项目内容")
    private String content;

    /** 专业部门 */
    @Excel(name = "专业部门")
    private String specializedDepartment;

    /** 原保养计划编号 */
    @Excel(name = "原保养计划编号")
    private String planNumber;

    /** 设备类别id */
    @Excel(name = "设备类别id")
    private Long equipmentId;
    
    /** 设备类别表 */
    @Excel(name = "设备类别表")
    private HyEquipment hyEquipment;

    /** 组织机构id */
    @Excel(name = "组织机构id")
    private Long deptId;
    
    /** 组织机构表 */
    @Excel(name = "组织机构表")
    private SysDept sysDept;

    /** 员工id */
    @Excel(name = "员工id")
    private Long userId;
    
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
    public void setPlanCode(Long planCode) 
    {
        this.planCode = planCode;
    }

    public Long getPlanCode() 
    {
        return planCode;
    }
    public void setPlanName(String planName) 
    {
        this.planName = planName;
    }

    public String getPlanName() 
    {
        return planName;
    }
    public void setPlanDate(Date planDate) 
    {
        this.planDate = planDate;
    }

    public Date getPlanDate() 
    {
        return planDate;
    }
    
    public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public void setMaintainType(String maintainType) 
    {
        this.maintainType = maintainType;
    }

    public String getMaintainType() 
    {
        return maintainType;
    }
    public void setMaintainLevel(String maintainLevel) 
    {
        this.maintainLevel = maintainLevel;
    }

    public String getMaintainLevel() 
    {
        return maintainLevel;
    }
    public void setMaintainPeriod(String maintainPeriod) 
    {
        this.maintainPeriod = maintainPeriod;
    }

    public String getMaintainPeriod() 
    {
        return maintainPeriod;
    }
    public void setPlanRemark(String planRemark) 
    {
        this.planRemark = planRemark;
    }

    public String getPlanRemark() 
    {
        return planRemark;
    }
    public void setIsAudit(String isAudit) 
    {
        this.isAudit = isAudit;
    }

    public String getIsAudit() 
    {
        return isAudit;
    }
    public void setPlansClose(String plansClose) 
    {
        this.plansClose = plansClose;
    }

    public String getPlansClose() 
    {
        return plansClose;
    }
    public void setClosedType(String closedType) 
    {
        this.closedType = closedType;
    }

    public String getClosedType() 
    {
        return closedType;
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
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setSpecializedDepartment(String specializedDepartment) 
    {
        this.specializedDepartment = specializedDepartment;
    }

    public String getSpecializedDepartment() 
    {
        return specializedDepartment;
    }
    public void setPlanNumber(String planNumber) 
    {
        this.planNumber = planNumber;
    }

    public String getPlanNumber() 
    {
        return planNumber;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public HyEquipment getHyEquipment() {
		return hyEquipment;
	}

	public void setHyEquipment(HyEquipment hyEquipment) {
		this.hyEquipment = hyEquipment;
	}

	public SysDept getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planCode", getPlanCode())
            .append("planName", getPlanName())
            .append("planDate", getPlanDate())
            .append("planStatus", getPlanStatus())
            .append("maintainType", getMaintainType())
            .append("maintainLevel", getMaintainLevel())
            .append("maintainPeriod", getMaintainPeriod())
            .append("planRemark", getPlanRemark())
            .append("isAudit", getIsAudit())
            .append("plansClose", getPlansClose())
            .append("closedType", getClosedType())
            .append("preparedBy", getPreparedBy())
            .append("makeTime", getMakeTime())
            .append("reviser", getReviser())
            .append("revisionTime", getRevisionTime())
            .append("content", getContent())
            .append("specializedDepartment", getSpecializedDepartment())
            .append("planNumber", getPlanNumber())
            .append("equipmentId", getEquipmentId())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .append("hyEquipment", getHyEquipment())
            .append("sysDept", getSysDept())
            .append("sysUser", getSysUser())
            .toString();
    }
}
