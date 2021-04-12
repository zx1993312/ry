package com.ruoyi.system.domain;

import java.util.Date;
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
    private String userPicture;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNumber;

    /** 单价 */
    @Excel(name = "单价")
    private Double unitPrice;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;
    /**订单状态*/
    @Excel(name="订单状态")
    private String state;
    /**用户表*/
    @Excel(name="用户表")
    private HyUser hyUser;
    /**产品表*/
    @Excel(name="产品表")
    private HyProduct hyProduct;
    /**图片地址*/
    @Excel(name="图片地址")
    private String fileName;
    /**创建时间*/
    @Excel(name="创建时间")
    private Date createTime;
    
    /**产品id*/
    @Excel(name="产品id")
    private Long productId;
    
    /**店铺表*/
    @Excel(name="店铺表")
    private HyShop hyShop;
    
    /**店家表*/
    @Excel(name="店家表")
    private HyBusiness hyBusiness;
    
    
    public HyShop getHyShop() {
		return hyShop;
	}

	public void setHyShop(HyShop hyShop) {
		this.hyShop = hyShop;
	}

	public HyBusiness getHyBusiness() {
		return hyBusiness;
	}

	public void setHyBusiness(HyBusiness hyBusiness) {
		this.hyBusiness = hyBusiness;
	}

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
    
   

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    
    public void setUnitPrice(Double unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public Double getUnitPrice() 
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
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public HyProduct getHyProduct() {
		return hyProduct;
	}

	public void setHyProduct(HyProduct hyProduct) {
		this.hyProduct = hyProduct;
	}

	@Override
	public String toString() {
		return "HyOrder [id=" + id + ", userId=" + userId + ", userPicture=" + userPicture + ", orderNumber="
				+ orderNumber + ", unitPrice=" + unitPrice + ", number=" + number + ", state=" + state + ", hyUser="
				+ hyUser + ", hyProduct=" + hyProduct + ", fileName=" + fileName + ", createTime=" + createTime
				+ ", productId=" + productId + ", hyShop=" + hyShop + ", hyBusiness=" + hyBusiness + "]";
	}

	



	


	

	

	
}
