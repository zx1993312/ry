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
import com.ruoyi.system.domain.HyAccessories;
import com.ruoyi.system.service.IHyAccessoriesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 所属设备及配件附件Controller
 * 
 * @author Administrator
 * @date 2021-05-10
 */
@Controller
@CrossOrigin
@RequestMapping("/system/accessories")
@Api(tags = "所属设备及配件附件Controller")
public class HyAccessoriesController extends BaseController
{
    private String prefix = "system/accessories";

    @Autowired
    private IHyAccessoriesService hyAccessoriesService;

    @RequiresPermissions("system:accessories:view")
    @GetMapping()
    public String accessories()
    {
        return prefix + "/accessories";
    }

    /**
     * 查询所属设备及配件附件列表
     */
    @ApiOperation("所属设备及配件附件")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAccessories", value = "项目实体类hyAccessories", required = true),
	})
    @RequiresPermissions("system:accessories:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyAccessories hyAccessories)
    {
        startPage();
        List<HyAccessories> list = hyAccessoriesService.selectHyAccessoriesList(hyAccessories);
        return getDataTable(list);
    }

    /**
     * 导出所属设备及配件附件列表
     */
    @ApiOperation("所属设备及配件附件")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAccessories", value = "项目实体类hyAccessories", required = true),
	})
    @RequiresPermissions("system:accessories:export")
    @Log(title = "所属设备及配件附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyAccessories hyAccessories)
    {
        List<HyAccessories> list = hyAccessoriesService.selectHyAccessoriesList(hyAccessories);
        ExcelUtil<HyAccessories> util = new ExcelUtil<HyAccessories>(HyAccessories.class);
        return util.exportExcel(list, "accessories");
    }

    /**
     * 新增所属设备及配件附件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存所属设备及配件附件
     */
    @ApiOperation("所属设备及配件附件")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAccessories", value = "项目实体类hyAccessories", required = true),
	})
    @RequiresPermissions("system:accessories:add")
    @Log(title = "所属设备及配件附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyAccessories hyAccessories)
    {
        return toAjax(hyAccessoriesService.insertHyAccessories(hyAccessories));
    }

    /**
     * 修改所属设备及配件附件
     */
    @ApiOperation("所属设备及配件附件")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyAccessories hyAccessories = hyAccessoriesService.selectHyAccessoriesById(id);
        mmap.put("hyAccessories", hyAccessories);
        return prefix + "/edit";
    }

    /**
     * 修改保存所属设备及配件附件
     */
    @ApiOperation("所属设备及配件附件")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAccessories", value = "项目实体类hyAccessories", required = true),
	})
    @RequiresPermissions("system:accessories:edit")
    @Log(title = "所属设备及配件附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyAccessories hyAccessories)
    {
        return toAjax(hyAccessoriesService.updateHyAccessories(hyAccessories));
    }

    /**
     * 删除所属设备及配件附件
     */
    @ApiOperation("所属设备及配件附件")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:accessories:remove")
    @Log(title = "所属设备及配件附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyAccessoriesService.deleteHyAccessoriesByIds(ids));
    }
}
