package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyCustomer;

/**
 * 客户标准单项设置Service
 * 
 * @author Administrator
 *
 */
public interface CustomerService {

	/**
	 * 查询客户标准单项设置
	 * 
	 * @return
	 */
	public List<HyCustomer> selectHyCustomerList();

	/**
	 * 根据id查询HyCost
	 * 
	 * @param id
	 * @return
	 */
	public List<HyCost> selectHyCost(Long id);

	/**
	 * 根据id查询CostList
	 * 
	 * @param id
	 * @return
	 */
	public List<HyCost> selectCostList(Long id);

	/**
	 * 客户标准单项修改
	 * 
	 * @param houseNumber
	 * @param costItems
	 * @param expenseType
	 * @param standardName
	 * @param billingCycle
	 * @param calculationMehod
	 * @param transferTenants
	 * @return
	 */
	public int updateHyCost(String houseNumber, String costItems, String expenseType, String standardName,
			String billingCycle, String calculationMehod, Integer transferTenants);

	/**
	 * 删除中间表数据
	 * 
	 * @param ids
	 * @return
	 */
	public int deleteHyCustomer(String costItems);
}
