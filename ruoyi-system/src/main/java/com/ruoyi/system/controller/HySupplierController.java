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
import com.ruoyi.system.domain.HySupplier;
import com.ruoyi.system.service.IHySupplierService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商Controller
 * 
 * @author Administrator
 * @date 2021-06-11
 */
@Controller
@RequestMapping("/system/supplier")
@Api(tags = "供应商Controller")
public class HySupplierController extends BaseController
{
    private String prefix = "system/supplier";

    @Autowired
    private IHySupplierService hySupplierService;

    @RequiresPermissions("system:supplier:view")
    @GetMapping()
    public String supplier()
    {
        return prefix + "/supplier";
    }

    /**
     * 查询供应商列表
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySupplier", value = "项目实体类hySupplier", required = true),
	})
    @RequiresPermissions("system:supplier:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HySupplier hySupplier)
    {
        startPage();
        List<HySupplier> list = hySupplierService.selectHySupplierList(hySupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商列表
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySupplier", value = "项目实体类hySupplier", required = true),
	})
    @RequiresPermissions("system:supplier:export")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HySupplier hySupplier)
    {
        List<HySupplier> list = hySupplierService.selectHySupplierList(hySupplier);
        ExcelUtil<HySupplier> util = new ExcelUtil<HySupplier>(HySupplier.class);
        return util.exportExcel(list, "supplier");
    }

    /**
     * 新增供应商
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存供应商
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySupplier", value = "项目实体类hySupplier", required = true),
	})
    @RequiresPermissions("system:supplier:add")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HySupplier hySupplier)
    {
        return toAjax(hySupplierService.insertHySupplier(hySupplier));
    }

    /**
     * 修改供应商
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HySupplier hySupplier = hySupplierService.selectHySupplierById(id);
        mmap.put("hySupplier", hySupplier);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySupplier", value = "项目实体类hySupplier", required = true),
	})
    @RequiresPermissions("system:supplier:edit")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HySupplier hySupplier)
    {
        return toAjax(hySupplierService.updateHySupplier(hySupplier));
    }

    /**
     * 删除供应商
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:supplier:remove")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hySupplierService.deleteHySupplierByIds(ids));
    }
}
