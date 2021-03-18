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
import com.ruoyi.system.domain.HyDistributionRule;
import com.ruoyi.system.service.IHyDistributionRuleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分销规则Controller
 * 
 * @author Administrator
 * @date 2021-03-09
 */
@Controller
@RequestMapping("/system/rule")
@Api(tags = "分销规则Controller")
public class HyDistributionRuleController extends BaseController
{
    private String prefix = "system/rule";

    @Autowired
    private IHyDistributionRuleService hyDistributionRuleService;

    @RequiresPermissions("system:rule:view")
    @GetMapping()
    public String rule()
    {
        return prefix + "/rule";
    }

    /**
     * 查询分销规则列表
     */
    @ApiOperation("分销规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDistributionRule", value = "项目实体类hyDistributionRule", required = true),
	})
    @RequiresPermissions("system:rule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyDistributionRule hyDistributionRule)
    {
        startPage();
        List<HyDistributionRule> list = hyDistributionRuleService.selectHyDistributionRuleList(hyDistributionRule);
        return getDataTable(list);
    }

    /**
     * 导出分销规则列表
     */
    @ApiOperation("分销规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDistributionRule", value = "项目实体类hyDistributionRule", required = true),
	})
    @RequiresPermissions("system:rule:export")
    @Log(title = "分销规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyDistributionRule hyDistributionRule)
    {
        List<HyDistributionRule> list = hyDistributionRuleService.selectHyDistributionRuleList(hyDistributionRule);
        ExcelUtil<HyDistributionRule> util = new ExcelUtil<HyDistributionRule>(HyDistributionRule.class);
        return util.exportExcel(list, "rule");
    }

    /**
     * 新增分销规则
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存分销规则
     */
    @ApiOperation("分销规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDistributionRule", value = "项目实体类hyDistributionRule", required = true),
	})
    @RequiresPermissions("system:rule:add")
    @Log(title = "分销规则", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyDistributionRule hyDistributionRule)
    {
        return toAjax(hyDistributionRuleService.insertHyDistributionRule(hyDistributionRule));
    }

    /**
     * 修改分销规则
     */
    @ApiOperation("分销规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyDistributionRule hyDistributionRule = hyDistributionRuleService.selectHyDistributionRuleById(id);
        mmap.put("hyDistributionRule", hyDistributionRule);
        return prefix + "/edit";
    }

    /**
     * 修改保存分销规则
     */
    @ApiOperation("分销规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDistributionRule", value = "项目实体类hyDistributionRule", required = true),
	})
    @RequiresPermissions("system:rule:edit")
    @Log(title = "分销规则", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyDistributionRule hyDistributionRule)
    {
        return toAjax(hyDistributionRuleService.updateHyDistributionRule(hyDistributionRule));
    }

    /**
     * 删除分销规则
     */
    @ApiOperation("分销规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:rule:remove")
    @Log(title = "分销规则", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyDistributionRuleService.deleteHyDistributionRuleByIds(ids));
    }
}
