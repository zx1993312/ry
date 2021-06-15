package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyWarehouse;
import com.ruoyi.system.mapper.HyWarehouseMapper;

@Service("warehouse")
public class WarehouseService {
	
	@Autowired
	HyWarehouseMapper hyWarehouseMapper;
	
	public List<HyWarehouse> getWarehouse(){
		return hyWarehouseMapper.selectHyWarehouseList(new HyWarehouse());
		
	}

}
