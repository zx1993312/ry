package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工对象 hy_employee
 * 
 * @author Administrator
 * @date 2021-04-14
 */
public class HyEmployee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工id */
    private Long id;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String employeeName;
    
    /** 员工电话 */
    @Excel(name = "员工电话")
    private String employeePhone;

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
    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() 
    {
        return employeeName;
    }
    
    public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

	public HyDept getHyDept() {
		return hyDept;
	}

	public void setHyDept(HyDept hyDept) {
		this.hyDept = hyDept;
	}

	@Override
	public String toString() {
		return "HyEmployee [id=" + id + ", employeeName=" + employeeName + ", employeePhone=" + employeePhone
				+ ", deptId=" + deptId + ", hyDept=" + hyDept + "]";
	}

	
    
}
