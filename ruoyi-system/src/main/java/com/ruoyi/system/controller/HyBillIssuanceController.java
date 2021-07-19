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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyBillIssuance;
import com.ruoyi.system.service.IHyBillIssuanceService;
import com.ruoyi.system.utils.ReflectUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 票据发放Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@CrossOrigin
@RequestMapping("/system/issuance")
@Api(tags = "票据发放Controller")
public class HyBillIssuanceController extends BaseController {
	private String prefix = "system/issuance";

	@Autowired
	private IHyBillIssuanceService hyBillIssuanceService;

	@RequiresPermissions("system:issuance:view")
	@GetMapping()
	public String issuance() {
		return prefix + "/issuance";
	}

	/**
	 * 查询票据发放列表
	 */
	@ApiOperation("票据发放")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyBillIssuance", value = "项目实体类hyBillIssuance", required = true), })
	@RequiresPermissions("system:issuance:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyBillIssuance hyBillIssuance) {
		startPage();
		List<HyBillIssuance> list = hyBillIssuanceService.selectHyBillIssuanceList(hyBillIssuance);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyBillIssuance hbi : list) {
			Map<String, Object> map = new HashMap<>();
			map = ReflectUtil.convertMap(hbi);
			reList.add(map);
		}
		return getDataTable(list, reList);
	}

	/**
	 * 导出票据发放列表
	 */
	@ApiOperation("票据发放")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyBillIssuance", value = "项目实体类hyBillIssuance", required = true), })
	@RequiresPermissions("system:issuance:export")
	@Log(title = "票据发放", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyBillIssuance hyBillIssuance) {
		List<HyBillIssuance> list = hyBillIssuanceService.selectHyBillIssuanceList(hyBillIssuance);
		ExcelUtil<HyBillIssuance> util = new ExcelUtil<HyBillIssuance>(HyBillIssuance.class);
		return util.exportExcel(list, "issuance");
	}

	/**
	 * 新增票据发放
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存票据发放
	 */
	@ApiOperation("票据发放")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyBillIssuance", value = "项目实体类hyBillIssuance", required = true), })
	@RequiresPermissions("system:issuance:add")
	@Log(title = "票据发放", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyBillIssuance hyBillIssuance) {
		List<HyBillIssuance> list = hyBillIssuanceService.selectHyBillIssuanceList(hyBillIssuance);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyBillIssuance hbi : list) {
			Map<String, Object> map = new HashMap<>();
			map = ReflectUtil.convertMap(hbi);
			reList.add(map);
		}
		return toAjax(hyBillIssuanceService.insertHyBillIssuance(hyBillIssuance));
	}

	/**
	 * 修改票据发放
	 */
	@ApiOperation("票据发放")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyBillIssuance hyBillIssuance = hyBillIssuanceService.selectHyBillIssuanceById(id);
		mmap.put("hyBillIssuance", hyBillIssuance);
		List<HyBillIssuance> list = hyBillIssuanceService.selectHyBillIssuanceList(hyBillIssuance);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyBillIssuance hbi : list) {
			Map<String, Object> map = new HashMap<>();
			map = ReflectUtil.convertMap(hbi);
			reList.add(map);
		}
		return prefix + "/edit";
	}

	/**
	 * 修改保存票据发放
	 */
	@ApiOperation("票据发放")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyBillIssuance", value = "项目实体类hyBillIssuance", required = true), })
	@RequiresPermissions("system:issuance:edit")
	@Log(title = "票据发放", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyBillIssuance hyBillIssuance) {
		List<HyBillIssuance> list = hyBillIssuanceService.selectHyBillIssuanceList(hyBillIssuance);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyBillIssuance hbi : list) {
			Map<String, Object> map = new HashMap<>();
			map = ReflectUtil.convertMap(hbi);
			reList.add(map);
		}
		return toAjax(hyBillIssuanceService.updateHyBillIssuance(hyBillIssuance));
	}

	/**
	 * 删除票据发放
	 */
	@ApiOperation("票据发放")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:issuance:remove")
	@Log(title = "票据发放", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyBillIssuanceService.deleteHyBillIssuanceByIds(ids));
	}
}
