package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.HyMaintenanceproject;
import com.ruoyi.system.service.IHyMaintenanceprojectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 保养项目Controller
 * 
 * @author Administrator
 * @date 2021-05-10
 */
@Controller
@RequestMapping("/system/SelectMaintenanceproject")
@Api(tags = "保养项目Controller")
public class HySelectMaintenanceprojectController extends BaseController
{
    private String prefix = "system/selectMaintenanceProject";

    @Autowired
    private IHyMaintenanceprojectService hyMaintenanceprojectService;

    @RequiresPermissions("system:maintenanceproject:view")
    @GetMapping()
    public String maintenanceproject()
    {
        return prefix + "/maintenanceproject";
    }

    /**
     * 查询保养项目列表
     */
    @ApiOperation("保养项目")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenanceproject", value = "项目实体类hyMaintenanceproject", required = true),
	})
    @RequiresPermissions("system:maintenanceproject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaintenanceproject hyMaintenanceproject)
    {
        startPage();
        List<HyMaintenanceproject> list = hyMaintenanceprojectService.selectHyMaintenanceprojectList(hyMaintenanceproject);
        return getDataTable(list);
    }

}
