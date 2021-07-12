package com.ruoyi.system.domain;

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

    /** 物料id */
    @Excel(name = "物料id")
    private Long materialId;
    
    /** 物料表 */
    @Excel(name = "物料表")
    private HyMaterial hyMaterial;
    
    /** 盘点员id */
    @Excel(name = "盘点员id")
    private Long checkId;
    
    /** 盘点员表 */
    @Excel(name = "盘点员表")
    private HyCheck hyCheck;

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
	
	public Long getCheckId() {
		return checkId;
	}

	public void setCheckId(Long checkId) {
		this.checkId = checkId;
	}
	

	public HyCheck getHyCheck() {
		return hyCheck;
	}

	public void setHyCheck(HyCheck hyCheck) {
		this.hyCheck = hyCheck;
	}

	@Override
	public String toString() {
		return "HyInventory [id=" + id + ", materialId=" + materialId + ", hyMaterial=" + hyMaterial + ", checkId="
				+ checkId + ", hyCheck=" + hyCheck + "]";
	}


	

	

    
}
