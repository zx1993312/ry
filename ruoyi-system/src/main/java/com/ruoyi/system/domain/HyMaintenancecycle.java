package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备保养周期对象 hy_maintenancecycle
 * 
 * @author Administrator
 * @date 2021-05-11
 */
public class HyMaintenancecycle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备保养周期id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String cycleName;

    /** 说明 */
    @Excel(name = "说明")
    private String cycleExplains;

    /** 预设数据 */
    @Excel(name = "预设数据")
    private String defaultData;

    /** 保养周期类型名 */
    @Excel(name = "保养周期类型名")
    private String cycleType;

    /** 周期值 */
    @Excel(name = "周期值")
    private String periodicQuantity;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCycleName(String cycleName) 
    {
        this.cycleName = cycleName;
    }

    public String getCycleName() 
    {
        return cycleName;
    }
    public void setCycleExplains(String cycleExplains) 
    {
        this.cycleExplains = cycleExplains;
    }

    public String getCycleExplains() 
    {
        return cycleExplains;
    }
    public void setDefaultData(String defaultData) 
    {
        this.defaultData = defaultData;
    }

    public String getDefaultData() 
    {
        return defaultData;
    }
    public void setCycleType(String cycleType) 
    {
        this.cycleType = cycleType;
    }

    public String getCycleType() 
    {
        return cycleType;
    }
    public void setPeriodicQuantity(String periodicQuantity) 
    {
        this.periodicQuantity = periodicQuantity;
    }

    public String getPeriodicQuantity() 
    {
        return periodicQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cycleName", getCycleName())
            .append("cycleExplains", getCycleExplains())
            .append("defaultData", getDefaultData())
            .append("cycleType", getCycleType())
            .append("periodicQuantity", getPeriodicQuantity())
            .toString();
    }
}
