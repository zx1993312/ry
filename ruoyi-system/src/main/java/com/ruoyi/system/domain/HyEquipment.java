package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 设备类别对象 hy_equipment
 * 
 * @author Administrator
 * @date 2021-05-08
 */
public class HyEquipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备类别id */
    private Long id;

    /** 父设备id */
    @Excel(name = "父设备id")
    private Long parentId;

    /** 设备类别代码 */
    @Excel(name = "设备类别代码")
    private String equipmentCode;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 设备说明 */
    @Excel(name = "设备说明")
    private String equipmentExplains;

    /** 是否明细 */
    @Excel(name = "是否明细")
    private String equipmentDetail;

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
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setEquipmentCode(String equipmentCode) 
    {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentCode() 
    {
        return equipmentCode;
    }
    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }
    public void setEquipmentExplains(String equipmentExplains) 
    {
        this.equipmentExplains = equipmentExplains;
    }

    public String getEquipmentExplains() 
    {
        return equipmentExplains;
    }
    public void setEquipmentDetail(String equipmentDetail) 
    {
        this.equipmentDetail = equipmentDetail;
    }

    public String getEquipmentDetail() 
    {
        return equipmentDetail;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
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
            .append("parentId", getParentId())
            .append("equipmentCode", getEquipmentCode())
            .append("equipmentName", getEquipmentName())
            .append("equipmentExplains", getEquipmentExplains())
            .append("equipmentDetail", getEquipmentDetail())
            .append("deptId", getDeptId())
            .append("sysDept", getSysDept())
            .toString();
    }
}
