package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检测设备对象 hy_detectionequipment
 * 
 * @author Administrator
 * @date 2021-05-14
 */
public class HyDetectionequipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 检测设备id */
    private Long id;

    /** 型号 */
    @Excel(name = "型号")
    private String detectionType;

    /** 规格 */
    @Excel(name = "规格")
    private String detectionSpecification;

    /** 单位 */
    @Excel(name = "单位")
    private String detectionUnit;

    /** 最小值 */
    @Excel(name = "最小值")
    private String min;

    /** 最大值 */
    @Excel(name = "最大值")
    private String max;

    /** 实测值 */
    @Excel(name = "实测值")
    private String measuredValue;

    /** 设备档案id */
    @Excel(name = "设备档案id")
    private Long archivesId;
    
    /** 设备档案表 */
    @Excel(name = "设备档案表")
    private HyEquipmentArchives hyEquipmentArchives;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDetectionType(String detectionType) 
    {
        this.detectionType = detectionType;
    }

    public String getDetectionType() 
    {
        return detectionType;
    }
    public void setDetectionSpecification(String detectionSpecification) 
    {
        this.detectionSpecification = detectionSpecification;
    }

    public String getDetectionSpecification() 
    {
        return detectionSpecification;
    }
    public void setDetectionUnit(String detectionUnit) 
    {
        this.detectionUnit = detectionUnit;
    }

    public String getDetectionUnit() 
    {
        return detectionUnit;
    }
    public void setMin(String min) 
    {
        this.min = min;
    }

    public String getMin() 
    {
        return min;
    }
    public void setMax(String max) 
    {
        this.max = max;
    }

    public String getMax() 
    {
        return max;
    }
    public void setMeasuredValue(String measuredValue) 
    {
        this.measuredValue = measuredValue;
    }

    public String getMeasuredValue() 
    {
        return measuredValue;
    }
    public void setArchivesId(Long archivesId) 
    {
        this.archivesId = archivesId;
    }

    public Long getArchivesId() 
    {
        return archivesId;
    }

    public HyEquipmentArchives getHyEquipmentArchives() {
		return hyEquipmentArchives;
	}

	public void setHyEquipmentArchives(HyEquipmentArchives hyEquipmentArchives) {
		this.hyEquipmentArchives = hyEquipmentArchives;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("detectionType", getDetectionType())
            .append("detectionSpecification", getDetectionSpecification())
            .append("detectionUnit", getDetectionUnit())
            .append("min", getMin())
            .append("max", getMax())
            .append("measuredValue", getMeasuredValue())
            .append("archivesId", getArchivesId())
            .append("hyEquipmentArchives", getHyEquipmentArchives())
            .toString();
    }
}
