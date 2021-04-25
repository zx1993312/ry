package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 巡检周期对象 hy_polling_period
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public class HyPollingPeriod extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡检周期id */
    private Long id;

    /** 巡检周期名称 */
    @Excel(name = "巡检周期名称")
    private String name;

    /** 巡检周期类型 */
    @Excel(name = "巡检周期类型")
    private String type;

    /** 间隔值 */
    @Excel(name = "间隔值")
    private String intervalValue;

    /** 是否启动 */
    @Excel(name = "是否启动")
    private String isStart;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setIntervalValue(String intervalValue) 
    {
        this.intervalValue = intervalValue;
    }

    public String getIntervalValue() 
    {
        return intervalValue;
    }
    public void setIsStart(String isStart) 
    {
        this.isStart = isStart;
    }

    public String getIsStart() 
    {
        return isStart;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("type", getType())
            .append("intervalValue", getIntervalValue())
            .append("isStart", getIsStart())
            .toString();
    }
}
