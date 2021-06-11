package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库对象 hy_warehouse
 * 
 * @author Administrator
 * @date 2021-06-11
 */
public class HyWarehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String warehouseName;

    /** 仓库地址 */
    @Excel(name = "仓库地址")
    private String warehouseAddress;

    /** 仓库类型 */
    @Excel(name = "仓库类型")
    private String warehouseType;

    /** 仓库面积 */
    @Excel(name = "仓库面积")
    private Long warehouseArea;

    /** 仓库编号 */
    @Excel(name = "仓库编号")
    private Long warehouseNum;

    /** 仓库电话 */
    @Excel(name = "仓库电话")
    private Long warehousePhone;

    /** 管理员 */
    @Excel(name = "管理员")
    private String administrators;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWarehouseName(String warehouseName) 
    {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName() 
    {
        return warehouseName;
    }
    public void setWarehouseAddress(String warehouseAddress) 
    {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehouseAddress() 
    {
        return warehouseAddress;
    }
    public void setWarehouseType(String warehouseType) 
    {
        this.warehouseType = warehouseType;
    }

    public String getWarehouseType() 
    {
        return warehouseType;
    }
    public void setWarehouseArea(Long warehouseArea) 
    {
        this.warehouseArea = warehouseArea;
    }

    public Long getWarehouseArea() 
    {
        return warehouseArea;
    }
    public void setWarehouseNum(Long warehouseNum) 
    {
        this.warehouseNum = warehouseNum;
    }

    public Long getWarehouseNum() 
    {
        return warehouseNum;
    }
    public void setWarehousePhone(Long warehousePhone) 
    {
        this.warehousePhone = warehousePhone;
    }

    public Long getWarehousePhone() 
    {
        return warehousePhone;
    }
    public void setAdministrators(String administrators) 
    {
        this.administrators = administrators;
    }

    public String getAdministrators() 
    {
        return administrators;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("warehouseName", getWarehouseName())
            .append("warehouseAddress", getWarehouseAddress())
            .append("warehouseType", getWarehouseType())
            .append("warehouseArea", getWarehouseArea())
            .append("warehouseNum", getWarehouseNum())
            .append("warehousePhone", getWarehousePhone())
            .append("administrators", getAdministrators())
            .toString();
    }
}
