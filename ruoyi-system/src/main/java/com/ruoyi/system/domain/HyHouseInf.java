package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房屋登记对象 hy_house_inf
 * 
 * @author liutianqi
 * @date 2021-01-06
 */
public class HyHouseInf extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;
    
    /** 房屋主键组 */
    private String ids;

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
    private BigDecimal bilingArea;

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
    @Excel(name="变更前交房状态")
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
    
    /** 小区id */
    private Long quartersId;
    
    /** 楼宇id */
    private Long buildingId;
    
    /** 楼宇表 */
    @Excel(name = "楼宇表")
    private HyBuilding hyBuilding;
    
    /** 业主id */
    private Long ownerId;
    
    /** 业主表 */
    @Excel(name = "业主表")
    private HyOwnerRegistration hyOwnerRegistration;
    
    /**
     * 月份
     */
    private String month;
    
    /**
     * 费用开始时间
     */
    private Date beginFeeDate;
    
    /**
     * 费用结束时间
     */
    private Date endFeeDate;
    
    /** 打折 */
    private BigDecimal discount;
    
    /** 费用id组 */
    private String costIds;
    
    /** 费用表 */
    @Excel(name = "费用表")
    private HyCost hyCost;
    
    /** 房屋id */
    private Long houseId;
    
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHouseNumber(String houseNumber) 
    {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumber() 
    {
        return houseNumber;
    }
    public void setHouseName(String houseName) 
    {
        this.houseName = houseName;
    }

    public String getHouseName() 
    {
        return houseName;
    }
    public void setBuiltUpArea(String builtUpArea) 
    {
        this.builtUpArea = builtUpArea;
    }

    public String getBuiltUpArea() 
    {
        return builtUpArea;
    }
    public void setGroupArea(String groupArea) 
    {
        this.groupArea = groupArea;
    }

    public String getGroupArea() 
    {
        return groupArea;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setFloor(String floor) 
    {
        this.floor = floor;
    }

    public String getFloor() 
    {
        return floor;
    }
    public void setSameUnitNumber(Long sameUnitNumber) 
    {
        this.sameUnitNumber = sameUnitNumber;
    }

    public Long getSameUnitNumber() 
    {
        return sameUnitNumber;
    }
    public void setAreaType(Integer areaType) 
    {
        this.areaType = areaType;
    }

    public Integer getAreaType() 
    {
        return areaType;
    }
    public void setBilingArea(BigDecimal bilingArea) 
    {
        this.bilingArea = bilingArea;
    }

    public BigDecimal getBilingArea() 
    {
        return bilingArea;
    }
    public void setInsideArea(String insideArea) 
    {
        this.insideArea = insideArea;
    }

    public String getInsideArea() 
    {
        return insideArea;
    }
    public void setSharedArea(String sharedArea) 
    {
        this.sharedArea = sharedArea;
    }

    public String getSharedArea() 
    {
        return sharedArea;
    }
    public void setGardenArea(String gardenArea) 
    {
        this.gardenArea = gardenArea;
    }

    public String getGardenArea() 
    {
        return gardenArea;
    }
    public void setBasementArea(String basementArea) 
    {
        this.basementArea = basementArea;
    }

    public String getBasementArea() 
    {
        return basementArea;
    }
    public void setSharedLobbyArea(String sharedLobbyArea) 
    {
        this.sharedLobbyArea = sharedLobbyArea;
    }

    public String getSharedLobbyArea() 
    {
        return sharedLobbyArea;
    }
    public void setSharedLayersArea(String sharedLayersArea) 
    {
        this.sharedLayersArea = sharedLayersArea;
    }

    public String getSharedLayersArea() 
    {
        return sharedLayersArea;
    }
    public void setShareRatio(String shareRatio) 
    {
        this.shareRatio = shareRatio;
    }

    public String getShareRatio() 
    {
        return shareRatio;
    }
    public void setBuildingStructure(String buildingStructure) 
    {
        this.buildingStructure = buildingStructure;
    }

    public String getBuildingStructure() 
    {
        return buildingStructure;
    }
    public void setParametersPer(String parametersPer) 
    {
        this.parametersPer = parametersPer;
    }

    public String getParametersPer() 
    {
        return parametersPer;
    }
    public void setHouseLayout(String houseLayout) 
    {
        this.houseLayout = houseLayout;
    }

    public String getHouseLayout() 
    {
        return houseLayout;
    }
    public void setFloorHeight(String floorHeight) 
    {
        this.floorHeight = floorHeight;
    }

    public String getFloorHeight() 
    {
        return floorHeight;
    }
    public void setNatureProperty(String natureProperty) 
    {
        this.natureProperty = natureProperty;
    }

    public String getNatureProperty() 
    {
        return natureProperty;
    }
    public void setNatureUse(String natureUse) 
    {
        this.natureUse = natureUse;
    }

    public String getNatureUse() 
    {
        return natureUse;
    }
    public void setUsageStatus(String usageStatus) 
    {
        this.usageStatus = usageStatus;
    }

    public String getUsageStatus() 
    {
        return usageStatus;
    }
    public void setOccupancyStatus(String occupancyStatus) 
    {
        this.occupancyStatus = occupancyStatus;
    }

    public String getOccupancyStatus() 
    {
        return occupancyStatus;
    }
    public void setDeliveryStatus(String deliveryStatus) 
    {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryStatus() 
    {
        return deliveryStatus;
    }
    public void setHouseType(String houseType) 
    {
        this.houseType = houseType;
    }

    public String getHouseType() 
    {
        return houseType;
    }
    public void setSalesStatus(String salesStatus) 
    {
        this.salesStatus = salesStatus;
    }

    public String getSalesStatus() 
    {
        return salesStatus;
    }
    public void setPurchaseContract(String purchaseContract) 
    {
        this.purchaseContract = purchaseContract;
    }

    public String getPurchaseContract() 
    {
        return purchaseContract;
    }
    public void setMarketingNum(String marketingNum) 
    {
        this.marketingNum = marketingNum;
    }

    public String getMarketingNum() 
    {
        return marketingNum;
    }

    public String getDeliveryStatusBefore() {
		return deliveryStatusBefore;
	}

	public void setDeliveryStatusBefore(String deliveryStatusBefore) {
		this.deliveryStatusBefore = deliveryStatusBefore;
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

	public HyOwnerRegistration getHyOwnerRegistration() {
		return hyOwnerRegistration;
	}

	public void setHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		this.hyOwnerRegistration = hyOwnerRegistration;
	}

	public Long getQuartersId() {
		return quartersId;
	}

	public void setQuartersId(Long quartersId) {
		this.quartersId = quartersId;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

	public HyBuilding getHyBuilding() {
		return hyBuilding;
	}

	public void setHyBuilding(HyBuilding hyBuilding) {
		this.hyBuilding = hyBuilding;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public HyCost getHyCost() {
		return hyCost;
	}

	public void setHyCost(HyCost hyCost) {
		this.hyCost = hyCost;
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}


	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Date getBeginFeeDate() {
		return beginFeeDate;
	}

	public void setBeginFeeDate(Date beginFeeDate) {
		this.beginFeeDate = beginFeeDate;
	}

	public Date getEndFeeDate() {
		return endFeeDate;
	}

	public void setEndFeeDate(Date endFeeDate) {
		this.endFeeDate = endFeeDate;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getCostIds() {
		return costIds;
	}

	public void setCostIds(String costIds) {
		this.costIds = costIds;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("houseNumber", getHouseNumber())
            .append("houseName", getHouseName())
            .append("builtUpArea", getBuiltUpArea())
            .append("groupArea", getGroupArea())
            .append("unit", getUnit())
            .append("floor", getFloor())
            .append("sameUnitNumber", getSameUnitNumber())
            .append("areaType", getAreaType())
            .append("bilingArea", getBilingArea())
            .append("insideArea", getInsideArea())
            .append("sharedArea", getSharedArea())
            .append("gardenArea", getGardenArea())
            .append("basementArea", getBasementArea())
            .append("sharedLobbyArea", getSharedLobbyArea())
            .append("sharedLayersArea", getSharedLayersArea())
            .append("shareRatio", getShareRatio())
            .append("buildingStructure", getBuildingStructure())
            .append("parametersPer", getParametersPer())
            .append("houseLayout", getHouseLayout())
            .append("floorHeight", getFloorHeight())
            .append("natureProperty", getNatureProperty())
            .append("natureUse", getNatureUse())
            .append("usageStatus", getUsageStatus())
            .append("occupancyStatus", getOccupancyStatus())
            .append("deliveryStatus", getDeliveryStatus())
            .append("houseType", getHouseType())
            .append("salesStatus", getSalesStatus())
            .append("purchaseContract", getPurchaseContract())
            .append("marketingNum", getMarketingNum())
            .append("quartersId", getQuartersId())
            .append("buildingId", getBuildingId())
            .append("ownerId", getOwnerId())
            .append("hyBuilding", getHyBuilding())
            .append("hyOwnerRegistration", getHyOwnerRegistration())
            .append("hyCost", getHyCost())
            .append("houseId", getHouseId())
            .append("ids", getIds())
            .append("costIds", getCostIds())
            .append("beginFeeDate", getBeginFeeDate())
            .append("endFeeDate", getEndFeeDate())
            .append("discount", getDiscount())
            .append("month", getMonth())
            .toString();
    }
}
