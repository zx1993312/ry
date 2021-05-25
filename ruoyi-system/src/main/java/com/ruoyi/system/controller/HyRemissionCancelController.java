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
import com.ruoyi.system.domain.HyFeeRemission;
import com.ruoyi.system.service.IHyFeeRemissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 费用减免撤销Controller
 * 
 * @author Administrator
 * @date 2021-01-13
 */
@Controller
@RequestMapping("/system/remissionCancel")
@Api(tags = "费用减免撤销Controller")
public class HyRemissionCancelController extends BaseController {
	private String prefix = "system/remissionCancel";

	@Autowired
	private IHyFeeRemissionService hyFeeRemissionService;

	@RequiresPermissions("system:remission:view")
	@GetMapping()
	public String remission() {
		return prefix + "/remission";
	}

	/**
	 * 查询费用减免列表
	 */
	@ApiOperation("费用减免")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyFeeRemission", value = "项目实体类hyFeeRemission", required = true), })
	@RequiresPermissions("system:remission:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyFeeRemission hyFeeRemission) {
		startPage();
		List<HyFeeRemission> list = hyFeeRemissionService.selectHyFeeRemissionList(hyFeeRemission);
		return getDataTable(list);
	}

	/**
	 * 导出费用减免列表
	 */
	@ApiOperation("费用减免")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyFeeRemission", value = "项目实体类hyFeeRemission", required = true), })
	@RequiresPermissions("system:remission:export")
	@Log(title = "费用减免", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyFeeRemission hyFeeRemission) {
		List<HyFeeRemission> list = hyFeeRemissionService.selectHyFeeRemissionList(hyFeeRemission);
		ExcelUtil<HyFeeRemission> util = new ExcelUtil<HyFeeRemission>(HyFeeRemission.class);
		return util.exportExcel(list, "remission");
	}

	/**
	 * 新增费用减免
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存费用减免
	 */
	@ApiOperation("费用减免")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyFeeRemission", value = "项目实体类hyFeeRemission", required = true), })
	@RequiresPermissions("system:remission:add")
	@Log(title = "费用减免", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyFeeRemission hyFeeRemission) {
		return toAjax(hyFeeRemissionService.insertHyFeeRemission(hyFeeRemission));
	}

	/**
	 * 修改费用减免
	 */
	@ApiOperation("费用减免")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyFeeRemission hyFeeRemission = hyFeeRemissionService.selectHyFeeRemissionById(id);
		mmap.put("hyFeeRemission", hyFeeRemission);
		return prefix + "/edit";
	}

	/**
	 * 修改保存费用减免
	 */
	@ApiOperation("费用减免")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyFeeRemission", value = "项目实体类hyFeeRemission", required = true), })
	@RequiresPermissions("system:remission:edit")
	@Log(title = "费用减免", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyFeeRemission hyFeeRemission) {
		return toAjax(hyFeeRemissionService.updateHyFeeRemission(hyFeeRemission));
	}

	/**
	 * 删除费用减免
	 */
	@ApiOperation("费用减免")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:remission:remove")
	@Log(title = "费用减免", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyFeeRemissionService.deleteHyFeeRemissionByIds(ids));
	}
}
