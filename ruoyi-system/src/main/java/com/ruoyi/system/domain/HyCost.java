package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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
	private String standard_Description;
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
	 * 审核结果及原因
	 */
	@Excel(name = "审核结果及原因")
	private String auditResultsReason;

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

	public String getStandard_Description() {
		return standard_Description;
	}

	public void setStandard_Description(String standard_Description) {
		this.standard_Description = standard_Description;
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

	@Override
	public String toString() {
		return "HyCost [id=" + id + ", costItems=" + costItems + ", expenseType=" + expenseType + ", parentId="
				+ parentId + ", ancestors=" + ancestors + ", standardName=" + standardName + ", chargingStandard="
				+ chargingStandard + ", calculationMehod=" + calculationMehod + ", standard_Description="
				+ standard_Description + ", standardState=" + standardState + ", proportionDamags=" + proportionDamags
				+ ", projectModification=" + projectModification + ", billingCycle=" + billingCycle
				+ ", bilingStartDate=" + bilingStartDate + ", auditResultsReason=" + auditResultsReason + ", getId()="
				+ getId() + ", getCostItems()=" + getCostItems() + ", getExpenseType()=" + getExpenseType()
				+ ", getParentId()=" + getParentId() + ", getAncestors()=" + getAncestors() + ", getStandardName()="
				+ getStandardName() + ", getChargingStandard()=" + getChargingStandard() + ", getCalculationMehod()="
				+ getCalculationMehod() + ", getStandard_Description()=" + getStandard_Description()
				+ ", getStandardState()=" + getStandardState() + ", getProportionDamags()=" + getProportionDamags()
				+ ", getProjectModification()=" + getProjectModification() + ", getBillingCycle()=" + getBillingCycle()
				+ ", getBilingStartDate()=" + getBilingStartDate() + ", getAuditResultsReason()="
				+ getAuditResultsReason() + ", getSearchValue()=" + getSearchValue() + ", getCreateBy()="
				+ getCreateBy() + ", getCreateTime()=" + getCreateTime() + ", getUpdateBy()=" + getUpdateBy()
				+ ", getUpdateTime()=" + getUpdateTime() + ", getRemark()=" + getRemark() + ", getParams()="
				+ getParams() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
