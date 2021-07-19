package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyGroupRegistration;
import com.ruoyi.system.service.IHyGroupRegistrationService;

/**
 * 查询费用项目
 * 
 * @author Administrator
 *
 */
@Service("groupRegistration")
public class GroupRegistrationService {

	@Autowired
	private IHyGroupRegistrationService hyGroupRegistrationService;

	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return 参数键值
	 */
	public List<HyGroupRegistration> getGroupRegistration() {
			return hyGroupRegistrationService.selectHyGroupRegistrationList(new HyGroupRegistration());
}
}
