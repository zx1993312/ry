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
import com.ruoyi.system.domain.HyAlipay;
import com.ruoyi.system.service.IHyAlipayService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 支付宝Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@RequestMapping("/system/alipay")
@Api(tags = "支付宝Controller")
public class HyAlipayController extends BaseController
{
    private String prefix = "system/alipay";

    @Autowired
    private IHyAlipayService hyAlipayService;

    @RequiresPermissions("system:alipay:view")
    @GetMapping()
    public String alipay()
    {
        return prefix + "/alipay";
    }

    /**
     * 查询支付宝列表
     */
    @ApiOperation("支付宝")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAlipay", value = "项目实体类hyAlipay", required = true),
	})
    @RequiresPermissions("system:alipay:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyAlipay hyAlipay)
    {
        startPage();
        List<HyAlipay> list = hyAlipayService.selectHyAlipayList(hyAlipay);
        return getDataTable(list);
    }

    /**
     * 导出支付宝列表
     */
    @ApiOperation("支付宝")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAlipay", value = "项目实体类hyAlipay", required = true),
	})
    @RequiresPermissions("system:alipay:export")
    @Log(title = "支付宝", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyAlipay hyAlipay)
    {
        List<HyAlipay> list = hyAlipayService.selectHyAlipayList(hyAlipay);
        ExcelUtil<HyAlipay> util = new ExcelUtil<HyAlipay>(HyAlipay.class);
        return util.exportExcel(list, "alipay");
    }

    /**
     * 新增支付宝
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存支付宝
     */
    @ApiOperation("支付宝")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAlipay", value = "项目实体类hyAlipay", required = true),
	})
    @RequiresPermissions("system:alipay:add")
    @Log(title = "支付宝", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyAlipay hyAlipay)
    {
        return toAjax(hyAlipayService.insertHyAlipay(hyAlipay));
    }

    /**
     * 修改支付宝
     */
    @ApiOperation("支付宝")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyAlipay hyAlipay = hyAlipayService.selectHyAlipayById(id);
        mmap.put("hyAlipay", hyAlipay);
        return prefix + "/edit";
    }

    /**
     * 修改保存支付宝
     */
    @ApiOperation("支付宝")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAlipay", value = "项目实体类hyAlipay", required = true),
	})
    @RequiresPermissions("system:alipay:edit")
    @Log(title = "支付宝", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyAlipay hyAlipay)
    {
        return toAjax(hyAlipayService.updateHyAlipay(hyAlipay));
    }

    /**
     * 删除支付宝
     */
    @ApiOperation("支付宝")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:alipay:remove")
    @Log(title = "支付宝", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyAlipayService.deleteHyAlipayByIds(ids));
    }
}
