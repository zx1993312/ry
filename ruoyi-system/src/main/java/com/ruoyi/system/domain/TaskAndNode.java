package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 巡检任务和巡检节点关联对象 task_and_node
 * 
 * @author Administrator
 * @date 2021-07-21
 */
public class TaskAndNode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡检任务id */
    @Excel(name = "巡检任务id")
    private Long taskId;

    /** 巡检节点id */
    @Excel(name = "巡检节点id")
    private Long nodeId;

    /** 是否巡检 */
    @Excel(name = "是否巡检")
    private String isInspection;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setNodeId(Long nodeId) 
    {
        this.nodeId = nodeId;
    }

    public Long getNodeId() 
    {
        return nodeId;
    }
    public void setIsInspection(String isInspection) 
    {
        this.isInspection = isInspection;
    }

    public String getIsInspection() 
    {
        return isInspection;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("nodeId", getNodeId())
            .append("isInspection", getIsInspection())
            .toString();
    }
}