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
import com.ruoyi.system.domain.HyPoster;
import com.ruoyi.system.service.IHyPosterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 海报Controller
 * 
 * @author Administrator
 * @date 2021-03-09
 */
@Controller
@RequestMapping("/system/poster")
@Api(tags = "海报Controller")
public class HyPosterController extends BaseController
{
    private String prefix = "system/poster";

    @Autowired
    private IHyPosterService hyPosterService;

    @RequiresPermissions("system:poster:view")
    @GetMapping()
    public String poster()
    {
        return prefix + "/poster";
    }

    /**
     * 查询海报列表
     */
    @ApiOperation("海报")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPoster", value = "项目实体类hyPoster", required = true),
	})
    @RequiresPermissions("system:poster:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyPoster hyPoster)
    {
        startPage();
        List<HyPoster> list = hyPosterService.selectHyPosterList(hyPoster);
        return getDataTable(list);
    }

    /**
     * 导出海报列表
     */
    @ApiOperation("海报")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPoster", value = "项目实体类hyPoster", required = true),
	})
    @RequiresPermissions("system:poster:export")
    @Log(title = "海报", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyPoster hyPoster)
    {
        List<HyPoster> list = hyPosterService.selectHyPosterList(hyPoster);
        ExcelUtil<HyPoster> util = new ExcelUtil<HyPoster>(HyPoster.class);
        return util.exportExcel(list, "poster");
    }

    /**
     * 新增海报
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存海报
     */
    @ApiOperation("海报")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPoster", value = "项目实体类hyPoster", required = true),
	})
    @RequiresPermissions("system:poster:add")
    @Log(title = "海报", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyPoster hyPoster)
    {
        return toAjax(hyPosterService.insertHyPoster(hyPoster));
    }

    /**
     * 修改海报
     */
    @ApiOperation("海报")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyPoster hyPoster = hyPosterService.selectHyPosterById(id);
        mmap.put("hyPoster", hyPoster);
        return prefix + "/edit";
    }

    /**
     * 修改保存海报
     */
    @ApiOperation("海报")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyPoster", value = "项目实体类hyPoster", required = true),
	})
    @RequiresPermissions("system:poster:edit")
    @Log(title = "海报", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyPoster hyPoster)
    {
        return toAjax(hyPosterService.updateHyPoster(hyPoster));
    }

    /**
     * 删除海报
     */
    @ApiOperation("海报")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:poster:remove")
    @Log(title = "海报", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyPosterService.deleteHyPosterByIds(ids));
    }
}
