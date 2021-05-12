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
import com.ruoyi.system.domain.HyMaintenancecycle;
import com.ruoyi.system.service.IHyMaintenancecycleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备保养周期Controller
 * 
 * @author Administrator
 * @date 2021-05-11
 */
@Controller
@RequestMapping("/system/maintenancecycle")
@Api(tags = "设备保养周期Controller")
public class HyMaintenancecycleController extends BaseController
{
    private String prefix = "system/maintenancecycle";

    @Autowired
    private IHyMaintenancecycleService hyMaintenancecycleService;

    @RequiresPermissions("system:maintenancecycle:view")
    @GetMapping()
    public String maintenancecycle()
    {
        return prefix + "/maintenancecycle";
    }

    /**
     * 查询设备保养周期列表
     */
    @ApiOperation("设备保养周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenancecycle", value = "项目实体类hyMaintenancecycle", required = true),
	})
    @RequiresPermissions("system:maintenancecycle:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaintenancecycle hyMaintenancecycle)
    {
        startPage();
        List<HyMaintenancecycle> list = hyMaintenancecycleService.selectHyMaintenancecycleList(hyMaintenancecycle);
        return getDataTable(list);
    }

    /**
     * 导出设备保养周期列表
     */
    @ApiOperation("设备保养周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenancecycle", value = "项目实体类hyMaintenancecycle", required = true),
	})
    @RequiresPermissions("system:maintenancecycle:export")
    @Log(title = "设备保养周期", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMaintenancecycle hyMaintenancecycle)
    {
        List<HyMaintenancecycle> list = hyMaintenancecycleService.selectHyMaintenancecycleList(hyMaintenancecycle);
        ExcelUtil<HyMaintenancecycle> util = new ExcelUtil<HyMaintenancecycle>(HyMaintenancecycle.class);
        return util.exportExcel(list, "maintenancecycle");
    }

    /**
     * 新增设备保养周期
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备保养周期
     */
    @ApiOperation("设备保养周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenancecycle", value = "项目实体类hyMaintenancecycle", required = true),
	})
    @RequiresPermissions("system:maintenancecycle:add")
    @Log(title = "设备保养周期", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyMaintenancecycle hyMaintenancecycle)
    {
        return toAjax(hyMaintenancecycleService.insertHyMaintenancecycle(hyMaintenancecycle));
    }

    /**
     * 修改设备保养周期
     */
    @ApiOperation("设备保养周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMaintenancecycle hyMaintenancecycle = hyMaintenancecycleService.selectHyMaintenancecycleById(id);
        mmap.put("hyMaintenancecycle", hyMaintenancecycle);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备保养周期
     */
    @ApiOperation("设备保养周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenancecycle", value = "项目实体类hyMaintenancecycle", required = true),
	})
    @RequiresPermissions("system:maintenancecycle:edit")
    @Log(title = "设备保养周期", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMaintenancecycle hyMaintenancecycle)
    {
        return toAjax(hyMaintenancecycleService.updateHyMaintenancecycle(hyMaintenancecycle));
    }

    /**
     * 删除设备保养周期
     */
    @ApiOperation("设备保养周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:maintenancecycle:remove")
    @Log(title = "设备保养周期", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMaintenancecycleService.deleteHyMaintenancecycleByIds(ids));
    }
}
