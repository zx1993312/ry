package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 巡检项目明细对象 hy_inspection_detail
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public class HyInspectionDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡检项目明细id */
    private Long id;

    /** 序号 */
    @Excel(name = "序号")
    private String code;

    /** 巡检时间点 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "巡检时间点", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inspectionTime;

    /** 巡检线路id */
    @Excel(name = "巡检线路id")
    private Long routeId;

    /** 节点巡检任务id */
    @Excel(name = "节点巡检任务id")
    private Long taskId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setInspectionTime(Date inspectionTime) 
    {
        this.inspectionTime = inspectionTime;
    }

    public Date getInspectionTime() 
    {
        return inspectionTime;
    }
    public void setRouteId(Long routeId) 
    {
        this.routeId = routeId;
    }

    public Long getRouteId() 
    {
        return routeId;
    }
    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("inspectionTime", getInspectionTime())
            .append("remark", getRemark())
            .append("routeId", getRouteId())
            .append("taskId", getTaskId())
            .toString();
    }
}
