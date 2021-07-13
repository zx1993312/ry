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
import com.ruoyi.system.domain.HyEquipmentAbnormal;
import com.ruoyi.system.service.IHyEquipmentAbnormalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备异常Controller
 * 
 * @author Administrator
 * @date 2021-07-13
 */
@Controller
@RequestMapping("/system/abnormal")
@Api(tags = "设备异常Controller")
public class HyEquipmentAbnormalController extends BaseController
{
    private String prefix = "system/abnormal";

    @Autowired
    private IHyEquipmentAbnormalService hyEquipmentAbnormalService;

    @RequiresPermissions("system:abnormal:view")
    @GetMapping()
    public String abnormal()
    {
        return prefix + "/abnormal";
    }

    /**
     * 查询设备异常列表
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEquipmentAbnormal", value = "项目实体类hyEquipmentAbnormal", required = true),
	})
    @RequiresPermissions("system:abnormal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
        startPage();
        List<HyEquipmentAbnormal> list = hyEquipmentAbnormalService.selectHyEquipmentAbnormalList(hyEquipmentAbnormal);
        return getDataTable(list);
    }
    
    /**
     * 查询设备异常待审核列表
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyEquipmentAbnormal", value = "项目实体类hyEquipmentAbnormal", required = true),
    })
    @RequiresPermissions("system:abnormal:list")
    @PostMapping("/listByAudit")
    @ResponseBody
    public List<HyEquipmentAbnormal> listByAudit(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
    	List<HyEquipmentAbnormal> list = hyEquipmentAbnormalService.selectHyEquipmentAbnormalListByAudit(hyEquipmentAbnormal);
    	return list;
    }
    
    /**
     * 查询设备异常已通过列表
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyEquipmentAbnormal", value = "项目实体类hyEquipmentAbnormal", required = true),
    })
    @RequiresPermissions("system:abnormal:list")
    @PostMapping("/listByThrough")
    @ResponseBody
    public List<HyEquipmentAbnormal> listByThrough(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
    	List<HyEquipmentAbnormal> list = hyEquipmentAbnormalService.selectHyEquipmentAbnormalListByThrough(hyEquipmentAbnormal);
    	return list;
    }
    
    /**
     * 查询设备异常已拒绝列表
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyEquipmentAbnormal", value = "项目实体类hyEquipmentAbnormal", required = true),
    })
    @RequiresPermissions("system:abnormal:list")
    @PostMapping("/listByRefusal")
    @ResponseBody
    public List<HyEquipmentAbnormal> listByRefusal(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
    	List<HyEquipmentAbnormal> list = hyEquipmentAbnormalService.selectHyEquipmentAbnormalListByRefusal(hyEquipmentAbnormal);
    	return list;
    }

    /**
     * 导出设备异常列表
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEquipmentAbnormal", value = "项目实体类hyEquipmentAbnormal", required = true),
	})
    @RequiresPermissions("system:abnormal:export")
    @Log(title = "设备异常", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
        List<HyEquipmentAbnormal> list = hyEquipmentAbnormalService.selectHyEquipmentAbnormalList(hyEquipmentAbnormal);
        ExcelUtil<HyEquipmentAbnormal> util = new ExcelUtil<HyEquipmentAbnormal>(HyEquipmentAbnormal.class);
        return util.exportExcel(list, "abnormal");
    }

    /**
     * 新增设备异常
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备异常
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEquipmentAbnormal", value = "项目实体类hyEquipmentAbnormal", required = true),
	})
    @RequiresPermissions("system:abnormal:add")
    @Log(title = "设备异常", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
        return toAjax(hyEquipmentAbnormalService.insertHyEquipmentAbnormal(hyEquipmentAbnormal));
    }

    /**
     * 修改设备异常
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyEquipmentAbnormal hyEquipmentAbnormal = hyEquipmentAbnormalService.selectHyEquipmentAbnormalById(id);
        mmap.put("hyEquipmentAbnormal", hyEquipmentAbnormal);
        return prefix + "/edit";
    }
    
    /**
     * 修改设备异常详情
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/editApp")
    @ResponseBody
    public List<HyEquipmentAbnormal> editApp(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
    	List<HyEquipmentAbnormal> list = hyEquipmentAbnormalService.selectHyEquipmentAbnormalList(hyEquipmentAbnormal);
    	return list;
    }
    
    /**
     * 修改设备异常通过
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/editThrough/{id}")
    public String editThrough(@PathVariable("id") Long id, ModelMap mmap)
    {
    	HyEquipmentAbnormal hyEquipmentAbnormal = hyEquipmentAbnormalService.selectHyEquipmentAbnormalById(id);
    	mmap.put("hyEquipmentAbnormal", hyEquipmentAbnormal);
    	return prefix + "/editThrough";
    }
    
    /**
     * 修改设备异常拒绝
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/editRefusal/{id}")
    public String editRefusal(@PathVariable("id") Long id, ModelMap mmap)
    {
    	HyEquipmentAbnormal hyEquipmentAbnormal = hyEquipmentAbnormalService.selectHyEquipmentAbnormalById(id);
    	mmap.put("hyEquipmentAbnormal", hyEquipmentAbnormal);
    	return prefix + "/editRefusal";
    }

    /**
     * 修改保存设备异常
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEquipmentAbnormal", value = "项目实体类hyEquipmentAbnormal", required = true),
	})
    @RequiresPermissions("system:abnormal:edit")
    @Log(title = "设备异常", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyEquipmentAbnormal hyEquipmentAbnormal)
    {
        return toAjax(hyEquipmentAbnormalService.updateHyEquipmentAbnormal(hyEquipmentAbnormal));
    }

    /**
     * 删除设备异常
     */
    @ApiOperation("设备异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:abnormal:remove")
    @Log(title = "设备异常", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyEquipmentAbnormalService.deleteHyEquipmentAbnormalByIds(ids));
    }
}
