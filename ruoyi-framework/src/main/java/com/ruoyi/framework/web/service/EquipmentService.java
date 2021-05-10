package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyEquipment;
import com.ruoyi.system.mapper.HyEquipmentMapper;

@Service("equipment")
public class EquipmentService {
	
	@Autowired
	HyEquipmentMapper hyEquipmentMapper;
	
	public List<HyEquipment> getEquipment(){
		return hyEquipmentMapper.selectHyEquipmentList(new HyEquipment());
		 
	}
}
