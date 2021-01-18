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
import com.ruoyi.system.domain.HyExemptionReason;
import com.ruoyi.system.service.IHyExemptionReasonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 减免原因设置Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/system/reason")
@Api(tags = "减免原因设置Controller")
public class HyExemptionReasonController extends BaseController {
	private String prefix = "system/reason";

	@Autowired
	private IHyExemptionReasonService hyExemptionReasonService;

	@RequiresPermissions("system:reason:view")
	@GetMapping()
	public String reason() {
		return prefix + "/reason";
	}

	/**
	 * 查询减免原因设置列表
	 */
	@ApiOperation("减免原因设置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyExemptionReason", value = "项目实体类hyExemptionReason", required = true), })
	@RequiresPermissions("system:reason:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyExemptionReason hyExemptionReason) {
		startPage();
		List<HyExemptionReason> list = hyExemptionReasonService.selectHyExemptionReasonList(hyExemptionReason);
		return getDataTable(list);
	}

	/**
	 * 导出减免原因设置列表
	 */
	@ApiOperation("减免原因设置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyExemptionReason", value = "项目实体类hyExemptionReason", required = true), })
	@RequiresPermissions("system:reason:export")
	@Log(title = "减免原因设置", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyExemptionReason hyExemptionReason) {
		List<HyExemptionReason> list = hyExemptionReasonService.selectHyExemptionReasonList(hyExemptionReason);
		ExcelUtil<HyExemptionReason> util = new ExcelUtil<HyExemptionReason>(HyExemptionReason.class);
		return util.exportExcel(list, "reason");
	}

	/**
	 * 新增减免原因设置
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存减免原因设置
	 */
	@ApiOperation("减免原因设置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyExemptionReason", value = "项目实体类hyExemptionReason", required = true), })
	@RequiresPermissions("system:reason:add")
	@Log(title = "减免原因设置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyExemptionReason hyExemptionReason) {
		return toAjax(hyExemptionReasonService.insertHyExemptionReason(hyExemptionReason));
	}

	/**
	 * 修改减免原因设置
	 */
	@ApiOperation("减免原因设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyExemptionReason hyExemptionReason = hyExemptionReasonService.selectHyExemptionReasonById(id);
		mmap.put("hyExemptionReason", hyExemptionReason);
		return prefix + "/edit";
	}

	/**
	 * 修改保存减免原因设置
	 */
	@ApiOperation("减免原因设置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyExemptionReason", value = "项目实体类hyExemptionReason", required = true), })
	@RequiresPermissions("system:reason:edit")
	@Log(title = "减免原因设置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyExemptionReason hyExemptionReason) {
		return toAjax(hyExemptionReasonService.updateHyExemptionReason(hyExemptionReason));
	}

	/**
	 * 删除减免原因设置
	 */
	@ApiOperation("减免原因设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:reason:remove")
	@Log(title = "减免原因设置", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyExemptionReasonService.deleteHyExemptionReasonByIds(ids));
	}
}
