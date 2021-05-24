package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class OwnerAndCost extends BaseEntity
{

	private static final long serialVersionUID = 1L;
	
	/**  业主id */
    private Long ownerId;
    
    /**  费用项目id */
    private Long costId;

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getCostId() {
		return costId;
	}

	public void setCostId(Long costId) {
		this.costId = costId;
	}

	@Override
	public String toString() {
		return "OwnerAndCost [ownerId=" + ownerId + ", costId=" + costId + "]";
	}
    
    
}
