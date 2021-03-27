package com.ruoyi.system.controller;

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
import com.ruoyi.system.service.IHyPictureService;
import com.ruoyi.system.service.IHyProductService;
import com.ruoyi.system.service.IHySetMealService;
import com.ruoyi.system.utils.ReflectUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 商城首页Controller
 * 
 * @author Administrator
 * @date 2021-03-24
 */
@Controller
@RequestMapping("/system/productDetailsSM")
@Api(tags = "商城首页Controller")
public class HyShoppingController extends BaseController {
	private String prefix = "system/productDetails";

	@Autowired
	private IHyProductService hyProductService;
	
	@Autowired
	private IHySetMealService hySetMealService;
	
	@Autowired
	private IHyPictureService hyPictureService;

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
		
        List<HySetMeal> relist = hySetMealService.selectHySetMealVoTest(new HySetMeal());
        mmap.put("relist", relist);
		
        List<HyPicture> reList = hyPictureService.selectHyPictureList(new HyPicture());
        mmap.put("reList", reList);

        //ReflectUtil<?> reflectUtil = new ReflectUtil();
        //reflectUtil.convertMap(list,relist,reList);
        
		return prefix + "/shoppingMall";
	}
}
