package com.ruoyi.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 费用报表controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/system/report")
@Api(tags = "费用报表Controller")
public class ExpenseReportController {
	private String prefix = "system/expenseReport";

	/**
	 * 返回费用报表页面
	 * 
	 * @return
	 */
	@ApiOperation("费用报表")
	@RequestMapping("/getReport")
	public String returnReport() {
		return prefix + "/report";
	}
}
