package com.ruoyi.framework.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyGroupRegistration;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.service.IHyGroupRegistrationService;
import com.ruoyi.system.service.IHyHouseInfService;

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

	@Autowired
	private IHyHouseInfService hyHouseInfService;

	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return 参数键值
	 */
	public List<?> getGroupRegistration(String group) {
		Map<String, Object> map = new HashMap<>();
		List<?> list = new ArrayList<>();
		List<Map<String, Object>> reList = new ArrayList<>();
		if (group.equals("0")) {
			list = hyGroupRegistrationService.selectHyGroupRegistrationList(new HyGroupRegistration());
		} else {
			list = hyHouseInfService.selectHyHouseInfList(new HyHouseInf());
		}

		Set<String> set = new HashSet<>();
		if (list.get(0) instanceof HyGroupRegistration) {
			for (int i = 0; i < list.size(); i++) {
				set = new HashSet<>();
				map = new HashMap<>();
				HyGroupRegistration hyGroupRegistration = (HyGroupRegistration) list.get(i);
				set.add(hyGroupRegistration.getGroupAreaName());
				map.put("data", set);
				reList.add(map);
			}
		} else if (list.get(0) instanceof HyHouseInf && group.equals("1")) {
			for (int i = 0; i < list.size(); i++) {
				set = new HashSet<>();
				map = new HashMap<>();
				HyHouseInf hyHouseInf = (HyHouseInf) list.get(i);
				set.add(hyHouseInf.getBuilding());
				map.put("data", set);
				reList.add(map);
			}
		} else if (list.get(0) instanceof HyHouseInf && group.equals("2")) {
			for (int i = 0; i < list.size(); i++) {
				set = new HashSet<>();
				map = new HashMap<>();
				HyHouseInf hyHouseInf = (HyHouseInf) list.get(i);
				set.add(hyHouseInf.getUnit());
				map.put("data", set);
				reList.add(map);
			}
		} else if (list.get(0) instanceof HyHouseInf && group.equals("3")) {
			for (int i = 0; i < list.size(); i++) {
				set = new HashSet<>();
				map = new HashMap<>();
				HyHouseInf hyHouseInf = (HyHouseInf) list.get(i);
				set.add(hyHouseInf.getFloor());
				map.put("data", set);
				reList.add(map);
			}
		}

		return reList;
	}

}
