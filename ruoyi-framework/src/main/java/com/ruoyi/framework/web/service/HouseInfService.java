package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.mapper.HyHouseInfMapper;

@Service("houseInf")
public class HouseInfService {
	
	@Autowired
	HyHouseInfMapper hyHouseInfMapper;
	
	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */
	public List<HyHouseInf> getHouseInf(){
		return hyHouseInfMapper.selectHyHouseInfList(new HyHouseInf());
		
	}
	
	public List<HyHouseInf> getUnit(){
		return hyHouseInfMapper.selectHyHouseInfListDistinct(new HyHouseInf());
		
	}
	
	public List<HyHouseInf> getHouseNumber(){
		return hyHouseInfMapper.selectHyHouseInfVoDistinctByhouseNumber(new HyHouseInf());
		
	}
}
