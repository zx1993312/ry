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

    /** 冲抵人 */
    @Excel(name = "冲抵人")
    private String offsetPreson;

    /** 冲抵操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "冲抵操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date offsetOperationDate;

    /** 冲抵年度 */
    @Excel(name = "冲抵年度")
    private String offsetYear;

    /** 冲抵月份 */
    @Excel(name = "冲抵月份")
    private String offsetMonth;

    /** 冲抵金额 */
    @Excel(name = "冲抵金额")
    private BigDecimal offsetMoney;
    
    /** 截止日期 */
    @Excel(name = "截止日期")
    private String offsetDate;

    /** 审核流程 */
    @Excel(name = "审核流程")
    private String auditProcess;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String auditStatus;

    /** 房屋id */
    @Excel(name = "房屋id")
    private Long houseId;

    /** 费用id */
    @Excel(name = "费用id")
    private Long costId;
    
    /** 费用id组 */
    @Excel(name = "费用id组")
    private String costIds;
    
    /** 房屋表 */
    @Excel(name = "房屋表")
    private HyHouseInf hyHouseInf;
    
    /** 业主表 */
    @Excel(name = "业主表")
    private HyOwnerRegistration hyOwnerRegistration;
    
    /** 费用项目表 */
    @Excel(name = "费用项目表")
    private HyCost hyCost;
    

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOffsetPreson() {
		return offsetPreson;
	}


	public void setOffsetPreson(String offsetPreson) {
		this.offsetPreson = offsetPreson;
	}


	public Date getOffsetOperationDate() {
		return offsetOperationDate;
	}


	public void setOffsetOperationDate(Date offsetOperationDate) {
		this.offsetOperationDate = offsetOperationDate;
	}


	public String getOffsetYear() {
		return offsetYear;
	}


	public void setOffsetYear(String offsetYear) {
		this.offsetYear = offsetYear;
	}


	public String getOffsetMonth() {
		return offsetMonth;
	}


	public void setOffsetMonth(String offsetMonth) {
		this.offsetMonth = offsetMonth;
	}


	public BigDecimal getOffsetMoney() {
		return offsetMoney;
	}


	public void setOffsetMoney(BigDecimal offsetMoney) {
		this.offsetMoney = offsetMoney;
	}


	public String getOffsetDate() {
		return offsetDate;
	}


	public void setOffsetDate(String offsetDate) {
		this.offsetDate = offsetDate;
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


	public Long getHouseId() {
		return houseId;
	}


	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}


	public Long getCostId() {
		return costId;
	}


	public void setCostId(Long costId) {
		this.costId = costId;
	}


	public String getCostIds() {
		return costIds;
	}


	public void setCostIds(String costIds) {
		this.costIds = costIds;
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


	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("offsetPreson", getOffsetPreson())
            .append("offsetOperationDate", getOffsetOperationDate())
            .append("offsetYear", getOffsetYear())
            .append("offsetMonth", getOffsetMonth())
            .append("offsetMoney", getOffsetMoney())
            .append("offsetDate", getOffsetDate())
            .append("auditProcess", getAuditProcess())
            .append("auditStatus", getAuditStatus())
            .append("houseId", getHouseId())
            .append("costId", getCostId())
            .append("costIds", getCostIds())
            .append("hyHouseInf", getHyHouseInf())
            .append("hyOwnerRegistration", getHyOwnerRegistration())
            .append("hyCost", getHyCost())
            .toString();
    }
}