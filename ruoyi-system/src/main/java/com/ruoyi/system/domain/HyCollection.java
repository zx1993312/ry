package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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

    /** 收款人 */
    @Excel(name = "收款人")
    private String payee;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 总金额 */
    @Excel(name = "总金额")
    private Long amount;

    /** 是否收款 */
    @Excel(name = "是否收款")
    private String isCollection;

    /** 交款人 */
    @Excel(name = "交款人")
    private String paymentPerson;

    /** 收款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectionTime;

    /** 是否记账 */
    @Excel(name = "是否记账")
    private String isBook;

    /** 记账时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记账时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bookTime;

    /** 是否交款 */
    @Excel(name = "是否交款")
    private String paymentStatue;

    /** 财务记账人 */
    @Excel(name = "财务记账人")
    private String bookPerson;

    /** 交款方式 */
    @Excel(name = "交款方式")
    private String payment;

    /** 备注 */
    @Excel(name = "备注")
    private String collectionRemark;

    /** 费用项目id */
    @Excel(name = "费用项目id")
    private Long costId;
    
    /** 费用项目表 */
    @Excel(name = "费用项目表")
    private HyCost hyCost;

    /** 房屋id */
    @Excel(name = "房屋id")
    private Long houseId;
    
    /** 房屋表 */
    @Excel(name = "房屋表")
    private HyHouseInf hyHouseInf;

    /** 业主id */
    @Excel(name = "业主id")
    private Long ownerId;
    
    /** 业主表 */
    @Excel(name = "业主表")
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
    public void setAmount(Long amount) 
    {
        this.amount = amount;
    }

    public Long getAmount() 
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

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applyTime", getApplyTime())
            .append("payee", getPayee())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("amount", getAmount())
            .append("isCollection", getIsCollection())
            .append("paymentPerson", getPaymentPerson())
            .append("collectionTime", getCollectionTime())
            .append("isBook", getIsBook())
            .append("bookTime", getBookTime())
            .append("paymentStatue", getPaymentStatue())
            .append("bookPerson", getBookPerson())
            .append("payment", getPayment())
            .append("collectionRemark", getCollectionRemark())
            .append("costId", getCostId())
            .append("houseId", getHouseId())
            .append("ownerId", getOwnerId())
            .append("hyCost", getHyCost())
            .append("hyHouseInf", getHyHouseInf())
            .append("hyOwnerRegistration", getHyOwnerRegistration())
            .toString();
    }
}