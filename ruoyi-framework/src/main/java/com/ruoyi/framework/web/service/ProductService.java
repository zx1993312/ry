package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyProduct;
import com.ruoyi.system.service.IHyProductService;

@Service("product")
public class ProductService {
	
	@Autowired
	private IHyProductService hyProductService;
	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */

	public List<HyProduct> getProduct(){
		return hyProductService.selectHyProductList(new HyProduct());
		
	}

}
