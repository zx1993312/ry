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
import com.ruoyi.system.domain.HyMaintenanceplandetail;
import com.ruoyi.system.service.IHyMaintenanceplandetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备保养计划执行安排Controller
 * 
 * @author Administrator
 * @date 2021-05-11
 */
@Controller
@RequestMapping("/system/maintenanceplandetail")
@Api(tags = "设备保养计划执行安排Controller")
public class HyMaintenanceplandetailController extends BaseController
{
    private String prefix = "system/maintenanceplandetail";

    @Autowired
    private IHyMaintenanceplandetailService hyMaintenanceplandetailService;

    @RequiresPermissions("system:maintenanceplandetail:view")
    @GetMapping()
    public String maintenanceplandetail()
    {
        return prefix + "/maintenanceplandetail";
    }

    /**
     * 查询设备保养计划执行安排列表
     */
    @ApiOperation("设备保养计划执行安排")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceplandetail", value = "项目实体类hyMaintenanceplandetail", required = true),
	})
    @RequiresPermissions("system:maintenanceplandetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaintenanceplandetail hyMaintenanceplandetail)
    {
        startPage();
        List<HyMaintenanceplandetail> list = hyMaintenanceplandetailService.selectHyMaintenanceplandetailList(hyMaintenanceplandetail);
        return getDataTable(list);
    }

    /**
     * 导出设备保养计划执行安排列表
     */
    @ApiOperation("设备保养计划执行安排")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceplandetail", value = "项目实体类hyMaintenanceplandetail", required = true),
	})
    @RequiresPermissions("system:maintenanceplandetail:export")
    @Log(title = "设备保养计划执行安排", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMaintenanceplandetail hyMaintenanceplandetail)
    {
        List<HyMaintenanceplandetail> list = hyMaintenanceplandetailService.selectHyMaintenanceplandetailList(hyMaintenanceplandetail);
        ExcelUtil<HyMaintenanceplandetail> util = new ExcelUtil<HyMaintenanceplandetail>(HyMaintenanceplandetail.class);
        return util.exportExcel(list, "maintenanceplandetail");
    }

    /**
     * 新增设备保养计划执行安排
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备保养计划执行安排
     */
    @ApiOperation("设备保养计划执行安排")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceplandetail", value = "项目实体类hyMaintenanceplandetail", required = true),
	})
    @RequiresPermissions("system:maintenanceplandetail:add")
    @Log(title = "设备保养计划执行安排", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyMaintenanceplandetail hyMaintenanceplandetail)
    {
        return toAjax(hyMaintenanceplandetailService.insertHyMaintenanceplandetail(hyMaintenanceplandetail));
    }

    /**
     * 修改设备保养计划执行安排
     */
    @ApiOperation("设备保养计划执行安排")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMaintenanceplandetail hyMaintenanceplandetail = hyMaintenanceplandetailService.selectHyMaintenanceplandetailById(id);
        mmap.put("hyMaintenanceplandetail", hyMaintenanceplandetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备保养计划执行安排
     */
    @ApiOperation("设备保养计划执行安排")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceplandetail", value = "项目实体类hyMaintenanceplandetail", required = true),
	})
    @RequiresPermissions("system:maintenanceplandetail:edit")
    @Log(title = "设备保养计划执行安排", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMaintenanceplandetail hyMaintenanceplandetail)
    {
        return toAjax(hyMaintenanceplandetailService.updateHyMaintenanceplandetail(hyMaintenanceplandetail));
    }

    /**
     * 删除设备保养计划执行安排
     */
    @ApiOperation("设备保养计划执行安排")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:maintenanceplandetail:remove")
    @Log(title = "设备保养计划执行安排", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMaintenanceplandetailService.deleteHyMaintenanceplandetailByIds(ids));
    }
}
