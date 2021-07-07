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
import com.ruoyi.system.domain.HyEverbrightBankPayment;
import com.ruoyi.system.service.IHyEverbrightBankPaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 光大银行支付Controller
 * 
 * @author Administrator
 * @date 2021-03-19
 */
@Controller
@CrossOrigin
@RequestMapping("/system/bankPayment")
@Api(tags = "光大银行支付Controller")
public class HyEverbrightBankPaymentController extends BaseController
{
    private String prefix = "system/bankPayment";

    @Autowired
    private IHyEverbrightBankPaymentService hyEverbrightBankPaymentService;

    @RequiresPermissions("system:payment:view")
    @GetMapping()
    public String payment()
    {
        return prefix + "/payment";
    }

    /**
     * 查询光大银行支付列表
     */
    @ApiOperation("光大银行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEverbrightBankPayment", value = "项目实体类hyEverbrightBankPayment", required = true),
	})
    @RequiresPermissions("system:payment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyEverbrightBankPayment hyEverbrightBankPayment)
    {
        startPage();
        List<HyEverbrightBankPayment> list = hyEverbrightBankPaymentService.selectHyEverbrightBankPaymentList(hyEverbrightBankPayment);
        return getDataTable(list);
    }

    /**
     * 导出光大银行支付列表
     */
    @ApiOperation("光大银行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEverbrightBankPayment", value = "项目实体类hyEverbrightBankPayment", required = true),
	})
    @RequiresPermissions("system:payment:export")
    @Log(title = "光大银行支付", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyEverbrightBankPayment hyEverbrightBankPayment)
    {
        List<HyEverbrightBankPayment> list = hyEverbrightBankPaymentService.selectHyEverbrightBankPaymentList(hyEverbrightBankPayment);
        ExcelUtil<HyEverbrightBankPayment> util = new ExcelUtil<HyEverbrightBankPayment>(HyEverbrightBankPayment.class);
        return util.exportExcel(list, "payment");
    }

    /**
     * 新增光大银行支付
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存光大银行支付
     */
    @ApiOperation("光大银行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEverbrightBankPayment", value = "项目实体类hyEverbrightBankPayment", required = true),
	})
    @RequiresPermissions("system:payment:add")
    @Log(title = "光大银行支付", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyEverbrightBankPayment hyEverbrightBankPayment)
    {
        return toAjax(hyEverbrightBankPaymentService.insertHyEverbrightBankPayment(hyEverbrightBankPayment));
    }

    /**
     * 修改光大银行支付
     */
    @ApiOperation("光大银行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyEverbrightBankPayment hyEverbrightBankPayment = hyEverbrightBankPaymentService.selectHyEverbrightBankPaymentById(id);
        mmap.put("hyEverbrightBankPayment", hyEverbrightBankPayment);
        return prefix + "/edit";
    }

    /**
     * 修改保存光大银行支付
     */
    @ApiOperation("光大银行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEverbrightBankPayment", value = "项目实体类hyEverbrightBankPayment", required = true),
	})
    @RequiresPermissions("system:payment:edit")
    @Log(title = "光大银行支付", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyEverbrightBankPayment hyEverbrightBankPayment)
    {
        return toAjax(hyEverbrightBankPaymentService.updateHyEverbrightBankPayment(hyEverbrightBankPayment));
    }

    /**
     * 删除光大银行支付
     */
    @ApiOperation("光大银行支付")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:payment:remove")
    @Log(title = "光大银行支付", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyEverbrightBankPaymentService.deleteHyEverbrightBankPaymentByIds(ids));
    }
}
