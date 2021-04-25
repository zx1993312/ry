package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 巡检结果对象 hy_inspection_result
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public class HyInspectionResult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡检结果id */
    private Long id;

    /** 巡检结果名称 */
    @Excel(name = "巡检结果名称")
    private String name;

    /** 巡检类别 */
    @Excel(name = "巡检类别")
    private String type;

    /** 是否正常 */
    @Excel(name = "是否正常")
    private String normal;

    /** 说明 */
    @Excel(name = "说明")
    private String explains;

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
    public void setNormal(String normal) 
    {
        this.normal = normal;
    }

    public String getNormal() 
    {
        return normal;
    }
    public void setExplains(String explains) 
    {
        this.explains = explains;
    }

    public String getExplains() 
    {
        return explains;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("type", getType())
            .append("normal", getNormal())
            .append("explains", getExplains())
            .toString();
    }
}
