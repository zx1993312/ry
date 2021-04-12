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
import com.ruoyi.system.domain.HyCommunitySuggest;
import com.ruoyi.system.service.IHyCommunitySuggestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社区建议Controller
 * 
 * @author Administrator
 * @date 2021-04-12
 */
@Controller
@RequestMapping("/system/suggest")
@Api(tags = "社区建议Controller")
public class HyCommunitySuggestController extends BaseController
{
    private String prefix = "system/suggest";

    @Autowired
    private IHyCommunitySuggestService hyCommunitySuggestService;

    @RequiresPermissions("system:suggest:view")
    @GetMapping()
    public String suggest()
    {
        return prefix + "/suggest";
    }

    /**
     * 查询社区建议列表
     */
    @ApiOperation("社区建议")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySuggest", value = "项目实体类hyCommunitySuggest", required = true),
	})
    @RequiresPermissions("system:suggest:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCommunitySuggest hyCommunitySuggest)
    {
        startPage();
        List<HyCommunitySuggest> list = hyCommunitySuggestService.selectHyCommunitySuggestList(hyCommunitySuggest);
        return getDataTable(list);
    }

    /**
     * 导出社区建议列表
     */
    @ApiOperation("社区建议")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySuggest", value = "项目实体类hyCommunitySuggest", required = true),
	})
    @RequiresPermissions("system:suggest:export")
    @Log(title = "社区建议", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCommunitySuggest hyCommunitySuggest)
    {
        List<HyCommunitySuggest> list = hyCommunitySuggestService.selectHyCommunitySuggestList(hyCommunitySuggest);
        ExcelUtil<HyCommunitySuggest> util = new ExcelUtil<HyCommunitySuggest>(HyCommunitySuggest.class);
        return util.exportExcel(list, "suggest");
    }

    /**
     * 新增社区建议
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社区建议
     */
    @ApiOperation("社区建议")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySuggest", value = "项目实体类hyCommunitySuggest", required = true),
	})
    @RequiresPermissions("system:suggest:add")
    @Log(title = "社区建议", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCommunitySuggest hyCommunitySuggest)
    {
        return toAjax(hyCommunitySuggestService.insertHyCommunitySuggest(hyCommunitySuggest));
    }

    /**
     * 修改社区建议
     */
    @ApiOperation("社区建议")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCommunitySuggest hyCommunitySuggest = hyCommunitySuggestService.selectHyCommunitySuggestById(id);
        mmap.put("hyCommunitySuggest", hyCommunitySuggest);
        return prefix + "/edit";
    }

    /**
     * 修改保存社区建议
     */
    @ApiOperation("社区建议")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySuggest", value = "项目实体类hyCommunitySuggest", required = true),
	})
    @RequiresPermissions("system:suggest:edit")
    @Log(title = "社区建议", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCommunitySuggest hyCommunitySuggest)
    {
        return toAjax(hyCommunitySuggestService.updateHyCommunitySuggest(hyCommunitySuggest));
    }

    /**
     * 删除社区建议
     */
    @ApiOperation("社区建议")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:suggest:remove")
    @Log(title = "社区建议", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCommunitySuggestService.deleteHyCommunitySuggestByIds(ids));
    }
}
