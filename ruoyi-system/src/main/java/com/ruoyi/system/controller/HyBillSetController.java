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
import com.ruoyi.system.domain.HyBillSet;
import com.ruoyi.system.service.IHyBillSetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 票据设置Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/system/set")
@Api(tags = "票据设置Controller")
public class HyBillSetController extends BaseController
{
    private String prefix = "system/set";

    @Autowired
    private IHyBillSetService hyBillSetService;

    @RequiresPermissions("system:set:view")
    @GetMapping()
    public String set()
    {
        return prefix + "/set";
    }

    /**
     * 查询票据设置列表
     */
    @ApiOperation("票据设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBillSet", value = "项目实体类hyBillSet", required = true),
	})
    @RequiresPermissions("system:set:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyBillSet hyBillSet)
    {
        startPage();
        List<HyBillSet> list = hyBillSetService.selectHyBillSetList(hyBillSet);
        return getDataTable(list);
    }

    /**
     * 导出票据设置列表
     */
    @ApiOperation("票据设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBillSet", value = "项目实体类hyBillSet", required = true),
	})
    @RequiresPermissions("system:set:export")
    @Log(title = "票据设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyBillSet hyBillSet)
    {
        List<HyBillSet> list = hyBillSetService.selectHyBillSetList(hyBillSet);
        ExcelUtil<HyBillSet> util = new ExcelUtil<HyBillSet>(HyBillSet.class);
        return util.exportExcel(list, "set");
    }

    /**
     * 新增票据设置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存票据设置
     */
    @ApiOperation("票据设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBillSet", value = "项目实体类hyBillSet", required = true),
	})
    @RequiresPermissions("system:set:add")
    @Log(title = "票据设置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyBillSet hyBillSet)
    {
        return toAjax(hyBillSetService.insertHyBillSet(hyBillSet));
    }

    /**
     * 修改票据设置
     */
    @ApiOperation("票据设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyBillSet hyBillSet = hyBillSetService.selectHyBillSetById(id);
        mmap.put("hyBillSet", hyBillSet);
        return prefix + "/edit";
    }

    /**
     * 修改保存票据设置
     */
    @ApiOperation("票据设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBillSet", value = "项目实体类hyBillSet", required = true),
	})
    @RequiresPermissions("system:set:edit")
    @Log(title = "票据设置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyBillSet hyBillSet)
    {
        return toAjax(hyBillSetService.updateHyBillSet(hyBillSet));
    }

    /**
     * 删除票据设置
     */
    @ApiOperation("票据设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:set:remove")
    @Log(title = "票据设置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyBillSetService.deleteHyBillSetByIds(ids));
    }
}
