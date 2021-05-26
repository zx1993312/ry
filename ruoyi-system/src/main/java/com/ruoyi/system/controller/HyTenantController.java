package com.ruoyi.system.controller;

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

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyTenant;
import com.ruoyi.system.domain.TenantAndHouse;
import com.ruoyi.system.mapper.TenantAndHouseMapper;
import com.ruoyi.system.service.IHyTenantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 租户资料登记Controller
 * 
 * @author Administrator
 * @date 2021-05-25
 */
@Controller
@RequestMapping("/system/tenant")
@Api(tags = "租户资料登记Controller")
public class HyTenantController extends BaseController {
	private String prefix = "system/tenant";
	
	private HyTenant hyTenant;

	@Autowired
	private IHyTenantService hyTenantService;

	@Autowired
	private TenantAndHouseMapper tenantAndHouseMapper;

	@RequiresPermissions("system:tenant:view")
	@GetMapping()
	public String tenant() {
		return prefix + "/tenant";
	}

	/**
	 * 查询租户资料登记列表
	 */
	@ApiOperation("租户资料登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyTenant", value = "项目实体类hyTenant", required = true), })
	@RequiresPermissions("system:tenant:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyTenant hyTenant) {
		startPage();
		List<HyTenant> list = hyTenantService.selectHyTenantList(hyTenant);
		return getDataTable(list);
	}

	/**
	 * 导出租户资料登记列表
	 */
	@ApiOperation("租户资料登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyTenant", value = "项目实体类hyTenant", required = true), })
	@RequiresPermissions("system:tenant:export")
	@Log(title = "租户资料登记", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyTenant hyTenant) {
		List<HyTenant> list = hyTenantService.selectHyTenantList(hyTenant);
		ExcelUtil<HyTenant> util = new ExcelUtil<HyTenant>(HyTenant.class);
		return util.exportExcel(list, "tenant");
	}

	/**
	 * 新增租户资料登记
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存租户资料登记
	 */
	@ApiOperation("租户资料登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyTenant", value = "项目实体类hyTenant", required = true), })
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyTenant hyTenant, ModelMap mmap) {
		int result = hyTenantService.insertHyTenant(hyTenant);
		if (result > 0) {
			List<HyTenant> list = hyTenantService.selectHyTenantList(hyTenant);
			hyTenant = list.get(0);
			this.hyTenant = hyTenant;
		}
		return toAjax(result);
	}

	/**
	 * 新增租户资料登记
	 */
	@GetMapping("/ad")
	public String ad(ModelMap mmap) {
		mmap.put("hyTenant", hyTenant);
		return prefix + "/ad";
	}

	/**
	 * 新增保存租户房屋关联Id
	 */
	@ApiOperation("租户资料登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "tenantAndHouse", value = "项目实体类tenantAndHouse", required = true), })
	@RequiresPermissions("system:tenant:add")
	@Log(title = "新增保存租户房屋关联Id", businessType = BusinessType.INSERT)
	@PostMapping("/ad")
	@ResponseBody
	public AjaxResult adSave(TenantAndHouse tenantAndHouse) {
		return toAjax(tenantAndHouseMapper.insertTenantAndHouse(tenantAndHouse));
	}

	/**
	 * 修改租户资料登记
	 */
	@ApiOperation("租户资料登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyTenant hyTenant = hyTenantService.selectHyTenantById(id);
		mmap.put("hyTenant", hyTenant);
		return prefix + "/edit";
	}

	/**
	 * 修改保存租户资料登记
	 */
	@ApiOperation("租户资料登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyTenant", value = "项目实体类hyTenant", required = true), })
	@RequiresPermissions("system:tenant:edit")
	@Log(title = "租户资料登记", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyTenant hyTenant) {
		return toAjax(hyTenantService.updateHyTenant(hyTenant));
	}

	/**
	 * 删除租户资料登记
	 */
	@ApiOperation("租户资料登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:tenant:remove")
	@Log(title = "租户资料登记", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyTenantService.deleteHyTenantByIds(ids));
	}
}
