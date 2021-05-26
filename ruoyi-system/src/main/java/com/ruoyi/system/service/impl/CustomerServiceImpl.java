package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyCustomer;
import com.ruoyi.system.mapper.HyCostMapper;
import com.ruoyi.system.mapper.HyCustomerMapper;
import com.ruoyi.system.service.CustomerService;

/**
 * 客户标准单项设置ServiceImpl
 * 
 * @author Administrator
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private HyCustomerMapper hyCustomerMapper;

	@Autowired
	private HyCostMapper hyCostMapper;

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

	@Override
	public int updateHyCost(String houseNumber, String costItems, String expenseType, String standardName,
			String billingCycle, String calculationMehod, Integer transferTenants) {
		String houseId = houseNumber;
		String[] costs = new String[] {};

		// 截取cost id
		if (costItems.indexOf(",") > 0) {
			costs = costItems.split(",");
		}
		List<Long> list = hyCustomerMapper.selectCostId(houseId, null);

		Map<Long, Object> map = new HashMap<Long, Object>();// 用于存放costId
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i), null);
		}

		for (int i = 0; i < costs.length; i++) {
			List<Long> id = hyCustomerMapper.selectCostId(houseId, costs[i]);
			if (id == null || id.size() == 0) {
				// 插入中间表
				hyCustomerMapper.insertHouseAndCost(houseId, costs[i]);
			}
			map.remove(id.get(0));// 删除map中元素

			HyCost hyCost = new HyCost();
			hyCost.setId(Long.valueOf(costs[i]));
			hyCost.setStandardName(standardName);
			hyCost.setBillingCycle(billingCycle);
			hyCost.setCalculationMehod(calculationMehod);
			hyCost.setTransferTenants(transferTenants);
			int updateHyResult = hyCostMapper.updateHyCost(hyCost);
			if (updateHyResult <= 0) {
				return 0;
			}
		}

		// 判断map size>0删除中间表数据
		if (map.size() > 0) {
			for (Long costId : map.keySet()) {
				hyCustomerMapper.deleteHouseAndCost(costId);
			}
		}
		return 1;
	}

	@Override
	public int deleteHyCustomer(String costItems) {
		HyCost hyCost = new HyCost();
		hyCost.setCostItems(costItems);
		List<HyCost> relist = hyCostMapper.selectHyCostList(hyCost);
		return hyCustomerMapper.deleteHouseAndCost(relist.get(0).getId());
	}

}
