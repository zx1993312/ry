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
import com.ruoyi.system.domain.HyOperatingParameter;
import com.ruoyi.system.service.IHyOperatingParameterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运行参数Controller
 * 
 * @author Administrator
 * @date 2021-05-10
 */
@Controller
@RequestMapping("/system/parameter")
@Api(tags = "运行参数Controller")
public class HyOperatingParameterController extends BaseController
{
    private String prefix = "system/parameter";

    @Autowired
    private IHyOperatingParameterService hyOperatingParameterService;

    @RequiresPermissions("system:parameter:view")
    @GetMapping()
    public String parameter()
    {
        return prefix + "/parameter";
    }

    /**
     * 查询运行参数列表
     */
    @ApiOperation("运行参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyOperatingParameter", value = "项目实体类hyOperatingParameter", required = true),
	})
    @RequiresPermissions("system:parameter:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyOperatingParameter hyOperatingParameter)
    {
        startPage();
        List<HyOperatingParameter> list = hyOperatingParameterService.selectHyOperatingParameterList(hyOperatingParameter);
        return getDataTable(list);
    }

    /**
     * 导出运行参数列表
     */
    @ApiOperation("运行参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyOperatingParameter", value = "项目实体类hyOperatingParameter", required = true),
	})
    @RequiresPermissions("system:parameter:export")
    @Log(title = "运行参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyOperatingParameter hyOperatingParameter)
    {
        List<HyOperatingParameter> list = hyOperatingParameterService.selectHyOperatingParameterList(hyOperatingParameter);
        ExcelUtil<HyOperatingParameter> util = new ExcelUtil<HyOperatingParameter>(HyOperatingParameter.class);
        return util.exportExcel(list, "parameter");
    }

    /**
     * 新增运行参数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存运行参数
     */
    @ApiOperation("运行参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyOperatingParameter", value = "项目实体类hyOperatingParameter", required = true),
	})
    @RequiresPermissions("system:parameter:add")
    @Log(title = "运行参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyOperatingParameter hyOperatingParameter)
    {
        return toAjax(hyOperatingParameterService.insertHyOperatingParameter(hyOperatingParameter));
    }

    /**
     * 修改运行参数
     */
    @ApiOperation("运行参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyOperatingParameter hyOperatingParameter = hyOperatingParameterService.selectHyOperatingParameterById(id);
        mmap.put("hyOperatingParameter", hyOperatingParameter);
        return prefix + "/edit";
    }

    /**
     * 修改保存运行参数
     */
    @ApiOperation("运行参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyOperatingParameter", value = "项目实体类hyOperatingParameter", required = true),
	})
    @RequiresPermissions("system:parameter:edit")
    @Log(title = "运行参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyOperatingParameter hyOperatingParameter)
    {
        return toAjax(hyOperatingParameterService.updateHyOperatingParameter(hyOperatingParameter));
    }

    /**
     * 删除运行参数
     */
    @ApiOperation("运行参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:parameter:remove")
    @Log(title = "运行参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyOperatingParameterService.deleteHyOperatingParameterByIds(ids));
    }
}
