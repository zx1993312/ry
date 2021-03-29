package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.service.ISystemHouseInfStateService;

@Controller
@RequestMapping("/system/houseInfState")
public class HyHouseInfStateController extends BaseController {

	private String prefix = "system/houseInfState";

	@Autowired
	private ISystemHouseInfStateService houseInfStateService;

	@RequiresPermissions("system:dict:view")
	@GetMapping()
	public String dicData() {
		return prefix + "/product";

	}

	@PostMapping("/list")
	@RequiresPermissions("system:dict:list")
	@ResponseBody
	public TableDataInfo list(SysDictData dictData) {
		startPage();
		List<SysDictData> list = houseInfStateService.selectDictDataListOr(dictData);
		return getDataTable(list);
	}

	@Log(title = "字典数据", businessType = BusinessType.EXPORT)
	@RequiresPermissions("system:dict:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SysDictData dictData) {
		List<SysDictData> list = houseInfStateService.selectDictDataListOr(dictData);
		ExcelUtil<SysDictData> util = new ExcelUtil<SysDictData>(SysDictData.class);
		return util.exportExcel(list, "字典数据");
	}

	@GetMapping("/add")
	public String add(ModelMap mmap) {
		return prefix + "/add";
	}

	@Log(title = "字典数据", businessType = BusinessType.INSERT)
	@RequiresPermissions("system:dict:add")
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SysDictData dict) {
		dict.setCreateBy(ShiroUtils.getLoginName());
		return toAjax(houseInfStateService.insertDictData(dict));
	}

	@GetMapping("/edit/{dictCode}")
	public String edit(@PathVariable("dictCode") Long dictCode, ModelMap mmap) {
		return prefix + "/edit";
	}

	@Log(title = "字典数据", businessType = BusinessType.UPDATE)
	@RequiresPermissions("system:dict:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@Validated SysDictData dict) {
		dict.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(houseInfStateService.updateDictData(dict));
	}
	
	@Log(title="字典数据",businessType=BusinessType.DELETE)
	@RequiresPermissions("system:dict:remove")
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(houseInfStateService.deleteDictDataByIds(ids));
	}
	

}
