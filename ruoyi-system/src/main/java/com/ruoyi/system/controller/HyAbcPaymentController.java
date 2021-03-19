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
import com.ruoyi.system.domain.HyAbcPayment;
import com.ruoyi.system.service.IHyAbcPaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 农行支付Controller
 * 
 * @author Administrator
 * @date 2021-03-19
 */
@Controller
@RequestMapping("/system/abcPayment")
@Api(tags = "农行支付Controller")
public class HyAbcPaymentController extends BaseController
{
    private String prefix = "system/abcPayment";

    @Autowired
    private IHyAbcPaymentService hyAbcPaymentService;

    @RequiresPermissions("system:payment:view")
    @GetMapping()
    public String payment()
    {
        return prefix + "/payment";
    }

    /**
     * 查询农行支付列表
     */
    @ApiOperation("农行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAbcPayment", value = "项目实体类hyAbcPayment", required = true),
	})
    @RequiresPermissions("system:payment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyAbcPayment hyAbcPayment)
    {
        startPage();
        List<HyAbcPayment> list = hyAbcPaymentService.selectHyAbcPaymentList(hyAbcPayment);
        return getDataTable(list);
    }

    /**
     * 导出农行支付列表
     */
    @ApiOperation("农行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAbcPayment", value = "项目实体类hyAbcPayment", required = true),
	})
    @RequiresPermissions("system:payment:export")
    @Log(title = "农行支付", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyAbcPayment hyAbcPayment)
    {
        List<HyAbcPayment> list = hyAbcPaymentService.selectHyAbcPaymentList(hyAbcPayment);
        ExcelUtil<HyAbcPayment> util = new ExcelUtil<HyAbcPayment>(HyAbcPayment.class);
        return util.exportExcel(list, "payment");
    }

    /**
     * 新增农行支付
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存农行支付
     */
    @ApiOperation("农行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAbcPayment", value = "项目实体类hyAbcPayment", required = true),
	})
    @RequiresPermissions("system:payment:add")
    @Log(title = "农行支付", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyAbcPayment hyAbcPayment)
    {
        return toAjax(hyAbcPaymentService.insertHyAbcPayment(hyAbcPayment));
    }

    /**
     * 修改农行支付
     */
    @ApiOperation("农行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyAbcPayment hyAbcPayment = hyAbcPaymentService.selectHyAbcPaymentById(id);
        mmap.put("hyAbcPayment", hyAbcPayment);
        return prefix + "/edit";
    }

    /**
     * 修改保存农行支付
     */
    @ApiOperation("农行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAbcPayment", value = "项目实体类hyAbcPayment", required = true),
	})
    @RequiresPermissions("system:payment:edit")
    @Log(title = "农行支付", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyAbcPayment hyAbcPayment)
    {
        return toAjax(hyAbcPaymentService.updateHyAbcPayment(hyAbcPayment));
    }

    /**
     * 删除农行支付
     */
    @ApiOperation("农行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:payment:remove")
    @Log(title = "农行支付", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyAbcPaymentService.deleteHyAbcPaymentByIds(ids));
    }
}
