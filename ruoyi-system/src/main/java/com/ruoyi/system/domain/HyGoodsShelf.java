package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 货架对象 hy_goods_shelf
 * 
 * @author Administrator
 * @date 2021-06-21
 */
public class HyGoodsShelf extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 货架id */
    private Long id;

    /** 货架名称 */
    @Excel(name = "货架名称")
    private String shelfName;

    /** 货架类型 */
    @Excel(name = "货架类型")
    private String shelfType;

    /** 货架数量 */
    @Excel(name = "货架数量")
    private String shelfCount;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long warehouseId;
    
    /** 仓库表 */
    @Excel(name = "仓库表")
    private HyWarehouse hyWarehouse;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShelfName(String shelfName) 
    {
        this.shelfName = shelfName;
    }

    public String getShelfName() 
    {
        return shelfName;
    }
    public void setShelfType(String shelfType) 
    {
        this.shelfType = shelfType;
    }

    public String getShelfType() 
    {
        return shelfType;
    }
    public void setShelfCount(String shelfCount) 
    {
        this.shelfCount = shelfCount;
    }

    public String getShelfCount() 
    {
        return shelfCount;
    }
    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }

    public HyWarehouse getHyWarehouse() {
		return hyWarehouse;
	}

	public void setHyWarehouse(HyWarehouse hyWarehouse) {
		this.hyWarehouse = hyWarehouse;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shelfName", getShelfName())
            .append("shelfType", getShelfType())
            .append("shelfCount", getShelfCount())
            .append("warehouseId", getWarehouseId())
            .append("hyWarehouse", getHyWarehouse())
            .toString();
    }
}
