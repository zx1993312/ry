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
import com.ruoyi.system.domain.HyCheckeProject;
import com.ruoyi.system.service.IHyCheckeProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 巡检项目Controller
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Controller
@RequestMapping("/system/projects")
@Api(tags = "巡检项目Controller")
public class HyCheckeProjectController extends BaseController
{
    private String prefix = "system/projects";

    @Autowired
    private IHyCheckeProjectService hyCheckeProjectService;

    @RequiresPermissions("system:project:view")
    @GetMapping()
    public String project()
    {
        return prefix + "/project";
    }

    /**
     * 查询巡检项目列表
     */
    @ApiOperation("巡检项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckeProject", value = "项目实体类hyCheckeProject", required = true),
	})
    @RequiresPermissions("system:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCheckeProject hyCheckeProject)
    {
        startPage();
        List<HyCheckeProject> list = hyCheckeProjectService.selectHyCheckeProjectList(hyCheckeProject);
        return getDataTable(list);
    }

    /**
     * 导出巡检项目列表
     */
    @ApiOperation("巡检项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckeProject", value = "项目实体类hyCheckeProject", required = true),
	})
    @RequiresPermissions("system:project:export")
    @Log(title = "巡检项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCheckeProject hyCheckeProject)
    {
        List<HyCheckeProject> list = hyCheckeProjectService.selectHyCheckeProjectList(hyCheckeProject);
        ExcelUtil<HyCheckeProject> util = new ExcelUtil<HyCheckeProject>(HyCheckeProject.class);
        return util.exportExcel(list, "project");
    }

    /**
     * 新增巡检项目
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存巡检项目
     */
    @ApiOperation("巡检项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckeProject", value = "项目实体类hyCheckeProject", required = true),
	})
    @RequiresPermissions("system:project:add")
    @Log(title = "巡检项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCheckeProject hyCheckeProject)
    {
        return toAjax(hyCheckeProjectService.insertHyCheckeProject(hyCheckeProject));
    }

    /**
     * 修改巡检项目
     */
    @ApiOperation("巡检项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCheckeProject hyCheckeProject = hyCheckeProjectService.selectHyCheckeProjectById(id);
        mmap.put("hyCheckeProject", hyCheckeProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存巡检项目
     */
    @ApiOperation("巡检项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckeProject", value = "项目实体类hyCheckeProject", required = true),
	})
    @RequiresPermissions("system:project:edit")
    @Log(title = "巡检项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCheckeProject hyCheckeProject)
    {
        return toAjax(hyCheckeProjectService.updateHyCheckeProject(hyCheckeProject));
    }

    /**
     * 删除巡检项目
     */
    @ApiOperation("巡检项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:project:remove")
    @Log(title = "巡检项目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCheckeProjectService.deleteHyCheckeProjectByIds(ids));
    }
}
