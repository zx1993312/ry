package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.HyPicture;
import com.ruoyi.system.domain.HyProduct;
import com.ruoyi.system.domain.HySetMeal;
import com.ruoyi.system.domain.HyShop;
import com.ruoyi.system.service.IHyPictureService;
import com.ruoyi.system.service.IHyProductService;
import com.ruoyi.system.service.IHySetMealService;
import com.ruoyi.system.service.IHyShopService;
import com.ruoyi.system.service.impl.HyPictureServiceImpl;
import com.ruoyi.system.service.impl.HyPrinterServiceImpl;
import com.ruoyi.system.service.impl.HySetMealServiceImpl;
import com.ruoyi.system.service.impl.HyShopServiceImpl;

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
@RequestMapping("/system/productDetailsCM")
@Api(tags = "票据设置Controller")
public class HycarouselMapController extends BaseController {
	private String prefix = "system/productDetails";

	@Autowired
	private IHyProductService hyProductService;
	
	@Autowired
	private IHySetMealService hySetMealService;
	
	@Autowired
	private IHyPictureService hyPictureService;
	
	@Autowired
	private IHyShopService HyShopService;

	@RequiresPermissions("system:set:view")
	@GetMapping()
	public String set() {
		return prefix + "/carouselMap";
	}

	@ApiOperation("查询收费比例设置列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyPicture", value = "项目实体类", required = true), })
	@GetMapping("/list")
	public String list(HyPicture hyPicture, ModelMap mmap) {

		List<HyProduct> productList = hyProductService.selectHyProductListTest(new HyProduct());
		mmap.put("productList", productList);
		
        List<HySetMeal> setMealList = hySetMealService.selectHySetMealVoTest(new HySetMeal());
        mmap.put("setMealList", setMealList);
		
        List<HyPicture> pictureList = hyPictureService.selectHyPictureList(new HyPicture());
        mmap.put("pictureList", pictureList);
        
        List<HyShop> shopList = HyShopService.selectHyShopListTest(new HyShop());
        mmap.put("shopList", shopList);

		return prefix + "/carouselMap";
	}
}
