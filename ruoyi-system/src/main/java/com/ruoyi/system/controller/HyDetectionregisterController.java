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
import com.ruoyi.system.domain.HyDetectionregister;
import com.ruoyi.system.service.IHyDetectionregisterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备检测登记Controller
 * 
 * @author Administrator
 * @date 2021-05-14
 */
@Controller
@RequestMapping("/system/detectionregister")
@Api(tags = "设备检测登记Controller")
public class HyDetectionregisterController extends BaseController
{
    private String prefix = "system/detectionregister";

    @Autowired
    private IHyDetectionregisterService hyDetectionregisterService;

    @RequiresPermissions("system:detectionregister:view")
    @GetMapping()
    public String detectionregister()
    {
        return prefix + "/detectionregister";
    }

    /**
     * 查询设备检测登记列表
     */
    @ApiOperation("设备检测登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionregister", value = "项目实体类hyDetectionregister", required = true),
	})
    @RequiresPermissions("system:detectionregister:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyDetectionregister hyDetectionregister)
    {
        startPage();
        List<HyDetectionregister> list = hyDetectionregisterService.selectHyDetectionregisterList(hyDetectionregister);
        return getDataTable(list);
    }

    /**
     * 导出设备检测登记列表
     */
    @ApiOperation("设备检测登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionregister", value = "项目实体类hyDetectionregister", required = true),
	})
    @RequiresPermissions("system:detectionregister:export")
    @Log(title = "设备检测登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyDetectionregister hyDetectionregister)
    {
        List<HyDetectionregister> list = hyDetectionregisterService.selectHyDetectionregisterList(hyDetectionregister);
        ExcelUtil<HyDetectionregister> util = new ExcelUtil<HyDetectionregister>(HyDetectionregister.class);
        return util.exportExcel(list, "detectionregister");
    }

    /**
     * 新增设备检测登记
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备检测登记
     */
    @ApiOperation("设备检测登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionregister", value = "项目实体类hyDetectionregister", required = true),
	})
    @RequiresPermissions("system:detectionregister:add")
    @Log(title = "设备检测登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyDetectionregister hyDetectionregister)
    {
        return toAjax(hyDetectionregisterService.insertHyDetectionregister(hyDetectionregister));
    }

    /**
     * 修改设备检测登记
     */
    @ApiOperation("设备检测登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyDetectionregister hyDetectionregister = hyDetectionregisterService.selectHyDetectionregisterById(id);
        mmap.put("hyDetectionregister", hyDetectionregister);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备检测登记
     */
    @ApiOperation("设备检测登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionregister", value = "项目实体类hyDetectionregister", required = true),
	})
    @RequiresPermissions("system:detectionregister:edit")
    @Log(title = "设备检测登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyDetectionregister hyDetectionregister)
    {
        return toAjax(hyDetectionregisterService.updateHyDetectionregister(hyDetectionregister));
    }

    /**
     * 删除设备检测登记
     */
    @ApiOperation("设备检测登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:detectionregister:remove")
    @Log(title = "设备检测登记", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyDetectionregisterService.deleteHyDetectionregisterByIds(ids));
    }
}
