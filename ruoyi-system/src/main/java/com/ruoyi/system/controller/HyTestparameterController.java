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
import com.ruoyi.system.domain.HyTestparameter;
import com.ruoyi.system.service.IHyTestparameterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检测参数Controller
 * 
 * @author Administrator
 * @date 2021-05-10
 */
@Controller
@RequestMapping("/system/testparameter")
@Api(tags = "检测参数Controller")
public class HyTestparameterController extends BaseController
{
    private String prefix = "system/testparameter";

    @Autowired
    private IHyTestparameterService hyTestparameterService;

    @RequiresPermissions("system:testparameter:view")
    @GetMapping()
    public String testparameter()
    {
        return prefix + "/testparameter";
    }

    /**
     * 查询检测参数列表
     */
    @ApiOperation("检测参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTestparameter", value = "项目实体类hyTestparameter", required = true),
	})
    @RequiresPermissions("system:testparameter:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyTestparameter hyTestparameter)
    {
        startPage();
        List<HyTestparameter> list = hyTestparameterService.selectHyTestparameterList(hyTestparameter);
        return getDataTable(list);
    }

    /**
     * 导出检测参数列表
     */
    @ApiOperation("检测参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTestparameter", value = "项目实体类hyTestparameter", required = true),
	})
    @RequiresPermissions("system:testparameter:export")
    @Log(title = "检测参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyTestparameter hyTestparameter)
    {
        List<HyTestparameter> list = hyTestparameterService.selectHyTestparameterList(hyTestparameter);
        ExcelUtil<HyTestparameter> util = new ExcelUtil<HyTestparameter>(HyTestparameter.class);
        return util.exportExcel(list, "testparameter");
    }

    /**
     * 新增检测参数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存检测参数
     */
    @ApiOperation("检测参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTestparameter", value = "项目实体类hyTestparameter", required = true),
	})
    @RequiresPermissions("system:testparameter:add")
    @Log(title = "检测参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyTestparameter hyTestparameter)
    {
        return toAjax(hyTestparameterService.insertHyTestparameter(hyTestparameter));
    }

    /**
     * 修改检测参数
     */
    @ApiOperation("检测参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyTestparameter hyTestparameter = hyTestparameterService.selectHyTestparameterById(id);
        mmap.put("hyTestparameter", hyTestparameter);
        return prefix + "/edit";
    }

    /**
     * 修改保存检测参数
     */
    @ApiOperation("检测参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTestparameter", value = "项目实体类hyTestparameter", required = true),
	})
    @RequiresPermissions("system:testparameter:edit")
    @Log(title = "检测参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyTestparameter hyTestparameter)
    {
        return toAjax(hyTestparameterService.updateHyTestparameter(hyTestparameter));
    }

    /**
     * 删除检测参数
     */
    @ApiOperation("检测参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:testparameter:remove")
    @Log(title = "检测参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyTestparameterService.deleteHyTestparameterByIds(ids));
    }
}
