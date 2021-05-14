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
import com.ruoyi.system.domain.HyDetectionregister;
import com.ruoyi.system.service.IHyDetectionregisterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备检测登记Controller
 * 
 * @author Administrator
 * @date 2021-05-14
 */
@Controller
@RequestMapping("/system/detectionuser")
@Api(tags = "设备检测登记Controller")
public class HyDetectionuserController extends BaseController
{
    private String prefix = "system/detectionuser";

    @Autowired
    private IHyDetectionregisterService hyDetectionregisterService;

    @RequiresPermissions("system:detectionregister:view")
    @GetMapping()
    public String detectionregister()
    {
        return prefix + "/detectionuser";
    }

    /**
     * 查询设备检测登记列表
     */
    @ApiOperation("设备检测登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDetectionregister", value = "项目实体类hyDetectionregister", required = true),
	})
    @RequiresPermissions("system:detectionregister:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyDetectionregister hyDetectionregister)
    {
        startPage();
        List<HyDetectionregister> list = hyDetectionregisterService.selectHyDetectionregisterList(hyDetectionregister);
        return getDataTable(list);
    }

}
