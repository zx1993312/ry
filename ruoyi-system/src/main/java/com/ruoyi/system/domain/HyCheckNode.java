package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 巡检节点对象 hy_check_node
 * 
 * @author Administrator
 * @date 2021-07-20
 */
public class HyCheckNode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡检节点id */
    private Long id;

    /** 巡检节点名称 */
    @Excel(name = "巡检节点名称")
    private String name;

    /** 巡检节点地址 */
    @Excel(name = "巡检节点地址")
    private String nodeAddress;

    /** 经度 */
    @Excel(name = "经度")
    private String nodeLongitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String nodeLatitude;

    /** 备注 */
    @Excel(name = "备注")
    private String nodeRemark;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNodeAddress(String nodeAddress) 
    {
        this.nodeAddress = nodeAddress;
    }

    public String getNodeAddress() 
    {
        return nodeAddress;
    }
    public void setNodeLongitude(String nodeLongitude) 
    {
        this.nodeLongitude = nodeLongitude;
    }

    public String getNodeLongitude() 
    {
        return nodeLongitude;
    }
    public void setNodeLatitude(String nodeLatitude) 
    {
        this.nodeLatitude = nodeLatitude;
    }

    public String getNodeLatitude() 
    {
        return nodeLatitude;
    }
    public void setNodeRemark(String nodeRemark) 
    {
        this.nodeRemark = nodeRemark;
    }

    public String getNodeRemark() 
    {
        return nodeRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("nodeAddress", getNodeAddress())
            .append("nodeLongitude", getNodeLongitude())
            .append("nodeLatitude", getNodeLatitude())
            .append("nodeRemark", getNodeRemark())
            .toString();
    }
}