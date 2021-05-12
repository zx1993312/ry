package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyEquipmentArchives;
import com.ruoyi.system.domain.HyMaintenanceplan;
import com.ruoyi.system.mapper.HyMaintenanceplanMapper;

@Service("plan")
public class PlanService {

	@Autowired
	HyMaintenanceplanMapper hyMaintenanceplanMapper;
	
	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */
	public List<HyMaintenanceplan> getPlan(){
		return hyMaintenanceplanMapper.selectHyMaintenanceplanList(new HyMaintenanceplan());
		
	}
}
