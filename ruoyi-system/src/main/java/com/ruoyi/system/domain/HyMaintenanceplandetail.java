package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备保养计划执行安排对象 hy_maintenanceplandetail
 * 
 * @author Administrator
 * @date 2021-05-11
 */
public class HyMaintenanceplandetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备保养计划执行安排id */
    private Long id;

    /** 保养项目 */
    @Excel(name = "保养项目")
    private String maintenanceProject;

    /** 保养要求 */
    @Excel(name = "保养要求")
    private String maintenanceRequirements;

    /** 计划执行日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划执行日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date executionDate;

    /** 计划完成日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划完成日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishDate;

    /** 执行工期 */
    @Excel(name = "执行工期")
    private String executiveProject;

    /** 执行部门 */
    @Excel(name = "执行部门")
    private String executiveArm;

    /** 执行人 */
    @Excel(name = "执行人")
    private String executor;

    /** 已执行 */
    @Excel(name = "已执行")
    private String executed;

    /** 执行岗位 */
    @Excel(name = "执行岗位")
    private String performJobs;

    /** 备注 */
    @Excel(name = "备注")
    private String arrangementRemark;

    /** 设备保养计划id */
    @Excel(name = "设备保养计划id")
    private Long planId;
    
    /** 设备保养计划表 */
    @Excel(name = "设备保养计划表")
    private HyMaintenanceplan hyMaintenanceplan;

    /** 设备类别id */
    @Excel(name = "设备类别id")
    private Long equipmentId;
    
    /** 设备类别表 */
    @Excel(name = "设备类别表")
    private HyEquipment hyEquipment;

    /** 设备保养登记id */
    @Excel(name = "设备保养登记id")
    private Long registrationId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaintenanceProject(String maintenanceProject) 
    {
        this.maintenanceProject = maintenanceProject;
    }

    public String getMaintenanceProject() 
    {
        return maintenanceProject;
    }
    public void setMaintenanceRequirements(String maintenanceRequirements) 
    {
        this.maintenanceRequirements = maintenanceRequirements;
    }

    public String getMaintenanceRequirements() 
    {
        return maintenanceRequirements;
    }
    public void setExecutionDate(Date executionDate) 
    {
        this.executionDate = executionDate;
    }

    public Date getExecutionDate() 
    {
        return executionDate;
    }
    public void setFinishDate(Date finishDate) 
    {
        this.finishDate = finishDate;
    }

    public Date getFinishDate() 
    {
        return finishDate;
    }
    public void setExecutiveProject(String executiveProject) 
    {
        this.executiveProject = executiveProject;
    }

    public String getExecutiveProject() 
    {
        return executiveProject;
    }
    public void setExecutiveArm(String executiveArm) 
    {
        this.executiveArm = executiveArm;
    }

    public String getExecutiveArm() 
    {
        return executiveArm;
    }
    public void setExecutor(String executor) 
    {
        this.executor = executor;
    }

    public String getExecutor() 
    {
        return executor;
    }
    public void setExecuted(String executed) 
    {
        this.executed = executed;
    }

    public String getExecuted() 
    {
        return executed;
    }
    public void setPerformJobs(String performJobs) 
    {
        this.performJobs = performJobs;
    }

    public String getPerformJobs() 
    {
        return performJobs;
    }
    public void setArrangementRemark(String arrangementRemark) 
    {
        this.arrangementRemark = arrangementRemark;
    }

    public String getArrangementRemark() 
    {
        return arrangementRemark;
    }
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }
    public void setRegistrationId(Long registrationId) 
    {
        this.registrationId = registrationId;
    }

    public Long getRegistrationId() 
    {
        return registrationId;
    }

    public HyMaintenanceplan getHyMaintenanceplan() {
		return hyMaintenanceplan;
	}

	public void setHyMaintenanceplan(HyMaintenanceplan hyMaintenanceplan) {
		this.hyMaintenanceplan = hyMaintenanceplan;
	}

	public HyEquipment getHyEquipment() {
		return hyEquipment;
	}

	public void setHyEquipment(HyEquipment hyEquipment) {
		this.hyEquipment = hyEquipment;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("maintenanceProject", getMaintenanceProject())
            .append("maintenanceRequirements", getMaintenanceRequirements())
            .append("executionDate", getExecutionDate())
            .append("finishDate", getFinishDate())
            .append("executiveProject", getExecutiveProject())
            .append("executiveArm", getExecutiveArm())
            .append("executor", getExecutor())
            .append("executed", getExecuted())
            .append("performJobs", getPerformJobs())
            .append("arrangementRemark", getArrangementRemark())
            .append("planId", getPlanId())
            .append("equipmentId", getEquipmentId())
            .append("registrationId", getRegistrationId())
            .append("hyMaintenanceplan", getHyMaintenanceplan())
            .append("hyEquipment", getHyEquipment())
            .toString();
    }
}
