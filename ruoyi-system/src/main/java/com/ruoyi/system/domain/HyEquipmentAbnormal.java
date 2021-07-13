package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备异常对象 hy_equipment_abnormal
 * 
 * @author Administrator
 * @date 2021-07-13
 */
public class HyEquipmentAbnormal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备异常表id */
    private Long id;

    /** 异常名称 */
    @Excel(name = "异常名称")
    private String abnormalName;

    /** 异常描述 */
    @Excel(name = "异常描述")
    private String abnormalDescribe;

    /** 异常图片 */
    @Excel(name = "异常图片")
    private String abnormalPicture;

    /** 审核人 */
    @Excel(name = "审核人")
    private String abnormalAuditor;

    /** 状态 */
    @Excel(name = "状态")
    private String abnormalStatus;

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
    public void setAbnormalName(String abnormalName) 
    {
        this.abnormalName = abnormalName;
    }

    public String getAbnormalName() 
    {
        return abnormalName;
    }
    public void setAbnormalDescribe(String abnormalDescribe) 
    {
        this.abnormalDescribe = abnormalDescribe;
    }

    public String getAbnormalDescribe() 
    {
        return abnormalDescribe;
    }
    public void setAbnormalPicture(String abnormalPicture) 
    {
        this.abnormalPicture = abnormalPicture;
    }

    public String getAbnormalPicture() 
    {
        return abnormalPicture;
    }
    public void setAbnormalAuditor(String abnormalAuditor) 
    {
        this.abnormalAuditor = abnormalAuditor;
    }

    public String getAbnormalAuditor() 
    {
        return abnormalAuditor;
    }
    public void setAbnormalStatus(String abnormalStatus) 
    {
        this.abnormalStatus = abnormalStatus;
    }

    public String getAbnormalStatus() 
    {
        return abnormalStatus;
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
            .append("abnormalName", getAbnormalName())
            .append("abnormalDescribe", getAbnormalDescribe())
            .append("abnormalPicture", getAbnormalPicture())
            .append("abnormalAuditor", getAbnormalAuditor())
            .append("abnormalStatus", getAbnormalStatus())
            .append("refusalReason", getRefusalReason())
            .append("throughReason", getThroughReason())
            .toString();
    }
}
