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
import com.ruoyi.system.domain.HyInventory;
import com.ruoyi.system.service.IHyInventoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 盘点管理Controller
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/inventory")
@Api(tags = "盘点管理Controller")
public class HyInventoryController extends BaseController
{
    private String prefix = "system/inventory";

    @Autowired
    private IHyInventoryService hyInventoryService;

    @RequiresPermissions("system:inventory:view")
    @GetMapping()
    public String inventory()
    {
        return prefix + "/inventory";
    }

    /**
     * 查询盘点管理列表
     */
    @ApiOperation("盘点管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInventory", value = "项目实体类hyInventory", required = true),
	})
    @RequiresPermissions("system:inventory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyInventory hyInventory)
    {
        startPage();
        List<HyInventory> list = hyInventoryService.selectHyInventoryList(hyInventory);
        return getDataTable(list);
    }

    /**
     * 导出盘点管理列表
     */
    @ApiOperation("盘点管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInventory", value = "项目实体类hyInventory", required = true),
	})
    @RequiresPermissions("system:inventory:export")
    @Log(title = "盘点管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyInventory hyInventory)
    {
        List<HyInventory> list = hyInventoryService.selectHyInventoryList(hyInventory);
        ExcelUtil<HyInventory> util = new ExcelUtil<HyInventory>(HyInventory.class);
        return util.exportExcel(list, "inventory");
    }

    /**
     * 新增盘点管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存盘点管理
     */
    @ApiOperation("盘点管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInventory", value = "项目实体类hyInventory", required = true),
	})
    @RequiresPermissions("system:inventory:add")
    @Log(title = "盘点管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyInventory hyInventory)
    {
        return toAjax(hyInventoryService.insertHyInventory(hyInventory));
    }

    /**
     * 修改盘点管理
     */
    @ApiOperation("盘点管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyInventory hyInventory = hyInventoryService.selectHyInventoryById(id);
        mmap.put("hyInventory", hyInventory);
        return prefix + "/edit";
    }

    /**
     * 修改保存盘点管理
     */
    @ApiOperation("盘点管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInventory", value = "项目实体类hyInventory", required = true),
	})
    @RequiresPermissions("system:inventory:edit")
    @Log(title = "盘点管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyInventory hyInventory)
    {
        return toAjax(hyInventoryService.updateHyInventory(hyInventory));
    }

    /**
     * 删除盘点管理
     */
    @ApiOperation("盘点管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:inventory:remove")
    @Log(title = "盘点管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyInventoryService.deleteHyInventoryByIds(ids));
    }
}
