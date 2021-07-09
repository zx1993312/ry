package com.ruoyi.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 装修管理对象 hy_fitment_manage
 * 
 * @author Administrator
 * @date 2021-04-13
 */
public class HyFitmentManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 装修管理id */
    private Long id;

    /** 装修状态 */
    @Excel(name = "装修状态")
    private String fitmentManageState;

    /** 装修描述 */
    @Excel(name = "装修描述")
    private String fitmentManageContent;

    /** 预期工期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预期工期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fitmentManageExpect;
    
    /** 装修开始日期 */
    private Date fitmentStartTime;
    
    /** 装修结束日期 */
    private Date fitmentEndTime;
    
    /** 手持图片地址 */
    private String processImg;
    
    /** 装修发起人 */
    private String fitmentUsername;
    
    /** 发起人部门 */
    private String fitmentDept;
    
    /** 审核人 */
    private String fitmentAuditor;
    
    /** 审核状态 */
    private String fitmentStatus;
    
    /** 拒绝原因 */
    private String refusalReason;
    
    /** 通过原因 */
    private String throughReason;

    /** 业主id */
    @Excel(name = "业主id")
    private Long ownerRegistrationId;
    
    /** 业主表 */
    @Excel(name = "业主表")
    private HyOwnerRegistration hyOwnerRegistration;
    
    /** 房屋表 */
    @Excel(name = "房屋表")
    private HyHouseInf hyHouseInf;
    
    /** 楼宇表 */
    @Excel(name = "楼宇表")
    private HyBuilding hyBuilding;
    
    /** 小区表 */
    @Excel(name = "小区表")
    private HyResidentialQuarters hyResidentialQuarters;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFitmentManageState() {
		return fitmentManageState;
	}

	public void setFitmentManageState(String fitmentManageState) {
		this.fitmentManageState = fitmentManageState;
	}

	public String getFitmentManageContent() {
		return fitmentManageContent;
	}

	public void setFitmentManageContent(String fitmentManageContent) {
		this.fitmentManageContent = fitmentManageContent;
	}

	public Date getFitmentManageExpect() {
		return fitmentManageExpect;
	}

	public void setFitmentManageExpect(Date fitmentManageExpect) {
		this.fitmentManageExpect = fitmentManageExpect;
	}

	public Date getFitmentStartTime() {
		return fitmentStartTime;
	}

	public void setFitmentStartTime(Date fitmentStartTime) {
		this.fitmentStartTime = fitmentStartTime;
	}

	public Date getFitmentEndTime() {
		return fitmentEndTime;
	}

	public void setFitmentEndTime(Date fitmentEndTime) {
		this.fitmentEndTime = fitmentEndTime;
	}

	public String getProcessImg() {
		return processImg;
	}

	public void setProcessImg(String processImg) {
		this.processImg = processImg;
	}

	public String getFitmentUsername() {
		return fitmentUsername;
	}

	public void setFitmentUsername(String fitmentUsername) {
		this.fitmentUsername = fitmentUsername;
	}

	public String getFitmentDept() {
		return fitmentDept;
	}

	public void setFitmentDept(String fitmentDept) {
		this.fitmentDept = fitmentDept;
	}

	public String getFitmentAuditor() {
		return fitmentAuditor;
	}

	public void setFitmentAuditor(String fitmentAuditor) {
		this.fitmentAuditor = fitmentAuditor;
	}


	public String getFitmentStatus() {
		return fitmentStatus;
	}

	public void setFitmentStatus(String fitmentStatus) {
		this.fitmentStatus = fitmentStatus;
	}

	public String getRefusalReason() {
		return refusalReason;
	}

	public void setRefusalReason(String refusalReason) {
		this.refusalReason = refusalReason;
	}

	public String getThroughReason() {
		return throughReason;
	}

	public void setThroughReason(String throughReason) {
		this.throughReason = throughReason;
	}

	public Long getOwnerRegistrationId() {
		return ownerRegistrationId;
	}

	public void setOwnerRegistrationId(Long ownerRegistrationId) {
		this.ownerRegistrationId = ownerRegistrationId;
	}

	public HyOwnerRegistration getHyOwnerRegistration() {
		return hyOwnerRegistration;
	}

	public void setHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		this.hyOwnerRegistration = hyOwnerRegistration;
	}

	public HyHouseInf getHyHouseInf() {
		return hyHouseInf;
	}

	public void setHyHouseInf(HyHouseInf hyHouseInf) {
		this.hyHouseInf = hyHouseInf;
	}

	public HyBuilding getHyBuilding() {
		return hyBuilding;
	}

	public void setHyBuilding(HyBuilding hyBuilding) {
		this.hyBuilding = hyBuilding;
	}

	public HyResidentialQuarters getHyResidentialQuarters() {
		return hyResidentialQuarters;
	}

	public void setHyResidentialQuarters(HyResidentialQuarters hyResidentialQuarters) {
		this.hyResidentialQuarters = hyResidentialQuarters;
	}

	@Override
	public String toString() {
		return "HyFitmentManage [id=" + id + ", fitmentManageState=" + fitmentManageState + ", fitmentManageContent="
				+ fitmentManageContent + ", fitmentManageExpect=" + fitmentManageExpect + ", fitmentStartTime="
				+ fitmentStartTime + ", fitmentEndTime=" + fitmentEndTime + ", processImg=" + processImg
				+ ", fitmentUsername=" + fitmentUsername + ", fitmentDept=" + fitmentDept + ", fitmentAuditor="
				+ fitmentAuditor + ", fitmentStatus=" + fitmentStatus + ", refusalReason=" + refusalReason
				+ ", throughReason=" + throughReason + ", ownerRegistrationId=" + ownerRegistrationId
				+ ", hyOwnerRegistration=" + hyOwnerRegistration + ", hyHouseInf=" + hyHouseInf + ", hyBuilding="
				+ hyBuilding + ", hyResidentialQuarters=" + hyResidentialQuarters + "]";
	}




	
}
