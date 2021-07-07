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
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.service.IHyCollectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 实收费用查询Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@CrossOrigin
@RequestMapping("/system/receiptsCost")
@Api(tags = "实收费用查询Controller")
public class HyReceiptsCostController extends BaseController {

	private String prefix = "system/receiptsCost";

	@Autowired
	private IHyCollectionService hyCollectionService;

	@RequiresPermissions("system:receiptsCost:view")
	@GetMapping()
	public String cost() {
		return prefix + "/receipts";
	}

	/**
	 * 实收费用查询列表
	 */
	@ApiOperation("实收费用查询")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true), })
	@RequiresPermissions("system:receiptsCost:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyCollection hyCollection) {
		startPage();
		List<HyCollection> list = hyCollectionService.selectHyCollectionList(hyCollection);
		return getDataTable(list);
	}
}
