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
import com.ruoyi.system.domain.HyReminderNotice;
import com.ruoyi.system.service.IHyReminderNoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 催缴通知Controller
 * 
 * @author Administrator
 * @date 2021-07-14
 */
@Controller
@CrossOrigin
@RequestMapping("/system/notices")
@Api(tags = "催缴通知Controller")
public class HyReminderNoticeController extends BaseController
{
    private String prefix = "system/notices";

    @Autowired
    private IHyReminderNoticeService hyReminderNoticeService;

    @RequiresPermissions("system:notice:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/notice";
    }

    /**
     * 查询催缴通知列表
     */
    @ApiOperation("催缴通知")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyReminderNotice", value = "项目实体类hyReminderNotice", required = true),
	})
    @RequiresPermissions("system:notice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyReminderNotice hyReminderNotice)
    {
        startPage();
        List<HyReminderNotice> list = hyReminderNoticeService.selectHyReminderNoticeList(hyReminderNotice);
        return getDataTable(list);
    }
    
    /**
     * 查询催缴通知列表App
     */
    @ApiOperation("催缴通知")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyReminderNotice", value = "项目实体类hyReminderNotice", required = true),
    })
    @RequiresPermissions("system:notice:list")
    @PostMapping("/listApp")
    @ResponseBody
    public List<HyReminderNotice> listApp(HyReminderNotice hyReminderNotice)
    {
    	List<HyReminderNotice> list = hyReminderNoticeService.selectHyReminderNoticeList(hyReminderNotice);
    	return list;
    }

    /**
     * 导出催缴通知列表
     */
    @ApiOperation("催缴通知")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyReminderNotice", value = "项目实体类hyReminderNotice", required = true),
	})
    @RequiresPermissions("system:notice:export")
    @Log(title = "催缴通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyReminderNotice hyReminderNotice)
    {
        List<HyReminderNotice> list = hyReminderNoticeService.selectHyReminderNoticeList(hyReminderNotice);
        ExcelUtil<HyReminderNotice> util = new ExcelUtil<HyReminderNotice>(HyReminderNotice.class);
        return util.exportExcel(list, "notice");
    }

    /**
     * 新增催缴通知
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存催缴通知
     */
    @ApiOperation("催缴通知")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyReminderNotice", value = "项目实体类hyReminderNotice", required = true),
	})
    @RequiresPermissions("system:notice:add")
    @Log(title = "催缴通知", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyReminderNotice hyReminderNotice)
    {
        return toAjax(hyReminderNoticeService.insertHyReminderNotice(hyReminderNotice));
    }

    /**
     * 修改催缴通知
     */
    @ApiOperation("催缴通知")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyReminderNotice hyReminderNotice = hyReminderNoticeService.selectHyReminderNoticeById(id);
        mmap.put("hyReminderNotice", hyReminderNotice);
        return prefix + "/edit";
    }
    
    /**
     * 催缴通知详情App
     */
    @ApiOperation("催缴通知")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/editApp")
    @ResponseBody
    public List<HyReminderNotice> editApp(HyReminderNotice hyReminderNotice)
    {
    	List<HyReminderNotice> list = hyReminderNoticeService.selectHyReminderNoticeList(hyReminderNotice);
    	return list;
    }

    /**
     * 修改保存催缴通知
     */
    @ApiOperation("催缴通知")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyReminderNotice", value = "项目实体类hyReminderNotice", required = true),
	})
    @RequiresPermissions("system:notice:edit")
    @Log(title = "催缴通知", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyReminderNotice hyReminderNotice)
    {
        return toAjax(hyReminderNoticeService.updateHyReminderNotice(hyReminderNotice));
    }

    /**
     * 删除催缴通知
     */
    @ApiOperation("催缴通知")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:notice:remove")
    @Log(title = "催缴通知", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyReminderNoticeService.deleteHyReminderNoticeByIds(ids));
    }
}
