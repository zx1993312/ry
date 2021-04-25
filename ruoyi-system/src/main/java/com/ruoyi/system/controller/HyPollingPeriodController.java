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
import com.ruoyi.system.domain.HyPollingPeriod;
import com.ruoyi.system.service.IHyPollingPeriodService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 巡检周期Controller
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Controller
@RequestMapping("/system/period")
@Api(tags = "巡检周期Controller")
public class HyPollingPeriodController extends BaseController
{
    private String prefix = "system/period";

    @Autowired
    private IHyPollingPeriodService hyPollingPeriodService;

    @RequiresPermissions("system:period:view")
    @GetMapping()
    public String period()
    {
        return prefix + "/period";
    }

    /**
     * 查询巡检周期列表
     */
    @ApiOperation("巡检周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPollingPeriod", value = "项目实体类hyPollingPeriod", required = true),
	})
    @RequiresPermissions("system:period:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyPollingPeriod hyPollingPeriod)
    {
        startPage();
        List<HyPollingPeriod> list = hyPollingPeriodService.selectHyPollingPeriodList(hyPollingPeriod);
        return getDataTable(list);
    }

    /**
     * 导出巡检周期列表
     */
    @ApiOperation("巡检周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPollingPeriod", value = "项目实体类hyPollingPeriod", required = true),
	})
    @RequiresPermissions("system:period:export")
    @Log(title = "巡检周期", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyPollingPeriod hyPollingPeriod)
    {
        List<HyPollingPeriod> list = hyPollingPeriodService.selectHyPollingPeriodList(hyPollingPeriod);
        ExcelUtil<HyPollingPeriod> util = new ExcelUtil<HyPollingPeriod>(HyPollingPeriod.class);
        return util.exportExcel(list, "period");
    }

    /**
     * 新增巡检周期
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存巡检周期
     */
    @ApiOperation("巡检周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPollingPeriod", value = "项目实体类hyPollingPeriod", required = true),
	})
    @RequiresPermissions("system:period:add")
    @Log(title = "巡检周期", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyPollingPeriod hyPollingPeriod)
    {
        return toAjax(hyPollingPeriodService.insertHyPollingPeriod(hyPollingPeriod));
    }

    /**
     * 修改巡检周期
     */
    @ApiOperation("巡检周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyPollingPeriod hyPollingPeriod = hyPollingPeriodService.selectHyPollingPeriodById(id);
        mmap.put("hyPollingPeriod", hyPollingPeriod);
        return prefix + "/edit";
    }

    /**
     * 修改保存巡检周期
     */
    @ApiOperation("巡检周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPollingPeriod", value = "项目实体类hyPollingPeriod", required = true),
	})
    @RequiresPermissions("system:period:edit")
    @Log(title = "巡检周期", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyPollingPeriod hyPollingPeriod)
    {
        return toAjax(hyPollingPeriodService.updateHyPollingPeriod(hyPollingPeriod));
    }

    /**
     * 删除巡检周期
     */
    @ApiOperation("巡检周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:period:remove")
    @Log(title = "巡检周期", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyPollingPeriodService.deleteHyPollingPeriodByIds(ids));
    }
}
