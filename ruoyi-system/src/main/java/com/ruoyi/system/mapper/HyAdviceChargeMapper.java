package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyHouseInf;

/**
 * 缴费通知Mapper接口
 * 
 * @author 
 * @date 2021-01-06
 */
public interface HyAdviceChargeMapper {

	/**
	 * 查询缴费通知列表
	 * 
	 * @param hyHouseInf 缴费通知
	 * @return 缴费通知集合
	 */
	public List<HyHouseInf> selectHyAdviceChargeList(HyHouseInf hyHouseInf);


}
