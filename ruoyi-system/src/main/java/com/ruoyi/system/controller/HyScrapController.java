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
import com.ruoyi.system.domain.HyScrap;
import com.ruoyi.system.service.IHyScrapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备报废申请Controller
 * 
 * @author Administrator
 * @date 2021-05-14
 */
@Controller
@RequestMapping("/system/scrap")
@Api(tags = "设备报废申请Controller")
public class HyScrapController extends BaseController
{
    private String prefix = "system/scrap";

    @Autowired
    private IHyScrapService hyScrapService;

    @RequiresPermissions("system:scrap:view")
    @GetMapping()
    public String scrap()
    {
        return prefix + "/scrap";
    }

    /**
     * 查询设备报废申请列表
     */
    @ApiOperation("设备报废申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyScrap", value = "项目实体类hyScrap", required = true),
	})
    @RequiresPermissions("system:scrap:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyScrap hyScrap)
    {
        startPage();
        List<HyScrap> list = hyScrapService.selectHyScrapList(hyScrap);
        return getDataTable(list);
    }

    /**
     * 导出设备报废申请列表
     */
    @ApiOperation("设备报废申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyScrap", value = "项目实体类hyScrap", required = true),
	})
    @RequiresPermissions("system:scrap:export")
    @Log(title = "设备报废申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyScrap hyScrap)
    {
        List<HyScrap> list = hyScrapService.selectHyScrapList(hyScrap);
        ExcelUtil<HyScrap> util = new ExcelUtil<HyScrap>(HyScrap.class);
        return util.exportExcel(list, "scrap");
    }

    /**
     * 新增设备报废申请
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备报废申请
     */
    @ApiOperation("设备报废申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyScrap", value = "项目实体类hyScrap", required = true),
	})
    @RequiresPermissions("system:scrap:add")
    @Log(title = "设备报废申请", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyScrap hyScrap)
    {
        return toAjax(hyScrapService.insertHyScrap(hyScrap));
    }

    /**
     * 修改设备报废申请
     */
    @ApiOperation("设备报废申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyScrap hyScrap = hyScrapService.selectHyScrapById(id);
        mmap.put("hyScrap", hyScrap);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备报废申请
     */
    @ApiOperation("设备报废申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyScrap", value = "项目实体类hyScrap", required = true),
	})
    @RequiresPermissions("system:scrap:edit")
    @Log(title = "设备报废申请", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyScrap hyScrap)
    {
        return toAjax(hyScrapService.updateHyScrap(hyScrap));
    }

    /**
     * 删除设备报废申请
     */
    @ApiOperation("设备报废申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:scrap:remove")
    @Log(title = "设备报废申请", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyScrapService.deleteHyScrapByIds(ids));
    }
}
