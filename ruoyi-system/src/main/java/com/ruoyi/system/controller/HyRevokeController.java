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
import com.ruoyi.system.domain.HyRevoke;
import com.ruoyi.system.service.IHyRevokeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 撤销操作Controller
 * 
 * @author Administrator
 * @date 2021-01-26
 */
@Controller
@CrossOrigin
@RequestMapping("/system/revoke")
@Api(tags = "撤销操作Controller")
public class HyRevokeController extends BaseController
{
    private String prefix = "system/revoke";

    @Autowired
    private IHyRevokeService hyRevokeService;

    @RequiresPermissions("system:revoke:view")
    @GetMapping()
    public String revoke()
    {
        return prefix + "/revoke";
    }

    /**
     * 查询撤销操作列表
     */
    @ApiOperation("撤销操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRevoke", value = "项目实体类hyRevoke", required = true),
	})
    @RequiresPermissions("system:revoke:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyRevoke hyRevoke)
    {
        startPage();
        List<HyRevoke> list = hyRevokeService.selectHyRevokeList(hyRevoke);
        return getDataTable(list);
    }

    /**
     * 导出撤销操作列表
     */
    @ApiOperation("撤销操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRevoke", value = "项目实体类hyRevoke", required = true),
	})
    @RequiresPermissions("system:revoke:export")
    @Log(title = "撤销操作", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyRevoke hyRevoke)
    {
        List<HyRevoke> list = hyRevokeService.selectHyRevokeList(hyRevoke);
        ExcelUtil<HyRevoke> util = new ExcelUtil<HyRevoke>(HyRevoke.class);
        return util.exportExcel(list, "revoke");
    }

    /**
     * 新增撤销操作
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存撤销操作
     */
    @ApiOperation("撤销操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRevoke", value = "项目实体类hyRevoke", required = true),
	})
    @RequiresPermissions("system:revoke:add")
    @Log(title = "撤销操作", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyRevoke hyRevoke)
    {
        return toAjax(hyRevokeService.insertHyRevoke(hyRevoke));
    }

    /**
     * 修改撤销操作
     */
    @ApiOperation("撤销操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyRevoke hyRevoke = hyRevokeService.selectHyRevokeById(id);
        mmap.put("hyRevoke", hyRevoke);
        return prefix + "/edit";
    }

    /**
     * 修改保存撤销操作
     */
    @ApiOperation("撤销操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRevoke", value = "项目实体类hyRevoke", required = true),
	})
    @RequiresPermissions("system:revoke:edit")
    @Log(title = "撤销操作", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyRevoke hyRevoke)
    {
        return toAjax(hyRevokeService.updateHyRevoke(hyRevoke));
    }

    /**
     * 删除撤销操作
     */
    @ApiOperation("撤销操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:revoke:remove")
    @Log(title = "撤销操作", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyRevokeService.deleteHyRevokeByIds(ids));
    }
}
