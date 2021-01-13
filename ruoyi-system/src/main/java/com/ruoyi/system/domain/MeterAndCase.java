package com.ruoyi.system.domain;

import java.math.BigDecimal;

import com.ruoyi.common.annotation.Excel;

public class MeterAndCase {

	@SuppressWarnings("unused")
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

	/** 变比 */
	@Excel(name = "变比")
	private BigDecimal transfRatio;

	/** 是否反向 */
	@Excel(name = "是否反向")
	private Integer reverseNot;

	/** 计量表类型 */
	@Excel(name = "计量表类型")
	private Integer strappingType;

	/** 表箱名称 */
	@Excel(name = "表箱名称")
	private String meterCaseName;

	/** 表箱位置 */
	@Excel(name = "表箱位置")
	private String meterCasePosition;

	/** 表箱序号 */
	@Excel(name = "表箱序号")
	private String meterSerial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public BigDecimal getTransfRatio() {
		return transfRatio;
	}

	public void setTransfRatio(BigDecimal transfRatio) {
		this.transfRatio = transfRatio;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public Integer getMeterType() {
		return meterType;
	}

	public void setMeterType(Integer meterType) {
		this.meterType = meterType;
	}

	public Integer getMeterSerialNum() {
		return meterSerialNum;
	}

	public void setMeterSerialNum(Integer meterSerialNum) {
		this.meterSerialNum = meterSerialNum;
	}

	public String getMeterName() {
		return meterName;
	}

	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}

	public BigDecimal getInitialRead() {
		return initialRead;
	}

	public void setInitialRead(BigDecimal initialRead) {
		this.initialRead = initialRead;
	}

	public Integer getReverseNot() {
		return reverseNot;
	}

	public void setReverseNot(Integer reverseNot) {
		this.reverseNot = reverseNot;
	}

	public Integer getStrappingType() {
		return strappingType;
	}

	public void setStrappingType(Integer strappingType) {
		this.strappingType = strappingType;
	}

	public String getMeterCaseName() {
		return meterCaseName;
	}

	public void setMeterCaseName(String meterCaseName) {
		this.meterCaseName = meterCaseName;
	}

	public String getMeterCasePosition() {
		return meterCasePosition;
	}

	public void setMeterCasePosition(String meterCasePosition) {
		this.meterCasePosition = meterCasePosition;
	}

	public String getMeterSerial() {
		return meterSerial;
	}

	public void setMeterSerial(String meterSerial) {
		this.meterSerial = meterSerial;
	}

	@Override
	public String toString() {
		return "MeterAndCase [id=" + id + ", houseNum=" + houseNum + ", meterType=" + meterType + ", meterSerialNum="
				+ meterSerialNum + ", meterName=" + meterName + ", initialRead=" + initialRead + ", transfRatio="
				+ transfRatio + ", reverseNot=" + reverseNot + ", strappingType=" + strappingType + ", meterCaseName="
				+ meterCaseName + ", meterCasePosition=" + meterCasePosition + ", meterSerial=" + meterSerial
				+ ", getId()=" + getId() + ", getHouseNum()=" + getHouseNum() + ", getMeterType()=" + getMeterType()
				+ ", getMeterSerialNum()=" + getMeterSerialNum() + ", getMeterName()=" + getMeterName()
				+ ", getTransfRatio()=" + getTransfRatio() + ", getReverseNot()=" + getReverseNot()
				+ ", getStrappingType()=" + getStrappingType() + ", getMeterCaseName()=" + getMeterCaseName()
				+ ", getMeterCasePosition()=" + getMeterCasePosition() + ", getMeterSerial()=" + getMeterSerial()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
