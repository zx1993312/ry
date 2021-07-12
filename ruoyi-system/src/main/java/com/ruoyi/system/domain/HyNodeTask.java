package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 节点巡检任务对象 hy_node_task
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public class HyNodeTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 节点巡检任务id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String taskName;

    /** 巡检方式 */
    @Excel(name = "巡检方式")
    private String inspectionWay;

    /** 巡检节点id */
    @Excel(name = "巡检节点id")
    private Long nodeId;
    
    /** 巡检节点表 */
    @Excel(name = "巡检节点表")
    private HyCheckeNode hyCheckeNode;

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
    public void setInspectionWay(String inspectionWay) 
    {
        this.inspectionWay = inspectionWay;
    }

    public String getInspectionWay() 
    {
        return inspectionWay;
    }
    public void setNodeId(Long nodeId) 
    {
        this.nodeId = nodeId;
    }

    public Long getNodeId() 
    {
        return nodeId;
    }

    public HyCheckeNode getHyCheckeNode() {
		return hyCheckeNode;
	}

	public void setHyCheckeNode(HyCheckeNode hyCheckeNode) {
		this.hyCheckeNode = hyCheckeNode;
	}

	@Override
	public String toString() {
		return "HyNodeTask [id=" + id + ", taskName=" + taskName + ", inspectionWay=" + inspectionWay + ", nodeId="
				+ nodeId + ", hyCheckeNode=" + hyCheckeNode + "]";
	}

}
