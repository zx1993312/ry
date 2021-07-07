package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyInspectionRoute;
import com.ruoyi.system.service.IHyInspectionRouteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 巡检线路Controller
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Controller
@CrossOrigin
@RequestMapping("/system/selectRouter")
@Api(tags = "巡检线路Controller")
public class HySelectRouteController extends BaseController
{
    private String prefix = "system/selectRouter";

    @Autowired
    private IHyInspectionRouteService hyInspectionRouteService;

    @RequiresPermissions("system:route:view")
    @GetMapping()
    public String route()
    {
        return prefix + "/route";
    }

    /**
     * 查询巡检线路列表
     */
    @ApiOperation("巡检线路")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInspectionRoute", value = "项目实体类hyInspectionRoute", required = true),
	})
    @RequiresPermissions("system:route:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyInspectionRoute hyInspectionRoute)
    {
        startPage();
        List<HyInspectionRoute> list = hyInspectionRouteService.selectHyInspectionRouteList(hyInspectionRoute);
        return getDataTable(list);
    }

    /**
     * 导出巡检线路列表
     */
    @ApiOperation("巡检线路")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInspectionRoute", value = "项目实体类hyInspectionRoute", required = true),
	})
    @RequiresPermissions("system:route:export")
    @Log(title = "巡检线路", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyInspectionRoute hyInspectionRoute)
    {
        List<HyInspectionRoute> list = hyInspectionRouteService.selectHyInspectionRouteList(hyInspectionRoute);
        ExcelUtil<HyInspectionRoute> util = new ExcelUtil<HyInspectionRoute>(HyInspectionRoute.class);
        return util.exportExcel(list, "route");
    }

}
