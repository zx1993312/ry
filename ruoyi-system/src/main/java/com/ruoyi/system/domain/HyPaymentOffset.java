package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预交冲抵对象 hy_payment_offset
 * 
 * @author Administrator
 * @date 2021-01-25
 */
public class HyPaymentOffset extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private Long id;

	/** 房屋编号 */
	@Excel(name = "房屋编号")
	private String houseNum;

	/** 冲抵类别 */
	@Excel(name = "冲抵类别")
	private Integer offsetCategory;

	/** 冲抵人 */
	@Excel(name = "冲抵人")
	private String offsetPreson;
	
	/** 冲抵费用项目 */
	@Excel(name = "冲抵费用项目")
	private String offsetExpense;
	
	/** 预交金额 */
	@Excel(name = "预交金额")
	private BigDecimal advanceAmount;

	/** 冲抵操作时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "冲抵操作时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date offsetOperationDate;

	/** 冲抵范围 */
	@Excel(name = "冲抵范围")
	private String offsetRange;

	/** 冲抵抵用时间 */
	@Excel(name = "冲抵抵用时间")
	private String offsetDate;

	/** 导入人 */
	@Excel(name = "导入人")
	private String importPerson;

	/** 导入时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "导入时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date importTime;

	/** 预交时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "预交时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date advanceTime;
	/**
	 * 审核表
	 */
	@Excel(name = "审核表")
	private HyAuditManagement hyAuditManagement;
	/**
	 * 费用项目表
	 */
	@Excel(name = "费用项目表")
	private HyCost hyCost;
	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setOffsetCategory(Integer offsetCategory) {
		this.offsetCategory = offsetCategory;
	}

	public Integer getOffsetCategory() {
		return offsetCategory;
	}

	public void setOffsetPreson(String offsetPreson) {
		this.offsetPreson = offsetPreson;
	}

	public String getOffsetPreson() {
		return offsetPreson;
	}

	public void setOffsetOperationDate(Date offsetOperationDate) {
		this.offsetOperationDate = offsetOperationDate;
	}

	public Date getOffsetOperationDate() {
		return offsetOperationDate;
	}

	public void setOffsetRange(String offsetRange) {
		this.offsetRange = offsetRange;
	}

	public String getOffsetRange() {
		return offsetRange;
	}

	public void setOffsetDate(String offsetDate) {
		this.offsetDate = offsetDate;
	}

	public String getOffsetDate() {
		return offsetDate;
	}

	public void setImportPerson(String importPerson) {
		this.importPerson = importPerson;
	}

	public String getImportPerson() {
		return importPerson;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public Date getImportTime() {
		return importTime;
	}



	public Date getAdvanceTime() {
		return advanceTime;
	}

	public void setAdvanceTime(Date advanceTime) {
		this.advanceTime = advanceTime;
	}

	public HyAuditManagement getHyAuditManagement() {
		return hyAuditManagement;
	}

	public void setHyAuditManagement(HyAuditManagement hyAuditManagement) {
		this.hyAuditManagement = hyAuditManagement;
	}

	public HyCost getHyCost() {
		return hyCost;
	}

	public void setHyCost(HyCost hyCost) {
		this.hyCost = hyCost;
	}

	public String getOffsetExpense() {
		return offsetExpense;
	}

	public void setOffsetExpense(String offsetExpense) {
		this.offsetExpense = offsetExpense;
	}

	public BigDecimal getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(BigDecimal advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	@Override
	public String toString() {
		return "HyPaymentOffset [id=" + id + ", houseNum=" + houseNum + ", offsetCategory=" + offsetCategory
				+ ", offsetPreson=" + offsetPreson + ", offsetExpense=" + offsetExpense + ", advanceAmount="
				+ advanceAmount + ", offsetOperationDate=" + offsetOperationDate + ", offsetRange=" + offsetRange
				+ ", offsetDate=" + offsetDate + ", importPerson=" + importPerson + ", importTime=" + importTime
				+ ", advanceTime=" + advanceTime + ", hyAuditManagement=" + hyAuditManagement + ", hyCost=" + hyCost
				+ "]";
	}



}
