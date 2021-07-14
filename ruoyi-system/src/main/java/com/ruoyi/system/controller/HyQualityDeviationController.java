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
import com.ruoyi.system.domain.HyQualityDeviation;
import com.ruoyi.system.service.IHyQualityDeviationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 品质异常Controller
 * 
 * @author Administrator
 * @date 2021-07-13
 */
@Controller
@CrossOrigin
@RequestMapping("/system/deviation")
@Api(tags = "品质异常Controller")
public class HyQualityDeviationController extends BaseController
{
    private String prefix = "system/deviation";

    @Autowired
    private IHyQualityDeviationService hyQualityDeviationService;

    @RequiresPermissions("system:deviation:view")
    @GetMapping()
    public String deviation()
    {
        return prefix + "/deviation";
    }

    /**
     * 查询品质异常列表
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyQualityDeviation", value = "项目实体类hyQualityDeviation", required = true),
	})
    @RequiresPermissions("system:deviation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyQualityDeviation hyQualityDeviation)
    {
        startPage();
        List<HyQualityDeviation> list = hyQualityDeviationService.selectHyQualityDeviationList(hyQualityDeviation);
        return getDataTable(list);
    }
    
    /**
     * 查询品质异常待审核列表
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyQualityDeviation", value = "项目实体类hyQualityDeviation", required = true),
    })
    @RequiresPermissions("system:deviation:list")
    @PostMapping("/listByAudit")
    @ResponseBody
    public List<HyQualityDeviation> listByAudit(HyQualityDeviation hyQualityDeviation)
    {
    	List<HyQualityDeviation> list = hyQualityDeviationService.selectHyQualityDeviationListByAudit(hyQualityDeviation);
    	return list;
    }
    
    /**
     * 查询品质异常已通过列表
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyQualityDeviation", value = "项目实体类hyQualityDeviation", required = true),
    })
    @RequiresPermissions("system:deviation:list")
    @PostMapping("/listByThrough")
    @ResponseBody
    public List<HyQualityDeviation> listByThrough(HyQualityDeviation hyQualityDeviation)
    {
    	List<HyQualityDeviation> list = hyQualityDeviationService.selectHyQualityDeviationListByThrough(hyQualityDeviation);
    	return list;
    }
    
    /**
     * 查询品质异常已拒绝列表
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyQualityDeviation", value = "项目实体类hyQualityDeviation", required = true),
    })
    @RequiresPermissions("system:deviation:list")
    @PostMapping("/listByRefusal")
    @ResponseBody
    public List<HyQualityDeviation> listByRefusal(HyQualityDeviation hyQualityDeviation)
    {
    	List<HyQualityDeviation> list = hyQualityDeviationService.selectHyQualityDeviationListByRefusal(hyQualityDeviation);
    	return list;
    }

    /**
     * 导出品质异常列表
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyQualityDeviation", value = "项目实体类hyQualityDeviation", required = true),
	})
    @RequiresPermissions("system:deviation:export")
    @Log(title = "品质异常", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyQualityDeviation hyQualityDeviation)
    {
        List<HyQualityDeviation> list = hyQualityDeviationService.selectHyQualityDeviationList(hyQualityDeviation);
        ExcelUtil<HyQualityDeviation> util = new ExcelUtil<HyQualityDeviation>(HyQualityDeviation.class);
        return util.exportExcel(list, "deviation");
    }

    /**
     * 新增品质异常
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存品质异常
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyQualityDeviation", value = "项目实体类hyQualityDeviation", required = true),
	})
    @RequiresPermissions("system:deviation:add")
    @Log(title = "品质异常", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyQualityDeviation hyQualityDeviation)
    {
        return toAjax(hyQualityDeviationService.insertHyQualityDeviation(hyQualityDeviation));
    }

    /**
     * 修改品质异常
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyQualityDeviation hyQualityDeviation = hyQualityDeviationService.selectHyQualityDeviationById(id);
        mmap.put("hyQualityDeviation", hyQualityDeviation);
        return prefix + "/edit";
    }
    
    /**
     * 品质异常详情APP
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/editApp")
    @ResponseBody
    public List<HyQualityDeviation> editApp(HyQualityDeviation hyQualityDeviation)
    {
    	List<HyQualityDeviation> list = hyQualityDeviationService.selectHyQualityDeviationList(hyQualityDeviation);
    	return list;
    }
    
    /**
     * 修改品质异常通过
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/editThrough/{id}")
    public String editThrough(@PathVariable("id") Long id, ModelMap mmap)
    {
    	HyQualityDeviation hyQualityDeviation = hyQualityDeviationService.selectHyQualityDeviationById(id);
    	mmap.put("hyQualityDeviation", hyQualityDeviation);
    	return prefix + "/editThrough";
    }
    
    /**
     * 修改品质异常拒绝
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/editRefusal/{id}")
    public String editRefusal(@PathVariable("id") Long id, ModelMap mmap)
    {
    	HyQualityDeviation hyQualityDeviation = hyQualityDeviationService.selectHyQualityDeviationById(id);
    	mmap.put("hyQualityDeviation", hyQualityDeviation);
    	return prefix + "/editRefusal";
    }

    /**
     * 修改保存品质异常
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyQualityDeviation", value = "项目实体类hyQualityDeviation", required = true),
	})
    @RequiresPermissions("system:deviation:edit")
    @Log(title = "品质异常", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyQualityDeviation hyQualityDeviation)
    {
        return toAjax(hyQualityDeviationService.updateHyQualityDeviation(hyQualityDeviation));
    }

    /**
     * 删除品质异常
     */
    @ApiOperation("品质异常")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:deviation:remove")
    @Log(title = "品质异常", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyQualityDeviationService.deleteHyQualityDeviationByIds(ids));
    }
}
