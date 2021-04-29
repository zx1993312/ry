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
@RequestMapping("/system/selectTask")
@Api(tags = "节点巡检任务Controller")
public class HySelectNodeTaskController extends BaseController
{
    private String prefix = "system/selectTask";

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

}
