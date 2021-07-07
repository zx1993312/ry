package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyWarehouse;
import com.ruoyi.system.service.IHyWarehouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库Controller
 * 
 * @author Administrator
 * @date 2021-06-11
 */
@Controller
@CrossOrigin
@RequestMapping("/system/warehouse")
@Api(tags = "仓库Controller")
public class HyWarehouseController extends BaseController
{
    private String prefix = "system/warehouse";

    @Autowired
    private IHyWarehouseService hyWarehouseService;

    @RequiresPermissions("system:warehouse:view")
    @GetMapping()
    public String warehouse()
    {
        return prefix + "/warehouse";
    }

    /**
     * 查询仓库列表
     */
    @ApiOperation("仓库")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyWarehouse", value = "项目实体类hyWarehouse", required = true),
	})
    @RequiresPermissions("system:warehouse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyWarehouse hyWarehouse)
    {
        startPage();
        List<HyWarehouse> list = hyWarehouseService.selectHyWarehouseList(hyWarehouse);
        return getDataTable(list);
    }

    /**
     * 导出仓库列表
     */
    @ApiOperation("仓库")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyWarehouse", value = "项目实体类hyWarehouse", required = true),
	})
    @RequiresPermissions("system:warehouse:export")
    @Log(title = "仓库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyWarehouse hyWarehouse)
    {
        List<HyWarehouse> list = hyWarehouseService.selectHyWarehouseList(hyWarehouse);
        ExcelUtil<HyWarehouse> util = new ExcelUtil<HyWarehouse>(HyWarehouse.class);
        return util.exportExcel(list, "warehouse");
    }

    /**
     * 新增仓库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存仓库
     */
    @ApiOperation("仓库")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyWarehouse", value = "项目实体类hyWarehouse", required = true),
	})
    @RequiresPermissions("system:warehouse:add")
    @Log(title = "仓库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyWarehouse hyWarehouse)
    {
        return toAjax(hyWarehouseService.insertHyWarehouse(hyWarehouse));
    }

    /**
     * 修改仓库
     */
    @ApiOperation("仓库")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyWarehouse hyWarehouse = hyWarehouseService.selectHyWarehouseById(id);
        mmap.put("hyWarehouse", hyWarehouse);
        return prefix + "/edit";
    }

    /**
     * 修改保存仓库
     */
    @ApiOperation("仓库")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyWarehouse", value = "项目实体类hyWarehouse", required = true),
	})
    @RequiresPermissions("system:warehouse:edit")
    @Log(title = "仓库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyWarehouse hyWarehouse)
    {
        return toAjax(hyWarehouseService.updateHyWarehouse(hyWarehouse));
    }

    /**
     * 删除仓库
     */
    @ApiOperation("仓库")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:warehouse:remove")
    @Log(title = "仓库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyWarehouseService.deleteHyWarehouseByIds(ids));
    }
}
