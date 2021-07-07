package com.ruoyi.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 费用查询Controller
 * 
 * @author Administrator
 *
 */
@Controller
@CrossOrigin
@RequestMapping("/system/feeSelect")
@Api(tags = "费用查询Controller")
public class FeeSelectController {
	private String prefix = "system/feeSelect";

	/**
	 * 返回费用报表页面
	 * 
	 * @return
	 */
	@ApiOperation("费用查询")
	@RequestMapping("/getFee")
	public String returnFee() {
		return prefix + "/fee";
	}
}
