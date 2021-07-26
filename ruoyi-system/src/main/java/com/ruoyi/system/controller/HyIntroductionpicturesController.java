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
import com.ruoyi.system.domain.HyIntroductionpictures;
import com.ruoyi.system.service.IHyIntroductionpicturesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物业简介图片Controller
 * 
 * @author Administrator
 * @date 2021-07-26
 */
@Controller
@RequestMapping("/system/introductionpictures")
@Api(tags = "物业简介图片Controller")
public class HyIntroductionpicturesController extends BaseController
{
    private String prefix = "system/introductionpictures";

    @Autowired
    private IHyIntroductionpicturesService hyIntroductionpicturesService;

    @RequiresPermissions("system:introductionpictures:view")
    @GetMapping()
    public String introductionpictures()
    {
        return prefix + "/introductionpictures";
    }

    /**
     * 查询物业简介图片列表
     */
    @ApiOperation("物业简介图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyIntroductionpictures", value = "项目实体类hyIntroductionpictures", required = true),
	})
    @RequiresPermissions("system:introductionpictures:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyIntroductionpictures hyIntroductionpictures)
    {
        startPage();
        List<HyIntroductionpictures> list = hyIntroductionpicturesService.selectHyIntroductionpicturesList(hyIntroductionpictures);
        return getDataTable(list);
    }

    /**
     * 导出物业简介图片列表
     */
    @ApiOperation("物业简介图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyIntroductionpictures", value = "项目实体类hyIntroductionpictures", required = true),
	})
    @RequiresPermissions("system:introductionpictures:export")
    @Log(title = "物业简介图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyIntroductionpictures hyIntroductionpictures)
    {
        List<HyIntroductionpictures> list = hyIntroductionpicturesService.selectHyIntroductionpicturesList(hyIntroductionpictures);
        ExcelUtil<HyIntroductionpictures> util = new ExcelUtil<HyIntroductionpictures>(HyIntroductionpictures.class);
        return util.exportExcel(list, "introductionpictures");
    }

    /**
     * 新增物业简介图片
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物业简介图片
     */
    @ApiOperation("物业简介图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyIntroductionpictures", value = "项目实体类hyIntroductionpictures", required = true),
	})
    @RequiresPermissions("system:introductionpictures:add")
    @Log(title = "物业简介图片", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyIntroductionpictures hyIntroductionpictures)
    {
        return toAjax(hyIntroductionpicturesService.insertHyIntroductionpictures(hyIntroductionpictures));
    }

    /**
     * 修改物业简介图片
     */
    @ApiOperation("物业简介图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyIntroductionpictures hyIntroductionpictures = hyIntroductionpicturesService.selectHyIntroductionpicturesById(id);
        mmap.put("hyIntroductionpictures", hyIntroductionpictures);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业简介图片
     */
    @ApiOperation("物业简介图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyIntroductionpictures", value = "项目实体类hyIntroductionpictures", required = true),
	})
    @RequiresPermissions("system:introductionpictures:edit")
    @Log(title = "物业简介图片", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyIntroductionpictures hyIntroductionpictures)
    {
        return toAjax(hyIntroductionpicturesService.updateHyIntroductionpictures(hyIntroductionpictures));
    }

    /**
     * 删除物业简介图片
     */
    @ApiOperation("物业简介图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:introductionpictures:remove")
    @Log(title = "物业简介图片", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyIntroductionpicturesService.deleteHyIntroductionpicturesByIds(ids));
    }
}
