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
import com.ruoyi.system.domain.HyInspectionDetail;
import com.ruoyi.system.service.IHyInspectionDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 巡检线路明细Controller
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Controller
@CrossOrigin
@RequestMapping("/system/detail")
@Api(tags = "巡检线路明细Controller")
public class HyInspectionDetailController extends BaseController
{
    private String prefix = "system/detail";

    @Autowired
    private IHyInspectionDetailService hyInspectionDetailService;

    @RequiresPermissions("system:detail:view")
    @GetMapping()
    public String detail()
    {
        return prefix + "/detail";
    }

    /**
     * 查询巡检线路明细列表
     */
    @ApiOperation("巡检线路明细")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInspectionDetail", value = "线路实体类hyInspectionDetail", required = true),
	})
    @RequiresPermissions("system:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyInspectionDetail hyInspectionDetail)
    {
        startPage();
        List<HyInspectionDetail> list = hyInspectionDetailService.selectHyInspectionDetailList(hyInspectionDetail);
        return getDataTable(list);
    }

    /**
     * 导出巡检线路明细列表
     */
    @ApiOperation("巡检线路明细")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInspectionDetail", value = "线路实体类hyInspectionDetail", required = true),
	})
    @RequiresPermissions("system:detail:export")
    @Log(title = "巡检线路明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyInspectionDetail hyInspectionDetail)
    {
        List<HyInspectionDetail> list = hyInspectionDetailService.selectHyInspectionDetailList(hyInspectionDetail);
        ExcelUtil<HyInspectionDetail> util = new ExcelUtil<HyInspectionDetail>(HyInspectionDetail.class);
        return util.exportExcel(list, "detail");
    }

    /**
     * 新增巡检线路明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存巡检线路明细
     */
    @ApiOperation("巡检线路明细")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInspectionDetail", value = "线路实体类hyInspectionDetail", required = true),
	})
    @RequiresPermissions("system:detail:add")
    @Log(title = "巡检线路明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyInspectionDetail hyInspectionDetail)
    {
        return toAjax(hyInspectionDetailService.insertHyInspectionDetail(hyInspectionDetail));
    }

    /**
     * 修改巡检线路明细
     */
    @ApiOperation("巡检线路明细")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyInspectionDetail hyInspectionDetail = hyInspectionDetailService.selectHyInspectionDetailById(id);
        mmap.put("hyInspectionDetail", hyInspectionDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存巡检线路明细
     */
    @ApiOperation("巡检线路明细")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyInspectionDetail", value = "线路实体类hyInspectionDetail", required = true),
	})
    @RequiresPermissions("system:detail:edit")
    @Log(title = "巡检线路明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyInspectionDetail hyInspectionDetail)
    {
        return toAjax(hyInspectionDetailService.updateHyInspectionDetail(hyInspectionDetail));
    }

    /**
     * 删除巡检线路明细
     */
    @ApiOperation("巡检线路明细")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:detail:remove")
    @Log(title = "巡检线路明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyInspectionDetailService.deleteHyInspectionDetailByIds(ids));
    }
}
