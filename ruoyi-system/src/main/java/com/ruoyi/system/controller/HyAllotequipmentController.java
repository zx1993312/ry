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
import com.ruoyi.system.domain.HyAllotequipment;
import com.ruoyi.system.service.IHyAllotequipmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 调拨设备Controller
 * 
 * @author Administrator
 * @date 2021-05-17
 */
@Controller
@CrossOrigin
@RequestMapping("/system/allotequipment")
@Api(tags = "调拨设备Controller")
public class HyAllotequipmentController extends BaseController
{
    private String prefix = "system/allotequipment";

    @Autowired
    private IHyAllotequipmentService hyAllotequipmentService;

    @RequiresPermissions("system:allotequipment:view")
    @GetMapping()
    public String allotequipment()
    {
        return prefix + "/allotequipment";
    }

    /**
     * 查询调拨设备列表
     */
    @ApiOperation("调拨设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAllotequipment", value = "项目实体类hyAllotequipment", required = true),
	})
    @RequiresPermissions("system:allotequipment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyAllotequipment hyAllotequipment)
    {
        startPage();
        List<HyAllotequipment> list = hyAllotequipmentService.selectHyAllotequipmentList(hyAllotequipment);
        return getDataTable(list);
    }

    /**
     * 导出调拨设备列表
     */
    @ApiOperation("调拨设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAllotequipment", value = "项目实体类hyAllotequipment", required = true),
	})
    @RequiresPermissions("system:allotequipment:export")
    @Log(title = "调拨设备", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyAllotequipment hyAllotequipment)
    {
        List<HyAllotequipment> list = hyAllotequipmentService.selectHyAllotequipmentList(hyAllotequipment);
        ExcelUtil<HyAllotequipment> util = new ExcelUtil<HyAllotequipment>(HyAllotequipment.class);
        return util.exportExcel(list, "allotequipment");
    }

    /**
     * 新增调拨设备
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存调拨设备
     */
    @ApiOperation("调拨设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAllotequipment", value = "项目实体类hyAllotequipment", required = true),
	})
    @RequiresPermissions("system:allotequipment:add")
    @Log(title = "调拨设备", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyAllotequipment hyAllotequipment)
    {
        return toAjax(hyAllotequipmentService.insertHyAllotequipment(hyAllotequipment));
    }

    /**
     * 修改调拨设备
     */
    @ApiOperation("调拨设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyAllotequipment hyAllotequipment = hyAllotequipmentService.selectHyAllotequipmentById(id);
        mmap.put("hyAllotequipment", hyAllotequipment);
        return prefix + "/edit";
    }

    /**
     * 修改保存调拨设备
     */
    @ApiOperation("调拨设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAllotequipment", value = "项目实体类hyAllotequipment", required = true),
	})
    @RequiresPermissions("system:allotequipment:edit")
    @Log(title = "调拨设备", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyAllotequipment hyAllotequipment)
    {
        return toAjax(hyAllotequipmentService.updateHyAllotequipment(hyAllotequipment));
    }

    /**
     * 删除调拨设备
     */
    @ApiOperation("调拨设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:allotequipment:remove")
    @Log(title = "调拨设备", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyAllotequipmentService.deleteHyAllotequipmentByIds(ids));
    }
}
