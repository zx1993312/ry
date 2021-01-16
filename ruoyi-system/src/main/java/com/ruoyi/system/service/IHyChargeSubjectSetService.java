package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyChargeSubjectSet;

/**
 * 收费科目设置Service接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface IHyChargeSubjectSetService {
	/**
	 * 查询收费科目设置
	 * 
	 * @param id 收费科目设置ID
	 * @return 收费科目设置
	 */
	public HyChargeSubjectSet selectHyChargeSubjectSetById(Long id);

	/**
	 * 查询收费科目设置列表
	 * 
	 * @param hyChargeSubjectSet 收费科目设置
	 * @return 收费科目设置集合
	 */
	public List<HyChargeSubjectSet> selectHyChargeSubjectSetList(HyChargeSubjectSet hyChargeSubjectSet);

	/**
	 * 新增收费科目设置
	 * 
	 * @param hyChargeSubjectSet 收费科目设置
	 * @return 结果
	 */
	public int insertHyChargeSubjectSet(HyChargeSubjectSet hyChargeSubjectSet);

	/**
	 * 修改收费科目设置
	 * 
	 * @param hyChargeSubjectSet 收费科目设置
	 * @return 结果
	 */
	public int updateHyChargeSubjectSet(HyChargeSubjectSet hyChargeSubjectSet);

	/**
	 * 批量删除收费科目设置
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteHyChargeSubjectSetByIds(String ids);

	/**
	 * 删除收费科目设置信息
	 * 
	 * @param id 收费科目设置ID
	 * @return 结果
	 */
	public int deleteHyChargeSubjectSetById(Long id);
}
