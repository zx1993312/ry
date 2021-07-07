package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.service.IHyCostService;

@Controller
@CrossOrigin
@RequestMapping("/system/getCharges")
public class ChargesController extends BaseController {

	private String prefix = "system/getCharges";

	private String costItems = "";

	@Autowired
	private IHyCostService hyCostService;

	@RequiresPermissions("system:getCharges:view")
	@GetMapping()
	public String entry(@RequestParam("costItems") String costItems) {
		this.costItems = costItems;
		return prefix + "/add";
	}

	/**
	 * 查询费用项目列表
	 */
	@RequiresPermissions("system:getCharges:list")
	@RequestMapping("/list")
	@ResponseBody
	public TableDataInfo list() {
		HyCost hyCost = new HyCost() ;
		hyCost.setCostItems(costItems);
		startPage();
		List<HyCost> list = hyCostService.selectHyCostList(hyCost);
		return getDataTable(list);
	}

}
