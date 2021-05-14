package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备维修物料对象 hy_servicemateriel
 * 
 * @author Administrator
 * @date 2021-05-13
 */
public class HyServicemateriel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备维修物料id */
    private Long id;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materielName;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String materielType;

    /** 物料品牌 */
    @Excel(name = "物料品牌")
    private String materielBrand;

    /** 物料数量 */
    @Excel(name = "物料数量")
    private String materielCount;

    /** 物料单价 */
    @Excel(name = "物料单价")
    private BigDecimal materielPrice;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String measuringUnit;

    /** 物料金额 */
    @Excel(name = "物料金额")
    private String materielMoney;

    /** 物料用途 */
    @Excel(name = "物料用途")
    private String materielUse;

    /** 设备维修登记id */
    @Excel(name = "设备维修登记id")
    private Long registrationId;
    
    /** 设备维修登记表 */
    @Excel(name = "设备维修登记表")
    private HyServiceregistration hyServiceregistration;

    /** 设备类别id */
    @Excel(name = "设备类别id")
    private Long equipmentId;
    
    /** 设备类别表 */
    @Excel(name = "设备类别表")
    private HyEquipment hyEquipment;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterielName(String materielName) 
    {
        this.materielName = materielName;
    }

    public String getMaterielName() 
    {
        return materielName;
    }
    public void setMaterielType(String materielType) 
    {
        this.materielType = materielType;
    }

    public String getMaterielType() 
    {
        return materielType;
    }
    public void setMaterielBrand(String materielBrand) 
    {
        this.materielBrand = materielBrand;
    }

    public String getMaterielBrand() 
    {
        return materielBrand;
    }
    public void setMaterielCount(String materielCount) 
    {
        this.materielCount = materielCount;
    }

    public String getMaterielCount() 
    {
        return materielCount;
    }
    public void setMaterielPrice(BigDecimal materielPrice) 
    {
        this.materielPrice = materielPrice;
    }

    public BigDecimal getMaterielPrice() 
    {
        return materielPrice;
    }
    public void setMeasuringUnit(String measuringUnit) 
    {
        this.measuringUnit = measuringUnit;
    }

    public String getMeasuringUnit() 
    {
        return measuringUnit;
    }
    public void setMaterielMoney(String materielMoney) 
    {
        this.materielMoney = materielMoney;
    }

    public String getMaterielMoney() 
    {
        return materielMoney;
    }
    public void setMaterielUse(String materielUse) 
    {
        this.materielUse = materielUse;
    }

    public String getMaterielUse() 
    {
        return materielUse;
    }
    public void setRegistrationId(Long registrationId) 
    {
        this.registrationId = registrationId;
    }

    public Long getRegistrationId() 
    {
        return registrationId;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }

    public HyServiceregistration getHyServiceregistration() {
		return hyServiceregistration;
	}

	public void setHyServiceregistration(HyServiceregistration hyServiceregistration) {
		this.hyServiceregistration = hyServiceregistration;
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
            .append("materielName", getMaterielName())
            .append("materielType", getMaterielType())
            .append("materielBrand", getMaterielBrand())
            .append("materielCount", getMaterielCount())
            .append("materielPrice", getMaterielPrice())
            .append("measuringUnit", getMeasuringUnit())
            .append("materielMoney", getMaterielMoney())
            .append("materielUse", getMaterielUse())
            .append("registrationId", getRegistrationId())
            .append("equipmentId", getEquipmentId())
            .append("hyServiceregistration", getHyServiceregistration())
            .append("hyEquipment", getHyEquipment())
            .toString();
    }
}
