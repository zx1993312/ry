package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

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
    private HyEmployee hyEmployee;
    
    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;
    
    /** 部门表 */
    @Excel(name = "部门表")
    private HyDept hyDept;

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

    public HyEmployee getHyEmployee() {
		return hyEmployee;
	}

	public void setHyEmployee(HyEmployee hyEmployee) {
		this.hyEmployee = hyEmployee;
	}

	public HyDept getHyDept() {
		return hyDept;
	}

	public void setHyDept(HyDept hyDept) {
		this.hyDept = hyDept;
	}

	@Override
	public String toString() {
		return "HySpecimen [id=" + id + ", employeeId=" + employeeId + ", hyEmployee=" + hyEmployee + ", deptId="
				+ deptId + ", hyDept=" + hyDept + "]";
	}

	
}
