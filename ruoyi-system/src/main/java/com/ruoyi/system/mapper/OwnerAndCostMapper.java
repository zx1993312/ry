package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.OwnerAndCost;

public interface OwnerAndCostMapper {
	
	public List<OwnerAndCost> selectOwnerAndCostList(OwnerAndCost ownerAndCost);
	
	public int insertOwnerAndCost(OwnerAndCost ownerAndCost);
	
	public int updateOwnerAndCost(OwnerAndCost ownerAndCost);

}
