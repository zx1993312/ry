package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预交冲抵对象 hy_payment_offset
 * 
 * @author Administrator
 * @date 2021-05-26
 */
public class HyPaymentOffset extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 冲抵类别 */
    @Excel(name = "冲抵类别")
    private Integer offsetCategory;

    /** 冲抵人 */
    @Excel(name = "冲抵人")
    private String offsetPreson;

    /** 冲抵操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "冲抵操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date offsetOperationDate;

    /** 冲抵范围 */
    @Excel(name = "冲抵范围")
    private String offsetRange;

    /** 冲抵年度 */
    @Excel(name = "冲抵年度")
    private String offsetYear;

    /** 冲抵月份 */
    @Excel(name = "冲抵月份")
    private String offsetMonth;

    /** 冲抵金额 */
    @Excel(name = "冲抵金额")
    private BigDecimal offsetMoney;
    
    /** 实收金额 */
    @Excel(name = "实收金额")
    private BigDecimal amountActually;

    /** 处理方式 */
    @Excel(name = "处理方式")
    private String offsetType;

    /** 审核流程 */
    @Excel(name = "审核流程")
    private String auditProcess;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String auditStatus;

    /** 房屋id */
    @Excel(name = "房屋id")
    private Long houseId;

    /** 票据id */
    @Excel(name = "票据id")
    private Long setId;
    
    /** 房屋表 */
    @Excel(name = "房屋表")
    private HyHouseInf hyHouseInf;
    
    /** 业主表 */
    @Excel(name = "业主表")
    private HyOwnerRegistration hyOwnerRegistration;
    
    /** 费用项目表 */
    @Excel(name = "费用项目表")
    private HyCost hyCost;
    
    /** 车位表 */
    @Excel(name = "车位表")
    private HyParkingInf hyParkingInf;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOffsetCategory(Integer offsetCategory) 
    {
        this.offsetCategory = offsetCategory;
    }

    public Integer getOffsetCategory() 
    {
        return offsetCategory;
    }
    public void setOffsetPreson(String offsetPreson) 
    {
        this.offsetPreson = offsetPreson;
    }

    public String getOffsetPreson() 
    {
        return offsetPreson;
    }
    public void setOffsetOperationDate(Date offsetOperationDate) 
    {
        this.offsetOperationDate = offsetOperationDate;
    }

    public Date getOffsetOperationDate() 
    {
        return offsetOperationDate;
    }
    public void setOffsetRange(String offsetRange) 
    {
        this.offsetRange = offsetRange;
    }

    public String getOffsetRange() 
    {
        return offsetRange;
    }
    public void setOffsetYear(String offsetYear) 
    {
        this.offsetYear = offsetYear;
    }

    public String getOffsetYear() 
    {
        return offsetYear;
    }
    public void setOffsetMonth(String offsetMonth) 
    {
        this.offsetMonth = offsetMonth;
    }

    public String getOffsetMonth() 
    {
        return offsetMonth;
    }
    public void setOffsetMoney(BigDecimal offsetMoney) 
    {
        this.offsetMoney = offsetMoney;
    }

    public BigDecimal getOffsetMoney() 
    {
        return offsetMoney;
    }
    
    public BigDecimal getAmountActually() {
		return amountActually;
	}

	public void setAmountActually(BigDecimal amountActually) {
		this.amountActually = amountActually;
	}

	public void setOffsetType(String offsetType) 
    {
        this.offsetType = offsetType;
    }

    public String getOffsetType() 
    {
        return offsetType;
    }
    public void setAuditProcess(String auditProcess) 
    {
        this.auditProcess = auditProcess;
    }

    public String getAuditProcess() 
    {
        return auditProcess;
    }
    public void setAuditStatus(String auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public String getAuditStatus() 
    {
        return auditStatus;
    }
    public void setHouseId(Long houseId) 
    {
        this.houseId = houseId;
    }

    public Long getHouseId() 
    {
        return houseId;
    }
    public void setSetId(Long setId) 
    {
        this.setId = setId;
    }

    public Long getSetId() 
    {
        return setId;
    }

    public HyHouseInf getHyHouseInf() {
		return hyHouseInf;
	}

	public void setHyHouseInf(HyHouseInf hyHouseInf) {
		this.hyHouseInf = hyHouseInf;
	}

	public HyOwnerRegistration getHyOwnerRegistration() {
		return hyOwnerRegistration;
	}

	public void setHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		this.hyOwnerRegistration = hyOwnerRegistration;
	}

	public HyCost getHyCost() {
		return hyCost;
	}

	public void setHyCost(HyCost hyCost) {
		this.hyCost = hyCost;
	}

	public HyParkingInf getHyParkingInf() {
		return hyParkingInf;
	}

	public void setHyParkingInf(HyParkingInf hyParkingInf) {
		this.hyParkingInf = hyParkingInf;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("offsetCategory", getOffsetCategory())
            .append("offsetPreson", getOffsetPreson())
            .append("offsetOperationDate", getOffsetOperationDate())
            .append("offsetRange", getOffsetRange())
            .append("offsetYear", getOffsetYear())
            .append("offsetMonth", getOffsetMonth())
            .append("offsetMoney", getOffsetMoney())
            .append("amountActually", getAmountActually())
            .append("offsetType", getOffsetType())
            .append("auditProcess", getAuditProcess())
            .append("auditStatus", getAuditStatus())
            .append("houseId", getHouseId())
            .append("setId", getSetId())
            .append("hyHouseInf", getHyHouseInf())
            .append("hyOwnerRegistration", getHyOwnerRegistration())
            .append("hyCost", getHyCost())
            .append("hyParkingInf", getHyParkingInf())
            .toString();
    }
}