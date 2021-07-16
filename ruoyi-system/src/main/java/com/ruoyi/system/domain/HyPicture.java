package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图片对象 hy_picture
 * 
 * @author Administrator
 * @date 2021-03-08
 */
public class HyPicture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片id */
    private Long id;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String pictureAddress;

    /** 产品id */
    @Excel(name = "产品id")
    private Long productId;
    
    /** 产品表 */
    @Excel(name = "产品表")
    private HyProduct hyProduct;
    
    

    public HyProduct getHyProduct() {
		return hyProduct;
	}

	public void setHyProduct(HyProduct hyProduct) {
		this.hyProduct = hyProduct;
	}

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPictureAddress(String pictureAddress) 
    {
        this.pictureAddress = pictureAddress;
    }

    public String getPictureAddress() 
    {
        return pictureAddress;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

	@Override
	public String toString() {
		return "HyPicture [id=" + id + ", pictureAddress=" + pictureAddress + ", productId=" + productId
				+ ", hyProduct=" + hyProduct + "]";
	}

	

  
}
