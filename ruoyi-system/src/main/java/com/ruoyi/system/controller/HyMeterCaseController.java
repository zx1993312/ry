package com.ruoyi.system.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
import com.ruoyi.system.domain.HyMeter;
import com.ruoyi.system.domain.HyMeterCase;
import com.ruoyi.system.domain.MeterAndCase;
import com.ruoyi.system.service.IHyMeterCaseService;
import com.ruoyi.system.service.IHyMeterService;
import com.ruoyi.system.utils.HyDataUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 表箱 Controller
 * 
 * @author Administrator
 * @date 2021-01-12
 */
@Controller
@CrossOrigin
@RequestMapping("/system/case")
@Api(tags = "表箱Controller")
public class HyMeterCaseController extends BaseController {
	private String prefix = "system/case";

	@Autowired
	private IHyMeterCaseService hyMeterCaseService;

	@Autowired
	private IHyMeterService hyMeterService;

	@RequiresPermissions("system:case:view")
	@GetMapping()
	public String cases() {
		return prefix + "/case";
	}

	/**
	 * 查询箱 列表
	 */
	@ApiOperation("表箱")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMeterCase", value = "项目实体类hyMeterCase", required = true), })
	@RequiresPermissions("system:case:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyMeterCase hyMeterCase) {
		startPage();
		List<HyMeterCase> list = hyMeterCaseService.selectHyMeterCaseList(hyMeterCase);
		return getDataTable(list);
	}

	/**
	 * 导出箱 列表
	 */
	@ApiOperation("表箱")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMeterCase", value = "项目实体类hyMeterCase", required = true), })
	@RequiresPermissions("system:case:export")
	@Log(title = "表箱", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyMeterCase hyMeterCase) {
		List<HyMeterCase> list = hyMeterCaseService.selectHyMeterCaseList(hyMeterCase);
		ExcelUtil<HyMeterCase> util = new ExcelUtil<HyMeterCase>(HyMeterCase.class);
		return util.exportExcel(list, "case");
	}

	/**
	 * 新增表箱
	 * 
	 */
	@GetMapping("/add")
	public String add(MeterAndCase meterAndCase) {
		return prefix + "/add";
	}

	/**
	 * 新增保存表箱
	 * 
	 */
	@ApiOperation("表箱")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMeterCase", value = "项目实体类hyMeterCase", required = true), })
	@RequiresPermissions("system:case:add")
	@Log(title = "表箱", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MeterAndCase meterAndCase) {
		return toAjax(hyMeterCaseService.insertHyMeterCase(meterAndCase));
	}

	/**
	 * 修改箱
	 * 
	 */
	@ApiOperation("表箱")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, @Param("houseNum") String houseNum,
			@Param("meterType") String meterType, @Param("meterSerialNum") String meterSerialNum,
			@Param("meterName") String meterName, @Param("initialRead") String initialRead,
			@Param("transfRatio") String transfRatio, @Param("reverseNot") String reverseNot,
			@Param("strappingType") String strappingType, @Param("hyMeterCase") String hyMeterCase, ModelMap mmap) {

		HyMeter hyMeter = (HyMeter) HyDataUtil.setData(HyMeter.class, houseNum, meterType, meterSerialNum, meterName,
				initialRead, transfRatio, reverseNot, strappingType, hyMeterCase);
		hyMeter.setId(id);
		hyMeterService.updateHyMeter(hyMeter);
		HyMeterCase rehyMeterCase = hyMeterCaseService.selectHyMeterCaseById(id);
		mmap.put("hyMeterCase", rehyMeterCase);
		return prefix + "/edit";
	}

	/**
	 * 修改保存表箱
	 * 
	 */
	@ApiOperation("表箱")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMeterCase", value = "项目实体类hyMeterCase", required = true), })
	@RequiresPermissions("system:case:edit")
	@Log(title = "表箱", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyMeterCase hyMeterCase) {
		return toAjax(hyMeterCaseService.updateHyMeterCase(hyMeterCase));
	}

	/**
	 * 删除表箱
	 * 
	 */
	@ApiOperation("表箱")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:case:remove")
	@Log(title = "表箱", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyMeterCaseService.deleteHyMeterCaseByIds(ids));
	}
}
