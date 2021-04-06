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
    private String pcitureAddress;

    /** 产品id */
    @Excel(name = "产品id")
    private Long productId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPcitureAddress(String pcitureAddress) 
    {
        this.pcitureAddress = pcitureAddress;
    }

    public String getPcitureAddress() 
    {
        return pcitureAddress;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

  
}
