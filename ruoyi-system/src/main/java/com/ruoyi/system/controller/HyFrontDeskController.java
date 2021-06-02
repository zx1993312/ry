package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.service.IHyFrontDeskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 前台收费Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/system/frontDesk")
@Api(tags = "前台收费Controller")
public class HyFrontDeskController extends BaseController {
	private String prefix = "system/frontDesk";

	@Autowired
	private IHyFrontDeskService hyFrontDeskService;

	@RequiresPermissions("system:cost:view")
	@GetMapping()
	public String cost() {
		return prefix + "/cost";
	}

	/**
	 * 查询前台收费列表
	 */
	@ApiOperation("前台收费")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cost:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyCost hyCost) {
		startPage();
		List<HyCost> list = hyFrontDeskService.selectHyCostList(hyCost);
		return getDataTable(list);
	}


	/**
	 * 导出前台收费列表
	 */
	@ApiOperation("前台收费")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cost:export")
	@Log(title = "前台收费", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyCost hyCost) {
		List<HyCost> list = hyFrontDeskService.selectHyCostList(hyCost);
		ExcelUtil<HyCost> util = new ExcelUtil<HyCost>(HyCost.class);
		return util.exportExcel(list, "cost");
	}

	/**
	 * 新增前台收费
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存前台收费
	 */
	@ApiOperation("前台收费")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cost:add")
	@Log(title = "前台收费", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyCost hyCost) {
		return toAjax(hyFrontDeskService.insertHyCost(hyCost));
	}

	/**
	 * 修改前台收费
	 */
	@ApiOperation("前台收费")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyCost hyCost = hyFrontDeskService.selectHyCostById(id);
		mmap.put("hyCost", hyCost);
		return prefix + "/edit";
	}

	/**
	 * 修改保存前台收费
	 */
	@ApiOperation("前台收费")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cost:edit")
	@Log(title = "前台收费", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyCost hyCost) {
		return toAjax(hyFrontDeskService.updateHyCost(hyCost));
	}

	/**
	 * 删除前台收费
	 */
	@ApiOperation("前台收费")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:cost:remove")
	@Log(title = "前台收费", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyFrontDeskService.deleteHyCostByIds(ids));
	}

}
