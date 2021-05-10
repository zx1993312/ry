package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检测参数对象 hy_testparameter
 * 
 * @author Administrator
 * @date 2021-05-10
 */
public class HyTestparameter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 检测参数id */
    private Long id;

    /** 检测参数名称 */
    @Excel(name = "检测参数名称")
    private String parameterName;

    /** 参数值 */
    @Excel(name = "参数值")
    private String parameterValues;

    /** 最小值 */
    @Excel(name = "最小值")
    private String leastValue;

    /** 最大值 */
    @Excel(name = "最大值")
    private String maximumValue;

    /** 备注 */
    @Excel(name = "备注")
    private String parameterRemark;

    /** 设备档案id */
    @Excel(name = "设备档案id")
    private Long archivesId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setParameterName(String parameterName) 
    {
        this.parameterName = parameterName;
    }

    public String getParameterName() 
    {
        return parameterName;
    }
    public void setParameterValues(String parameterValues) 
    {
        this.parameterValues = parameterValues;
    }

    public String getParameterValues() 
    {
        return parameterValues;
    }
    public void setLeastValue(String leastValue) 
    {
        this.leastValue = leastValue;
    }

    public String getLeastValue() 
    {
        return leastValue;
    }
    public void setMaximumValue(String maximumValue) 
    {
        this.maximumValue = maximumValue;
    }

    public String getMaximumValue() 
    {
        return maximumValue;
    }
    public void setParameterRemark(String parameterRemark) 
    {
        this.parameterRemark = parameterRemark;
    }

    public String getParameterRemark() 
    {
        return parameterRemark;
    }
    public void setArchivesId(Long archivesId) 
    {
        this.archivesId = archivesId;
    }

    public Long getArchivesId() 
    {
        return archivesId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parameterName", getParameterName())
            .append("parameterValues", getParameterValues())
            .append("leastValue", getLeastValue())
            .append("maximumValue", getMaximumValue())
            .append("parameterRemark", getParameterRemark())
            .append("archivesId", getArchivesId())
            .toString();
    }
}
