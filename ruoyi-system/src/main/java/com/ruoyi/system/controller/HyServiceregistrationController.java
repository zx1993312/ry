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
import com.ruoyi.system.domain.HyServiceregistration;
import com.ruoyi.system.service.IHyServiceregistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备维修登记Controller
 * 
 * @author Administrator
 * @date 2021-05-13
 */
@Controller
@CrossOrigin
@RequestMapping("/system/serviceregistration")
@Api(tags = "设备维修登记Controller")
public class HyServiceregistrationController extends BaseController
{
    private String prefix = "system/serviceregistration";

    @Autowired
    private IHyServiceregistrationService hyServiceregistrationService;

    @RequiresPermissions("system:serviceregistration:view")
    @GetMapping()
    public String serviceregistration()
    {
        return prefix + "/serviceregistration";
    }

    /**
     * 查询设备维修登记列表
     */
    @ApiOperation("设备维修登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServiceregistration", value = "项目实体类hyServiceregistration", required = true),
	})
    @RequiresPermissions("system:serviceregistration:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyServiceregistration hyServiceregistration)
    {
        startPage();
        List<HyServiceregistration> list = hyServiceregistrationService.selectHyServiceregistrationList(hyServiceregistration);
        return getDataTable(list);
    }

    /**
     * 导出设备维修登记列表
     */
    @ApiOperation("设备维修登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServiceregistration", value = "项目实体类hyServiceregistration", required = true),
	})
    @RequiresPermissions("system:serviceregistration:export")
    @Log(title = "设备维修登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyServiceregistration hyServiceregistration)
    {
        List<HyServiceregistration> list = hyServiceregistrationService.selectHyServiceregistrationList(hyServiceregistration);
        ExcelUtil<HyServiceregistration> util = new ExcelUtil<HyServiceregistration>(HyServiceregistration.class);
        return util.exportExcel(list, "serviceregistration");
    }

    /**
     * 新增设备维修登记
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备维修登记
     */
    @ApiOperation("设备维修登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServiceregistration", value = "项目实体类hyServiceregistration", required = true),
	})
    @RequiresPermissions("system:serviceregistration:add")
    @Log(title = "设备维修登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyServiceregistration hyServiceregistration)
    {
        return toAjax(hyServiceregistrationService.insertHyServiceregistration(hyServiceregistration));
    }

    /**
     * 修改设备维修登记
     */
    @ApiOperation("设备维修登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyServiceregistration hyServiceregistration = hyServiceregistrationService.selectHyServiceregistrationById(id);
        mmap.put("hyServiceregistration", hyServiceregistration);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备维修登记
     */
    @ApiOperation("设备维修登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServiceregistration", value = "项目实体类hyServiceregistration", required = true),
	})
    @RequiresPermissions("system:serviceregistration:edit")
    @Log(title = "设备维修登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyServiceregistration hyServiceregistration)
    {
        return toAjax(hyServiceregistrationService.updateHyServiceregistration(hyServiceregistration));
    }

    /**
     * 删除设备维修登记
     */
    @ApiOperation("设备维修登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:serviceregistration:remove")
    @Log(title = "设备维修登记", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyServiceregistrationService.deleteHyServiceregistrationByIds(ids));
    }
}
