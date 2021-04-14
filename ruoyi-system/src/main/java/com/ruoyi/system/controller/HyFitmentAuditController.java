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
import com.ruoyi.system.domain.HyFitmentAudit;
import com.ruoyi.system.service.IHyFitmentAuditService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 装修审核Controller
 * 
 * @author Administrator
 * @date 2021-04-13
 */
@Controller
@RequestMapping("/system/audits")
@Api(tags = "装修审核Controller")
public class HyFitmentAuditController extends BaseController
{
    private String prefix = "system/audits";

    @Autowired
    private IHyFitmentAuditService hyFitmentAuditService;

    @RequiresPermissions("system:audit:view")
    @GetMapping()
    public String audit()
    {
        return prefix + "/audit";
    }

    /**
     * 查询装修审核列表
     */
    @ApiOperation("装修审核")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFitmentAudit", value = "项目实体类hyFitmentAudit", required = true),
	})
    @RequiresPermissions("system:audit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyFitmentAudit hyFitmentAudit)
    {
        startPage();
        List<HyFitmentAudit> list = hyFitmentAuditService.selectHyFitmentAuditList(hyFitmentAudit);
        return getDataTable(list);
    }

    /**
     * 导出装修审核列表
     */
    @ApiOperation("装修审核")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFitmentAudit", value = "项目实体类hyFitmentAudit", required = true),
	})
    @RequiresPermissions("system:audit:export")
    @Log(title = "装修审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyFitmentAudit hyFitmentAudit)
    {
        List<HyFitmentAudit> list = hyFitmentAuditService.selectHyFitmentAuditList(hyFitmentAudit);
        ExcelUtil<HyFitmentAudit> util = new ExcelUtil<HyFitmentAudit>(HyFitmentAudit.class);
        return util.exportExcel(list, "audit");
    }

    /**
     * 新增装修审核
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存装修审核
     */
    @ApiOperation("装修审核")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFitmentAudit", value = "项目实体类hyFitmentAudit", required = true),
	})
    @RequiresPermissions("system:audit:add")
    @Log(title = "装修审核", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyFitmentAudit hyFitmentAudit)
    {
        return toAjax(hyFitmentAuditService.insertHyFitmentAudit(hyFitmentAudit));
    }

    /**
     * 修改装修审核
     */
    @ApiOperation("装修审核")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyFitmentAudit hyFitmentAudit = hyFitmentAuditService.selectHyFitmentAuditById(id);
        mmap.put("hyFitmentAudit", hyFitmentAudit);
        return prefix + "/edit";
    }

    /**
     * 修改保存装修审核
     */
    @ApiOperation("装修审核")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFitmentAudit", value = "项目实体类hyFitmentAudit", required = true),
	})
    @RequiresPermissions("system:audit:edit")
    @Log(title = "装修审核", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyFitmentAudit hyFitmentAudit)
    {
        return toAjax(hyFitmentAuditService.updateHyFitmentAudit(hyFitmentAudit));
    }

    /**
     * 删除装修审核
     */
    @ApiOperation("装修审核")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:audit:remove")
    @Log(title = "装修审核", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyFitmentAuditService.deleteHyFitmentAuditByIds(ids));
    }
}
