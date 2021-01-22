package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.annotation.EnumAnn;
import com.ruoyi.system.enums.AuditEnum;

/**
 * 费用减免对象 hy_fee_remission
 * 
 * @author Administrator
 * @date 2021-01-13
 */
public class HyFeeRemission extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private Long id;

	/** 减免业务类型 */
	@Excel(name = "减免业务类型")
	private Integer businessExemptedType;

	/** 费用名称 */
	@Excel(name = "费用名称")
	private String feeName;

	/** 减免类型 */
	@Excel(name = "减免类型")
	private Integer reliefTypes;

	/** 减免总金额 */
	@Excel(name = "减免总金额")
	private BigDecimal totalAmountDeduction;

	/** 已减免金额 */
	@Excel(name = "已减免金额")
	private BigDecimal reducedAmount;

	/** 取消减免金额 */
	@Excel(name = "取消减免金额")
	private BigDecimal cancellationCreditAmount;

	/** 每月减免金额 */
	@Excel(name = "每月减免金额")
	private BigDecimal monthlyDeductionAmount;

	/** 减免比例 */
	@Excel(name = "减免比例")
	private BigDecimal reductionRatio;

	/** 均摊减免总金额 */
	@Excel(name = "均摊减免总金额")
	private BigDecimal sharingTotalDeduction;

	/** 开始时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date timeStr;

	/** 结束时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date timeEnd;

	/** 减免原因 */
	@Excel(name = "减免原因")
	private String exemptionReason;

	/** 备注 */
	@Excel(name = "备注")
	private String remarks;

	/** 是否冲抵修改记录 */
	@Excel(name = "是否冲抵修改记录")
	private String offsetModificationRecord;

	/** 审核状态 */
	@Excel(name = "审核状态")
	@EnumAnn(enumClass = AuditEnum.class, enumType = "Integer")
	private Integer auditStatus;

	/** 税率 */
	@Excel(name = "税率")
	private BigDecimal taxRate;

	/** 费用日期 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "费用日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date feeDate;

	/** 应收日期 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "应收日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date dueDate;

	/** 减免年份 */
	@Excel(name = "减免年份")
	private String remissionYear;

	/** 减免月份 */
	@Excel(name = "减免月份")
	private String remissionMonth;

	/** 减免登记人 */
	@Excel(name = "减免登记人")
	private String exemptionRegistrant;

	/** 登记时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "登记时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date registrationTime;

	/** 是否减免 */
	@Excel(name = "是否减免")
	private Integer reduceNot;

	/** 未减免金额 */
	@Excel(name = "未减免金额")
	private BigDecimal amountNotRemitted;

	/** 含税金额 */
	@Excel(name = "含税金额")
	private BigDecimal amountTaxInc;

	/** 税费 */
	@Excel(name = "税费")
	private BigDecimal taxation;

	/** 不含税金额 */
	@Excel(name = "不含税金额")
	private BigDecimal amountExcludingTax;

	/** 冲抵时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "冲抵时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date offsetTime;

	/** 撤销时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "撤销时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date cancellationTime;

	/** 撤销人 */
	@Excel(name = "撤销人")
	private String revocation;

	/** 是否冲销 */
	@Excel(name = "是否冲销")
	private Integer writeoffOnt;

	/** 冲销时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "冲销时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date writeoffTime;

	private String houseNumber;

	private String houseName;

	private Integer parkingNumber;

	private String ownerName;

	private String meterName;

	private int registrationMark;

	private HyOwnerRegistration hyOwnerRegistration;

	private HyHouseInf hyHouseInf;

	private HyParkingInf hyParkingInf;

	private HyMeter hyMeter;

	public HyHouseInf getHyHouseInf() {
		return hyHouseInf;
	}

	public void setHyHouseInf(HyHouseInf hyHouseInf) {
		this.hyHouseInf = hyHouseInf;
	}

	public HyParkingInf getHyParkingInf() {
		return hyParkingInf;
	}

	public void setHyParkingInf(HyParkingInf hyParkingInf) {
		this.hyParkingInf = hyParkingInf;
	}

	public HyMeter getHyMeter() {
		return hyMeter;
	}

	public void setHyMeter(HyMeter hyMeter) {
		this.hyMeter = hyMeter;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setBusinessExemptedType(Integer businessExemptedType) {
		this.businessExemptedType = businessExemptedType;
	}

	public Integer getBusinessExemptedType() {
		return businessExemptedType;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public String getFeeName() {
		return feeName;
	}

	public void setReliefTypes(Integer reliefTypes) {
		this.reliefTypes = reliefTypes;
	}

	public Integer getReliefTypes() {
		return reliefTypes;
	}

	public void setTotalAmountDeduction(BigDecimal totalAmountDeduction) {
		this.totalAmountDeduction = totalAmountDeduction;
	}

	public BigDecimal getTotalAmountDeduction() {
		return totalAmountDeduction;
	}

	public void setReducedAmount(BigDecimal reducedAmount) {
		this.reducedAmount = reducedAmount;
	}

	public BigDecimal getReducedAmount() {
		return reducedAmount;
	}

	public void setCancellationCreditAmount(BigDecimal cancellationCreditAmount) {
		this.cancellationCreditAmount = cancellationCreditAmount;
	}

	public BigDecimal getCancellationCreditAmount() {
		return cancellationCreditAmount;
	}

	public void setMonthlyDeductionAmount(BigDecimal monthlyDeductionAmount) {
		this.monthlyDeductionAmount = monthlyDeductionAmount;
	}

	public BigDecimal getMonthlyDeductionAmount() {
		return monthlyDeductionAmount;
	}

	public void setReductionRatio(BigDecimal reductionRatio) {
		this.reductionRatio = reductionRatio;
	}

	public BigDecimal getReductionRatio() {
		return reductionRatio;
	}

	public void setSharingTotalDeduction(BigDecimal sharingTotalDeduction) {
		this.sharingTotalDeduction = sharingTotalDeduction;
	}

	public BigDecimal getSharingTotalDeduction() {
		return sharingTotalDeduction;
	}

	public void setTimeStr(Date timeStr) {
		this.timeStr = timeStr;
	}

	public Date getTimeStr() {
		return timeStr;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setExemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
	}

	public String getExemptionReason() {
		return exemptionReason;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setOffsetModificationRecord(String offsetModificationRecord) {
		this.offsetModificationRecord = offsetModificationRecord;
	}

	public String getOffsetModificationRecord() {
		return offsetModificationRecord;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setFeeDate(Date feeDate) {
		this.feeDate = feeDate;
	}

	public Date getFeeDate() {
		return feeDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setRemissionYear(String remissionYear) {
		this.remissionYear = remissionYear;
	}

	public String getRemissionYear() {
		return remissionYear;
	}

	public void setRemissionMonth(String remissionMonth) {
		this.remissionMonth = remissionMonth;
	}

	public String getRemissionMonth() {
		return remissionMonth;
	}

	public void setExemptionRegistrant(String exemptionRegistrant) {
		this.exemptionRegistrant = exemptionRegistrant;
	}

	public String getExemptionRegistrant() {
		return exemptionRegistrant;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setReduceNot(Integer reduceNot) {
		this.reduceNot = reduceNot;
	}

	public Integer getReduceNot() {
		return reduceNot;
	}

	public void setAmountNotRemitted(BigDecimal amountNotRemitted) {
		this.amountNotRemitted = amountNotRemitted;
	}

	public BigDecimal getAmountNotRemitted() {
		return amountNotRemitted;
	}

	public void setAmountTaxInc(BigDecimal amountTaxInc) {
		this.amountTaxInc = amountTaxInc;
	}

	public BigDecimal getAmountTaxInc() {
		return amountTaxInc;
	}

	public void setTaxation(BigDecimal taxation) {
		this.taxation = taxation;
	}

	public BigDecimal getTaxation() {
		return taxation;
	}

	public void setAmountExcludingTax(BigDecimal amountExcludingTax) {
		this.amountExcludingTax = amountExcludingTax;
	}

	public BigDecimal getAmountExcludingTax() {
		return amountExcludingTax;
	}

	public void setOffsetTime(Date offsetTime) {
		this.offsetTime = offsetTime;
	}

	public Date getOffsetTime() {
		return offsetTime;
	}

	public void setCancellationTime(Date cancellationTime) {
		this.cancellationTime = cancellationTime;
	}

	public Date getCancellationTime() {
		return cancellationTime;
	}

	public void setRevocation(String revocation) {
		this.revocation = revocation;
	}

	public String getRevocation() {
		return revocation;
	}

	public void setWriteoffOnt(Integer writeoffOnt) {
		this.writeoffOnt = writeoffOnt;
	}

	public Integer getWriteoffOnt() {
		return writeoffOnt;
	}

	public void setWriteoffTime(Date writeoffTime) {
		this.writeoffTime = writeoffTime;
	}

	public Date getWriteoffTime() {
		return writeoffTime;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public Integer getParkingNumber() {
		return parkingNumber;
	}

	public void setParkingNumber(Integer parkingNumber) {
		this.parkingNumber = parkingNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getMeterName() {
		return meterName;
	}

	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}

	public int getRegistrationMark() {
		return registrationMark;
	}

	public void setRegistrationMark(int registrationMark) {
		this.registrationMark = registrationMark;
	}

	public HyOwnerRegistration getHyOwnerRegistration() {
		return hyOwnerRegistration;
	}

	public void setHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		this.hyOwnerRegistration = hyOwnerRegistration;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	@Override
	public String toString() {
		return "HyFeeRemission [id=" + id + ", businessExemptedType=" + businessExemptedType + ", feeName=" + feeName
				+ ", reliefTypes=" + reliefTypes + ", totalAmountDeduction=" + totalAmountDeduction + ", reducedAmount="
				+ reducedAmount + ", cancellationCreditAmount=" + cancellationCreditAmount + ", monthlyDeductionAmount="
				+ monthlyDeductionAmount + ", reductionRatio=" + reductionRatio + ", sharingTotalDeduction="
				+ sharingTotalDeduction + ", timeStr=" + timeStr + ", timeEnd=" + timeEnd + ", exemptionReason="
				+ exemptionReason + ", remarks=" + remarks + ", offsetModificationRecord=" + offsetModificationRecord
				+ ", auditStatus=" + auditStatus + ", taxRate=" + taxRate + ", feeDate=" + feeDate + ", dueDate="
				+ dueDate + ", remissionYear=" + remissionYear + ", remissionMonth=" + remissionMonth
				+ ", exemptionRegistrant=" + exemptionRegistrant + ", registrationTime=" + registrationTime
				+ ", reduceNot=" + reduceNot + ", amountNotRemitted=" + amountNotRemitted + ", amountTaxInc="
				+ amountTaxInc + ", taxation=" + taxation + ", amountExcludingTax=" + amountExcludingTax
				+ ", offsetTime=" + offsetTime + ", cancellationTime=" + cancellationTime + ", revocation=" + revocation
				+ ", writeoffOnt=" + writeoffOnt + ", writeoffTime=" + writeoffTime + ", houseNumber=" + houseNumber
				+ ", houseName=" + houseName + ", parkingNumber=" + parkingNumber + ", ownerName=" + ownerName
				+ ", meterName=" + meterName + ", hyOwnerRegistration=" + hyOwnerRegistration + ", hyHouseInf="
				+ hyHouseInf + ", hyParkingInf=" + hyParkingInf + ", hyMeter=" + hyMeter + ", getHyHouseInf()="
				+ getHyHouseInf() + ", getHyParkingInf()=" + getHyParkingInf() + ", getHyMeter()=" + getHyMeter()
				+ ", getId()=" + getId() + ", getBusinessExemptedType()=" + getBusinessExemptedType()
				+ ", getFeeName()=" + getFeeName() + ", getReliefTypes()=" + getReliefTypes()
				+ ", getTotalAmountDeduction()=" + getTotalAmountDeduction() + ", getReducedAmount()="
				+ getReducedAmount() + ", getCancellationCreditAmount()=" + getCancellationCreditAmount()
				+ ", getMonthlyDeductionAmount()=" + getMonthlyDeductionAmount() + ", getReductionRatio()="
				+ getReductionRatio() + ", getSharingTotalDeduction()=" + getSharingTotalDeduction() + ", getTimeStr()="
				+ getTimeStr() + ", getTimeEnd()=" + getTimeEnd() + ", getExemptionReason()=" + getExemptionReason()
				+ ", getRemarks()=" + getRemarks() + ", getOffsetModificationRecord()=" + getOffsetModificationRecord()
				+ ", getAuditStatus()=" + getAuditStatus() + ", getTaxRate()=" + getTaxRate() + ", getFeeDate()="
				+ getFeeDate() + ", getDueDate()=" + getDueDate() + ", getRemissionYear()=" + getRemissionYear()
				+ ", getRemissionMonth()=" + getRemissionMonth() + ", getExemptionRegistrant()="
				+ getExemptionRegistrant() + ", getRegistrationTime()=" + getRegistrationTime() + ", getReduceNot()="
				+ getReduceNot() + ", getAmountNotRemitted()=" + getAmountNotRemitted() + ", getAmountTaxInc()="
				+ getAmountTaxInc() + ", getTaxation()=" + getTaxation() + ", getAmountExcludingTax()="
				+ getAmountExcludingTax() + ", getOffsetTime()=" + getOffsetTime() + ", getCancellationTime()="
				+ getCancellationTime() + ", getRevocation()=" + getRevocation() + ", getWriteoffOnt()="
				+ getWriteoffOnt() + ", getWriteoffTime()=" + getWriteoffTime() + ", getHouseName()=" + getHouseName()
				+ ", getParkingNumber()=" + getParkingNumber() + ", getOwnerName()=" + getOwnerName()
				+ ", getMeterName()=" + getMeterName() + ", getHyOwnerRegistration()=" + getHyOwnerRegistration()
				+ ", getHouseNumber()=" + getHouseNumber() + "]";
	}

}
