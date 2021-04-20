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
import com.ruoyi.system.domain.HyMaterial;
import com.ruoyi.system.service.IHyMaterialService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物料Controller
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/material")
@Api(tags = "物料Controller")
public class HyMaterialController extends BaseController
{
    private String prefix = "system/material";

    @Autowired
    private IHyMaterialService hyMaterialService;

    @RequiresPermissions("system:material:view")
    @GetMapping()
    public String material()
    {
        return prefix + "/material";
    }

    /**
     * 查询物料列表
     */
    @ApiOperation("物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaterial", value = "项目实体类hyMaterial", required = true),
	})
    @RequiresPermissions("system:material:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaterial hyMaterial)
    {
        startPage();
        List<HyMaterial> list = hyMaterialService.selectHyMaterialList(hyMaterial);
        return getDataTable(list);
    }

    /**
     * 导出物料列表
     */
    @ApiOperation("物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaterial", value = "项目实体类hyMaterial", required = true),
	})
    @RequiresPermissions("system:material:export")
    @Log(title = "物料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMaterial hyMaterial)
    {
        List<HyMaterial> list = hyMaterialService.selectHyMaterialList(hyMaterial);
        ExcelUtil<HyMaterial> util = new ExcelUtil<HyMaterial>(HyMaterial.class);
        return util.exportExcel(list, "material");
    }

    /**
     * 新增物料
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物料
     */
    @ApiOperation("物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaterial", value = "项目实体类hyMaterial", required = true),
	})
    @RequiresPermissions("system:material:add")
    @Log(title = "物料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyMaterial hyMaterial)
    {
        return toAjax(hyMaterialService.insertHyMaterial(hyMaterial));
    }

    /**
     * 修改物料
     */
    @ApiOperation("物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMaterial hyMaterial = hyMaterialService.selectHyMaterialById(id);
        mmap.put("hyMaterial", hyMaterial);
        return prefix + "/edit";
    }

    /**
     * 修改保存物料
     */
    @ApiOperation("物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaterial", value = "项目实体类hyMaterial", required = true),
	})
    @RequiresPermissions("system:material:edit")
    @Log(title = "物料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMaterial hyMaterial)
    {
        return toAjax(hyMaterialService.updateHyMaterial(hyMaterial));
    }

    /**
     * 删除物料
     */
    @ApiOperation("物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:material:remove")
    @Log(title = "物料", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMaterialService.deleteHyMaterialByIds(ids));
    }
}
