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
import com.ruoyi.system.domain.HyMaintenanceproject;
import com.ruoyi.system.service.IHyMaintenanceprojectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 保养项目Controller
 * 
 * @author Administrator
 * @date 2021-05-10
 */
@Controller
@CrossOrigin
@RequestMapping("/system/maintenanceproject")
@Api(tags = "保养项目Controller")
public class HyMaintenanceprojectController extends BaseController
{
    private String prefix = "system/maintenanceproject";

    @Autowired
    private IHyMaintenanceprojectService hyMaintenanceprojectService;

    @RequiresPermissions("system:maintenanceproject:view")
    @GetMapping()
    public String maintenanceproject()
    {
        return prefix + "/maintenanceproject";
    }

    /**
     * 查询保养项目列表
     */
    @ApiOperation("保养项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceproject", value = "项目实体类hyMaintenanceproject", required = true),
	})
    @RequiresPermissions("system:maintenanceproject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaintenanceproject hyMaintenanceproject)
    {
        startPage();
        List<HyMaintenanceproject> list = hyMaintenanceprojectService.selectHyMaintenanceprojectList(hyMaintenanceproject);
        return getDataTable(list);
    }

    /**
     * 导出保养项目列表
     */
    @ApiOperation("保养项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceproject", value = "项目实体类hyMaintenanceproject", required = true),
	})
    @RequiresPermissions("system:maintenanceproject:export")
    @Log(title = "保养项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMaintenanceproject hyMaintenanceproject)
    {
        List<HyMaintenanceproject> list = hyMaintenanceprojectService.selectHyMaintenanceprojectList(hyMaintenanceproject);
        ExcelUtil<HyMaintenanceproject> util = new ExcelUtil<HyMaintenanceproject>(HyMaintenanceproject.class);
        return util.exportExcel(list, "maintenanceproject");
    }

    /**
     * 新增保养项目
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存保养项目
     */
    @ApiOperation("保养项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceproject", value = "项目实体类hyMaintenanceproject", required = true),
	})
    @RequiresPermissions("system:maintenanceproject:add")
    @Log(title = "保养项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyMaintenanceproject hyMaintenanceproject)
    {
        return toAjax(hyMaintenanceprojectService.insertHyMaintenanceproject(hyMaintenanceproject));
    }

    /**
     * 修改保养项目
     */
    @ApiOperation("保养项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMaintenanceproject hyMaintenanceproject = hyMaintenanceprojectService.selectHyMaintenanceprojectById(id);
        mmap.put("hyMaintenanceproject", hyMaintenanceproject);
        return prefix + "/edit";
    }

    /**
     * 修改保存保养项目
     */
    @ApiOperation("保养项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceproject", value = "项目实体类hyMaintenanceproject", required = true),
	})
    @RequiresPermissions("system:maintenanceproject:edit")
    @Log(title = "保养项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMaintenanceproject hyMaintenanceproject)
    {
        return toAjax(hyMaintenanceprojectService.updateHyMaintenanceproject(hyMaintenanceproject));
    }

    /**
     * 删除保养项目
     */
    @ApiOperation("保养项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:maintenanceproject:remove")
    @Log(title = "保养项目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMaintenanceprojectService.deleteHyMaintenanceprojectByIds(ids));
    }
}
