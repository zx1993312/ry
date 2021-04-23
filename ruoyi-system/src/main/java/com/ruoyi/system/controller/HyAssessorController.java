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
import com.ruoyi.system.domain.HyAssessor;
import com.ruoyi.system.service.IHyAssessorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 审核管理Controller
 * 
 * @author Administrator
 * @date 2021-04-21
 */
@Controller
@RequestMapping("/system/assessor")
@Api(tags = "审核管理Controller")
public class HyAssessorController extends BaseController
{
    private String prefix = "system/assessor";

    @Autowired
    private IHyAssessorService hyAssessorService;

    @RequiresPermissions("system:assessor:view")
    @GetMapping()
    public String assessor()
    {
        return prefix + "/assessor";
    }

    /**
     * 查询审核管理列表
     */
    @ApiOperation("审核管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAssessor", value = "项目实体类hyAssessor", required = true),
	})
    @RequiresPermissions("system:assessor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyAssessor hyAssessor)
    {
        startPage();
        List<HyAssessor> list = hyAssessorService.selectHyAssessorList(hyAssessor);
        return getDataTable(list);
    }

    /**
     * 导出审核管理列表
     */
    @ApiOperation("审核管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAssessor", value = "项目实体类hyAssessor", required = true),
	})
    @RequiresPermissions("system:assessor:export")
    @Log(title = "审核管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyAssessor hyAssessor)
    {
        List<HyAssessor> list = hyAssessorService.selectHyAssessorList(hyAssessor);
        ExcelUtil<HyAssessor> util = new ExcelUtil<HyAssessor>(HyAssessor.class);
        return util.exportExcel(list, "assessor");
    }

    /**
     * 新增审核管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存审核管理
     */
    @ApiOperation("审核管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAssessor", value = "项目实体类hyAssessor", required = true),
	})
    @RequiresPermissions("system:assessor:add")
    @Log(title = "审核管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyAssessor hyAssessor)
    {
        return toAjax(hyAssessorService.insertHyAssessor(hyAssessor));
    }

    /**
     * 修改审核管理
     */
    @ApiOperation("审核管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyAssessor hyAssessor = hyAssessorService.selectHyAssessorById(id);
        System.out.println("=======hyAssessor=========="+hyAssessor);
        mmap.put("hyAssessor", hyAssessor);
        return prefix + "/edit";
    }

    /**
     * 修改保存审核管理入库
     */
    @ApiOperation("审核管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyAssessor", value = "项目实体类hyAssessor", required = true),
	})
    @RequiresPermissions("system:assessor:edit")
    @Log(title = "审核管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyAssessor hyAssessor)
    {
        return toAjax(hyAssessorService.updateHyAssessor(hyAssessor));
    }
    
    /**
     * 修改保存审核管理出库
     */
    @ApiOperation("审核管理")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyAssessor", value = "项目实体类hyAssessor", required = true),
    })
    @RequiresPermissions("system:assessor:edit")
    @Log(title = "审核管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edits")
    @ResponseBody
    public AjaxResult edits(HyAssessor hyAssessor)
    {
    	return toAjax(hyAssessorService.updateHyAssessors(hyAssessor));
    }

    /**
     * 删除审核管理
     */
    @ApiOperation("审核管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:assessor:remove")
    @Log(title = "审核管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyAssessorService.deleteHyAssessorByIds(ids));
    }
}
