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
import com.ruoyi.system.domain.HyLifting;
import com.ruoyi.system.service.IHyLiftingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提料人Controller
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/lifting")
@Api(tags = "提料人Controller")
public class HyLiftingController extends BaseController
{
    private String prefix = "system/lifting";

    @Autowired
    private IHyLiftingService hyLiftingService;

    @RequiresPermissions("system:lifting:view")
    @GetMapping()
    public String lifting()
    {
        return prefix + "/lifting";
    }

    /**
     * 查询提料人列表
     */
    @ApiOperation("提料人")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyLifting", value = "项目实体类hyLifting", required = true),
	})
    @RequiresPermissions("system:lifting:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyLifting hyLifting)
    {
        startPage();
        List<HyLifting> list = hyLiftingService.selectHyLiftingList(hyLifting);
        return getDataTable(list);
    }

    /**
     * 导出提料人列表
     */
    @ApiOperation("提料人")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyLifting", value = "项目实体类hyLifting", required = true),
	})
    @RequiresPermissions("system:lifting:export")
    @Log(title = "提料人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyLifting hyLifting)
    {
        List<HyLifting> list = hyLiftingService.selectHyLiftingList(hyLifting);
        ExcelUtil<HyLifting> util = new ExcelUtil<HyLifting>(HyLifting.class);
        return util.exportExcel(list, "lifting");
    }

    /**
     * 新增提料人
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存提料人
     */
    @ApiOperation("提料人")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyLifting", value = "项目实体类hyLifting", required = true),
	})
    @RequiresPermissions("system:lifting:add")
    @Log(title = "提料人", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyLifting hyLifting)
    {
        return toAjax(hyLiftingService.insertHyLifting(hyLifting));
    }

    /**
     * 修改提料人
     */
    @ApiOperation("提料人")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyLifting hyLifting = hyLiftingService.selectHyLiftingById(id);
        mmap.put("hyLifting", hyLifting);
        return prefix + "/edit";
    }

    /**
     * 修改保存提料人
     */
    @ApiOperation("提料人")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyLifting", value = "项目实体类hyLifting", required = true),
	})
    @RequiresPermissions("system:lifting:edit")
    @Log(title = "提料人", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyLifting hyLifting)
    {
        return toAjax(hyLiftingService.updateHyLifting(hyLifting));
    }

    /**
     * 删除提料人
     */
    @ApiOperation("提料人")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:lifting:remove")
    @Log(title = "提料人", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyLiftingService.deleteHyLiftingByIds(ids));
    }
}
