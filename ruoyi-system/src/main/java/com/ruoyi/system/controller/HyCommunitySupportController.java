package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyCommunitySupport;
import com.ruoyi.system.service.IHyCommunitySupportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社区配套Controller
 * 
 * @author Administrator
 * @date 2021-03-12
 */
@Controller
@CrossOrigin
@RequestMapping("/system/support")
@Api(tags = "社区配套Controller")
public class HyCommunitySupportController extends BaseController
{
    private String prefix = "system/support";

    @Autowired
    private IHyCommunitySupportService hyCommunitySupportService;

    @RequiresPermissions("system:support:view")
    @GetMapping()
    public String support()
    {
        return prefix + "/support";
    }

    /**
     * 查询社区配套列表
     */
    @ApiOperation("社区配套")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySupport", value = "项目实体类hyCommunitySupport", required = true),
	})
    @RequiresPermissions("system:support:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCommunitySupport hyCommunitySupport)
    {
        startPage();
        List<HyCommunitySupport> list = hyCommunitySupportService.selectHyCommunitySupportList(hyCommunitySupport);
        return getDataTable(list);
    }

    /**
     * 导出社区配套列表
     */
    @ApiOperation("社区配套")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySupport", value = "项目实体类hyCommunitySupport", required = true),
	})
    @RequiresPermissions("system:support:export")
    @Log(title = "社区配套", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCommunitySupport hyCommunitySupport)
    {
        List<HyCommunitySupport> list = hyCommunitySupportService.selectHyCommunitySupportList(hyCommunitySupport);
        ExcelUtil<HyCommunitySupport> util = new ExcelUtil<HyCommunitySupport>(HyCommunitySupport.class);
        return util.exportExcel(list, "support");
    }

    /**
     * 新增社区配套
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社区配套
     */
    @ApiOperation("社区配套")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySupport", value = "项目实体类hyCommunitySupport", required = true),
	})
    @RequiresPermissions("system:support:add")
    @Log(title = "社区配套", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCommunitySupport hyCommunitySupport)
    {
        return toAjax(hyCommunitySupportService.insertHyCommunitySupport(hyCommunitySupport));
    }

    /**
     * 修改社区配套
     */
    @ApiOperation("社区配套")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCommunitySupport hyCommunitySupport = hyCommunitySupportService.selectHyCommunitySupportById(id);
        mmap.put("hyCommunitySupport", hyCommunitySupport);
        return prefix + "/edit";
    }

    /**
     * 修改保存社区配套
     */
    @ApiOperation("社区配套")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunitySupport", value = "项目实体类hyCommunitySupport", required = true),
	})
    @RequiresPermissions("system:support:edit")
    @Log(title = "社区配套", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCommunitySupport hyCommunitySupport)
    {
        return toAjax(hyCommunitySupportService.updateHyCommunitySupport(hyCommunitySupport));
    }

    /**
     * 删除社区配套
     */
    @ApiOperation("社区配套")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:support:remove")
    @Log(title = "社区配套", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCommunitySupportService.deleteHyCommunitySupportByIds(ids));
    }
}
