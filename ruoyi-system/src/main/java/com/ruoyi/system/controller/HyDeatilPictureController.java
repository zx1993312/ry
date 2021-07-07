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
import com.ruoyi.system.domain.HyDeatilPicture;
import com.ruoyi.system.service.IHyDeatilPictureService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品详情的图片
Controller
 * 
 * @author Administrator
 * @date 2021-04-08
 */
@Controller
@CrossOrigin
@RequestMapping("/system/deatilPicture")
@Api(tags = "商品详情的图片Controller")
public class HyDeatilPictureController extends BaseController
{
    private String prefix = "system/deatilPicture";

    @Autowired
    private IHyDeatilPictureService hyDeatilPictureService;

    @RequiresPermissions("system:deatilPicture:view")
    @GetMapping()
    public String picture()
    {
        return prefix + "/picture";
    }

    /**
     * 查询商品详情的图片
列表
     */
    @ApiOperation("商品详情的图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDeatilPicture", value = "项目实体类hyDeatilPicture", required = true),
	})
    @RequiresPermissions("system:deatilPicture:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyDeatilPicture hyDeatilPicture)
    {
        startPage();
        List<HyDeatilPicture> list = hyDeatilPictureService.selectHyDeatilPictureList(hyDeatilPicture);
        return getDataTable(list);
    }

    /**
     * 导出商品详情的图片
列表
     */
    @ApiOperation("商品详情的图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDeatilPicture", value = "项目实体类hyDeatilPicture", required = true),
	})
    @RequiresPermissions("system:deatilPicture:export")
    @Log(title = "商品详情的图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyDeatilPicture hyDeatilPicture)
    {
        List<HyDeatilPicture> list = hyDeatilPictureService.selectHyDeatilPictureList(hyDeatilPicture);
        ExcelUtil<HyDeatilPicture> util = new ExcelUtil<HyDeatilPicture>(HyDeatilPicture.class);
        return util.exportExcel(list, "picture");
    }

    /**
     * 新增商品详情的图片

     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品详情的图片

     */
    @ApiOperation("商品详情的图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDeatilPicture", value = "项目实体类hyDeatilPicture", required = true),
	})
    @RequiresPermissions("system:deatilPicture:add")
    @Log(title = "商品详情的图片", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyDeatilPicture hyDeatilPicture)
    {
        return toAjax(hyDeatilPictureService.insertHyDeatilPicture(hyDeatilPicture));
    }

    /**
     * 修改商品详情的图片

     */
    @ApiOperation("商品详情的图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyDeatilPicture hyDeatilPicture = hyDeatilPictureService.selectHyDeatilPictureById(id);
        mmap.put("hyDeatilPicture", hyDeatilPicture);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品详情的图片

     */
    @ApiOperation("商品详情的图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDeatilPicture", value = "项目实体类hyDeatilPicture", required = true),
	})
    @RequiresPermissions("system:deatilPicture:edit")
    @Log(title = "商品详情的图片", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyDeatilPicture hyDeatilPicture)
    {
        return toAjax(hyDeatilPictureService.updateHyDeatilPicture(hyDeatilPicture));
    }

    /**
     * 删除商品详情的图片

     */
    @ApiOperation("商品详情的图片")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:deatilPicture:remove")
    @Log(title = "商品详情的图片", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyDeatilPictureService.deleteHyDeatilPictureByIds(ids));
    }
}
