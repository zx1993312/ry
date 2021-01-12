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
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.service.IHyCostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 费用项目Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/system/cost")
@Api(tags = "费用项目Controller")
public class HyCostController extends BaseController {
	private String prefix = "system/cost";

	@Autowired
	private IHyCostService hyCostService;

	@RequiresPermissions("system:cost:view")
	@GetMapping()
	public String cost() {
		return prefix + "/cost";
	}

	/**
	 * 查询费用项目列表
	 */
	@ApiOperation("费用项目")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cost:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyCost hyCost) {
		startPage();
		List<HyCost> list = hyCostService.selectHyCostList(hyCost);
		return getDataTable(list);
	}

	/**
	 * 加载部门列表树
	 */
	@ApiOperation("费用项目")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cost:costList")
	@GetMapping("/costList")
	@ResponseBody
	public List<Ztree> treeData() {
		List<Ztree> hyCost = hyCostService.selectHyCostListTree(new HyCost());
		return hyCost;
	}

	/**
	 * 导出费用项目列表
	 */
	@ApiOperation("费用项目")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cost:export")
	@Log(title = "费用项目", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyCost hyCost) {
		List<HyCost> list = hyCostService.selectHyCostList(hyCost);
		ExcelUtil<HyCost> util = new ExcelUtil<HyCost>(HyCost.class);
		return util.exportExcel(list, "cost");
	}

	/**
	 * 新增费用项目
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存费用项目
	 */
	@ApiOperation("费用项目")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cost:add")
	@Log(title = "费用项目", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyCost hyCost) {
		return toAjax(hyCostService.insertHyCost(hyCost));
	}

	/**
	 * 修改费用项目
	 */
	@ApiOperation("费用项目")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyCost hyCost = hyCostService.selectHyCostById(id);
		mmap.put("hyCost", hyCost);
		return prefix + "/edit";
	}

	/**
	 * 修改保存费用项目
	 */
	@ApiOperation("费用项目")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cost:edit")
	@Log(title = "费用项目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyCost hyCost) {
		return toAjax(hyCostService.updateHyCost(hyCost));
	}

	/**
	 * 删除费用项目
	 */
	@ApiOperation("费用项目")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:cost:remove")
	@Log(title = "费用项目", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyCostService.deleteHyCostByIds(ids));
	}
}
