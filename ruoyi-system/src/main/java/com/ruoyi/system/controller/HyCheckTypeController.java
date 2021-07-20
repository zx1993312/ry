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
import com.ruoyi.system.domain.HyCheckType;
import com.ruoyi.system.service.IHyCheckTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 巡检类型Controller
 * 
 * @author Administrator
 * @date 2021-07-20
 */
@Controller
@RequestMapping("/system/type")
@Api(tags = "巡检类型Controller")
public class HyCheckTypeController extends BaseController
{
    private String prefix = "system/type";

    @Autowired
    private IHyCheckTypeService hyCheckTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询巡检类型列表
     */
    @ApiOperation("巡检类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckType", value = "项目实体类hyCheckType", required = true),
	})
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCheckType hyCheckType)
    {
        startPage();
        List<HyCheckType> list = hyCheckTypeService.selectHyCheckTypeList(hyCheckType);
        return getDataTable(list);
    }

    /**
     * 导出巡检类型列表
     */
    @ApiOperation("巡检类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckType", value = "项目实体类hyCheckType", required = true),
	})
    @RequiresPermissions("system:type:export")
    @Log(title = "巡检类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCheckType hyCheckType)
    {
        List<HyCheckType> list = hyCheckTypeService.selectHyCheckTypeList(hyCheckType);
        ExcelUtil<HyCheckType> util = new ExcelUtil<HyCheckType>(HyCheckType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增巡检类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存巡检类型
     */
    @ApiOperation("巡检类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckType", value = "项目实体类hyCheckType", required = true),
	})
    @RequiresPermissions("system:type:add")
    @Log(title = "巡检类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCheckType hyCheckType)
    {
        return toAjax(hyCheckTypeService.insertHyCheckType(hyCheckType));
    }

    /**
     * 修改巡检类型
     */
    @ApiOperation("巡检类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCheckType hyCheckType = hyCheckTypeService.selectHyCheckTypeById(id);
        mmap.put("hyCheckType", hyCheckType);
        return prefix + "/edit";
    }

    /**
     * 修改保存巡检类型
     */
    @ApiOperation("巡检类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckType", value = "项目实体类hyCheckType", required = true),
	})
    @RequiresPermissions("system:type:edit")
    @Log(title = "巡检类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCheckType hyCheckType)
    {
        return toAjax(hyCheckTypeService.updateHyCheckType(hyCheckType));
    }

    /**
     * 删除巡检类型
     */
    @ApiOperation("巡检类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:type:remove")
    @Log(title = "巡检类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCheckTypeService.deleteHyCheckTypeByIds(ids));
    }
}
