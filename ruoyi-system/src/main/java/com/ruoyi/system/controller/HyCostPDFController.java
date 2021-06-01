package com.ruoyi.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.service.IHyCostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 费用项目PDFController
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/system/costPDF")
@Api(tags = "费用项目Controller")
public class HyCostPDFController extends BaseController {
	private String prefix = "system/costPDF";

	@Autowired
	private IHyCostService hyCostService;

	@RequiresPermissions("system:cost:view")
	@GetMapping()
	public String cost() {
		return prefix + "/costPDF";
	}

	/**
	 * 查询费用项目列表
	 */
	@ApiOperation("费用项目")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cost:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyCost hyCost) {
		startPage();
		List<HyCost> list = hyCostService.selectHyCostList(hyCost);
		return getDataTable(list);
	}

	/**
	 * 导出费用项目列表
	 */
	@ApiOperation("费用项目")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cost:export")
	@Log(title = "费用项目", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyCost hyCost) {
		List<HyCost> list = hyCostService.selectHyCostList(hyCost);
		ExcelUtil<HyCost> util = new ExcelUtil<HyCost>(HyCost.class);
		return util.exportExcel(list, "cost");
	}
	/**
	 * 导出PDF
	 */
	 @PostMapping("/exportPDF")
	 @ResponseBody
	public AjaxResult downloadPDF(HttpServletResponse response) throws Exception
	{
		 return toAjax(hyCostService.downloadPDF(response));
	}

}
