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
import com.ruoyi.system.domain.HyCommunityActivity;
import com.ruoyi.system.service.IHyCommunityActivityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社区活动Controller
 * 
 * @author Administrator
 * @date 2021-04-12
 */
@Controller
@CrossOrigin
@RequestMapping("/system/activity")
@Api(tags = "社区活动Controller")
public class HyCommunityActivityController extends BaseController
{
    private String prefix = "system/activity";

    @Autowired
    private IHyCommunityActivityService hyCommunityActivityService;

    @RequiresPermissions("system:activity:view")
    @GetMapping()
    public String activity()
    {
        return prefix + "/activity";
    }

    /**
     * 查询社区活动列表
     */
    @ApiOperation("社区活动")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityActivity", value = "项目实体类hyCommunityActivity", required = true),
	})
    @RequiresPermissions("system:activity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCommunityActivity hyCommunityActivity)
    {
        startPage();
        List<HyCommunityActivity> list = hyCommunityActivityService.selectHyCommunityActivityList(hyCommunityActivity);
        return getDataTable(list);
    }

    /**
     * 导出社区活动列表
     */
    @ApiOperation("社区活动")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityActivity", value = "项目实体类hyCommunityActivity", required = true),
	})
    @RequiresPermissions("system:activity:export")
    @Log(title = "社区活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCommunityActivity hyCommunityActivity)
    {
        List<HyCommunityActivity> list = hyCommunityActivityService.selectHyCommunityActivityList(hyCommunityActivity);
        ExcelUtil<HyCommunityActivity> util = new ExcelUtil<HyCommunityActivity>(HyCommunityActivity.class);
        return util.exportExcel(list, "activity");
    }

    /**
     * 新增社区活动
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社区活动
     */
    @ApiOperation("社区活动")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityActivity", value = "项目实体类hyCommunityActivity", required = true),
	})
    @RequiresPermissions("system:activity:add")
    @Log(title = "社区活动", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCommunityActivity hyCommunityActivity)
    {
        return toAjax(hyCommunityActivityService.insertHyCommunityActivity(hyCommunityActivity));
    }

    /**
     * 修改社区活动
     */
    @ApiOperation("社区活动")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCommunityActivity hyCommunityActivity = hyCommunityActivityService.selectHyCommunityActivityById(id);
        mmap.put("hyCommunityActivity", hyCommunityActivity);
        return prefix + "/edit";
    }

    /**
     * 修改保存社区活动
     */
    @ApiOperation("社区活动")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityActivity", value = "项目实体类hyCommunityActivity", required = true),
	})
    @RequiresPermissions("system:activity:edit")
    @Log(title = "社区活动", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCommunityActivity hyCommunityActivity)
    {
        return toAjax(hyCommunityActivityService.updateHyCommunityActivity(hyCommunityActivity));
    }

    /**
     * 删除社区活动
     */
    @ApiOperation("社区活动")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:activity:remove")
    @Log(title = "社区活动", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCommunityActivityService.deleteHyCommunityActivityByIds(ids));
    }
}
