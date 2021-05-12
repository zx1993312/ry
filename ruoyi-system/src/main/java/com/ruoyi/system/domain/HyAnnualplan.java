package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 年度保养计划对象 hy_annualplan
 * 
 * @author Administrator
 * @date 2021-05-12
 */
public class HyAnnualplan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 年度保养计划id */
    private Long id;

    /** 单据号 */
    @Excel(name = "单据号")
    private Long documentNumber;

    /** 年份 */
    @Excel(name = "年份")
    private String year;

    /** 是否显示全部设备 */
    @Excel(name = "是否显示全部设备")
    private String isSelect;

    /** 是否审核 */
    @Excel(name = "是否审核")
    private String isAudit;

    /** 组织机构id */
    @Excel(name = "组织机构id")
    private Long deptId;
    
    /** 组织机构表 */
    @Excel(name = "组织机构表")
    private SysDept sysDept;

    /** 设备类别id */
    @Excel(name = "设备类别id")
    private Long equipmentId;
    
    /** 设备类别表 */
    @Excel(name = "设备类别表")
    private HyEquipment hyEquipment;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDocumentNumber(Long documentNumber) 
    {
        this.documentNumber = documentNumber;
    }

    public Long getDocumentNumber() 
    {
        return documentNumber;
    }
    public void setYear(String year) 
    {
        this.year = year;
    }

    public String getYear() 
    {
        return year;
    }
    public void setIsSelect(String isSelect) 
    {
        this.isSelect = isSelect;
    }

    public String getIsSelect() 
    {
        return isSelect;
    }
    public void setIsAudit(String isAudit) 
    {
        this.isAudit = isAudit;
    }

    public String getIsAudit() 
    {
        return isAudit;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }

    public SysDept getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}


	public HyEquipment getHyEquipment() {
		return hyEquipment;
	}

	public void setHyEquipment(HyEquipment hyEquipment) {
		this.hyEquipment = hyEquipment;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("documentNumber", getDocumentNumber())
            .append("year", getYear())
            .append("isSelect", getIsSelect())
            .append("isAudit", getIsAudit())
            .append("deptId", getDeptId())
            .append("equipmentId", getEquipmentId())
            .append("sysDept", getSysDept())
            .append("hyEquipment", getHyEquipment())
            .toString();
    }
}
