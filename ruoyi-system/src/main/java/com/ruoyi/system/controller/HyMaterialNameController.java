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
import com.ruoyi.system.domain.HyMaterial;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysDictTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 物料名称Controller
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/materialName")
@Api(tags = "物料名称Controller")
public class HyMaterialNameController extends BaseController {

	private String prefix = "system/materialName";

	@Autowired
	private ISysDictDataService dictDataService;

	@Autowired
	private ISysDictTypeService dictTypeService;

	@RequiresPermissions("system:materialName:view")
	@GetMapping()
	public String material() {
		return prefix + "/material";
	}

	/**
	 * 查询物料名称列表
	 */
	@ApiOperation("物料名称")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMaterial", value = "项目实体类hyMaterial", required = true), })
	@RequiresPermissions("system:materialName:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyMaterial hyMaterial) {
		startPage();
		List<SysDictData> list = dictTypeService.selectDictDataByType("hy_material_name");
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
	@RequiresPermissions("system:materialName:add")
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

	/**
	 * 修改保存字典类型
	 */
	@RequiresPermissions("system:materialName:edit")
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@Validated SysDictData dict) {
		dict.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(dictDataService.updateDictData(dict));
	}

	@Log(title = "服务类型", businessType = BusinessType.DELETE)
	@RequiresPermissions("system:materialName:remove")
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(dictDataService.deleteDictDataByIds(ids));
	}
}
