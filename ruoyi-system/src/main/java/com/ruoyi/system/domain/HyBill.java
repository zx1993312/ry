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
    private String billCode;

    /** 物料用途 */
    @Excel(name = "物料用途")
    private String materialUse;

    /** 是否在库 */
    @Excel(name = "是否在库")
    private String isStock;
    
    /** 是否在库 */
    @Excel(name = "是否在库")
    private String time;

    /** 物料id */
    @Excel(name = "物料id")
    private Long materialId;
    
    /** 物料表 */
    @Excel(name = "物料表")
    private HyMaterial hyMaterial;
    

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBillCode(String billCode) 
    {
        this.billCode = billCode;
    }

    public String getBillCode() 
    {
        return billCode;
    }
    public void setMaterialUse(String materialUse) 
    {
        this.materialUse = materialUse;
    }

    public String getMaterialUse() 
    {
        return materialUse;
    }
    
    

    public String getIsStock() {
		return isStock;
	}

	public void setIsStock(String isStock) {
		this.isStock = isStock;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	@Override
	public String toString() {
		return "HyBill [id=" + id + ", billCode=" + billCode + ", materialUse=" + materialUse + ", isStock=" + isStock
				+ ", time=" + time + ", materialId=" + materialId + ", hyMaterial=" + hyMaterial + "]";
	}



	

	
	

	

	
}
