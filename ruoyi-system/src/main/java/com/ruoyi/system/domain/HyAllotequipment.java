package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 调拨设备对象 hy_allotequipment
 * 
 * @author Administrator
 * @date 2021-05-17
 */
public class HyAllotequipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 调拨设备id */
    private Long id;

    /** 调拨型号 */
    @Excel(name = "调拨型号")
    private String allotType;

    /** 资产编号 */
    @Excel(name = "资产编号")
    private String assetNumber;

    /** 生产厂家 */
    @Excel(name = "生产厂家")
    private String manufactureFactory;

    /** 数量 */
    @Excel(name = "数量")
    private String allotCount;

    /** 启用日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "启用日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commissioningDate;

    /** 资产原值 */
    @Excel(name = "资产原值")
    private String assetValue;

    /** 资产净值 */
    @Excel(name = "资产净值")
    private String netValue;

    /** 备注 */
    @Excel(name = "备注")
    private String allotRemark;

    /** 设备档案id */
    @Excel(name = "设备档案id")
    private Long archivesId;
    
    /** 设备档案表 */
    @Excel(name = "设备档案表")
    private HyEquipmentArchives hyEquipmentArchives;

    /** 组织机构id */
    @Excel(name = "组织机构id")
    private Long deptId;
    
    /** 组织机构表 */
    @Excel(name = "组织机构表")
    private SysDept sysDept;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAllotType(String allotType) 
    {
        this.allotType = allotType;
    }

    public String getAllotType() 
    {
        return allotType;
    }
    public void setAssetNumber(String assetNumber) 
    {
        this.assetNumber = assetNumber;
    }

    public String getAssetNumber() 
    {
        return assetNumber;
    }
    public void setManufactureFactory(String manufactureFactory) 
    {
        this.manufactureFactory = manufactureFactory;
    }

    public String getManufactureFactory() 
    {
        return manufactureFactory;
    }
    public void setAllotCount(String allotCount) 
    {
        this.allotCount = allotCount;
    }

    public String getAllotCount() 
    {
        return allotCount;
    }
    public void setCommissioningDate(Date commissioningDate) 
    {
        this.commissioningDate = commissioningDate;
    }

    public Date getCommissioningDate() 
    {
        return commissioningDate;
    }
    public void setAssetValue(String assetValue) 
    {
        this.assetValue = assetValue;
    }

    public String getAssetValue() 
    {
        return assetValue;
    }
    public void setNetValue(String netValue) 
    {
        this.netValue = netValue;
    }

    public String getNetValue() 
    {
        return netValue;
    }
    public void setAllotRemark(String allotRemark) 
    {
        this.allotRemark = allotRemark;
    }

    public String getAllotRemark() 
    {
        return allotRemark;
    }
    public void setArchivesId(Long archivesId) 
    {
        this.archivesId = archivesId;
    }

    public Long getArchivesId() 
    {
        return archivesId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public HyEquipmentArchives getHyEquipmentArchives() {
		return hyEquipmentArchives;
	}

	public void setHyEquipmentArchives(HyEquipmentArchives hyEquipmentArchives) {
		this.hyEquipmentArchives = hyEquipmentArchives;
	}

	public SysDept getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("allotType", getAllotType())
            .append("assetNumber", getAssetNumber())
            .append("manufactureFactory", getManufactureFactory())
            .append("allotCount", getAllotCount())
            .append("commissioningDate", getCommissioningDate())
            .append("assetValue", getAssetValue())
            .append("netValue", getNetValue())
            .append("allotRemark", getAllotRemark())
            .append("archivesId", getArchivesId())
            .append("deptId", getDeptId())
            .append("hyEquipmentArchives", getHyEquipmentArchives())
            .append("sysDept", getSysDept())
            .toString();
    }
}
