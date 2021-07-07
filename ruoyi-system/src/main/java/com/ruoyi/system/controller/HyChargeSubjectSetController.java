package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyChargeSubjectSet;
import com.ruoyi.system.service.IHyChargeSubjectSetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收费科目设置Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@CrossOrigin
@RequestMapping("/system/subject")
@Api(tags = "收费科目设置Controller")
public class HyChargeSubjectSetController extends BaseController {
	private String prefix = "system/subject";

	@Autowired
	private IHyChargeSubjectSetService hyChargeSubjectSetService;

	@RequiresPermissions("system:subject:view")
	@GetMapping()
	public String set() {
		return prefix + "/subject";
	}

	/**
	 * 查询收费科目设置列表
	 */
	@ApiOperation("收费科目设置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyChargeSubjectSet", value = "项目实体类hyChargeSubjectSet", required = true), })
	@RequiresPermissions("system:subject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyChargeSubjectSet hyChargeSubjectSet) {
		startPage();
		List<HyChargeSubjectSet> list = hyChargeSubjectSetService.selectHyChargeSubjectSetList(hyChargeSubjectSet);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyChargeSubjectSet hcs : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hcs);
			reList.add(map);
		}
		return getDataTable(list,  reList);
	}

	/**
	 * 导出收费科目设置列表
	 */
	@ApiOperation("收费科目设置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyChargeSubjectSet", value = "项目实体类hyChargeSubjectSet", required = true), })
	@RequiresPermissions("system:subject:export")
	@Log(title = "收费科目设置", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyChargeSubjectSet hyChargeSubjectSet) {
		List<HyChargeSubjectSet> list = hyChargeSubjectSetService.selectHyChargeSubjectSetList(hyChargeSubjectSet);
		ExcelUtil<HyChargeSubjectSet> util = new ExcelUtil<HyChargeSubjectSet>(HyChargeSubjectSet.class);
		return util.exportExcel(list, "subject");
	}

	/**
	 * 新增收费科目设置
	 */
	@GetMapping("/add")
	public String add(HyChargeSubjectSet hyChargeSubjectSet) {
		List<HyChargeSubjectSet> list = hyChargeSubjectSetService.selectHyChargeSubjectSetList(hyChargeSubjectSet);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyChargeSubjectSet hcs : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hcs);
			reList.add(map);
		}
		return prefix + "/add";
	}

	/**
	 * 新增保存收费科目设置
	 */
	@ApiOperation("收费科目设置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyChargeSubjectSet", value = "项目实体类hyChargeSubjectSet", required = true), })
	@RequiresPermissions("system:subject:add")
	@Log(title = "收费科目设置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyChargeSubjectSet hyChargeSubjectSet) {
		return toAjax(hyChargeSubjectSetService.insertHyChargeSubjectSet(hyChargeSubjectSet));
	}

	/**
	 * 修改收费科目设置
	 */
	@ApiOperation("收费科目设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyChargeSubjectSet hyChargeSubjectSet = hyChargeSubjectSetService.selectHyChargeSubjectSetById(id);
		mmap.put("hyChargeSubjectSet", hyChargeSubjectSet);
		List<HyChargeSubjectSet> list = hyChargeSubjectSetService.selectHyChargeSubjectSetList(hyChargeSubjectSet);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyChargeSubjectSet hcs : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hcs);
			reList.add(map);
		}

		return prefix + "/edit";
	}

	/**
	 * 修改保存收费科目设置
	 */
	@ApiOperation("收费科目设置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyChargeSubjectSet", value = "项目实体类hyChargeSubjectSet", required = true), })
	@RequiresPermissions("system:subject:edit")
	@Log(title = "收费科目设置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyChargeSubjectSet hyChargeSubjectSet) {
		List<HyChargeSubjectSet> list = hyChargeSubjectSetService.selectHyChargeSubjectSetList(hyChargeSubjectSet);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyChargeSubjectSet hcs : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hcs);
			reList.add(map);
		}
		return toAjax(hyChargeSubjectSetService.updateHyChargeSubjectSet(hyChargeSubjectSet));
	}

	/**
	 * 删除收费科目设置
	 */
	@ApiOperation("收费科目设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:subject:remove")
	@Log(title = "收费科目设置", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyChargeSubjectSetService.deleteHyChargeSubjectSetByIds(ids));
	}
}
