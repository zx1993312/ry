package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyRefund;
import com.ruoyi.system.service.IHyRefundService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 退款申请Controller
 * 
 * @author Administrator
 * @date 2021-05-29
 */
@Controller
@CrossOrigin
@RequestMapping("/system/refund")
@Api(tags = "退款申请Controller")
public class HyRefundController extends BaseController {
	private String prefix = "system/refundMoney";

	@Autowired
	private IHyRefundService hyRefundService;

	@RequiresPermissions("system:refund:view")
	@GetMapping()
	public String refund() {
		return prefix + "/refund";
	}

	/**
	 * 查询退款申请列表
	 */
	@ApiOperation("退款申请")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyRefund", value = "项目实体类hyRefund", required = true), })
	@RequiresPermissions("system:refund:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyRefund hyRefund) {
		startPage();
		List<HyRefund> list = hyRefundService.selectHyRefundList(hyRefund);
		return getDataTable(list);
	}

	/**
	 * 查询退款申请列表
	 */
	@ApiOperation("退款申请")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyRefund", value = "项目实体类hyRefund", required = true), })
	@RequiresPermissions("system:refund:list")
	@PostMapping("/listByIsExamine")
	@ResponseBody
	public TableDataInfo listByIsExamine(HyRefund hyRefund) {
		startPage();
		if (!StringUtils.isEmpty(hyRefund.getHyOwnerRegistration().getOwnerName())
				|| !StringUtils.isEmpty(hyRefund.getHyHouseInf().getHouseName())
				|| !StringUtils.isEmpty(hyRefund.getHyHouseInf().getHouseNumber())) {
			hyRefund.setIsExamine(1);
			List<HyRefund> list = hyRefundService.selectHyRefundList(hyRefund);
			return getDataTable(list);
		}
		return getDataTable(new ArrayList<HyRefund>());
	}

	/**
	 * 导出退款申请列表
	 */
	@ApiOperation("退款申请")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyRefund", value = "项目实体类hyRefund", required = true), })
	@RequiresPermissions("system:refund:export")
	@Log(title = "退款申请", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyRefund hyRefund) {
		List<HyRefund> list = hyRefundService.selectHyRefundList(hyRefund);
		ExcelUtil<HyRefund> util = new ExcelUtil<HyRefund>(HyRefund.class);
		return util.exportExcel(list, "refund");
	}

	/**
	 * 新增退款申请
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存退款申请
	 */
	@ApiOperation("退款申请")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyRefund", value = "项目实体类hyRefund", required = true), })
	@RequiresPermissions("system:refund:add")
	@Log(title = "退款申请", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyRefund hyRefund) {
		return toAjax(hyRefundService.insertHyRefund(hyRefund));
	}

	/**
	 * 修改退款申请
	 */
	@ApiOperation("退款申请")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyRefund hyRefund = hyRefundService.selectHyRefundById(id);
		mmap.put("hyRefund", hyRefund);
		return prefix + "/edit";
	}

	/**
	 * 修改保存退款申请
	 */
	@ApiOperation("退款申请")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyRefund", value = "项目实体类hyRefund", required = true), })
	@RequiresPermissions("system:refund:edit")
	@Log(title = "退款申请", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyRefund hyRefund) {
		return toAjax(hyRefundService.updateHyRefund(hyRefund));
	}
	/**
	 * 修改保存退款申请
	 * @throws Exception 
	 */
	@ApiOperation("退款申请")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyRefund", value = "项目实体类hyRefund", required = true), })
	@RequiresPermissions("system:refund:edit")
	@Log(title = "退款申请", businessType = BusinessType.UPDATE)
	@PostMapping("/edits")
	@ResponseBody
	public AjaxResult editsSave(HyRefund hyRefund,HttpServletResponse response) throws Exception {
		int result = hyRefundService.updateHyRefunds(hyRefund);
		if (result > 0) {
			exportPDF(hyRefund,response);
		}
		return toAjax(result);
	}

	/**
	 * 删除退款申请
	 */
	@ApiOperation("退款申请")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:refund:remove")
	@Log(title = "退款申请", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyRefundService.deleteHyRefundByIds(ids));
	}

	/**
	 * 导出PDF
	 */
	 @ResponseBody
	public AjaxResult exportPDF(HyRefund hyRefund,HttpServletResponse response) throws Exception
	{
		 return toAjax(hyRefundService.exportPDF(hyRefund,response));
	}
}