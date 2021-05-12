package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备保养物料对象 hy_maintenancesupplies
 * 
 * @author Administrator
 * @date 2021-05-12
 */
public class HyMaintenancesupplies extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备保养物料id */
    private Long id;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String suppliesName;
    
    /** 物料规格 */
    @Excel(name = "物料规格")
    private String suppliesSpecification;

    /** 物料品牌 */
    @Excel(name = "物料品牌")
    private String suppliesBrand;

    /** 物料数量 */
    @Excel(name = "物料数量")
    private String suppliesCount;

    /** 物料单价 */
    @Excel(name = "物料单价")
    private BigDecimal suppliesPrice;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String suppliesMeasurement;

    /** 物料用途 */
    @Excel(name = "物料用途")
    private String suppliesUse;

    /** 金额 */
    @Excel(name = "金额")
    private String money;

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

    /** 设备保养计划id */
    @Excel(name = "设备保养计划id")
    private Long planId;
    
    /** 设备保养计划表 */
    @Excel(name = "设备保养计划表")
    private HyMaintenanceplan hyMaintenanceplan;

    /** 设备保养登记id */
    @Excel(name = "设备保养登记id")
    private Long registrationId;
    
    /** 设备保养登记表 */
    @Excel(name = "设备保养登记表")
    private HyMaintenanceregistration hyMaintenanceregistration;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSuppliesSpecification(String suppliesSpecification) 
    {
        this.suppliesSpecification = suppliesSpecification;
    }

    public String getSuppliesSpecification() 
    {
        return suppliesSpecification;
    }
    public void setSuppliesBrand(String suppliesBrand) 
    {
        this.suppliesBrand = suppliesBrand;
    }

    public String getSuppliesBrand() 
    {
        return suppliesBrand;
    }
    public void setSuppliesCount(String suppliesCount) 
    {
        this.suppliesCount = suppliesCount;
    }

    public String getSuppliesCount() 
    {
        return suppliesCount;
    }
    public void setSuppliesPrice(BigDecimal suppliesPrice) 
    {
        this.suppliesPrice = suppliesPrice;
    }

    public BigDecimal getSuppliesPrice() 
    {
        return suppliesPrice;
    }
    public void setSuppliesMeasurement(String suppliesMeasurement) 
    {
        this.suppliesMeasurement = suppliesMeasurement;
    }

    public String getSuppliesMeasurement() 
    {
        return suppliesMeasurement;
    }
    public void setSuppliesUse(String suppliesUse) 
    {
        this.suppliesUse = suppliesUse;
    }

    public String getSuppliesUse() 
    {
        return suppliesUse;
    }
    public void setMoney(String money) 
    {
        this.money = money;
    }

    public String getMoney() 
    {
        return money;
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

    public String getSuppliesName() {
		return suppliesName;
	}

	public void setSuppliesName(String suppliesName) {
		this.suppliesName = suppliesName;
	}

	public HyEquipmentArchives getHyEquipmentArchives() {
		return hyEquipmentArchives;
	}

	public void setHyEquipmentArchives(HyEquipmentArchives hyEquipmentArchives) {
		this.hyEquipmentArchives = hyEquipmentArchives;
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
            .append("suppliesName", getSuppliesName())
            .append("suppliesSpecification", getSuppliesSpecification())
            .append("suppliesBrand", getSuppliesBrand())
            .append("suppliesCount", getSuppliesCount())
            .append("suppliesPrice", getSuppliesPrice())
            .append("suppliesMeasurement", getSuppliesMeasurement())
            .append("suppliesUse", getSuppliesUse())
            .append("money", getMoney())
            .append("archivesId", getArchivesId())
            .append("equipmentId", getEquipmentId())
            .append("planId", getPlanId())
            .append("registrationId", getRegistrationId())
            .append("hyEquipmentArchives", getHyEquipmentArchives())
            .append("hyMaintenanceplan", getHyMaintenanceplan())
            .append("hyMaintenanceregistration", getHyMaintenanceregistration())
            .append("hyEquipment", getHyEquipment())
            .toString();
    }
}
