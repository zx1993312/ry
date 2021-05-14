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
import com.ruoyi.system.domain.HyDetectionequipment;
import com.ruoyi.system.service.IHyDetectionequipmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检测设备Controller
 * 
 * @author Administrator
 * @date 2021-05-14
 */
@Controller
@RequestMapping("/system/detectionequipment")
@Api(tags = "检测设备Controller")
public class HyDetectionequipmentController extends BaseController
{
    private String prefix = "system/detectionequipment";

    @Autowired
    private IHyDetectionequipmentService hyDetectionequipmentService;

    @RequiresPermissions("system:detectionequipment:view")
    @GetMapping()
    public String detectionequipment()
    {
        return prefix + "/detectionequipment";
    }

    /**
     * 查询检测设备列表
     */
    @ApiOperation("检测设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionequipment", value = "项目实体类hyDetectionequipment", required = true),
	})
    @RequiresPermissions("system:detectionequipment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyDetectionequipment hyDetectionequipment)
    {
        startPage();
        List<HyDetectionequipment> list = hyDetectionequipmentService.selectHyDetectionequipmentList(hyDetectionequipment);
        return getDataTable(list);
    }

    /**
     * 导出检测设备列表
     */
    @ApiOperation("检测设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionequipment", value = "项目实体类hyDetectionequipment", required = true),
	})
    @RequiresPermissions("system:detectionequipment:export")
    @Log(title = "检测设备", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyDetectionequipment hyDetectionequipment)
    {
        List<HyDetectionequipment> list = hyDetectionequipmentService.selectHyDetectionequipmentList(hyDetectionequipment);
        ExcelUtil<HyDetectionequipment> util = new ExcelUtil<HyDetectionequipment>(HyDetectionequipment.class);
        return util.exportExcel(list, "detectionequipment");
    }

    /**
     * 新增检测设备
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存检测设备
     */
    @ApiOperation("检测设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionequipment", value = "项目实体类hyDetectionequipment", required = true),
	})
    @RequiresPermissions("system:detectionequipment:add")
    @Log(title = "检测设备", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyDetectionequipment hyDetectionequipment)
    {
        return toAjax(hyDetectionequipmentService.insertHyDetectionequipment(hyDetectionequipment));
    }

    /**
     * 修改检测设备
     */
    @ApiOperation("检测设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyDetectionequipment hyDetectionequipment = hyDetectionequipmentService.selectHyDetectionequipmentById(id);
        mmap.put("hyDetectionequipment", hyDetectionequipment);
        return prefix + "/edit";
    }

    /**
     * 修改保存检测设备
     */
    @ApiOperation("检测设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionequipment", value = "项目实体类hyDetectionequipment", required = true),
	})
    @RequiresPermissions("system:detectionequipment:edit")
    @Log(title = "检测设备", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyDetectionequipment hyDetectionequipment)
    {
        return toAjax(hyDetectionequipmentService.updateHyDetectionequipment(hyDetectionequipment));
    }

    /**
     * 删除检测设备
     */
    @ApiOperation("检测设备")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:detectionequipment:remove")
    @Log(title = "检测设备", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyDetectionequipmentService.deleteHyDetectionequipmentByIds(ids));
    }
}
