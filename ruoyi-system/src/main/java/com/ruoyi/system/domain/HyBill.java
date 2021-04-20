package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 台账管理物料列对象 hy_bill
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public class HyBill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 台账物料列表id */
    private Long id;

    /** 物料列表编号 */
    @Excel(name = "物料列表编号")
    private Long billCode;

    /** 物料类型 */
    @Excel(name = "物料类型")
    private String materialType;

    /** 物料用途 */
    @Excel(name = "物料用途")
    private String materialUse;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long materialNumber;

    /** 是否在库 */
    @Excel(name = "是否在库")
    private String state;

    /** 物料id */
    @Excel(name = "物料id")
    private Long materialId;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String materrialAudit;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBillCode(Long billCode) 
    {
        this.billCode = billCode;
    }

    public Long getBillCode() 
    {
        return billCode;
    }
    public void setMaterialType(String materialType) 
    {
        this.materialType = materialType;
    }

    public String getMaterialType() 
    {
        return materialType;
    }
    public void setMaterialUse(String materialUse) 
    {
        this.materialUse = materialUse;
    }

    public String getMaterialUse() 
    {
        return materialUse;
    }
    public void setMaterialNumber(Long materialNumber) 
    {
        this.materialNumber = materialNumber;
    }

    public Long getMaterialNumber() 
    {
        return materialNumber;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setMaterrialAudit(String materrialAudit) 
    {
        this.materrialAudit = materrialAudit;
    }

    public String getMaterrialAudit() 
    {
        return materrialAudit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("billCode", getBillCode())
            .append("materialType", getMaterialType())
            .append("materialUse", getMaterialUse())
            .append("materialNumber", getMaterialNumber())
            .append("state", getState())
            .append("materialId", getMaterialId())
            .append("materrialAudit", getMaterrialAudit())
            .toString();
    }
}
