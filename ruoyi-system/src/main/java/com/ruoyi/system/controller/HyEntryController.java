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
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyEntry;
import com.ruoyi.system.service.IHyEntryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 入账处理Controller
 * 
 * @author Administrator
 * @date 2021-01-23
 */
@Controller
@RequestMapping("/system/entry")
@Api(tags = "入账处理Controller")
public class HyEntryController extends BaseController {
	private String prefix = "system/entry";

	@Autowired
	private IHyEntryService hyEntryService;

	@RequiresPermissions("system:entry:view")
	@GetMapping()
	public String entry() {
		return prefix + "/entry";
	}

	/**
	 * 查询入账处理列表
	 */
	@ApiOperation("入账处理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyEntry", value = "项目实体类hyEntry", required = true), })
	@RequiresPermissions("system:entry:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyEntry hyEntry) {
		startPage();
		List<HyEntry> list = hyEntryService.selectHyEntryList(hyEntry);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyEntry he : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(he);
			reList.add(map);
		}
		return getDataTable(list,  reList);
	}

	/**
	 * 导出入账处理列表
	 */
	@ApiOperation("入账处理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyEntry", value = "项目实体类hyEntry", required = true), })
	@RequiresPermissions("system:entry:export")
	@Log(title = "入账处理", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyEntry hyEntry) {
		List<HyEntry> list = hyEntryService.selectHyEntryList(hyEntry);
		ExcelUtil<HyEntry> util = new ExcelUtil<HyEntry>(HyEntry.class);
		return util.exportExcel(list, "entry");
	}

	/**
	 * 新增入账处理
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存入账处理
	 */
	@ApiOperation("入账处理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyEntry", value = "项目实体类hyEntry", required = true), })
	@RequiresPermissions("system:entry:add")
	@Log(title = "入账处理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyEntry hyEntry) {
		return toAjax(hyEntryService.insertHyEntry(hyEntry));
	}

	/**
	 * 修改入账处理
	 */
	@ApiOperation("入账处理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyEntry hyEntry = hyEntryService.selectHyEntryById(id);
		mmap.put("hyEntry", hyEntry);
		return prefix + "/edit";
	}

	/**
	 * 修改保存入账处理
	 */
	@ApiOperation("入账处理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyEntry", value = "项目实体类hyEntry", required = true), })
	@RequiresPermissions("system:entry:edit")
	@Log(title = "入账处理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyEntry hyEntry) {
		return toAjax(hyEntryService.updateHyEntry(hyEntry));
	}

	/**
	 * 删除入账处理
	 */
	@ApiOperation("入账处理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:entry:remove")
	@Log(title = "入账处理", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyEntryService.deleteHyEntryByIds(ids));
	}
}
