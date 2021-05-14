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
import com.ruoyi.system.domain.HyMemo;
import com.ruoyi.system.service.IHyMemoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备维修保养备忘录Controller
 * 
 * @author Administrator
 * @date 2021-05-13
 */
@Controller
@RequestMapping("/system/memo")
@Api(tags = "设备维修保养备忘录Controller")
public class HyMemoController extends BaseController
{
    private String prefix = "system/memo";

    @Autowired
    private IHyMemoService hyMemoService;

    @RequiresPermissions("system:memo:view")
    @GetMapping()
    public String memo()
    {
        return prefix + "/memo";
    }

    /**
     * 查询设备维修保养备忘录列表
     */
    @ApiOperation("设备维修保养备忘录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMemo", value = "项目实体类hyMemo", required = true),
	})
    @RequiresPermissions("system:memo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMemo hyMemo)
    {
        startPage();
        List<HyMemo> list = hyMemoService.selectHyMemoList(hyMemo);
        return getDataTable(list);
    }

    /**
     * 导出设备维修保养备忘录列表
     */
    @ApiOperation("设备维修保养备忘录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMemo", value = "项目实体类hyMemo", required = true),
	})
    @RequiresPermissions("system:memo:export")
    @Log(title = "设备维修保养备忘录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyMemo hyMemo)
    {
        List<HyMemo> list = hyMemoService.selectHyMemoList(hyMemo);
        ExcelUtil<HyMemo> util = new ExcelUtil<HyMemo>(HyMemo.class);
        return util.exportExcel(list, "memo");
    }

    /**
     * 新增设备维修保养备忘录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备维修保养备忘录
     */
    @ApiOperation("设备维修保养备忘录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMemo", value = "项目实体类hyMemo", required = true),
	})
    @RequiresPermissions("system:memo:add")
    @Log(title = "设备维修保养备忘录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyMemo hyMemo)
    {
        return toAjax(hyMemoService.insertHyMemo(hyMemo));
    }

    /**
     * 修改设备维修保养备忘录
     */
    @ApiOperation("设备维修保养备忘录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyMemo hyMemo = hyMemoService.selectHyMemoById(id);
        mmap.put("hyMemo", hyMemo);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备维修保养备忘录
     */
    @ApiOperation("设备维修保养备忘录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMemo", value = "项目实体类hyMemo", required = true),
	})
    @RequiresPermissions("system:memo:edit")
    @Log(title = "设备维修保养备忘录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyMemo hyMemo)
    {
        return toAjax(hyMemoService.updateHyMemo(hyMemo));
    }

    /**
     * 删除设备维修保养备忘录
     */
    @ApiOperation("设备维修保养备忘录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:memo:remove")
    @Log(title = "设备维修保养备忘录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyMemoService.deleteHyMemoByIds(ids));
    }
}
