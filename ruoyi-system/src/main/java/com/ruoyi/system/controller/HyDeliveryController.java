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
import com.ruoyi.system.domain.HyDelivery;
import com.ruoyi.system.service.IHyDeliveryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出库管理Controller
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Controller
@CrossOrigin
@RequestMapping("/system/delivery")
@Api(tags = "出库管理Controller")
public class HyDeliveryController extends BaseController
{
    private String prefix = "system/delivery";

    @Autowired
    private IHyDeliveryService hyDeliveryService;

    @RequiresPermissions("system:delivery:view")
    @GetMapping()
    public String delivery()
    {
        return prefix + "/delivery";
    }

    /**
     * 查询出库管理列表
     */
    @ApiOperation("出库管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDelivery", value = "项目实体类hyDelivery", required = true),
	})
    @RequiresPermissions("system:delivery:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyDelivery hyDelivery)
    {
        startPage();
        List<HyDelivery> list = hyDeliveryService.selectHyDeliveryList(hyDelivery);
        return getDataTable(list);
    }

    /**
     * 导出出库管理列表
     */
    @ApiOperation("出库管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDelivery", value = "项目实体类hyDelivery", required = true),
	})
    @RequiresPermissions("system:delivery:export")
    @Log(title = "出库管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyDelivery hyDelivery)
    {
        List<HyDelivery> list = hyDeliveryService.selectHyDeliveryList(hyDelivery);
        ExcelUtil<HyDelivery> util = new ExcelUtil<HyDelivery>(HyDelivery.class);
        return util.exportExcel(list, "delivery");
    }

    /**
     * 新增出库管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存出库管理
     */
    @ApiOperation("出库管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDelivery", value = "项目实体类hyDelivery", required = true),
	})
    @RequiresPermissions("system:delivery:add")
    @Log(title = "出库管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyDelivery hyDelivery)
    {
        return toAjax(hyDeliveryService.insertHyDelivery(hyDelivery));
    }

    /**
     * 修改出库管理
     */
    @ApiOperation("出库管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyDelivery hyDelivery = hyDeliveryService.selectHyDeliveryById(id);
        mmap.put("hyDelivery", hyDelivery);
        return prefix + "/edit";
    }

    /**
     * 修改保存出库管理
     */
    @ApiOperation("出库管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDelivery", value = "项目实体类hyDelivery", required = true),
	})
    @RequiresPermissions("system:delivery:edit")
    @Log(title = "出库管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyDelivery hyDelivery)
    {
        return toAjax(hyDeliveryService.updateHyDelivery(hyDelivery));
    }

    /**
     * 删除出库管理
     */
    @ApiOperation("出库管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:delivery:remove")
    @Log(title = "出库管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyDeliveryService.deleteHyDeliveryByIds(ids));
    }
}
