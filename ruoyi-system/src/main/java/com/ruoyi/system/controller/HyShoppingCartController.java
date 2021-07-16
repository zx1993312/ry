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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyShoppingCart;
import com.ruoyi.system.service.IHyShoppingCartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 购物车Controller
 * 
 * @author Administrator
 * @date 2021-07-16
 */
@Controller
@RequestMapping("/system/cart")
@Api(tags = "购物车Controller")
public class HyShoppingCartController extends BaseController {
	private String prefix = "system/cart";

	@Autowired
	private IHyShoppingCartService hyShoppingCartService;

	@RequiresPermissions("system:cart:view")
	@GetMapping()
	public String cart() {
		return prefix + "/cart";
	}

	/**
	 * 查询购物车列表
	 */
	@ApiOperation("购物车")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyShoppingCart", value = "项目实体类hyShoppingCart", required = true), })
	@RequiresPermissions("system:cart:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyShoppingCart hyShoppingCart) {
		startPage();
		List<HyShoppingCart> list = hyShoppingCartService.selectHyShoppingCartList(hyShoppingCart);
		return getDataTable(list);
	}

	/**
	 * app查询购物车列表
	 * 
	 * @param hyShoppingCart
	 * @return
	 */
	@RequiresPermissions("system:cart:appList")
	@PostMapping("/appList")
	@ResponseBody
	public List<HyShoppingCart> lists(HyShoppingCart hyShoppingCart) {
		return hyShoppingCartService.selectHyShoppingCartList(hyShoppingCart);
	}

	/**
	 * 导出购物车列表
	 */
	@ApiOperation("购物车")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyShoppingCart", value = "项目实体类hyShoppingCart", required = true), })
	@RequiresPermissions("system:cart:export")
	@Log(title = "购物车", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyShoppingCart hyShoppingCart) {
		List<HyShoppingCart> list = hyShoppingCartService.selectHyShoppingCartList(hyShoppingCart);
		ExcelUtil<HyShoppingCart> util = new ExcelUtil<HyShoppingCart>(HyShoppingCart.class);
		return util.exportExcel(list, "cart");
	}

	/**
	 * 新增购物车
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存购物车
	 */
	@ApiOperation("购物车")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyShoppingCart", value = "项目实体类hyShoppingCart", required = true), })
	@RequiresPermissions("system:cart:add")
	@Log(title = "购物车", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyShoppingCart hyShoppingCart) {
		return toAjax(hyShoppingCartService.insertHyShoppingCart(hyShoppingCart));
	}

	/**
	 * 修改购物车
	 */
	@ApiOperation("购物车")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyShoppingCart hyShoppingCart = hyShoppingCartService.selectHyShoppingCartById(id);
		mmap.put("hyShoppingCart", hyShoppingCart);
		return prefix + "/edit";
	}

	/**
	 * 修改保存购物车
	 */
	@ApiOperation("购物车")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyShoppingCart", value = "项目实体类hyShoppingCart", required = true), })
	@RequiresPermissions("system:cart:edit")
	@Log(title = "购物车", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyShoppingCart hyShoppingCart) {
		return toAjax(hyShoppingCartService.updateHyShoppingCart(hyShoppingCart));
	}

	/**
	 * 删除购物车
	 */
	@ApiOperation("购物车")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:cart:remove")
	@Log(title = "购物车", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyShoppingCartService.deleteHyShoppingCartByIds(ids));
	}
}
