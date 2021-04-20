package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料对象 hy_material
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public class HyMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料id */
    private Long id;

    /** 物料编号 */
    @Excel(name = "物料编号")
    private Long materialCode;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materialName;

    /** 物料类型 */
    @Excel(name = "物料类型")
    private String materialType;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String materialUnit;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long materialNumber;

    /** 储存位置 */
    @Excel(name = "储存位置")
    private String materialAddress;

    /** 入库部门 */
    @Excel(name = "入库部门")
    private String materialDept;

    /** 供应商 */
    @Excel(name = "供应商")
    private String materialSupplier;

    /** 上交采购单据 */
    @Excel(name = "上交采购单据")
    private String materialCommute;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterialCode(Long materialCode) 
    {
        this.materialCode = materialCode;
    }

    public Long getMaterialCode() 
    {
        return materialCode;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setMaterialType(String materialType) 
    {
        this.materialType = materialType;
    }

    public String getMaterialType() 
    {
        return materialType;
    }
    public void setMaterialUnit(String materialUnit) 
    {
        this.materialUnit = materialUnit;
    }

    public String getMaterialUnit() 
    {
        return materialUnit;
    }
    public void setMaterialNumber(Long materialNumber) 
    {
        this.materialNumber = materialNumber;
    }

    public Long getMaterialNumber() 
    {
        return materialNumber;
    }
    public void setMaterialAddress(String materialAddress) 
    {
        this.materialAddress = materialAddress;
    }

    public String getMaterialAddress() 
    {
        return materialAddress;
    }
    public void setMaterialDept(String materialDept) 
    {
        this.materialDept = materialDept;
    }

    public String getMaterialDept() 
    {
        return materialDept;
    }
    public void setMaterialSupplier(String materialSupplier) 
    {
        this.materialSupplier = materialSupplier;
    }

    public String getMaterialSupplier() 
    {
        return materialSupplier;
    }
    public void setMaterialCommute(String materialCommute) 
    {
        this.materialCommute = materialCommute;
    }

    public String getMaterialCommute() 
    {
        return materialCommute;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialCode", getMaterialCode())
            .append("materialName", getMaterialName())
            .append("materialType", getMaterialType())
            .append("materialUnit", getMaterialUnit())
            .append("materialNumber", getMaterialNumber())
            .append("materialAddress", getMaterialAddress())
            .append("materialDept", getMaterialDept())
            .append("materialSupplier", getMaterialSupplier())
            .append("materialCommute", getMaterialCommute())
            .append("createTime", getCreateTime())
            .append("state", getState())
            .toString();
    }
}
