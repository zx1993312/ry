package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 组团登记对象 hy_group_registration
 * 
 * @author Administrator
 * @date 2021-02-02
 */
public class HyGroupRegistration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 组团id */
    private Long id;

    /** 组团区域名称 */
    @Excel(name = "组团区域名称")
    private String groupAreaName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGroupAreaName(String groupAreaName) 
    {
        this.groupAreaName = groupAreaName;
    }

    public String getGroupAreaName() 
    {
        return groupAreaName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupAreaName", getGroupAreaName())
            .toString();
    }
}
