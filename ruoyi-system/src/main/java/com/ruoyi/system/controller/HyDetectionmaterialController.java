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
import com.ruoyi.system.domain.HyDetectionmaterial;
import com.ruoyi.system.service.IHyDetectionmaterialService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备检测物料Controller
 * 
 * @author Administrator
 * @date 2021-05-14
 */
@Controller
@CrossOrigin
@RequestMapping("/system/detectionmaterial")
@Api(tags = "设备检测物料Controller")
public class HyDetectionmaterialController extends BaseController
{
    private String prefix = "system/detectionmaterial";

    @Autowired
    private IHyDetectionmaterialService hyDetectionmaterialService;

    @RequiresPermissions("system:detectionmaterial:view")
    @GetMapping()
    public String detectionmaterial()
    {
        return prefix + "/detectionmaterial";
    }

    /**
     * 查询设备检测物料列表
     */
    @ApiOperation("设备检测物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionmaterial", value = "项目实体类hyDetectionmaterial", required = true),
	})
    @RequiresPermissions("system:detectionmaterial:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyDetectionmaterial hyDetectionmaterial)
    {
        startPage();
        List<HyDetectionmaterial> list = hyDetectionmaterialService.selectHyDetectionmaterialList(hyDetectionmaterial);
        return getDataTable(list);
    }

    /**
     * 导出设备检测物料列表
     */
    @ApiOperation("设备检测物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionmaterial", value = "项目实体类hyDetectionmaterial", required = true),
	})
    @RequiresPermissions("system:detectionmaterial:export")
    @Log(title = "设备检测物料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyDetectionmaterial hyDetectionmaterial)
    {
        List<HyDetectionmaterial> list = hyDetectionmaterialService.selectHyDetectionmaterialList(hyDetectionmaterial);
        ExcelUtil<HyDetectionmaterial> util = new ExcelUtil<HyDetectionmaterial>(HyDetectionmaterial.class);
        return util.exportExcel(list, "detectionmaterial");
    }

    /**
     * 新增设备检测物料
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备检测物料
     */
    @ApiOperation("设备检测物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionmaterial", value = "项目实体类hyDetectionmaterial", required = true),
	})
    @RequiresPermissions("system:detectionmaterial:add")
    @Log(title = "设备检测物料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyDetectionmaterial hyDetectionmaterial)
    {
        return toAjax(hyDetectionmaterialService.insertHyDetectionmaterial(hyDetectionmaterial));
    }

    /**
     * 修改设备检测物料
     */
    @ApiOperation("设备检测物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyDetectionmaterial hyDetectionmaterial = hyDetectionmaterialService.selectHyDetectionmaterialById(id);
        mmap.put("hyDetectionmaterial", hyDetectionmaterial);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备检测物料
     */
    @ApiOperation("设备检测物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionmaterial", value = "项目实体类hyDetectionmaterial", required = true),
	})
    @RequiresPermissions("system:detectionmaterial:edit")
    @Log(title = "设备检测物料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyDetectionmaterial hyDetectionmaterial)
    {
        return toAjax(hyDetectionmaterialService.updateHyDetectionmaterial(hyDetectionmaterial));
    }

    /**
     * 删除设备检测物料
     */
    @ApiOperation("设备检测物料")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:detectionmaterial:remove")
    @Log(title = "设备检测物料", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyDetectionmaterialService.deleteHyDetectionmaterialByIds(ids));
    }
}
