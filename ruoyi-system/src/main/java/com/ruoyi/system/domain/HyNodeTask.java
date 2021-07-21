package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 节点巡检任务对象 hy_node_task
 * 
 * @author Administrator
 * @date 2021-07-21
 */
public class HyNodeTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 节点巡检任务id */
    private Long id;

    /** 计划名称 */
    @Excel(name = "计划名称")
    private String taskName;

    /** 巡检时间 */
    @Excel(name = "巡检时间")
    private String taskTime;

    /** 任务备注 */
    @Excel(name = "任务备注")
    private String taskRemark;

    /** 任务状态 */
    @Excel(name = "任务状态")
    private String taskStatus;

    /** 巡检节点id组 */
    @Excel(name = "巡检节点id组")
    private String nodeIds;
    
    /** 巡检节点表 */
    @Excel(name = "巡检节点表")
    private HyCheckNode hyCheckNode;
    
    /** 巡检节点巡检任务关联表 */
    @Excel(name = "巡检节点巡检任务关联表")
    private TaskAndNode taskAndNode;

    /** 巡检人id */
    @Excel(name = "巡检人id")
    private Long userId;
    
    /** 巡检人表 */
    @Excel(name = "巡检人表")
    private SysUser sysUser;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;
    
    /** 部门表 */
    @Excel(name = "部门表")
    private SysDept sysDept;

    /** 巡检类型id */
    @Excel(name = "巡检类型id")
    private Long typeId;
    
    /** 巡检类型表 */
    @Excel(name = "巡检类型表")
    private HyCheckType hyCheckType;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }
    public void setTaskTime(String taskTime) 
    {
        this.taskTime = taskTime;
    }

    public String getTaskTime() 
    {
        return taskTime;
    }
    public void setTaskRemark(String taskRemark) 
    {
        this.taskRemark = taskRemark;
    }

    public String getTaskRemark() 
    {
        return taskRemark;
    }
    public void setTaskStatus(String taskStatus) 
    {
        this.taskStatus = taskStatus;
    }

    public String getTaskStatus() 
    {
        return taskStatus;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }

	public String getNodeIds() {
		return nodeIds;
	}

	public void setNodeIds(String nodeIds) {
		this.nodeIds = nodeIds;
	}

	public HyCheckNode getHyCheckNode() {
		return hyCheckNode;
	}

	public void setHyCheckNode(HyCheckNode hyCheckNode) {
		this.hyCheckNode = hyCheckNode;
	}

	public TaskAndNode getTaskAndNode() {
		return taskAndNode;
	}

	public void setTaskAndNode(TaskAndNode taskAndNode) {
		this.taskAndNode = taskAndNode;
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

	public HyCheckType getHyCheckType() {
		return hyCheckType;
	}

	public void setHyCheckType(HyCheckType hyCheckType) {
		this.hyCheckType = hyCheckType;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskName", getTaskName())
            .append("taskTime", getTaskTime())
            .append("taskRemark", getTaskRemark())
            .append("taskStatus", getTaskStatus())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("typeId", getTypeId())
            .append("nodeIds", getNodeIds())
            .append("hyCheckNode", getHyCheckNode())
            .append("taskAndNode", getTaskAndNode())
            .append("sysUser", getSysUser())
            .append("sysDept", getSysDept())
            .append("hyCheckType", getHyCheckType())
            .toString();
    }
}
