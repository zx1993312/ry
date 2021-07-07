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
import com.ruoyi.system.domain.HyBill;
import com.ruoyi.system.service.IHyBillService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 台账管理物料列Controller
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Controller
@CrossOrigin
@RequestMapping("/system/bill")
@Api(tags = "台账管理物料列Controller")
public class HyBillController extends BaseController
{
    private String prefix = "system/bill";

    @Autowired
    private IHyBillService hyBillService;

    @RequiresPermissions("system:bill:view")
    @GetMapping()
    public String bill()
    {
        return prefix + "/bill";
    }

    /**
     * 查询台账管理物料列列表
     */
    @ApiOperation("台账管理物料列")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBill", value = "项目实体类hyBill", required = true),
	})
    @RequiresPermissions("system:bill:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyBill hyBill)
    {
        startPage();
        List<HyBill> list = hyBillService.selectHyBillList(hyBill);
        System.out.println("===list==="+list);
        return getDataTable(list);
    }

    /**
     * 导出台账管理物料列列表
     */
    @ApiOperation("台账管理物料列")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBill", value = "项目实体类hyBill", required = true),
	})
    @RequiresPermissions("system:bill:export")
    @Log(title = "台账管理物料列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyBill hyBill)
    {
        List<HyBill> list = hyBillService.selectHyBillList(hyBill);
        ExcelUtil<HyBill> util = new ExcelUtil<HyBill>(HyBill.class);
        return util.exportExcel(list, "bill");
    }

    /**
     * 新增台账管理物料列
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存台账管理物料列
     */
    @ApiOperation("台账管理物料列")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBill", value = "项目实体类hyBill", required = true),
	})
    @RequiresPermissions("system:bill:add")
    @Log(title = "台账管理物料列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyBill hyBill)
    {
        return toAjax(hyBillService.insertHyBill(hyBill));
    }

    /**
     * 修改台账管理物料列
     */
    @ApiOperation("台账管理物料列")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyBill hyBill = hyBillService.selectHyBillById(id);
        mmap.put("hyBill", hyBill);
        return prefix + "/edit";
    }

    /**
     * 修改保存台账管理物料列
     */
    @ApiOperation("台账管理物料列")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBill", value = "项目实体类hyBill", required = true),
	})
    @RequiresPermissions("system:bill:edit")
    @Log(title = "台账管理物料列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyBill hyBill)
    {
        return toAjax(hyBillService.updateHyBill(hyBill));
    }

    /**
     * 删除台账管理物料列
     */
    @ApiOperation("台账管理物料列")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:bill:remove")
    @Log(title = "台账管理物料列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyBillService.deleteHyBillByIds(ids));
    }
}
