package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.ruoyi.system.domain.HyProjectSel;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysDictTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 服务类型Controller
 * 
 * @author Administrator
 * @date 2021-03-06
 */
@Controller
@CrossOrigin
@RequestMapping("/system/serviceType")
@Api(tags = "服务类型Controller")
public class HyServiceTypeController extends BaseController {

	private String prefix = "system/serviceType";

	@Autowired
	private ISysDictDataService dictDataService;

	@Autowired
	private ISysDictTypeService dictTypeService;

	@RequiresPermissions("system:serviceType:view")
	@GetMapping()
	public String serviceType() {
		return prefix + "/serviceType";
	}

	/**
	 * 查询服务类型列表
	 */
	@ApiOperation("服务类型")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyProjectSel", value = "服务类型hyProjectSel", required = true), })
	@RequiresPermissions("system:serviceType:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyProjectSel hyProjectSel) {
		startPage();
		List<SysDictData> list = dictTypeService.selectDictDataByType("hy_serve_type");
		return getDataTable(list);
	}

	/**
	 * 新增字典类型
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存字典类型
	 */
	@Log(title = "服务类型", businessType = BusinessType.INSERT)
	@RequiresPermissions("system:serviceType:add")
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@Validated SysDictData dict) {
		dict.setCreateBy(ShiroUtils.getLoginName());
		return toAjax(dictDataService.insertDictData(dict));
	}

	/**
	 * 修改字典类型
	 */
	@GetMapping("/edit/{dictCode}")
	public String edit(@PathVariable("dictCode") Long dictCode, ModelMap mmap) {
		mmap.put("dict", dictDataService.selectDictDataById(dictCode));
		return prefix + "/edit";
	}

	@Log(title = "服务类型", businessType = BusinessType.DELETE)
	@RequiresPermissions("system:serviceType:remove")
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(dictDataService.deleteDictDataByIds(ids));
	}
}
