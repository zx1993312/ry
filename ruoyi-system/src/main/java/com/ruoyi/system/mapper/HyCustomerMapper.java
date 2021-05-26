package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyCustomer;

public interface HyCustomerMapper {

	public List<HyCustomer> selectHyCustomerList();

	public List<HyCost> selectCost(Long id);
	
	public List<HyCost> selectCostList(Long id);

}
