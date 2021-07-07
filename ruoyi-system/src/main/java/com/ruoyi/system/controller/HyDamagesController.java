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
import com.ruoyi.system.domain.HyDamages;
import com.ruoyi.system.service.IHyDamagesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 违约金Controller
 * 
 * @author Administrator
 * @date 2021-01-28
 */
@Controller
@CrossOrigin
@RequestMapping("/system/damages")
@Api(tags = "违约金Controller")
public class HyDamagesController extends BaseController
{
    private String prefix = "system/damages";

    @Autowired
    private IHyDamagesService hyDamagesService;

    @RequiresPermissions("system:damages:view")
    @GetMapping()
    public String damages()
    {
        return prefix + "/damages";
    }

    /**
     * 查询违约金列表
     */
    @ApiOperation("违约金")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDamages", value = "项目实体类hyDamages", required = true),
	})
    @RequiresPermissions("system:damages:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyDamages hyDamages)
    {
        startPage();
        List<HyDamages> list = hyDamagesService.selectHyDamagesList(hyDamages);
        return getDataTable(list);
    }

    /**
     * 导出违约金列表
     */
    @ApiOperation("违约金")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDamages", value = "项目实体类hyDamages", required = true),
	})
    @RequiresPermissions("system:damages:export")
    @Log(title = "违约金", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyDamages hyDamages)
    {
        List<HyDamages> list = hyDamagesService.selectHyDamagesList(hyDamages);
        ExcelUtil<HyDamages> util = new ExcelUtil<HyDamages>(HyDamages.class);
        return util.exportExcel(list, "damages");
    }

    /**
     * 新增违约金
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存违约金
     */
    @ApiOperation("违约金")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDamages", value = "项目实体类hyDamages", required = true),
	})
    @RequiresPermissions("system:damages:add")
    @Log(title = "违约金", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyDamages hyDamages)
    {
        return toAjax(hyDamagesService.insertHyDamages(hyDamages));
    }

    /**
     * 修改违约金
     */
    @ApiOperation("违约金")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyDamages hyDamages = hyDamagesService.selectHyDamagesById(id);
        mmap.put("hyDamages", hyDamages);
        return prefix + "/edit";
    }

    /**
     * 修改保存违约金
     */
    @ApiOperation("违约金")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDamages", value = "项目实体类hyDamages", required = true),
	})
    @RequiresPermissions("system:damages:edit")
    @Log(title = "违约金", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyDamages hyDamages)
    {
        return toAjax(hyDamagesService.updateHyDamages(hyDamages));
    }

    /**
     * 删除违约金
     */
    @ApiOperation("违约金")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:damages:remove")
    @Log(title = "违约金", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyDamagesService.deleteHyDamagesByIds(ids));
    }
}
