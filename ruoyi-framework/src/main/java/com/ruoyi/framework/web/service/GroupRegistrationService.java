package com.ruoyi.framework.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		StringBuffer sb = new StringBuffer();

		if (list.get(0) instanceof HyGroupRegistration) {// 查询组团区域
			for (int i = 0; i < list.size(); i++) {
				sb.setLength(0);
				map = new HashMap<>();
				HyGroupRegistration hyGroupRegistration = (HyGroupRegistration) list.get(i);
				String groupAreaName = hyGroupRegistration.getGroupAreaName();
				if (null == groupAreaName || groupAreaName.equals("")) {
					continue;
				}
				sb.append(groupAreaName);
				map.put("data", sb.toString());
				reList.add(map);
			}
		} else if (list.get(0) instanceof HyHouseInf && group.equals("1")) {// 查询楼宇
			for (int i = 0; i < list.size(); i++) {
				sb.setLength(0);
				map = new HashMap<>();
				HyHouseInf hyHouseInf = (HyHouseInf) list.get(i);
				String building = hyHouseInf.getBuilding();
				if (null == building || building.equals("")) {
					continue;
				}
				sb.append(building);
				map.put("data", sb.toString());
				reList.add(map);
			}
		} else if (list.get(0) instanceof HyHouseInf && group.equals("2")) {// 查询单元
			for (int i = 0; i < list.size(); i++) {
				sb.setLength(0);
				map = new HashMap<>();
				HyHouseInf hyHouseInf = (HyHouseInf) list.get(i);
				String unit = hyHouseInf.getUnit();
				if (null == unit || unit.equals("")) {
					continue;
				}
				sb.append(unit);
				map.put("data", sb.toString());
				reList.add(map);
			}
		} else if (list.get(0) instanceof HyHouseInf && group.equals("3")) {// 查询楼层
			for (int i = 0; i < list.size(); i++) {
				sb.setLength(0);
				map = new HashMap<>();
				HyHouseInf hyHouseInf = (HyHouseInf) list.get(i);
				String floor = hyHouseInf.getFloor();
				if (null == floor || floor.equals("")) {
					continue;
				}
				sb.append(floor);
				map.put("data", sb);
				reList.add(map);
			}
		}

		return reList;
	}

}
