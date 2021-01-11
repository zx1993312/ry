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
import com.ruoyi.system.domain.HyParkingInf;
import com.ruoyi.system.service.IHyParkingInfService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车位资料 Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller 
@RequestMapping("/system/parking")
@Api(tags = "车位资料 Controller")
public class HyParkingInfController extends BaseController {
	private String prefix = "system/parking";

	@Autowired
	private IHyParkingInfService hyParkingInfService;

	@RequiresPermissions("system:parking:view")
	@GetMapping()
	public String inf() {
		return prefix + "/parking";
	}

	/**
	 * 查询车位资料 列表
	 */
	@ApiOperation("车位资料")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyParkingInf", value = "项目实体类hyParkingInf", required = true), })
	@RequiresPermissions("system:parking:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyParkingInf hyParkingInf) {
		startPage();
		List<HyParkingInf> list = hyParkingInfService.selectHyParkingInfList(hyParkingInf);
		List<Map<String , Object>>reList=new ArrayList<>();
		for (HyParkingInf hpi:list) {
			Map<String,Object> map=new HashMap<>();
			map=Constants.REFLECT_UTIL.convertMap(hpi);
			reList.add(map);
		}
		return getDataTable(reList);
	}

	/**
	 * 导出车位资料 列表
	 */
	@ApiOperation("车位资料")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyParkingInf", value = "项目实体类hyParkingInf", required = true), })
	@RequiresPermissions("system:parking:export")
	@Log(title = "车位资料", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyParkingInf hyParkingInf) {
		List<HyParkingInf> list = hyParkingInfService.selectHyParkingInfList(hyParkingInf);
		ExcelUtil<HyParkingInf> util = new ExcelUtil<HyParkingInf>(HyParkingInf.class);
		return util.exportExcel(list, "parking");
	}

	/**
	 * 新增车位资料
	 * 
	 */
	@GetMapping("/add")
	public String add(HyParkingInf hyParkingInf) {
		
		List<HyParkingInf> list = hyParkingInfService.selectHyParkingInfList(hyParkingInf);
		List<Map<String , Object>>reList=new ArrayList<>();
		for (HyParkingInf hpi:list) {
			Map<String,Object> map=new HashMap<>();
			map=Constants.REFLECT_UTIL.convertMap(hpi);
			reList.add(map);
		}
		return prefix + "/add";
	}

	/**
	 * 新增保存车位资料
	 * 
	 */
	@ApiOperation("车位资料")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyParkingInf", value = "项目实体类hyParkingInf", required = true), })
	@RequiresPermissions("system:parking:add")
	@Log(title = "车位资料", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyParkingInf hyParkingInf) {
		return toAjax(hyParkingInfService.insertHyParkingInf(hyParkingInf));
	}

	/**
	 * 修改车位资料
	 * 
	 */
	@ApiOperation("车位资料")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyParkingInf hyParkingInf = hyParkingInfService.selectHyParkingInfById(id);
		mmap.put("hyParkingInf", hyParkingInf);
		List<HyParkingInf> list = hyParkingInfService.selectHyParkingInfList(hyParkingInf);
		List<Map<String , Object>>reList=new ArrayList<>();
		for (HyParkingInf hpi:list) {
			Map<String,Object> map=new HashMap<>();
			map=Constants.REFLECT_UTIL.convertMap(hpi);
			reList.add(map);
		}
		return prefix + "/edit";
	}

	/**
	 * 修改保存车位资料
	 * 
	 */
	@ApiOperation("车位资料")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyParkingInf", value = "项目实体类hyParkingInf", required = true), })
	@RequiresPermissions("system:parking:edit")
	@Log(title = "车位资料", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyParkingInf hyParkingInf) {
		List<HyParkingInf> list = hyParkingInfService.selectHyParkingInfList(hyParkingInf);
		List<Map<String , Object>>reList=new ArrayList<>();
		for (HyParkingInf hpi:list) {
			Map<String,Object> map=new HashMap<>();
			map=Constants.REFLECT_UTIL.convertMap(hpi);
			reList.add(map);
		}
		return toAjax(hyParkingInfService.updateHyParkingInf(hyParkingInf));
	}

	/**
	 * 删除车位资料
	 * 
	 */
	@ApiOperation("车位资料")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:parking:remove")
	@Log(title = "车位资料", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyParkingInfService.deleteHyParkingInfByIds(ids));
	}
}
