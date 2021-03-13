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
import com.ruoyi.system.domain.HyCommunityIntroduction;
import com.ruoyi.system.service.IHyCommunityIntroductionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社区简介Controller
 * 
 * @author Administrator
 * @date 2021-03-12
 */
@Controller
@RequestMapping("/system/introduction")
@Api(tags = "社区简介Controller")
public class HyCommunityIntroductionController extends BaseController
{
    private String prefix = "system/introduction";

    @Autowired
    private IHyCommunityIntroductionService hyCommunityIntroductionService;

    @RequiresPermissions("system:introduction:view")
    @GetMapping()
    public String introduction()
    {
        return prefix + "/introduction";
    }

    /**
     * 查询社区简介列表
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityIntroduction", value = "项目实体类hyCommunityIntroduction", required = true),
	})
    @RequiresPermissions("system:introduction:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCommunityIntroduction hyCommunityIntroduction)
    {
        startPage();
        List<HyCommunityIntroduction> list = hyCommunityIntroductionService.selectHyCommunityIntroductionList(hyCommunityIntroduction);
        return getDataTable(list);
    }

    /**
     * 导出社区简介列表
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityIntroduction", value = "项目实体类hyCommunityIntroduction", required = true),
	})
    @RequiresPermissions("system:introduction:export")
    @Log(title = "社区简介", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCommunityIntroduction hyCommunityIntroduction)
    {
        List<HyCommunityIntroduction> list = hyCommunityIntroductionService.selectHyCommunityIntroductionList(hyCommunityIntroduction);
        ExcelUtil<HyCommunityIntroduction> util = new ExcelUtil<HyCommunityIntroduction>(HyCommunityIntroduction.class);
        return util.exportExcel(list, "introduction");
    }

    /**
     * 新增社区简介
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社区简介
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityIntroduction", value = "项目实体类hyCommunityIntroduction", required = true),
	})
    @RequiresPermissions("system:introduction:add")
    @Log(title = "社区简介", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCommunityIntroduction hyCommunityIntroduction)
    {
        return toAjax(hyCommunityIntroductionService.insertHyCommunityIntroduction(hyCommunityIntroduction));
    }

    /**
     * 修改社区简介
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCommunityIntroduction hyCommunityIntroduction = hyCommunityIntroductionService.selectHyCommunityIntroductionById(id);
        mmap.put("hyCommunityIntroduction", hyCommunityIntroduction);
        return prefix + "/edit";
    }

    /**
     * 修改保存社区简介
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityIntroduction", value = "项目实体类hyCommunityIntroduction", required = true),
	})
    @RequiresPermissions("system:introduction:edit")
    @Log(title = "社区简介", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCommunityIntroduction hyCommunityIntroduction)
    {
        return toAjax(hyCommunityIntroductionService.updateHyCommunityIntroduction(hyCommunityIntroduction));
    }

    /**
     * 删除社区简介
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:introduction:remove")
    @Log(title = "社区简介", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCommunityIntroductionService.deleteHyCommunityIntroductionByIds(ids));
    }
}
