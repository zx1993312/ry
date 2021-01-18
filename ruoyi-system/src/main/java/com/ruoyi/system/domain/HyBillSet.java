package com.ruoyi.system.domain;

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

	/** 票据类别 */
	@Excel(name = "票据类别")
	private String billCategory;

	/** 前缀 */
	@Excel(name = "前缀")
	private String prefix;

	/** 后缀 */
	@Excel(name = "后缀")
	private String suffix;

	/** 位数 */
	@Excel(name = "位数")
	private String digit;

	/** 票据样例 */
	@Excel(name = "票据样例")
	private String billSample;

	/** 定额票据面板 */
	@Excel(name = "定额票据面板")
	private String billPanel;

	@Excel(name = "定额票据")
	private String panel;

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

	@Override
	public String toString() {
		return "HyBillSet [id=" + id + ", billTypes=" + billTypes + ", billCategory=" + billCategory + ", prefix="
				+ prefix + ", suffix=" + suffix + ", digit=" + digit + ", billSample=" + billSample + ", billPanel="
				+ billPanel + ", panel=" + panel + "]";
	}

}
