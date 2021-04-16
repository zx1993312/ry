package com.ruoyi.system.controller;

import java.io.IOException;
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

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyReport;
import com.ruoyi.system.service.IHyReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报事管理Controller
 * 
 * @author Administrator
 * @date 2021-04-13
 */
@Controller
@RequestMapping("/system/report")
@Api(tags = "报事管理Controller")
public class HyReportController extends BaseController
{
    private String prefix = "system/report";

    @Autowired
    private IHyReportService hyReportService;

    @RequiresPermissions("system:report:view")
    @GetMapping()
    public String report()
    {
        return prefix + "/report";
    }

    /**
     * 查询报事管理列表
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyReport", value = "项目实体类hyReport", required = true),
	})
    @RequiresPermissions("system:report:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyReport hyReport)
    {
        startPage();
        List<HyReport> list = hyReportService.selectHyReportList(hyReport);
        return getDataTable(list);
    }

    /**
     * 导出报事管理列表
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyReport", value = "项目实体类hyReport", required = true),
	})
    @RequiresPermissions("system:report:export")
    @Log(title = "报事管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyReport hyReport)
    {
        List<HyReport> list = hyReportService.selectHyReportList(hyReport);
        ExcelUtil<HyReport> util = new ExcelUtil<HyReport>(HyReport.class);
        return util.exportExcel(list, "report");
    }

    /**
     * 新增报事管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报事管理
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyReport", value = "项目实体类hyReport", required = true),
	})
    @RequiresPermissions("system:report:add")
    @Log(title = "报事管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyReport hyReport)
    {
        return toAjax(hyReportService.insertHyReport(hyReport));
    }

    /**
     * 修改报事管理
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
    	HyReport hyReport = hyReportService.selectHyReportById(id);
    	mmap.put("hyReport", hyReport);
    	return prefix + "/detail";
    }
    
    /**
     * 修改报事管理
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyReport hyReport = hyReportService.selectHyReportById(id);
        mmap.put("hyReport", hyReport);
        return prefix + "/edit";
    }

    /**
     * 修改保存报事管理
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyReport", value = "项目实体类hyReport", required = true),
	})
    @RequiresPermissions("system:report:edit")
    @Log(title = "报事管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyReport hyReport)
    {
        return toAjax(hyReportService.updateHyReport(hyReport));
    }
    /**
     * 一键全部审核
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyReport", value = "项目实体类hyReport", required = true),
    })
    @RequiresPermissions("system:report:edit")
    @Log(title = "报事管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edits")
    @ResponseBody
    public AjaxResult edits(HyReport hyReport)
    {
    	return toAjax(hyReportService.updateAudit(hyReport));
    }

    /**
     * 删除报事管理
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:report:remove")
    @Log(title = "报事管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyReportService.deleteHyReportByIds(ids));
    }
    
    /**
     * 发送推送
     */
/*    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "phone", value = "phone", required = true),
	})
    @RequiresPermissions("system:report:remove")
    @Log(title = "报事管理", businessType = BusinessType.DELETE)
    @PostMapping( "/send")
    @ResponseBody
    public void send(String phone)
    {
        int appId = 1400507916;
        String appKey = "cb557ebf356684d1380e57d04c6290ce";
        int templateId = 926030;
        String smsSign = "航宇智慧物业";
        int appId = 1400330563;
        String appKey = "ef1e3d4f939cdf086c096be552920371";
        int templateId = 308731;
        String smsSign = "CNXFS";
        try {
        	String[] params = {};
			SmsSingleSender sender = new SmsSingleSender(appId, appKey);
			SmsSingleSenderResult result = sender.sendWithParam("86", phone, templateId,params, smsSign,"","");
			System.out.println(result);
		} catch (HTTPException e) {
			e.printStackTrace();
		}catch (JSONException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
    }*/
}
