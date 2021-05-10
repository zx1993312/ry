package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 设备档案对象 hy_equipment_archives
 * 
 * @author Administrator
 * @date 2021-05-08
 */
public class HyEquipmentArchives extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备档案id */
    private Long id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String archivesNumber;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String archivesName;

    /** 设备类别 */
    @Excel(name = "设备类别")
    private String archivesSort;

    /** 制造厂家 */
    @Excel(name = "制造厂家")
    private String archivesManufacturers;

    /** 型号 */
    @Excel(name = "型号")
    private String archivesType;

    /** 规格 */
    @Excel(name = "规格")
    private String archivesSpecification;

    /** 购置日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购置日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date acquisitionDate;

    /** 出厂日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出厂日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseDate;

    /** 出厂编号 */
    @Excel(name = "出厂编号")
    private String releaseNumber;

    /** 安装日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "安装日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date installationDate;

    /** 安装单位 */
    @Excel(name = "安装单位")
    private String installationUnit;

    /** 存放位置 */
    @Excel(name = "存放位置")
    private String storeAddress;

    /** 使用日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "使用日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date useDate;

    /** 使用年限 */
    @Excel(name = "使用年限")
    private BigDecimal userYear;

    /** 报废时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报废时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date discardTime;

    /** 质保开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "质保开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commencementDate;

    /** 质保年限 */
    @Excel(name = "质保年限")
    private BigDecimal warrantyPeriod;

    /** 质保结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "质保结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 原值 */
    @Excel(name = "原值")
    private BigDecimal originalValue;

    /** 折旧率 */
    @Excel(name = "折旧率")
    private BigDecimal depreciationRate;

    /** 现估价 */
    @Excel(name = "现估价")
    private BigDecimal nowPrice;

    /** 已提折旧 */
    @Excel(name = "已提折旧")
    private BigDecimal mentionDepreciation;

    /** 净值 */
    @Excel(name = "净值")
    private BigDecimal netValue;

    /** 设备图号 */
    @Excel(name = "设备图号")
    private String equipmentDraw;

    /** 使用范围 */
    @Excel(name = "使用范围")
    private String useRange;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal number;

    /** 占地面积 */
    @Excel(name = "占地面积")
    private BigDecimal floorSpace;

    /** 产权归属 */
    @Excel(name = "产权归属")
    private String propertyOwnership;

    /** 使用说明书 */
    @Excel(name = "使用说明书")
    private String operationInstruction;

    /** 技术资料 */
    @Excel(name = "技术资料")
    private String technicalData;

    /** 使用状态 */
    @Excel(name = "使用状态")
    private String useState;

    /** 扫描码 */
    @Excel(name = "扫描码")
    private String scanCode;

    /** 图片 */
    @Excel(name = "图片")
    private String archivesPicture;

    /** 正常期（年） */
    @Excel(name = "正常期", readConverterExp = "年=")
    private BigDecimal normalEpoch;

    /** 运维期（年） */
    @Excel(name = "运维期", readConverterExp = "年=")
    private BigDecimal operationalPeriod;

    /** 最近检测日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近检测日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testDate;

    /** 设备等级 */
    @Excel(name = "设备等级")
    private String equipmentLevel;

    /** 移交日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "移交日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handoverDate;

    /** 是否强制检测 */
    @Excel(name = "是否强制检测")
    private String compulsoryTest;

    /** 强制检测周期（月） */
    @Excel(name = "强制检测周期", readConverterExp = "月=")
    private String inspectionPeriod;

    /** 检测周期（月） */
    @Excel(name = "检测周期", readConverterExp = "月=")
    private String detectionPeriod;

    /** 设备类别id */
    @Excel(name = "设备类别id")
    private Long equipmentId;
    
    /** 设备类别表 */
    @Excel(name = "设备类别表")
    private HyEquipment hyEquipment;

    /** 设备责任人 */
    @Excel(name = "设备责任人")
    private Long userId;
    
    /** 员工表 */
    @Excel(name = "员工表")
    private SysUser sysUser;
    
    /** 组织机构id */
    @Excel(name = "组织机构id")
    private Long deptId;
    
    /** 组织机构表 */
    @Excel(name = "组织机构表")
    private SysDept sysDept;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setArchivesNumber(String archivesNumber) 
    {
        this.archivesNumber = archivesNumber;
    }

    public String getArchivesNumber() 
    {
        return archivesNumber;
    }
    public void setArchivesName(String archivesName) 
    {
        this.archivesName = archivesName;
    }

    public String getArchivesName() 
    {
        return archivesName;
    }
    public void setArchivesSort(String archivesSort) 
    {
        this.archivesSort = archivesSort;
    }

    public String getArchivesSort() 
    {
        return archivesSort;
    }
    public void setArchivesManufacturers(String archivesManufacturers) 
    {
        this.archivesManufacturers = archivesManufacturers;
    }

    public String getArchivesManufacturers() 
    {
        return archivesManufacturers;
    }
    public void setArchivesType(String archivesType) 
    {
        this.archivesType = archivesType;
    }

    public String getArchivesType() 
    {
        return archivesType;
    }
    public void setArchivesSpecification(String archivesSpecification) 
    {
        this.archivesSpecification = archivesSpecification;
    }

    public String getArchivesSpecification() 
    {
        return archivesSpecification;
    }
    public void setAcquisitionDate(Date acquisitionDate) 
    {
        this.acquisitionDate = acquisitionDate;
    }

    public Date getAcquisitionDate() 
    {
        return acquisitionDate;
    }
    public void setReleaseDate(Date releaseDate) 
    {
        this.releaseDate = releaseDate;
    }

    public Date getReleaseDate() 
    {
        return releaseDate;
    }
    public void setReleaseNumber(String releaseNumber) 
    {
        this.releaseNumber = releaseNumber;
    }

    public String getReleaseNumber() 
    {
        return releaseNumber;
    }
    public void setInstallationDate(Date installationDate) 
    {
        this.installationDate = installationDate;
    }

    public Date getInstallationDate() 
    {
        return installationDate;
    }
    public void setInstallationUnit(String installationUnit) 
    {
        this.installationUnit = installationUnit;
    }

    public String getInstallationUnit() 
    {
        return installationUnit;
    }
    public void setStoreAddress(String storeAddress) 
    {
        this.storeAddress = storeAddress;
    }

    public String getStoreAddress() 
    {
        return storeAddress;
    }
    public void setUseDate(Date useDate) 
    {
        this.useDate = useDate;
    }

    public Date getUseDate() 
    {
        return useDate;
    }
    public void setUserYear(BigDecimal userYear) 
    {
        this.userYear = userYear;
    }

    public BigDecimal getUserYear() 
    {
        return userYear;
    }
    public void setDiscardTime(Date discardTime) 
    {
        this.discardTime = discardTime;
    }

    public Date getDiscardTime() 
    {
        return discardTime;
    }
    public void setCommencementDate(Date commencementDate) 
    {
        this.commencementDate = commencementDate;
    }

    public Date getCommencementDate() 
    {
        return commencementDate;
    }
    public void setWarrantyPeriod(BigDecimal warrantyPeriod) 
    {
        this.warrantyPeriod = warrantyPeriod;
    }

    public BigDecimal getWarrantyPeriod() 
    {
        return warrantyPeriod;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setOriginalValue(BigDecimal originalValue) 
    {
        this.originalValue = originalValue;
    }

    public BigDecimal getOriginalValue() 
    {
        return originalValue;
    }
    public void setDepreciationRate(BigDecimal depreciationRate) 
    {
        this.depreciationRate = depreciationRate;
    }

    public BigDecimal getDepreciationRate() 
    {
        return depreciationRate;
    }
    public void setNowPrice(BigDecimal nowPrice) 
    {
        this.nowPrice = nowPrice;
    }

    public BigDecimal getNowPrice() 
    {
        return nowPrice;
    }
    public void setMentionDepreciation(BigDecimal mentionDepreciation) 
    {
        this.mentionDepreciation = mentionDepreciation;
    }

    public BigDecimal getMentionDepreciation() 
    {
        return mentionDepreciation;
    }
    public void setNetValue(BigDecimal netValue) 
    {
        this.netValue = netValue;
    }

    public BigDecimal getNetValue() 
    {
        return netValue;
    }
    public void setEquipmentDraw(String equipmentDraw) 
    {
        this.equipmentDraw = equipmentDraw;
    }

    public String getEquipmentDraw() 
    {
        return equipmentDraw;
    }
    public void setUseRange(String useRange) 
    {
        this.useRange = useRange;
    }

    public String getUseRange() 
    {
        return useRange;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setNumber(BigDecimal number) 
    {
        this.number = number;
    }

    public BigDecimal getNumber() 
    {
        return number;
    }
    public void setFloorSpace(BigDecimal floorSpace) 
    {
        this.floorSpace = floorSpace;
    }

    public BigDecimal getFloorSpace() 
    {
        return floorSpace;
    }
    public void setPropertyOwnership(String propertyOwnership) 
    {
        this.propertyOwnership = propertyOwnership;
    }

    public String getPropertyOwnership() 
    {
        return propertyOwnership;
    }
    public void setOperationInstruction(String operationInstruction) 
    {
        this.operationInstruction = operationInstruction;
    }

    public String getOperationInstruction() 
    {
        return operationInstruction;
    }
    public void setTechnicalData(String technicalData) 
    {
        this.technicalData = technicalData;
    }

    public String getTechnicalData() 
    {
        return technicalData;
    }
    public void setUseState(String useState) 
    {
        this.useState = useState;
    }

    public String getUseState() 
    {
        return useState;
    }
    public void setScanCode(String scanCode) 
    {
        this.scanCode = scanCode;
    }

    public String getScanCode() 
    {
        return scanCode;
    }
    public void setArchivesPicture(String archivesPicture) 
    {
        this.archivesPicture = archivesPicture;
    }

    public String getArchivesPicture() 
    {
        return archivesPicture;
    }
    public void setNormalEpoch(BigDecimal normalEpoch) 
    {
        this.normalEpoch = normalEpoch;
    }

    public BigDecimal getNormalEpoch() 
    {
        return normalEpoch;
    }
    public void setOperationalPeriod(BigDecimal operationalPeriod) 
    {
        this.operationalPeriod = operationalPeriod;
    }

    public BigDecimal getOperationalPeriod() 
    {
        return operationalPeriod;
    }
    public void setTestDate(Date testDate) 
    {
        this.testDate = testDate;
    }

    public Date getTestDate() 
    {
        return testDate;
    }
    public void setEquipmentLevel(String equipmentLevel) 
    {
        this.equipmentLevel = equipmentLevel;
    }

    public String getEquipmentLevel() 
    {
        return equipmentLevel;
    }
    public void setHandoverDate(Date handoverDate) 
    {
        this.handoverDate = handoverDate;
    }

    public Date getHandoverDate() 
    {
        return handoverDate;
    }
    public void setCompulsoryTest(String compulsoryTest) 
    {
        this.compulsoryTest = compulsoryTest;
    }

    public String getCompulsoryTest() 
    {
        return compulsoryTest;
    }
    public void setInspectionPeriod(String inspectionPeriod) 
    {
        this.inspectionPeriod = inspectionPeriod;
    }

    public String getInspectionPeriod() 
    {
        return inspectionPeriod;
    }
    public void setDetectionPeriod(String detectionPeriod) 
    {
        this.detectionPeriod = detectionPeriod;
    }

    public String getDetectionPeriod() 
    {
        return detectionPeriod;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public HyEquipment getHyEquipment() {
		return hyEquipment;
	}

	public void setHyEquipment(HyEquipment hyEquipment) {
		this.hyEquipment = hyEquipment;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysDept getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("archivesNumber", getArchivesNumber())
            .append("archivesName", getArchivesName())
            .append("archivesSort", getArchivesSort())
            .append("archivesManufacturers", getArchivesManufacturers())
            .append("archivesType", getArchivesType())
            .append("archivesSpecification", getArchivesSpecification())
            .append("acquisitionDate", getAcquisitionDate())
            .append("releaseDate", getReleaseDate())
            .append("releaseNumber", getReleaseNumber())
            .append("installationDate", getInstallationDate())
            .append("installationUnit", getInstallationUnit())
            .append("storeAddress", getStoreAddress())
            .append("useDate", getUseDate())
            .append("userYear", getUserYear())
            .append("discardTime", getDiscardTime())
            .append("commencementDate", getCommencementDate())
            .append("warrantyPeriod", getWarrantyPeriod())
            .append("endDate", getEndDate())
            .append("originalValue", getOriginalValue())
            .append("depreciationRate", getDepreciationRate())
            .append("nowPrice", getNowPrice())
            .append("mentionDepreciation", getMentionDepreciation())
            .append("netValue", getNetValue())
            .append("equipmentDraw", getEquipmentDraw())
            .append("useRange", getUseRange())
            .append("unit", getUnit())
            .append("number", getNumber())
            .append("floorSpace", getFloorSpace())
            .append("propertyOwnership", getPropertyOwnership())
            .append("operationInstruction", getOperationInstruction())
            .append("technicalData", getTechnicalData())
            .append("remark", getRemark())
            .append("useState", getUseState())
            .append("scanCode", getScanCode())
            .append("archivesPicture", getArchivesPicture())
            .append("normalEpoch", getNormalEpoch())
            .append("operationalPeriod", getOperationalPeriod())
            .append("testDate", getTestDate())
            .append("equipmentLevel", getEquipmentLevel())
            .append("handoverDate", getHandoverDate())
            .append("compulsoryTest", getCompulsoryTest())
            .append("inspectionPeriod", getInspectionPeriod())
            .append("detectionPeriod", getDetectionPeriod())
            .append("equipmentId", getEquipmentId())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("hyEquipment", getHyEquipment())
            .append("sysUser", getSysUser())
            .append("sysDept", getSysDept())
            .toString();
    }
}
