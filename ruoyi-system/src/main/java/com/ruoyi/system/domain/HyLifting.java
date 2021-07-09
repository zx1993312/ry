package com.ruoyi.system.domain;

import java.util.Date;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提料人对象 hy_lifting
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public class HyLifting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 提料人id */
    private Long id;
    
    /** 需求数量 */
    @Excel(name = "需求数量")
    private Long materialNumber;


    /** 物料用途 */
    @Excel(name = "物料用途")
    private String materialUse;

    /** 是否归还 */
    @Excel(name = "是否归还")
    private String isreturn;

    /** 申请部门 */
    @Excel(name = "申请部门")
    private String depts;

    /** 申请人 */
    @Excel(name = "申请人")
    private String proposer;

    /** 物料id */
    @Excel(name = "物料id")
    private Long materialId;
    
    /** 申请原因*/
    @Excel(name = "申请原因")
    private String reason;
    
    /** 开始时间*/
    @Excel(name = "开始时间")
    private Date startTime;
    
    /** 结束时间*/
    @Excel(name = "结束时间")
    private Date endTime;
    
    /** 是否长期*/
    @Excel(name = "是否长期")
    private String isLong;
    
    /** 负责人*/
    @Excel(name = "负责人")
    private String leadingCadre;
    
    /** 负责人部门*/
    @Excel(name = "负责人部门")
    private String leadingDepartment;
    
    /** 物料表 */
    @Excel(name = "物料表")
    private HyMaterial hyMaterial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(Long materialNumber) {
		this.materialNumber = materialNumber;
	}

	public String getMaterialUse() {
		return materialUse;
	}

	public void setMaterialUse(String materialUse) {
		this.materialUse = materialUse;
	}

	public String getIsreturn() {
		return isreturn;
	}

	public void setIsreturn(String isreturn) {
		this.isreturn = isreturn;
	}

	public String getDepts() {
		return depts;
	}

	public void setDepts(String depts) {
		this.depts = depts;
	}

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getIsLong() {
		return isLong;
	}

	public void setIsLong(String isLong) {
		this.isLong = isLong;
	}

	public String getLeadingCadre() {
		return leadingCadre;
	}

	public void setLeadingCadre(String leadingCadre) {
		this.leadingCadre = leadingCadre;
	}

	public String getLeadingDepartment() {
		return leadingDepartment;
	}

	public void setLeadingDepartment(String leadingDepartment) {
		this.leadingDepartment = leadingDepartment;
	}

	public HyMaterial getHyMaterial() {
		return hyMaterial;
	}

	public void setHyMaterial(HyMaterial hyMaterial) {
		this.hyMaterial = hyMaterial;
	}

	@Override
	public String toString() {
		return "HyLifting [id=" + id + ", materialNumber=" + materialNumber + ", materialUse=" + materialUse
				+ ", isreturn=" + isreturn + ", depts=" + depts + ", proposer=" + proposer + ", materialId="
				+ materialId + ", reason=" + reason + ", startTime=" + startTime + ", endTime=" + endTime + ", isLong="
				+ isLong + ", leadingCadre=" + leadingCadre + ", leadingDepartment=" + leadingDepartment
				+ ", hyMaterial=" + hyMaterial + "]";
	}

}
