package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 票据设置对象 hy_bill_set
 * 
 * @author Administrator
 * @date 2021-05-24
 */
public class HyBillSet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 业务类型 */
    @Excel(name = "业务类型")
    private Integer businessType;

    /** 票据种类 */
    @Excel(name = "票据种类")
    private String billTypes;

    /** 票据类别 */
    @Excel(name = "票据类别")
    private String billCategory;

    /** 票据号码 */
    @Excel(name = "票据号码")
    private String billNumber;

    /** 前缀 */
    @Excel(name = "前缀")
    private String prefix;

    /** 后缀 */
    @Excel(name = "后缀")
    private String suffix;

    /** 发票号码 */
    @Excel(name = "发票号码")
    private String invoiceNumber;

    /** 位数 */
    @Excel(name = "位数")
    private String digit;

    /** 票据日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "票据日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date billDate;

    /** 票据样例 */
    @Excel(name = "票据样例")
    private String billSample;

    /** 新票据日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "新票据日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date billDateNew;

    /** 定额票据面板 */
    @Excel(name = "定额票据面板")
    private String billPanel;

    /** 新收款方式 */
    @Excel(name = "新收款方式")
    private String paymentMethodNew;

    /** 收款方式 */
    @Excel(name = "收款方式")
    private String paymentMethod;

    /** 收款人 */
    @Excel(name = "收款人")
    private String paymentPerson;

    /** 收款金额 */
    @Excel(name = "收款金额")
    private BigDecimal paymentAmount;

    /** 收款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date paymentDate;

    /** 修改人 */
    @Excel(name = "修改人")
    private String modifyPerson;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 定额票据 */
    @Excel(name = "定额票据")
    private String panel;

    /** 收/退款金额 */
    @Excel(name = "收/退款金额")
    private BigDecimal billAmount;

    /** 是否撤销 */
    @Excel(name = "是否撤销")
    private Integer cancelNot;

    /** 是否冲销 */
    @Excel(name = "是否冲销")
    private Integer writeNot;

    /** 支/汇票号 */
    @Excel(name = "支/汇票号")
    private String draftCheckNumber;
    
    /** 房屋表 */
    @Excel(name = "房屋表")
    private HyHouseInf hyHouseInf;

    /** 业主id */
    @Excel(name = "业主id")
    private Long ownerId;
    
    /** 业主表 */
    @Excel(name = "业主表")
    private HyOwnerRegistration hyOwnerRegistration;
    
    /** 费用项目id */
    @Excel(name = "费用项目id")
    private Long costId;
    
    /** 费用项目表 */
    @Excel(name = "费用项目表")
    private HyCost hyCost;

    /** 撤销id */
    @Excel(name = "撤销id")
    private Long revokeId;
    
    /** 撤销表 */
    @Excel(name = "撤销表")
    private HyRevoke hyRevoke;

    /** 预交id */
    @Excel(name = "预交id")
    private Long offsetId;
    
    /** 预交表 */
    @Excel(name = "预交表")
    private HyPaymentOffset hyPaymentOffset;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBusinessType(Integer businessType) 
    {
        this.businessType = businessType;
    }

    public Integer getBusinessType() 
    {
        return businessType;
    }
    public void setBillTypes(String billTypes) 
    {
        this.billTypes = billTypes;
    }

    public String getBillTypes() 
    {
        return billTypes;
    }
    public void setBillCategory(String billCategory) 
    {
        this.billCategory = billCategory;
    }

    public String getBillCategory() 
    {
        return billCategory;
    }
    public void setBillNumber(String billNumber) 
    {
        this.billNumber = billNumber;
    }

    public String getBillNumber() 
    {
        return billNumber;
    }
    public void setPrefix(String prefix) 
    {
        this.prefix = prefix;
    }

    public String getPrefix() 
    {
        return prefix;
    }
    public void setSuffix(String suffix) 
    {
        this.suffix = suffix;
    }

    public String getSuffix() 
    {
        return suffix;
    }
    public void setInvoiceNumber(String invoiceNumber) 
    {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNumber() 
    {
        return invoiceNumber;
    }
    public void setDigit(String digit) 
    {
        this.digit = digit;
    }

    public String getDigit() 
    {
        return digit;
    }
    public void setBillDate(Date billDate) 
    {
        this.billDate = billDate;
    }

    public Date getBillDate() 
    {
        return billDate;
    }
    public void setBillSample(String billSample) 
    {
        this.billSample = billSample;
    }

    public String getBillSample() 
    {
        return billSample;
    }
    public void setBillDateNew(Date billDateNew) 
    {
        this.billDateNew = billDateNew;
    }

    public Date getBillDateNew() 
    {
        return billDateNew;
    }
    public void setBillPanel(String billPanel) 
    {
        this.billPanel = billPanel;
    }

    public String getBillPanel() 
    {
        return billPanel;
    }
    public void setPaymentMethodNew(String paymentMethodNew) 
    {
        this.paymentMethodNew = paymentMethodNew;
    }

    public String getPaymentMethodNew() 
    {
        return paymentMethodNew;
    }
    public void setPaymentMethod(String paymentMethod) 
    {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() 
    {
        return paymentMethod;
    }
    public void setPaymentPerson(String paymentPerson) 
    {
        this.paymentPerson = paymentPerson;
    }

    public String getPaymentPerson() 
    {
        return paymentPerson;
    }
    public void setPaymentAmount(BigDecimal paymentAmount) 
    {
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getPaymentAmount() 
    {
        return paymentAmount;
    }
    public void setPaymentDate(Date paymentDate) 
    {
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDate() 
    {
        return paymentDate;
    }
    public void setModifyPerson(String modifyPerson) 
    {
        this.modifyPerson = modifyPerson;
    }

    public String getModifyPerson() 
    {
        return modifyPerson;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }
    public void setPanel(String panel) 
    {
        this.panel = panel;
    }

    public String getPanel() 
    {
        return panel;
    }
    public void setBillAmount(BigDecimal billAmount) 
    {
        this.billAmount = billAmount;
    }

    public BigDecimal getBillAmount() 
    {
        return billAmount;
    }
    public void setCancelNot(Integer cancelNot) 
    {
        this.cancelNot = cancelNot;
    }

    public Integer getCancelNot() 
    {
        return cancelNot;
    }
    public void setWriteNot(Integer writeNot) 
    {
        this.writeNot = writeNot;
    }

    public Integer getWriteNot() 
    {
        return writeNot;
    }
    public void setDraftCheckNumber(String draftCheckNumber) 
    {
        this.draftCheckNumber = draftCheckNumber;
    }

    public String getDraftCheckNumber() 
    {
        return draftCheckNumber;
    }
    public void setOwnerId(Long ownerId) 
    {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() 
    {
        return ownerId;
    }
    public void setCostId(Long costId) 
    {
        this.costId = costId;
    }

    public Long getCostId() 
    {
        return costId;
    }
    public void setRevokeId(Long revokeId) 
    {
        this.revokeId = revokeId;
    }

    public Long getRevokeId() 
    {
        return revokeId;
    }
    public void setOffsetId(Long offsetId) 
    {
        this.offsetId = offsetId;
    }

    public Long getOffsetId() 
    {
        return offsetId;
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

	public HyRevoke getHyRevoke() {
		return hyRevoke;
	}

	public void setHyRevoke(HyRevoke hyRevoke) {
		this.hyRevoke = hyRevoke;
	}

	public HyPaymentOffset getHyPaymentOffset() {
		return hyPaymentOffset;
	}

	public void setHyPaymentOffset(HyPaymentOffset hyPaymentOffset) {
		this.hyPaymentOffset = hyPaymentOffset;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("businessType", getBusinessType())
            .append("billTypes", getBillTypes())
            .append("billCategory", getBillCategory())
            .append("billNumber", getBillNumber())
            .append("prefix", getPrefix())
            .append("suffix", getSuffix())
            .append("invoiceNumber", getInvoiceNumber())
            .append("digit", getDigit())
            .append("billDate", getBillDate())
            .append("billSample", getBillSample())
            .append("billDateNew", getBillDateNew())
            .append("billPanel", getBillPanel())
            .append("paymentMethodNew", getPaymentMethodNew())
            .append("paymentMethod", getPaymentMethod())
            .append("paymentPerson", getPaymentPerson())
            .append("paymentAmount", getPaymentAmount())
            .append("paymentDate", getPaymentDate())
            .append("modifyPerson", getModifyPerson())
            .append("modifyTime", getModifyTime())
            .append("panel", getPanel())
            .append("billAmount", getBillAmount())
            .append("cancelNot", getCancelNot())
            .append("writeNot", getWriteNot())
            .append("remark", getRemark())
            .append("draftCheckNumber", getDraftCheckNumber())
            .append("ownerId", getOwnerId())
            .append("costId", getCostId())
            .append("revokeId", getRevokeId())
            .append("offsetId", getOffsetId())
            .append("hyHouseInf", getHyHouseInf())
            .append("hyOwnerRegistration", getHyOwnerRegistration())
            .append("hyCost", getHyCost())
            .append("hyRevoke", getHyRevoke())
            .append("hyPaymentOffset", getHyPaymentOffset())
            .toString();
    }
}