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
import com.ruoyi.system.domain.HyCommunity;
import com.ruoyi.system.service.IHyCommunityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社区Controller
 * 
 * @author Administrator
 * @date 2021-03-12
 */
@Controller
@CrossOrigin
@RequestMapping("/system/community")
@Api(tags = "社区Controller")
public class HyCommunityController extends BaseController
{
    private String prefix = "system/community";

    @Autowired
    private IHyCommunityService hyCommunityService;

    @RequiresPermissions("system:community:view")
    @GetMapping()
    public String community()
    {
        return prefix + "/community";
    }

    /**
     * 查询社区列表
     */
    @ApiOperation("社区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunity", value = "项目实体类hyCommunity", required = true),
	})
    @RequiresPermissions("system:community:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCommunity hyCommunity)
    {
        startPage();
        List<HyCommunity> list = hyCommunityService.selectHyCommunityList(hyCommunity);
        return getDataTable(list);
    }

    /**
     * 导出社区列表
     */
    @ApiOperation("社区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunity", value = "项目实体类hyCommunity", required = true),
	})
    @RequiresPermissions("system:community:export")
    @Log(title = "社区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCommunity hyCommunity)
    {
        List<HyCommunity> list = hyCommunityService.selectHyCommunityList(hyCommunity);
        ExcelUtil<HyCommunity> util = new ExcelUtil<HyCommunity>(HyCommunity.class);
        return util.exportExcel(list, "community");
    }

    /**
     * 新增社区
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社区
     */
    @ApiOperation("社区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunity", value = "项目实体类hyCommunity", required = true),
	})
    @RequiresPermissions("system:community:add")
    @Log(title = "社区", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCommunity hyCommunity)
    {
        return toAjax(hyCommunityService.insertHyCommunity(hyCommunity));
    }

    /**
     * 修改社区
     */
    @ApiOperation("社区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCommunity hyCommunity = hyCommunityService.selectHyCommunityById(id);
        mmap.put("hyCommunity", hyCommunity);
        return prefix + "/edit";
    }

    /**
     * 修改保存社区
     */
    @ApiOperation("社区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunity", value = "项目实体类hyCommunity", required = true),
	})
    @RequiresPermissions("system:community:edit")
    @Log(title = "社区", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCommunity hyCommunity)
    {
        return toAjax(hyCommunityService.updateHyCommunity(hyCommunity));
    }

    /**
     * 删除社区
     */
    @ApiOperation("社区")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:community:remove")
    @Log(title = "社区", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCommunityService.deleteHyCommunityByIds(ids));
    }
}
