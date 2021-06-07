package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.HyEquipment;
import com.ruoyi.system.service.IHyEquipmentService;

import io.swagger.annotations.Api;
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
	private IHyEquipmentService hyEquipmentService;

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
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyEquipment hyEquipment) {
		startPage();
		List<HyEquipment> list = hyEquipmentService.selectHyEquipmentList(hyEquipment);
		return getDataTable(list);
	}
}
