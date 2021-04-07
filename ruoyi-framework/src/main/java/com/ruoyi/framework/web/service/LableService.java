package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyLable;
import com.ruoyi.system.service.IHyLableService;

@Service("lable")
public class LableService {
	@Autowired
	private IHyLableService hyLableService;
	
	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */
	public List<HyLable> getLable(){
		return hyLableService.selectHyLableVoDistinct(new HyLable());
		 
	}
}
