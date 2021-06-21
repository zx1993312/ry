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
    
    /** 物料规格 */
    @Excel(name = "物料规格")
    private String materialSpecification;

    /** 物料单位 */
    @Excel(name = "物料单位")
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

    /** 上交采购单据 */
    @Excel(name = "上交采购单据")
    private String materialCommute;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String state;
    
    /** 审核人 */
    @Excel(name = "审核人")
    private String specimen;
    
    /** 审核部门 */
    @Excel(name = "审核部门")
    private String specimendept;
    
    /** 盘点人 */
    @Excel(name = "盘点人")
    private String checkmen;
    
    /** 审核管理id */
    @Excel(name = "审核管理id")
    private Long assessorId;
    
    /** 供应商id */
    @Excel(name = "供应商id")
    private Long supplierId;
    
    /** 供应商表 */
    @Excel(name = "供应商表")
    private HySupplier hySupplier;
    
    /** 仓库id */
    @Excel(name = "仓库id")
    private Long warehouseId;
    
    /** 仓库表 */
    @Excel(name = "仓库表")
    private HyWarehouse hyWarehouse;
    
    /** 货架id */
    @Excel(name = "货架id")
    private Long shelfId;
    
    /** 货架表 */
    @Excel(name = "货架表")
    private HyGoodsShelf hyGoodsShelf;

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
    
    public String getMaterialSpecification() {
		return materialSpecification;
	}

	public void setMaterialSpecification(String materialSpecification) {
		this.materialSpecification = materialSpecification;
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

	public String getSpecimen() {
		return specimen;
	}

	public void setSpecimen(String specimen) {
		this.specimen = specimen;
	}

	public String getSpecimendept() {
		return specimendept;
	}

	public void setSpecimendept(String specimendept) {
		this.specimendept = specimendept;
	}

	public String getCheckmen() {
		return checkmen;
	}

	public void setCheckmen(String checkmen) {
		this.checkmen = checkmen;
	}

	public Long getAssessorId() {
		return assessorId;
	}

	public void setAssessorId(Long assessorId) {
		this.assessorId = assessorId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public HySupplier getHySupplier() {
		return hySupplier;
	}

	public void setHySupplier(HySupplier hySupplier) {
		this.hySupplier = hySupplier;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public HyWarehouse getHyWarehouse() {
		return hyWarehouse;
	}

	public void setHyWarehouse(HyWarehouse hyWarehouse) {
		this.hyWarehouse = hyWarehouse;
	}

	public Long getShelfId() {
		return shelfId;
	}

	public void setShelfId(Long shelfId) {
		this.shelfId = shelfId;
	}

	public HyGoodsShelf getHyGoodsShelf() {
		return hyGoodsShelf;
	}

	public void setHyGoodsShelf(HyGoodsShelf hyGoodsShelf) {
		this.hyGoodsShelf = hyGoodsShelf;
	}

	@Override
	public String toString() {
		return "HyMaterial [id=" + id + ", materialCode=" + materialCode + ", materialName=" + materialName
				+ ", materialType=" + materialType + ", materialSpecification=" + materialSpecification
				+ ", materialUnit=" + materialUnit + ", materialNumber=" + materialNumber + ", materialAddress="
				+ materialAddress + ", materialDept=" + materialDept + ", materialCommute=" + materialCommute
				+ ", state=" + state + ", specimen=" + specimen + ", specimendept=" + specimendept + ", checkmen="
				+ checkmen + ", assessorId=" + assessorId + ", supplierId=" + supplierId + ", hySupplier=" + hySupplier
				+ ", warehouseId=" + warehouseId + ", hyWarehouse=" + hyWarehouse + ", shelfId=" + shelfId
				+ ", hyGoodsShelf=" + hyGoodsShelf + "]";
	}






	

	

	

	
}
