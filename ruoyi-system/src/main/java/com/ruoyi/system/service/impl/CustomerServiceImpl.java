package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyCustomer;
import com.ruoyi.system.mapper.HyCustomerMapper;
import com.ruoyi.system.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private HyCustomerMapper hyCustomerMapper;

	@Override
	public List<HyCustomer> selectHyCustomerList() {
		return hyCustomerMapper.selectHyCustomerList();
	}

	@Override
	public List<HyCost> selectHyCost(Long id) {
		return hyCustomerMapper.selectCost(id);
	}

	@Override
	public List<HyCost> selectCostList(Long id) {
		return hyCustomerMapper.selectCostList(id);
	}
	
	

}
