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
import com.ruoyi.system.domain.HyProportionSet;
import com.ruoyi.system.service.IHyProportionSetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收费比例设置Controller
 * 
 * @author Administrator
 * @date 2021-01-23
 */
@Controller
@RequestMapping("/system/proportionSet")
@Api(tags = "收费比例设置Controller")
public class HyProportionSetController extends BaseController
{
    private String prefix = "system/proportionSet";

    @Autowired
    private IHyProportionSetService hyProportionSetService;

    @RequiresPermissions("system:set:view")
    @GetMapping()
    public String set()
    {
        return prefix + "/set";
    }

    /**
     * 查询收费比例设置列表
     */
    @ApiOperation("收费比例设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProportionSet", value = "项目实体类hyProportionSet", required = true),
	})
    @RequiresPermissions("system:set:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyProportionSet hyProportionSet)
    {
        startPage();
        List<HyProportionSet> list = hyProportionSetService.selectHyProportionSetList(hyProportionSet);
        return getDataTable(list);
    }

    /**
     * 导出收费比例设置列表
     */
    @ApiOperation("收费比例设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProportionSet", value = "项目实体类hyProportionSet", required = true),
	})
    @RequiresPermissions("system:set:export")
    @Log(title = "收费比例设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyProportionSet hyProportionSet)
    {
        List<HyProportionSet> list = hyProportionSetService.selectHyProportionSetList(hyProportionSet);
        ExcelUtil<HyProportionSet> util = new ExcelUtil<HyProportionSet>(HyProportionSet.class);
        return util.exportExcel(list, "set");
    }

    /**
     * 新增收费比例设置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存收费比例设置
     */
    @ApiOperation("收费比例设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProportionSet", value = "项目实体类hyProportionSet", required = true),
	})
    @RequiresPermissions("system:set:add")
    @Log(title = "收费比例设置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyProportionSet hyProportionSet)
    {
        return toAjax(hyProportionSetService.insertHyProportionSet(hyProportionSet));
    }

    /**
     * 修改收费比例设置
     */
    @ApiOperation("收费比例设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyProportionSet hyProportionSet = hyProportionSetService.selectHyProportionSetById(id);
        mmap.put("hyProportionSet", hyProportionSet);
        return prefix + "/edit";
    }

    /**
     * 修改保存收费比例设置
     */
    @ApiOperation("收费比例设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProportionSet", value = "项目实体类hyProportionSet", required = true),
	})
    @RequiresPermissions("system:set:edit")
    @Log(title = "收费比例设置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyProportionSet hyProportionSet)
    {
        return toAjax(hyProportionSetService.updateHyProportionSet(hyProportionSet));
    }

    /**
     * 删除收费比例设置
     */
    @ApiOperation("收费比例设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:set:remove")
    @Log(title = "收费比例设置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyProportionSetService.deleteHyProportionSetByIds(ids));
    }
}
