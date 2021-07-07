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
import com.ruoyi.system.domain.HyMaintenancesupplies;
import com.ruoyi.system.service.IHyMaintenancesuppliesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备保养物料Controller
 * 
 * @author Administrator
 * @date 2021-05-12
 */
@Controller
@CrossOrigin
@RequestMapping("/system/maintenancesupplies")
@Api(tags = "设备保养物料Controller")
public class HyMaintenancesuppliesController extends BaseController
{
    private String prefix = "system/maintenancesupplies";

    @Autowired
    private IHyMaintenancesuppliesService hyMaintenancesuppliesService;

    @RequiresPermissions("system:maintenancesupplies:view")
    @GetMapping()
    public String maintenancesupplies()
    {
        return prefix + "/maintenancesupplies";
    }

    /**
     * 查询设备保养物料列表
     */
    @ApiOperation("设备保养物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenancesupplies", value = "项目实体类hyMaintenancesupplies", required = true),
	})
    @RequiresPermissions("system:maintenancesupplies:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaintenancesupplies hyMaintenancesupplies)
    {
        startPage();
        List<HyMaintenancesupplies> list = hyMaintenancesuppliesService.selectHyMaintenancesuppliesList(hyMaintenancesupplies);
        return getDataTable(list);
    }

    /**
     * 导出设备保养物料列表
     */
    @ApiOperation("设备保养物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenancesupplies", value = "项目实体类hyMaintenancesupplies", required = true),
	})
    @RequiresPermissions("system:maintenancesupplies:export")
    @Log(title = "设备保养物料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMaintenancesupplies hyMaintenancesupplies)
    {
        List<HyMaintenancesupplies> list = hyMaintenancesuppliesService.selectHyMaintenancesuppliesList(hyMaintenancesupplies);
        ExcelUtil<HyMaintenancesupplies> util = new ExcelUtil<HyMaintenancesupplies>(HyMaintenancesupplies.class);
        return util.exportExcel(list, "maintenancesupplies");
    }

    /**
     * 新增设备保养物料
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备保养物料
     */
    @ApiOperation("设备保养物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenancesupplies", value = "项目实体类hyMaintenancesupplies", required = true),
	})
    @RequiresPermissions("system:maintenancesupplies:add")
    @Log(title = "设备保养物料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyMaintenancesupplies hyMaintenancesupplies)
    {
        return toAjax(hyMaintenancesuppliesService.insertHyMaintenancesupplies(hyMaintenancesupplies));
    }

    /**
     * 修改设备保养物料
     */
    @ApiOperation("设备保养物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMaintenancesupplies hyMaintenancesupplies = hyMaintenancesuppliesService.selectHyMaintenancesuppliesById(id);
        mmap.put("hyMaintenancesupplies", hyMaintenancesupplies);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备保养物料
     */
    @ApiOperation("设备保养物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenancesupplies", value = "项目实体类hyMaintenancesupplies", required = true),
	})
    @RequiresPermissions("system:maintenancesupplies:edit")
    @Log(title = "设备保养物料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMaintenancesupplies hyMaintenancesupplies)
    {
        return toAjax(hyMaintenancesuppliesService.updateHyMaintenancesupplies(hyMaintenancesupplies));
    }

    /**
     * 删除设备保养物料
     */
    @ApiOperation("设备保养物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:maintenancesupplies:remove")
    @Log(title = "设备保养物料", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMaintenancesuppliesService.deleteHyMaintenancesuppliesByIds(ids));
    }
}
