package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyCustomer;

public interface CustomerService {

	public List<HyCustomer> selectHyCustomerList();

	public List<HyCost> selectHyCost(Long id);
}
