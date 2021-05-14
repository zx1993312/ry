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
import com.ruoyi.system.domain.HyTransfers;
import com.ruoyi.system.service.IHyTransfersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备调拨一览Controller
 * 
 * @author Administrator
 * @date 2021-05-14
 */
@Controller
@RequestMapping("/system/transfers")
@Api(tags = "设备调拨一览Controller")
public class HyTransfersController extends BaseController
{
    private String prefix = "system/transfers";

    @Autowired
    private IHyTransfersService hyTransfersService;

    @RequiresPermissions("system:transfers:view")
    @GetMapping()
    public String transfers()
    {
        return prefix + "/transfers";
    }

    /**
     * 查询设备调拨一览列表
     */
    @ApiOperation("设备调拨一览")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTransfers", value = "项目实体类hyTransfers", required = true),
	})
    @RequiresPermissions("system:transfers:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyTransfers hyTransfers)
    {
        startPage();
        List<HyTransfers> list = hyTransfersService.selectHyTransfersList(hyTransfers);
        return getDataTable(list);
    }

    /**
     * 导出设备调拨一览列表
     */
    @ApiOperation("设备调拨一览")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTransfers", value = "项目实体类hyTransfers", required = true),
	})
    @RequiresPermissions("system:transfers:export")
    @Log(title = "设备调拨一览", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyTransfers hyTransfers)
    {
        List<HyTransfers> list = hyTransfersService.selectHyTransfersList(hyTransfers);
        ExcelUtil<HyTransfers> util = new ExcelUtil<HyTransfers>(HyTransfers.class);
        return util.exportExcel(list, "transfers");
    }

    /**
     * 新增设备调拨一览
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备调拨一览
     */
    @ApiOperation("设备调拨一览")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTransfers", value = "项目实体类hyTransfers", required = true),
	})
    @RequiresPermissions("system:transfers:add")
    @Log(title = "设备调拨一览", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyTransfers hyTransfers)
    {
        return toAjax(hyTransfersService.insertHyTransfers(hyTransfers));
    }

    /**
     * 修改设备调拨一览
     */
    @ApiOperation("设备调拨一览")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyTransfers hyTransfers = hyTransfersService.selectHyTransfersById(id);
        mmap.put("hyTransfers", hyTransfers);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备调拨一览
     */
    @ApiOperation("设备调拨一览")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTransfers", value = "项目实体类hyTransfers", required = true),
	})
    @RequiresPermissions("system:transfers:edit")
    @Log(title = "设备调拨一览", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyTransfers hyTransfers)
    {
        return toAjax(hyTransfersService.updateHyTransfers(hyTransfers));
    }

    /**
     * 删除设备调拨一览
     */
    @ApiOperation("设备调拨一览")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:transfers:remove")
    @Log(title = "设备调拨一览", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyTransfersService.deleteHyTransfersByIds(ids));
    }
}
