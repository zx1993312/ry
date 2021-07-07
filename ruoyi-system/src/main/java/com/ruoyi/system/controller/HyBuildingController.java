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
import com.ruoyi.system.domain.HyBuilding;
import com.ruoyi.system.service.IHyBuildingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 楼宇Controller
 * 
 * @author Administrator
 * @date 2021-05-22
 */
@Controller
@CrossOrigin
@RequestMapping("/system/building")
@Api(tags = "楼宇Controller")
public class HyBuildingController extends BaseController
{
    private String prefix = "system/building";

    @Autowired
    private IHyBuildingService hyBuildingService;

    @RequiresPermissions("system:building:view")
    @GetMapping()
    public String building()
    {
        return prefix + "/building";
    }

    /**
     * 查询楼宇列表
     */
    @ApiOperation("楼宇")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBuilding", value = "项目实体类hyBuilding", required = true),
	})
    @RequiresPermissions("system:building:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyBuilding hyBuilding)
    {
        startPage();
        List<HyBuilding> list = hyBuildingService.selectHyBuildingList(hyBuilding);
        return getDataTable(list);
    }
    
    /**
     * 查询楼宇列表
     */
    @ApiOperation("楼宇")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyBuilding", value = "项目实体类hyBuilding", required = true),
    })
    @RequiresPermissions("system:building:list")
    @PostMapping("/lists")
    @ResponseBody
    public List<HyBuilding> lists(HyBuilding hyBuilding)
    {
    	startPage();
    	List<HyBuilding> list = hyBuildingService.selectHyBuildingList(hyBuilding);
    	return list;
    }

    /**
     * 导出楼宇列表
     */
    @ApiOperation("楼宇")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBuilding", value = "项目实体类hyBuilding", required = true),
	})
    @RequiresPermissions("system:building:export")
    @Log(title = "楼宇", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyBuilding hyBuilding)
    {
        List<HyBuilding> list = hyBuildingService.selectHyBuildingList(hyBuilding);
        ExcelUtil<HyBuilding> util = new ExcelUtil<HyBuilding>(HyBuilding.class);
        return util.exportExcel(list, "building");
    }

    /**
     * 新增楼宇
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存楼宇
     */
    @ApiOperation("楼宇")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBuilding", value = "项目实体类hyBuilding", required = true),
	})
    @RequiresPermissions("system:building:add")
    @Log(title = "楼宇", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyBuilding hyBuilding)
    {
        return toAjax(hyBuildingService.insertHyBuilding(hyBuilding));
    }

    /**
     * 修改楼宇
     */
    @ApiOperation("楼宇")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyBuilding hyBuilding = hyBuildingService.selectHyBuildingById(id);
        mmap.put("hyBuilding", hyBuilding);
        return prefix + "/edit";
    }

    /**
     * 修改保存楼宇
     */
    @ApiOperation("楼宇")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyBuilding", value = "项目实体类hyBuilding", required = true),
	})
    @RequiresPermissions("system:building:edit")
    @Log(title = "楼宇", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyBuilding hyBuilding)
    {
        return toAjax(hyBuildingService.updateHyBuilding(hyBuilding));
    }

    /**
     * 删除楼宇
     */
    @ApiOperation("楼宇")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:building:remove")
    @Log(title = "楼宇", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyBuildingService.deleteHyBuildingByIds(ids));
    }
}
