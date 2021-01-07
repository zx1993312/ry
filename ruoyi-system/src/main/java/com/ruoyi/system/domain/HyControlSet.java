package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.annotation.EnumAnn;
import com.ruoyi.system.enums.ControlEnum;

/**
 * 管控模型设置对象 hy_control_set
 * 
 * @author Administrator
 * @date 2021-01-07
 */
public class HyControlSet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 收费科目是否需要审核 */
    @Excel(name = "收费科目是否需要审核")
    @EnumAnn(enumClass=ControlEnum.class,enumType="Integer")
    private Integer chargeSubjectApproved;

    /** 交房状态修改生效时间 */
    @Excel(name = "交房状态修改生效时间")
    @EnumAnn(enumClass=ControlEnum.class,enumType="Integer")
    private Integer deliveryEffectiveTime;

    /** 有欠费时是否允许预存 */
    @Excel(name = "有欠费时是否允许预存")
    @EnumAnn(enumClass=ControlEnum.class,enumType="Integer")
    private Integer depositArrearsAllowed;

    /** 预存是否允许部分冲抵 */
    @Excel(name = "预存是否允许部分冲抵")
    @EnumAnn(enumClass=ControlEnum.class,enumType="Integer")
    private Integer partialOffsetAllowed;

    /** 票号是否使用系统票号 */
    @Excel(name = "票号是否使用系统票号")
    @EnumAnn(enumClass=ControlEnum.class,enumType="Integer")
    private Integer systemTicketnumNot;

    /** 零头结转取整位数 */
    @Excel(name = "零头结转取整位数")
    @EnumAnn(enumClass=ControlEnum.class,enumType="Integer")
    private Integer oddCarryForward;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setChargeSubjectApproved(Integer chargeSubjectApproved) 
    {
        this.chargeSubjectApproved = chargeSubjectApproved;
    }

    public Integer getChargeSubjectApproved() 
    {
        return chargeSubjectApproved;
    }
    public void setDeliveryEffectiveTime(Integer deliveryEffectiveTime) 
    {
        this.deliveryEffectiveTime = deliveryEffectiveTime;
    }

    public Integer getDeliveryEffectiveTime() 
    {
        return deliveryEffectiveTime;
    }
    public void setDepositArrearsAllowed(Integer depositArrearsAllowed) 
    {
        this.depositArrearsAllowed = depositArrearsAllowed;
    }

    public Integer getDepositArrearsAllowed() 
    {
        return depositArrearsAllowed;
    }
    public void setPartialOffsetAllowed(Integer partialOffsetAllowed) 
    {
        this.partialOffsetAllowed = partialOffsetAllowed;
    }

    public Integer getPartialOffsetAllowed() 
    {
        return partialOffsetAllowed;
    }
    public void setSystemTicketnumNot(Integer systemTicketnumNot) 
    {
        this.systemTicketnumNot = systemTicketnumNot;
    }

    public Integer getSystemTicketnumNot() 
    {
        return systemTicketnumNot;
    }
    public void setOddCarryForward(Integer oddCarryForward) 
    {
        this.oddCarryForward = oddCarryForward;
    }

    public Integer getOddCarryForward() 
    {
        return oddCarryForward;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("chargeSubjectApproved", getChargeSubjectApproved())
            .append("deliveryEffectiveTime", getDeliveryEffectiveTime())
            .append("depositArrearsAllowed", getDepositArrearsAllowed())
            .append("partialOffsetAllowed", getPartialOffsetAllowed())
            .append("systemTicketnumNot", getSystemTicketnumNot())
            .append("oddCarryForward", getOddCarryForward())
            .toString();
    }
}
