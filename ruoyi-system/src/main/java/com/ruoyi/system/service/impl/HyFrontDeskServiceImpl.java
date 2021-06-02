package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.OwnerAndCost;
import com.ruoyi.system.mapper.HyFrontDeskMapper;
import com.ruoyi.system.mapper.OwnerAndCostMapper;
import com.ruoyi.system.service.IHyFrontDeskService;

/**
 * 费用项目Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyFrontDeskServiceImpl implements IHyFrontDeskService {
	@Autowired
	private HyFrontDeskMapper hyFrontDeskMapper;

	@Autowired
	private OwnerAndCostMapper ownerAndCostMapper;

	/**
	 * 查询费用项目
	 * 
	 * @param id 费用项目ID
	 * @return 费用项目
	 */
	@Override
	public HyCost selectHyCostById(Long id) {
		return hyFrontDeskMapper.selectHyCostById(id);
	}

	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目
	 */
	@Override
	public List<HyCost> selectHyCostList(HyCost hyCost) {
		return hyFrontDeskMapper.selectHyCostList(hyCost);
	}



	/**
	 * 新增费用项目
	 * 
	 * @param hyCost 费用项目
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertHyCost(HyCost hyCost) {
		OwnerAndCost ownerAndCost = new OwnerAndCost();
		Long ownerId = hyCost.getOwnerAndCost().getOwnerId();
		String a = hyFrontDeskMapper.selectNextValue("hy_database", "hy_cost");
		Long costId = Long.valueOf(a);
		ownerAndCost.setCostId(costId);
		ownerAndCost.setOwnerId(ownerId);
		ownerAndCostMapper.insertOwnerAndCost(ownerAndCost);
		return hyFrontDeskMapper.insertHyCost(hyCost);
	}

	/**
	 * 修改费用项目
	 * 
	 * @param hyCost 费用项目
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateHyCost(HyCost hyCost) {
		Long ownerId = hyCost.getOwnerAndCost().getOwnerId();
		Long costId = hyCost.getId();
		OwnerAndCost ownerAndCost = new OwnerAndCost();
		ownerAndCost.setOwnerId(ownerId);
		ownerAndCost.setCostId(costId);
		ownerAndCostMapper.updateOwnerAndCost(ownerAndCost);
		return hyFrontDeskMapper.updateHyCost(hyCost);
	}


	/**
	 * 删除费用项目对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyCostByIds(String ids) {
		return hyFrontDeskMapper.deleteHyCostByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除费用项目信息
	 * 
	 * @param id 费用项目ID
	 * @return 结果
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteHyCostById(Long id) {
		return hyFrontDeskMapper.deleteHyCostById(id);
	}

}
