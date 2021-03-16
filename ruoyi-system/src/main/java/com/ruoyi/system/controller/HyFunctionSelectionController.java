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
import com.ruoyi.system.domain.HyFunctionSelection;
import com.ruoyi.system.service.IHyFunctionSelectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 功能选择Controller
 * 
 * @author Administrator
 * @date 2021-03-16
 */
@Controller
@RequestMapping("/system/selection")
@Api(tags = "功能选择Controller")
public class HyFunctionSelectionController extends BaseController
{
    private String prefix = "system/selection";

    @Autowired
    private IHyFunctionSelectionService hyFunctionSelectionService;

    @RequiresPermissions("system:selection:view")
    @GetMapping()
    public String selection()
    {
        return prefix + "/selection";
    }

    /**
     * 查询功能选择列表
     */
    @ApiOperation("功能选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFunctionSelection", value = "项目实体类hyFunctionSelection", required = true),
	})
    @RequiresPermissions("system:selection:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyFunctionSelection hyFunctionSelection)
    {
        startPage();
        List<HyFunctionSelection> list = hyFunctionSelectionService.selectHyFunctionSelectionList(hyFunctionSelection);
        return getDataTable(list);
    }

    /**
     * 导出功能选择列表
     */
    @ApiOperation("功能选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFunctionSelection", value = "项目实体类hyFunctionSelection", required = true),
	})
    @RequiresPermissions("system:selection:export")
    @Log(title = "功能选择", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyFunctionSelection hyFunctionSelection)
    {
        List<HyFunctionSelection> list = hyFunctionSelectionService.selectHyFunctionSelectionList(hyFunctionSelection);
        ExcelUtil<HyFunctionSelection> util = new ExcelUtil<HyFunctionSelection>(HyFunctionSelection.class);
        return util.exportExcel(list, "selection");
    }

    /**
     * 新增功能选择
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存功能选择
     */
    @ApiOperation("功能选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFunctionSelection", value = "项目实体类hyFunctionSelection", required = true),
	})
    @RequiresPermissions("system:selection:add")
    @Log(title = "功能选择", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyFunctionSelection hyFunctionSelection)
    {
        return toAjax(hyFunctionSelectionService.insertHyFunctionSelection(hyFunctionSelection));
    }

    /**
     * 修改功能选择
     */
    @ApiOperation("功能选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyFunctionSelection hyFunctionSelection = hyFunctionSelectionService.selectHyFunctionSelectionById(id);
        mmap.put("hyFunctionSelection", hyFunctionSelection);
        return prefix + "/edit";
    }

    /**
     * 修改保存功能选择
     */
    @ApiOperation("功能选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFunctionSelection", value = "项目实体类hyFunctionSelection", required = true),
	})
    @RequiresPermissions("system:selection:edit")
    @Log(title = "功能选择", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyFunctionSelection hyFunctionSelection)
    {
        return toAjax(hyFunctionSelectionService.updateHyFunctionSelection(hyFunctionSelection));
    }

    /**
     * 删除功能选择
     */
    @ApiOperation("功能选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:selection:remove")
    @Log(title = "功能选择", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyFunctionSelectionService.deleteHyFunctionSelectionByIds(ids));
    }
}
