package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 运行参数对象 hy_operating_parameter
 * 
 * @author Administrator
 * @date 2021-05-10
 */
public class HyOperatingParameter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 运行参数id */
    private Long id;

    /** 设备运行参数项 */
    @Excel(name = "设备运行参数项")
    private String operationParameter;

    /** 临界值 */
    @Excel(name = "临界值")
    private String criticalValue;

    /** 是否为必录项 */
    @Excel(name = "是否为必录项")
    private String isRequired;

    /** 设备类型id */
    @Excel(name = "设备类型id")
    private Long equipmentId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOperationParameter(String operationParameter) 
    {
        this.operationParameter = operationParameter;
    }

    public String getOperationParameter() 
    {
        return operationParameter;
    }
    public void setCriticalValue(String criticalValue) 
    {
        this.criticalValue = criticalValue;
    }

    public String getCriticalValue() 
    {
        return criticalValue;
    }
    public void setIsRequired(String isRequired) 
    {
        this.isRequired = isRequired;
    }

    public String getIsRequired() 
    {
        return isRequired;
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
            .append("operationParameter", getOperationParameter())
            .append("criticalValue", getCriticalValue())
            .append("isRequired", getIsRequired())
            .append("equipmentId", getEquipmentId())
            .toString();
    }
}
