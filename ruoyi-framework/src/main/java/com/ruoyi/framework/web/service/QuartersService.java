package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyResidentialQuarters;
import com.ruoyi.system.domain.HyShop;
import com.ruoyi.system.mapper.HyResidentialQuartersMapper;

@Service("quarters")
public class QuartersService {
	
	@Autowired
	HyResidentialQuartersMapper hyResidentialQuartersMapper;
	
	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */
	public List<HyResidentialQuarters> getQuarters(){
		return hyResidentialQuartersMapper.selectHyResidentialQuartersList(new HyResidentialQuarters());
		
	}
}
