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
import com.ruoyi.system.domain.HyResidentialQuarters;
import com.ruoyi.system.service.IHyResidentialQuartersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小区Controller
 * 
 * @author Administrator
 * @date 2021-03-17
 */
@Controller
@CrossOrigin
@RequestMapping("/system/quarters")
@Api(tags = "小区Controller")
public class HyResidentialQuartersController extends BaseController
{
    private String prefix = "system/quarters";

    @Autowired
    private IHyResidentialQuartersService hyResidentialQuartersService;

    @RequiresPermissions("system:quarters:view")
    @GetMapping()
    public String quarters()
    {
        return prefix + "/quarters";
    }

    /**
     * 查询小区列表
     */
    @ApiOperation("小区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyResidentialQuarters", value = "项目实体类hyResidentialQuarters", required = true),
	})
    @RequiresPermissions("system:quarters:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyResidentialQuarters hyResidentialQuarters)
    {
        startPage();
        List<HyResidentialQuarters> list = hyResidentialQuartersService.selectHyResidentialQuartersList(hyResidentialQuarters);
        return getDataTable(list);
    }

    /**
     * 导出小区列表
     */
    @ApiOperation("小区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyResidentialQuarters", value = "项目实体类hyResidentialQuarters", required = true),
	})
    @RequiresPermissions("system:quarters:export")
    @Log(title = "小区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyResidentialQuarters hyResidentialQuarters)
    {
        List<HyResidentialQuarters> list = hyResidentialQuartersService.selectHyResidentialQuartersList(hyResidentialQuarters);
        ExcelUtil<HyResidentialQuarters> util = new ExcelUtil<HyResidentialQuarters>(HyResidentialQuarters.class);
        return util.exportExcel(list, "quarters");
    }

    /**
     * 新增小区
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存小区
     */
    @ApiOperation("小区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyResidentialQuarters", value = "项目实体类hyResidentialQuarters", required = true),
	})
    @RequiresPermissions("system:quarters:add")
    @Log(title = "小区", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyResidentialQuarters hyResidentialQuarters)
    {
        return toAjax(hyResidentialQuartersService.insertHyResidentialQuarters(hyResidentialQuarters));
    }

    /**
     * 修改小区
     */
    @ApiOperation("小区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyResidentialQuarters hyResidentialQuarters = hyResidentialQuartersService.selectHyResidentialQuartersById(id);
        mmap.put("hyResidentialQuarters", hyResidentialQuarters);
        return prefix + "/edit";
    }

    /**
     * 修改保存小区
     */
    @ApiOperation("小区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyResidentialQuarters", value = "项目实体类hyResidentialQuarters", required = true),
	})
    @RequiresPermissions("system:quarters:edit")
    @Log(title = "小区", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyResidentialQuarters hyResidentialQuarters)
    {
        return toAjax(hyResidentialQuartersService.updateHyResidentialQuarters(hyResidentialQuarters));
    }

    /**
     * 删除小区
     */
    @ApiOperation("小区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:quarters:remove")
    @Log(title = "小区", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyResidentialQuartersService.deleteHyResidentialQuartersByIds(ids));
    }
}
