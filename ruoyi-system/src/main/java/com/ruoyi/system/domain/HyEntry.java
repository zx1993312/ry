package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.annotation.EnumAnn;
import com.ruoyi.system.enums.EntryEnum;

/**
 * 入账处理对象 hy_entry
 * 
 * @author Administrator
 * @date 2021-01-23
 */
public class HyEntry extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 入账类别 */
    @Excel(name = "入账类别")
    @EnumAnn(enumClass=EntryEnum.class)
    private Integer entryType;

    /** 入账时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入账时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryDate;

    /** 入账人 */
    @Excel(name = "入账人")
    private String entryPerson;

    /** 入账范围 */
    @Excel(name = "入账范围")
    private String entryRange;

    /** 入账开始年月 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入账开始年月", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryDateStr;

    /** 入账结束年月 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入账结束年月", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryDateEnd;

    /** 入账总金额 */
    @Excel(name = "入账总金额")
    private String entryAmount;

    /** 房屋编号 */
    @Excel(name = "房屋编号")
    private String houseNum;
    /**
     * 审核表
     */
  private HyAuditManagement hyAuditManagement;
    /**
     * 费用项目表
     */
    private HyCost hyCost;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEntryType(Integer entryType) 
    {
        this.entryType = entryType;
    }

    public Integer getEntryType() 
    {
        return entryType;
    }
    public void setEntryDate(Date entryDate) 
    {
        this.entryDate = entryDate;
    }

    public Date getEntryDate() 
    {
        return entryDate;
    }
    public void setEntryPerson(String entryPerson) 
    {
        this.entryPerson = entryPerson;
    }

    public String getEntryPerson() 
    {
        return entryPerson;
    }
    public void setEntryRange(String entryRange) 
    {
        this.entryRange = entryRange;
    }

    public String getEntryRange() 
    {
        return entryRange;
    }
    public void setEntryDateStr(Date entryDateStr) 
    {
        this.entryDateStr = entryDateStr;
    }

    public Date getEntryDateStr() 
    {
        return entryDateStr;
    }
    public void setEntryDateEnd(Date entryDateEnd) 
    {
        this.entryDateEnd = entryDateEnd;
    }

    public Date getEntryDateEnd() 
    {
        return entryDateEnd;
    }
    public void setEntryAmount(String entryAmount) 
    {
        this.entryAmount = entryAmount;
    }

    public String getEntryAmount() 
    {
        return entryAmount;
    }
    public void setHouseNum(String houseNum) 
    {
        this.houseNum = houseNum;
    }

    public String getHouseNum() 
    {
        return houseNum;
    }

   
	public HyCost getHyCost() {
		return hyCost;
	}

	public void setHyCost(HyCost hyCost) {
		this.hyCost = hyCost;
	}

	public HyAuditManagement getHyAuditManagement() {
		return hyAuditManagement;
	}

	public void setHyAuditManagement(HyAuditManagement hyAuditManagement) {
		this.hyAuditManagement = hyAuditManagement;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("entryType", getEntryType())
            .append("entryDate", getEntryDate())
            .append("entryPerson", getEntryPerson())
            .append("entryRange", getEntryRange())
            .append("entryDateStr", getEntryDateStr())
            .append("entryDateEnd", getEntryDateEnd())
            .append("entryAmount", getEntryAmount())
            .append("houseNum", getHouseNum())
            .toString();
    }
}
