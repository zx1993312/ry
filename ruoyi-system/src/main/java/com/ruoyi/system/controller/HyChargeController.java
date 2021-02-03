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
import com.ruoyi.system.domain.HyCharge;
import com.ruoyi.system.service.IHyChargeService;
import com.ruoyi.system.service.IHyDataIsExistService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 收费比例设置Controller
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Controller
@RequestMapping("/system/charge")
@Api(tags = "航宇物业，收费比例设置controller")
public class HyChargeController extends BaseController {
	private String prefix = "system/charge";

	@Autowired
	private IHyChargeService hyChargeService;

	@Autowired
	private IHyDataIsExistService hyDataIsExistService;

	@RequiresPermissions("system:charge:view")
	@GetMapping()
	public String charge() {
		return prefix + "/charge";
	}

	/**
	 * 查询收费比例设置列表
	 */
	@RequiresPermissions("system:charge:list")
	@ApiOperation("查询收费比例设置列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCharge", value = "项目实体类", required = true), })
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyCharge hyCharge) {
		startPage();
		List<HyCharge> list = hyChargeService.selectHyChargeList(hyCharge);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyCharge hc : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hc);
			reList.add(map);
		}
		return getDataTable(list,  reList);
	}

	/**
	 * 导出收费比例设置列表
	 */
	@RequiresPermissions("system:charge:export")
	@Log(title = "收费比例设置", businessType = BusinessType.EXPORT)
	@ApiOperation("导出收费比例设置列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCharge", value = "项目实体类", required = true), })
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyCharge hyCharge) {
		List<HyCharge> list = hyChargeService.selectHyChargeList(hyCharge);
		ExcelUtil<HyCharge> util = new ExcelUtil<HyCharge>(HyCharge.class);
		return util.exportExcel(list, "charge");
	}

	/**
	 * 新增收费比例设置
	 */
	@ApiOperation("新增收费比例设置")
	@GetMapping("/add")
	public String add(HyCharge hyCharge) {
		List<HyCharge> list = hyChargeService.selectHyChargeList(hyCharge);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyCharge hc : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hc);
			reList.add(map);
		}
		return prefix + "/add";
	}

	/**
	 * 新增保存收费比例设置
	 */
	@RequiresPermissions("system:charge:add")
	@Log(title = "收费比例设置", businessType = BusinessType.INSERT)
	@ApiOperation("新增保存收费比例设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCharge", value = "项目实体类", required = true), })
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyCharge hyCharge) {

		return toAjax(hyChargeService.insertHyCharge(hyCharge));
	}

	/**
	 * 修改收费比例设置
	 */
	@ApiOperation("修改收费比例设置")
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyCharge hyCharge = hyChargeService.selectHyChargeById(id);
		mmap.put("hyCharge", hyCharge);
		List<HyCharge> list = hyChargeService.selectHyChargeList(hyCharge);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyCharge hc : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hc);
			reList.add(map);
		}
		return prefix + "/edit";
	}

	/**
	 * 修改保存收费比例设置
	 */
	@RequiresPermissions("system:charge:edit")
	@Log(title = "收费比例设置", businessType = BusinessType.UPDATE)
	@ApiOperation("修改保存收费比例设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCharge", value = "项目实体类", required = true), })
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyCharge hyCharge) {
		List<HyCharge> list = hyChargeService.selectHyChargeList(hyCharge);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyCharge hc : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hc);
			reList.add(map);
		}
		return toAjax(hyChargeService.updateHyCharge(hyCharge));
	}

	/**
	 * 删除收费比例设置
	 */
	@RequiresPermissions("system:charge:remove")
	@Log(title = "收费比例设置", businessType = BusinessType.DELETE)
	@ApiOperation("删除收费比例设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyChargeService.deleteHyChargeByIds(ids));
	}

	/**
	 * 校验房间号
	 */
	@PostMapping("/checkNumber")
	@ResponseBody
	public String checkNumber(HyCharge hyCharge) {
		Object obj = hyDataIsExistService.selectHyDataIsExist("hy_charge", "number", hyCharge.getNumber());
		if (null == obj) {
			return "0";
		}
		return "1";
	}

}
