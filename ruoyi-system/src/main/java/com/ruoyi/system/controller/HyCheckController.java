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
import com.ruoyi.system.domain.HyCheck;
import com.ruoyi.system.service.IHyCheckService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 盘点员Controller
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Controller
@CrossOrigin
@RequestMapping("/system/check")
@Api(tags = "盘点员Controller")
public class HyCheckController extends BaseController
{
    private String prefix = "system/check";

    @Autowired
    private IHyCheckService hyCheckService;

    @RequiresPermissions("system:check:view")
    @GetMapping()
    public String check()
    {
        return prefix + "/check";
    }

    /**
     * 查询盘点员列表
     */
    @ApiOperation("盘点员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheck", value = "项目实体类hyCheck", required = true),
	})
    @RequiresPermissions("system:check:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCheck hyCheck)
    {
        startPage();
        List<HyCheck> list = hyCheckService.selectHyCheckList(hyCheck);
        return getDataTable(list);
    }

    /**
     * 导出盘点员列表
     */
    @ApiOperation("盘点员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheck", value = "项目实体类hyCheck", required = true),
	})
    @RequiresPermissions("system:check:export")
    @Log(title = "盘点员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCheck hyCheck)
    {
        List<HyCheck> list = hyCheckService.selectHyCheckList(hyCheck);
        ExcelUtil<HyCheck> util = new ExcelUtil<HyCheck>(HyCheck.class);
        return util.exportExcel(list, "check");
    }

    /**
     * 新增盘点员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存盘点员
     */
    @ApiOperation("盘点员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheck", value = "项目实体类hyCheck", required = true),
	})
    @RequiresPermissions("system:check:add")
    @Log(title = "盘点员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCheck hyCheck)
    {
        return toAjax(hyCheckService.insertHyCheck(hyCheck));
    }

    /**
     * 修改盘点员
     */
    @ApiOperation("盘点员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCheck hyCheck = hyCheckService.selectHyCheckById(id);
        mmap.put("hyCheck", hyCheck);
        return prefix + "/edit";
    }

    /**
     * 修改保存盘点员
     */
    @ApiOperation("盘点员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheck", value = "项目实体类hyCheck", required = true),
	})
    @RequiresPermissions("system:check:edit")
    @Log(title = "盘点员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCheck hyCheck)
    {
        return toAjax(hyCheckService.updateHyCheck(hyCheck));
    }

    /**
     * 删除盘点员
     */
    @ApiOperation("盘点员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:check:remove")
    @Log(title = "盘点员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCheckService.deleteHyCheckByIds(ids));
    }
}
