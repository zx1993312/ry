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
import com.ruoyi.system.domain.HyGroupRegistration;
import com.ruoyi.system.service.IHyGroupRegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 组团登记Controller
 * 
 * @author Administrator
 * @date 2021-02-02
 */
@Controller
@RequestMapping("/system/groupRegistration")
@Api(tags = "组团登记Controller")
public class HyGroupRegistrationController extends BaseController
{
    private String prefix = "system/groupRegistration";

    @Autowired
    private IHyGroupRegistrationService hyGroupRegistrationService;

    @RequiresPermissions("system:registration:view")
    @GetMapping()
    public String registration()
    {
        return prefix + "/registration";
    }

    /**
     * 查询组团登记列表
     */
    @ApiOperation("组团登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyGroupRegistration", value = "项目实体类hyGroupRegistration", required = true),
	})
    @RequiresPermissions("system:registration:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyGroupRegistration hyGroupRegistration)
    {
        startPage();
        List<HyGroupRegistration> list = hyGroupRegistrationService.selectHyGroupRegistrationList(hyGroupRegistration);
        return getDataTable(list);
    }

    /**
     * 导出组团登记列表
     */
    @ApiOperation("组团登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyGroupRegistration", value = "项目实体类hyGroupRegistration", required = true),
	})
    @RequiresPermissions("system:registration:export")
    @Log(title = "组团登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyGroupRegistration hyGroupRegistration)
    {
        List<HyGroupRegistration> list = hyGroupRegistrationService.selectHyGroupRegistrationList(hyGroupRegistration);
        ExcelUtil<HyGroupRegistration> util = new ExcelUtil<HyGroupRegistration>(HyGroupRegistration.class);
        return util.exportExcel(list, "registration");
    }

    /**
     * 新增组团登记
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存组团登记
     */
    @ApiOperation("组团登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyGroupRegistration", value = "项目实体类hyGroupRegistration", required = true),
	})
    @RequiresPermissions("system:registration:add")
    @Log(title = "组团登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyGroupRegistration hyGroupRegistration)
    {
        return toAjax(hyGroupRegistrationService.insertHyGroupRegistration(hyGroupRegistration));
    }

    /**
     * 修改组团登记
     */
    @ApiOperation("组团登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyGroupRegistration hyGroupRegistration = hyGroupRegistrationService.selectHyGroupRegistrationById(id);
        mmap.put("hyGroupRegistration", hyGroupRegistration);
        return prefix + "/edit";
    }

    /**
     * 修改保存组团登记
     */
    @ApiOperation("组团登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyGroupRegistration", value = "项目实体类hyGroupRegistration", required = true),
	})
    @RequiresPermissions("system:registration:edit")
    @Log(title = "组团登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyGroupRegistration hyGroupRegistration)
    {
        return toAjax(hyGroupRegistrationService.updateHyGroupRegistration(hyGroupRegistration));
    }

    /**
     * 删除组团登记
     */
    @ApiOperation("组团登记")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:registration:remove")
    @Log(title = "组团登记", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyGroupRegistrationService.deleteHyGroupRegistrationByIds(ids));
    }
}
