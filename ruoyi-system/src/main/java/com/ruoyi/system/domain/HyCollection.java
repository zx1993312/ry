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
 * @date 2021-01-04
 */
public class HyCollection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收款审核ID */
    private Long id;

    /** 管理项目 */
    @Excel(name = "管理项目")
    private String manageProjects;

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
    private Integer collection;

    /** 收款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectionTime;

    /** 财务收款人 */
    @Excel(name = "财务收款人")
    private String collectionPerson;

    /** 是否记账 */
    @Excel(name = "是否记账")
    private Integer bookkeeping;

    /** 记账时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记账时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bookTime;

    /** 财务记账人 */
    @Excel(name = "财务记账人")
    private String bookPerson;

    /** 备注 */
    @Excel(name = "备注")
    private String brake;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setManageProjects(String manageProjects) 
    {
        this.manageProjects = manageProjects;
    }

    public String getManageProjects() 
    {
        return manageProjects;
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
    public void setCollection(Integer collection) 
    {
        this.collection = collection;
    }

    public Integer getCollection() 
    {
        return collection;
    }
    public void setCollectionTime(Date collectionTime) 
    {
        this.collectionTime = collectionTime;
    }

    public Date getCollectionTime() 
    {
        return collectionTime;
    }
    public void setCollectionPerson(String collectionPerson) 
    {
        this.collectionPerson = collectionPerson;
    }

    public String getCollectionPerson() 
    {
        return collectionPerson;
    }
    public void setBookkeeping(Integer bookkeeping) 
    {
        this.bookkeeping = bookkeeping;
    }

    public Integer getBookkeeping() 
    {
        return bookkeeping;
    }
    public void setBookTime(Date bookTime) 
    {
        this.bookTime = bookTime;
    }

    public Date getBookTime() 
    {
        return bookTime;
    }
    public void setBookPerson(String bookPerson) 
    {
        this.bookPerson = bookPerson;
    }

    public String getBookPerson() 
    {
        return bookPerson;
    }
    public void setBrake(String brake) 
    {
        this.brake = brake;
    }

    public String getBrake() 
    {
        return brake;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("manageProjects", getManageProjects())
            .append("applyTime", getApplyTime())
            .append("payee", getPayee())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("amount", getAmount())
            .append("collection", getCollection())
            .append("collectionTime", getCollectionTime())
            .append("collectionPerson", getCollectionPerson())
            .append("bookkeeping", getBookkeeping())
            .append("bookTime", getBookTime())
            .append("bookPerson", getBookPerson())
            .append("brake", getBrake())
            .toString();
    }
}
