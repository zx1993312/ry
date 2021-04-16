package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyArea;
import com.ruoyi.system.mapper.HyAreaMapper;

/**
 * 查询所有省份
 * 
 * @author Administrator
 *
 */
@Service("area")
public class AreaService {

	@Autowired
	private HyAreaMapper hyAreaMapper;

	/**
	 * 查询所有省份方法
	 * 
	 * @return
	 */
	public List<HyArea> getProvince() {
		return hyAreaMapper.selectChinaProvince();
	}
	
	/**
	 * 查询所有市方法
	 * 
	 * @return
	 */
	public List<HyArea> getCity(Long id) {
		return hyAreaMapper.selectChinaCity(id);
	}
}
