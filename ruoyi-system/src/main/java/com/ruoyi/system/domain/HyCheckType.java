package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 巡检类型对象 hy_check_type
 * 
 * @author Administrator
 * @date 2021-07-20
 */
public class HyCheckType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡检类型id */
    private Long id;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String checkType;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCheckType(String checkType) 
    {
        this.checkType = checkType;
    }

    public String getCheckType() 
    {
        return checkType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("checkType", getCheckType())
            .toString();
    }
}
