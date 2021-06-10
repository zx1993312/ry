package com.ruoyi.system.domain;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

public class HyCashierDesk extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3949860057483832063L;
	
	private Long id;
	private String costItems;
	private String communityName;
	private String buildingName;
	private String houseNumber;
	private String ownerName;
	private Date feeDate;
	private String isCollection;
	private String amountReceivable;
	private String amount;

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

	public Date getFeeDate() {
		return feeDate;
	}

	public void setFeeDate(Date feeDate) {
		this.feeDate = feeDate;
	}

	public String getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(String isCollection) {
		this.isCollection = isCollection;
	}

	public String getAmountReceivable() {
		return amountReceivable;
	}

	public void setAmountReceivable(String amountReceivable) {
		this.amountReceivable = amountReceivable;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
