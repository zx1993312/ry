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
import com.ruoyi.system.domain.HyScore;
import com.ruoyi.system.service.IHyScoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评价Controller
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Controller
@RequestMapping("/system/score")
@Api(tags = "评价Controller")
public class HyScoreController extends BaseController
{
    private String prefix = "system/score";

    @Autowired
    private IHyScoreService hyScoreService;

    @RequiresPermissions("system:score:view")
    @GetMapping()
    public String score()
    {
        return prefix + "/score";
    }

    /**
     * 查询评价列表
     */
    @ApiOperation("评价")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyScore", value = "项目实体类hyScore", required = true),
	})
    @RequiresPermissions("system:score:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyScore hyScore)
    {
        startPage();
        List<HyScore> list = hyScoreService.selectHyScoreList(hyScore);
        return getDataTable(list);
    }

    /**
     * 导出评价列表
     */
    @ApiOperation("评价")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyScore", value = "项目实体类hyScore", required = true),
	})
    @RequiresPermissions("system:score:export")
    @Log(title = "评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyScore hyScore)
    {
        List<HyScore> list = hyScoreService.selectHyScoreList(hyScore);
        ExcelUtil<HyScore> util = new ExcelUtil<HyScore>(HyScore.class);
        return util.exportExcel(list, "score");
    }

    /**
     * 新增评价
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评价
     */
    @ApiOperation("评价")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyScore", value = "项目实体类hyScore", required = true),
	})
    @RequiresPermissions("system:score:add")
    @Log(title = "评价", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyScore hyScore)
    {
        return toAjax(hyScoreService.insertHyScore(hyScore));
    }

    /**
     * 修改评价
     */
    @ApiOperation("评价")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyScore hyScore = hyScoreService.selectHyScoreById(id);
        mmap.put("hyScore", hyScore);
        return prefix + "/edit";
    }

    /**
     * 修改保存评价
     */
    @ApiOperation("评价")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyScore", value = "项目实体类hyScore", required = true),
	})
    @RequiresPermissions("system:score:edit")
    @Log(title = "评价", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyScore hyScore)
    {
        return toAjax(hyScoreService.updateHyScore(hyScore));
    }

    /**
     * 删除评价
     */
    @ApiOperation("评价")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:score:remove")
    @Log(title = "评价", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyScoreService.deleteHyScoreByIds(ids));
    }
}
