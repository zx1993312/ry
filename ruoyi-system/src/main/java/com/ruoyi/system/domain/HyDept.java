package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 部门对象 hy_dept
 * 
 * @author Administrator
 * @date 2021-04-14
 */
public class HyDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门id */
    private Long id;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

    /** 负责人 */
    @Excel(name = "负责人")
    private String leader;

    /** 物业id */
    @Excel(name = "物业id")
    private Long propertyId;
    
    /** 物业表 */
    @Excel(name = "物业表")
    private HyProperty hyProperty;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setLeader(String leader) 
    {
        this.leader = leader;
    }

    public String getLeader() 
    {
        return leader;
    }
    public void setPropertyId(Long propertyId) 
    {
        this.propertyId = propertyId;
    }

    public Long getPropertyId() 
    {
        return propertyId;
    }

    public HyProperty getHyProperty() {
		return hyProperty;
	}

	public void setHyProperty(HyProperty hyProperty) {
		this.hyProperty = hyProperty;
	}

	@Override
	public String toString() {
		return "HyDept [id=" + id + ", deptName=" + deptName + ", leader=" + leader + ", propertyId=" + propertyId
				+ ", hyProperty=" + hyProperty + "]";
	}

	
}
