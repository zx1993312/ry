package com.ruoyi.system.controller;

import java.util.List;

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
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.service.IHyGenerationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 账单生成Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@CrossOrigin
@RequestMapping("/system/generation")
@Api(tags = "账单生成Controller")
public class HyGenerationController extends BaseController {
	private String prefix = "system/generation";

	@Autowired
	private IHyGenerationService hyGenerationService;
	
	@RequiresPermissions("system:generation:view")
	@GetMapping()
	public String generation() {
		return prefix + "/generation";
	}

	/**
	 * 查询账单生成列表
	 */
	@ApiOperation("账单生成")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyHouseInf", value = "项目实体类hyHouseInf", required = true), })
	@RequiresPermissions("system:generation:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyHouseInf hyHouseInf) {
		startPage();
		List<HyHouseInf> list = hyGenerationService.selectHyGenerationList(hyHouseInf);
		return getDataTable(list);
	}


	/**
	 * 导出账单生成列表
	 */
	@ApiOperation("账单生成")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyHouseInf", value = "项目实体类hyHouseInf", required = true), })
	@RequiresPermissions("system:generation:export")
	@Log(title = "账单生成", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyHouseInf hyHouseInf) {
		List<HyHouseInf> list = hyGenerationService.selectHyGenerationList(hyHouseInf);
		ExcelUtil<HyHouseInf> util = new ExcelUtil<HyHouseInf>(HyHouseInf.class);
		return util.exportExcel(list, "inf");
	}

	/**
	 * 新增账单生成
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存账单生成
	 */
	@ApiOperation("账单生成")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyHouseInf", value = "项目实体类hyHouseInf", required = true), })
	@RequiresPermissions("system:generation:add")
	@Log(title = "账单生成", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyHouseInf hyHouseInf) {
		return toAjax(hyGenerationService.insertHyGeneration(hyHouseInf));
	}

	/**
	 * 修改账单生成
	 */
	@ApiOperation("账单生成")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyHouseInf hyHouseInf = hyGenerationService.selectHyGenerationById(id);
		mmap.put("hyHouseInf", hyHouseInf);
		return prefix + "/edit";
	}

	/**
	 * 修改保存账单生成
	 */
	@ApiOperation("账单生成")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyHouseInf", value = "项目实体类hyHouseInf", required = true), })
	@RequiresPermissions("system:generation:edit")
	@Log(title = "账单生成", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyHouseInf hyHouseInf) {
		return toAjax(hyGenerationService.updateHyGeneration(hyHouseInf));
	}
}
