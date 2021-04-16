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
import com.ruoyi.system.domain.HyDept;
import com.ruoyi.system.service.IHyDeptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 部门Controller
 * 
 * @author Administrator
 * @date 2021-04-14
 */
@Controller
@RequestMapping("/system/depts")
@Api(tags = "部门Controller")
public class HyDeptController extends BaseController
{
    private String prefix = "system/depts";

    @Autowired
    private IHyDeptService hyDeptService;

    @RequiresPermissions("system:dept:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/dept";
    }

    /**
     * 查询部门列表
     */
    @ApiOperation("部门")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDept", value = "项目实体类hyDept", required = true),
	})
    @RequiresPermissions("system:dept:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyDept hyDept)
    {
        startPage();
        List<HyDept> list = hyDeptService.selectHyDeptList(hyDept);
        return getDataTable(list);
    }
    
    /**
     * 查询所有部门信息
     */
    @ApiOperation("部门")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyDept", value = "项目实体类hyDept", required = true),
    })
    @RequiresPermissions("system:dept:list")
    @PostMapping("/lists")
    @ResponseBody
    public List<HyDept> lists(HyDept hyDept)
    {
    	return hyDeptService.selectHyDeptList(hyDept);
    	
    }

    /**
     * 导出部门列表
     */
    @ApiOperation("部门")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDept", value = "项目实体类hyDept", required = true),
	})
    @RequiresPermissions("system:dept:export")
    @Log(title = "部门", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyDept hyDept)
    {
        List<HyDept> list = hyDeptService.selectHyDeptList(hyDept);
        ExcelUtil<HyDept> util = new ExcelUtil<HyDept>(HyDept.class);
        return util.exportExcel(list, "dept");
    }

    /**
     * 新增部门
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存部门
     */
    @ApiOperation("部门")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDept", value = "项目实体类hyDept", required = true),
	})
    @RequiresPermissions("system:dept:add")
    @Log(title = "部门", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyDept hyDept)
    {
        return toAjax(hyDeptService.insertHyDept(hyDept));
    }

    /**
     * 修改部门
     */
    @ApiOperation("部门")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyDept hyDept = hyDeptService.selectHyDeptById(id);
        mmap.put("hyDept", hyDept);
        return prefix + "/edit";
    }

    /**
     * 修改保存部门
     */
    @ApiOperation("部门")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDept", value = "项目实体类hyDept", required = true),
	})
    @RequiresPermissions("system:dept:edit")
    @Log(title = "部门", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyDept hyDept)
    {
        return toAjax(hyDeptService.updateHyDept(hyDept));
    }

    /**
     * 删除部门
     */
    @ApiOperation("部门")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:dept:remove")
    @Log(title = "部门", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyDeptService.deleteHyDeptByIds(ids));
    }
}
