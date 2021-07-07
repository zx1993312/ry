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
import com.ruoyi.system.domain.HyCommunityInformation;
import com.ruoyi.system.service.IHyCommunityInformationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社区咨询Controller
 * 
 * @author Administrator
 * @date 2021-03-15
 */
@Controller
@CrossOrigin
@RequestMapping("/system/information")
@Api(tags = "社区咨询Controller")
public class HyCommunityInformationController extends BaseController
{
    private String prefix = "system/information";

    @Autowired
    private IHyCommunityInformationService hyCommunityInformationService;

    @RequiresPermissions("system:information:view")
    @GetMapping()
    public String information()
    {
        return prefix + "/information";
    }

    /**
     * 查询社区咨询列表
     */
    @ApiOperation("社区咨询")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityInformation", value = "项目实体类hyCommunityInformation", required = true),
	})
    @RequiresPermissions("system:information:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCommunityInformation hyCommunityInformation)
    {
        startPage();
        List<HyCommunityInformation> list = hyCommunityInformationService.selectHyCommunityInformationList(hyCommunityInformation);
        return getDataTable(list);
    }

    /**
     * 导出社区咨询列表
     */
    @ApiOperation("社区咨询")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityInformation", value = "项目实体类hyCommunityInformation", required = true),
	})
    @RequiresPermissions("system:information:export")
    @Log(title = "社区咨询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCommunityInformation hyCommunityInformation)
    {
        List<HyCommunityInformation> list = hyCommunityInformationService.selectHyCommunityInformationList(hyCommunityInformation);
        ExcelUtil<HyCommunityInformation> util = new ExcelUtil<HyCommunityInformation>(HyCommunityInformation.class);
        return util.exportExcel(list, "information");
    }

    /**
     * 新增社区咨询
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社区咨询
     */
    @ApiOperation("社区咨询")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityInformation", value = "项目实体类hyCommunityInformation", required = true),
	})
    @RequiresPermissions("system:information:add")
    @Log(title = "社区咨询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCommunityInformation hyCommunityInformation)
    {
        return toAjax(hyCommunityInformationService.insertHyCommunityInformation(hyCommunityInformation));
    }

    /**
     * 修改社区咨询
     */
    @ApiOperation("社区咨询")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCommunityInformation hyCommunityInformation = hyCommunityInformationService.selectHyCommunityInformationById(id);
        mmap.put("hyCommunityInformation", hyCommunityInformation);
        return prefix + "/edit";
    }

    /**
     * 修改保存社区咨询
     */
    @ApiOperation("社区咨询")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityInformation", value = "项目实体类hyCommunityInformation", required = true),
	})
    @RequiresPermissions("system:information:edit")
    @Log(title = "社区咨询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCommunityInformation hyCommunityInformation)
    {
        return toAjax(hyCommunityInformationService.updateHyCommunityInformation(hyCommunityInformation));
    }

    /**
     * 删除社区咨询
     */
    @ApiOperation("社区咨询")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:information:remove")
    @Log(title = "社区咨询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCommunityInformationService.deleteHyCommunityInformationByIds(ids));
    }
}
