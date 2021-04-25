package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 巡检项目对象 hy_checke_project
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public class HyCheckeProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡检项目id */
    private Long id;

    /** 巡检类型 */
    @Excel(name = "巡检类型")
    private String type;

    /** 标准 */
    @Excel(name = "标准")
    private String standard;

    /** 是否测量 */
    @Excel(name = "是否测量")
    private String isMeasured;

    /** 参考值 */
    @Excel(name = "参考值")
    private String referenceValue;

    /** 测量值 */
    @Excel(name = "测量值")
    private String measuredValue;

    /** 说明 */
    @Excel(name = "说明")
    private String explains;

    /** 巡检说明 */
    @Excel(name = "巡检说明")
    private String inspectionInstructions;

    /** 巡检项目图片 */
    @Excel(name = "巡检项目图片")
    private String projectPicture;

    /** 巡检项目明细图片 */
    @Excel(name = "巡检项目明细图片")
    private String detailPicture;

    /** 问题描述 */
    @Excel(name = "问题描述")
    private String problemDescription;

    /** 巡检项目经度 */
    @Excel(name = "巡检项目经度")
    private String patrolLongitude;

    /** 巡检项目纬度 */
    @Excel(name = "巡检项目纬度")
    private String patrolLatitude;

    /** 巡检节点id */
    @Excel(name = "巡检节点id")
    private Long nodeId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setStandard(String standard) 
    {
        this.standard = standard;
    }

    public String getStandard() 
    {
        return standard;
    }
    public void setIsMeasured(String isMeasured) 
    {
        this.isMeasured = isMeasured;
    }

    public String getIsMeasured() 
    {
        return isMeasured;
    }
    public void setReferenceValue(String referenceValue) 
    {
        this.referenceValue = referenceValue;
    }

    public String getReferenceValue() 
    {
        return referenceValue;
    }
    public void setMeasuredValue(String measuredValue) 
    {
        this.measuredValue = measuredValue;
    }

    public String getMeasuredValue() 
    {
        return measuredValue;
    }
    public void setExplains(String explains) 
    {
        this.explains = explains;
    }

    public String getExplains() 
    {
        return explains;
    }
    public void setInspectionInstructions(String inspectionInstructions) 
    {
        this.inspectionInstructions = inspectionInstructions;
    }

    public String getInspectionInstructions() 
    {
        return inspectionInstructions;
    }
    public void setProjectPicture(String projectPicture) 
    {
        this.projectPicture = projectPicture;
    }

    public String getProjectPicture() 
    {
        return projectPicture;
    }
    public void setDetailPicture(String detailPicture) 
    {
        this.detailPicture = detailPicture;
    }

    public String getDetailPicture() 
    {
        return detailPicture;
    }
    public void setProblemDescription(String problemDescription) 
    {
        this.problemDescription = problemDescription;
    }

    public String getProblemDescription() 
    {
        return problemDescription;
    }
    public void setPatrolLongitude(String patrolLongitude) 
    {
        this.patrolLongitude = patrolLongitude;
    }

    public String getPatrolLongitude() 
    {
        return patrolLongitude;
    }
    public void setPatrolLatitude(String patrolLatitude) 
    {
        this.patrolLatitude = patrolLatitude;
    }

    public String getPatrolLatitude() 
    {
        return patrolLatitude;
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
            .append("type", getType())
            .append("standard", getStandard())
            .append("isMeasured", getIsMeasured())
            .append("referenceValue", getReferenceValue())
            .append("measuredValue", getMeasuredValue())
            .append("explains", getExplains())
            .append("inspectionInstructions", getInspectionInstructions())
            .append("projectPicture", getProjectPicture())
            .append("detailPicture", getDetailPicture())
            .append("problemDescription", getProblemDescription())
            .append("patrolLongitude", getPatrolLongitude())
            .append("patrolLatitude", getPatrolLatitude())
            .append("nodeId", getNodeId())
            .toString();
    }
}
