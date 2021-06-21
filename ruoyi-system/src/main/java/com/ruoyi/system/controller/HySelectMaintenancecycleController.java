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
import com.ruoyi.system.domain.HyMaintenancecycle;
import com.ruoyi.system.service.IHyMaintenancecycleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 设备保养周期Controller
 * 
 * @author Administrator
 * @date 2021-05-11
 */
@Controller
@RequestMapping("/system/selectPeriod")
@Api(tags = "设备保养周期Controller")
public class HySelectMaintenancecycleController extends BaseController
{
    private String prefix = "system/selectPeriod";

    @Autowired
    private IHyMaintenancecycleService hyMaintenancecycleService;

    @RequiresPermissions("system:maintenancecycle:view")
    @GetMapping()
    public String maintenancecycle()
    {
        return prefix + "/maintenancecycle";
    }

    /**
     * 查询设备保养周期列表
     */
    @ApiOperation("设备保养周期")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyMaintenancecycle", value = "项目实体类hyMaintenancecycle", required = true),
	})
    @RequiresPermissions("system:maintenancecycle:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyMaintenancecycle hyMaintenancecycle)
    {
        startPage();
        List<HyMaintenancecycle> list = hyMaintenancecycleService.selectHyMaintenancecycleList(hyMaintenancecycle);
        return getDataTable(list);
    }

}
