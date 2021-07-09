package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyReport;
import com.ruoyi.system.service.IHyReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 报事管理Controller
 * 
 * @author Administrator
 * @date 2021-04-13
 */
@Controller
@CrossOrigin
@RequestMapping("/system/reports")
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
     * 查询待派单报事管理列表APP
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyReport", value = "项目实体类hyReport", required = true),
    })
    @RequiresPermissions("system:report:list")
    @PostMapping("/listDP")
    @ResponseBody
    public List<HyReport> listDP(HyReport hyReport)
    {
    	List<HyReport> list = hyReportService.selectHyReportListByDP(hyReport);
    	return list;
    }
    
    /**
     * 查询已派单报事管理列表APP
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyReport", value = "项目实体类hyReport", required = true),
    })
    @RequiresPermissions("system:report:list")
    @PostMapping("/listYP")
    @ResponseBody
    public List<HyReport> listYP(HyReport hyReport)
    {
    	List<HyReport> list = hyReportService.selectHyReportListByYP(hyReport);
    	return list;
    }
    
    /**
     * 查询已完成报事管理列表APP
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyReport", value = "项目实体类hyReport", required = true),
    })
    @RequiresPermissions("system:report:list")
    @PostMapping("/listYWC")
    @ResponseBody
    public List<HyReport> listYWC(HyReport hyReport)
    {
    	List<HyReport> list = hyReportService.selectHyReportListByYWC(hyReport);
    	return list;
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
     * 新增保存报事管理App
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyReport", value = "项目实体类hyReport", required = true),
    })
    @RequiresPermissions("system:report:add")
    @Log(title = "报事管理", businessType = BusinessType.INSERT)
    @PostMapping("/appAdd")
    @ResponseBody
    public AjaxResult appAdd(HyReport hyReport)
    {
    	return toAjax(hyReportService.insertHyReportByApp(hyReport));
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
     * 查看报事管理详情App
     */
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/detailApp")
    public List<HyReport> detail(Long id)
    {
    	List<HyReport> list = new ArrayList<HyReport>();
    	HyReport hyReport = hyReportService.selectHyReportById(id);
    	list.add(hyReport);
    	return list;
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
    @ApiOperation("报事管理")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "phone", value = "phone", required = true),
	})
    @RequiresPermissions("system:report:remove")
    @Log(title = "报事管理", businessType = BusinessType.DELETE)
    @PostMapping( "/send")
    @ResponseBody
    public boolean send(String phone) throws Exception
    {
    	System.out.println("=============phone================="+phone);
        HttpClient client = new HttpClient();  
        PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");  
        post.addRequestHeader("Content-Type",  
                "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码  
        NameValuePair[] data = { new NameValuePair("Uid", "XuShilong"), // 注册的用户名  
                new NameValuePair("Key", "d41d8cd98f00b204e980"), // 注册成功后,登录网站使用的密钥  
                new NameValuePair("smsMob", phone), // 手机号码  
                new NameValuePair("smsText", "(1)接收员您好，请检查您的维修订单，请抓紧时间完成。") };//设置短信内容
post.setRequestBody(data);  
  
    client.executeMethod(post);  
    Header[] headers = post.getResponseHeaders();  
    int statusCode = post.getStatusCode();  
    System.out.println("statusCode:" + statusCode);  
    for (Header h : headers) {  
        System.out.println(h.toString());  
    }  
    String result = new String(post.getResponseBodyAsString().getBytes(  
            "gbk"));  
    System.out.println(result);  
    post.releaseConnection();  
    return true;
    }
}
