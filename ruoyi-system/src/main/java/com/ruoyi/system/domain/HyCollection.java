package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收款管理 Collection management对象 hy_collection
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
public class HyCollection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收款审核ID */
    private Long id;

    /** 申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyTime;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 收据号码 */
    @Excel(name = "收据号码")
    private String receiptNumber;
    
    /** 总金额 */
    @Excel(name = "总金额")
    private BigDecimal amount;

    /** 是否收款 */
    @Excel(name = "是否收款")
    private String isCollection;
    
    /** 收款方式 */
    @Excel(name = "收款方式")
    private String collectionType;
    
    /** 收款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectionTime;

    /** 收款人 */
    @Excel(name = "收款人")
    private String payee;

    /** 是否记账 */
    @Excel(name = "是否记账")
    private String isBook;

    /** 记账时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记账时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bookTime;
    
    /** 记账人 */
    @Excel(name = "记账人")
    private String bookPerson;

    /** 是否交款 */
    @Excel(name = "是否交款")
    private String paymentStatue;
    
    /** 交款方式 */
    @Excel(name = "交款方式")
    private String payment;
    
    /** 交款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date paymentTime;

    /** 交款人 */
    @Excel(name = "交款人")
    private String paymentPerson;
    
    /** 是否延期 */
    @Excel(name = "是否延期")
    private String isDeferred;
    
    /** 延期原因 */
    @Excel(name = "延期原因")
    private String deferredCause;
    
    /** 延期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "延期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deferredTime;
    
    /** 延期人 */
    @Excel(name = "延期人")
    private String deferredPerson;
    
    /** 是否退款 */
    @Excel(name = "是否退款")
    private String isRefund;
    
    /** 退款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date refundTime;
    
    /** 退款人 */
    @Excel(name = "退款人")
    private String refundPerson;

    /** 备注 */
    @Excel(name = "备注")
    private String collectionRemark;
    
    /** 月份 */
    private int month;

    /** 费用项目id */
    private Long costId;
    
    /** 费用项目id组 */
    private String costIds;
    
    /** 费用项目表 */
    private HyCost hyCost;

    /** 房屋id */
    private Long houseId;
    
    /** 房屋表 */
    private HyHouseInf hyHouseInf;
    
    /** 楼宇表 */
    private HyBuilding hyBuilding;

    /** 业主id */
    private Long ownerId;
    
    /** 业主表 */
    private HyOwnerRegistration hyOwnerRegistration;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setApplyTime(Date applyTime) 
    {
        this.applyTime = applyTime;
    }

    public Date getApplyTime() 
    {
        return applyTime;
    }
    public void setPayee(String payee) 
    {
        this.payee = payee;
    }

    public String getPayee() 
    {
        return payee;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setIsCollection(String isCollection) 
    {
        this.isCollection = isCollection;
    }

    public String getIsCollection() 
    {
        return isCollection;
    }
    public void setPaymentPerson(String paymentPerson) 
    {
        this.paymentPerson = paymentPerson;
    }

    public String getPaymentPerson() 
    {
        return paymentPerson;
    }
    public void setCollectionTime(Date collectionTime) 
    {
        this.collectionTime = collectionTime;
    }

    public Date getCollectionTime() 
    {
        return collectionTime;
    }
    public void setIsBook(String isBook) 
    {
        this.isBook = isBook;
    }

    public String getIsBook() 
    {
        return isBook;
    }
    public void setBookTime(Date bookTime) 
    {
        this.bookTime = bookTime;
    }

    public Date getBookTime() 
    {
        return bookTime;
    }
    public void setPaymentStatue(String paymentStatue) 
    {
        this.paymentStatue = paymentStatue;
    }

    public String getPaymentStatue() 
    {
        return paymentStatue;
    }
    public void setBookPerson(String bookPerson) 
    {
        this.bookPerson = bookPerson;
    }

    public String getBookPerson() 
    {
        return bookPerson;
    }
    public void setPayment(String payment) 
    {
        this.payment = payment;
    }

    public String getPayment() 
    {
        return payment;
    }
    public void setCollectionRemark(String collectionRemark) 
    {
        this.collectionRemark = collectionRemark;
    }

    public String getCollectionRemark() 
    {
        return collectionRemark;
    }
    public void setCostId(Long costId) 
    {
        this.costId = costId;
    }

    public Long getCostId() 
    {
        return costId;
    }
    public void setHouseId(Long houseId) 
    {
        this.houseId = houseId;
    }

    public Long getHouseId() 
    {
        return houseId;
    }
    public void setOwnerId(Long ownerId) 
    {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() 
    {
        return ownerId;
    }

    public HyCost getHyCost() {
		return hyCost;
	}

	public void setHyCost(HyCost hyCost) {
		this.hyCost = hyCost;
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

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getIsDeferred() {
		return isDeferred;
	}

	public void setIsDeferred(String isDeferred) {
		this.isDeferred = isDeferred;
	}

	public String getDeferredCause() {
		return deferredCause;
	}

	public void setDeferredCause(String deferredCause) {
		this.deferredCause = deferredCause;
	}

	public Date getDeferredTime() {
		return deferredTime;
	}

	public void setDeferredTime(Date deferredTime) {
		this.deferredTime = deferredTime;
	}

	public String getDeferredPerson() {
		return deferredPerson;
	}

	public void setDeferredPerson(String deferredPerson) {
		this.deferredPerson = deferredPerson;
	}

	public String getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	public String getRefundPerson() {
		return refundPerson;
	}

	public void setRefundPerson(String refundPerson) {
		this.refundPerson = refundPerson;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getCostIds() {
		return costIds;
	}

	public void setCostIds(String costIds) {
		this.costIds = costIds;
	}

	public HyBuilding getHyBuilding() {
		return hyBuilding;
	}

	public void setHyBuilding(HyBuilding hyBuilding) {
		this.hyBuilding = hyBuilding;
	}

	@Override
	public String toString() {
		return "HyCollection [id=" + id + ", applyTime=" + applyTime + ", startTime=" + startTime + ", endTime="
				+ endTime + ", receiptNumber=" + receiptNumber + ", amount=" + amount + ", isCollection=" + isCollection
				+ ", collectionType=" + collectionType + ", collectionTime=" + collectionTime + ", payee=" + payee
				+ ", isBook=" + isBook + ", bookTime=" + bookTime + ", bookPerson=" + bookPerson + ", paymentStatue="
				+ paymentStatue + ", payment=" + payment + ", paymentTime=" + paymentTime + ", paymentPerson="
				+ paymentPerson + ", isDeferred=" + isDeferred + ", deferredCause=" + deferredCause + ", deferredTime="
				+ deferredTime + ", deferredPerson=" + deferredPerson + ", isRefund=" + isRefund + ", refundTime="
				+ refundTime + ", refundPerson=" + refundPerson + ", collectionRemark=" + collectionRemark + ", month="
				+ month + ", costId=" + costId + ", costIds=" + costIds + ", hyCost=" + hyCost + ", houseId=" + houseId
				+ ", hyHouseInf=" + hyHouseInf + ", hyBuilding=" + hyBuilding + ", ownerId=" + ownerId
				+ ", hyOwnerRegistration=" + hyOwnerRegistration + "]";
	}

	




}