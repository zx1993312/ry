package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出库管理对象 hy_delivery
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public class HyDelivery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出库管理id */
    private Long id;

    /** 出库编号 */
    @Excel(name = "出库编号")
    private Long deliveryCode;

    /** 领取人 */
    @Excel(name = "领取人")
    private String deliveryReceiver;

    /** 领取部门 */
    @Excel(name = "领取部门")
    private String deliveryDept;

    /** 经办人 */
    @Excel(name = "经办人")
    private String deliveryOperator;

    /** 审核部门 */
    @Excel(name = "审核部门")
    private String operatorAuditDept;

    /** 审核人 */
    @Excel(name = "审核人")
    private String operatorAuditPerson;

    /** 物料类型 */
    @Excel(name = "物料类型")
    private String operatorType;

    /** 物料用途 */
    @Excel(name = "物料用途")
    private String operatorUse;

    /** 领取数量 */
    @Excel(name = "领取数量")
    private Long operatorNumber;

    /** 提料人id */
    @Excel(name = "提料人id")
    private Long liftingId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeliveryCode(Long deliveryCode) 
    {
        this.deliveryCode = deliveryCode;
    }

    public Long getDeliveryCode() 
    {
        return deliveryCode;
    }
    public void setDeliveryReceiver(String deliveryReceiver) 
    {
        this.deliveryReceiver = deliveryReceiver;
    }

    public String getDeliveryReceiver() 
    {
        return deliveryReceiver;
    }
    public void setDeliveryDept(String deliveryDept) 
    {
        this.deliveryDept = deliveryDept;
    }

    public String getDeliveryDept() 
    {
        return deliveryDept;
    }
    public void setDeliveryOperator(String deliveryOperator) 
    {
        this.deliveryOperator = deliveryOperator;
    }

    public String getDeliveryOperator() 
    {
        return deliveryOperator;
    }
    public void setOperatorAuditDept(String operatorAuditDept) 
    {
        this.operatorAuditDept = operatorAuditDept;
    }

    public String getOperatorAuditDept() 
    {
        return operatorAuditDept;
    }
    public void setOperatorAuditPerson(String operatorAuditPerson) 
    {
        this.operatorAuditPerson = operatorAuditPerson;
    }

    public String getOperatorAuditPerson() 
    {
        return operatorAuditPerson;
    }
    public void setOperatorType(String operatorType) 
    {
        this.operatorType = operatorType;
    }

    public String getOperatorType() 
    {
        return operatorType;
    }
    public void setOperatorUse(String operatorUse) 
    {
        this.operatorUse = operatorUse;
    }

    public String getOperatorUse() 
    {
        return operatorUse;
    }
    public void setOperatorNumber(Long operatorNumber) 
    {
        this.operatorNumber = operatorNumber;
    }

    public Long getOperatorNumber() 
    {
        return operatorNumber;
    }
    public void setLiftingId(Long liftingId) 
    {
        this.liftingId = liftingId;
    }

    public Long getLiftingId() 
    {
        return liftingId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deliveryCode", getDeliveryCode())
            .append("deliveryReceiver", getDeliveryReceiver())
            .append("deliveryDept", getDeliveryDept())
            .append("deliveryOperator", getDeliveryOperator())
            .append("operatorAuditDept", getOperatorAuditDept())
            .append("operatorAuditPerson", getOperatorAuditPerson())
            .append("operatorType", getOperatorType())
            .append("operatorUse", getOperatorUse())
            .append("operatorNumber", getOperatorNumber())
            .append("createTime", getCreateTime())
            .append("liftingId", getLiftingId())
            .toString();
    }
}
