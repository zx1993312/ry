package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyPatrolScheme;
import com.ruoyi.system.service.IHyFreeInspectionListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 自由巡检一览表Controller
 * 
 * @author Administrator
 * @date 2021-04-28
 */
@Controller
@RequestMapping("/system/free")
@Api(tags = "自由巡检一览表Controller")
public class HyFreeInspectionListController extends BaseController
{
    private String prefix = "system/freeInspectionList";

    @Autowired
    private IHyFreeInspectionListService hyFreeInspectionListService;

    @RequiresPermissions("system:scheme:view")
    @GetMapping()
    public String list()
    {
        return prefix + "/list";
    }

    /**
     * 查询巡检计划列表
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPatrolScheme", value = "项目实体类hyPatrolScheme", required = true),
	})
    @RequiresPermissions("system:scheme:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyPatrolScheme hyPatrolScheme)
    {
        startPage();
        List<HyPatrolScheme> list = hyFreeInspectionListService.selectHyPatrolSchemeList(hyPatrolScheme);
        return getDataTable(list);
    }

    /**
     * 导出巡检计划列表
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPatrolScheme", value = "项目实体类hyPatrolScheme", required = true),
	})
    @RequiresPermissions("system:scheme:export")
    @Log(title = "巡检计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyPatrolScheme hyPatrolScheme)
    {
        List<HyPatrolScheme> list = hyFreeInspectionListService.selectHyPatrolSchemeList(hyPatrolScheme);
        ExcelUtil<HyPatrolScheme> util = new ExcelUtil<HyPatrolScheme>(HyPatrolScheme.class);
        return util.exportExcel(list, "scheme");
    }

}
