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
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.service.IHyOwnerRegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 业主资料登记Controller
 * 
 * @author Administrator
 * @date 2021-01-09
 */
@Controller
@CrossOrigin
@RequestMapping("/system/registration")
@Api(tags = "业主资料登记Controller")
public class HyOwnerRegistrationController extends BaseController {
	private String prefix = "system/registration";

	@Autowired
	private IHyOwnerRegistrationService hyOwnerRegistrationService;

	@RequiresPermissions("system:registration:view")
	@GetMapping()
	public String registration() {
		return prefix + "/registration";
	}

	/**
	 * 查询业主资料登记列表
	 */
	@ApiOperation("业主资料登记")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyOwnerRegistration", value = "项目实体类hyOwnerRegistration", required = true), })
	@RequiresPermissions("system:registration:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyOwnerRegistration hyOwnerRegistration) {
		startPage();
		List<HyOwnerRegistration> list = hyOwnerRegistrationService.selectHyOwnerRegistrationList(hyOwnerRegistration);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyOwnerRegistration hor : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hor);
			reList.add(map);
		}
		return getDataTable(list, reList);
	}

	@RequiresPermissions("system:registration:list")
	@PostMapping("/lists")
	@ResponseBody
	public List<HyOwnerRegistration> lists(HyOwnerRegistration hyOwnerRegistration) {
		return hyOwnerRegistrationService.selectHyOwnerRegistrationList(hyOwnerRegistration);
	}

	/**
	 * 导出业主资料登记列表
	 */
	@ApiOperation("业主资料登记")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyOwnerRegistration", value = "项目实体类hyOwnerRegistration", required = true), })
	@RequiresPermissions("system:registration:export")
	@Log(title = "业主资料登记", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyOwnerRegistration hyOwnerRegistration) {
		List<HyOwnerRegistration> list = hyOwnerRegistrationService.selectHyOwnerRegistrationList(hyOwnerRegistration);
		ExcelUtil<HyOwnerRegistration> util = new ExcelUtil<HyOwnerRegistration>(HyOwnerRegistration.class);
		return util.exportExcel(list, "registration");
	}

	/**
	 * 新增业主资料登记
	 */
	@GetMapping("/add")
	public String add(HyOwnerRegistration hyOwnerRegistration) {
		List<HyOwnerRegistration> list = hyOwnerRegistrationService.selectHyOwnerRegistrationList(hyOwnerRegistration);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyOwnerRegistration hor : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hor);
			reList.add(map);
		}
		return prefix + "/add";
	}

	/**
	 * 新增保存业主资料登记
	 */
	@ApiOperation("业主资料登记")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyOwnerRegistration", value = "项目实体类hyOwnerRegistration", required = true), })
	@RequiresPermissions("system:registration:add")
	@Log(title = "业主资料登记", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyOwnerRegistration hyOwnerRegistration) {
		List<HyOwnerRegistration> list = hyOwnerRegistrationService.selectHyOwnerRegistrationList(hyOwnerRegistration);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyOwnerRegistration hor : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hor);
			reList.add(map);
		}
		return toAjax(hyOwnerRegistrationService.insertHyOwnerRegistration(hyOwnerRegistration));
	}

	/**
	 * 修改业主资料登记
	 */
	@ApiOperation("业主资料登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyOwnerRegistration hyOwnerRegistration = hyOwnerRegistrationService.selectHyOwnerRegistrationById(id);
		mmap.put("hyOwnerRegistration", hyOwnerRegistration);
		List<HyOwnerRegistration> list = hyOwnerRegistrationService.selectHyOwnerRegistrationList(hyOwnerRegistration);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyOwnerRegistration hor : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hor);
			reList.add(map);
		}
		return prefix + "/edit";
	}

	/**
	 * 修改保存业主资料登记
	 */
	@ApiOperation("业主资料登记")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyOwnerRegistration", value = "项目实体类hyOwnerRegistration", required = true), })
	@RequiresPermissions("system:registration:edit")
	@Log(title = "业主资料登记", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyOwnerRegistration hyOwnerRegistration) {
		List<HyOwnerRegistration> list = hyOwnerRegistrationService.selectHyOwnerRegistrationList(hyOwnerRegistration);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyOwnerRegistration hor : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hor);
			reList.add(map);
		}
		return toAjax(hyOwnerRegistrationService.updateHyOwnerRegistration(hyOwnerRegistration));
	}

	/**
	 * 删除业主资料登记
	 */
	@ApiOperation("业主资料登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:registration:remove")
	@Log(title = "业主资料登记", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyOwnerRegistrationService.deleteHyOwnerRegistrationByIds(ids));
	}

	/**
	 * 导入房屋数据
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
		ExcelUtil<HyOwnerRegistration> util = new ExcelUtil<HyOwnerRegistration>(HyOwnerRegistration.class);
		List<HyOwnerRegistration> userList = util.importExcel(file.getInputStream());
		String operName = ShiroUtils.getSysUser().getLoginName();
		String message = hyOwnerRegistrationService.importOwnerRegistration(userList, updateSupport, operName);
		return AjaxResult.success(message);
	}

	@RequiresPermissions("system:set:view")
	@GetMapping("/importTemplate")
	@ResponseBody
	public AjaxResult importTemplate() {
		ExcelUtil<HyOwnerRegistration> util = new ExcelUtil<HyOwnerRegistration>(HyOwnerRegistration.class);
		return util.importTemplateExcel("业主资料登记");
	}
}
