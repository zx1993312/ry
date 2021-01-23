package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收费比例设置对象 hy_proportion_set
 * 
 * @author Administrator
 * @date 2021-01-23
 */
public class HyProportionSet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 序号 */
    @Excel(name = "序号")
    private Long serialNum;

    /** 交房状态 */
    @Excel(name = "交房状态")
    private Integer deliveryStatus;

    /** 收费比例 */
    @Excel(name = "收费比例")
    private String chargeRatio;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 当前交房状态 */
    @Excel(name = "当前交房状态")
    private Integer deliveryCurrentStatus;

    /** 缴纳收费科目 */
    @Excel(name = "缴纳收费科目")
    private String chargeSubject;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSerialNum(Long serialNum) 
    {
        this.serialNum = serialNum;
    }

    public Long getSerialNum() 
    {
        return serialNum;
    }
    public void setDeliveryStatus(Integer deliveryStatus) 
    {
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getDeliveryStatus() 
    {
        return deliveryStatus;
    }
    public void setChargeRatio(String chargeRatio) 
    {
        this.chargeRatio = chargeRatio;
    }

    public String getChargeRatio() 
    {
        return chargeRatio;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setDeliveryCurrentStatus(Integer deliveryCurrentStatus) 
    {
        this.deliveryCurrentStatus = deliveryCurrentStatus;
    }

    public Integer getDeliveryCurrentStatus() 
    {
        return deliveryCurrentStatus;
    }
    public void setChargeSubject(String chargeSubject) 
    {
        this.chargeSubject = chargeSubject;
    }

    public String getChargeSubject() 
    {
        return chargeSubject;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("serialNum", getSerialNum())
            .append("deliveryStatus", getDeliveryStatus())
            .append("chargeRatio", getChargeRatio())
            .append("remarks", getRemarks())
            .append("deliveryCurrentStatus", getDeliveryCurrentStatus())
            .append("chargeSubject", getChargeSubject())
            .toString();
    }
}
