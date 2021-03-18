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
import com.ruoyi.system.domain.HyResidentialQuartersPicture;
import com.ruoyi.system.service.IHyResidentialQuartersPictureService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小区图片Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@RequestMapping("/system/ResidentialQuartersPicture")
@Api(tags = "小区图片Controller")
public class HyResidentialQuartersPictureController extends BaseController
{
    private String prefix = "system/ResidentialQuartersPicture";

    @Autowired
    private IHyResidentialQuartersPictureService hyResidentialQuartersPictureService;

    @RequiresPermissions("system:picture:view")
    @GetMapping()
    public String picture()
    {
        return prefix + "/picture";
    }

    /**
     * 查询小区图片列表
     */
    @ApiOperation("小区图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyResidentialQuartersPicture", value = "项目实体类hyResidentialQuartersPicture", required = true),
	})
    @RequiresPermissions("system:picture:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyResidentialQuartersPicture hyResidentialQuartersPicture)
    {
        startPage();
        List<HyResidentialQuartersPicture> list = hyResidentialQuartersPictureService.selectHyResidentialQuartersPictureList(hyResidentialQuartersPicture);
        return getDataTable(list);
    }

    /**
     * 导出小区图片列表
     */
    @ApiOperation("小区图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyResidentialQuartersPicture", value = "项目实体类hyResidentialQuartersPicture", required = true),
	})
    @RequiresPermissions("system:picture:export")
    @Log(title = "小区图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyResidentialQuartersPicture hyResidentialQuartersPicture)
    {
        List<HyResidentialQuartersPicture> list = hyResidentialQuartersPictureService.selectHyResidentialQuartersPictureList(hyResidentialQuartersPicture);
        ExcelUtil<HyResidentialQuartersPicture> util = new ExcelUtil<HyResidentialQuartersPicture>(HyResidentialQuartersPicture.class);
        return util.exportExcel(list, "picture");
    }

    /**
     * 新增小区图片
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存小区图片
     */
    @ApiOperation("小区图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyResidentialQuartersPicture", value = "项目实体类hyResidentialQuartersPicture", required = true),
	})
    @RequiresPermissions("system:picture:add")
    @Log(title = "小区图片", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyResidentialQuartersPicture hyResidentialQuartersPicture)
    {
        return toAjax(hyResidentialQuartersPictureService.insertHyResidentialQuartersPicture(hyResidentialQuartersPicture));
    }

    /**
     * 修改小区图片
     */
    @ApiOperation("小区图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyResidentialQuartersPicture hyResidentialQuartersPicture = hyResidentialQuartersPictureService.selectHyResidentialQuartersPictureById(id);
        mmap.put("hyResidentialQuartersPicture", hyResidentialQuartersPicture);
        return prefix + "/edit";
    }

    /**
     * 修改保存小区图片
     */
    @ApiOperation("小区图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyResidentialQuartersPicture", value = "项目实体类hyResidentialQuartersPicture", required = true),
	})
    @RequiresPermissions("system:picture:edit")
    @Log(title = "小区图片", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyResidentialQuartersPicture hyResidentialQuartersPicture)
    {
        return toAjax(hyResidentialQuartersPictureService.updateHyResidentialQuartersPicture(hyResidentialQuartersPicture));
    }

    /**
     * 删除小区图片
     */
    @ApiOperation("小区图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:picture:remove")
    @Log(title = "小区图片", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyResidentialQuartersPictureService.deleteHyResidentialQuartersPictureByIds(ids));
    }
}
