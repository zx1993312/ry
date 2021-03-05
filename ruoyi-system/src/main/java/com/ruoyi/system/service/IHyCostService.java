package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.system.domain.HyCost;

/**
 * 费用项目Service接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface IHyCostService {
	/**
	 * 查询费用项目
	 * 
	 * @param id 费用项目ID
	 * @return 费用项目
	 */
	public HyCost selectHyCostById(Long id);

	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目集合
	 */
	public List<HyCost> selectHyCostList(HyCost hyCost);
	
    public List<HyCost> selectHyCostListOr(HyCost hyCost);

	
	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目集合
	 */
	public List<HyCost> selectHyCostListDistinct(HyCost hyCost);

	/**
	 * 查询费用项目列表
	 * 
	 * @param hyCost 费用项目
	 * @return 费用项目集合
	 */
	public List<Ztree> selectHyCostListTree(HyCost hyCost);

	/**
	 * 新增费用项目
	 * 
	 * @param hyCost 费用项目
	 * @return 结果
	 */
	public int insertHyCost(HyCost hyCost);

	/**
	 * 修改费用项目
	 * 
	 * @param hyCost 费用项目
	 * @return 结果
	 */
	public int updateHyCost(HyCost hyCost);
	
	
	

	/**
	 * 批量删除费用项目
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyCostByIds(String ids);

	/**
	 * 删除费用项目信息
	 * 
	 * @param id 费用项目ID
	 * @return 结果
	 */
	public int deleteHyCostById(Long id);

	public int updateHyCostOther(String currentState);
}
