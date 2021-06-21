package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.service.IHyHouseInfService;
import com.ruoyi.system.service.IHyOwnerRegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 房屋登记Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/system/inf")
@Api(tags = "房屋登记Controller")
public class HyHouseInfController extends BaseController {
	private String prefix = "system/inf";

	@Autowired
	private IHyHouseInfService hyHouseInfService;
	
	@Autowired
	private IHyOwnerRegistrationService hyOwnerRegistrationService;

	@RequiresPermissions("system:inf:view")
	@GetMapping()
	public String inf() {
		return prefix + "/inf";
	}

	/**
	 * 查询房屋登记列表
	 */
	@ApiOperation("房屋登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyHouseInf", value = "项目实体类hyHouseInf", required = true), })
	@RequiresPermissions("system:inf:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyHouseInf hyHouseInf) {
		startPage();
		List<HyHouseInf> list = hyHouseInfService.selectHyHouseInfList(hyHouseInf);
		return getDataTable(list);
	}

	@RequiresPermissions("system:inf:lists")
	@PostMapping("/lists")
	@ResponseBody
	public List<HyHouseInf> lists(HyHouseInf hyHouseInf) {
		return hyHouseInfService.selectHyHouseInfList(hyHouseInf);
	}
	
	@RequiresPermissions("system:inf:lists")
	@PostMapping("/owner")
	@ResponseBody
	public List<HyOwnerRegistration> ownerList(HyHouseInf hyHouseInf) {
		List<HyOwnerRegistration> relist = new ArrayList<HyOwnerRegistration>();
		List<HyHouseInf> hyHouseInfList = hyHouseInfService.selectHyHouseInfList(hyHouseInf);
		for (HyHouseInf list : hyHouseInfList) {
			HyOwnerRegistration hyOwnerRegistration = hyOwnerRegistrationService.selectHyOwnerRegistrationById(list.getOwnerId());
			relist.add(hyOwnerRegistration);
		}
		return relist;
	}

	/**
	 * 导出房屋登记列表
	 */
	@ApiOperation("房屋登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyHouseInf", value = "项目实体类hyHouseInf", required = true), })
	@RequiresPermissions("system:inf:export")
	@Log(title = "房屋登记", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyHouseInf hyHouseInf) {
		List<HyHouseInf> list = hyHouseInfService.selectHyHouseInfList(hyHouseInf);
		ExcelUtil<HyHouseInf> util = new ExcelUtil<HyHouseInf>(HyHouseInf.class);
		return util.exportExcel(list, "inf");
	}

	/**
	 * 新增房屋登记
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存房屋登记
	 */
	@ApiOperation("房屋登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyHouseInf", value = "项目实体类hyHouseInf", required = true), })
	@RequiresPermissions("system:inf:add")
	@Log(title = "房屋登记", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyHouseInf hyHouseInf) {
		return toAjax(hyHouseInfService.insertHyHouseInf(hyHouseInf));
	}

	/**
	 * 修改房屋登记
	 */
	@ApiOperation("房屋登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyHouseInf hyHouseInf = hyHouseInfService.selectHyHouseInfById(id);
		mmap.put("hyHouseInf", hyHouseInf);
		return prefix + "/edit";
	}

	/**
	 * 修改保存房屋登记
	 */
	@ApiOperation("房屋登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyHouseInf", value = "项目实体类hyHouseInf", required = true), })
	@RequiresPermissions("system:inf:edit")
	@Log(title = "房屋登记", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyHouseInf hyHouseInf) {
		return toAjax(hyHouseInfService.updateHyHouseInf(hyHouseInf));
	}

	/**
	 * 删除房屋登记
	 */
	@ApiOperation("房屋登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:inf:remove")
	@Log(title = "房屋登记", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyHouseInfService.deleteHyHouseInfByIds(ids));
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
	@RequiresPermissions("ystem:inf:import")
	@PostMapping("/importData")
	@ResponseBody
	public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
		ExcelUtil<HyHouseInf> util = new ExcelUtil<HyHouseInf>(HyHouseInf.class);
		List<HyHouseInf> userList = util.importExcel(file.getInputStream());
		String operName = ShiroUtils.getSysUser().getLoginName();
		String message = hyHouseInfService.importHouseInf(userList, updateSupport, operName);
		return AjaxResult.success(message);
	}

	@RequiresPermissions("system:inf:view")
	@GetMapping("/importTemplate")
	@ResponseBody
	public AjaxResult importTemplate() {
		ExcelUtil<HyHouseInf> util = new ExcelUtil<HyHouseInf>(HyHouseInf.class);
		return util.importTemplateExcel("房屋登记");
	}
}
