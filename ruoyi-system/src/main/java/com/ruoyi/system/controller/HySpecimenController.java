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
import com.ruoyi.system.domain.HySpecimen;
import com.ruoyi.system.service.IHySpecimenService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 接收员Controller
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/specimen")
@Api(tags = "接收员Controller")
public class HySpecimenController extends BaseController
{
    private String prefix = "system/specimen";

    @Autowired
    private IHySpecimenService hySpecimenService;

    @RequiresPermissions("system:specimen:view")
    @GetMapping()
    public String specimen()
    {
        return prefix + "/specimen";
    }

    /**
     * 查询接收员列表
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySpecimen", value = "项目实体类hySpecimen", required = true),
	})
    @RequiresPermissions("system:specimen:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HySpecimen hySpecimen)
    {
        startPage();
        List<HySpecimen> list = hySpecimenService.selectHySpecimenList(hySpecimen);
        return getDataTable(list);
    }

    /**
     * 导出接收员列表
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySpecimen", value = "项目实体类hySpecimen", required = true),
	})
    @RequiresPermissions("system:specimen:export")
    @Log(title = "接收员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HySpecimen hySpecimen)
    {
        List<HySpecimen> list = hySpecimenService.selectHySpecimenList(hySpecimen);
        ExcelUtil<HySpecimen> util = new ExcelUtil<HySpecimen>(HySpecimen.class);
        return util.exportExcel(list, "specimen");
    }

    /**
     * 新增接收员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存接收员
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySpecimen", value = "项目实体类hySpecimen", required = true),
	})
    @RequiresPermissions("system:specimen:add")
    @Log(title = "接收员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HySpecimen hySpecimen)
    {
        return toAjax(hySpecimenService.insertHySpecimen(hySpecimen));
    }

    /**
     * 修改接收员
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HySpecimen hySpecimen = hySpecimenService.selectHySpecimenById(id);
        mmap.put("hySpecimen", hySpecimen);
        return prefix + "/edit";
    }

    /**
     * 修改保存接收员
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySpecimen", value = "项目实体类hySpecimen", required = true),
	})
    @RequiresPermissions("system:specimen:edit")
    @Log(title = "接收员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HySpecimen hySpecimen)
    {
        return toAjax(hySpecimenService.updateHySpecimen(hySpecimen));
    }

    /**
     * 删除接收员
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:specimen:remove")
    @Log(title = "接收员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hySpecimenService.deleteHySpecimenByIds(ids));
    }
}
