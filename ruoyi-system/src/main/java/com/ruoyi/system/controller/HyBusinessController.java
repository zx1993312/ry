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
import com.ruoyi.system.domain.HyBusiness;
import com.ruoyi.system.service.IHyBusinessService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商家Controller
 * 
 * @author Administrator
 * @date 2021-03-05
 */
@Controller
@RequestMapping("/system/business")
@Api(tags = "商家Controller")
public class HyBusinessController extends BaseController
{
    private String prefix = "system/business";

    @Autowired
    private IHyBusinessService hyBusinessService;

    @RequiresPermissions("system:business:view")
    @GetMapping()
    public String business()
    {
        return prefix + "/business";
    }

    /**
     * 查询商家列表
     */
    @ApiOperation("商家")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBusiness", value = "项目实体类hyBusiness", required = true),
	})
    @RequiresPermissions("system:business:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyBusiness hyBusiness)
    {
        startPage();
        List<HyBusiness> list = hyBusinessService.selectHyBusinessList(hyBusiness);
        return getDataTable(list);
    }

    /**
     * 导出商家列表
     */
    @ApiOperation("商家")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBusiness", value = "项目实体类hyBusiness", required = true),
	})
    @RequiresPermissions("system:business:export")
    @Log(title = "商家", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyBusiness hyBusiness)
    {
        List<HyBusiness> list = hyBusinessService.selectHyBusinessList(hyBusiness);
        ExcelUtil<HyBusiness> util = new ExcelUtil<HyBusiness>(HyBusiness.class);
        return util.exportExcel(list, "business");
    }

    /**
     * 新增商家
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商家
     */
    @ApiOperation("商家")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBusiness", value = "项目实体类hyBusiness", required = true),
	})
    @RequiresPermissions("system:business:add")
    @Log(title = "商家", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyBusiness hyBusiness)
    {
        return toAjax(hyBusinessService.insertHyBusiness(hyBusiness));
    }

    /**
     * 修改商家
     */
    @ApiOperation("商家")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyBusiness hyBusiness = hyBusinessService.selectHyBusinessById(id);
        mmap.put("hyBusiness", hyBusiness);
        return prefix + "/edit";
    }

    /**
     * 修改保存商家
     */
    @ApiOperation("商家")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBusiness", value = "项目实体类hyBusiness", required = true),
	})
    @RequiresPermissions("system:business:edit")
    @Log(title = "商家", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyBusiness hyBusiness)
    {
        return toAjax(hyBusinessService.updateHyBusiness(hyBusiness));
    }

    /**
     * 删除商家
     */
    @ApiOperation("商家")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:business:remove")
    @Log(title = "商家", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyBusinessService.deleteHyBusinessByIds(ids));
    }
}
