package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 减免原因设置对象 hy_exemption_reason
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public class HyExemptionReason extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 减免类别 */
    @Excel(name = "减免类别")
    private String exemptionCategory;

    /** 减免原因 */
    @Excel(name = "减免原因")
    private String exemptionReason;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setExemptionCategory(String exemptionCategory) 
    {
        this.exemptionCategory = exemptionCategory;
    }

    public String getExemptionCategory() 
    {
        return exemptionCategory;
    }
    public void setExemptionReason(String exemptionReason) 
    {
        this.exemptionReason = exemptionReason;
    }

    public String getExemptionReason() 
    {
        return exemptionReason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("exemptionCategory", getExemptionCategory())
            .append("exemptionReason", getExemptionReason())
            .toString();
    }
}
