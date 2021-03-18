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
import com.ruoyi.system.domain.HyRegistrationModeConfiguration;
import com.ruoyi.system.service.IHyRegistrationModeConfigurationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 注册方式配置Controller
 * 
 * @author Administrator
 * @date 2021-03-17
 */
@Controller
@RequestMapping("/system/configuration")
@Api(tags = "注册方式配置Controller")
public class HyRegistrationModeConfigurationController extends BaseController
{
    private String prefix = "system/configuration";

    @Autowired
    private IHyRegistrationModeConfigurationService hyRegistrationModeConfigurationService;

    @RequiresPermissions("system:configuration:view")
    @GetMapping()
    public String configuration()
    {
        return prefix + "/configuration";
    }

    /**
     * 查询注册方式配置列表
     */
    @ApiOperation("注册方式配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRegistrationModeConfiguration", value = "项目实体类hyRegistrationModeConfiguration", required = true),
	})
    @RequiresPermissions("system:configuration:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyRegistrationModeConfiguration hyRegistrationModeConfiguration)
    {
        startPage();
        List<HyRegistrationModeConfiguration> list = hyRegistrationModeConfigurationService.selectHyRegistrationModeConfigurationList(hyRegistrationModeConfiguration);
        return getDataTable(list);
    }

    /**
     * 导出注册方式配置列表
     */
    @ApiOperation("注册方式配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRegistrationModeConfiguration", value = "项目实体类hyRegistrationModeConfiguration", required = true),
	})
    @RequiresPermissions("system:configuration:export")
    @Log(title = "注册方式配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyRegistrationModeConfiguration hyRegistrationModeConfiguration)
    {
        List<HyRegistrationModeConfiguration> list = hyRegistrationModeConfigurationService.selectHyRegistrationModeConfigurationList(hyRegistrationModeConfiguration);
        ExcelUtil<HyRegistrationModeConfiguration> util = new ExcelUtil<HyRegistrationModeConfiguration>(HyRegistrationModeConfiguration.class);
        return util.exportExcel(list, "configuration");
    }

    /**
     * 新增注册方式配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存注册方式配置
     */
    @ApiOperation("注册方式配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRegistrationModeConfiguration", value = "项目实体类hyRegistrationModeConfiguration", required = true),
	})
    @RequiresPermissions("system:configuration:add")
    @Log(title = "注册方式配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyRegistrationModeConfiguration hyRegistrationModeConfiguration)
    {
        return toAjax(hyRegistrationModeConfigurationService.insertHyRegistrationModeConfiguration(hyRegistrationModeConfiguration));
    }

    /**
     * 修改注册方式配置
     */
    @ApiOperation("注册方式配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyRegistrationModeConfiguration hyRegistrationModeConfiguration = hyRegistrationModeConfigurationService.selectHyRegistrationModeConfigurationById(id);
        mmap.put("hyRegistrationModeConfiguration", hyRegistrationModeConfiguration);
        return prefix + "/edit";
    }

    /**
     * 修改保存注册方式配置
     */
    @ApiOperation("注册方式配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRegistrationModeConfiguration", value = "项目实体类hyRegistrationModeConfiguration", required = true),
	})
    @RequiresPermissions("system:configuration:edit")
    @Log(title = "注册方式配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyRegistrationModeConfiguration hyRegistrationModeConfiguration)
    {
        return toAjax(hyRegistrationModeConfigurationService.updateHyRegistrationModeConfiguration(hyRegistrationModeConfiguration));
    }

    /**
     * 删除注册方式配置
     */
    @ApiOperation("注册方式配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:configuration:remove")
    @Log(title = "注册方式配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyRegistrationModeConfigurationService.deleteHyRegistrationModeConfigurationByIds(ids));
    }
}
