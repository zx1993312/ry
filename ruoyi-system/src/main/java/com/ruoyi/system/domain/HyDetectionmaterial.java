package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备检测物料对象 hy_detectionmaterial
 * 
 * @author Administrator
 * @date 2021-05-14
 */
public class HyDetectionmaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备检测物料id */
    private Long id;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materialName;

    /** 物料数量 */
    @Excel(name = "物料数量")
    private String materialCount;

    /** 物料价格 */
    @Excel(name = "物料价格")
    private BigDecimal materialPrice;

    /** 物料金额 */
    @Excel(name = "物料金额")
    private String materialMoney;

    /** 物料品牌 */
    @Excel(name = "物料品牌")
    private String materialBrand;

    /** 物料型号 */
    @Excel(name = "物料型号")
    private String materialType;
    
    /** 物料用途 */
    @Excel(name = "物料用途")
    private String materialUse;

    /** 设备类别id */
    @Excel(name = "设备类别id")
    private Long equipmentId;
    
    /** 设备类别表 */
    @Excel(name = "设备类别表")
    private HyEquipment hyEquipment;

    /** 检测登记id */
    @Excel(name = "检测登记id")
    private Long registerId;
    
    /** 检测登记表 */
    @Excel(name = "检测登记表")
    private HyDetectionregister hyDetectionregister;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setMaterialCount(String materialCount) 
    {
        this.materialCount = materialCount;
    }

    public String getMaterialCount() 
    {
        return materialCount;
    }
    public void setMaterialPrice(BigDecimal materialPrice) 
    {
        this.materialPrice = materialPrice;
    }

    public BigDecimal getMaterialPrice() 
    {
        return materialPrice;
    }
    public void setMaterialMoney(String materialMoney) 
    {
        this.materialMoney = materialMoney;
    }

    public String getMaterialMoney() 
    {
        return materialMoney;
    }
    public void setMaterialBrand(String materialBrand) 
    {
        this.materialBrand = materialBrand;
    }

    public String getMaterialBrand() 
    {
        return materialBrand;
    }
    public void setMaterialType(String materialType) 
    {
        this.materialType = materialType;
    }

    public String getMaterialType() 
    {
        return materialType;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }
    public void setRegisterId(Long registerId) 
    {
        this.registerId = registerId;
    }

    public Long getRegisterId() 
    {
        return registerId;
    }

    public String getMaterialUse() {
		return materialUse;
	}

	public void setMaterialUse(String materialUse) {
		this.materialUse = materialUse;
	}

	public HyEquipment getHyEquipment() {
		return hyEquipment;
	}

	public void setHyEquipment(HyEquipment hyEquipment) {
		this.hyEquipment = hyEquipment;
	}

	public HyDetectionregister getHyDetectionregister() {
		return hyDetectionregister;
	}

	public void setHyDetectionregister(HyDetectionregister hyDetectionregister) {
		this.hyDetectionregister = hyDetectionregister;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialName", getMaterialName())
            .append("materialCount", getMaterialCount())
            .append("materialPrice", getMaterialPrice())
            .append("materialMoney", getMaterialMoney())
            .append("materialBrand", getMaterialBrand())
            .append("materialType", getMaterialType())
            .append("materialUse", getMaterialUse())
            .append("equipmentId", getEquipmentId())
            .append("registerId", getRegisterId())
            .append("hyEquipment", getHyEquipment())
            .append("hyDetectionregister", getHyDetectionregister())
            .toString();
    }
}
