package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.annotation.EnumAnn;
import com.ruoyi.system.enums.ControlEnum;
import com.ruoyi.system.enums.ParkingEnum;

/**
 * 车位资料
对象 hy_parking_inf
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public class HyParkingInf extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 车位区域 */
    @Excel(name = "车位区域")
    private String parkingArea;

    /** 车位类别 */
    @Excel(name = "车位类别")
    private String parkingType;

    /** 车位类型 */
    @Excel(name = "车位类型")
    private String parkingClass;

    /** 车位编号 */
    @Excel(name = "车位编号")
    private String parkingNumber;

    /** 合同交付日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同交付日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractDeliveryDate;

    /** 实际交付日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际交付日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualDeliveryDate;

    /** 接管日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "接管日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date takeoverTime;

    /** 收费标准 */
    @Excel(name = "收费标准")
    private String chargingStandard;

    /** 当前状态 */
    @Excel(name = "当前状态")
    @EnumAnn(enumClass=ParkingEnum.class,enumType="String")
    private String currentState;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String ownerName;

    /** 房屋编号 */
    @Excel(name = "房屋编号")
    private String houseNumber;

    /** 房屋名称 */
    @Excel(name = "房屋名称")
    private String houseName;

    /** 房屋产权性质 */
    @Excel(name = "房屋产权性质")
    private Integer houseProperty;

    /** 房屋使用性质 */
    @Excel(name = "房屋使用性质")
    private Integer houseNature;

    /** 停车卡号 */
    @Excel(name = "停车卡号")
    private String parkingCard;

    /** 车牌号码 */
    @Excel(name = "车牌号码")
    private String licensePlate;

    /** 车辆类型 */
    @Excel(name = "车辆类型")
    private String vehicleType;

    /** 车辆品牌 */
    @Excel(name = "车辆品牌")
    private String vehicleBrand;

    /** 排量 */
    @Excel(name = "排量")
    private BigDecimal displacement;

    /** 车辆颜色 */
    @Excel(name = "车辆颜色")
    private String vehicleColor;

    /** 是否收取其他费用 */
    @Excel(name = "是否收取其他费用")
    @EnumAnn(enumClass=ControlEnum.class)
    private Integer otherExpenses;

    /** 是否挂牌 */
    @Excel(name = "是否挂牌")
    @EnumAnn(enumClass=ControlEnum.class)
    private Integer licensePlateNot;

    /** 挂牌时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "挂牌时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date licensePlateTime;

    /** 使用状态 */
    @Excel(name = "使用状态")
    @EnumAnn(enumClass=ParkingEnum.class,enumType="Integer")
    private Integer usageStatus;

    /** 车位产权性质 */
    @Excel(name = "车位产权性质")
    private String parkingProperty;

    /** 办理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "办理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date timeProcessing;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date timeStr;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date timeEnd;

    /** 计费周期 */
    @Excel(name = "计费周期")
    private String bilingCycle;
    
    @Excel(name="车位名称")
    private String parkingName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParkingArea() {
		return parkingArea;
	}

	public void setParkingArea(String parkingArea) {
		this.parkingArea = parkingArea;
	}

	public String getParkingType() {
		return parkingType;
	}

	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}

	public String getParkingClass() {
		return parkingClass;
	}

	public void setParkingClass(String parkingClass) {
		this.parkingClass = parkingClass;
	}

	public String getParkingNumber() {
		return parkingNumber;
	}

	public void setParkingNumber(String parkingNumber) {
		this.parkingNumber = parkingNumber;
	}

	public Date getContractDeliveryDate() {
		return contractDeliveryDate;
	}

	public void setContractDeliveryDate(Date contractDeliveryDate) {
		this.contractDeliveryDate = contractDeliveryDate;
	}

	public Date getActualDeliveryDate() {
		return actualDeliveryDate;
	}

	public void setActualDeliveryDate(Date actualDeliveryDate) {
		this.actualDeliveryDate = actualDeliveryDate;
	}

	public Date getTakeoverTime() {
		return takeoverTime;
	}

	public void setTakeoverTime(Date takeoverTime) {
		this.takeoverTime = takeoverTime;
	}

	public String getChargingStandard() {
		return chargingStandard;
	}

	public void setChargingStandard(String chargingStandard) {
		this.chargingStandard = chargingStandard;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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

	public Integer getHouseProperty() {
		return houseProperty;
	}

	public void setHouseProperty(Integer houseProperty) {
		this.houseProperty = houseProperty;
	}

	public Integer getHouseNature() {
		return houseNature;
	}

	public void setHouseNature(Integer houseNature) {
		this.houseNature = houseNature;
	}

	public String getParkingCard() {
		return parkingCard;
	}

	public void setParkingCard(String parkingCard) {
		this.parkingCard = parkingCard;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public BigDecimal getDisplacement() {
		return displacement;
	}

	public void setDisplacement(BigDecimal displacement) {
		this.displacement = displacement;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public Integer getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(Integer otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

	public Integer getLicensePlateNot() {
		return licensePlateNot;
	}

	public void setLicensePlateNot(Integer licensePlateNot) {
		this.licensePlateNot = licensePlateNot;
	}

	public Date getLicensePlateTime() {
		return licensePlateTime;
	}

	public void setLicensePlateTime(Date licensePlateTime) {
		this.licensePlateTime = licensePlateTime;
	}

	public Integer getUsageStatus() {
		return usageStatus;
	}

	public void setUsageStatus(Integer usageStatus) {
		this.usageStatus = usageStatus;
	}

	public String getParkingProperty() {
		return parkingProperty;
	}

	public void setParkingProperty(String parkingProperty) {
		this.parkingProperty = parkingProperty;
	}

	public Date getTimeProcessing() {
		return timeProcessing;
	}

	public void setTimeProcessing(Date timeProcessing) {
		this.timeProcessing = timeProcessing;
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

	public String getBilingCycle() {
		return bilingCycle;
	}

	public void setBilingCycle(String bilingCycle) {
		this.bilingCycle = bilingCycle;
	}

	public String getParkingName() {
		return parkingName;
	}

	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	@Override
	public String toString() {
		return "HyParkingInf [id=" + id + ", parkingArea=" + parkingArea + ", parkingType=" + parkingType
				+ ", parkingClass=" + parkingClass + ", parkingNumber=" + parkingNumber + ", contractDeliveryDate="
				+ contractDeliveryDate + ", actualDeliveryDate=" + actualDeliveryDate + ", takeoverTime=" + takeoverTime
				+ ", chargingStandard=" + chargingStandard + ", currentState=" + currentState + ", ownerName="
				+ ownerName + ", houseNumber=" + houseNumber + ", houseName=" + houseName + ", houseProperty="
				+ houseProperty + ", houseNature=" + houseNature + ", parkingCard=" + parkingCard + ", licensePlate="
				+ licensePlate + ", vehicleType=" + vehicleType + ", vehicleBrand=" + vehicleBrand + ", displacement="
				+ displacement + ", vehicleColor=" + vehicleColor + ", otherExpenses=" + otherExpenses
				+ ", licensePlateNot=" + licensePlateNot + ", licensePlateTime=" + licensePlateTime + ", usageStatus="
				+ usageStatus + ", parkingProperty=" + parkingProperty + ", timeProcessing=" + timeProcessing
				+ ", timeStr=" + timeStr + ", timeEnd=" + timeEnd + ", bilingCycle=" + bilingCycle + ", parkingName="
				+ parkingName + ", getId()=" + getId() + ", getParkingArea()=" + getParkingArea()
				+ ", getParkingType()=" + getParkingType() + ", getParkingClass()=" + getParkingClass()
				+ ", getParkingNumber()=" + getParkingNumber() + ", getContractDeliveryDate()="
				+ getContractDeliveryDate() + ", getActualDeliveryDate()=" + getActualDeliveryDate()
				+ ", getTakeoverTime()=" + getTakeoverTime() + ", getChargingStandard()=" + getChargingStandard()
				+ ", getCurrentState()=" + getCurrentState() + ", getOwnerName()=" + getOwnerName()
				+ ", getHouseNumber()=" + getHouseNumber() + ", getHouseName()=" + getHouseName()
				+ ", getHouseProperty()=" + getHouseProperty() + ", getHouseNature()=" + getHouseNature()
				+ ", getParkingCard()=" + getParkingCard() + ", getLicensePlate()=" + getLicensePlate()
				+ ", getVehicleType()=" + getVehicleType() + ", getVehicleBrand()=" + getVehicleBrand()
				+ ", getDisplacement()=" + getDisplacement() + ", getVehicleColor()=" + getVehicleColor()
				+ ", getOtherExpenses()=" + getOtherExpenses() + ", getLicensePlateNot()=" + getLicensePlateNot()
				+ ", getLicensePlateTime()=" + getLicensePlateTime() + ", getUsageStatus()=" + getUsageStatus()
				+ ", getParkingProperty()=" + getParkingProperty() + ", getTimeProcessing()=" + getTimeProcessing()
				+ ", getTimeStr()=" + getTimeStr() + ", getTimeEnd()=" + getTimeEnd() + ", getBilingCycle()="
				+ getBilingCycle() + ", getParkingName()=" + getParkingName() + ", getSearchValue()=" + getSearchValue()
				+ ", getCreateBy()=" + getCreateBy() + ", getCreateTime()=" + getCreateTime() + ", getUpdateBy()="
				+ getUpdateBy() + ", getUpdateTime()=" + getUpdateTime() + ", getRemark()=" + getRemark()
				+ ", getParams()=" + getParams() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

 
}
