package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.OrderAndProduct;
import com.ruoyi.system.service.IOrderAndProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单商品中间Controller
 * 
 * @author Administrator
 * @date 2021-07-15
 */
@Controller
@RequestMapping("/system/orderAndProduct")
@Api(tags = "订单商品中间Controller")
public class OrderAndProductController extends BaseController
{
    private String prefix = "system/product";

    @Autowired
    private IOrderAndProductService orderAndProductService;

    @RequiresPermissions("system:product:view")
    @GetMapping()
    public String product()
    {
        return prefix + "/product";
    }

    /**
     * 查询订单商品中间列表                                                           
     */
    @ApiOperation("订单商品中间")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "orderAndProduct", value = "项目实体类orderAndProduct", required = true),
	})
    @RequiresPermissions("system:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OrderAndProduct orderAndProduct)
    {
        startPage();
        List<OrderAndProduct> list = orderAndProductService.selectOrderAndProductList(orderAndProduct);
        return getDataTable(list);
    }

    /**
     * 导出订单商品中间列表
     */
    @ApiOperation("订单商品中间")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "orderAndProduct", value = "项目实体类orderAndProduct", required = true),
	})
    @RequiresPermissions("system:product:export")
    @Log(title = "订单商品中间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OrderAndProduct orderAndProduct)
    {
        List<OrderAndProduct> list = orderAndProductService.selectOrderAndProductList(orderAndProduct);
        ExcelUtil<OrderAndProduct> util = new ExcelUtil<OrderAndProduct>(OrderAndProduct.class);
        return util.exportExcel(list, "product");
    }

    /**
     * 新增订单商品中间
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单商品中间
     */
    @ApiOperation("订单商品中间")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "orderAndProduct", value = "项目实体类orderAndProduct", required = true),
	})
    @RequiresPermissions("system:product:add")
    @Log(title = "订单商品中间", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OrderAndProduct orderAndProduct)
    {
        return toAjax(orderAndProductService.insertOrderAndProduct(orderAndProduct));
    }

    /**
     * 修改订单商品中间
     */
    @ApiOperation("订单商品中间")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "orderId", value = "主键id", required = true),
	})
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap)
    {
        OrderAndProduct orderAndProduct = orderAndProductService.selectOrderAndProductById(orderId);
        mmap.put("orderAndProduct", orderAndProduct);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单商品中间
     */
    @ApiOperation("订单商品中间")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "orderAndProduct", value = "项目实体类orderAndProduct", required = true),
	})
    @RequiresPermissions("system:product:edit")
    @Log(title = "订单商品中间", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OrderAndProduct orderAndProduct)
    {
        return toAjax(orderAndProductService.updateOrderAndProduct(orderAndProduct));
    }

    /**
     * 删除订单商品中间
     */
    @ApiOperation("订单商品中间")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:product:remove")
    @Log(title = "订单商品中间", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(orderAndProductService.deleteOrderAndProductByIds(ids));
    }
}
