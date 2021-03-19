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
import com.ruoyi.system.domain.HyPrinter;
import com.ruoyi.system.service.IHyPrinterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 打印机配置Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@RequestMapping("/system/printer")
@Api(tags = "打印机配置Controller")
public class HyPrinterController extends BaseController
{
    private String prefix = "system/printer";

    @Autowired
    private IHyPrinterService hyPrinterService;

    @RequiresPermissions("system:printer:view")
    @GetMapping()
    public String printer()
    {
        return prefix + "/printer";
    }

    /**
     * 查询打印机配置列表
     */
    @ApiOperation("打印机配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPrinter", value = "项目实体类hyPrinter", required = true),
	})
    @RequiresPermissions("system:printer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyPrinter hyPrinter)
    {
        startPage();
        List<HyPrinter> list = hyPrinterService.selectHyPrinterList(hyPrinter);
        return getDataTable(list);
    }

    /**
     * 导出打印机配置列表
     */
    @ApiOperation("打印机配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPrinter", value = "项目实体类hyPrinter", required = true),
	})
    @RequiresPermissions("system:printer:export")
    @Log(title = "打印机配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyPrinter hyPrinter)
    {
        List<HyPrinter> list = hyPrinterService.selectHyPrinterList(hyPrinter);
        ExcelUtil<HyPrinter> util = new ExcelUtil<HyPrinter>(HyPrinter.class);
        return util.exportExcel(list, "printer");
    }

    /**
     * 新增打印机配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存打印机配置
     */
    @ApiOperation("打印机配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPrinter", value = "项目实体类hyPrinter", required = true),
	})
    @RequiresPermissions("system:printer:add")
    @Log(title = "打印机配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyPrinter hyPrinter)
    {
        return toAjax(hyPrinterService.insertHyPrinter(hyPrinter));
    }

    /**
     * 修改打印机配置
     */
    @ApiOperation("打印机配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyPrinter hyPrinter = hyPrinterService.selectHyPrinterById(id);
        mmap.put("hyPrinter", hyPrinter);
        return prefix + "/edit";
    }

    /**
     * 修改保存打印机配置
     */
    @ApiOperation("打印机配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPrinter", value = "项目实体类hyPrinter", required = true),
	})
    @RequiresPermissions("system:printer:edit")
    @Log(title = "打印机配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyPrinter hyPrinter)
    {
        return toAjax(hyPrinterService.updateHyPrinter(hyPrinter));
    }

    /**
     * 删除打印机配置
     */
    @ApiOperation("打印机配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:printer:remove")
    @Log(title = "打印机配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyPrinterService.deleteHyPrinterByIds(ids));
    }
}
