package com.ruoyi.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.service.IHyArrearageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 欠费通知Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/system/arrearage")
@Api(tags = "欠费通知Controller")
public class HyArrearageController extends BaseController {
	private String prefix = "system/arrearage";

	@Autowired
	private IHyArrearageService hyArrearageService;

	@RequiresPermissions("system:inf:view")
	@GetMapping()
	public String inf() {
		return prefix + "/arrearage";
	}

	/**
	 * 查询欠费通知列表
	 */
	@ApiOperation("欠费通知")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyHouseInf", value = "项目实体类hyHouseInf", required = true), })
	@RequiresPermissions("system:arrearage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyHouseInf hyHouseInf) {
		startPage();
		List<HyHouseInf> list = hyArrearageService.selectHyArrearageList(hyHouseInf);
		return getDataTable(list);
	}
	
	/**
	 * 导出欠费通知单
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}
	
	/**
	 * 导出PDF
	 */
	 @PostMapping("/exportPDF")
	 @ResponseBody
	public AjaxResult downloadPDF(String warm,HttpServletResponse response) throws Exception
	{
		 return toAjax(hyArrearageService.downloadPDF(warm,response));
	}
	
}
