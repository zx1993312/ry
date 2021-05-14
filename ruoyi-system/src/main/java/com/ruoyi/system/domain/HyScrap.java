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
 * 设备报废申请对象 hy_scrap
 * 
 * @author Administrator
 * @date 2021-05-14
 */
public class HyScrap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备报废申请id */
    private Long id;

    /** 单据号 */
    @Excel(name = "单据号")
    private String documentNumber;

    /** 报废日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报废日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date scrapDate;

    /** 报废型号 */
    @Excel(name = "报废型号")
    private String scrapType;

    /** 生产厂家 */
    @Excel(name = "生产厂家")
    private String manufactureFactory;

    /** 启用日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "启用日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commissioningDate;

    /** 原值 */
    @Excel(name = "原值")
    private BigDecimal originalValue;

    /** 现值 */
    @Excel(name = "现值")
    private BigDecimal presentValue;

    /** 服役过程 */
    @Excel(name = "服役过程")
    private String serviceProcess;

    /** 履历卡编号 */
    @Excel(name = "履历卡编号")
    private String cardNumber;

    /** 报废原因 */
    @Excel(name = "报废原因")
    private String scrapReason;

    /** 鉴定结论 */
    @Excel(name = "鉴定结论")
    private String expertConclusion;
    
    /** 是否审核 */
    @Excel(name = "是否审核")
    private String isAudit;

    /** 组织机构id */
    @Excel(name = "组织机构id")
    private Long deptId;
    
    /** 组织机构表 */
    @Excel(name = "组织机构表")
    private SysDept sysDept;

    /** 员工id */
    @Excel(name = "员工id")
    private Long userId;
    
    /** 员工表 */
    @Excel(name = "员工表")
    private SysUser sysUser;

    /** 设备档案id */
    @Excel(name = "设备档案id")
    private Long archivesId;
    
    /** 设备档案表 */
    @Excel(name = "设备档案表")
    private HyEquipmentArchives hyEquipmentArchives;

    /** 保养计划id */
    @Excel(name = "保养计划id")
    private Long planId;
    
    /** 保养计划表 */
    @Excel(name = "保养计划表")
    private HyMaintenanceplan hyMaintenanceplan;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDocumentNumber(String documentNumber) 
    {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber() 
    {
        return documentNumber;
    }
    public void setScrapDate(Date scrapDate) 
    {
        this.scrapDate = scrapDate;
    }

    public Date getScrapDate() 
    {
        return scrapDate;
    }
    public void setScrapType(String scrapType) 
    {
        this.scrapType = scrapType;
    }

    public String getScrapType() 
    {
        return scrapType;
    }
    public void setManufactureFactory(String manufactureFactory) 
    {
        this.manufactureFactory = manufactureFactory;
    }

    public String getManufactureFactory() 
    {
        return manufactureFactory;
    }
    public void setCommissioningDate(Date commissioningDate) 
    {
        this.commissioningDate = commissioningDate;
    }

    public Date getCommissioningDate() 
    {
        return commissioningDate;
    }
    public void setOriginalValue(BigDecimal originalValue) 
    {
        this.originalValue = originalValue;
    }

    public BigDecimal getOriginalValue() 
    {
        return originalValue;
    }
    public void setPresentValue(BigDecimal presentValue) 
    {
        this.presentValue = presentValue;
    }

    public BigDecimal getPresentValue() 
    {
        return presentValue;
    }
    public void setServiceProcess(String serviceProcess) 
    {
        this.serviceProcess = serviceProcess;
    }

    public String getServiceProcess() 
    {
        return serviceProcess;
    }
    public void setCardNumber(String cardNumber) 
    {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() 
    {
        return cardNumber;
    }
    public void setScrapReason(String scrapReason) 
    {
        this.scrapReason = scrapReason;
    }

    public String getScrapReason() 
    {
        return scrapReason;
    }
    public void setExpertConclusion(String expertConclusion) 
    {
        this.expertConclusion = expertConclusion;
    }

    public String getExpertConclusion() 
    {
        return expertConclusion;
    }
    
    public String getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(String isAudit) {
		this.isAudit = isAudit;
	}

	public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setArchivesId(Long archivesId) 
    {
        this.archivesId = archivesId;
    }

    public Long getArchivesId() 
    {
        return archivesId;
    }
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }

    public SysDept getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public HyEquipmentArchives getHyEquipmentArchives() {
		return hyEquipmentArchives;
	}

	public void setHyEquipmentArchives(HyEquipmentArchives hyEquipmentArchives) {
		this.hyEquipmentArchives = hyEquipmentArchives;
	}

	public HyMaintenanceplan getHyMaintenanceplan() {
		return hyMaintenanceplan;
	}

	public void setHyMaintenanceplan(HyMaintenanceplan hyMaintenanceplan) {
		this.hyMaintenanceplan = hyMaintenanceplan;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("documentNumber", getDocumentNumber())
            .append("scrapDate", getScrapDate())
            .append("scrapType", getScrapType())
            .append("manufactureFactory", getManufactureFactory())
            .append("commissioningDate", getCommissioningDate())
            .append("originalValue", getOriginalValue())
            .append("presentValue", getPresentValue())
            .append("serviceProcess", getServiceProcess())
            .append("cardNumber", getCardNumber())
            .append("scrapReason", getScrapReason())
            .append("expertConclusion", getExpertConclusion())
            .append("isAudit", getIsAudit())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .append("archivesId", getArchivesId())
            .append("planId", getPlanId())
            .append("sysDept", getSysDept())
            .append("sysUser", getSysUser())
            .append("hyEquipmentArchives", getHyEquipmentArchives())
            .append("hyMaintenanceplan", getHyMaintenanceplan())
            .toString();
    }
}
