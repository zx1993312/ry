package com.ruoyi.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出入库记录对象 hy_stock_record
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public class HyStockRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出入库记录id */
    private Long id;

    /** 入库次数 */
    @Excel(name = "入库次数")
    private Long warehouseNumber;

    /** 出库次数 */
    @Excel(name = "出库次数")
    private Long outboundNumber;

    /** 入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date warehouseTime;

    /** 出库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date outboundTime;

    /** 供应商是否在库 */
    @Excel(name = "供应商是否在库")
    private String state;

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
    public void setWarehouseNumber(Long warehouseNumber) 
    {
        this.warehouseNumber = warehouseNumber;
    }

    public Long getWarehouseNumber() 
    {
        return warehouseNumber;
    }
    public void setOutboundNumber(Long outboundNumber) 
    {
        this.outboundNumber = outboundNumber;
    }

    public Long getOutboundNumber() 
    {
        return outboundNumber;
    }
    public void setWarehouseTime(Date warehouseTime) 
    {
        this.warehouseTime = warehouseTime;
    }

    public Date getWarehouseTime() 
    {
        return warehouseTime;
    }
    public void setOutboundTime(Date outboundTime) 
    {
        this.outboundTime = outboundTime;
    }

    public Date getOutboundTime() 
    {
        return outboundTime;
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
    
    public HyMaterial getHyMaterial() {
		return hyMaterial;
	}

	public void setHyMaterial(HyMaterial hyMaterial) {
		this.hyMaterial = hyMaterial;
	}

	@Override
	public String toString() {
		return "HyStockRecord [id=" + id + ", warehouseNumber=" + warehouseNumber + ", outboundNumber=" + outboundNumber
				+ ", warehouseTime=" + warehouseTime + ", outboundTime=" + outboundTime + ", state=" + state
				+ ", materialId=" + materialId + ", hyMaterial=" + hyMaterial + "]";
	}


}
