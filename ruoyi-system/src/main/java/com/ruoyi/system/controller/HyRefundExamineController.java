package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
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
@RequestMapping("/system/refundExamine")
@Api(tags = "退款审核Controller")
public class HyRefundExamineController extends BaseController {

	private String prefix = "system/refundExamine";

	@Autowired
	private IHyRefundService hyRefundService;

	@RequiresPermissions("system:refundExamine:view")
	@GetMapping()
	public String refund() {
		return prefix + "/refundExamine";
	}

	/**
	 * 查询退款申请列表
	 */
	@ApiOperation("退款申请")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyRefund", value = "项目实体类hyRefund", required = true), })
	@RequiresPermissions("system:refundExamine:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyRefund hyRefund) {
		startPage();
		hyRefund.setIsExamine(0);
		List<HyRefund> list = hyRefundService.selectHyRefundList(hyRefund);
		return getDataTable(list);
	}

	/**
	 * 修改退款审核
	 */
	@ApiOperation("退款审核")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyPaymentOffset", value = "退款审核实体类hyRefund", required = true), })
	@RequiresPermissions("system:offset:edit")
	@Log(title = "退款审核", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyRefund hyRefund) {
		hyRefund.setIsExamine(1);
		return toAjax(hyRefundService.updateHyRefund(hyRefund));
	}

}
