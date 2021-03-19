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
import com.ruoyi.system.domain.HyThirdPayment;
import com.ruoyi.system.service.IHyThirdPaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 微信支付第三方Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@RequestMapping("/system/payment")
@Api(tags = "微信支付第三方Controller")
public class HyThirdPaymentController extends BaseController
{
    private String prefix = "system/payment";

    @Autowired
    private IHyThirdPaymentService hyThirdPaymentService;

    @RequiresPermissions("system:payment:view")
    @GetMapping()
    public String payment()
    {
        return prefix + "/payment";
    }

    /**
     * 查询微信支付第三方列表
     */
    @ApiOperation("微信支付第三方")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyThirdPayment", value = "项目实体类hyThirdPayment", required = true),
	})
    @RequiresPermissions("system:payment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyThirdPayment hyThirdPayment)
    {
        startPage();
        List<HyThirdPayment> list = hyThirdPaymentService.selectHyThirdPaymentList(hyThirdPayment);
        return getDataTable(list);
    }

    /**
     * 导出微信支付第三方列表
     */
    @ApiOperation("微信支付第三方")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyThirdPayment", value = "项目实体类hyThirdPayment", required = true),
	})
    @RequiresPermissions("system:payment:export")
    @Log(title = "微信支付第三方", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyThirdPayment hyThirdPayment)
    {
        List<HyThirdPayment> list = hyThirdPaymentService.selectHyThirdPaymentList(hyThirdPayment);
        ExcelUtil<HyThirdPayment> util = new ExcelUtil<HyThirdPayment>(HyThirdPayment.class);
        return util.exportExcel(list, "payment");
    }

    /**
     * 新增微信支付第三方
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存微信支付第三方
     */
    @ApiOperation("微信支付第三方")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyThirdPayment", value = "项目实体类hyThirdPayment", required = true),
	})
    @RequiresPermissions("system:payment:add")
    @Log(title = "微信支付第三方", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyThirdPayment hyThirdPayment)
    {
        return toAjax(hyThirdPaymentService.insertHyThirdPayment(hyThirdPayment));
    }

    /**
     * 修改微信支付第三方
     */
    @ApiOperation("微信支付第三方")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyThirdPayment hyThirdPayment = hyThirdPaymentService.selectHyThirdPaymentById(id);
        mmap.put("hyThirdPayment", hyThirdPayment);
        return prefix + "/edit";
    }

    /**
     * 修改保存微信支付第三方
     */
    @ApiOperation("微信支付第三方")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyThirdPayment", value = "项目实体类hyThirdPayment", required = true),
	})
    @RequiresPermissions("system:payment:edit")
    @Log(title = "微信支付第三方", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyThirdPayment hyThirdPayment)
    {
        return toAjax(hyThirdPaymentService.updateHyThirdPayment(hyThirdPayment));
    }

    /**
     * 删除微信支付第三方
     */
    @ApiOperation("微信支付第三方")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:payment:remove")
    @Log(title = "微信支付第三方", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyThirdPaymentService.deleteHyThirdPaymentByIds(ids));
    }
}
