package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 保养设备对象 hy_maintenanceequipment
 * 
 * @author Administrator
 * @date 2021-05-12
 */
public class HyMaintenanceequipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 保养设备id */
    private Long id;

    /** 保养设备型号 */
    @Excel(name = "保养设备型号")
    private String maintenanceequipmentType;

    /** 保养设备规格 */
    @Excel(name = "保养设备规格")
    private String maintenanceequipmentSpecification;

    /** 保养设备单位 */
    @Excel(name = "保养设备单位")
    private String maintenanceequipmentUnit;

    /** 存放位置 */
    @Excel(name = "存放位置")
    private String maintenanceequipmentPlace;

    /** 设备类别id/附属设备 */
    @Excel(name = "设备类别id/附属设备")
    private Long equipmentId;
    
    /** 设备类别表 */
    @Excel(name = "设备类别表")
    private HyEquipment hyEquipment;
    
    /** 设备保养计划id */
    @Excel(name = "设备保养计划id")
    private Long planId;
    
    /** 设备保养表 */
    @Excel(name = "设备保养表")
    private HyMaintenanceplan hyMaintenanceplan;

    /** 设备保养登记id */
    @Excel(name = "设备保养登记id")
    private Long registrationId;
    
    /** 设备保养登记表 */
    @Excel(name = "设备保养登记表")
    private HyMaintenanceregistration hyMaintenanceregistration;
    
    /** 设备档案id */
    @Excel(name = "设备档案id")
    private Long archivesId;
    
    /** 设备档案表 */
    @Excel(name = "设备档案表")
    private HyEquipmentArchives hyEquipmentArchives;

    /** 当前周期 */
    @Excel(name = "当前周期")
    private String currentCycle;

    /** 当前年限 */
    @Excel(name = "当前年限")
    private String currentYear;

    /** 调整年限 */
    @Excel(name = "调整年限")
    private String adjustmentYear;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaintenanceequipmentType(String maintenanceequipmentType) 
    {
        this.maintenanceequipmentType = maintenanceequipmentType;
    }

    public String getMaintenanceequipmentType() 
    {
        return maintenanceequipmentType;
    }
    public void setMaintenanceequipmentSpecification(String maintenanceequipmentSpecification) 
    {
        this.maintenanceequipmentSpecification = maintenanceequipmentSpecification;
    }

    public String getMaintenanceequipmentSpecification() 
    {
        return maintenanceequipmentSpecification;
    }
    public void setMaintenanceequipmentUnit(String maintenanceequipmentUnit) 
    {
        this.maintenanceequipmentUnit = maintenanceequipmentUnit;
    }

    public String getMaintenanceequipmentUnit() 
    {
        return maintenanceequipmentUnit;
    }
    public void setMaintenanceequipmentPlace(String maintenanceequipmentPlace) 
    {
        this.maintenanceequipmentPlace = maintenanceequipmentPlace;
    }

    public String getMaintenanceequipmentPlace() 
    {
        return maintenanceequipmentPlace;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setRegistrationId(Long registrationId) 
    {
        this.registrationId = registrationId;
    }

    public Long getRegistrationId() 
    {
        return registrationId;
    }
    
    public Long getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(Long archivesId) {
		this.archivesId = archivesId;
	}

	public void setCurrentCycle(String currentCycle) 
    {
        this.currentCycle = currentCycle;
    }

    public String getCurrentCycle() 
    {
        return currentCycle;
    }
    public void setCurrentYear(String currentYear) 
    {
        this.currentYear = currentYear;
    }

    public String getCurrentYear() 
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

    public HyMaintenanceplan getHyMaintenanceplan() {
		return hyMaintenanceplan;
	}

	public void setHyMaintenanceplan(HyMaintenanceplan hyMaintenanceplan) {
		this.hyMaintenanceplan = hyMaintenanceplan;
	}

	public HyMaintenanceregistration getHyMaintenanceregistration() {
		return hyMaintenanceregistration;
	}

	public void setHyMaintenanceregistration(HyMaintenanceregistration hyMaintenanceregistration) {
		this.hyMaintenanceregistration = hyMaintenanceregistration;
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

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("maintenanceequipmentType", getMaintenanceequipmentType())
            .append("maintenanceequipmentSpecification", getMaintenanceequipmentSpecification())
            .append("maintenanceequipmentUnit", getMaintenanceequipmentUnit())
            .append("maintenanceequipmentPlace", getMaintenanceequipmentPlace())
            .append("equipmentId", getEquipmentId())
            .append("planId", getPlanId())
            .append("registrationId", getRegistrationId())
            .append("archivesId", getArchivesId())
            .append("currentCycle", getCurrentCycle())
            .append("currentYear", getCurrentYear())
            .append("adjustmentYear", getAdjustmentYear())
            .append("hyMaintenanceplan", getHyMaintenanceplan())
            .append("hyMaintenanceregistration", getHyMaintenanceregistration())
            .append("hyEquipmentArchives", getHyEquipmentArchives())
            .append("hyEquipment", getHyEquipment())
            .toString();
    }
}
