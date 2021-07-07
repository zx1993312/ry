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
import com.ruoyi.system.domain.HyRegistrationFieldConfiguration;
import com.ruoyi.system.service.IHyRegistrationFieldConfigurationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 注册字段配置Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@CrossOrigin
@RequestMapping("/system/fieldConfiguration")
@Api(tags = "注册字段配置Controller")
public class HyRegistrationFieldConfigurationController extends BaseController
{
    private String prefix = "system/fieldConfiguration";

    @Autowired
    private IHyRegistrationFieldConfigurationService hyRegistrationFieldConfigurationService;

    @RequiresPermissions("system:configuration:view")
    @GetMapping()
    public String configuration()
    {
        return prefix + "/configuration";
    }

    /**
     * 查询注册字段配置列表
     */
    @ApiOperation("注册字段配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRegistrationFieldConfiguration", value = "项目实体类hyRegistrationFieldConfiguration", required = true),
	})
    @RequiresPermissions("system:configuration:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyRegistrationFieldConfiguration hyRegistrationFieldConfiguration)
    {
        startPage();
        List<HyRegistrationFieldConfiguration> list = hyRegistrationFieldConfigurationService.selectHyRegistrationFieldConfigurationList(hyRegistrationFieldConfiguration);
        return getDataTable(list);
    }

    /**
     * 导出注册字段配置列表
     */
    @ApiOperation("注册字段配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRegistrationFieldConfiguration", value = "项目实体类hyRegistrationFieldConfiguration", required = true),
	})
    @RequiresPermissions("system:configuration:export")
    @Log(title = "注册字段配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyRegistrationFieldConfiguration hyRegistrationFieldConfiguration)
    {
        List<HyRegistrationFieldConfiguration> list = hyRegistrationFieldConfigurationService.selectHyRegistrationFieldConfigurationList(hyRegistrationFieldConfiguration);
        ExcelUtil<HyRegistrationFieldConfiguration> util = new ExcelUtil<HyRegistrationFieldConfiguration>(HyRegistrationFieldConfiguration.class);
        return util.exportExcel(list, "configuration");
    }

    /**
     * 新增注册字段配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存注册字段配置
     */
    @ApiOperation("注册字段配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRegistrationFieldConfiguration", value = "项目实体类hyRegistrationFieldConfiguration", required = true),
	})
    @RequiresPermissions("system:configuration:add")
    @Log(title = "注册字段配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyRegistrationFieldConfiguration hyRegistrationFieldConfiguration)
    {
        return toAjax(hyRegistrationFieldConfigurationService.insertHyRegistrationFieldConfiguration(hyRegistrationFieldConfiguration));
    }

    /**
     * 修改注册字段配置
     */
    @ApiOperation("注册字段配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyRegistrationFieldConfiguration hyRegistrationFieldConfiguration = hyRegistrationFieldConfigurationService.selectHyRegistrationFieldConfigurationById(id);
        mmap.put("hyRegistrationFieldConfiguration", hyRegistrationFieldConfiguration);
        return prefix + "/edit";
    }

    /**
     * 修改保存注册字段配置
     */
    @ApiOperation("注册字段配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyRegistrationFieldConfiguration", value = "项目实体类hyRegistrationFieldConfiguration", required = true),
	})
    @RequiresPermissions("system:configuration:edit")
    @Log(title = "注册字段配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyRegistrationFieldConfiguration hyRegistrationFieldConfiguration)
    {
        return toAjax(hyRegistrationFieldConfigurationService.updateHyRegistrationFieldConfiguration(hyRegistrationFieldConfiguration));
    }

    /**
     * 删除注册字段配置
     */
    @ApiOperation("注册字段配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:configuration:remove")
    @Log(title = "注册字段配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyRegistrationFieldConfigurationService.deleteHyRegistrationFieldConfigurationByIds(ids));
    }
}
