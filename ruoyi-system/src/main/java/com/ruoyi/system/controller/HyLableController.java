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
import com.ruoyi.system.domain.HyLable;
import com.ruoyi.system.service.IHyLableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 标签Controller
 * 
 * @author Administrator
 * @date 2021-07-16
 */
@Controller
@RequestMapping("/system/lable")
@Api(tags = "标签Controller")
public class HyLableController extends BaseController
{
    private String prefix = "system/lable";

    @Autowired
    private IHyLableService hyLableService;

    @RequiresPermissions("system:lable:view")
    @GetMapping()
    public String lable()
    {
        return prefix + "/lable";
    }

    /**
     * 查询标签列表
     */
    @ApiOperation("标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyLable", value = "项目实体类hyLable", required = true),
	})
    @RequiresPermissions("system:lable:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyLable hyLable)
    {
        startPage();
        List<HyLable> list = hyLableService.selectHyLableList(hyLable);
        return getDataTable(list);
    }
    
    /**
     * 查询标签列表App
     */
    @ApiOperation("标签")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyLable", value = "项目实体类hyLable", required = true),
    })
    @PostMapping("/listApp")
    @ResponseBody
    public List<HyLable> listApp(HyLable hyLable)
    {
    	List<HyLable> list = hyLableService.selectHyLableList(hyLable);
    	return list;
    }

    /**
     * 导出标签列表
     */
    @ApiOperation("标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyLable", value = "项目实体类hyLable", required = true),
	})
    @RequiresPermissions("system:lable:export")
    @Log(title = "标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyLable hyLable)
    {
        List<HyLable> list = hyLableService.selectHyLableList(hyLable);
        ExcelUtil<HyLable> util = new ExcelUtil<HyLable>(HyLable.class);
        return util.exportExcel(list, "lable");
    }

    /**
     * 新增标签
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存标签
     */
    @ApiOperation("标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyLable", value = "项目实体类hyLable", required = true),
	})
    @RequiresPermissions("system:lable:add")
    @Log(title = "标签", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyLable hyLable)
    {
        return toAjax(hyLableService.insertHyLable(hyLable));
    }

    /**
     * 修改标签
     */
    @ApiOperation("标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyLable hyLable = hyLableService.selectHyLableById(id);
        mmap.put("hyLable", hyLable);
        return prefix + "/edit";
    }

    /**
     * 修改保存标签
     */
    @ApiOperation("标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyLable", value = "项目实体类hyLable", required = true),
	})
    @RequiresPermissions("system:lable:edit")
    @Log(title = "标签", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyLable hyLable)
    {
        return toAjax(hyLableService.updateHyLable(hyLable));
    }

    /**
     * 删除标签
     */
    @ApiOperation("标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:lable:remove")
    @Log(title = "标签", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyLableService.deleteHyLableByIds(ids));
    }
}