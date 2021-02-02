package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.mapper.HyCostMapper;
import com.ruoyi.system.mapper.HyHouseInfMapper;
import com.ruoyi.system.mapper.HyMeterMapper;
import com.ruoyi.system.mapper.HyOwnerRegistrationMapper;
import com.ruoyi.system.mapper.HyParkingInfMapper;
import com.ruoyi.system.service.IHyCostService;

/**
 * 费用项目Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyCostServiceImpl implements IHyCostService {
	@Autowired
	private HyCostMapper hyCostMapper;
	@Autowired
	private HyOwnerRegistrationMapper HyOwnerRegistrationMapper;
	@Autowired
	private HyHouseInfMapper HyHouseInfMapper;
	@Autowired
	private HyParkingInfMapper HyParkingInfMapper;
	@Autowired
	private HyMeterMapper HyMeterMapper;

	/**
	 * 查询费用项目
	 * 
	 * @param id 费用项目ID
	 * @return 费用项目
	 */
	@Override
	public HyCost selectHyCostById(Long id) {
		return hyCostMapper.selectHyCostById(id);
	}

	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目
	 */
	@Override
	public List<HyCost> selectHyCostList(HyCost hyCost) {
		return hyCostMapper.selectHyCostList(hyCost);
	}

	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目
	 */
	@Override
	public List<HyCost> selectHyCostListDistinct(HyCost hyCost) {
		List<HyCost> list = hyCostMapper.selectHyCostListDistinct(hyCost);
		List<HyCost> reList = new ArrayList<>();
		for (HyCost cost : list) {
			if (null == cost) {
				continue;
			}
			reList.add(cost);
		}
		return reList;
	}

	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Ztree> selectHyCostListTree(HyCost hyCost) {
		List<Ztree> ztrees = initZtree(hyCostMapper.selectHyCostList(hyCost));
		return ztrees;
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
		hyCost.getHyOwnerRegistration().setHouseNum(hyCost.getHouseNum());
		HyOwnerRegistrationMapper.insertHyOwnerRegistration(hyCost.getHyOwnerRegistration());
		HyHouseInfMapper.insertHyHouseInf(hyCost.getHyHouseInf());
		System.out.println(Constants.TIME_ALL.format(hyCost.getBilingStartDate()));
//		hyCost.setBilingStartDate();
		return hyCostMapper.insertHyCost(hyCost);
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
		return hyCostMapper.updateHyCost(hyCost);
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
		return hyCostMapper.deleteHyCostByIds(Convert.toStrArray(ids));
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
		return hyCostMapper.deleteHyCostById(id);
	}

	/**
	 * 对象转费用项目列表树
	 *
	 * @param deptList 部门列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<HyCost> hyCostList) {
		return initZtree(hyCostList, null);
	}

	/**
	 * 对象转费用项目列表树
	 *
	 * @param deptList     部门列表
	 * @param roleDeptList 角色已存在菜单列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<HyCost> hyCostList, List<String> roleDeptList) {

		List<Ztree> ztrees = new ArrayList<Ztree>();
		boolean isCheck = StringUtils.isNotNull(roleDeptList);
		for (HyCost hyCost : hyCostList) {
			if (UserConstants.DEPT_NORMAL.equals("0")) {
				Ztree ztree = new Ztree();
				ztree.setId(hyCost.getId());
				ztree.setpId(Long.valueOf(null == hyCost.getParentId() ? -1l : hyCost.getParentId()));
				ztree.setName(hyCost.getCostItems());
				ztree.setTitle(hyCost.getCostItems());
				if (isCheck) {
					ztree.setChecked(roleDeptList.contains(hyCost.getId() + hyCost.getCostItems()));
				}
				ztrees.add(ztree);
			}
		}
		return ztrees;
	}
}
