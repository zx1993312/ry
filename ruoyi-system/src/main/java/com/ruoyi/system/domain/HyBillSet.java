package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.annotation.EnumAnn;
import com.ruoyi.system.enums.PanelEnum;

/**
 * 票据设置对象 hy_bill_set
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public class HyBillSet extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private Long id;
	
	
	/** 票据种类 */
	@Excel(name = "票据种类")
	@EnumAnn(enumClass = PanelEnum.class, enumType = "String")
	private String billTypes;
	
	/**
	 * 票据号码
	 */
	@Excel(name = "票据号码")
	private String billNumber;
	
	/**
	 * 发票号码
	 */
	@Excel(name = "发票号码")
	private String invoiceNumber;

	/** 票据类别 */
	@Excel(name = "票据类别")
	private String billCategory;
	
	/**
	 * 票据日期
	 */
	@Excel(name = " 票据日期")
	private Date billDate;
	
	/**
	 * 新票据日期
	 */
	@Excel(name = "新票据日期")
	private Date billDateNew;

	/** 前缀 */
	@Excel(name = "前缀")
	private String prefix;

	/** 后缀 */
	@Excel(name = "后缀")
	private String suffix;

	/** 位数 */
	@Excel(name = "位数")
	private String digit;
	
	/**
	 * 新收款方式
	 */
	@Excel(name = "新收款方式")
	private String paymentMethodNew;
	
	/**
	 * 收款方式
	 */
	@Excel(name = "收款方式")
	private String paymentMethod;
	
	/**
	 * 收款人
	 */
	@Excel(name = "收款人")
	private String paymentPerson;
	
	/**
	 * 收款时间
	 */
	@Excel(name = "收款时间")
	private Date paymentDate;
	
	/**
	 * 修改人
	 */
	@Excel(name = "修改人")
	private String modifyPerson;
	
	/**
	 * 修改时间
	 */
	@Excel(name = "修改时间")
	private Date modifyTime;

	/** 票据样例 */
	@Excel(name = "票据样例")
	private String billSample;

	/** 定额票据面板 */
	@Excel(name = "定额票据面板")
	private String billPanel;

	@Excel(name = "定额票据")
	private String panel;
	
	/**
	 * 房屋表
	 */
	@Excel(name = "房屋表")
	private HyHouseInf hyHouseInf;
	
	/**
	 * 费用项目id
	 */
	@Excel(name = "费用项目id")
	private Long costId;
	
	/**
	 * 费用项目表
	 */
	@Excel(name = "费用项目表")
	private HyCost hyCost;
	
	/**
	 * 撤销对象id
	 */
	@Excel(name = "撤销对象id")
	private Long revokeId;
	
	/**
	 * 撤销对象表
	 */
	@Excel(name = "撤销对象表")
	private HyRevoke hyRevoke;
	
	/**
	 * 预交冲抵id
	 */
	@Excel(name = "交冲抵id")
	private Long offsetId;
	
	/**
	 * 预交冲抵表
	 */
	@Excel(name = "预交冲抵表")
	private HyPaymentOffset hyPaymentOffset;
	/** 业务类型 */
	@Excel(name = "业务类型")
	private Integer businessType;

	private BigDecimal paymentAmount;

	private Integer cancelNot;

	private Integer writeNot;

	private String remark;

	private String draftCheckNumber;

	private BigDecimal billAmount;
	
	/** 业主id */
	@Excel(name = "业主id")
	private Long ownerId;
	
	/**
	 * 业主表
	 */
	@Excel(name = "业主表")
	private HyOwnerRegistration hyOwnerRegistration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillTypes() {
		return billTypes;
	}

	public void setBillTypes(String billTypes) {
		this.billTypes = billTypes;
	}

	public String getBillCategory() {
		return billCategory;
	}

	public void setBillCategory(String billCategory) {
		this.billCategory = billCategory;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getDigit() {
		return digit;
	}

	public void setDigit(String digit) {
		this.digit = digit;
	}

	public String getBillSample() {
		return billSample;
	}

	public void setBillSample(String billSample) {
		this.billSample = billSample;
	}

	public String getBillPanel() {
		return billPanel;
	}

	public void setBillPanel(String billPanel) {
		this.billPanel = billPanel;
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String panel) {
		this.panel = panel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Date getBillDateNew() {
		return billDateNew;
	}

	public void setBillDateNew(Date billDateNew) {
		this.billDateNew = billDateNew;
	}

	public String getPaymentMethodNew() {
		return paymentMethodNew;
	}

	public void setPaymentMethodNew(String paymentMethodNew) {
		this.paymentMethodNew = paymentMethodNew;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentPerson() {
		return paymentPerson;
	}

	public void setPaymentPerson(String paymentPerson) {
		this.paymentPerson = paymentPerson;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getModifyPerson() {
		return modifyPerson;
	}

	public void setModifyPerson(String modifyPerson) {
		this.modifyPerson = modifyPerson;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
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

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Integer getCancelNot() {
		return cancelNot;
	}

	public void setCancelNot(Integer cancelNot) {
		this.cancelNot = cancelNot;
	}

	public Integer getWriteNot() {
		return writeNot;
	}

	public void setWriteNot(Integer writeNot) {
		this.writeNot = writeNot;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDraftCheckNumber() {
		return draftCheckNumber;
	}

	public void setDraftCheckNumber(String draftCheckNumber) {
		this.draftCheckNumber = draftCheckNumber;
	}

	public HyCost getHyCost() {
		return hyCost;
	}

	public void setHyCost(HyCost hyCost) {
		this.hyCost = hyCost;
	}

	public HyRevoke getHyRevoke() {
		return hyRevoke;
	}

	public void setHyRevoke(HyRevoke hyRevoke) {
		this.hyRevoke = hyRevoke;
	}

	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}

	public HyPaymentOffset getHyPaymentOffset() {
		return hyPaymentOffset;
	}

	public void setHyPaymentOffset(HyPaymentOffset hyPaymentOffset) {
		this.hyPaymentOffset = hyPaymentOffset;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getCostId() {
		return costId;
	}

	public void setCostId(Long costId) {
		this.costId = costId;
	}

	public Long getRevokeId() {
		return revokeId;
	}

	public void setRevokeId(Long revokeId) {
		this.revokeId = revokeId;
	}

	public Long getOffsetId() {
		return offsetId;
	}

	public void setOffsetId(Long offsetId) {
		this.offsetId = offsetId;
	}

	@Override
	public String toString() {
		return "HyBillSet [id=" + id + ", billTypes=" + billTypes + ", billNumber=" + billNumber + ", invoiceNumber="
				+ invoiceNumber + ", billCategory=" + billCategory + ", billDate=" + billDate + ", billDateNew="
				+ billDateNew + ", prefix=" + prefix + ", suffix=" + suffix + ", digit=" + digit + ", paymentMethodNew="
				+ paymentMethodNew + ", paymentMethod=" + paymentMethod + ", paymentPerson=" + paymentPerson
				+ ", paymentDate=" + paymentDate + ", modifyPerson=" + modifyPerson + ", modifyTime=" + modifyTime
				+ ", billSample=" + billSample + ", billPanel=" + billPanel + ", panel=" + panel + ", hyHouseInf="
				+ hyHouseInf + ", costId=" + costId + ", hyCost=" + hyCost + ", revokeId=" + revokeId + ", hyRevoke="
				+ hyRevoke + ", offsetId=" + offsetId + ", hyPaymentOffset=" + hyPaymentOffset + ", businessType="
				+ businessType + ", paymentAmount=" + paymentAmount + ", cancelNot=" + cancelNot + ", writeNot="
				+ writeNot + ", remark=" + remark + ", draftCheckNumber=" + draftCheckNumber + ", billAmount="
				+ billAmount + ", ownerId=" + ownerId + ", hyOwnerRegistration=" + hyOwnerRegistration + "]";
	}



}
