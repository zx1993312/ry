package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 保养单位对象 hy_maintenanceunit
 * 
 * @author Administrator
 * @date 2021-05-11
 */
public class HyMaintenanceunit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 保养单位id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String unitName;

    /** 地址 */
    @Excel(name = "地址")
    private String unitAddress;

    /** 联系人 */
    @Excel(name = "联系人")
    private String unitContact;

    /** 电话 */
    @Excel(name = "电话")
    private String unitPhone;

    /** 手机 */
    @Excel(name = "手机")
    private String unitCellphone;

    /** 传真 */
    @Excel(name = "传真")
    private String unitFax;

    /** 邮编 */
    @Excel(name = "邮编")
    private String unitPostcode;

    /** 备注 */
    @Excel(name = "备注")
    private String unitRemark;

    /** 组织机构id */
    @Excel(name = "组织机构id")
    private Long deptId;
    
    /** 项目id */
    @Excel(name = "项目id")
    private Long parentId;
    
    /** 物业id */
    @Excel(name = "物业id")
    private Long propertyId;
    
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
    public void setUnitName(String unitName) 
    {
        this.unitName = unitName;
    }

    public String getUnitName() 
    {
        return unitName;
    }
    public void setUnitAddress(String unitAddress) 
    {
        this.unitAddress = unitAddress;
    }

    public String getUnitAddress() 
    {
        return unitAddress;
    }
    public void setUnitContact(String unitContact) 
    {
        this.unitContact = unitContact;
    }

    public String getUnitContact() 
    {
        return unitContact;
    }
    public void setUnitPhone(String unitPhone) 
    {
        this.unitPhone = unitPhone;
    }

    public String getUnitPhone() 
    {
        return unitPhone;
    }
    public void setUnitCellphone(String unitCellphone) 
    {
        this.unitCellphone = unitCellphone;
    }

    public String getUnitCellphone() 
    {
        return unitCellphone;
    }
    public void setUnitFax(String unitFax) 
    {
        this.unitFax = unitFax;
    }

    public String getUnitFax() 
    {
        return unitFax;
    }
    public void setUnitPostcode(String unitPostcode) 
    {
        this.unitPostcode = unitPostcode;
    }

    public String getUnitPostcode() 
    {
        return unitPostcode;
    }
    public void setUnitRemark(String unitRemark) 
    {
        this.unitRemark = unitRemark;
    }

    public String getUnitRemark() 
    {
        return unitRemark;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
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
            .append("unitName", getUnitName())
            .append("unitAddress", getUnitAddress())
            .append("unitContact", getUnitContact())
            .append("unitPhone", getUnitPhone())
            .append("unitCellphone", getUnitCellphone())
            .append("unitFax", getUnitFax())
            .append("unitPostcode", getUnitPostcode())
            .append("unitRemark", getUnitRemark())
            .append("deptId", getDeptId())
            .append("parentId", getParentId())
            .append("propertyId", getPropertyId())
            .append("sysDept", getSysDept())
            .toString();
    }
}
