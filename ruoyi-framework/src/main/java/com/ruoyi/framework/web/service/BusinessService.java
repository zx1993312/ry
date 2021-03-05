package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyBusiness;
import com.ruoyi.system.service.IHyBusinessService;

/**
 * 
 * 查询商家
 * @author Administrator
 *
 */
@Service("business")
public class BusinessService {
	
	@Autowired
	private IHyBusinessService hyBusinessService;
	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */
	public List<HyBusiness> getBusiness(){
		return hyBusinessService.selectHyselectHyBusinessDistinct(new HyBusiness());
		
	}

}
