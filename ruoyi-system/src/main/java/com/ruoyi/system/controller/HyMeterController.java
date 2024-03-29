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
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyMeter;
import com.ruoyi.system.service.IHyMeterService;

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
@CrossOrigin
@RequestMapping("/system/meter")
@Api(tags = "抄表设置Controller")
public class HyMeterController extends BaseController {
	private String prefix = "system/meter";

	@Autowired
	private IHyMeterService hyMeterService;

	@RequiresPermissions("system:meter:view")
	@GetMapping()
	public String meter() {
		return prefix + "/meter";
	}

	/**
	 * 查询抄表设置列表
	 */
	@ApiOperation("抄表设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMeter", value = "项目实体类hyMeter", required = true), })
	@RequiresPermissions("system:meter:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyMeter hyMeter) {
		startPage();
		List<HyMeter> list = hyMeterService.selectHyMeterList(hyMeter);
		return getDataTable(list);
	}

	@RequiresPermissions("system:meter:lists")
	@PostMapping("/lists")
	@ResponseBody
	public List<HyMeter> lists(HyMeter hyMeter) {
		return hyMeterService.selectHyMeterList(hyMeter);
	}

	/**
	 * 导出抄表设置列表
	 */
	@ApiOperation("抄表设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMeter", value = "项目实体类hyMeter", required = true), })
	@RequiresPermissions("system:meter:export")
	@Log(title = "抄表设置", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyMeter hyMeter) {
		List<HyMeter> list = hyMeterService.selectHyMeterList(hyMeter);
		ExcelUtil<HyMeter> util = new ExcelUtil<HyMeter>(HyMeter.class);
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
	@RequiresPermissions("system:meter:add")
	@Log(title = "抄表设置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyMeter hyMeter) {
		return toAjax(hyMeterService.insertHyMeter(hyMeter));
	}

	/**
	 * 修改抄表设置
	 */
	@ApiOperation("抄表设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyMeter hyMeter = hyMeterService.selectHyMeterById(id);
		mmap.put("hyMeter", hyMeter);
		return prefix + "/edit";
	}

	/**
	 * 修改保存抄表设置
	 */
	@ApiOperation("抄表设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyMeter", value = "项目实体类hyMeter", required = true), })
	@RequiresPermissions("system:meter:edit")
	@Log(title = "抄表设置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyMeter hyMeter) {
		return toAjax(hyMeterService.updateHyMeter(hyMeter));
	}

	/**
	 * 删除抄设置
	 */
	@ApiOperation("抄表设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:meter:remove")
	@Log(title = "抄表设置", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyMeterService.deleteHyMeterByIds(ids));
	}

	/**
	 * 导入抄表数据
	 * 
	 * @param file
	 * @param updateSupport
	 * @return
	 * @throws Exception
	 */
	@Log(title = "用户管理", businessType = BusinessType.IMPORT)
	@RequiresPermissions("system:registration:import")
	@PostMapping("/importData")
	@ResponseBody
	public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
		ExcelUtil<HyMeter> util = new ExcelUtil<HyMeter>(HyMeter.class);
		List<HyMeter> userList = util.importExcel(file.getInputStream());
		String operName = ShiroUtils.getSysUser().getLoginName();
		String message = hyMeterService.importMeter(userList, updateSupport, operName);
		return AjaxResult.success(message);
	}

	@RequiresPermissions("system:set:view")
	@GetMapping("/importTemplate")
	@ResponseBody
	public AjaxResult importTemplate() {
		ExcelUtil<HyMeter> util = new ExcelUtil<HyMeter>(HyMeter.class);
		return util.importTemplateExcel("票据设置");
	}
}
