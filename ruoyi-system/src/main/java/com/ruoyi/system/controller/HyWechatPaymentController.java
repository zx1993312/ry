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
import com.ruoyi.system.domain.HyWechatPayment;
import com.ruoyi.system.service.IHyWechatPaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 微信支付Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@RequestMapping("/system/payment")
@Api(tags = "微信支付Controller")
public class HyWechatPaymentController extends BaseController
{
    private String prefix = "system/payment";

    @Autowired
    private IHyWechatPaymentService hyWechatPaymentService;

    @RequiresPermissions("system:payment:view")
    @GetMapping()
    public String payment()
    {
        return prefix + "/payment";
    }

    /**
     * 查询微信支付列表
     */
    @ApiOperation("微信支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyWechatPayment", value = "项目实体类hyWechatPayment", required = true),
	})
    @RequiresPermissions("system:payment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyWechatPayment hyWechatPayment)
    {
        startPage();
        List<HyWechatPayment> list = hyWechatPaymentService.selectHyWechatPaymentList(hyWechatPayment);
        return getDataTable(list);
    }

    /**
     * 导出微信支付列表
     */
    @ApiOperation("微信支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyWechatPayment", value = "项目实体类hyWechatPayment", required = true),
	})
    @RequiresPermissions("system:payment:export")
    @Log(title = "微信支付", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyWechatPayment hyWechatPayment)
    {
        List<HyWechatPayment> list = hyWechatPaymentService.selectHyWechatPaymentList(hyWechatPayment);
        ExcelUtil<HyWechatPayment> util = new ExcelUtil<HyWechatPayment>(HyWechatPayment.class);
        return util.exportExcel(list, "payment");
    }

    /**
     * 新增微信支付
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存微信支付
     */
    @ApiOperation("微信支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyWechatPayment", value = "项目实体类hyWechatPayment", required = true),
	})
    @RequiresPermissions("system:payment:add")
    @Log(title = "微信支付", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyWechatPayment hyWechatPayment)
    {
        return toAjax(hyWechatPaymentService.insertHyWechatPayment(hyWechatPayment));
    }

    /**
     * 修改微信支付
     */
    @ApiOperation("微信支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyWechatPayment hyWechatPayment = hyWechatPaymentService.selectHyWechatPaymentById(id);
        mmap.put("hyWechatPayment", hyWechatPayment);
        return prefix + "/edit";
    }

    /**
     * 修改保存微信支付
     */
    @ApiOperation("微信支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyWechatPayment", value = "项目实体类hyWechatPayment", required = true),
	})
    @RequiresPermissions("system:payment:edit")
    @Log(title = "微信支付", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyWechatPayment hyWechatPayment)
    {
        return toAjax(hyWechatPaymentService.updateHyWechatPayment(hyWechatPayment));
    }

    /**
     * 删除微信支付
     */
    @ApiOperation("微信支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:payment:remove")
    @Log(title = "微信支付", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyWechatPaymentService.deleteHyWechatPaymentByIds(ids));
    }
}
