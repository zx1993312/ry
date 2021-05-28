package com.ruoyi.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Controller
@RequestMapping("/system/refund")
@Api(tags = "退款申请Controller")
public class HyRefundController {

	private String prefix = "system/refundMoney";

	@RequiresPermissions("system:refund:view")
	@GetMapping()
	public String remission() {
		return prefix + "/refund";
	}

}
