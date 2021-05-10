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
import com.ruoyi.system.domain.HyTechnical;
import com.ruoyi.system.service.IHyTechnicalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 技术参数Controller
 * 
 * @author Administrator
 * @date 2021-05-10
 */
@Controller
@RequestMapping("/system/technical")
@Api(tags = "技术参数Controller")
public class HyTechnicalController extends BaseController
{
    private String prefix = "system/technical";

    @Autowired
    private IHyTechnicalService hyTechnicalService;

    @RequiresPermissions("system:technical:view")
    @GetMapping()
    public String technical()
    {
        return prefix + "/technical";
    }

    /**
     * 查询技术参数列表
     */
    @ApiOperation("技术参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTechnical", value = "项目实体类hyTechnical", required = true),
	})
    @RequiresPermissions("system:technical:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyTechnical hyTechnical)
    {
        startPage();
        List<HyTechnical> list = hyTechnicalService.selectHyTechnicalList(hyTechnical);
        return getDataTable(list);
    }

    /**
     * 导出技术参数列表
     */
    @ApiOperation("技术参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTechnical", value = "项目实体类hyTechnical", required = true),
	})
    @RequiresPermissions("system:technical:export")
    @Log(title = "技术参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyTechnical hyTechnical)
    {
        List<HyTechnical> list = hyTechnicalService.selectHyTechnicalList(hyTechnical);
        ExcelUtil<HyTechnical> util = new ExcelUtil<HyTechnical>(HyTechnical.class);
        return util.exportExcel(list, "technical");
    }

    /**
     * 新增技术参数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存技术参数
     */
    @ApiOperation("技术参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTechnical", value = "项目实体类hyTechnical", required = true),
	})
    @RequiresPermissions("system:technical:add")
    @Log(title = "技术参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyTechnical hyTechnical)
    {
        return toAjax(hyTechnicalService.insertHyTechnical(hyTechnical));
    }

    /**
     * 修改技术参数
     */
    @ApiOperation("技术参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyTechnical hyTechnical = hyTechnicalService.selectHyTechnicalById(id);
        mmap.put("hyTechnical", hyTechnical);
        return prefix + "/edit";
    }

    /**
     * 修改保存技术参数
     */
    @ApiOperation("技术参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyTechnical", value = "项目实体类hyTechnical", required = true),
	})
    @RequiresPermissions("system:technical:edit")
    @Log(title = "技术参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyTechnical hyTechnical)
    {
        return toAjax(hyTechnicalService.updateHyTechnical(hyTechnical));
    }

    /**
     * 删除技术参数
     */
    @ApiOperation("技术参数")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:technical:remove")
    @Log(title = "技术参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyTechnicalService.deleteHyTechnicalByIds(ids));
    }
}
