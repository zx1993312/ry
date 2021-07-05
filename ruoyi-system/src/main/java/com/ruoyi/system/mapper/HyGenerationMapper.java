package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyHouseInf;

/**
 * 账单生成Mapper接口
 * 
 * @author liutianqi
 * @date 2021-01-06
 */
public interface HyGenerationMapper {
	/**
	 * 查询账单生成
	 * 
	 * @param id 账单生成ID
	 * @return 账单生成
	 */
	public HyHouseInf selectHyGenerationById(Long id);

	/**
	 * 查询账单生成列表
	 * 
	 * @param hyHouseInf 账单生成
	 * @return 账单生成集合
	 */
	public List<HyHouseInf> selectHyGenerationList(HyHouseInf hyHouseInf);
	
	/**
	 * 新增账单生成
	 * 
	 * @param hyHouseInf 账单生成
	 * @return 结果
	 */
	public int insertHyGeneration(HyHouseInf hyHouseInf);

	/**
	 * 修改账单生成
	 * 
	 * @param hyHouseInf 账单生成
	 * @return 结果
	 */
	public int updateHyGeneration(HyHouseInf hyHouseInf);

}
