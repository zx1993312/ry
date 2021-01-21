package com.ruoyi.system.controller;

import java.math.BigDecimal;
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
import com.ruoyi.system.domain.HySelectMeter;
import com.ruoyi.system.service.IHySelectMeterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 抄表设置Controller
 * 
 * @author Administrator
 * @date 2021-01-12
 */
@Controller
@RequestMapping("/system/publicDistrictMeter")
@Api(tags = "抄表设置Controller")
public class HyPulbicDistriceMeterController extends BaseController {
	private String prefix = "system/publicDistrictMeter";

	@Autowired
	private IHySelectMeterService hySelectMeterService;

	@RequiresPermissions("system:selectMeter:view")
	@GetMapping()
	public String meter() {
		return prefix + "/meter";
	}

	/**
	 * 查询抄表设置列表
	 */
	@ApiOperation("抄表设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMeter", value = "项目实体类hyMeter", required = true), })
	@RequiresPermissions("system:selectMeter:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HySelectMeter hySelectMeter) {
		Map<String, Object> map = new HashMap<>();
		startPage();
		List<HySelectMeter> list = hySelectMeterService.selectHySelMeterList(hySelectMeter);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HySelectMeter hs : list) {
			map = Constants.REFLECT_UTIL.convertMap(hs);
			if (hs != null) {

				if (hs.getNewMeterConsumption() != null && hs.getOldMeterConsumption() != null) {

					BigDecimal newMeter = new BigDecimal(hs.getNewMeterConsumption());
					BigDecimal oldMeter = new BigDecimal(hs.getOldMeterConsumption());
					BigDecimal count = newMeter.subtract(oldMeter);
					map.put("count", count);
					reList.add(map);
				}
			}
		}
		return getDataTable(reList);
	}

	/**
	 * 导出抄表设置列表
	 */
	@ApiOperation("抄表设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMeter", value = "项目实体类hyMeter", required = true), })
	@RequiresPermissions("system:selectMeter:export")
	@Log(title = "抄表设置", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HySelectMeter hySelectMeter) {
		List<HySelectMeter> list = hySelectMeterService.selectHySelMeterList(hySelectMeter);
		ExcelUtil<HySelectMeter> util = new ExcelUtil<HySelectMeter>(HySelectMeter.class);
		return util.exportExcel(list, "meter");
	}

	/**
	 * 新增抄表设置
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存抄表设置
	 */
	@ApiOperation("抄表设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMeter", value = "项目实体类hyMeter", required = true), })
	@RequiresPermissions("system:selectMeter:add")
	@Log(title = "抄表设置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HySelectMeter hySelectMeter) {
		return toAjax(hySelectMeterService.addHySelMeter(hySelectMeter));
	}

	/**
	 * 修改抄表设置
	 */
	@ApiOperation("抄表设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HySelectMeter hySelectMeter = hySelectMeterService.selectHySelMeterById(id);
		mmap.put("hySelectMeter", hySelectMeter);
		return prefix + "/edit";
	}

	/**
	 * 修改保存抄表设置
	 */
	@ApiOperation("抄表设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMeter", value = "项目实体类hyMeter", required = true), })
	@RequiresPermissions("system:selectMeter:edit")
	@Log(title = "抄表设置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HySelectMeter hySelectMeter) {
		return toAjax(hySelectMeterService.updateHySelMeter(hySelectMeter));
	}

	/**
	 * 删除抄设置
	 */
	@ApiOperation("抄表设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:selectMeter:remove")
	@Log(title = "抄表设置", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hySelectMeterService.deleteHySelMeterByIds(ids));
	}
}
