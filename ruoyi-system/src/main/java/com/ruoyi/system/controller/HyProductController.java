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
import com.ruoyi.system.domain.HyPicture;
import com.ruoyi.system.domain.HyProduct;
import com.ruoyi.system.service.IHyProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品Controller
 * 
 * @author Administrator
 * @date 2021-03-06
 */
@Controller
@RequestMapping("/system/product")
@Api(tags = "产品Controller")
public class HyProductController extends BaseController
{
    private String prefix = "system/product";

    @Autowired
    private IHyProductService hyProductService;

    @RequiresPermissions("system:product:view")
    @GetMapping()
    public String product()
    {
        return prefix + "/product";
    }

    /**
     * 查询产品列表
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
	})
    @RequiresPermissions("system:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyProduct hyProduct)
    {
        startPage();
        List<HyProduct> list = hyProductService.selectHyProductList(hyProduct);
        return getDataTable(list);
    }

    /**
     * 导出产品列表
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
	})
    @RequiresPermissions("system:product:export")
    @Log(title = "产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyProduct hyProduct)
    {
        List<HyProduct> list = hyProductService.selectHyProductList(hyProduct);
        ExcelUtil<HyProduct> util = new ExcelUtil<HyProduct>(HyProduct.class);
        return util.exportExcel(list, "product");
    }

    /**
     * 新增产品
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
	})
    @RequiresPermissions("system:product:add")
    @Log(title = "产品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyProduct hyProduct)
    {
        return toAjax(hyProductService.insertHyProduct(hyProduct));
    }

    /**
     * 修改产品
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyProduct hyProduct = hyProductService.selectHyProductById(id);
        mmap.put("hyProduct", hyProduct);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
	})
    @RequiresPermissions("system:product:edit")
    @Log(title = "产品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyProduct hyProduct)
    {
        return toAjax(hyProductService.updateHyProduct(hyProduct));
    }

    /**
     * 删除产品
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:product:remove")
    @Log(title = "产品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyProductService.deleteHyProductByIds(ids));
    }
}
