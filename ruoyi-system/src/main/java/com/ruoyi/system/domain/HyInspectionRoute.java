package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 巡检线路对象 hy_inspection_route
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public class HyInspectionRoute extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡检线路id */
    private Long id;

    /** 巡检线路名称 */
    @Excel(name = "巡检线路名称")
    private String routeName;

    /** 巡检类别 */
    @Excel(name = "巡检类别")
    private String type;

    /** 巡检计划id */
    @Excel(name = "巡检计划id")
    private Long schemeId;

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
    public void setRouteName(String routeName) 
    {
        this.routeName = routeName;
    }

    public String getRouteName() 
    {
        return routeName;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setSchemeId(Long schemeId) 
    {
        this.schemeId = schemeId;
    }

    public Long getSchemeId() 
    {
        return schemeId;
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
            .append("routeName", getRouteName())
            .append("type", getType())
            .append("remark", getRemark())
            .append("schemeId", getSchemeId())
            .append("deptId", getDeptId())
            .append("parentId", getParentId())
            .append("propertyId", getPropertyId())
            .append("sysDept", getSysDept())
            .toString();
    }
}
