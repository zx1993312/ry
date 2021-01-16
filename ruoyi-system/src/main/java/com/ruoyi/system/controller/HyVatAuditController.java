package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyVatAudit;
import com.ruoyi.system.service.IHyVatAuditService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 增值税率审核Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/system/audit")
@Api(tags = "增值税率审核Controller")
public class HyVatAuditController extends BaseController {
	private String prefix = "system/audit";

	@Autowired
	private IHyVatAuditService hyVatAuditService;

	@RequiresPermissions("system:audit:view")
	@GetMapping()
	public String audit() {
		return prefix + "/audit";
	}

	/**
	 * 查询增值税率审核列表
	 */
	@ApiOperation("增值税率审核")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyVatAudit", value = "项目实体类hyVatAudit", required = true), })
	@RequiresPermissions("system:audit:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyVatAudit hyVatAudit) {
		startPage();
		List<HyVatAudit> list = hyVatAuditService.selectHyVatAuditList(hyVatAudit);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyVatAudit hva : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hva);
			reList.add(map);
		}

		return getDataTable(reList);
	}

	/**
	 * 导出增值税率审核列表
	 */
	@ApiOperation("增值税率审核")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyVatAudit", value = "项目实体类hyVatAudit", required = true), })
	@RequiresPermissions("system:audit:export")
	@Log(title = "增值税率审核", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyVatAudit hyVatAudit) {
		List<HyVatAudit> list = hyVatAuditService.selectHyVatAuditList(hyVatAudit);
		ExcelUtil<HyVatAudit> util = new ExcelUtil<HyVatAudit>(HyVatAudit.class);
		return util.exportExcel(list, "audit");
	}

	/**
	 * 新增增值税率审核
	 */
	@GetMapping("/add")
	public String add(HyVatAudit hyVatAudit) {
		List<HyVatAudit> list = hyVatAuditService.selectHyVatAuditList(hyVatAudit);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyVatAudit hva : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hva);
			reList.add(map);
		}
		return prefix + "/add";
	}

	/**
	 * 新增保存增值税率审核
	 */
	@ApiOperation("增值税率审核")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyVatAudit", value = "项目实体类hyVatAudit", required = true), })
	@RequiresPermissions("system:audit:add")
	@Log(title = "增值税率审核", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyVatAudit hyVatAudit) {
		return toAjax(hyVatAuditService.insertHyVatAudit(hyVatAudit));
	}

	/**
	 * 修改增值税率审核
	 */
	@ApiOperation("增值税率审核")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyVatAudit hyVatAudit = hyVatAuditService.selectHyVatAuditById(id);
		System.out.println(hyVatAudit.getEstateRecord());
		mmap.put("hyVatAudit", hyVatAudit);
		return prefix + "/edit";
	}

	/**
	 * 修改保存增值税率审核
	 */
	@ApiOperation("增值税率审核")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyVatAudit", value = "项目实体类hyVatAudit", required = true), })
	@RequiresPermissions("system:audit:edit")
	@Log(title = "增值税率审核", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyVatAudit hyVatAudit) {
		List<HyVatAudit> list = hyVatAuditService.selectHyVatAuditList(hyVatAudit);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyVatAudit hva : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hva);
			reList.add(map);
		}
		return toAjax(hyVatAuditService.updateHyVatAudit(hyVatAudit));
	}

	/**
	 * 删除增值税率审核
	 */
	@ApiOperation("增值税率审核")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:audit:remove")
	@Log(title = "增值税率审核", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyVatAuditService.deleteHyVatAuditByIds(ids));
	}
}
