package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyCheckType;
import com.ruoyi.system.service.IHyCheckTypeService;

@Service("type")
public class TypeService {
	@Autowired
	private IHyCheckTypeService hyCheckTypeService;
	
	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */
	public List<HyCheckType> getType(){
		return hyCheckTypeService.selectHyCheckTypeList(new HyCheckType());
		
	}
}
