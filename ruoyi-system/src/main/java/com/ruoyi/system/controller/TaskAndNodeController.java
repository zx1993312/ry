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
import com.ruoyi.system.domain.TaskAndNode;
import com.ruoyi.system.service.ITaskAndNodeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 巡检任务和巡检节点关联Controller
 * 
 * @author Administrator
 * @date 2021-07-21
 */
@Controller
@RequestMapping("/system/taskAndNode")
@Api(tags = "巡检任务和巡检节点关联Controller")
public class TaskAndNodeController extends BaseController
{
    private String prefix = "system/taskAndNode";

    @Autowired
    private ITaskAndNodeService taskAndNodeService;

    @RequiresPermissions("system:node:view")
    @GetMapping()
    public String node()
    {
        return prefix + "/taskAndNode";
    }

    /**
     * 查询巡检任务和巡检节点关联列表
     */
    @ApiOperation("巡检任务和巡检节点关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "taskAndNode", value = "项目实体类taskAndNode", required = true),
	})
    @RequiresPermissions("system:node:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TaskAndNode taskAndNode)
    {
        startPage();
        List<TaskAndNode> list = taskAndNodeService.selectTaskAndNodeList(taskAndNode);
        return getDataTable(list);
    }

    /**
     * 导出巡检任务和巡检节点关联列表
     */
    @ApiOperation("巡检任务和巡检节点关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "taskAndNode", value = "项目实体类taskAndNode", required = true),
	})
    @RequiresPermissions("system:node:export")
    @Log(title = "巡检任务和巡检节点关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TaskAndNode taskAndNode)
    {
        List<TaskAndNode> list = taskAndNodeService.selectTaskAndNodeList(taskAndNode);
        ExcelUtil<TaskAndNode> util = new ExcelUtil<TaskAndNode>(TaskAndNode.class);
        return util.exportExcel(list, "node");
    }

    /**
     * 新增巡检任务和巡检节点关联
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存巡检任务和巡检节点关联
     */
    @ApiOperation("巡检任务和巡检节点关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "taskAndNode", value = "项目实体类taskAndNode", required = true),
	})
    @RequiresPermissions("system:node:add")
    @Log(title = "巡检任务和巡检节点关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TaskAndNode taskAndNode)
    {
        return toAjax(taskAndNodeService.insertTaskAndNode(taskAndNode));
    }

    /**
     * 修改巡检任务和巡检节点关联
     */
    @ApiOperation("巡检任务和巡检节点关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "taskId", value = "主键id", required = true),
	})
    @GetMapping("/edit/{taskId}")
    public String edit(@PathVariable("taskId") Long taskId, ModelMap mmap)
    {
        TaskAndNode taskAndNode = taskAndNodeService.selectTaskAndNodeById(taskId);
        mmap.put("taskAndNode", taskAndNode);
        return prefix + "/edit";
    }

    /**
     * 修改保存巡检任务和巡检节点关联
     */
    @ApiOperation("巡检任务和巡检节点关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "taskAndNode", value = "项目实体类taskAndNode", required = true),
	})
    @RequiresPermissions("system:node:edit")
    @Log(title = "巡检任务和巡检节点关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TaskAndNode taskAndNode)
    {
        return toAjax(taskAndNodeService.updateTaskAndNode(taskAndNode));
    }

    /**
     * 删除巡检任务和巡检节点关联
     */
    @ApiOperation("巡检任务和巡检节点关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:node:remove")
    @Log(title = "巡检任务和巡检节点关联", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(taskAndNodeService.deleteTaskAndNodeByIds(ids));
    }
}