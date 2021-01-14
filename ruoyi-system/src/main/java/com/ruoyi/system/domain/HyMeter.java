package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 抄设置对象 hy_meter
 * 
 * @author Administrator
 * @date 2021-01-12
 */
public class HyMeter extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private Long id;

	/** 房屋编号 */
	@Excel(name = "房屋编号")
	private String houseNum;

	/** 表计类型 */
	@Excel(name = "表计类型")
	private Integer meterType;

	/** 表计序号 */
	@Excel(name = "表计序号")
	private Integer meterSerialNum;

	/** 表计名称 */
	@Excel(name = "表计名称")
	private String meterName;

	/** 初始读数 */
	@Excel(name = "初始读数")
	private BigDecimal initialRead;

	/** 起数 */
	@Excel(name = "起数")
	private BigDecimal meterStrNum;

	/** 止数 */
	@Excel(name = "止数")
	private BigDecimal meterEndNum;

	/** 变比 */
	@Excel(name = "变比")
	private BigDecimal transfRatio;

	/** 是否反向 */
	@Excel(name = "是否反向")
	private Integer reverseNot;

	/** 计量表类型 */
	@Excel(name = "计量表类型")
	private Integer strappingType;

	/** 抄表日期 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "抄表日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date meterReadDate;

	/** 倍率 */
	@Excel(name = "倍率")
	private BigDecimal magnification;

	/** 现用量 */
	@Excel(name = "现用量")
	private BigDecimal newMeterConsumption;

	/** 旧表用量 */
	@Excel(name = "旧表用量")
	private BigDecimal oldMeterConsumption;

	/** 损耗 */
	@Excel(name = "损耗")
	private String attritionRate;

	/** 单价 */
	@Excel(name = "单价")
	private BigDecimal unitPrice;

	/** 金额 */
	@Excel(name = "金额")
	private BigDecimal amountPrice;

	/** 异常提示 */
	@Excel(name = "异常提示")
	private String abnormalPrompt;

	/** 客户名称 */
	@Excel(name = "客户名称")
	private String customerName;

	/** 是否冻结 */
	@Excel(name = "是否冻结")
	private Integer freezeNot;

	/** 抄表来源 */
	@Excel(name = "抄表来源")
	private String sourceMeter;

	/** 抄表人 */
	@Excel(name = "抄表人")
	private String meterReader;

	/** 录入时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "录入时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date inputTime;

	@Excel(name = "表箱")
	private HyMeterCase hyMeterCase;

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

	public void setMeterType(Integer meterType) {
		this.meterType = meterType;
	}

	public Integer getMeterType() {
		return meterType;
	}

	public void setMeterSerialNum(Integer meterSerialNum) {
		this.meterSerialNum = meterSerialNum;
	}

	public Integer getMeterSerialNum() {
		return meterSerialNum;
	}

	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}

	public String getMeterName() {
		return meterName;
	}

	public void setInitialRead(BigDecimal initialRead) {
		this.initialRead = initialRead;
	}

	public BigDecimal getInitialRead() {
		return initialRead;
	}

	public void setMeterStrNum(BigDecimal meterStrNum) {
		this.meterStrNum = meterStrNum;
	}

	public BigDecimal getMeterStrNum() {
		return meterStrNum;
	}

	public void setMeterEndNum(BigDecimal meterEndNum) {
		this.meterEndNum = meterEndNum;
	}

	public BigDecimal getMeterEndNum() {
		return meterEndNum;
	}

	public void setTransfRatio(BigDecimal transfRatio) {
		this.transfRatio = transfRatio;
	}

	public BigDecimal getTransfRatio() {
		return transfRatio;
	}

	public void setReverseNot(Integer reverseNot) {
		this.reverseNot = reverseNot;
	}

	public Integer getReverseNot() {
		return reverseNot;
	}

	public void setStrappingType(Integer strappingType) {
		this.strappingType = strappingType;
	}

	public Integer getStrappingType() {
		return strappingType;
	}

	public void setMeterReadDate(Date meterReadDate) {
		this.meterReadDate = meterReadDate;
	}

	public Date getMeterReadDate() {
		return meterReadDate;
	}

	public void setMagnification(BigDecimal magnification) {
		this.magnification = magnification;
	}

	public BigDecimal getMagnification() {
		return magnification;
	}

	public void setNewMeterConsumption(BigDecimal newMeterConsumption) {
		this.newMeterConsumption = newMeterConsumption;
	}

	public BigDecimal getNewMeterConsumption() {
		return newMeterConsumption;
	}

	public void setOldMeterConsumption(BigDecimal oldMeterConsumption) {
		this.oldMeterConsumption = oldMeterConsumption;
	}

	public BigDecimal getOldMeterConsumption() {
		return oldMeterConsumption;
	}

	public void setAttritionRate(String attritionRate) {
		this.attritionRate = attritionRate;
	}

	public String getAttritionRate() {
		return attritionRate;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setAmountPrice(BigDecimal amountPrice) {
		this.amountPrice = amountPrice;
	}

	public BigDecimal getAmountPrice() {
		return amountPrice;
	}

	public void setAbnormalPrompt(String abnormalPrompt) {
		this.abnormalPrompt = abnormalPrompt;
	}

	public String getAbnormalPrompt() {
		return abnormalPrompt;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setFreezeNot(Integer freezeNot) {
		this.freezeNot = freezeNot;
	}

	public Integer getFreezeNot() {
		return freezeNot;
	}

	public void setSourceMeter(String sourceMeter) {
		this.sourceMeter = sourceMeter;
	}

	public String getSourceMeter() {
		return sourceMeter;
	}

	public void setMeterReader(String meterReader) {
		this.meterReader = meterReader;
	}

	public String getMeterReader() {
		return meterReader;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public Date getInputTime() {
		return inputTime;
	}

	public HyMeterCase getHyMeterCase() {
		return hyMeterCase;
	}

	public void setHyMeterCase(HyMeterCase hyMeterCase) {
		this.hyMeterCase = hyMeterCase;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("houseNum", getHouseNum()).append("meterType", getMeterType())
				.append("meterSerialNum", getMeterSerialNum()).append("meterName", getMeterName())
				.append("initialRead", getInitialRead()).append("meterStrNum", getMeterStrNum())
				.append("meterEndNum", getMeterEndNum()).append("transfRatio", getTransfRatio())
				.append("reverseNot", getReverseNot()).append("strappingType", getStrappingType())
				.append("meterReadDate", getMeterReadDate()).append("magnification", getMagnification())
				.append("newMeterConsumption", getNewMeterConsumption())
				.append("oldMeterConsumption", getOldMeterConsumption()).append("attritionRate", getAttritionRate())
				.append("unitPrice", getUnitPrice()).append("amountPrice", getAmountPrice())
				.append("abnormalPrompt", getAbnormalPrompt()).append("customerName", getCustomerName())
				.append("freezeNot", getFreezeNot()).append("sourceMeter", getSourceMeter())
				.append("meterReader", getMeterReader()).append("inputTime", getInputTime()).toString();
	}
}
