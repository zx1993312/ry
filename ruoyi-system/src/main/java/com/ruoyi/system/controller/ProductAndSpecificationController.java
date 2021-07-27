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
import com.ruoyi.system.domain.ProductAndSpecification;
import com.ruoyi.system.service.IProductAndSpecificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品和规格关联Controller
 * 
 * @author Administrator
 * @date 2021-07-26
 */
@Controller
@RequestMapping("/system/specifications")
@Api(tags = "商品和规格关联Controller")
public class ProductAndSpecificationController extends BaseController
{
    private String prefix = "system/specification";

    @Autowired
    private IProductAndSpecificationService productAndSpecificationService;

    @RequiresPermissions("system:specification:view")
    @GetMapping()
    public String specification()
    {
        return prefix + "/specification";
    }

    /**
     * 查询商品和规格关联列表
     */
    @ApiOperation("商品和规格关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "productAndSpecification", value = "项目实体类productAndSpecification", required = true),
	})
    @RequiresPermissions("system:specification:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductAndSpecification productAndSpecification)
    {
        startPage();
        List<ProductAndSpecification> list = productAndSpecificationService.selectProductAndSpecificationList(productAndSpecification);
        return getDataTable(list);
    }

    /**
     * 导出商品和规格关联列表
     */
    @ApiOperation("商品和规格关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "productAndSpecification", value = "项目实体类productAndSpecification", required = true),
	})
    @RequiresPermissions("system:specification:export")
    @Log(title = "商品和规格关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductAndSpecification productAndSpecification)
    {
        List<ProductAndSpecification> list = productAndSpecificationService.selectProductAndSpecificationList(productAndSpecification);
        ExcelUtil<ProductAndSpecification> util = new ExcelUtil<ProductAndSpecification>(ProductAndSpecification.class);
        return util.exportExcel(list, "specification");
    }

    /**
     * 新增商品和规格关联
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品和规格关联
     */
    @ApiOperation("商品和规格关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "productAndSpecification", value = "项目实体类productAndSpecification", required = true),
	})
    @RequiresPermissions("system:specification:add")
    @Log(title = "商品和规格关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProductAndSpecification productAndSpecification)
    {
        return toAjax(productAndSpecificationService.insertProductAndSpecification(productAndSpecification));
    }

    /**
     * 修改商品和规格关联
     */
    @ApiOperation("商品和规格关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "productId", value = "主键id", required = true),
	})
    @GetMapping("/edit/{productId}")
    public String edit(@PathVariable("productId") Long productId, ModelMap mmap)
    {
        ProductAndSpecification productAndSpecification = productAndSpecificationService.selectProductAndSpecificationById(productId);
        mmap.put("productAndSpecification", productAndSpecification);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品和规格关联
     */
    @ApiOperation("商品和规格关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "productAndSpecification", value = "项目实体类productAndSpecification", required = true),
	})
    @RequiresPermissions("system:specification:edit")
    @Log(title = "商品和规格关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductAndSpecification productAndSpecification)
    {
        return toAjax(productAndSpecificationService.updateProductAndSpecification(productAndSpecification));
    }

    /**
     * 删除商品和规格关联
     */
    @ApiOperation("商品和规格关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:specification:remove")
    @Log(title = "商品和规格关联", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productAndSpecificationService.deleteProductAndSpecificationByIds(ids));
    }
}
