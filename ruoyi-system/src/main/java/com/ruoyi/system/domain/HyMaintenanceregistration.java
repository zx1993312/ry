package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备保养登记对象 hy_maintenanceregistration
 * 
 * @author Administrator
 * @date 2021-05-12
 */
public class HyMaintenanceregistration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备保养登记id */
    private Long id;

    /** 保养记录号 */
    @Excel(name = "保养记录号")
    private Long recordNumber;

    /** 保养类别 */
    @Excel(name = "保养类别")
    private String categories;

    /** 保养计划号 */
    @Excel(name = "保养计划号")
    private String planNumber;

    /** 专业部门 */
    @Excel(name = "专业部门")
    private String specializedDepartment;

    /** 计划开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 计划结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 保养内容 */
    @Excel(name = "保养内容")
    private String maintenanceContent;

    /** 当前保养内容 */
    @Excel(name = "当前保养内容")
    private String currentContent;

    /** 保养开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "保养开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 保养结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "保养结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 工时 */
    @Excel(name = "工时")
    private BigDecimal manHour;

    /** 负责人 */
    @Excel(name = "负责人")
    private String principal;

    /** 保养费用 */
    @Excel(name = "保养费用")
    private BigDecimal upkeepCost;

    /** 保养单位 */
    @Excel(name = "保养单位")
    private String upkeepUnit;

    /** 备注 */
    @Excel(name = "备注")
    private String registrationRemark;

    /** 保养完成情况 */
    @Excel(name = "保养完成情况")
    private String maintenanceCompletion;

    /** 是否有异常 */
    @Excel(name = "是否有异常")
    private String isUnusual;

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

    /** 员工id */
    @Excel(name = "员工id")
    private Long userId;

    /** 设备类别id */
    @Excel(name = "设备类别id")
    private Long equipmentId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRecordNumber(Long recordNumber) 
    {
        this.recordNumber = recordNumber;
    }

    public Long getRecordNumber() 
    {
        return recordNumber;
    }
    public void setCategories(String categories) 
    {
        this.categories = categories;
    }

    public String getCategories() 
    {
        return categories;
    }
    public void setPlanNumber(String planNumber) 
    {
        this.planNumber = planNumber;
    }

    public String getPlanNumber() 
    {
        return planNumber;
    }
    public void setSpecializedDepartment(String specializedDepartment) 
    {
        this.specializedDepartment = specializedDepartment;
    }

    public String getSpecializedDepartment() 
    {
        return specializedDepartment;
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
    public void setMaintenanceContent(String maintenanceContent) 
    {
        this.maintenanceContent = maintenanceContent;
    }

    public String getMaintenanceContent() 
    {
        return maintenanceContent;
    }
    public void setCurrentContent(String currentContent) 
    {
        this.currentContent = currentContent;
    }

    public String getCurrentContent() 
    {
        return currentContent;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setManHour(BigDecimal manHour) 
    {
        this.manHour = manHour;
    }

    public BigDecimal getManHour() 
    {
        return manHour;
    }
    public void setPrincipal(String principal) 
    {
        this.principal = principal;
    }

    public String getPrincipal() 
    {
        return principal;
    }
    public void setUpkeepCost(BigDecimal upkeepCost) 
    {
        this.upkeepCost = upkeepCost;
    }

    public BigDecimal getUpkeepCost() 
    {
        return upkeepCost;
    }
    public void setUpkeepUnit(String upkeepUnit) 
    {
        this.upkeepUnit = upkeepUnit;
    }

    public String getUpkeepUnit() 
    {
        return upkeepUnit;
    }
    public void setRegistrationRemark(String registrationRemark) 
    {
        this.registrationRemark = registrationRemark;
    }

    public String getRegistrationRemark() 
    {
        return registrationRemark;
    }
    public void setMaintenanceCompletion(String maintenanceCompletion) 
    {
        this.maintenanceCompletion = maintenanceCompletion;
    }

    public String getMaintenanceCompletion() 
    {
        return maintenanceCompletion;
    }
    public void setIsUnusual(String isUnusual) 
    {
        this.isUnusual = isUnusual;
    }

    public String getIsUnusual() 
    {
        return isUnusual;
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
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("recordNumber", getRecordNumber())
            .append("categories", getCategories())
            .append("planNumber", getPlanNumber())
            .append("specializedDepartment", getSpecializedDepartment())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("maintenanceContent", getMaintenanceContent())
            .append("currentContent", getCurrentContent())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("manHour", getManHour())
            .append("principal", getPrincipal())
            .append("upkeepCost", getUpkeepCost())
            .append("upkeepUnit", getUpkeepUnit())
            .append("registrationRemark", getRegistrationRemark())
            .append("maintenanceCompletion", getMaintenanceCompletion())
            .append("isUnusual", getIsUnusual())
            .append("receptionTime", getReceptionTime())
            .append("acceptor", getAcceptor())
            .append("inspectionAcceptance", getInspectionAcceptance())
            .append("problemRectification", getProblemRectification())
            .append("userId", getUserId())
            .append("equipmentId", getEquipmentId())
            .toString();
    }
}
