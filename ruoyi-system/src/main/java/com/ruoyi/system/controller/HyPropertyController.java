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
import com.ruoyi.system.domain.HyProperty;
import com.ruoyi.system.service.IHyPropertyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物业Controller
 * 
 * @author Administrator
 * @date 2021-03-17
 */
@Controller
@CrossOrigin
@RequestMapping("/system/property")
@Api(tags = "物业Controller")
public class HyPropertyController extends BaseController
{
    private String prefix = "system/property";

    @Autowired
    private IHyPropertyService hyPropertyService;

    @RequiresPermissions("system:property:view")
    @GetMapping()
    public String property()
    {
        return prefix + "/property";
    }

    /**
     * 查询物业列表
     */
    @ApiOperation("物业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProperty", value = "项目实体类hyProperty", required = true),
	})
    @RequiresPermissions("system:property:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyProperty hyProperty)
    {
        startPage();
        List<HyProperty> list = hyPropertyService.selectHyPropertyList(hyProperty);
        return getDataTable(list);
    }

    /**
     * 导出物业列表
     */
    @ApiOperation("物业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProperty", value = "项目实体类hyProperty", required = true),
	})
    @RequiresPermissions("system:property:export")
    @Log(title = "物业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyProperty hyProperty)
    {
        List<HyProperty> list = hyPropertyService.selectHyPropertyList(hyProperty);
        ExcelUtil<HyProperty> util = new ExcelUtil<HyProperty>(HyProperty.class);
        return util.exportExcel(list, "property");
    }

    /**
     * 新增物业
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物业
     */
    @ApiOperation("物业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProperty", value = "项目实体类hyProperty", required = true),
	})
    @RequiresPermissions("system:property:add")
    @Log(title = "物业", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyProperty hyProperty)
    {
        return toAjax(hyPropertyService.insertHyProperty(hyProperty));
    }

    /**
     * 修改物业
     */
    @ApiOperation("物业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyProperty hyProperty = hyPropertyService.selectHyPropertyById(id);
        mmap.put("hyProperty", hyProperty);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业
     */
    @ApiOperation("物业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProperty", value = "项目实体类hyProperty", required = true),
	})
    @RequiresPermissions("system:property:edit")
    @Log(title = "物业", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyProperty hyProperty)
    {
        return toAjax(hyPropertyService.updateHyProperty(hyProperty));
    }

    /**
     * 删除物业
     */
    @ApiOperation("物业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:property:remove")
    @Log(title = "物业", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyPropertyService.deleteHyPropertyByIds(ids));
    }
}
