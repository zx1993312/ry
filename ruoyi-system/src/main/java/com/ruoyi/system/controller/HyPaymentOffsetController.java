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
import com.ruoyi.system.domain.HyPaymentOffset;
import com.ruoyi.system.service.IHyPaymentOffsetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预交冲抵Controller
 * 
 * @author Administrator
 * @date 2021-05-26
 */
@Controller
@CrossOrigin
@RequestMapping("/system/offset")
@Api(tags = "预交冲抵Controller")
public class HyPaymentOffsetController extends BaseController
{
    private String prefix = "system/offset";

    @Autowired
    private IHyPaymentOffsetService hyPaymentOffsetService;

    @RequiresPermissions("system:offset:view")
    @GetMapping()
    public String offset()
    {
        return prefix + "/offset";
    }

    /**
     * 查询预交冲抵列表
     */
    @ApiOperation("预交冲抵")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPaymentOffset", value = "项目实体类hyPaymentOffset", required = true),
	})
    @RequiresPermissions("system:offset:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyPaymentOffset hyPaymentOffset)
    {
        startPage();
        List<HyPaymentOffset> list = hyPaymentOffsetService.selectHyPaymentOffsetList(hyPaymentOffset);
        return getDataTable(list);
    }

    /**
     * 导出预交冲抵列表
     */
    @ApiOperation("预交冲抵")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPaymentOffset", value = "项目实体类hyPaymentOffset", required = true),
	})
    @RequiresPermissions("system:offset:export")
    @Log(title = "预交冲抵", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyPaymentOffset hyPaymentOffset)
    {
        List<HyPaymentOffset> list = hyPaymentOffsetService.selectHyPaymentOffsetList(hyPaymentOffset);
        ExcelUtil<HyPaymentOffset> util = new ExcelUtil<HyPaymentOffset>(HyPaymentOffset.class);
        return util.exportExcel(list, "offset");
    }

    /**
     * 新增预交冲抵
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存预交冲抵
     */
    @ApiOperation("预交冲抵")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPaymentOffset", value = "项目实体类hyPaymentOffset", required = true),
	})
    @RequiresPermissions("system:offset:add")
    @Log(title = "预交冲抵", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyPaymentOffset hyPaymentOffset)
    {
        return toAjax(hyPaymentOffsetService.insertHyPaymentOffset(hyPaymentOffset));
    }

    /**
     * 修改预交冲抵
     */
    @ApiOperation("预交冲抵")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyPaymentOffset hyPaymentOffset = hyPaymentOffsetService.selectHyPaymentOffsetById(id);
        mmap.put("hyPaymentOffset", hyPaymentOffset);
        return prefix + "/edit";
    }

    /**
     * 修改保存预交冲抵
     */
    @ApiOperation("预交冲抵")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPaymentOffset", value = "项目实体类hyPaymentOffset", required = true),
	})
    @RequiresPermissions("system:offset:edit")
    @Log(title = "预交冲抵", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyPaymentOffset hyPaymentOffset)
    {
        return toAjax(hyPaymentOffsetService.updateHyPaymentOffset(hyPaymentOffset));
    }

    /**
     * 删除预交冲抵
     */
    @ApiOperation("预交冲抵")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:offset:remove")
    @Log(title = "预交冲抵", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyPaymentOffsetService.deleteHyPaymentOffsetByIds(ids));
    }
}