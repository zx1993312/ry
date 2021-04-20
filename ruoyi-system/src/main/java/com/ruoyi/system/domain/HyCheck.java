package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 盘点员对象 hy_check
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public class HyCheck extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 盘点员id */
    private Long id;

    /** 部门 */
    @Excel(name = "部门")
    private String dept;

    /** 工号 */
    @Excel(name = "工号")
    private String code;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 员工id */
    @Excel(name = "员工id")
    private Long employeeId;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDept(String dept) 
    {
        this.dept = dept;
    }

    public String getDept() 
    {
        return dept;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dept", getDept())
            .append("code", getCode())
            .append("name", getName())
            .append("employeeId", getEmployeeId())
            .append("deptId", getDeptId())
            .toString();
    }
}
