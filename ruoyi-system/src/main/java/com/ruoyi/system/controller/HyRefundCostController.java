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

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.HyRefund;
import com.ruoyi.system.service.IHyRefundService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 退款费用查询Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@CrossOrigin
@RequestMapping("/system/refundCost")
@Api(tags = "退款费用查询Controller")
public class HyRefundCostController extends BaseController {

	private String prefix = "system/refundCost";

	@Autowired
	private IHyRefundService hyRefundService;

	@RequiresPermissions("system:refund:view")
	@GetMapping()
	public String refund() {
		return prefix + "/refundCost";
	}

	/**
	 * 查询退款申请列表
	 */
	@ApiOperation("退款费用查询")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyRefund", value = "项目实体类hyRefund", required = true), })
	@RequiresPermissions("system:refund:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyRefund hyRefund) {
		startPage();
		List<HyRefund> list = hyRefundService.selectHyRefundList(hyRefund);
		return getDataTable(list);
	}

}
