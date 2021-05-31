package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class HouseAndCost extends BaseEntity
{

	private static final long serialVersionUID = 1L;
	
	/**  房屋id */
    private Long houseId;
    
    /**  费用项目id */
    private Long costId;


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

	@Override
	public String toString() {
		return "HouseAndCost [houseId=" + houseId + ", costId=" + costId + "]";
	}

    
    
}
