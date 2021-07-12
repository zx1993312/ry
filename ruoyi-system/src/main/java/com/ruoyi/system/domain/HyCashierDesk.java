package com.ruoyi.system.domain;

import java.math.BigDecimal;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class HyCashierDesk extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3949860057483832063L;
	/** 序号*/
	@Excel(name = "序号")
	private Long id;
	/** 项目*/
	@Excel(name = "项目")
	private String costItems;
	/** 小区名称*/
	@Excel(name = "小区名称")
	private String communityName;
	/** 楼栋名称*/
	@Excel(name = "楼栋名称")
	private String buildingName;
	/** 费用日期*/
	@Excel(name = "费用日期")
	private String feeDate;
	/** 是否收款*/
	@Excel(name = "是否收款")
	private String isCollection;
	/** 应收费用*/
	@Excel(name = "应收费用")
	private BigDecimal amountReceivable;
	/** 已收费用*/
	@Excel(name = "已收费用")
	private BigDecimal amount;
	/** 栋号*/
	@Excel(name = "栋号")
	private String buildingNumber;
	/** 单元*/
	@Excel(name = "单元")
	private String unit;
	/** 房屋编号*/
	@Excel(name = "房屋编号")
	private String houseNumber;
	/** 业主名称*/
	@Excel(name = "业主名称")
	private String ownerName;
	 /** 计费面积 */
    @Excel(name = "计费面积")
    private BigDecimal bilingArea;
    /** 移动电话 */
    @Excel(name = "移动电话")
    private String mobilePhone;
    /** 证件号码 */
    @Excel(name = "证件号码")
    private String idCardNum;
    /** 身份证地址 */
    @Excel(name = "身份证地址")
    private String idCardAddress;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCostItems() {
		return costItems;
	}

	public void setCostItems(String costItems) {
		this.costItems = costItems;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getFeeDate() {
		return feeDate;
	}

	public void setFeeDate(String feeDate) {
		this.feeDate = feeDate;
	}

	public String getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(String isCollection) {
		this.isCollection = isCollection;
	}

	public BigDecimal getAmountReceivable() {
		return amountReceivable;
	}

	public void setAmountReceivable(BigDecimal amountReceivable) {
		this.amountReceivable = amountReceivable;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getBilingArea() {
		return bilingArea;
	}

	public void setBilingArea(BigDecimal bilingArea) {
		this.bilingArea = bilingArea;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

	public String getIdCardAddress() {
		return idCardAddress;
	}

	public void setIdCardAddress(String idCardAddress) {
		this.idCardAddress = idCardAddress;
	}

	@Override
	public String toString() {
		return "HyCashierDesk [id=" + id + ", costItems=" + costItems + ", communityName=" + communityName
				+ ", buildingName=" + buildingName + ", feeDate=" + feeDate + ", isCollection=" + isCollection
				+ ", amountReceivable=" + amountReceivable + ", amount=" + amount + ", buildingNumber=" + buildingNumber
				+ ", unit=" + unit + ", houseNumber=" + houseNumber + ", ownerName=" + ownerName + ", bilingArea="
				+ bilingArea + ", mobilePhone=" + mobilePhone + ", idCardNum=" + idCardNum + ", idCardAddress="
				+ idCardAddress + "]";
	}

}
