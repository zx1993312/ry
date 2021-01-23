package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyBillSet;

/**
 * 票据设置Service接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface IHyBillSetService {
	/**
	 * 查询票据设置
	 * 
	 * @param id 票据设置ID
	 * @return 票据设置
	 */
	public HyBillSet selectHyBillSetById(Long id);

	/**
	 * 查询票据设置列表
	 * 
	 * @param hyBillSet 票据设置
	 * @return 票据设置集合
	 */
	public List<HyBillSet> selectHyBillSetList(HyBillSet hyBillSet);

	/**
	 * 查询票据设置列表
	 * 
	 * @param hyBillSet 票据设置
	 * @return 票据设置集合
	 */
	public List<HyBillSet> selectHyBillSetListByDate(HyBillSet hyBillSet);

	/**
	 * 新增票据设置
	 * 
	 * @param hyBillSet 票据设置
	 * @return 结果
	 */
	public int insertHyBillSet(HyBillSet hyBillSet);

	/**
	 * 修改票据设置
	 * 
	 * @param hyBillSet 票据设置
	 * @return 结果
	 */
	public int updateHyBillSet(HyBillSet hyBillSet);

	/**
	 * 批量删除票据设置
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyBillSetByIds(String ids);

	/**
	 * 删除票据设置信息
	 * 
	 * @param id 票据设置ID
	 * @return 结果
	 */
	public int deleteHyBillSetById(Long id);
}
