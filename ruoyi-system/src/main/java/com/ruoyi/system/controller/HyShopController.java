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
import com.ruoyi.system.domain.HyShop;
import com.ruoyi.system.service.IHyShopService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 店铺Controller
 * 
 * @author Administrator
 * @date 2021-03-05
 */
@Controller
@RequestMapping("/system/shop")
@Api(tags = "店铺Controller")
public class HyShopController extends BaseController
{
    private String prefix = "system/shop";

    @Autowired
    private IHyShopService hyShopService;

    @RequiresPermissions("system:shop:view")
    @GetMapping()
    public String shop()
    {
        return prefix + "/shop";
    }

    /**
     * 查询店铺列表
     */
    @ApiOperation("店铺")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyShop", value = "项目实体类hyShop", required = true),
	})
    @RequiresPermissions("system:shop:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyShop hyShop)
    {
        startPage();
        List<HyShop> list = hyShopService.selectHyShopList(hyShop);
        return getDataTable(list);
    }

    /**
     * 导出店铺列表
     */
    @ApiOperation("店铺")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyShop", value = "项目实体类hyShop", required = true),
	})
    @RequiresPermissions("system:shop:export")
    @Log(title = "店铺", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyShop hyShop)
    {
        List<HyShop> list = hyShopService.selectHyShopList(hyShop);
        ExcelUtil<HyShop> util = new ExcelUtil<HyShop>(HyShop.class);
        return util.exportExcel(list, "shop");
    }

    /**
     * 新增店铺
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存店铺
     */
    @ApiOperation("店铺")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyShop", value = "项目实体类hyShop", required = true),
	})
    @RequiresPermissions("system:shop:add")
    @Log(title = "店铺", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyShop hyShop)
    {
    	hyShop.setBusinessId(hyShop.getHyBusiness().getId());
        return toAjax(hyShopService.insertHyShop(hyShop));
    }

    /**
     * 修改店铺
     */
    @ApiOperation("店铺")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyShop hyShop = hyShopService.selectHyShopById(id);
        mmap.put("hyShop", hyShop);
        return prefix + "/edit";
    }

    /**
     * 修改保存店铺
     */
    @ApiOperation("店铺")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyShop", value = "项目实体类hyShop", required = true),
	})
    @RequiresPermissions("system:shop:edit")
    @Log(title = "店铺", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyShop hyShop)
    {
        return toAjax(hyShopService.updateHyShop(hyShop));
    }

    /**
     * 删除店铺
     */
    @ApiOperation("店铺")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:shop:remove")
    @Log(title = "店铺", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyShopService.deleteHyShopByIds(ids));
    }
}
