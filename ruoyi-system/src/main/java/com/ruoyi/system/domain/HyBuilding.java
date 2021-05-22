package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 楼宇对象 hy_building
 * 
 * @author Administrator
 * @date 2021-05-22
 */
public class HyBuilding extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 楼宇id */
    private Long id;

    /** 楼宇名称 */
    @Excel(name = "楼宇名称")
    private String buildingName;

    /** 楼宇高度 */
    @Excel(name = "楼宇高度")
    private String buildingHigh;

    /** 楼宇单元数 */
    @Excel(name = "楼宇单元数")
    private String buildingUnit;

    /** 每单元每层户数 */
    @Excel(name = "每单元每层户数")
    private String buildingHouseholds;

    /** 楼宇地址 */
    @Excel(name = "楼宇地址")
    private String buildingAddress;

    /** 建造年份 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "建造年份", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buildingYear;

    /** 备注 */
    @Excel(name = "备注")
    private String buildingRemark;

    /** 小区id */
    @Excel(name = "小区id")
    private Long quartersId;
    
    /** 小区表 */
    @Excel(name = "小区表")
    private HyResidentialQuarters hyResidentialQuarters;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;
    
    /** 项目表 */
    @Excel(name = "项目表")
    private HyProject hyProject;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBuildingName(String buildingName) 
    {
        this.buildingName = buildingName;
    }

    public String getBuildingName() 
    {
        return buildingName;
    }
    public void setBuildingHigh(String buildingHigh) 
    {
        this.buildingHigh = buildingHigh;
    }

    public String getBuildingHigh() 
    {
        return buildingHigh;
    }
    public void setBuildingUnit(String buildingUnit) 
    {
        this.buildingUnit = buildingUnit;
    }

    public String getBuildingUnit() 
    {
        return buildingUnit;
    }
    public void setBuildingHouseholds(String buildingHouseholds) 
    {
        this.buildingHouseholds = buildingHouseholds;
    }

    public String getBuildingHouseholds() 
    {
        return buildingHouseholds;
    }
    public void setBuildingAddress(String buildingAddress) 
    {
        this.buildingAddress = buildingAddress;
    }

    public String getBuildingAddress() 
    {
        return buildingAddress;
    }
    public void setBuildingYear(Date buildingYear) 
    {
        this.buildingYear = buildingYear;
    }

    public Date getBuildingYear() 
    {
        return buildingYear;
    }
    public void setBuildingRemark(String buildingRemark) 
    {
        this.buildingRemark = buildingRemark;
    }

    public String getBuildingRemark() 
    {
        return buildingRemark;
    }
    public void setQuartersId(Long quartersId) 
    {
        this.quartersId = quartersId;
    }

    public Long getQuartersId() 
    {
        return quartersId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }

    public HyResidentialQuarters getHyResidentialQuarters() {
		return hyResidentialQuarters;
	}

	public void setHyResidentialQuarters(HyResidentialQuarters hyResidentialQuarters) {
		this.hyResidentialQuarters = hyResidentialQuarters;
	}

	public HyProject getHyProject() {
		return hyProject;
	}

	public void setHyProject(HyProject hyProject) {
		this.hyProject = hyProject;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("buildingName", getBuildingName())
            .append("buildingHigh", getBuildingHigh())
            .append("buildingUnit", getBuildingUnit())
            .append("buildingHouseholds", getBuildingHouseholds())
            .append("buildingAddress", getBuildingAddress())
            .append("buildingYear", getBuildingYear())
            .append("buildingRemark", getBuildingRemark())
            .append("quartersId", getQuartersId())
            .append("projectId", getProjectId())
            .append("hyResidentialQuarters", getHyResidentialQuarters())
            .append("hyProject", getHyProject())
            .toString();
    }
}
