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
import com.ruoyi.system.domain.HyStockRecord;
import com.ruoyi.system.service.IHyStockRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出入库记录Controller
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/record")
@Api(tags = "出入库记录Controller")
public class HyStockRecordController extends BaseController
{
    private String prefix = "system/record";

    @Autowired
    private IHyStockRecordService hyStockRecordService;

    @RequiresPermissions("system:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询出入库记录列表
     */
    @ApiOperation("出入库记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyStockRecord", value = "项目实体类hyStockRecord", required = true),
	})
    @RequiresPermissions("system:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyStockRecord hyStockRecord)
    {
        startPage();
        List<HyStockRecord> list = hyStockRecordService.selectHyStockRecordList(hyStockRecord);
        System.out.println("list==========="+list);
        return getDataTable(list);
    }

    /**
     * 导出出入库记录列表
     */
    @ApiOperation("出入库记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyStockRecord", value = "项目实体类hyStockRecord", required = true),
	})
    @RequiresPermissions("system:record:export")
    @Log(title = "出入库记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyStockRecord hyStockRecord)
    {
        List<HyStockRecord> list = hyStockRecordService.selectHyStockRecordList(hyStockRecord);
        ExcelUtil<HyStockRecord> util = new ExcelUtil<HyStockRecord>(HyStockRecord.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 新增出入库记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存出入库记录
     */
    @ApiOperation("出入库记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyStockRecord", value = "项目实体类hyStockRecord", required = true),
	})
    @RequiresPermissions("system:record:add")
    @Log(title = "出入库记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyStockRecord hyStockRecord)
    {
        return toAjax(hyStockRecordService.insertHyStockRecord(hyStockRecord));
    }

    /**
     * 修改出入库记录
     */
    @ApiOperation("出入库记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyStockRecord hyStockRecord = hyStockRecordService.selectHyStockRecordById(id);
        mmap.put("hyStockRecord", hyStockRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存出入库记录
     */
    @ApiOperation("出入库记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyStockRecord", value = "项目实体类hyStockRecord", required = true),
	})
    @RequiresPermissions("system:record:edit")
    @Log(title = "出入库记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyStockRecord hyStockRecord)
    {
        return toAjax(hyStockRecordService.updateHyStockRecord(hyStockRecord));
    }

    /**
     * 删除出入库记录
     */
    @ApiOperation("出入库记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:record:remove")
    @Log(title = "出入库记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyStockRecordService.deleteHyStockRecordByIds(ids));
    }
}
