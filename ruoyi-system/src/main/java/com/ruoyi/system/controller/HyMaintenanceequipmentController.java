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
import com.ruoyi.system.domain.HyMaintenanceequipment;
import com.ruoyi.system.service.IHyMaintenanceequipmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 保养设备Controller
 * 
 * @author Administrator
 * @date 2021-05-12
 */
@Controller
@CrossOrigin
@RequestMapping("/system/maintenanceequipment")
@Api(tags = "保养设备Controller")
public class HyMaintenanceequipmentController extends BaseController
{
    private String prefix = "system/maintenanceequipment";

    @Autowired
    private IHyMaintenanceequipmentService hyMaintenanceequipmentService;

    @RequiresPermissions("system:maintenanceequipment:view")
    @GetMapping()
    public String maintenanceequipment()
    {
        return prefix + "/maintenanceequipment";
    }

    /**
     * 查询保养设备列表
     */
    @ApiOperation("保养设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceequipment", value = "项目实体类hyMaintenanceequipment", required = true),
	})
    @RequiresPermissions("system:maintenanceequipment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaintenanceequipment hyMaintenanceequipment)
    {
        startPage();
        List<HyMaintenanceequipment> list = hyMaintenanceequipmentService.selectHyMaintenanceequipmentList(hyMaintenanceequipment);
        return getDataTable(list);
    }

    /**
     * 导出保养设备列表
     */
    @ApiOperation("保养设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceequipment", value = "项目实体类hyMaintenanceequipment", required = true),
	})
    @RequiresPermissions("system:maintenanceequipment:export")
    @Log(title = "保养设备", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMaintenanceequipment hyMaintenanceequipment)
    {
        List<HyMaintenanceequipment> list = hyMaintenanceequipmentService.selectHyMaintenanceequipmentList(hyMaintenanceequipment);
        ExcelUtil<HyMaintenanceequipment> util = new ExcelUtil<HyMaintenanceequipment>(HyMaintenanceequipment.class);
        return util.exportExcel(list, "maintenanceequipment");
    }

    /**
     * 新增保养设备
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存保养设备
     */
    @ApiOperation("保养设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceequipment", value = "项目实体类hyMaintenanceequipment", required = true),
	})
    @RequiresPermissions("system:maintenanceequipment:add")
    @Log(title = "保养设备", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyMaintenanceequipment hyMaintenanceequipment)
    {
        return toAjax(hyMaintenanceequipmentService.insertHyMaintenanceequipment(hyMaintenanceequipment));
    }

    /**
     * 修改保养设备
     */
    @ApiOperation("保养设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMaintenanceequipment hyMaintenanceequipment = hyMaintenanceequipmentService.selectHyMaintenanceequipmentById(id);
        mmap.put("hyMaintenanceequipment", hyMaintenanceequipment);
        return prefix + "/edit";
    }

    /**
     * 修改保存保养设备
     */
    @ApiOperation("保养设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceequipment", value = "项目实体类hyMaintenanceequipment", required = true),
	})
    @RequiresPermissions("system:maintenanceequipment:edit")
    @Log(title = "保养设备", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMaintenanceequipment hyMaintenanceequipment)
    {
        return toAjax(hyMaintenanceequipmentService.updateHyMaintenanceequipment(hyMaintenanceequipment));
    }

    /**
     * 删除保养设备
     */
    @ApiOperation("保养设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:maintenanceequipment:remove")
    @Log(title = "保养设备", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMaintenanceequipmentService.deleteHyMaintenanceequipmentByIds(ids));
    }
}
