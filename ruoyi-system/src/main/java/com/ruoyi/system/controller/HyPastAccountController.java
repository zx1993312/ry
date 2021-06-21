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
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyPastAccount;
import com.ruoyi.system.service.IHyPastAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 往期应收调账Controller
 * 
 * @author Administrator
 * @date 2021-01-07
 */
@Controller
@RequestMapping("/system/account")
@Api(tags = "往期应收调账Controller")
public class HyPastAccountController extends BaseController {
	private String prefix = "system/account";

	@Autowired
	private IHyPastAccountService hyPastAccountService;

	@RequiresPermissions("system:account:view")
	@GetMapping()
	public String account() {
		return prefix + "/account";
	}

	/**
	 * 查询往期应收调账列表
	 */
	@ApiOperation("往期应收调账")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyPastAccount", value = "项目实体类hyPastAccount", required = true), })
	@RequiresPermissions("system:account:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyPastAccount hyPastAccount) {
		startPage();
		List<HyPastAccount> list = hyPastAccountService.selectHyPastAccountList(hyPastAccount);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyPastAccount hpa : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hpa);
			reList.add(map);
		}
		return getDataTable(list,  reList);
	}

	/**
	 * 导出往期应收调账列表
	 */
	@ApiOperation("往期应收调账")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyPastAccount", value = "项目实体类hyPastAccount", required = true), })
	@RequiresPermissions("system:account:export")
	@Log(title = "往期应收调账", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyPastAccount hyPastAccount) {
		List<HyPastAccount> list = hyPastAccountService.selectHyPastAccountList(hyPastAccount);
		ExcelUtil<HyPastAccount> util = new ExcelUtil<HyPastAccount>(HyPastAccount.class);
		return util.exportExcel(list, "account");
	}

	/**
	 * 新增往期应收调账
	 */
	@GetMapping("/add")
	public String add(HyPastAccount hyPastAccount) {
		List<HyPastAccount> list = hyPastAccountService.selectHyPastAccountList(hyPastAccount);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyPastAccount hpa : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hpa);
			reList.add(map);
		}
		return prefix + "/add";
	}

	/**
	 * 新增保存往期应收调账
	 */
	@ApiOperation("往期应收调账")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyPastAccount", value = "项目实体类hyPastAccount", required = true), })
	@RequiresPermissions("system:account:add")
	@Log(title = "往期应收调账", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyPastAccount hyPastAccount) {
		return toAjax(hyPastAccountService.insertHyPastAccount(hyPastAccount));
	}

	/**
	 * 修改往期应收调账
	 */
	@ApiOperation("往期应收调账")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyPastAccount hyPastAccount = hyPastAccountService.selectHyPastAccountById(id);
		mmap.put("hyPastAccount", hyPastAccount);
		List<HyPastAccount> list = hyPastAccountService.selectHyPastAccountList(hyPastAccount);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyPastAccount hpa : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hpa);
			reList.add(map);
		}
		return prefix + "/edit";
	}

	/**
	 * 修改保存往期应收调账
	 */
	@ApiOperation("往期应收调账")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyPastAccount", value = "项目实体类hyPastAccount", required = true), })
	@RequiresPermissions("system:account:edit")
	@Log(title = "往期应收调账", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyPastAccount hyPastAccount) {
		List<HyPastAccount> list = hyPastAccountService.selectHyPastAccountList(hyPastAccount);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyPastAccount hpa : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hpa);
			reList.add(map);
		}
		return toAjax(hyPastAccountService.updateHyPastAccount(hyPastAccount));
	}

	/**
	 * 删除往期应收调账
	 */
	@ApiOperation("往期应收调账")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:account:remove")
	@Log(title = "往期应收调账", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyPastAccountService.deleteHyPastAccountByIds(ids));
	}
	
	/**
	 * 导入应收调账数据
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
		ExcelUtil<HyPastAccount> util = new ExcelUtil<HyPastAccount>(HyPastAccount.class);
		List<HyPastAccount> userList = util.importExcel(file.getInputStream());
		String operName = ShiroUtils.getSysUser().getLoginName();
		String message = hyPastAccountService.importCost(userList, updateSupport, operName);
		return AjaxResult.success(message);
	}
	@RequiresPermissions("system:set:view")
	 @GetMapping("/importTemplate")
	 @ResponseBody
	 public AjaxResult importTemplate() {
	  ExcelUtil<HyPastAccount> util = new ExcelUtil<HyPastAccount>(HyPastAccount.class);
	  return util.importTemplateExcel("应收调账");
	 }
}
