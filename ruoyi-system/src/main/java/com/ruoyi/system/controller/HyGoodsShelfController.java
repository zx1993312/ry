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
import com.ruoyi.system.domain.HyGoodsShelf;
import com.ruoyi.system.service.IHyGoodsShelfService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 货架Controller
 * 
 * @author Administrator
 * @date 2021-06-21
 */
@Controller
@CrossOrigin
@RequestMapping("/system/shelf")
@Api(tags = "货架Controller")
public class HyGoodsShelfController extends BaseController
{
    private String prefix = "system/shelf";

    @Autowired
    private IHyGoodsShelfService hyGoodsShelfService;

    @RequiresPermissions("system:shelf:view")
    @GetMapping()
    public String shelf()
    {
        return prefix + "/shelf";
    }

    /**
     * 查询货架列表
     */
    @ApiOperation("货架")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyGoodsShelf", value = "项目实体类hyGoodsShelf", required = true),
	})
    @RequiresPermissions("system:shelf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyGoodsShelf hyGoodsShelf)
    {
        startPage();
        List<HyGoodsShelf> list = hyGoodsShelfService.selectHyGoodsShelfList(hyGoodsShelf);
        return getDataTable(list);
    }
    
    /**
     * 查询货架列表
     */
    @ApiOperation("货架")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyGoodsShelf", value = "项目实体类hyGoodsShelf", required = true),
    })
    @RequiresPermissions("system:shelf:list")
    @PostMapping("/lists")
    @ResponseBody
    public List<HyGoodsShelf> lists(HyGoodsShelf hyGoodsShelf)
    {
    	startPage();
    	List<HyGoodsShelf> list = hyGoodsShelfService.selectHyGoodsShelfList(hyGoodsShelf);
    	return list;
    }

    /**
     * 导出货架列表
     */
    @ApiOperation("货架")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyGoodsShelf", value = "项目实体类hyGoodsShelf", required = true),
	})
    @RequiresPermissions("system:shelf:export")
    @Log(title = "货架", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyGoodsShelf hyGoodsShelf)
    {
        List<HyGoodsShelf> list = hyGoodsShelfService.selectHyGoodsShelfList(hyGoodsShelf);
        ExcelUtil<HyGoodsShelf> util = new ExcelUtil<HyGoodsShelf>(HyGoodsShelf.class);
        return util.exportExcel(list, "shelf");
    }

    /**
     * 新增货架
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存货架
     */
    @ApiOperation("货架")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyGoodsShelf", value = "项目实体类hyGoodsShelf", required = true),
	})
    @RequiresPermissions("system:shelf:add")
    @Log(title = "货架", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyGoodsShelf hyGoodsShelf)
    {
        return toAjax(hyGoodsShelfService.insertHyGoodsShelf(hyGoodsShelf));
    }

    /**
     * 修改货架
     */
    @ApiOperation("货架")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyGoodsShelf hyGoodsShelf = hyGoodsShelfService.selectHyGoodsShelfById(id);
        mmap.put("hyGoodsShelf", hyGoodsShelf);
        return prefix + "/edit";
    }

    /**
     * 修改保存货架
     */
    @ApiOperation("货架")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyGoodsShelf", value = "项目实体类hyGoodsShelf", required = true),
	})
    @RequiresPermissions("system:shelf:edit")
    @Log(title = "货架", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyGoodsShelf hyGoodsShelf)
    {
        return toAjax(hyGoodsShelfService.updateHyGoodsShelf(hyGoodsShelf));
    }

    /**
     * 删除货架
     */
    @ApiOperation("货架")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:shelf:remove")
    @Log(title = "货架", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyGoodsShelfService.deleteHyGoodsShelfByIds(ids));
    }
}
