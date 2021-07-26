package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单对象 hy_order
 * 
 * @author Administrator
 * @date 2021-07-15
 */
public class HyOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNumber;
    
    /** 订单状态 */
    @Excel(name = "订单状态")
    private String orderState;

    /** 退款原因 */
    @Excel(name = "退款原因")
    private String refundReason;

    /** 退款说明 */
    @Excel(name = "退款说明")
    private String refundInstructions;

    /** 退款金额 */
    @Excel(name = "退款金额")
    private BigDecimal refundAmount;

    /** 商品id组 */
    @Excel(name = "商品id组")
    private String productIds;
    
    /** 业主id */
    @Excel(name = "业主id")
    private Long ownerId;
    
    /** 业主表 */
    @Excel(name = "业主表")
    private HyOwnerRegistration hyOwnerRegistration;
    
    /** 商品表 */
    @Excel(name = "商品表")
    private HyProduct hyProduct;
    
    /** 商品缩略图表 */
    @Excel(name = "商品缩略图表")
    private HyPicture hyPicture;
    
    /** 订单商品中间表 */
    @Excel(name = "订单商品中间表")
    private OrderAndProduct orderAndProduct;
    
    /** 商品数量组 */
    private String numbers;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    
	public void setOrderState(String orderState) 
    {
        this.orderState = orderState;
    }

    public String getOrderState() 
    {
        return orderState;
    }
    public void setRefundReason(String refundReason) 
    {
        this.refundReason = refundReason;
    }

    public String getRefundReason() 
    {
        return refundReason;
    }
    public void setRefundInstructions(String refundInstructions) 
    {
        this.refundInstructions = refundInstructions;
    }

    public String getRefundInstructions() 
    {
        return refundInstructions;
    }
    public void setRefundAmount(BigDecimal refundAmount) 
    {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getRefundAmount() 
    {
        return refundAmount;
    }
    
    public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public void setOwnerId(Long ownerId) 
    {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() 
    {
        return ownerId;
    }

    public HyOwnerRegistration getHyOwnerRegistration() {
		return hyOwnerRegistration;
	}

	public void setHyOwnerRegistration(HyOwnerRegistration hyOwnerRegistration) {
		this.hyOwnerRegistration = hyOwnerRegistration;
	}

	public HyProduct getHyProduct() {
		return hyProduct;
	}

	public void setHyProduct(HyProduct hyProduct) {
		this.hyProduct = hyProduct;
	}

	public HyPicture getHyPicture() {
		return hyPicture;
	}

	public void setHyPicture(HyPicture hyPicture) {
		this.hyPicture = hyPicture;
	}

	public OrderAndProduct getOrderAndProduct() {
		return orderAndProduct;
	}

	public void setOrderAndProduct(OrderAndProduct orderAndProduct) {
		this.orderAndProduct = orderAndProduct;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderNumber", getOrderNumber())
            .append("orderState", getOrderState())
            .append("createTime", getCreateTime())
            .append("refundReason", getRefundReason())
            .append("refundInstructions", getRefundInstructions())
            .append("refundAmount", getRefundAmount())
            .append("productIds", getProductIds())
            .append("ownerId", getOwnerId())
            .append("hyOwnerRegistration", getHyOwnerRegistration())
            .append("hyProduct", getHyProduct())
            .append("hyPicture", getHyPicture())
            .append("orderAndProduct", getOrderAndProduct())
            .append("numbers", getNumbers())
            .toString();
    }
}