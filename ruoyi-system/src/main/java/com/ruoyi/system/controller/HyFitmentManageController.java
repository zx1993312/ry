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
import com.ruoyi.system.domain.HyFitmentManage;
import com.ruoyi.system.service.IHyFitmentManageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 装修管理Controller
 * 
 * @author Administrator
 * @date 2021-04-13
 */
@Controller
@CrossOrigin
@RequestMapping("/system/manage")
@Api(tags = "装修管理Controller")
public class HyFitmentManageController extends BaseController
{
    private String prefix = "system/manage";

    @Autowired
    private IHyFitmentManageService hyFitmentManageService;

    @RequiresPermissions("system:manage:view")
    @GetMapping()
    public String manage()
    {
        return prefix + "/manage";
    }

    /**
     * 查询装修管理列表
     */
    @ApiOperation("装修管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFitmentManage", value = "项目实体类hyFitmentManage", required = true),
	})
    @RequiresPermissions("system:manage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyFitmentManage hyFitmentManage)
    {
        startPage();
        List<HyFitmentManage> list = hyFitmentManageService.selectHyFitmentManageList(hyFitmentManage);
        return getDataTable(list);
    }

    /**
     * 导出装修管理列表
     */
    @ApiOperation("装修管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFitmentManage", value = "项目实体类hyFitmentManage", required = true),
	})
    @RequiresPermissions("system:manage:export")
    @Log(title = "装修管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyFitmentManage hyFitmentManage)
    {
        List<HyFitmentManage> list = hyFitmentManageService.selectHyFitmentManageList(hyFitmentManage);
        ExcelUtil<HyFitmentManage> util = new ExcelUtil<HyFitmentManage>(HyFitmentManage.class);
        return util.exportExcel(list, "manage");
    }

    /**
     * 新增装修管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存装修管理
     */
    @ApiOperation("装修管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFitmentManage", value = "项目实体类hyFitmentManage", required = true),
	})
    @RequiresPermissions("system:manage:add")
    @Log(title = "装修管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyFitmentManage hyFitmentManage)
    {
        return toAjax(hyFitmentManageService.insertHyFitmentManage(hyFitmentManage));
    }

    /**
     * 修改装修管理
     */
    @ApiOperation("装修管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyFitmentManage hyFitmentManage = hyFitmentManageService.selectHyFitmentManageById(id);
        mmap.put("hyFitmentManage", hyFitmentManage);
        return prefix + "/edit";
    }

    /**
     * 修改保存装修管理
     */
    @ApiOperation("装修管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyFitmentManage", value = "项目实体类hyFitmentManage", required = true),
	})
    @RequiresPermissions("system:manage:edit")
    @Log(title = "装修管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyFitmentManage hyFitmentManage)
    {
        return toAjax(hyFitmentManageService.updateHyFitmentManage(hyFitmentManage));
    }

    /**
     * 删除装修管理
     */
    @ApiOperation("装修管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:manage:remove")
    @Log(title = "装修管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyFitmentManageService.deleteHyFitmentManageByIds(ids));
    }
}
