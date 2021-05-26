package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class TenantAndHouse extends BaseEntity
{
	 private static final long serialVersionUID = 1L;
	 
 	/** 租户Id */
    @Excel(name = "租户Id")
    private Long tenantId;
	    
    /** 房屋Id */
    @Excel(name = "房屋Id")
    private Long houseId;

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	@Override
	public String toString() {
		return "TenantAndHouse [tenantId=" + tenantId + ", houseId=" + houseId + "]";
	}
    
    

}
