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

    /** 房屋id */
    @Excel(name = "房屋id")
    private Long houseId;

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

    /** 减免登记标识 */
    @Excel(name = "减免登记标识")
    private Integer registrationMark;

    /** 减免方式 */
    @Excel(name = "减免方式")
    private Long reductionExemption;

    /** 减免基数 */
    @Excel(name = "减免基数")
    private String deductionBase;

    /** 计算截至日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计算截至日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date closingDate;

    /** 减免登记时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "减免登记时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date exemptionRegistration;
	
	private HyOwnerRegistration hyOwnerRegistration;

	private HyHouseInf hyHouseInf;

	private HyParkingInf hyParkingInf;

	private HyMeter hyMeter;
	
	private HyCost hyCost;
	
	private HyDamages hyDamages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public Integer getBusinessExemptedType() {
		return businessExemptedType;
	}

	public void setBusinessExemptedType(Integer businessExemptedType) {
		this.businessExemptedType = businessExemptedType;
	}

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public Integer getReliefTypes() {
		return reliefTypes;
	}

	public void setReliefTypes(Integer reliefTypes) {
		this.reliefTypes = reliefTypes;
	}

	public BigDecimal getTotalAmountDeduction() {
		return totalAmountDeduction;
	}

	public void setTotalAmountDeduction(BigDecimal totalAmountDeduction) {
		this.totalAmountDeduction = totalAmountDeduction;
	}

	public BigDecimal getReducedAmount() {
		return reducedAmount;
	}

	public void setReducedAmount(BigDecimal reducedAmount) {
		this.reducedAmount = reducedAmount;
	}

	public BigDecimal getCancellationCreditAmount() {
		return cancellationCreditAmount;
	}

	public void setCancellationCreditAmount(BigDecimal cancellationCreditAmount) {
		this.cancellationCreditAmount = cancellationCreditAmount;
	}

	public BigDecimal getMonthlyDeductionAmount() {
		return monthlyDeductionAmount;
	}

	public void setMonthlyDeductionAmount(BigDecimal monthlyDeductionAmount) {
		this.monthlyDeductionAmount = monthlyDeductionAmount;
	}

	public BigDecimal getReductionRatio() {
		return reductionRatio;
	}

	public void setReductionRatio(BigDecimal reductionRatio) {
		this.reductionRatio = reductionRatio;
	}

	public BigDecimal getSharingTotalDeduction() {
		return sharingTotalDeduction;
	}

	public void setSharingTotalDeduction(BigDecimal sharingTotalDeduction) {
		this.sharingTotalDeduction = sharingTotalDeduction;
	}

	public Date getTimeStr() {
		return timeStr;
	}

	public void setTimeStr(Date timeStr) {
		this.timeStr = timeStr;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getExemptionReason() {
		return exemptionReason;
	}

	public void setExemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOffsetModificationRecord() {
		return offsetModificationRecord;
	}

	public void setOffsetModificationRecord(String offsetModificationRecord) {
		this.offsetModificationRecord = offsetModificationRecord;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public Date getFeeDate() {
		return feeDate;
	}

	public void setFeeDate(Date feeDate) {
		this.feeDate = feeDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getRemissionYear() {
		return remissionYear;
	}

	public void setRemissionYear(String remissionYear) {
		this.remissionYear = remissionYear;
	}

	public String getRemissionMonth() {
		return remissionMonth;
	}

	public void setRemissionMonth(String remissionMonth) {
		this.remissionMonth = remissionMonth;
	}

	public String getExemptionRegistrant() {
		return exemptionRegistrant;
	}

	public void setExemptionRegistrant(String exemptionRegistrant) {
		this.exemptionRegistrant = exemptionRegistrant;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Integer getReduceNot() {
		return reduceNot;
	}

	public void setReduceNot(Integer reduceNot) {
		this.reduceNot = reduceNot;
	}

	public BigDecimal getAmountNotRemitted() {
		return amountNotRemitted;
	}

	public void setAmountNotRemitted(BigDecimal amountNotRemitted) {
		this.amountNotRemitted = amountNotRemitted;
	}

	public BigDecimal getAmountTaxInc() {
		return amountTaxInc;
	}

	public void setAmountTaxInc(BigDecimal amountTaxInc) {
		this.amountTaxInc = amountTaxInc;
	}

	public BigDecimal getTaxation() {
		return taxation;
	}

	public void setTaxation(BigDecimal taxation) {
		this.taxation = taxation;
	}

	public BigDecimal getAmountExcludingTax() {
		return amountExcludingTax;
	}

	public void setAmountExcludingTax(BigDecimal amountExcludingTax) {
		this.amountExcludingTax = amountExcludingTax;
	}

	public Date getOffsetTime() {
		return offsetTime;
	}

	public void setOffsetTime(Date offsetTime) {
		this.offsetTime = offsetTime;
	}

	public Date getCancellationTime() {
		return cancellationTime;
	}

	public void setCancellationTime(Date cancellationTime) {
		this.cancellationTime = cancellationTime;
	}

	public String getRevocation() {
		return revocation;
	}

	public void setRevocation(String revocation) {
		this.revocation = revocation;
	}

	public Integer getWriteoffOnt() {
		return writeoffOnt;
	}

	public void setWriteoffOnt(Integer writeoffOnt) {
		this.writeoffOnt = writeoffOnt;
	}

	public Date getWriteoffTime() {
		return writeoffTime;
	}

	public void setWriteoffTime(Date writeoffTime) {
		this.writeoffTime = writeoffTime;
	}

	public Integer getRegistrationMark() {
		return registrationMark;
	}

	public void setRegistrationMark(Integer registrationMark) {
		this.registrationMark = registrationMark;
	}

	public Long getReductionExemption() {
		return reductionExemption;
	}

	public void setReductionExemption(Long reductionExemption) {
		this.reductionExemption = reductionExemption;
	}

	public String getDeductionBase() {
		return deductionBase;
	}

	public void setDeductionBase(String deductionBase) {
		this.deductionBase = deductionBase;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Date getExemptionRegistration() {
		return exemptionRegistration;
	}

	public void setExemptionRegistration(Date exemptionRegistration) {
		this.exemptionRegistration = exemptionRegistration;
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

	public HyCost getHyCost() {
		return hyCost;
	}

	public void setHyCost(HyCost hyCost) {
		this.hyCost = hyCost;
	}

	public HyDamages getHyDamages() {
		return hyDamages;
	}

	public void setHyDamages(HyDamages hyDamages) {
		this.hyDamages = hyDamages;
	}

	@Override
	public String toString() {
		return "HyFeeRemission [id=" + id + ", houseId=" + houseId + ", businessExemptedType=" + businessExemptedType
				+ ", feeName=" + feeName + ", reliefTypes=" + reliefTypes + ", totalAmountDeduction="
				+ totalAmountDeduction + ", reducedAmount=" + reducedAmount + ", cancellationCreditAmount="
				+ cancellationCreditAmount + ", monthlyDeductionAmount=" + monthlyDeductionAmount + ", reductionRatio="
				+ reductionRatio + ", sharingTotalDeduction=" + sharingTotalDeduction + ", timeStr=" + timeStr
				+ ", timeEnd=" + timeEnd + ", exemptionReason=" + exemptionReason + ", remarks=" + remarks
				+ ", offsetModificationRecord=" + offsetModificationRecord + ", auditStatus=" + auditStatus
				+ ", taxRate=" + taxRate + ", feeDate=" + feeDate + ", dueDate=" + dueDate + ", remissionYear="
				+ remissionYear + ", remissionMonth=" + remissionMonth + ", exemptionRegistrant=" + exemptionRegistrant
				+ ", registrationTime=" + registrationTime + ", reduceNot=" + reduceNot + ", amountNotRemitted="
				+ amountNotRemitted + ", amountTaxInc=" + amountTaxInc + ", taxation=" + taxation
				+ ", amountExcludingTax=" + amountExcludingTax + ", offsetTime=" + offsetTime + ", cancellationTime="
				+ cancellationTime + ", revocation=" + revocation + ", writeoffOnt=" + writeoffOnt + ", writeoffTime="
				+ writeoffTime + ", registrationMark=" + registrationMark + ", reductionExemption=" + reductionExemption
				+ ", deductionBase=" + deductionBase + ", closingDate=" + closingDate + ", exemptionRegistration="
				+ exemptionRegistration + ", hyOwnerRegistration=" + hyOwnerRegistration + ", hyHouseInf=" + hyHouseInf
				+ ", hyParkingInf=" + hyParkingInf + ", hyMeter=" + hyMeter + ", hyCost=" + hyCost + ", hyDamages="
				+ hyDamages + "]";
	}






}
