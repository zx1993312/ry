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
import com.ruoyi.system.domain.HyNodeTask;
import com.ruoyi.system.service.IHyNodeTaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 节点巡检任务Controller
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Controller
@CrossOrigin
@RequestMapping("/system/task")
@Api(tags = "节点巡检任务Controller")
public class HyNodeTaskController extends BaseController
{
    private String prefix = "system/task";

    @Autowired
    private IHyNodeTaskService hyNodeTaskService;

    @RequiresPermissions("system:task:view")
    @GetMapping()
    public String task()
    {
        return prefix + "/task";
    }

    /**
     * 查询节点巡检任务列表
     */
    @ApiOperation("节点巡检任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyNodeTask", value = "项目实体类hyNodeTask", required = true),
	})
    @RequiresPermissions("system:task:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyNodeTask hyNodeTask)
    {
        startPage();
        List<HyNodeTask> list = hyNodeTaskService.selectHyNodeTaskList(hyNodeTask);
        return getDataTable(list);
    }

    /**
     * 导出节点巡检任务列表
     */
    @ApiOperation("节点巡检任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyNodeTask", value = "项目实体类hyNodeTask", required = true),
	})
    @RequiresPermissions("system:task:export")
    @Log(title = "节点巡检任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyNodeTask hyNodeTask)
    {
        List<HyNodeTask> list = hyNodeTaskService.selectHyNodeTaskList(hyNodeTask);
        ExcelUtil<HyNodeTask> util = new ExcelUtil<HyNodeTask>(HyNodeTask.class);
        return util.exportExcel(list, "task");
    }

    /**
     * 新增节点巡检任务
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存节点巡检任务
     */
    @ApiOperation("节点巡检任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyNodeTask", value = "项目实体类hyNodeTask", required = true),
	})
    @RequiresPermissions("system:task:add")
    @Log(title = "节点巡检任务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyNodeTask hyNodeTask)
    {
        return toAjax(hyNodeTaskService.insertHyNodeTask(hyNodeTask));
    }

    /**
     * 修改节点巡检任务
     */
    @ApiOperation("节点巡检任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyNodeTask hyNodeTask = hyNodeTaskService.selectHyNodeTaskById(id);
        mmap.put("hyNodeTask", hyNodeTask);
        return prefix + "/edit";
    }

    /**
     * 修改保存节点巡检任务
     */
    @ApiOperation("节点巡检任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyNodeTask", value = "项目实体类hyNodeTask", required = true),
	})
    @RequiresPermissions("system:task:edit")
    @Log(title = "节点巡检任务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyNodeTask hyNodeTask)
    {
        return toAjax(hyNodeTaskService.updateHyNodeTask(hyNodeTask));
    }

    /**
     * 删除节点巡检任务
     */
    @ApiOperation("节点巡检任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:task:remove")
    @Log(title = "节点巡检任务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyNodeTaskService.deleteHyNodeTaskByIds(ids));
    }
}
