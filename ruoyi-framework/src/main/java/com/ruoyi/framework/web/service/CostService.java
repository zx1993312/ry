package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.service.IHyCostService;

/**
 * 查询费用项目
 * 
 * @author Administrator
 *
 */
@Service("cost")
public class CostService {

	@Autowired
	private IHyCostService hyCostSevice;

	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return 参数键值
	 */
	public List<HyCost> getCost() {
		return hyCostSevice.selectHyCostListDistinct(new HyCost());
	}
}
