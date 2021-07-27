package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品规格对象 hy_commercial_specification
 * 
 * @author Administrator
 * @date 2021-07-26
 */
public class HyCommercialSpecification extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品规格id */
    private Long id;

    /** 规格名称 */
    @Excel(name = "规格名称")
    private String specification;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSpecification(String specification) 
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("specification", getSpecification())
            .toString();
    }
}
