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
import com.ruoyi.system.domain.HyCommercialSpecification;
import com.ruoyi.system.service.IHyCommercialSpecificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品规格Controller
 * 
 * @author Administrator
 * @date 2021-07-26
 */
@Controller
@RequestMapping("/system/specification")
@Api(tags = "商品规格Controller")
public class HyCommercialSpecificationController extends BaseController
{
    private String prefix = "system/specification";

    @Autowired
    private IHyCommercialSpecificationService hyCommercialSpecificationService;

    @RequiresPermissions("system:specification:view")
    @GetMapping()
    public String specification()
    {
        return prefix + "/specification";
    }

    /**
     * 查询商品规格列表
     */
    @ApiOperation("商品规格")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommercialSpecification", value = "项目实体类hyCommercialSpecification", required = true),
	})
    @RequiresPermissions("system:specification:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCommercialSpecification hyCommercialSpecification)
    {
        startPage();
        List<HyCommercialSpecification> list = hyCommercialSpecificationService.selectHyCommercialSpecificationList(hyCommercialSpecification);
        return getDataTable(list);
    }

    /**
     * 导出商品规格列表
     */
    @ApiOperation("商品规格")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommercialSpecification", value = "项目实体类hyCommercialSpecification", required = true),
	})
    @RequiresPermissions("system:specification:export")
    @Log(title = "商品规格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCommercialSpecification hyCommercialSpecification)
    {
        List<HyCommercialSpecification> list = hyCommercialSpecificationService.selectHyCommercialSpecificationList(hyCommercialSpecification);
        ExcelUtil<HyCommercialSpecification> util = new ExcelUtil<HyCommercialSpecification>(HyCommercialSpecification.class);
        return util.exportExcel(list, "specification");
    }

    /**
     * 新增商品规格
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品规格
     */
    @ApiOperation("商品规格")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommercialSpecification", value = "项目实体类hyCommercialSpecification", required = true),
	})
    @RequiresPermissions("system:specification:add")
    @Log(title = "商品规格", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCommercialSpecification hyCommercialSpecification)
    {
        return toAjax(hyCommercialSpecificationService.insertHyCommercialSpecification(hyCommercialSpecification));
    }

    /**
     * 修改商品规格
     */
    @ApiOperation("商品规格")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCommercialSpecification hyCommercialSpecification = hyCommercialSpecificationService.selectHyCommercialSpecificationById(id);
        mmap.put("hyCommercialSpecification", hyCommercialSpecification);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品规格
     */
    @ApiOperation("商品规格")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommercialSpecification", value = "项目实体类hyCommercialSpecification", required = true),
	})
    @RequiresPermissions("system:specification:edit")
    @Log(title = "商品规格", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCommercialSpecification hyCommercialSpecification)
    {
        return toAjax(hyCommercialSpecificationService.updateHyCommercialSpecification(hyCommercialSpecification));
    }

    /**
     * 删除商品规格
     */
    @ApiOperation("商品规格")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:specification:remove")
    @Log(title = "商品规格", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCommercialSpecificationService.deleteHyCommercialSpecificationByIds(ids));
    }
}
