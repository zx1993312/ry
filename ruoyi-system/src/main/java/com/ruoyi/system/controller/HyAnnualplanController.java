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
import com.ruoyi.system.domain.HyAnnualplan;
import com.ruoyi.system.service.IHyAnnualplanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 年度保养计划Controller
 * 
 * @author Administrator
 * @date 2021-05-12
 */
@Controller
@RequestMapping("/system/annualplan")
@Api(tags = "年度保养计划Controller")
public class HyAnnualplanController extends BaseController
{
    private String prefix = "system/annualplan";

    @Autowired
    private IHyAnnualplanService hyAnnualplanService;

    @RequiresPermissions("system:annualplan:view")
    @GetMapping()
    public String annualplan()
    {
        return prefix + "/annualplan";
    }

    /**
     * 查询年度保养计划列表
     */
    @ApiOperation("年度保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAnnualplan", value = "项目实体类hyAnnualplan", required = true),
	})
    @RequiresPermissions("system:annualplan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyAnnualplan hyAnnualplan)
    {
        startPage();
        List<HyAnnualplan> list = hyAnnualplanService.selectHyAnnualplanList(hyAnnualplan);
        return getDataTable(list);
    }

    /**
     * 导出年度保养计划列表
     */
    @ApiOperation("年度保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAnnualplan", value = "项目实体类hyAnnualplan", required = true),
	})
    @RequiresPermissions("system:annualplan:export")
    @Log(title = "年度保养计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyAnnualplan hyAnnualplan)
    {
        List<HyAnnualplan> list = hyAnnualplanService.selectHyAnnualplanList(hyAnnualplan);
        ExcelUtil<HyAnnualplan> util = new ExcelUtil<HyAnnualplan>(HyAnnualplan.class);
        return util.exportExcel(list, "annualplan");
    }

    /**
     * 新增年度保养计划
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存年度保养计划
     */
    @ApiOperation("年度保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAnnualplan", value = "项目实体类hyAnnualplan", required = true),
	})
    @RequiresPermissions("system:annualplan:add")
    @Log(title = "年度保养计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyAnnualplan hyAnnualplan)
    {
        return toAjax(hyAnnualplanService.insertHyAnnualplan(hyAnnualplan));
    }

    /**
     * 修改年度保养计划
     */
    @ApiOperation("年度保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyAnnualplan hyAnnualplan = hyAnnualplanService.selectHyAnnualplanById(id);
        mmap.put("hyAnnualplan", hyAnnualplan);
        return prefix + "/edit";
    }

    /**
     * 修改保存年度保养计划
     */
    @ApiOperation("年度保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAnnualplan", value = "项目实体类hyAnnualplan", required = true),
	})
    @RequiresPermissions("system:annualplan:edit")
    @Log(title = "年度保养计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyAnnualplan hyAnnualplan)
    {
        return toAjax(hyAnnualplanService.updateHyAnnualplan(hyAnnualplan));
    }

    /**
     * 删除年度保养计划
     */
    @ApiOperation("年度保养计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:annualplan:remove")
    @Log(title = "年度保养计划", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyAnnualplanService.deleteHyAnnualplanByIds(ids));
    }
}
