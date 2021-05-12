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
import com.ruoyi.system.domain.HyMaintenanceregistration;
import com.ruoyi.system.service.IHyMaintenanceregistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备保养登记Controller
 * 
 * @author Administrator
 * @date 2021-05-12
 */
@Controller
@RequestMapping("/system/maintenanceregistration")
@Api(tags = "设备保养登记Controller")
public class HyMaintenanceregistrationController extends BaseController
{
    private String prefix = "system/maintenanceregistration";

    @Autowired
    private IHyMaintenanceregistrationService hyMaintenanceregistrationService;

    @RequiresPermissions("system:maintenanceregistration:view")
    @GetMapping()
    public String maintenanceregistration()
    {
        return prefix + "/maintenanceregistration";
    }

    /**
     * 查询设备保养登记列表
     */
    @ApiOperation("设备保养登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceregistration", value = "项目实体类hyMaintenanceregistration", required = true),
	})
    @RequiresPermissions("system:maintenanceregistration:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaintenanceregistration hyMaintenanceregistration)
    {
        startPage();
        List<HyMaintenanceregistration> list = hyMaintenanceregistrationService.selectHyMaintenanceregistrationList(hyMaintenanceregistration);
        return getDataTable(list);
    }

    /**
     * 导出设备保养登记列表
     */
    @ApiOperation("设备保养登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceregistration", value = "项目实体类hyMaintenanceregistration", required = true),
	})
    @RequiresPermissions("system:maintenanceregistration:export")
    @Log(title = "设备保养登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMaintenanceregistration hyMaintenanceregistration)
    {
        List<HyMaintenanceregistration> list = hyMaintenanceregistrationService.selectHyMaintenanceregistrationList(hyMaintenanceregistration);
        ExcelUtil<HyMaintenanceregistration> util = new ExcelUtil<HyMaintenanceregistration>(HyMaintenanceregistration.class);
        return util.exportExcel(list, "maintenanceregistration");
    }

    /**
     * 新增设备保养登记
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备保养登记
     */
    @ApiOperation("设备保养登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceregistration", value = "项目实体类hyMaintenanceregistration", required = true),
	})
    @RequiresPermissions("system:maintenanceregistration:add")
    @Log(title = "设备保养登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyMaintenanceregistration hyMaintenanceregistration)
    {
        return toAjax(hyMaintenanceregistrationService.insertHyMaintenanceregistration(hyMaintenanceregistration));
    }

    /**
     * 修改设备保养登记
     */
    @ApiOperation("设备保养登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMaintenanceregistration hyMaintenanceregistration = hyMaintenanceregistrationService.selectHyMaintenanceregistrationById(id);
        mmap.put("hyMaintenanceregistration", hyMaintenanceregistration);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备保养登记
     */
    @ApiOperation("设备保养登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceregistration", value = "项目实体类hyMaintenanceregistration", required = true),
	})
    @RequiresPermissions("system:maintenanceregistration:edit")
    @Log(title = "设备保养登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMaintenanceregistration hyMaintenanceregistration)
    {
        return toAjax(hyMaintenanceregistrationService.updateHyMaintenanceregistration(hyMaintenanceregistration));
    }

    /**
     * 删除设备保养登记
     */
    @ApiOperation("设备保养登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:maintenanceregistration:remove")
    @Log(title = "设备保养登记", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMaintenanceregistrationService.deleteHyMaintenanceregistrationByIds(ids));
    }
}
