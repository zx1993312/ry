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
import com.ruoyi.system.domain.HyMaintenanceunit;
import com.ruoyi.system.service.IHyMaintenanceunitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 保养单位Controller
 * 
 * @author Administrator
 * @date 2021-05-11
 */
@Controller
@CrossOrigin
@RequestMapping("/system/maintenanceunit")
@Api(tags = "保养单位Controller")
public class HyMaintenanceunitController extends BaseController
{
    private String prefix = "system/maintenanceunit";

    @Autowired
    private IHyMaintenanceunitService hyMaintenanceunitService;

    @RequiresPermissions("system:maintenanceunit:view")
    @GetMapping()
    public String maintenanceunit()
    {
        return prefix + "/maintenanceunit";
    }

    /**
     * 查询保养单位列表
     */
    @ApiOperation("保养单位")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceunit", value = "项目实体类hyMaintenanceunit", required = true),
	})
    @RequiresPermissions("system:maintenanceunit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaintenanceunit hyMaintenanceunit)
    {
        startPage();
        List<HyMaintenanceunit> list = hyMaintenanceunitService.selectHyMaintenanceunitList(hyMaintenanceunit);
        return getDataTable(list);
    }

    /**
     * 导出保养单位列表
     */
    @ApiOperation("保养单位")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceunit", value = "项目实体类hyMaintenanceunit", required = true),
	})
    @RequiresPermissions("system:maintenanceunit:export")
    @Log(title = "保养单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMaintenanceunit hyMaintenanceunit)
    {
        List<HyMaintenanceunit> list = hyMaintenanceunitService.selectHyMaintenanceunitList(hyMaintenanceunit);
        ExcelUtil<HyMaintenanceunit> util = new ExcelUtil<HyMaintenanceunit>(HyMaintenanceunit.class);
        return util.exportExcel(list, "maintenanceunit");
    }

    /**
     * 新增保养单位
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存保养单位
     */
    @ApiOperation("保养单位")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceunit", value = "项目实体类hyMaintenanceunit", required = true),
	})
    @RequiresPermissions("system:maintenanceunit:add")
    @Log(title = "保养单位", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyMaintenanceunit hyMaintenanceunit)
    {
        return toAjax(hyMaintenanceunitService.insertHyMaintenanceunit(hyMaintenanceunit));
    }

    /**
     * 修改保养单位
     */
    @ApiOperation("保养单位")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMaintenanceunit hyMaintenanceunit = hyMaintenanceunitService.selectHyMaintenanceunitById(id);
        mmap.put("hyMaintenanceunit", hyMaintenanceunit);
        return prefix + "/edit";
    }

    /**
     * 修改保存保养单位
     */
    @ApiOperation("保养单位")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceunit", value = "项目实体类hyMaintenanceunit", required = true),
	})
    @RequiresPermissions("system:maintenanceunit:edit")
    @Log(title = "保养单位", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMaintenanceunit hyMaintenanceunit)
    {
        return toAjax(hyMaintenanceunitService.updateHyMaintenanceunit(hyMaintenanceunit));
    }

    /**
     * 删除保养单位
     */
    @ApiOperation("保养单位")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:maintenanceunit:remove")
    @Log(title = "保养单位", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMaintenanceunitService.deleteHyMaintenanceunitByIds(ids));
    }
}
