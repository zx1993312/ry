package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyGroupRegistration;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.service.IHyGroupRegistrationService;
import com.ruoyi.system.service.IHyHouseInfService;

@Controller
@RequestMapping("/system/group")
public class HyGroupController extends BaseController {

	@Autowired
	private IHyGroupRegistrationService hyGroupRegistrationService;

	@Autowired
	private IHyHouseInfService hyHouseInfService;

	@Log(title = "获取下拉选数据", businessType = BusinessType.UPDATE)
	@GetMapping("/getGroupData")
	@ResponseBody
	public List<?> editSave(String currentState) {
		Map<String, Object> map = new HashMap<>();
		List<?> list = new ArrayList<>();
		List<Map<String, Object>> reList = new ArrayList<>();
		if (currentState.equals("0")) {
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
		} else if (list.get(0) instanceof HyHouseInf && currentState.equals("1")) {
			for (int i = 0; i < list.size(); i++) {
				set = new HashSet<>();
				map = new HashMap<>();
				HyHouseInf hyHouseInf = (HyHouseInf) list.get(i);
				set.add(hyHouseInf.getHyBuilding().getBuildingName());
				map.put("data", set);
				reList.add(map);
			}
		} else if (list.get(0) instanceof HyHouseInf && currentState.equals("2")) {
			for (int i = 0; i < list.size(); i++) {
				set = new HashSet<>();
				map = new HashMap<>();
				HyHouseInf hyHouseInf = (HyHouseInf) list.get(i);
				set.add(hyHouseInf.getUnit());
				map.put("data", set);
				reList.add(map);
			}
		} else if (list.get(0) instanceof HyHouseInf && currentState.equals("3")) {
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
