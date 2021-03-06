package com.ruoyi.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.HyDeatilPicture;
import com.ruoyi.system.domain.HyPicture;
import com.ruoyi.system.domain.HyProduct;
import com.ruoyi.system.domain.HySetMeal;
import com.ruoyi.system.domain.HyShop;
import com.ruoyi.system.service.IHyDeatilPictureService;
import com.ruoyi.system.service.IHyProductService;
import com.ruoyi.system.service.IHySetMealService;
import com.ruoyi.system.service.IHyShopService;

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
@CrossOrigin
@RequestMapping("/system/productDetailsCM")
@Api(tags = "票据设置Controller")
public class HyCarouselMapController extends BaseController {

	private String prefix = "system/productDetails";

	@Autowired
	private IHyProductService hyProductService;
	
	@Autowired
	private IHySetMealService hySetMealService;
	
	@Autowired
	private IHyDeatilPictureService hyDeatilPictureService;
	
	@Autowired
	private IHyShopService HyShopService;

	@RequiresPermissions("system:set:view")
	@GetMapping()
	public String set() {
		return prefix + "/carouselMap";  
	}

	@ApiOperation("查询收费比例设置列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyDeatilPicture", value = "项目实体类", required = true), })
	@GetMapping("/list")
	public String list(HyPicture hyPicture, ModelMap mmap,HttpServletRequest request) {

		String pid = request.getParameter("id");
		HyProduct product = hyProductService.selectHyProductById(Long.parseLong(pid));
		mmap.put("product", product);
		
		HySetMeal setMeal = new HySetMeal();
		setMeal.setProductId(Long.parseLong(pid));
		List<HySetMeal> list = hySetMealService.selectHySetMealList(setMeal);
		setMeal = (HySetMeal)list.get(0);
//		Long id = setMeal.getId();
//        setMeal = hySetMealService.selectHySetMealById(id);
        mmap.put("setMeal", setMeal);
		
//        HyDeatilPicture hyDeatilPicture = new HyDeatilPicture();
//        hyDeatilPicture.setProductId(Long.parseLong(pid));
        List<HyDeatilPicture> deatilPicture = hyDeatilPictureService.selectHyDeatilPictureList(new HyDeatilPicture());
//        hyDeatilPicture = (HyDeatilPicture)list1.get(0);
        mmap.put("deatilPicture", deatilPicture);
        
        HyShop shop = new HyShop();
        Long shopId = product.getShopId();
        shop = HyShopService.selectHyShopById(shopId);
        mmap.put("shop", shop);
        
		return prefix + "/carouselMap";
	} 
}
