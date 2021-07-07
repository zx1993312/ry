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
import com.ruoyi.system.domain.HySetMeal;
import com.ruoyi.system.service.IHySetMealService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 套餐Controller
 * 
 * @author Administrator
 * @date 2021-03-06
 */
@Controller
@CrossOrigin
@RequestMapping("/system/meal")
@Api(tags = "套餐Controller")
public class HySetMealController extends BaseController
{
    private String prefix = "system/meal";

    @Autowired
    private IHySetMealService hySetMealService;

    @RequiresPermissions("system:meal:view")
    @GetMapping()
    public String meal()
    {
        return prefix + "/meal";
    }

    /**
     * 查询套餐列表
     */
    @ApiOperation("套餐")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySetMeal", value = "项目实体类hySetMeal", required = true),
	})
    @RequiresPermissions("system:meal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HySetMeal hySetMeal)
    {
        startPage();
        List<HySetMeal> list = hySetMealService.selectHySetMealList(hySetMeal);
        return getDataTable(list);
    }

    /**
     * 导出套餐列表
     */
    @ApiOperation("套餐")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySetMeal", value = "项目实体类hySetMeal", required = true),
	})
    @RequiresPermissions("system:meal:export")
    @Log(title = "套餐", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HySetMeal hySetMeal)
    {
        List<HySetMeal> list = hySetMealService.selectHySetMealList(hySetMeal);
        ExcelUtil<HySetMeal> util = new ExcelUtil<HySetMeal>(HySetMeal.class);
        return util.exportExcel(list, "meal");
    }

    /**
     * 新增套餐
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存套餐
     */
    @ApiOperation("套餐")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySetMeal", value = "项目实体类hySetMeal", required = true),
	})
    @RequiresPermissions("system:meal:add")
    @Log(title = "套餐", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HySetMeal hySetMeal)
    {
        return toAjax(hySetMealService.insertHySetMeal(hySetMeal));
    }

    /**
     * 修改套餐
     */
    @ApiOperation("套餐")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HySetMeal hySetMeal = hySetMealService.selectHySetMealById(id);
        mmap.put("hySetMeal", hySetMeal);
        return prefix + "/edit";
    }

    /**
     * 修改保存套餐
     */
    @ApiOperation("套餐")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySetMeal", value = "项目实体类hySetMeal", required = true),
	})
    @RequiresPermissions("system:meal:edit")
    @Log(title = "套餐", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HySetMeal hySetMeal)
    {
        return toAjax(hySetMealService.updateHySetMeal(hySetMeal));
    }

    /**
     * 删除套餐
     */
    @ApiOperation("套餐")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:meal:remove")
    @Log(title = "套餐", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hySetMealService.deleteHySetMealByIds(ids));
    }
}
