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
import com.ruoyi.system.domain.HyUnionpayBusiness;
import com.ruoyi.system.service.IHyUnionpayBusinessService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 银联商务Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@RequestMapping("/system/unionpayBusiness")
@Api(tags = "银联商务Controller")
public class HyUnionpayBusinessController extends BaseController
{
    private String prefix = "system/business";

    @Autowired
    private IHyUnionpayBusinessService hyUnionpayBusinessService;

    @RequiresPermissions("system:business:view")
    @GetMapping()
    public String business()
    {
        return prefix + "/business";
    }

    /**
     * 查询银联商务列表
     */
    @ApiOperation("银联商务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyUnionpayBusiness", value = "项目实体类hyUnionpayBusiness", required = true),
	})
    @RequiresPermissions("system:business:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyUnionpayBusiness hyUnionpayBusiness)
    {
        startPage();
        List<HyUnionpayBusiness> list = hyUnionpayBusinessService.selectHyUnionpayBusinessList(hyUnionpayBusiness);
        return getDataTable(list);
    }

    /**
     * 导出银联商务列表
     */
    @ApiOperation("银联商务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyUnionpayBusiness", value = "项目实体类hyUnionpayBusiness", required = true),
	})
    @RequiresPermissions("system:business:export")
    @Log(title = "银联商务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyUnionpayBusiness hyUnionpayBusiness)
    {
        List<HyUnionpayBusiness> list = hyUnionpayBusinessService.selectHyUnionpayBusinessList(hyUnionpayBusiness);
        ExcelUtil<HyUnionpayBusiness> util = new ExcelUtil<HyUnionpayBusiness>(HyUnionpayBusiness.class);
        return util.exportExcel(list, "business");
    }

    /**
     * 新增银联商务
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存银联商务
     */
    @ApiOperation("银联商务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyUnionpayBusiness", value = "项目实体类hyUnionpayBusiness", required = true),
	})
    @RequiresPermissions("system:business:add")
    @Log(title = "银联商务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyUnionpayBusiness hyUnionpayBusiness)
    {
        return toAjax(hyUnionpayBusinessService.insertHyUnionpayBusiness(hyUnionpayBusiness));
    }

    /**
     * 修改银联商务
     */
    @ApiOperation("银联商务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyUnionpayBusiness hyUnionpayBusiness = hyUnionpayBusinessService.selectHyUnionpayBusinessById(id);
        mmap.put("hyUnionpayBusiness", hyUnionpayBusiness);
        return prefix + "/edit";
    }

    /**
     * 修改保存银联商务
     */
    @ApiOperation("银联商务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyUnionpayBusiness", value = "项目实体类hyUnionpayBusiness", required = true),
	})
    @RequiresPermissions("system:business:edit")
    @Log(title = "银联商务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyUnionpayBusiness hyUnionpayBusiness)
    {
        return toAjax(hyUnionpayBusinessService.updateHyUnionpayBusiness(hyUnionpayBusiness));
    }

    /**
     * 删除银联商务
     */
    @ApiOperation("银联商务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:business:remove")
    @Log(title = "银联商务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyUnionpayBusinessService.deleteHyUnionpayBusinessByIds(ids));
    }
}
