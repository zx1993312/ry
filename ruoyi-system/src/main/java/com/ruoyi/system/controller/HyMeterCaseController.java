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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyMeterCase;
import com.ruoyi.system.domain.MeterAndCase;
import com.ruoyi.system.service.IHyMeterCaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 箱
Controller
 * 
 * @author Administrator
 * @date 2021-01-12
 */
@Controller
@RequestMapping("/system/case")
@Api(tags = "箱Controller")
public class HyMeterCaseController extends BaseController
{
    private String prefix = "system/case";

    @Autowired
    private IHyMeterCaseService hyMeterCaseService;

    @RequiresPermissions("system:case:view")
    @GetMapping()
    public String cases()
    {
        return prefix + "/case";
    }

    /**
     * 查询箱
列表
     */
    @ApiOperation("箱")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMeterCase", value = "项目实体类hyMeterCase", required = true),
	})
    @RequiresPermissions("system:case:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMeterCase hyMeterCase)
    {
        startPage();
        List<HyMeterCase> list = hyMeterCaseService.selectHyMeterCaseList(hyMeterCase);
        return getDataTable(list);
    }

    /**
     * 导出箱
列表
     */
    @ApiOperation("箱")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMeterCase", value = "项目实体类hyMeterCase", required = true),
	})
    @RequiresPermissions("system:case:export")
    @Log(title = "箱", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMeterCase hyMeterCase)
    {
        List<HyMeterCase> list = hyMeterCaseService.selectHyMeterCaseList(hyMeterCase);
        ExcelUtil<HyMeterCase> util = new ExcelUtil<HyMeterCase>(HyMeterCase.class);
        return util.exportExcel(list, "case");
    }

    /**
     * 新增箱

     */
    @GetMapping("/add")
    public String add(MeterAndCase meterAndCase)
    {
        return prefix + "/add";
    }

    /**
     * 新增保存箱

     */
    @ApiOperation("箱")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMeterCase", value = "项目实体类hyMeterCase", required = true),
	})
    @RequiresPermissions("system:case:add")
    @Log(title = "箱", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MeterAndCase meterAndCase)
    {
        return toAjax(hyMeterCaseService.insertHyMeterCase(meterAndCase));
    }

    /**
     * 修改箱

     */
    @ApiOperation("箱")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMeterCase hyMeterCase = hyMeterCaseService.selectHyMeterCaseById(id);
        mmap.put("hyMeterCase", hyMeterCase);
        return prefix + "/edit";
    }

    /**
     * 修改保存箱

     */
    @ApiOperation("箱")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMeterCase", value = "项目实体类hyMeterCase", required = true),
	})
    @RequiresPermissions("system:case:edit")
    @Log(title = "箱", businessType = BusinessType.UPDATE)
    @RequestMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMeterCase hyMeterCase)
    {
        return toAjax(hyMeterCaseService.updateHyMeterCase(hyMeterCase));
    }

    /**
     * 删除箱

     */
    @ApiOperation("箱")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:case:remove")
    @Log(title = "箱", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMeterCaseService.deleteHyMeterCaseByIds(ids));
    }
}
