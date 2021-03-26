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
 * @date 2021-03-15
 */
public class HyOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;
    
    /** 用户头像 */
    @Excel(name = "用户头像")
    private String userPictrue;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNumber;

    /** 商品名 */
    @Excel(name = "商品名")
    private String tradeName;

    /** 商家名 */
    @Excel(name = "商家名")
    private String businessName;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal unitPrice;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;
    /**订单装态*/
    @Excel(name="订单装态")
    private String state;
    /**用户表*/
    @Excel(name="用户表")
    private HyUser hyUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    
    public String getUserPictrue() {
		return userPictrue;
	}

	public void setUserPictrue(String userPictrue) {
		this.userPictrue = userPictrue;
	}

	public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setTradeName(String tradeName) 
    {
        this.tradeName = tradeName;
    }

    public String getTradeName() 
    {
        return tradeName;
    }
    public void setBusinessName(String businessName) 
    {
        this.businessName = businessName;
    }

    public String getBusinessName() 
    {
        return businessName;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }

    public HyUser getHyUser() {
		return hyUser;
	}

	public void setHyUser(HyUser hyUser) {
		this.hyUser = hyUser;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "HyOrder [id=" + id + ", userId=" + userId + ", userPictrue=" + userPictrue + ", orderNumber="
				+ orderNumber + ", tradeName=" + tradeName + ", businessName=" + businessName + ", unitPrice="
				+ unitPrice + ", number=" + number + ", state=" + state + ", hyUser=" + hyUser + "]";
	}

	
}
