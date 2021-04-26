package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 接收员对象 hy_specimen
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public class HySpecimen extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 接收员id */
    private Long id;

    /** 员工id */
    @Excel(name = "员工id")
    private Long employeeId;

    /** 员工表 */
    @Excel(name = "员工表")
    private SysUser sysUser;
    
    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;
    
    /** 部门表 */
    @Excel(name = "部门表")
    private SysDept sysDept;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEmployeeId(Long employeeId) 
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() 
    {
        return employeeId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }


	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysDept getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	@Override
	public String toString() {
		return "HySpecimen [id=" + id + ", employeeId=" + employeeId + ", sysUser=" + sysUser + ", deptId=" + deptId
				+ ", sysDept=" + sysDept + "]";
	}


	
}
