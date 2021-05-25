package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyBuilding;
import com.ruoyi.system.mapper.HyBuildingMapper;

/**
 * 查询楼宇信息
 * 
 * @author Administrator
 *
 */
@Service("building")
public class BuildingService {

	@Autowired
	HyBuildingMapper hyBuildingMapper;

	public List<HyBuilding> getBuilding() {
		return hyBuildingMapper.selectHyBuildingList(new HyBuilding());

	}
}
