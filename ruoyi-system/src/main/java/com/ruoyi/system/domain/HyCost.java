package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 费用项目对象 hy_cost
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public class HyCost extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private Long id;

	/** 房屋编号 **/
	@Excel(name = "房屋编号")
	private String houseNum;

	/** 费用项目 */
	@Excel(name = "费用项目")
	private String costItems;

	/** 费用类型 */
	@Excel(name = "费用类型")
	private String expenseType;

	@Excel(name = "父类id")
	private Integer parentId;
	/**
	 * 组级列表
	 */
	@Excel(name = "组级列表")
	private String ancestors;
	/**
	 * 标准名称
	 */
	@Excel(name = "标准名称")
	private String standardName;
	/**
	 * 费用序号
	 */
	@Excel(name = "费用项目")
	private String feeNum;
	/**
	 * 通用收费标注
	 */
	@Excel(name = "通用收费标注")
	private BigDecimal chargingStandard;
	/**
	 * 计算方式
	 */
	@Excel(name = "计算方式")
	private String calculationMehod;
	/**
	 * 标准说明
	 */
	@Excel(name = "标准说明")
	private String standardDescription;
	/**
	 * 标准状态
	 */
	@Excel(name = "标准状态")
	private String standardState;
	/**
	 * 违约金比例
	 */
	@Excel(name = "违约金比例")
	private BigDecimal proportionDamags;
	/**
	 * 是否允许项目修改
	 */
	@Excel(name = "是否允许项目修改")
	private Integer projectModification;
	/**
	 * 计费周期
	 */
	@Excel(name = "计费周期")
	private String billingCycle;
	/**
	 * 计费开始日期
	 */
	@Excel(name = "计费开始日期")
	private Date bilingStartDate;

	/**
	 * 计费结束日期
	 */
	@Excel(name = "计费结束日期")
	private Date bilingEndDate;
	/**
	 * 审核结果及原因
	 */
	@Excel(name = "审核结果及原因")
	private String auditResultsReason;
	/**
	 * 原费用日期
	 */
	@Excel(name = "原费用日期")
	private Date feeDateOld;
	/**
	 * 费用日期
	 */
	@Excel(name = "费用日期")
	private Date feeDate;
	/**
	 * 原应收日期
	 */
	@Excel(name = "原应收日期")
	private Date dueDateOld;
	/**
	 * 应收日期
	 */
	@Excel(name = "应收日期")
	private Date dueDate;
	/**
	 * 原应收金额
	 */
	@Excel(name = "原应收金额")
	private BigDecimal amountReceivableOld;
	/**
	 * 应收金额
	 */
	@Excel(name = "应收金额")
	private BigDecimal amountReceivable;
	/**
	 * 实收金额
	 */
	@Excel(name = "实收金额")
	private BigDecimal amountActually;
	/**
	 * 备注
	 */
	@Excel(name = "备注")
	private String remarks;
	/**
	 * 操作日期
	 */
	@Excel(name = "操作日期")
	private Date operationDate;
	/**
	 * 操作人
	 */
	@Excel(name = "操作人")
	private String operationUser;
	/**
	 * 操作类别
	 */
	@Excel(name = "操作类别")
	private String operationType;
	/**
	 * 删除原因
	 */
	@Excel(name = "删除原因")
	private String deleteReason;
	/**
	 * 预交冲抵
	 */
	@Excel(name = "预交冲抵")
	private BigDecimal advancePaymetnOffset;
	/**
	 * 减免冲销
	 */
	@Excel(name = "减免冲销")
	private BigDecimal writeOff;
	/**
	 * 退款金额
	 */
	@Excel(name = "退款金额")
	private BigDecimal refundAmount;
	/**
	 * 欠收金额
	 */
	@Excel(name = "欠收金额")
	private BigDecimal amountArrears;
	/**
	 * 托收状态
	 */
	@Excel(name = "托收状态")
	private Integer collectionStatus;
	/**
	 * 冻结时间
	 */
	@Excel(name = "冻结人")
	private String frozenPerson;
	/**
	 * 冻结状态
	 */
	@Excel(name = "冻结状态")
	private Integer frozenState;
	/**
	 * 冻结日期
	 */
	@Excel(name = "冻结日期")
	private Date frozenDate;
	/**
	 * 冻结原因
	 */
	@Excel(name = "冻结原因")
	private String frozenReason;
	/**
	 * 垫付状态
	 */
	@Excel(name = "垫付状态")
	private Integer advanceStatus;
	/**
	 * 预交状态
	 */
	@Excel(name = "预交状态")
	private Integer deliveryStatus;
	/**
	 * 出租时自动转移租户
	 */
	@Excel(name="出租时自动转移租户")
	private Integer transferTenants;
	/**
	 * 变更时间
	 */
	@Excel(name="变更时间")
	private Date changeDate;
	/**
	 * 计费方式
	 */
	@Excel(name="计费方式")
	private String billingMethod;

	private HyParkingInf hyParkingInf;

	private HyHouseInf hyHouseInf;

	private HyOwnerRegistration hyOwnerRegistration;
	
	private HyMeter hyMeter;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setCostItems(String costItems) {
		this.costItems = costItems;
	}

	public String getCostItems() {
		return costItems;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getAncestors() {
		return ancestors;
	}

	public void setAncestors(String ancestors) {
		this.ancestors = ancestors;
	}

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public BigDecimal getChargingStandard() {
		return chargingStandard;
	}

	public void setChargingStandard(BigDecimal chargingStandard) {
		this.chargingStandard = chargingStandard;
	}

	public String getCalculationMehod() {
		return calculationMehod;
	}

	public void setCalculationMehod(String calculationMehod) {
		this.calculationMehod = calculationMehod;
	}

	public String getStandardState() {
		return standardState;
	}

	public void setStandardState(String standardState) {
		this.standardState = standardState;
	}

	public BigDecimal getProportionDamags() {
		return proportionDamags;
	}

	public void setProportionDamags(BigDecimal proportionDamags) {
		this.proportionDamags = proportionDamags;
	}

	public Integer getProjectModification() {
		return projectModification;
	}

	public void setProjectModification(Integer projectModification) {
		this.projectModification = projectModification;
	}

	public String getBillingCycle() {
		return billingCycle;
	}

	public void setBillingCycle(String billingCycle) {
		this.billingCycle = billingCycle;
	}

	public Date getBilingStartDate() {
		return bilingStartDate;
	}

	public void setBilingStartDate(Date bilingStartDate) {
		this.bilingStartDate = bilingStartDate;
	}

	public String getAuditResultsReason() {
		return auditResultsReason;
	}

	public void setAuditResultsReason(String auditResultsReason) {
		this.auditResultsReason = auditResultsReason;
	}



	public Date getBilingEndDate() {
		return bilingEndDate;
	}

	public void setBilingEndDate(Date bilingEndDate) {
		this.bilingEndDate = bilingEndDate;
	}

	public Date getFeeDateOld() {
		return feeDateOld;
	}

	public void setFeeDateOld(Date feeDateOld) {
		this.feeDateOld = feeDateOld;
	}

	public Date getFeeDate() {
		return feeDate;
	}

	public void setFeeDate(Date feeDate) {
		this.feeDate = feeDate;
	}

	public Date getDueDateOld() {
		return dueDateOld;
	}

	public void setDueDateOld(Date dueDateOld) {
		this.dueDateOld = dueDateOld;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getAmountReceivableOld() {
		return amountReceivableOld;
	}

	public void setAmountReceivableOld(BigDecimal amountReceivableOld) {
		this.amountReceivableOld = amountReceivableOld;
	}

	public BigDecimal getAmountReceivable() {
		return amountReceivable;
	}

	public void setAmountReceivable(BigDecimal amountReceivable) {
		this.amountReceivable = amountReceivable;
	}

	public BigDecimal getAmountActually() {
		return amountActually;
	}

	public void setAmountActually(BigDecimal amountActually) {
		this.amountActually = amountActually;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOperationUser() {
		return operationUser;
	}

	public void setOperationUser(String operationUser) {
		this.operationUser = operationUser;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getDeleteReason() {
		return deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public BigDecimal getAdvancePaymetnOffset() {
		return advancePaymetnOffset;
	}

	public void setAdvancePaymetnOffset(BigDecimal advancePaymetnOffset) {
		this.advancePaymetnOffset = advancePaymetnOffset;
	}

	public BigDecimal getWriteOff() {
		return writeOff;
	}

	public void setWriteOff(BigDecimal writeOff) {
		this.writeOff = writeOff;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public BigDecimal getAmountArrears() {
		return amountArrears;
	}

	public void setAmountArrears(BigDecimal amountArrears) {
		this.amountArrears = amountArrears;
	}

	public Integer getCollectionStatus() {
		return collectionStatus;
	}

	public void setCollectionStatus(Integer collectionStatus) {
		this.collectionStatus = collectionStatus;
	}

	public Integer getFrozenState() {
		return frozenState;
	}

	public void setFrozenState(Integer frozenState) {
		this.frozenState = frozenState;
	}

	public Integer getAdvanceStatus() {
		return advanceStatus;
	}

	public void setAdvanceStatus(Integer advanceStatus) {
		this.advanceStatus = advanceStatus;
	}

	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public HyParkingInf getHyParkingInf() {
		return hyParkingInf;
	}

	public void setHyParkingInf(HyParkingInf hyParkingInf) {
		this.hyParkingInf = hyParkingInf;
	}

	public HyHouseInf getHyHouseInf() {
		return hyHouseInf;
	}

	public void setHyHouseInf(HyHouseInf hyHouseInf) {
		this.hyHouseInf = hyHouseInf;
	}

	public HyOwnerRegistration getHyOwnerRegistration() {
		return hyOwnerRegistration;
	}

	public void setHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		this.hyOwnerRegistration = hyOwnerRegistration;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getFeeNum() {
		return feeNum;
	}

	public void setFeeNum(String feeNum) {
		this.feeNum = feeNum;
	}

	public String getFrozenPerson() {
		return frozenPerson;
	}

	public void setFrozenPerson(String frozenPerson) {
		this.frozenPerson = frozenPerson;
	}

	public Date getFrozenDate() {
		return frozenDate;
	}

	public void setFrozenDate(Date frozenDate) {
		this.frozenDate = frozenDate;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public String getFrozenReason() {
		return frozenReason;
	}

	public void setFrozenReason(String frozenReason) {
		this.frozenReason = frozenReason;
	}

	public String getStandardDescription() {
		return standardDescription;
	}

	public void setStandardDescription(String standardDescription) {
		this.standardDescription = standardDescription;
	}

	public Integer getTransferTenants() {
		return transferTenants;
	}

	public void setTransferTenants(Integer transferTenants) {
		this.transferTenants = transferTenants;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public HyMeter getHyMeter() {
		return hyMeter;
	}

	public void setHyMeter(HyMeter hyMeter) {
		this.hyMeter = hyMeter;
	}

	public String getBillingMethod() {
		return billingMethod;
	}

	public void setBillingMethod(String billingMethod) {
		this.billingMethod = billingMethod;
	}

	@Override
	public String toString() {
		return "HyCost [id=" + id + ", houseNum=" + houseNum + ", costItems=" + costItems + ", expenseType="
				+ expenseType + ", parentId=" + parentId + ", ancestors=" + ancestors + ", standardName=" + standardName
				+ ", feeNum=" + feeNum + ", chargingStandard=" + chargingStandard + ", calculationMehod="
				+ calculationMehod + ", standardDescription=" + standardDescription + ", standardState=" + standardState
				+ ", proportionDamags=" + proportionDamags + ", projectModification=" + projectModification
				+ ", billingCycle=" + billingCycle + ", bilingStartDate=" + bilingStartDate + ", bilingEndDate="
				+ bilingEndDate + ", auditResultsReason=" + auditResultsReason + ", feeDateOld=" + feeDateOld
				+ ", feeDate=" + feeDate + ", dueDateOld=" + dueDateOld + ", dueDate=" + dueDate
				+ ", amountReceivableOld=" + amountReceivableOld + ", amountReceivable=" + amountReceivable
				+ ", amountActually=" + amountActually + ", remarks=" + remarks + ", operationDate=" + operationDate
				+ ", operationUser=" + operationUser + ", operationType=" + operationType + ", deleteReason="
				+ deleteReason + ", advancePaymetnOffset=" + advancePaymetnOffset + ", writeOff=" + writeOff
				+ ", refundAmount=" + refundAmount + ", amountArrears=" + amountArrears + ", collectionStatus="
				+ collectionStatus + ", frozenPerson=" + frozenPerson + ", frozenState=" + frozenState + ", frozenDate="
				+ frozenDate + ", frozenReason=" + frozenReason + ", advanceStatus=" + advanceStatus
				+ ", deliveryStatus=" + deliveryStatus + ", hyParkingInf=" + hyParkingInf + ", hyHouseInf=" + hyHouseInf
				+ ", hyOwnerRegistration=" + hyOwnerRegistration + ", getId()=" + getId() + ", getCostItems()="
				+ getCostItems() + ", getExpenseType()=" + getExpenseType() + ", getParentId()=" + getParentId()
				+ ", getAncestors()=" + getAncestors() + ", getStandardName()=" + getStandardName()
				+ ", getChargingStandard()=" + getChargingStandard() + ", getCalculationMehod()="
				+ getCalculationMehod() + ", getStandardState()=" + getStandardState() + ", getProportionDamags()="
				+ getProportionDamags() + ", getProjectModification()=" + getProjectModification()
				+ ", getBillingCycle()=" + getBillingCycle() + ", getBilingStartDate()=" + getBilingStartDate()
				+ ", getAuditResultsReason()=" + getAuditResultsReason() + ", getBilingEndDate()=" + getBilingEndDate() + ", getFeeDateOld()=" + getFeeDateOld()
				+ ", getFeeDate()=" + getFeeDate() + ", getDueDateOld()=" + getDueDateOld() + ", getDueDate()="
				+ getDueDate() + ", getAmountReceivableOld()=" + getAmountReceivableOld() + ", getAmountReceivable()="
				+ getAmountReceivable() + ", getAmountActually()=" + getAmountActually() + ", getRemarks()="
				+ getRemarks() + ", getOperationUser()=" + getOperationUser() + ", getOperationType()="
				+ getOperationType() + ", getDeleteReason()=" + getDeleteReason() + ", getAdvancePaymetnOffset()="
				+ getAdvancePaymetnOffset() + ", getWriteOff()=" + getWriteOff() + ", getRefundAmount()="
				+ getRefundAmount() + ", getAmountArrears()=" + getAmountArrears() + ", getCollectionStatus()="
				+ getCollectionStatus() + ", getFrozenState()=" + getFrozenState() + ", getAdvanceStatus()="
				+ getAdvanceStatus() + ", getDeliveryStatus()=" + getDeliveryStatus() + ", getHyParkingInf()="
				+ getHyParkingInf() + ", getHyHouseInf()=" + getHyHouseInf() + ", getHyOwnerRegistration()="
				+ getHyOwnerRegistration() + ", getHouseNum()=" + getHouseNum() + ", getFeeNum()=" + getFeeNum()
				+ ", getFrozenPerson()=" + getFrozenPerson() + ", getFrozenDate()=" + getFrozenDate()
				+ ", getOperationDate()=" + getOperationDate() + ", getFrozenReason()=" + getFrozenReason()
				+ ", getStandardDescription()=" + getStandardDescription() + ", getSearchValue()=" + getSearchValue()
				+ ", getCreateBy()=" + getCreateBy() + ", getCreateTime()=" + getCreateTime() + ", getUpdateBy()="
				+ getUpdateBy() + ", getUpdateTime()=" + getUpdateTime() + ", getRemark()=" + getRemark()
				+ ", getParams()=" + getParams() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
