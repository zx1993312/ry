package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.HyArea;

/**
 * 地区表service
 * 
 * @author Administrator
 *
 */
public interface IAreaService {

	/**
	 * 查询地区表方法省份
	 * 
	 * @return
	 */
	public List<HyArea> selectChinaProvinceData();

	/**
	 * 查询地区表方法市
	 * 
	 * @return
	 */
	public List<HyArea> selectChinaCityData(Long parentid);
}
