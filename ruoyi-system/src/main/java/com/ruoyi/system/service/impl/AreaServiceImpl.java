package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyArea;
import com.ruoyi.system.mapper.HyAreaMapper;
import com.ruoyi.system.service.IAreaService;

/**
 * 地区service实现类
 * 
 * @author Administrator
 *
 */
@Service
public class AreaServiceImpl implements IAreaService {

	@Autowired
	private HyAreaMapper hyAreaMapper;

	@Override
	public List<HyArea> selectChinaProvinceData() {
		return hyAreaMapper.selectChinaProvince();
	}

	@Override
	public List<HyArea> selectChinaCityData(Long parentid) {
		return hyAreaMapper.selectChinaCity(parentid);
	}

}
