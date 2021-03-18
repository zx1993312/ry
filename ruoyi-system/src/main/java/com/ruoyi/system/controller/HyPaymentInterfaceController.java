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
import com.ruoyi.system.domain.HyPaymentInterface;
import com.ruoyi.system.service.IHyPaymentInterfaceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 支付接口设置Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@RequestMapping("/system/interface")
@Api(tags = "支付接口设置Controller")
public class HyPaymentInterfaceController extends BaseController
{
    private String prefix = "system/interface";

    @Autowired
    private IHyPaymentInterfaceService hyPaymentInterfaceService;

    @RequiresPermissions("system:interface:view")
    @GetMapping()
    public String anterface()
    {
        return prefix + "/interface";
    }

    /**
     * 查询支付接口设置列表
     */
    @ApiOperation("支付接口设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPaymentInterface", value = "项目实体类hyPaymentInterface", required = true),
	})
    @RequiresPermissions("system:interface:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyPaymentInterface hyPaymentInterface)
    {
        startPage();
        List<HyPaymentInterface> list = hyPaymentInterfaceService.selectHyPaymentInterfaceList(hyPaymentInterface);
        return getDataTable(list);
    }

    /**
     * 导出支付接口设置列表
     */
    @ApiOperation("支付接口设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPaymentInterface", value = "项目实体类hyPaymentInterface", required = true),
	})
    @RequiresPermissions("system:interface:export")
    @Log(title = "支付接口设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyPaymentInterface hyPaymentInterface)
    {
        List<HyPaymentInterface> list = hyPaymentInterfaceService.selectHyPaymentInterfaceList(hyPaymentInterface);
        ExcelUtil<HyPaymentInterface> util = new ExcelUtil<HyPaymentInterface>(HyPaymentInterface.class);
        return util.exportExcel(list, "interface");
    }

    /**
     * 新增支付接口设置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存支付接口设置
     */
    @ApiOperation("支付接口设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPaymentInterface", value = "项目实体类hyPaymentInterface", required = true),
	})
    @RequiresPermissions("system:interface:add")
    @Log(title = "支付接口设置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyPaymentInterface hyPaymentInterface)
    {
        return toAjax(hyPaymentInterfaceService.insertHyPaymentInterface(hyPaymentInterface));
    }

    /**
     * 修改支付接口设置
     */
    @ApiOperation("支付接口设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyPaymentInterface hyPaymentInterface = hyPaymentInterfaceService.selectHyPaymentInterfaceById(id);
        mmap.put("hyPaymentInterface", hyPaymentInterface);
        return prefix + "/edit";
    }

    /**
     * 修改保存支付接口设置
     */
    @ApiOperation("支付接口设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPaymentInterface", value = "项目实体类hyPaymentInterface", required = true),
	})
    @RequiresPermissions("system:interface:edit")
    @Log(title = "支付接口设置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyPaymentInterface hyPaymentInterface)
    {
        return toAjax(hyPaymentInterfaceService.updateHyPaymentInterface(hyPaymentInterface));
    }

    /**
     * 删除支付接口设置
     */
    @ApiOperation("支付接口设置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:interface:remove")
    @Log(title = "支付接口设置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyPaymentInterfaceService.deleteHyPaymentInterfaceByIds(ids));
    }
}
