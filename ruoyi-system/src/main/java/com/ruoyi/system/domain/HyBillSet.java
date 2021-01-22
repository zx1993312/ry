package com.ruoyi.system.domain;

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
	/**
	 * 房屋编号
	 */
	@Excel(name = "房屋编号")
	private String houseNum;
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

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
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

	@Override
	public String toString() {
		return "HyBillSet [id=" + id + ", houseNum=" + houseNum + ", billTypes=" + billTypes + ", billNumber="
				+ billNumber + ", invoiceNumber=" + invoiceNumber + ", billCategory=" + billCategory + ", billDate="
				+ billDate + ", billDateNew=" + billDateNew + ", prefix=" + prefix + ", suffix=" + suffix + ", digit="
				+ digit + ", paymentMethodNew=" + paymentMethodNew + ", paymentMethod=" + paymentMethod
				+ ", paymentPerson=" + paymentPerson + ", paymentDate=" + paymentDate + ", modifyPerson=" + modifyPerson
				+ ", modifyTime=" + modifyTime + ", billSample=" + billSample + ", billPanel=" + billPanel + ", panel="
				+ panel + ", getId()=" + getId() + ", getBillTypes()=" + getBillTypes() + ", getBillCategory()="
				+ getBillCategory() + ", getPrefix()=" + getPrefix() + ", getSuffix()=" + getSuffix() + ", getDigit()="
				+ getDigit() + ", getBillSample()=" + getBillSample() + ", getBillPanel()=" + getBillPanel()
				+ ", getPanel()=" + getPanel() + ", getHouseNum()=" + getHouseNum() + ", getBillNumber()="
				+ getBillNumber() + ", getInvoiceNumber()=" + getInvoiceNumber() + ", getBillDate()=" + getBillDate()
				+ ", getBillDateNew()=" + getBillDateNew() + ", getPaymentMethodNew()=" + getPaymentMethodNew()
				+ ", getPaymentMethod()=" + getPaymentMethod() + ", getPaymentPerson()=" + getPaymentPerson()
				+ ", getPaymentDate()=" + getPaymentDate() + ", getModifyPerson()=" + getModifyPerson()
				+ ", getModifyTime()=" + getModifyTime() + ", getSearchValue()=" + getSearchValue() + ", getCreateBy()="
				+ getCreateBy() + ", getCreateTime()=" + getCreateTime() + ", getUpdateBy()=" + getUpdateBy()
				+ ", getUpdateTime()=" + getUpdateTime() + ", getRemark()=" + getRemark() + ", getParams()="
				+ getParams() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
