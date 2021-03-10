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
import com.ruoyi.system.domain.HyDistribution;
import com.ruoyi.system.service.IHyDistributionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分销Controller
 * 
 * @author Administrator
 * @date 2021-03-09
 */
@Controller
@RequestMapping("/system/distribution")
@Api(tags = "分销Controller")
public class HyDistributionController extends BaseController
{
    private String prefix = "system/distribution";

    @Autowired
    private IHyDistributionService hyDistributionService;

    @RequiresPermissions("system:distribution:view")
    @GetMapping()
    public String distribution()
    {
        return prefix + "/distribution";
    }

    /**
     * 查询分销列表
     */
    @ApiOperation("分销")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDistribution", value = "项目实体类hyDistribution", required = true),
	})
    @RequiresPermissions("system:distribution:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyDistribution hyDistribution)
    {
        startPage();
        List<HyDistribution> list = hyDistributionService.selectHyDistributionList(hyDistribution);
        return getDataTable(list);
    }

    /**
     * 导出分销列表
     */
    @ApiOperation("分销")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDistribution", value = "项目实体类hyDistribution", required = true),
	})
    @RequiresPermissions("system:distribution:export")
    @Log(title = "分销", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyDistribution hyDistribution)
    {
        List<HyDistribution> list = hyDistributionService.selectHyDistributionList(hyDistribution);
        ExcelUtil<HyDistribution> util = new ExcelUtil<HyDistribution>(HyDistribution.class);
        return util.exportExcel(list, "distribution");
    }

    /**
     * 新增分销
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存分销
     */
    @ApiOperation("分销")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDistribution", value = "项目实体类hyDistribution", required = true),
	})
    @RequiresPermissions("system:distribution:add")
    @Log(title = "分销", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyDistribution hyDistribution)
    {
        return toAjax(hyDistributionService.insertHyDistribution(hyDistribution));
    }

    /**
     * 修改分销
     */
    @ApiOperation("分销")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyDistribution hyDistribution = hyDistributionService.selectHyDistributionById(id);
        mmap.put("hyDistribution", hyDistribution);
        return prefix + "/edit";
    }

    /**
     * 修改保存分销
     */
    @ApiOperation("分销")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyDistribution", value = "项目实体类hyDistribution", required = true),
	})
    @RequiresPermissions("system:distribution:edit")
    @Log(title = "分销", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyDistribution hyDistribution)
    {
        return toAjax(hyDistributionService.updateHyDistribution(hyDistribution));
    }

    /**
     * 删除分销
     */
    @ApiOperation("分销")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:distribution:remove")
    @Log(title = "分销", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyDistributionService.deleteHyDistributionByIds(ids));
    }
}
