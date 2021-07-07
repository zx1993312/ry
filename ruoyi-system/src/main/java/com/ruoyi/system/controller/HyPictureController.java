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
import com.ruoyi.system.domain.HyPicture;
import com.ruoyi.system.service.IHyPictureService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片Controller
 * 
 * @author Administrator
 * @date 2021-03-08
 */
@Controller
@CrossOrigin
@RequestMapping("/system/picture")
@Api(tags = "图片Controller")
public class HyPictureController extends BaseController
{
    private String prefix = "system/picture";

    @Autowired
    private IHyPictureService hyPictureService;

    @RequiresPermissions("system:picture:view")
    @GetMapping()
    public String picture()
    {
        return prefix + "/picture";
    }

    /**
     * 查询图片列表
     */
    @ApiOperation("图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPicture", value = "项目实体类hyPicture", required = true),
	})
    @RequiresPermissions("system:picture:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyPicture hyPicture)
    {
        startPage();
        List<HyPicture> list = hyPictureService.selectHyPictureList(hyPicture);
        return getDataTable(list);
    }

    /**
     * 导出图片列表
     */
    @ApiOperation("图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPicture", value = "项目实体类hyPicture", required = true),
	})
    @RequiresPermissions("system:picture:export")
    @Log(title = "图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyPicture hyPicture)
    {
        List<HyPicture> list = hyPictureService.selectHyPictureList(hyPicture);
        ExcelUtil<HyPicture> util = new ExcelUtil<HyPicture>(HyPicture.class);
        return util.exportExcel(list, "picture");
    }

    /**
     * 新增图片
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存图片
     */
    @ApiOperation("图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPicture", value = "项目实体类hyPicture", required = true),
	})
    @RequiresPermissions("system:picture:add")
    @Log(title = "图片", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyPicture hyPicture)
    {
        return toAjax(hyPictureService.insertHyPicture(hyPicture));
    }

    /**
     * 修改图片
     */
    @ApiOperation("图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyPicture hyPicture = hyPictureService.selectHyPictureById(id);
        mmap.put("hyPicture", hyPicture);
        return prefix + "/edit";
    }

    /**
     * 修改保存图片
     */
    @ApiOperation("图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPicture", value = "项目实体类hyPicture", required = true),
	})
    @RequiresPermissions("system:picture:edit")
    @Log(title = "图片", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyPicture hyPicture)
    {
        return toAjax(hyPictureService.updateHyPicture(hyPicture));
    }

    /**
     * 删除图片
     */
    @ApiOperation("图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:picture:remove")
    @Log(title = "图片", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyPictureService.deleteHyPictureByIds(ids));
    }
}
