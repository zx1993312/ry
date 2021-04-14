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
import com.ruoyi.system.domain.HyRecipients;
import com.ruoyi.system.service.IHyRecipientsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 接收员Controller
 * 
 * @author Administrator
 * @date 2021-04-13
 */
@Controller
@RequestMapping("/system/recipients")
@Api(tags = "接收员Controller")
public class HyRecipientsController extends BaseController
{
    private String prefix = "system/recipients";

    @Autowired
    private IHyRecipientsService hyRecipientsService;

    @RequiresPermissions("system:recipients:view")
    @GetMapping()
    public String recipients()
    {
        return prefix + "/recipients";
    }

    /**
     * 查询接收员列表
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRecipients", value = "项目实体类hyRecipients", required = true),
	})
    @RequiresPermissions("system:recipients:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyRecipients hyRecipients)
    {
        startPage();
        List<HyRecipients> list = hyRecipientsService.selectHyRecipientsList(hyRecipients);
        return getDataTable(list);
    }

    /**
     * 导出接收员列表
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRecipients", value = "项目实体类hyRecipients", required = true),
	})
    @RequiresPermissions("system:recipients:export")
    @Log(title = "接收员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyRecipients hyRecipients)
    {
        List<HyRecipients> list = hyRecipientsService.selectHyRecipientsList(hyRecipients);
        ExcelUtil<HyRecipients> util = new ExcelUtil<HyRecipients>(HyRecipients.class);
        return util.exportExcel(list, "recipients");
    }

    /**
     * 新增接收员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存接收员
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRecipients", value = "项目实体类hyRecipients", required = true),
	})
    @RequiresPermissions("system:recipients:add")
    @Log(title = "接收员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyRecipients hyRecipients)
    {
        return toAjax(hyRecipientsService.insertHyRecipients(hyRecipients));
    }

    /**
     * 修改接收员
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyRecipients hyRecipients = hyRecipientsService.selectHyRecipientsById(id);
        mmap.put("hyRecipients", hyRecipients);
        return prefix + "/edit";
    }

    /**
     * 修改保存接收员
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRecipients", value = "项目实体类hyRecipients", required = true),
	})
    @RequiresPermissions("system:recipients:edit")
    @Log(title = "接收员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyRecipients hyRecipients)
    {
        return toAjax(hyRecipientsService.updateHyRecipients(hyRecipients));
    }

    /**
     * 删除接收员
     */
    @ApiOperation("接收员")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:recipients:remove")
    @Log(title = "接收员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyRecipientsService.deleteHyRecipientsByIds(ids));
    }
}
