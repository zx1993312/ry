package com.ruoyi.system.domain;

import java.util.Date;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class ReHyCustomer extends BaseEntity {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5087310088771157233L;

	/** 主键 */
	private Long id;

	/** 房屋编号 */
	@Excel(name = "房屋编号")
	private String houseNumber;

	/** 房屋名称 */
	@Excel(name = "房屋名称")
	private String houseName;

	/** 建筑面积 */
	@Excel(name = "建筑面积")
	private String builtUpArea;

	/** 组团区域 */
	@Excel(name = "组团区域")
	private String groupArea;

	/** 单元 */
	@Excel(name = "单元")
	private String unit;

	/** 楼层 */
	@Excel(name = "楼层")
	private String floor;

	/** 同单元同楼层流水号 */
	@Excel(name = "同单元同楼层流水号")
	private Long sameUnitNumber;

	/** 面积类型 */
	@Excel(name = "面积类型")
	private Integer areaType;

	/** 计费面积 */
	@Excel(name = "计费面积")
	private String bilingArea;

	/** 套内面积 */
	@Excel(name = "套内面积")
	private String insideArea;

	/** 公摊面积 */
	@Excel(name = "公摊面积")
	private String sharedArea;

	/** 花园面积 */
	@Excel(name = "花园面积")
	private String gardenArea;

	/** 地下室面积 */
	@Excel(name = "地下室面积")
	private String basementArea;

	/** 大堂分摊面积 */
	@Excel(name = "大堂分摊面积")
	private String sharedLobbyArea;

	/** 层间分摊面积 */
	@Excel(name = "层间分摊面积")
	private String sharedLayersArea;

	/** 公摊比例 */
	@Excel(name = "公摊比例")
	private String shareRatio;

	/** 建筑结构 */
	@Excel(name = "建筑结构")
	private String buildingStructure;

	/** 单位面积承重参数 */
	@Excel(name = "单位面积承重参数")
	private String parametersPer;

	/** 房屋户型 */
	@Excel(name = "房屋户型")
	private String houseLayout;

	/** 层高 */
	@Excel(name = "层高")
	private String floorHeight;

	/** 产权性质 */
	@Excel(name = "产权性质")
	private String natureProperty;

	/** 使用性质 */
	@Excel(name = "使用性质")
	private String natureUse;

	/** 使用状态 */
	@Excel(name = "使用状态")
	private String usageStatus;

	/** 入住状态 */
	@Excel(name = "入住状态")
	private String occupancyStatus;
	/**
	 * 变更前交房状态
	 */
	@Excel(name = "变更前交房状态")
	private String deliveryStatusBefore;

	/** 交房状态 */
	@Excel(name = "交房状态")
	private String deliveryStatus;
	/**
	 * 变更时间
	 */
	@Excel(name = "变更时间")
	private Date changeDate;
	/**
	 * 变更人
	 */
	@Excel(name = "变更人")
	private String changePerson;
	/**
	 * 备注
	 */
	@Excel(name = "备注")
	private String remark;

	/** 房屋类型 */
	@Excel(name = "房屋类型")
	private String houseType;

	/** 销售状态 */
	@Excel(name = "销售状态")
	private String salesStatus;

	/** 购房合同号 */
	@Excel(name = "购房合同号")
	private String purchaseContract;

	/** 营销编号 */
	@Excel(name = "营销编号")
	private String marketingNum;

	/** 楼宇id */
	private Long buildingId;

	/** 业主id */
	private Long ownerId;

	/** 楼宇名称 */
	@Excel(name = "楼宇名称")
	private String buildingName;

	/** 业主名称 */
	@Excel(name = "业主名称")
	private String ownerName;

	/** 车位编号 */
	@Excel(name = "车位编号")
	private String parkingNumber;

	/** 费用项目 */
	private String costItems;

	/** 费用类型 */
	private String expenseType;

	/** 表计名称 */
	@Excel(name = "表计名称")
	private String meterName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getBuiltUpArea() {
		return builtUpArea;
	}

	public void setBuiltUpArea(String builtUpArea) {
		this.builtUpArea = builtUpArea;
	}

	public String getGroupArea() {
		return groupArea;
	}

	public void setGroupArea(String groupArea) {
		this.groupArea = groupArea;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Long getSameUnitNumber() {
		return sameUnitNumber;
	}

	public void setSameUnitNumber(Long sameUnitNumber) {
		this.sameUnitNumber = sameUnitNumber;
	}

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}

	public String getBilingArea() {
		return bilingArea;
	}

	public void setBilingArea(String bilingArea) {
		this.bilingArea = bilingArea;
	}

	public String getInsideArea() {
		return insideArea;
	}

	public void setInsideArea(String insideArea) {
		this.insideArea = insideArea;
	}

	public String getSharedArea() {
		return sharedArea;
	}

	public void setSharedArea(String sharedArea) {
		this.sharedArea = sharedArea;
	}

	public String getGardenArea() {
		return gardenArea;
	}

	public void setGardenArea(String gardenArea) {
		this.gardenArea = gardenArea;
	}

	public String getBasementArea() {
		return basementArea;
	}

	public void setBasementArea(String basementArea) {
		this.basementArea = basementArea;
	}

	public String getSharedLobbyArea() {
		return sharedLobbyArea;
	}

	public void setSharedLobbyArea(String sharedLobbyArea) {
		this.sharedLobbyArea = sharedLobbyArea;
	}

	public String getSharedLayersArea() {
		return sharedLayersArea;
	}

	public void setSharedLayersArea(String sharedLayersArea) {
		this.sharedLayersArea = sharedLayersArea;
	}

	public String getShareRatio() {
		return shareRatio;
	}

	public void setShareRatio(String shareRatio) {
		this.shareRatio = shareRatio;
	}

	public String getBuildingStructure() {
		return buildingStructure;
	}

	public void setBuildingStructure(String buildingStructure) {
		this.buildingStructure = buildingStructure;
	}

	public String getParametersPer() {
		return parametersPer;
	}

	public void setParametersPer(String parametersPer) {
		this.parametersPer = parametersPer;
	}

	public String getHouseLayout() {
		return houseLayout;
	}

	public void setHouseLayout(String houseLayout) {
		this.houseLayout = houseLayout;
	}

	public String getFloorHeight() {
		return floorHeight;
	}

	public void setFloorHeight(String floorHeight) {
		this.floorHeight = floorHeight;
	}

	public String getNatureProperty() {
		return natureProperty;
	}

	public void setNatureProperty(String natureProperty) {
		this.natureProperty = natureProperty;
	}

	public String getNatureUse() {
		return natureUse;
	}

	public void setNatureUse(String natureUse) {
		this.natureUse = natureUse;
	}

	public String getUsageStatus() {
		return usageStatus;
	}

	public void setUsageStatus(String usageStatus) {
		this.usageStatus = usageStatus;
	}

	public String getOccupancyStatus() {
		return occupancyStatus;
	}

	public void setOccupancyStatus(String occupancyStatus) {
		this.occupancyStatus = occupancyStatus;
	}

	public String getDeliveryStatusBefore() {
		return deliveryStatusBefore;
	}

	public void setDeliveryStatusBefore(String deliveryStatusBefore) {
		this.deliveryStatusBefore = deliveryStatusBefore;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getChangePerson() {
		return changePerson;
	}

	public void setChangePerson(String changePerson) {
		this.changePerson = changePerson;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getSalesStatus() {
		return salesStatus;
	}

	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}

	public String getPurchaseContract() {
		return purchaseContract;
	}

	public void setPurchaseContract(String purchaseContract) {
		this.purchaseContract = purchaseContract;
	}

	public String getMarketingNum() {
		return marketingNum;
	}

	public void setMarketingNum(String marketingNum) {
		this.marketingNum = marketingNum;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getParkingNumber() {
		return parkingNumber;
	}

	public void setParkingNumber(String parkingNumber) {
		this.parkingNumber = parkingNumber;
	}

	public String getCostItems() {
		return costItems;
	}

	public void setCostItems(String costItems) {
		this.costItems = costItems;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getMeterName() {
		return meterName;
	}

	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}

}
