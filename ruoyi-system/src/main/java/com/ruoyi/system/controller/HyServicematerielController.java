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
import com.ruoyi.system.domain.HyServicemateriel;
import com.ruoyi.system.service.IHyServicematerielService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备维修物料Controller
 * 
 * @author Administrator
 * @date 2021-05-13
 */
@Controller
@RequestMapping("/system/servicemateriel")
@Api(tags = "设备维修物料Controller")
public class HyServicematerielController extends BaseController
{
    private String prefix = "system/servicemateriel";

    @Autowired
    private IHyServicematerielService hyServicematerielService;

    @RequiresPermissions("system:servicemateriel:view")
    @GetMapping()
    public String servicemateriel()
    {
        return prefix + "/servicemateriel";
    }

    /**
     * 查询设备维修物料列表
     */
    @ApiOperation("设备维修物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServicemateriel", value = "项目实体类hyServicemateriel", required = true),
	})
    @RequiresPermissions("system:servicemateriel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyServicemateriel hyServicemateriel)
    {
        startPage();
        List<HyServicemateriel> list = hyServicematerielService.selectHyServicematerielList(hyServicemateriel);
        return getDataTable(list);
    }

    /**
     * 导出设备维修物料列表
     */
    @ApiOperation("设备维修物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServicemateriel", value = "项目实体类hyServicemateriel", required = true),
	})
    @RequiresPermissions("system:servicemateriel:export")
    @Log(title = "设备维修物料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyServicemateriel hyServicemateriel)
    {
        List<HyServicemateriel> list = hyServicematerielService.selectHyServicematerielList(hyServicemateriel);
        ExcelUtil<HyServicemateriel> util = new ExcelUtil<HyServicemateriel>(HyServicemateriel.class);
        return util.exportExcel(list, "servicemateriel");
    }

    /**
     * 新增设备维修物料
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备维修物料
     */
    @ApiOperation("设备维修物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServicemateriel", value = "项目实体类hyServicemateriel", required = true),
	})
    @RequiresPermissions("system:servicemateriel:add")
    @Log(title = "设备维修物料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyServicemateriel hyServicemateriel)
    {
        return toAjax(hyServicematerielService.insertHyServicemateriel(hyServicemateriel));
    }

    /**
     * 修改设备维修物料
     */
    @ApiOperation("设备维修物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyServicemateriel hyServicemateriel = hyServicematerielService.selectHyServicematerielById(id);
        mmap.put("hyServicemateriel", hyServicemateriel);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备维修物料
     */
    @ApiOperation("设备维修物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServicemateriel", value = "项目实体类hyServicemateriel", required = true),
	})
    @RequiresPermissions("system:servicemateriel:edit")
    @Log(title = "设备维修物料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyServicemateriel hyServicemateriel)
    {
        return toAjax(hyServicematerielService.updateHyServicemateriel(hyServicemateriel));
    }

    /**
     * 删除设备维修物料
     */
    @ApiOperation("设备维修物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:servicemateriel:remove")
    @Log(title = "设备维修物料", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyServicematerielService.deleteHyServicematerielByIds(ids));
    }
}
