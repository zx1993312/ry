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
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyAuditManagement;
import com.ruoyi.system.service.IHyAuditManagementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 审核管理 Controller
 * 
 * @author Administrator
 * @date 2021-01-23
 */
@Controller
@RequestMapping("/system/management")
@Api(tags = "审核管理Controller")
public class HyAuditManagementController extends BaseController {
	private String prefix = "system/management";

	@Autowired
	private IHyAuditManagementService hyAuditManagementService;

	@RequiresPermissions("system:management:view")
	@GetMapping()
	public String management() {
		return prefix + "/management";
	}

	/**
	 * 查询审核管理 列表
	 */
	@ApiOperation("审核管理")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyAuditManagement", value = "项目实体类hyAuditManagement", required = true), })
	@RequiresPermissions("system:management:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyAuditManagement hyAuditManagement) {
		startPage();
		List<HyAuditManagement> list = hyAuditManagementService.selectHyAuditManagementList(hyAuditManagement);
		return getDataTable(list);
	}

	/**
	 * 导出审核管理 列表
	 */
	@ApiOperation("审核管理")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyAuditManagement", value = "项目实体类hyAuditManagement", required = true), })
	@RequiresPermissions("system:management:export")
	@Log(title = "审核管理", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyAuditManagement hyAuditManagement) {
		List<HyAuditManagement> list = hyAuditManagementService.selectHyAuditManagementList(hyAuditManagement);
		ExcelUtil<HyAuditManagement> util = new ExcelUtil<HyAuditManagement>(HyAuditManagement.class);
		return util.exportExcel(list, "management");
	}

	/**
	 * 新增审核管理
	 * 
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存审核管理
	 * 
	 */
	@ApiOperation("审核管理")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyAuditManagement", value = "项目实体类hyAuditManagement", required = true), })
	@RequiresPermissions("system:management:add")
	@Log(title = "审核管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyAuditManagement hyAuditManagement) {
		return toAjax(hyAuditManagementService.insertHyAuditManagement(hyAuditManagement));
	}

	/**
	 * 修改审核管理
	 * 
	 */
	@ApiOperation("审核管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyAuditManagement hyAuditManagement = hyAuditManagementService.selectHyAuditManagementById(id);
		mmap.put("hyAuditManagement", hyAuditManagement);
		return prefix + "/edit";
	}

	/**
	 * 修改保存审核管理
	 * 
	 */
	@ApiOperation("审核管理")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyAuditManagement", value = "项目实体类hyAuditManagement", required = true), })
	@RequiresPermissions("system:management:edit")
	@Log(title = "审核管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyAuditManagement hyAuditManagement) {
		return toAjax(hyAuditManagementService.updateHyAuditManagement(hyAuditManagement));
	}

	/**
	 * 删除审核管理
	 * 
	 */
	@ApiOperation("审核管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:management:remove")
	@Log(title = "审核管理", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyAuditManagementService.deleteHyAuditManagementByIds(ids));
	}
}
