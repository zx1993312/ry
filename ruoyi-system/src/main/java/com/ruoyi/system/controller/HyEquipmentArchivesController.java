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
import com.ruoyi.system.domain.HyEquipmentArchives;
import com.ruoyi.system.service.IHyEquipmentArchivesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备档案Controller
 * 
 * @author Administrator
 * @date 2021-05-08
 */
@Controller
@CrossOrigin
@RequestMapping("/system/archives")
@Api(tags = "设备档案Controller")
public class HyEquipmentArchivesController extends BaseController
{
    private String prefix = "system/archives";

    @Autowired
    private IHyEquipmentArchivesService hyEquipmentArchivesService;

    @RequiresPermissions("system:archives:view")
    @GetMapping()
    public String archives()
    {
        return prefix + "/archives";
    }

    /**
     * 查询设备档案列表
     */
    @ApiOperation("设备档案")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEquipmentArchives", value = "项目实体类hyEquipmentArchives", required = true),
	})
    @RequiresPermissions("system:archives:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyEquipmentArchives hyEquipmentArchives)
    {
        startPage();
        List<HyEquipmentArchives> list = hyEquipmentArchivesService.selectHyEquipmentArchivesList(hyEquipmentArchives);
        return getDataTable(list);
    }

    /**
     * 导出设备档案列表
     */
    @ApiOperation("设备档案")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEquipmentArchives", value = "项目实体类hyEquipmentArchives", required = true),
	})
    @RequiresPermissions("system:archives:export")
    @Log(title = "设备档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyEquipmentArchives hyEquipmentArchives)
    {
        List<HyEquipmentArchives> list = hyEquipmentArchivesService.selectHyEquipmentArchivesList(hyEquipmentArchives);
        ExcelUtil<HyEquipmentArchives> util = new ExcelUtil<HyEquipmentArchives>(HyEquipmentArchives.class);
        return util.exportExcel(list, "archives");
    }

    /**
     * 新增设备档案
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备档案
     */
    @ApiOperation("设备档案")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEquipmentArchives", value = "项目实体类hyEquipmentArchives", required = true),
	})
    @RequiresPermissions("system:archives:add")
    @Log(title = "设备档案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyEquipmentArchives hyEquipmentArchives)
    {
        return toAjax(hyEquipmentArchivesService.insertHyEquipmentArchives(hyEquipmentArchives));
    }

    /**
     * 修改设备档案
     */
    @ApiOperation("设备档案")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyEquipmentArchives hyEquipmentArchives = hyEquipmentArchivesService.selectHyEquipmentArchivesById(id);
        mmap.put("hyEquipmentArchives", hyEquipmentArchives);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备档案
     */
    @ApiOperation("设备档案")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEquipmentArchives", value = "项目实体类hyEquipmentArchives", required = true),
	})
    @RequiresPermissions("system:archives:edit")
    @Log(title = "设备档案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyEquipmentArchives hyEquipmentArchives)
    {
        return toAjax(hyEquipmentArchivesService.updateHyEquipmentArchives(hyEquipmentArchives));
    }

    /**
     * 删除设备档案
     */
    @ApiOperation("设备档案")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:archives:remove")
    @Log(title = "设备档案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyEquipmentArchivesService.deleteHyEquipmentArchivesByIds(ids));
    }
}
