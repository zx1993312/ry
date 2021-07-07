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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.service.IHyEntryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 入账处理Controller
 * 
 * @author Administrator
 * @date 2021-01-23
 */
@Controller
@CrossOrigin
@RequestMapping("/system/entry")
@Api(tags = "入账处理Controller")
public class HyEntryController extends BaseController {
	private String prefix = "system/entry";

	@Autowired
	private IHyEntryService hyEntryService;

	@RequiresPermissions("system:entry:view")
	@GetMapping()
	public String entry() {
		return prefix + "/entry";
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
        List<HyCollection> list = hyEntryService.selectHyCollectionList(hyCollection);
        return getDataTable(list);
    }
    
    /**
     * 修改收款管理 Collection management
     */
    @ApiOperation("收款管理 Collection management")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCollection hyCollection = hyEntryService.selectHyCollectionById(id);
        mmap.put("hyCollection", hyCollection);
        return prefix + "/edit";
    }

    /**
     * 修改保存收款管理 Collection management
     */
    @ApiOperation("收款管理 Collection management")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true),
	})
    @RequiresPermissions("system:collection:edit")
    @Log(title = "收款管理 Collection management", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCollection hyCollection)
    {
        return toAjax(hyEntryService.updateHyCollection(hyCollection));
    }

}
