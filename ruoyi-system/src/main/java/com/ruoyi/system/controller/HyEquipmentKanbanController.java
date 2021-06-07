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
import com.ruoyi.system.domain.HyServiceregistration;
import com.ruoyi.system.enums.FaultCategoryEnums;
import com.ruoyi.system.service.IHyServiceregistrationService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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

	@RequiresPermissions("system:equipmentKanban:view")
	@GetMapping()
	public String equipment() {
		return prefix + "/equipment";
	}

	/**
	 * 查询设备看板列表
	 */
	@ApiOperation("设备类别")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyEquipment", value = "项目实体类hyEquipment", required = true), })
	@RequiresPermissions("system:equipmentKanban:list")
	@PostMapping("/getEcharsData")
	@ResponseBody
	public TableDataInfo list(HyServiceregistration hyServiceregistration) {
		startPage();
		List<HyServiceregistration> list = hyServiceregistrationService
				.selectHyServiceregistrationList(hyServiceregistration);
		return getDataTable(getData(list));
	}

	/**
	 * 获取echars数据
	 * 
	 * @param list
	 * @return
	 */
	public List<Map<String, Object>> getData(List<HyServiceregistration> list) {
		Set<String> set = new HashSet<>();
		for (HyServiceregistration h : list) {
			set.add(h.getFaultCategory());
		}

		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> relist = new ArrayList<Map<String, Object>>();
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
		return relist;
	}
}
