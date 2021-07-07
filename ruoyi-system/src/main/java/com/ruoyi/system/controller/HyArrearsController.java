package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.service.IHyCostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 欠收费用查询Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@CrossOrigin
@RequestMapping("/system/arrears")
@Api(tags = "欠收费用查询Controller")
public class HyArrearsController extends BaseController {
	private String prefix = "system/arrears";

	@Autowired
	private IHyCostService hyCostService;

	@RequiresPermissions("system:arrears:view")
	@GetMapping()
	public String cost() {
		return prefix + "/arrears";
	}

	/**
	 * 欠收费用查询列表
	 */
	@ApiOperation("欠收费用查询")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:arrears:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyCost hyCost) {
		startPage();
		List<HyCost> list = hyCostService.selectHyCostList(hyCost);
		return getDataTable(list);
	}
}
