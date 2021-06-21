package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.HyPicture;
import com.ruoyi.system.domain.HyProduct;
import com.ruoyi.system.service.IHyProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 票据设置Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/system/productDetailsSM")
@Api(tags = "票据设置Controller")
public class HyShoppingController extends BaseController {
	private String prefix = "system/productDetails";

	@Autowired
	private IHyProductService hyProductService;
	
	

	@RequiresPermissions("system:set:view")
	@GetMapping()
	public String set() {
		return prefix + "/shoppingMall";
	}

	@ApiOperation("查询收费比例设置列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyPicture", value = "项目实体类", required = true), })
	@GetMapping("/list")
	public String list(HyPicture hyPicture, ModelMap mmap) {

		List<HyProduct> list = hyProductService.selectHyProductListTest(new HyProduct());
		mmap.put("list", list);
		return prefix + "/shoppingMall";
	}
}
