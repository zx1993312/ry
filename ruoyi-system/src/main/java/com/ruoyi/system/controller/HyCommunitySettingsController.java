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
import com.ruoyi.system.domain.HyCommunitySettings;
import com.ruoyi.system.service.IHyCommunitySettingsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小区设置Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@RequestMapping("/system/settings")
@Api(tags = "小区设置Controller")
public class HyCommunitySettingsController extends BaseController
{
    private String prefix = "system/settings";

    @Autowired
    private IHyCommunitySettingsService hyCommunitySettingsService;

    @RequiresPermissions("system:settings:view")
    @GetMapping()
    public String settings()
    {
        return prefix + "/settings";
    }

    /**
     * 查询小区设置列表
     */
    @ApiOperation("小区设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySettings", value = "项目实体类hyCommunitySettings", required = true),
	})
    @RequiresPermissions("system:settings:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCommunitySettings hyCommunitySettings)
    {
        startPage();
        List<HyCommunitySettings> list = hyCommunitySettingsService.selectHyCommunitySettingsList(hyCommunitySettings);
        return getDataTable(list);
    }

    /**
     * 导出小区设置列表
     */
    @ApiOperation("小区设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySettings", value = "项目实体类hyCommunitySettings", required = true),
	})
    @RequiresPermissions("system:settings:export")
    @Log(title = "小区设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCommunitySettings hyCommunitySettings)
    {
        List<HyCommunitySettings> list = hyCommunitySettingsService.selectHyCommunitySettingsList(hyCommunitySettings);
        ExcelUtil<HyCommunitySettings> util = new ExcelUtil<HyCommunitySettings>(HyCommunitySettings.class);
        return util.exportExcel(list, "settings");
    }

    /**
     * 新增小区设置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存小区设置
     */
    @ApiOperation("小区设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySettings", value = "项目实体类hyCommunitySettings", required = true),
	})
    @RequiresPermissions("system:settings:add")
    @Log(title = "小区设置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCommunitySettings hyCommunitySettings)
    {
        return toAjax(hyCommunitySettingsService.insertHyCommunitySettings(hyCommunitySettings));
    }

    /**
     * 修改小区设置
     */
    @ApiOperation("小区设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCommunitySettings hyCommunitySettings = hyCommunitySettingsService.selectHyCommunitySettingsById(id);
        mmap.put("hyCommunitySettings", hyCommunitySettings);
        return prefix + "/edit";
    }

    /**
     * 修改保存小区设置
     */
    @ApiOperation("小区设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySettings", value = "项目实体类hyCommunitySettings", required = true),
	})
    @RequiresPermissions("system:settings:edit")
    @Log(title = "小区设置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCommunitySettings hyCommunitySettings)
    {
        return toAjax(hyCommunitySettingsService.updateHyCommunitySettings(hyCommunitySettings));
    }

    /**
     * 删除小区设置
     */
    @ApiOperation("小区设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:settings:remove")
    @Log(title = "小区设置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCommunitySettingsService.deleteHyCommunitySettingsByIds(ids));
    }
}
