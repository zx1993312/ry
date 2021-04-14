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
import com.ruoyi.system.domain.HyMaintenance;
import com.ruoyi.system.service.IHyMaintenanceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维修费用Controller
 * 
 * @author Administrator
 * @date 2021-04-13
 */
@Controller
@RequestMapping("/system/maintenance")
@Api(tags = "维修费用Controller")
public class HyMaintenanceController extends BaseController
{
    private String prefix = "system/maintenance";

    @Autowired
    private IHyMaintenanceService hyMaintenanceService;

    @RequiresPermissions("system:maintenance:view")
    @GetMapping()
    public String maintenance()
    {
        return prefix + "/maintenance";
    }

    /**
     * 查询维修费用列表
     */
    @ApiOperation("维修费用")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenance", value = "项目实体类hyMaintenance", required = true),
	})
    @RequiresPermissions("system:maintenance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaintenance hyMaintenance)
    {
        startPage();
        List<HyMaintenance> list = hyMaintenanceService.selectHyMaintenanceList(hyMaintenance);
        return getDataTable(list);
    }

    /**
     * 导出维修费用列表
     */
    @ApiOperation("维修费用")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenance", value = "项目实体类hyMaintenance", required = true),
	})
    @RequiresPermissions("system:maintenance:export")
    @Log(title = "维修费用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMaintenance hyMaintenance)
    {
        List<HyMaintenance> list = hyMaintenanceService.selectHyMaintenanceList(hyMaintenance);
        ExcelUtil<HyMaintenance> util = new ExcelUtil<HyMaintenance>(HyMaintenance.class);
        return util.exportExcel(list, "maintenance");
    }

    /**
     * 新增维修费用
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存维修费用
     */
    @ApiOperation("维修费用")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenance", value = "项目实体类hyMaintenance", required = true),
	})
    @RequiresPermissions("system:maintenance:add")
    @Log(title = "维修费用", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyMaintenance hyMaintenance)
    {
        return toAjax(hyMaintenanceService.insertHyMaintenance(hyMaintenance));
    }

    /**
     * 修改维修费用
     */
    @ApiOperation("维修费用")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMaintenance hyMaintenance = hyMaintenanceService.selectHyMaintenanceById(id);
        mmap.put("hyMaintenance", hyMaintenance);
        return prefix + "/edit";
    }

    /**
     * 修改保存维修费用
     */
    @ApiOperation("维修费用")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenance", value = "项目实体类hyMaintenance", required = true),
	})
    @RequiresPermissions("system:maintenance:edit")
    @Log(title = "维修费用", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMaintenance hyMaintenance)
    {
        return toAjax(hyMaintenanceService.updateHyMaintenance(hyMaintenance));
    }

    /**
     * 删除维修费用
     */
    @ApiOperation("维修费用")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:maintenance:remove")
    @Log(title = "维修费用", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMaintenanceService.deleteHyMaintenanceByIds(ids));
    }
}
