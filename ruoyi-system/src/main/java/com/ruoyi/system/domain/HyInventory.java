package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 盘点管理对象 hy_inventory
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public class HyInventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 盘点管理id */
    private Long id;

    /** 物料编号 */
    @Excel(name = "物料编号")
    private Long materialCode;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private Long materialName;

    /** 物料类型 */
    @Excel(name = "物料类型")
    private String materialType;

    /** 存储位置 */
    @Excel(name = "存储位置")
    private String materialAddress;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long materialNumber;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String state;

    /** 物料id */
    @Excel(name = "物料id")
    private Long materialId;

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
    public void setMaterialName(Long materialName) 
    {
        this.materialName = materialName;
    }

    public Long getMaterialName() 
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
    public void setMaterialAddress(String materialAddress) 
    {
        this.materialAddress = materialAddress;
    }

    public String getMaterialAddress() 
    {
        return materialAddress;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialCode", getMaterialCode())
            .append("materialName", getMaterialName())
            .append("materialType", getMaterialType())
            .append("materialAddress", getMaterialAddress())
            .append("materialNumber", getMaterialNumber())
            .append("state", getState())
            .append("materialId", getMaterialId())
            .toString();
    }
}
