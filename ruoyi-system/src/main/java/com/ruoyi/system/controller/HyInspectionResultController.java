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
import com.ruoyi.system.domain.HyInspectionResult;
import com.ruoyi.system.service.IHyInspectionResultService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 巡检结果Controller
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Controller
@CrossOrigin
@RequestMapping("/system/result")
@Api(tags = "巡检结果Controller")
public class HyInspectionResultController extends BaseController
{
    private String prefix = "system/result";

    @Autowired
    private IHyInspectionResultService hyInspectionResultService;

    @RequiresPermissions("system:result:view")
    @GetMapping()
    public String result()
    {
        return prefix + "/result";
    }

    /**
     * 查询巡检结果列表
     */
    @ApiOperation("巡检结果")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInspectionResult", value = "项目实体类hyInspectionResult", required = true),
	})
    @RequiresPermissions("system:result:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyInspectionResult hyInspectionResult)
    {
        startPage();
        List<HyInspectionResult> list = hyInspectionResultService.selectHyInspectionResultList(hyInspectionResult);
        return getDataTable(list);
    }

    /**
     * 导出巡检结果列表
     */
    @ApiOperation("巡检结果")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInspectionResult", value = "项目实体类hyInspectionResult", required = true),
	})
    @RequiresPermissions("system:result:export")
    @Log(title = "巡检结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyInspectionResult hyInspectionResult)
    {
        List<HyInspectionResult> list = hyInspectionResultService.selectHyInspectionResultList(hyInspectionResult);
        ExcelUtil<HyInspectionResult> util = new ExcelUtil<HyInspectionResult>(HyInspectionResult.class);
        return util.exportExcel(list, "result");
    }

    /**
     * 新增巡检结果
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存巡检结果
     */
    @ApiOperation("巡检结果")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInspectionResult", value = "项目实体类hyInspectionResult", required = true),
	})
    @RequiresPermissions("system:result:add")
    @Log(title = "巡检结果", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyInspectionResult hyInspectionResult)
    {
        return toAjax(hyInspectionResultService.insertHyInspectionResult(hyInspectionResult));
    }

    /**
     * 修改巡检结果
     */
    @ApiOperation("巡检结果")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyInspectionResult hyInspectionResult = hyInspectionResultService.selectHyInspectionResultById(id);
        mmap.put("hyInspectionResult", hyInspectionResult);
        return prefix + "/edit";
    }

    /**
     * 修改保存巡检结果
     */
    @ApiOperation("巡检结果")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInspectionResult", value = "项目实体类hyInspectionResult", required = true),
	})
    @RequiresPermissions("system:result:edit")
    @Log(title = "巡检结果", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyInspectionResult hyInspectionResult)
    {
        return toAjax(hyInspectionResultService.updateHyInspectionResult(hyInspectionResult));
    }

    /**
     * 删除巡检结果
     */
    @ApiOperation("巡检结果")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:result:remove")
    @Log(title = "巡检结果", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyInspectionResultService.deleteHyInspectionResultByIds(ids));
    }
}
