package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 审核管理对象 hy_assessor
 * 
 * @author Administrator
 * @date 2021-04-21
 */
public class HyAssessor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 审核管理id */
    private Long id;

    /** 物料id */
    @Excel(name = "物料id")
    private Long materialId;
    
    /** 物料表 */
    @Excel(name = "物料表")
    private HyMaterial hyMaterial;
    
    /** 接收员id */
    @Excel(name = "接收员id")
    private Long specimenId;
    
    /** 接收员表 */
    @Excel(name = "接收员表")
    private HySpecimen hySpecimen;
    
    /** 盘点管理表 */
    @Excel(name = "盘点管理表")
    private HyInventory hyInventory;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }

    public HyMaterial getHyMaterial() {
		return hyMaterial;
	}

	public void setHyMaterial(HyMaterial hyMaterial) {
		this.hyMaterial = hyMaterial;
	}

	public Long getSpecimenId() {
		return specimenId;
	}

	public void setSpecimenId(Long specimenId) {
		this.specimenId = specimenId;
	}

	public HySpecimen getHySpecimen() {
		return hySpecimen;
	}

	public void setHySpecimen(HySpecimen hySpecimen) {
		this.hySpecimen = hySpecimen;
	}

	public HyInventory getHyInventory() {
		return hyInventory;
	}

	public void setHyInventory(HyInventory hyInventory) {
		this.hyInventory = hyInventory;
	}

	@Override
	public String toString() {
		return "HyAssessor [id=" + id + ", materialId=" + materialId + ", hyMaterial=" + hyMaterial + ", specimenId="
				+ specimenId + ", hySpecimen=" + hySpecimen + ", hyInventory=" + hyInventory + "]";
	}

	

	

	
}
