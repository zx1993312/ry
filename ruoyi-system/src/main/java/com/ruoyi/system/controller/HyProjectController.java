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
import com.ruoyi.system.domain.HyProject;
import com.ruoyi.system.service.IHyProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目列Controller
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Controller
@RequestMapping("/system/project")
@Api(tags = "航宇物业，项目列表controller")
public class HyProjectController extends BaseController
{
    private String prefix = "system/project";

    @Autowired
    private IHyProjectService hyProjectService;

    @RequiresPermissions("system:project:view")
    @GetMapping()
    public String project()
    {
        return prefix + "/project";
    }

    /**
     * 查询项目列列表
     */
    @ApiOperation("查询项目列列表")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProject", value = "项目实体类", required = true),
	})
    @RequiresPermissions("system:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyProject hyProject)
    {
        startPage();
        List<HyProject> list = hyProjectService.selectHyProjectList(hyProject);
        return getDataTable(list);
    }

    /**
     * 导出项目列列表
     */
    @ApiOperation("导出项目列列表")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProject", value = "项目实体类", required = true),
	})
    @RequiresPermissions("system:project:export")
    @Log(title = "项目列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyProject hyProject)
    {
        List<HyProject> list = hyProjectService.selectHyProjectList(hyProject);
        ExcelUtil<HyProject> util = new ExcelUtil<HyProject>(HyProject.class);
        return util.exportExcel(list, "project");
    }

    /**
     * 新增项目列
     */
    @ApiOperation("新增项目列")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目列
     */
    @ApiOperation("新增保存项目列")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProject", value = "项目实体类", required = true),
	})
    @RequiresPermissions("system:project:add")
    @Log(title = "项目列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyProject hyProject)
    {
        return toAjax(hyProjectService.insertHyProject(hyProject));
    }

    /**
     * 修改项目列
     */
    @ApiOperation("修改项目列")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyProject hyProject = hyProjectService.selectHyProjectById(id);
        mmap.put("hyProject", hyProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目列
     */
    @ApiOperation("修改保存项目列")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProject", value = "项目实体类", required = true),
	})
    @RequiresPermissions("system:project:edit")
    @Log(title = "项目列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyProject hyProject)
    {
        return toAjax(hyProjectService.updateHyProject(hyProject));
    }

    /**
     * 删除项目列
     */
    @ApiOperation("删除项目列")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:project:remove")
    @Log(title = "项目列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyProjectService.deleteHyProjectByIds(ids));
    }
}
