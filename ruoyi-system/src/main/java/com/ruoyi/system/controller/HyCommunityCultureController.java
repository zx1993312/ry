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
import com.ruoyi.system.domain.HyCommunityCulture;
import com.ruoyi.system.service.IHyCommunityCultureService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社区文化Controller
 * 
 * @author Administrator
 * @date 2021-04-12
 */
@Controller
@RequestMapping("/system/culture")
@Api(tags = "社区文化Controller")
public class HyCommunityCultureController extends BaseController
{
    private String prefix = "system/culture";

    @Autowired
    private IHyCommunityCultureService hyCommunityCultureService;

    @RequiresPermissions("system:culture:view")
    @GetMapping()
    public String culture()
    {
        return prefix + "/culture";
    }

    /**
     * 查询社区文化列表
     */
    @ApiOperation("社区文化")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityCulture", value = "项目实体类hyCommunityCulture", required = true),
	})
    @RequiresPermissions("system:culture:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCommunityCulture hyCommunityCulture)
    {
        startPage();
        List<HyCommunityCulture> list = hyCommunityCultureService.selectHyCommunityCultureList(hyCommunityCulture);
        return getDataTable(list);
    }

    /**
     * 导出社区文化列表
     */
    @ApiOperation("社区文化")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityCulture", value = "项目实体类hyCommunityCulture", required = true),
	})
    @RequiresPermissions("system:culture:export")
    @Log(title = "社区文化", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCommunityCulture hyCommunityCulture)
    {
        List<HyCommunityCulture> list = hyCommunityCultureService.selectHyCommunityCultureList(hyCommunityCulture);
        ExcelUtil<HyCommunityCulture> util = new ExcelUtil<HyCommunityCulture>(HyCommunityCulture.class);
        return util.exportExcel(list, "culture");
    }

    /**
     * 新增社区文化
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社区文化
     */
    @ApiOperation("社区文化")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityCulture", value = "项目实体类hyCommunityCulture", required = true),
	})
    @RequiresPermissions("system:culture:add")
    @Log(title = "社区文化", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCommunityCulture hyCommunityCulture)
    {
        return toAjax(hyCommunityCultureService.insertHyCommunityCulture(hyCommunityCulture));
    }

    /**
     * 修改社区文化
     */
    @ApiOperation("社区文化")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCommunityCulture hyCommunityCulture = hyCommunityCultureService.selectHyCommunityCultureById(id);
        mmap.put("hyCommunityCulture", hyCommunityCulture);
        return prefix + "/edit";
    }

    /**
     * 修改保存社区文化
     */
    @ApiOperation("社区文化")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityCulture", value = "项目实体类hyCommunityCulture", required = true),
	})
    @RequiresPermissions("system:culture:edit")
    @Log(title = "社区文化", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCommunityCulture hyCommunityCulture)
    {
        return toAjax(hyCommunityCultureService.updateHyCommunityCulture(hyCommunityCulture));
    }

    /**
     * 删除社区文化
     */
    @ApiOperation("社区文化")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:culture:remove")
    @Log(title = "社区文化", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCommunityCultureService.deleteHyCommunityCultureByIds(ids));
    }
}
