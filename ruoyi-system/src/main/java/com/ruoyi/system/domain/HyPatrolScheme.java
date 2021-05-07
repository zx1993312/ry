package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 巡检计划对象 hy_patrol_scheme
 * 
 * @author Administrator
 * @date 2021-04-25
 */
public class HyPatrolScheme extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡检计划id */
    private Long id;

    /** 单据号 */
    @Excel(name = "单据号")
    private Long documentNumber;

    /** 计划时间 */
    @Excel(name = "计划时间")
    private String plannedTime;

    /** 计划区间 */
    @Excel(name = "计划区间")
    private String planRange;

    /** 计划年度 */
    @Excel(name = "计划年度")
    private String planAnnual;

    /** 计划人 */
    @Excel(name = "计划人")
    private String planner;

    /** 巡检人 */
    @Excel(name = "巡检人")
    private String checkPeople;

    /** 巡检时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "巡检时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inspectionTime;

    /** 制单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "制单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date makeTime;

    /** 制单人 */
    @Excel(name = "制单人")
    private String documentMaker;

    /** 修订时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修订时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date revisionTime;

    /** 修订人 */
    @Excel(name = "修订人")
    private String reviser;

    /** 是否审核 */
    @Excel(name = "是否审核")
    private String isCheck;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 审核人 */
    @Excel(name = "审核人")
    private String auditor;

    /** 实际巡检时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际巡检时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualInspectionTime;

    /** 巡检状态 */
    @Excel(name = "巡检状态")
    private String inspectionStatus;

    /** 变更巡检状态原因 */
    @Excel(name = "变更巡检状态原因")
    private String changeStatus;

    /** 巡检说明 */
    @Excel(name = "巡检说明")
    private String inspectionInstructions;

    /** 组织机构id */
    @Excel(name = "组织机构id")
    private Long deptId;
    
    /** 项目id */
    @Excel(name = "项目id")
    private Long parentId;
    
    /** 物业id */
    @Excel(name = "物业id")
    private Long propertyId;
    
    /** 节点巡检表 */
    @Excel(name = "节点巡检表")
    private HyCheckeNode hyCheckeNode;
    
    /** 巡检项目表 */
    @Excel(name = "巡检项目表")
    private HyCheckeProject hyCheckeProject;
    
    /** 巡检线路表 */
    @Excel(name = "巡检线路表")
    private HyInspectionRoute hyInspectionRoute;
    
    /** 巡检线路明细表 */
    @Excel(name = "巡检线路明细表")
    private HyInspectionDetail hyInspectionDetail;
    
    /** 巡检周期表 */
    @Excel(name = "巡检周期表")
    private HyPollingPeriod hyPollingPeriod;
    
    /** 巡检结果表 */
    @Excel(name = "巡检结果表")
    private HyInspectionResult hyInspectionResult;
    
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDocumentNumber(Long documentNumber) 
    {
        this.documentNumber = documentNumber;
    }

    public Long getDocumentNumber() 
    {
        return documentNumber;
    }
    public void setPlannedTime(String plannedTime) 
    {
        this.plannedTime = plannedTime;
    }

    public String getPlannedTime() 
    {
        return plannedTime;
    }
    public void setPlanRange(String planRange) 
    {
        this.planRange = planRange;
    }

    public String getPlanRange() 
    {
        return planRange;
    }
    public void setPlanAnnual(String planAnnual) 
    {
        this.planAnnual = planAnnual;
    }

    public String getPlanAnnual() 
    {
        return planAnnual;
    }
    public void setPlanner(String planner) 
    {
        this.planner = planner;
    }

    public String getPlanner() 
    {
        return planner;
    }
    public void setCheckPeople(String checkPeople) 
    {
        this.checkPeople = checkPeople;
    }

    public String getCheckPeople() 
    {
        return checkPeople;
    }
    public void setInspectionTime(Date inspectionTime) 
    {
        this.inspectionTime = inspectionTime;
    }

    public Date getInspectionTime() 
    {
        return inspectionTime;
    }
    public void setMakeTime(Date makeTime) 
    {
        this.makeTime = makeTime;
    }

    public Date getMakeTime() 
    {
        return makeTime;
    }
    public void setDocumentMaker(String documentMaker) 
    {
        this.documentMaker = documentMaker;
    }

    public String getDocumentMaker() 
    {
        return documentMaker;
    }
    public void setRevisionTime(Date revisionTime) 
    {
        this.revisionTime = revisionTime;
    }

    public Date getRevisionTime() 
    {
        return revisionTime;
    }
    public void setReviser(String reviser) 
    {
        this.reviser = reviser;
    }

    public String getReviser() 
    {
        return reviser;
    }
    public void setIsCheck(String isCheck) 
    {
        this.isCheck = isCheck;
    }

    public String getIsCheck() 
    {
        return isCheck;
    }
    public void setAuditTime(Date auditTime) 
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime() 
    {
        return auditTime;
    }
    public void setAuditor(String auditor) 
    {
        this.auditor = auditor;
    }

    public String getAuditor() 
    {
        return auditor;
    }
    public void setActualInspectionTime(Date actualInspectionTime) 
    {
        this.actualInspectionTime = actualInspectionTime;
    }

    public Date getActualInspectionTime() 
    {
        return actualInspectionTime;
    }
    public void setInspectionStatus(String inspectionStatus) 
    {
        this.inspectionStatus = inspectionStatus;
    }

    public String getInspectionStatus() 
    {
        return inspectionStatus;
    }
    public void setChangeStatus(String changeStatus) 
    {
        this.changeStatus = changeStatus;
    }

    public String getChangeStatus() 
    {
        return changeStatus;
    }
    public void setInspectionInstructions(String inspectionInstructions) 
    {
        this.inspectionInstructions = inspectionInstructions;
    }

    public String getInspectionInstructions() 
    {
        return inspectionInstructions;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }


	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public HyInspectionRoute getHyInspectionRoute() {
		return hyInspectionRoute;
	}

	public void setHyInspectionRoute(HyInspectionRoute hyInspectionRoute) {
		this.hyInspectionRoute = hyInspectionRoute;
	}

	public HyPollingPeriod getHyPollingPeriod() {
		return hyPollingPeriod;
	}

	public void setHyPollingPeriod(HyPollingPeriod hyPollingPeriod) {
		this.hyPollingPeriod = hyPollingPeriod;
	}

	public HyCheckeNode getHyCheckeNode() {
		return hyCheckeNode;
	}

	public void setHyCheckeNode(HyCheckeNode hyCheckeNode) {
		this.hyCheckeNode = hyCheckeNode;
	}

	public HyCheckeProject getHyCheckeProject() {
		return hyCheckeProject;
	}

	public void setHyCheckeProject(HyCheckeProject hyCheckeProject) {
		this.hyCheckeProject = hyCheckeProject;
	}

	public HyInspectionDetail getHyInspectionDetail() {
		return hyInspectionDetail;
	}

	public void setHyInspectionDetail(HyInspectionDetail hyInspectionDetail) {
		this.hyInspectionDetail = hyInspectionDetail;
	}

	public HyInspectionResult getHyInspectionResult() {
		return hyInspectionResult;
	}

	public void setHyInspectionResult(HyInspectionResult hyInspectionResult) {
		this.hyInspectionResult = hyInspectionResult;
	}

	@Override
	public String toString() {
		return "HyPatrolScheme [id=" + id + ", documentNumber=" + documentNumber + ", plannedTime=" + plannedTime
				+ ", planRange=" + planRange + ", planAnnual=" + planAnnual + ", planner=" + planner + ", checkPeople="
				+ checkPeople + ", inspectionTime=" + inspectionTime + ", makeTime=" + makeTime + ", documentMaker="
				+ documentMaker + ", revisionTime=" + revisionTime + ", reviser=" + reviser + ", isCheck=" + isCheck
				+ ", auditTime=" + auditTime + ", auditor=" + auditor + ", actualInspectionTime=" + actualInspectionTime
				+ ", inspectionStatus=" + inspectionStatus + ", changeStatus=" + changeStatus
				+ ", inspectionInstructions=" + inspectionInstructions + ", deptId=" + deptId + ", hyCheckeNode="
				+ hyCheckeNode + ", hyCheckeProject=" + hyCheckeProject + ", hyInspectionRoute=" + hyInspectionRoute
				+ ", hyInspectionDetail=" + hyInspectionDetail + ", hyPollingPeriod=" + hyPollingPeriod
				+ ", hyInspectionResult=" + hyInspectionResult + "]";
	}



}
