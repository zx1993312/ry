package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出库管理对象 hy_delivery
 * 
 * @author Administrator
 * @date 2021-04-20
 */
public class HyDelivery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出库管理id */
    private Long id;

    /** 出库编号 */
    @Excel(name = "出库编号")
    private String deliveryCode;

    /** 提料人id */
    @Excel(name = "提料人id")
    private Long liftingId;
    
    /** 提料人表 */
    @Excel(name = "提料人表")
    private HyLifting hyLifting;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeliveryCode(String deliveryCode) 
    {
        this.deliveryCode = deliveryCode;
    }

    public String getDeliveryCode() 
    {
        return deliveryCode;
    }
    public void setLiftingId(Long liftingId) 
    {
        this.liftingId = liftingId;
    }

    public Long getLiftingId() 
    {
        return liftingId;
    }

	public HyLifting getHyLifting() {
		return hyLifting;
	}

	public void setHyLifting(HyLifting hyLifting) {
		this.hyLifting = hyLifting;
	}

	@Override
	public String toString() {
		return "HyDelivery [id=" + id + ", deliveryCode=" + deliveryCode + ", liftingId=" + liftingId + ", hyLifting="
				+ hyLifting + "]";
	}


   
}
