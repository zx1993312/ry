package com.ruoyi.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class HyEntry extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private Long id;

	/** 入账类别 */
	@Excel(name = "入账类别")
	@EnumAnn(enumClass = EntryEnum.class)
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

	/** 费用项目id */
	@Excel(name = "费用项目id")
	private Long costId;

	/** 审核流程 */
	private String auditProcess;

	/** 审核状态 */
	private String auditStatus;

	/** 费用项目表 */
	private HyCost hyCost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEntryType() {
		return entryType;
	}

	public void setEntryType(Integer entryType) {
		this.entryType = entryType;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getEntryPerson() {
		return entryPerson;
	}

	public void setEntryPerson(String entryPerson) {
		this.entryPerson = entryPerson;
	}

	public String getEntryRange() {
		return entryRange;
	}

	public void setEntryRange(String entryRange) {
		this.entryRange = entryRange;
	}

	public Date getEntryDateStr() {
		return entryDateStr;
	}

	public void setEntryDateStr(Date entryDateStr) {
		this.entryDateStr = entryDateStr;
	}

	public Date getEntryDateEnd() {
		return entryDateEnd;
	}

	public void setEntryDateEnd(Date entryDateEnd) {
		this.entryDateEnd = entryDateEnd;
	}

	public String getEntryAmount() {
		return entryAmount;
	}

	public void setEntryAmount(String entryAmount) {
		this.entryAmount = entryAmount;
	}

	public Long getCostId() {
		return costId;
	}

	public void setCostId(Long costId) {
		this.costId = costId;
	}

	public String getAuditProcess() {
		return auditProcess;
	}

	public void setAuditProcess(String auditProcess) {
		this.auditProcess = auditProcess;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public HyCost getHyCost() {
		return hyCost;
	}

	public void setHyCost(HyCost hyCost) {
		this.hyCost = hyCost;
	}

	@Override
	public String toString() {
		return "HyEntry [id=" + id + ", entryType=" + entryType + ", entryDate=" + entryDate + ", entryPerson="
				+ entryPerson + ", entryRange=" + entryRange + ", entryDateStr=" + entryDateStr + ", entryDateEnd="
				+ entryDateEnd + ", entryAmount=" + entryAmount + ", costId=" + costId + ", auditProcess="
				+ auditProcess + ", auditStatus=" + auditStatus + ", hyCost=" + hyCost + "]";
	}

}
