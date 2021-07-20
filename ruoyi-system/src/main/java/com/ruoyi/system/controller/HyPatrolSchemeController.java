package com.ruoyi.system.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyPatrolScheme;
import com.ruoyi.system.service.IHyPatrolSchemeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 巡检计划Controller
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Controller
@CrossOrigin
@RequestMapping("/system/scheme")
@Api(tags = "巡检计划Controller")
public class HyPatrolSchemeController extends BaseController
{
    private String prefix = "system/scheme";

    @Autowired
    private IHyPatrolSchemeService hyPatrolSchemeService;

    @RequiresPermissions("system:scheme:view")
    @GetMapping()
    public String scheme()
    {
        return prefix + "/scheme";
    }

    /**
     * 查询巡检计划列表
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPatrolScheme", value = "项目实体类hyPatrolScheme", required = true),
	})
    @RequiresPermissions("system:scheme:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyPatrolScheme hyPatrolScheme)
    {
        startPage();
        List<HyPatrolScheme> list = hyPatrolSchemeService.selectHyPatrolSchemeList(hyPatrolScheme);
        return getDataTable(list);
    }
    
    /**
     * 查询巡检计划明细列表
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyPatrolScheme", value = "项目实体类hyPatrolScheme", required = true),
    })
    @RequiresPermissions("system:scheme:list")
    @PostMapping("/lists")
    @ResponseBody
    public TableDataInfo lists(HyPatrolScheme hyPatrolScheme)
    {
    	startPage();
    	List<HyPatrolScheme> list = hyPatrolSchemeService.selectHyPatrolSchemeDetailList(hyPatrolScheme);
    	return getDataTable(list);
    }
    
    
    /**
     * 查询巡检计划未完成列表
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyPatrolScheme", value = "项目实体类hyPatrolScheme", required = true),
    })
    @RequiresPermissions("system:scheme:list")
    @PostMapping("/listByUnfinished")
    @ResponseBody
    public List<HyPatrolScheme> listByUnfinished(HyPatrolScheme hyPatrolScheme)
    {
    	List<HyPatrolScheme> list = hyPatrolSchemeService.selectHyPatrolSchemeListByUnfinished(hyPatrolScheme);
    	return list;
    }
    
    /**
     * 查询巡检计划进行中列表
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyPatrolScheme", value = "项目实体类hyPatrolScheme", required = true),
    })
    @RequiresPermissions("system:scheme:list")
    @PostMapping("/listByUnderway")
    @ResponseBody
    public List<HyPatrolScheme> listByUnderway(HyPatrolScheme hyPatrolScheme)
    {
    	List<HyPatrolScheme> list = hyPatrolSchemeService.selectHyPatrolSchemeListByUnderway(hyPatrolScheme);
    	return list;
    }
    
    /**
     * 查询巡检计划已完成列表
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyPatrolScheme", value = "项目实体类hyPatrolScheme", required = true),
    })
    @RequiresPermissions("system:scheme:list")
    @PostMapping("/listByFinished")
    @ResponseBody
    public List<HyPatrolScheme> listByFinished(HyPatrolScheme hyPatrolScheme)
    {
    	List<HyPatrolScheme> list = hyPatrolSchemeService.selectHyPatrolSchemeListByFinished(hyPatrolScheme);
    	return list;
    }

    /**
     * 导出巡检计划列表
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPatrolScheme", value = "项目实体类hyPatrolScheme", required = true),
	})
    @RequiresPermissions("system:scheme:export")
    @Log(title = "巡检计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyPatrolScheme hyPatrolScheme)
    {
        List<HyPatrolScheme> list = hyPatrolSchemeService.selectHyPatrolSchemeList(hyPatrolScheme);
        ExcelUtil<HyPatrolScheme> util = new ExcelUtil<HyPatrolScheme>(HyPatrolScheme.class);
        return util.exportExcel(list, "scheme");
    }

    /**
     * 新增巡检计划
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	HyPatrolScheme hyPatrolScheme = new HyPatrolScheme();
       	hyPatrolScheme.setDocumentNumber(new Date().getTime());
       	Date DateTime = new Date();
       	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        String dateString = formatter.format(DateTime);  
       	hyPatrolScheme.setPlannedTime(dateString);
       	Calendar date = Calendar.getInstance();
       	String year = String.valueOf(date.get(Calendar.YEAR));
       	hyPatrolScheme.setPlanAnnual(year);
       	System.out.println("hyPatrolScheme========"+hyPatrolScheme);
    	mmap.put("hyPatrolScheme", hyPatrolScheme);
        return prefix + "/add";
    }

    /**
     * 新增保存巡检计划
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPatrolScheme", value = "项目实体类hyPatrolScheme", required = true),
	})
    @RequiresPermissions("system:scheme:add")
    @Log(title = "巡检计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyPatrolScheme hyPatrolScheme)
    {
        return toAjax(hyPatrolSchemeService.insertHyPatrolScheme(hyPatrolScheme));
    }

    /**
     * 修改巡检计划
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyPatrolScheme hyPatrolScheme = hyPatrolSchemeService.selectHyPatrolSchemeById(id);
        mmap.put("hyPatrolScheme", hyPatrolScheme);
        return prefix + "/edit";
    }

    /**
     * 修改保存巡检计划
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPatrolScheme", value = "项目实体类hyPatrolScheme", required = true),
	})
    @RequiresPermissions("system:scheme:edit")
    @Log(title = "巡检计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyPatrolScheme hyPatrolScheme)
    {
        return toAjax(hyPatrolSchemeService.updateHyPatrolScheme(hyPatrolScheme));
    }

    /**
     * 删除巡检计划
     */
    @ApiOperation("巡检计划")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:scheme:remove")
    @Log(title = "巡检计划", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyPatrolSchemeService.deleteHyPatrolSchemeByIds(ids));
    }
}
