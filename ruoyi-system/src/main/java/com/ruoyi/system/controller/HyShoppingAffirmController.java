package com.ruoyi.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyOrder;
import com.ruoyi.system.domain.HyPicture;
import com.ruoyi.system.domain.HyProduct;
import com.ruoyi.system.domain.HySetMeal;
import com.ruoyi.system.domain.HyUser;
import com.ruoyi.system.service.IHyOrderService;
import com.ruoyi.system.service.IHyPictureService;
import com.ruoyi.system.service.IHyProductService;
import com.ruoyi.system.service.IHySetMealService;
import com.ruoyi.system.service.IHyUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

/**
 * 商品确认Controller
 * 
 * @author Administrator
 * @date 2021-03-09
 */

@Controller
@RequestMapping("/system/productDetailsSA")
@Api(tags = "商品Controller")
public class HyShoppingAffirmController extends BaseController
{
    private String prefix = "system/productDetails";

    @Autowired
    private IHyUserService hyUserService;
    
    @Autowired
	private IHyOrderService hyOrderService;
    
    @Autowired
	private IHySetMealService hySetMealService;
    
    @Autowired
    private IHyProductService hyProductService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/shoppingAffirm";
    }

   
   

    /**
     * 新增保存用户
     */
    @ApiOperation("商品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyUser", value = "项目实体类hyUser", required = true),
	})
    @RequiresPermissions("system:user:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyUser hyUser)
    {
        return toAjax(hyUserService.insertHyUserTest(hyUser));  
    }
    
    @ApiOperation("查询收费比例设置列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyPicture", value = "项目实体类", required = true), })
	@GetMapping("/list")
	public String list(HyPicture hyPicture, ModelMap mmap,HttpServletRequest request) {
		
    	String id = request.getParameter("id");
    	
    	HyProduct product = hyProductService.selectHyId(Long.parseLong(id));
		mmap.put("product", product);
		
		HyOrder hyOrder = hyOrderService.selectId(new HyOrder());
		mmap.put("hyOrder",hyOrder);
        
		return prefix + "/shoppingAffirm";

    }
}
