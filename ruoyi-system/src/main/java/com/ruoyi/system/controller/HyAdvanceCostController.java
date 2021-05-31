package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.HyPaymentOffset;
import com.ruoyi.system.service.IHyPaymentOffsetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 预交费用查询Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/system/advanceCost")
@Api(tags = "预交费用查询Controller")
public class HyAdvanceCostController extends BaseController {
	private String prefix = "system/advanceCost";

	@Autowired
	private IHyPaymentOffsetService hyPaymentOffsetService;

	@RequiresPermissions("system:advanceCost:view")
	@GetMapping()
	public String cost() {
		return prefix + "/advance";
	}

	/**
	 * 预交费用查询列表
	 */
	@ApiOperation("预交费用查询")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true), })
	@RequiresPermissions("system:advanceCost:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyPaymentOffset hyPaymentOffset) {
		startPage();
		List<HyPaymentOffset> list = hyPaymentOffsetService.selectHyPaymentOffsetListAll(hyPaymentOffset);
		return getDataTable(list);
	}
}
