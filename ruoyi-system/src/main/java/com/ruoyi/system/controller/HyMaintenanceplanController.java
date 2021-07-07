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
import com.ruoyi.system.domain.HyMaintenanceplan;
import com.ruoyi.system.service.IHyMaintenanceplanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备保养计划Controller
 * 
 * @author Administrator
 * @date 2021-05-11
 */
@Controller
@CrossOrigin
@RequestMapping("/system/maintenanceplan")
@Api(tags = "设备保养计划Controller")
public class HyMaintenanceplanController extends BaseController
{
    private String prefix = "system/maintenanceplan";

    @Autowired
    private IHyMaintenanceplanService hyMaintenanceplanService;

    @RequiresPermissions("system:maintenanceplan:view")
    @GetMapping()
    public String maintenanceplan()
    {
        return prefix + "/maintenanceplan";
    }

    /**
     * 查询设备保养计划列表
     */
    @ApiOperation("设备保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceplan", value = "项目实体类hyMaintenanceplan", required = true),
	})
    @RequiresPermissions("system:maintenanceplan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaintenanceplan hyMaintenanceplan)
    {
        startPage();
        List<HyMaintenanceplan> list = hyMaintenanceplanService.selectHyMaintenanceplanList(hyMaintenanceplan);
        return getDataTable(list);
    }

    /**
     * 导出设备保养计划列表
     */
    @ApiOperation("设备保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceplan", value = "项目实体类hyMaintenanceplan", required = true),
	})
    @RequiresPermissions("system:maintenanceplan:export")
    @Log(title = "设备保养计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMaintenanceplan hyMaintenanceplan)
    {
        List<HyMaintenanceplan> list = hyMaintenanceplanService.selectHyMaintenanceplanList(hyMaintenanceplan);
        ExcelUtil<HyMaintenanceplan> util = new ExcelUtil<HyMaintenanceplan>(HyMaintenanceplan.class);
        return util.exportExcel(list, "maintenanceplan");
    }

    /**
     * 新增设备保养计划
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备保养计划
     */
    @ApiOperation("设备保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceplan", value = "项目实体类hyMaintenanceplan", required = true),
	})
    @RequiresPermissions("system:maintenanceplan:add")
    @Log(title = "设备保养计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyMaintenanceplan hyMaintenanceplan)
    {
        return toAjax(hyMaintenanceplanService.insertHyMaintenanceplan(hyMaintenanceplan));
    }

    /**
     * 修改设备保养计划
     */
    @ApiOperation("设备保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMaintenanceplan hyMaintenanceplan = hyMaintenanceplanService.selectHyMaintenanceplanById(id);
        mmap.put("hyMaintenanceplan", hyMaintenanceplan);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备保养计划
     */
    @ApiOperation("设备保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceplan", value = "项目实体类hyMaintenanceplan", required = true),
	})
    @RequiresPermissions("system:maintenanceplan:edit")
    @Log(title = "设备保养计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMaintenanceplan hyMaintenanceplan)
    {
        return toAjax(hyMaintenanceplanService.updateHyMaintenanceplan(hyMaintenanceplan));
    }

    /**
     * 删除设备保养计划
     */
    @ApiOperation("设备保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:maintenanceplan:remove")
    @Log(title = "设备保养计划", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMaintenanceplanService.deleteHyMaintenanceplanByIds(ids));
    }
}
