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
import com.ruoyi.system.domain.HyServiceProviderAccountNumber;
import com.ruoyi.system.service.IHyServiceProviderAccountNumberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 服务商商户号Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@CrossOrigin
@RequestMapping("/system/number")
@Api(tags = "服务商商户号Controller")
public class HyServiceProviderAccountNumberController extends BaseController
{
    private String prefix = "system/number";

    @Autowired
    private IHyServiceProviderAccountNumberService hyServiceProviderAccountNumberService;

    @RequiresPermissions("system:number:view")
    @GetMapping()
    public String number()
    {
        return prefix + "/number";
    }

    /**
     * 查询服务商商户号列表
     */
    @ApiOperation("服务商商户号")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServiceProviderAccountNumber", value = "项目实体类hyServiceProviderAccountNumber", required = true),
	})
    @RequiresPermissions("system:number:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyServiceProviderAccountNumber hyServiceProviderAccountNumber)
    {
        startPage();
        List<HyServiceProviderAccountNumber> list = hyServiceProviderAccountNumberService.selectHyServiceProviderAccountNumberList(hyServiceProviderAccountNumber);
        return getDataTable(list);
    }

    /**
     * 导出服务商商户号列表
     */
    @ApiOperation("服务商商户号")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServiceProviderAccountNumber", value = "项目实体类hyServiceProviderAccountNumber", required = true),
	})
    @RequiresPermissions("system:number:export")
    @Log(title = "服务商商户号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyServiceProviderAccountNumber hyServiceProviderAccountNumber)
    {
        List<HyServiceProviderAccountNumber> list = hyServiceProviderAccountNumberService.selectHyServiceProviderAccountNumberList(hyServiceProviderAccountNumber);
        ExcelUtil<HyServiceProviderAccountNumber> util = new ExcelUtil<HyServiceProviderAccountNumber>(HyServiceProviderAccountNumber.class);
        return util.exportExcel(list, "number");
    }

    /**
     * 新增服务商商户号
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存服务商商户号
     */
    @ApiOperation("服务商商户号")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServiceProviderAccountNumber", value = "项目实体类hyServiceProviderAccountNumber", required = true),
	})
    @RequiresPermissions("system:number:add")
    @Log(title = "服务商商户号", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyServiceProviderAccountNumber hyServiceProviderAccountNumber)
    {
        return toAjax(hyServiceProviderAccountNumberService.insertHyServiceProviderAccountNumber(hyServiceProviderAccountNumber));
    }

    /**
     * 修改服务商商户号
     */
    @ApiOperation("服务商商户号")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyServiceProviderAccountNumber hyServiceProviderAccountNumber = hyServiceProviderAccountNumberService.selectHyServiceProviderAccountNumberById(id);
        mmap.put("hyServiceProviderAccountNumber", hyServiceProviderAccountNumber);
        return prefix + "/edit";
    }

    /**
     * 修改保存服务商商户号
     */
    @ApiOperation("服务商商户号")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyServiceProviderAccountNumber", value = "项目实体类hyServiceProviderAccountNumber", required = true),
	})
    @RequiresPermissions("system:number:edit")
    @Log(title = "服务商商户号", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyServiceProviderAccountNumber hyServiceProviderAccountNumber)
    {
        return toAjax(hyServiceProviderAccountNumberService.updateHyServiceProviderAccountNumber(hyServiceProviderAccountNumber));
    }

    /**
     * 删除服务商商户号
     */
    @ApiOperation("服务商商户号")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:number:remove")
    @Log(title = "服务商商户号", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyServiceProviderAccountNumberService.deleteHyServiceProviderAccountNumberByIds(ids));
    }
}
