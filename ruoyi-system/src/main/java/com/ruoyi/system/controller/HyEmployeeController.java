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
import com.ruoyi.system.domain.HyEmployee;
import com.ruoyi.system.service.IHyEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工Controller
 * 
 * @author Administrator
 * @date 2021-04-14
 */
@Controller
@RequestMapping("/system/employee")
@Api(tags = "员工Controller")
public class HyEmployeeController extends BaseController
{
    private String prefix = "system/employee";

    @Autowired
    private IHyEmployeeService hyEmployeeService;

    @RequiresPermissions("system:employee:view")
    @GetMapping()
    public String employee()
    {
        return prefix + "/employee";
    }

    /**
     * 查询员工列表
     */
    @ApiOperation("员工")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEmployee", value = "项目实体类hyEmployee", required = true),
	})
    @RequiresPermissions("system:employee:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyEmployee hyEmployee)
    {
        startPage();
        List<HyEmployee> list = hyEmployeeService.selectHyEmployeeList(hyEmployee);
        return getDataTable(list);
    }
    
    /**
     * 查询所有员工信息
     */
    @ApiOperation("员工")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyEmployee", value = "项目实体类hyEmployee", required = true),
    })
    @RequiresPermissions("system:employee:list")
    @PostMapping("/lists")
    @ResponseBody
    public List<HyEmployee> lists(HyEmployee hyEmployee)
    {
    	return hyEmployeeService.selectHyEmployeeList(hyEmployee);
    }

    /**
     * 导出员工列表
     */
    @ApiOperation("员工")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEmployee", value = "项目实体类hyEmployee", required = true),
	})
    @RequiresPermissions("system:employee:export")
    @Log(title = "员工", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyEmployee hyEmployee)
    {
        List<HyEmployee> list = hyEmployeeService.selectHyEmployeeList(hyEmployee);
        ExcelUtil<HyEmployee> util = new ExcelUtil<HyEmployee>(HyEmployee.class);
        return util.exportExcel(list, "employee");
    }

    /**
     * 新增员工
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工
     */
    @ApiOperation("员工")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEmployee", value = "项目实体类hyEmployee", required = true),
	})
    @RequiresPermissions("system:employee:add")
    @Log(title = "员工", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyEmployee hyEmployee)
    {
        return toAjax(hyEmployeeService.insertHyEmployee(hyEmployee));
    }

    /**
     * 修改员工
     */
    @ApiOperation("员工")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyEmployee hyEmployee = hyEmployeeService.selectHyEmployeeById(id);
        mmap.put("hyEmployee", hyEmployee);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工
     */
    @ApiOperation("员工")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEmployee", value = "项目实体类hyEmployee", required = true),
	})
    @RequiresPermissions("system:employee:edit")
    @Log(title = "员工", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyEmployee hyEmployee)
    {
        return toAjax(hyEmployeeService.updateHyEmployee(hyEmployee));
    }

    /**
     * 删除员工
     */
    @ApiOperation("员工")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:employee:remove")
    @Log(title = "员工", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyEmployeeService.deleteHyEmployeeByIds(ids));
    }
}
