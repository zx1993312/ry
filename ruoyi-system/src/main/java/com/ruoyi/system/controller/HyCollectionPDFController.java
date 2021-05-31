package com.ruoyi.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.service.IHyCollectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收款管理 Collection managementController
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
@Controller
@RequestMapping("/system/collectionPDF")
@Api(tags = "收款管理 Collection managementController")
public class HyCollectionPDFController extends BaseController
{
    private String prefix = "system/collectionPDF";

    @Autowired
    private IHyCollectionService hyCollectionService;

    @RequiresPermissions("system:collection:view")
    @GetMapping()
    public String collection()
    {
        return prefix + "/collectionPDF";
    }

    /**
     * 查询收款管理 Collection management列表
     */
    @ApiOperation("收款管理 Collection management")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true),
	})
    @RequiresPermissions("system:collection:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCollection hyCollection)
    {
        startPage();
        List<HyCollection> list = hyCollectionService.selectHyCollectionList(hyCollection);
        return getDataTable(list);
    }

    /**
     * 导出收款管理 Collection management列表
     */
    @ApiOperation("收款管理 Collection management")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true),
	})
    @RequiresPermissions("system:collection:export")
    @Log(title = "收款管理 Collection management", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCollection hyCollection)
    {
        List<HyCollection> list = hyCollectionService.selectHyCollectionList(hyCollection);
        ExcelUtil<HyCollection> util = new ExcelUtil<HyCollection>(HyCollection.class);
        return util.exportExcel(list, "collection");
    }
    
    /**
	 * 导出PDF
	 */
	 @PostMapping("/collectionPDF")
	 @ResponseBody
	public AjaxResult collectionPDF(HttpServletResponse response) throws Exception
	{
		 return toAjax(hyCollectionService.collectionPDF(response));
	}

}