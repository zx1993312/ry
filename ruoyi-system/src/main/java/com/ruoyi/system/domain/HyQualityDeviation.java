package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 品质异常对象 hy_quality_deviation
 * 
 * @author Administrator
 * @date 2021-07-13
 */
public class HyQualityDeviation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 品质异常表id */
    private Long id;

    /** 异常名称 */
    @Excel(name = "异常名称")
    private String deviationName;

    /** 异常描述 */
    @Excel(name = "异常描述")
    private String deviationDescribe;

    /** 异常图片 */
    @Excel(name = "异常图片")
    private String deviationPicture;

    /** 审核人 */
    @Excel(name = "审核人")
    private String deviationAuditor;

    /** 状态 */
    @Excel(name = "状态")
    private String deviationStatus;

    /** 拒绝原因 */
    @Excel(name = "拒绝原因")
    private String refusalReason;

    /** 通过原因 */
    @Excel(name = "通过原因")
    private String throughReason;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviationName(String deviationName) 
    {
        this.deviationName = deviationName;
    }

    public String getDeviationName() 
    {
        return deviationName;
    }
    public void setDeviationDescribe(String deviationDescribe) 
    {
        this.deviationDescribe = deviationDescribe;
    }

    public String getDeviationDescribe() 
    {
        return deviationDescribe;
    }
    public void setDeviationPicture(String deviationPicture) 
    {
        this.deviationPicture = deviationPicture;
    }

    public String getDeviationPicture() 
    {
        return deviationPicture;
    }
    public void setDeviationAuditor(String deviationAuditor) 
    {
        this.deviationAuditor = deviationAuditor;
    }

    public String getDeviationAuditor() 
    {
        return deviationAuditor;
    }
    public void setDeviationStatus(String deviationStatus) 
    {
        this.deviationStatus = deviationStatus;
    }

    public String getDeviationStatus() 
    {
        return deviationStatus;
    }
    public void setRefusalReason(String refusalReason) 
    {
        this.refusalReason = refusalReason;
    }

    public String getRefusalReason() 
    {
        return refusalReason;
    }
    public void setThroughReason(String throughReason) 
    {
        this.throughReason = throughReason;
    }

    public String getThroughReason() 
    {
        return throughReason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviationName", getDeviationName())
            .append("deviationDescribe", getDeviationDescribe())
            .append("deviationPicture", getDeviationPicture())
            .append("deviationAuditor", getDeviationAuditor())
            .append("deviationStatus", getDeviationStatus())
            .append("refusalReason", getRefusalReason())
            .append("throughReason", getThroughReason())
            .toString();
    }
}
