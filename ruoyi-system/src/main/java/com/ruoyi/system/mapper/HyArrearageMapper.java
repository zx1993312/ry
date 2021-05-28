package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyHouseInf;

/**
 * 欠费通知Mapper接口
 * 
 * @author 
 * @date 2021-01-06
 */
public interface HyArrearageMapper {

	/**
	 * 查询欠费通知列表
	 * 
	 * @param hyHouseInf 欠费通知
	 * @return 欠费通知集合
	 */
	public List<HyHouseInf> selectHyArrearageList(HyHouseInf hyHouseInf);


}
