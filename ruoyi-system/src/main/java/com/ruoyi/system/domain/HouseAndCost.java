package com.ruoyi.system.domain;

import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

public class HouseAndCost extends BaseEntity
{

	private static final long serialVersionUID = 1L;
	
	/**  房屋id */
    private Long houseId;
    
    /**  费用项目id */
    private Long costId;
    
    /**  费用起始时间 */
    private String beginFeeDate;
    
    /**  费用结束时间 */
    private String payFeeDate;
    
    /**  费用期间 */
    private String feeDate;
    
    /**  打折 */
    private BigDecimal discount;


	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public Long getCostId() {
		return costId;
	}

	public void setCostId(Long costId) {
		this.costId = costId;
	}

	public String getPayFeeDate() {
		return payFeeDate;
	}

	public void setPayFeeDate(String payFeeDate) {
		this.payFeeDate = payFeeDate;
	}

	public String getBeginFeeDate() {
		return beginFeeDate;
	}

	public void setBeginFeeDate(String beginFeeDate) {
		this.beginFeeDate = beginFeeDate;
	}

	public String getFeeDate() {
		return feeDate;
	}

	public void setFeeDate(String feeDate) {
		this.feeDate = feeDate;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "HouseAndCost [houseId=" + houseId + ", costId=" + costId + ", beginFeeDate=" + beginFeeDate
				+ ", payFeeDate=" + payFeeDate + ", feeDate=" + feeDate + ", discount=" + discount + "]";
	}



	

	

    
    
}
