package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.HyInspectionRoute;
import com.ruoyi.system.domain.HyServiceregistration;
import com.ruoyi.system.enums.FaultCategoryEnums;
import com.ruoyi.system.enums.TypeEnums;
import com.ruoyi.system.service.IHyInspectionRouteService;
import com.ruoyi.system.service.IHyServiceregistrationService;

/**
 * 设备看板Controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/system/equipmentKanban")
public class HyEquipmentKanbanController extends BaseController {
	private String prefix = "system/equipmentKanban";

	@Autowired
	private IHyServiceregistrationService hyServiceregistrationService;

	@Autowired
	private IHyInspectionRouteService hyInspectionRouteService;

	@RequiresPermissions("system:equipmentKanban:view")
	@GetMapping()
	public String equipment() {
		return prefix + "/equipment";
	}

	/**
	 * 查询设备看板列表
	 */
	@RequiresPermissions("system:equipmentKanban:getEquipmentEcharsData")
	@PostMapping("/getEquipmentEcharsData")
	@ResponseBody
	public TableDataInfo getEquipmentEcharsData(HyServiceregistration hyServiceregistration) {
		startPage();
		List<HyServiceregistration> list = hyServiceregistrationService
				.selectHyServiceregistrationList(hyServiceregistration);
		return getDataTable(getData(list));
	}

	/**
	 * 查询巡检线路列表
	 */
	@RequiresPermissions("system:equipmentKanban:getRouteEcharsData")
	@PostMapping("/getRouteEcharsData")
	@ResponseBody
	public TableDataInfo getRouteEcharsData(HyInspectionRoute hyInspectionRoute) {
		startPage();
		List<HyInspectionRoute> list = hyInspectionRouteService.selectHyInspectionRouteList(hyInspectionRoute);
		return getDataTable(getData(list));
	}

	/**
	 * 获取echars数据
	 * 
	 * @param list
	 * @return
	 */
	public List<Map<String, Object>> getData(List<?> list) {
		Set<String> set = new HashSet<>();
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> relist = new ArrayList<Map<String, Object>>();

		Object ob = new Object();
		for (Object o : list) {
			ob = o;
			if (o instanceof HyServiceregistration) {
				HyServiceregistration h = (HyServiceregistration) o;
				set.add(h.getFaultCategory());
			} else if (o instanceof HyInspectionRoute) {
				HyInspectionRoute h = (HyInspectionRoute) o;
				set.add(h.getType());
			}
		}

		if (ob instanceof HyServiceregistration) {
			for (String s : set) {
				map = new HashMap<>();// 新建map避免覆盖
				HyServiceregistration hyService = new HyServiceregistration();
				hyService.setFaultCategory(s);
				List<?> list1 = hyServiceregistrationService.selectHyServiceregistrationList(hyService);
				String value = FaultCategoryEnums.getValue(s);
				map.put("key", value);
				map.put("value", list1.size());
				relist.add(map);
			}
		} else if (ob instanceof HyInspectionRoute) {
			for (String s : set) {
				map = new HashMap<>();// 新建map避免覆盖
				HyInspectionRoute hyInspectionRoute = new HyInspectionRoute();
				hyInspectionRoute.setType(s);
				List<?> list1 = hyInspectionRouteService.selectHyInspectionRouteList(hyInspectionRoute);
				String value = TypeEnums.getValue(s);
				map.put("key", value);
				map.put("value", list1.size());
				map.put("routeName", hyInspectionRoute.getRouteName());
				relist.add(map);
			}
		}
		return relist;
	}

}
