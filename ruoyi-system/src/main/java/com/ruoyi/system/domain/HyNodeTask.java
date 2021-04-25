package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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
    private String name;

    /** 巡检方式 */
    @Excel(name = "巡检方式")
    private String inspectionWay;

    /** 巡检节点d */
    @Excel(name = "巡检节点d")
    private Long nodeId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("inspectionWay", getInspectionWay())
            .append("remark", getRemark())
            .append("nodeId", getNodeId())
            .toString();
    }
}
