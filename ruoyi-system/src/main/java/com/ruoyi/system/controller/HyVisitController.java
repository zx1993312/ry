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
import com.ruoyi.system.domain.HyVisit;
import com.ruoyi.system.service.IHyVisitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 访客Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@CrossOrigin
@RequestMapping("/system/visit")
@Api(tags = "访客Controller")
public class HyVisitController extends BaseController
{
    private String prefix = "system/visit";

    @Autowired
    private IHyVisitService hyVisitService;

    @RequiresPermissions("system:visit:view")
    @GetMapping()
    public String visit()
    {
        return prefix + "/visit";
    }

    /**
     * 查询访客列表
     */
    @ApiOperation("访客")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyVisit", value = "项目实体类hyVisit", required = true),
	})
    @RequiresPermissions("system:visit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyVisit hyVisit)
    {
        startPage();
        List<HyVisit> list = hyVisitService.selectHyVisitList(hyVisit);
        return getDataTable(list);
    }

    /**
     * 导出访客列表
     */
    @ApiOperation("访客")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyVisit", value = "项目实体类hyVisit", required = true),
	})
    @RequiresPermissions("system:visit:export")
    @Log(title = "访客", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyVisit hyVisit)
    {
        List<HyVisit> list = hyVisitService.selectHyVisitList(hyVisit);
        ExcelUtil<HyVisit> util = new ExcelUtil<HyVisit>(HyVisit.class);
        return util.exportExcel(list, "visit");
    }

    /**
     * 新增访客
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存访客
     */
    @ApiOperation("访客")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyVisit", value = "项目实体类hyVisit", required = true),
	})
    @RequiresPermissions("system:visit:add")
    @Log(title = "访客", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyVisit hyVisit)
    {
        return toAjax(hyVisitService.insertHyVisit(hyVisit));
    }

    /**
     * 修改访客
     */
    @ApiOperation("访客")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyVisit hyVisit = hyVisitService.selectHyVisitById(id);
        mmap.put("hyVisit", hyVisit);
        return prefix + "/edit";
    }

    /**
     * 修改保存访客
     */
    @ApiOperation("访客")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyVisit", value = "项目实体类hyVisit", required = true),
	})
    @RequiresPermissions("system:visit:edit")
    @Log(title = "访客", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyVisit hyVisit)
    {
        return toAjax(hyVisitService.updateHyVisit(hyVisit));
    }

    /**
     * 删除访客
     */
    @ApiOperation("访客")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:visit:remove")
    @Log(title = "访客", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyVisitService.deleteHyVisitByIds(ids));
    }
}
