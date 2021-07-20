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
import com.ruoyi.system.domain.HyCheckNode;
import com.ruoyi.system.service.IHyCheckNodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 巡检节点Controller
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Controller
@CrossOrigin
@RequestMapping("/system/node")
@Api(tags = "巡检节点Controller")
public class HyCheckNodeController extends BaseController
{
    private String prefix = "system/node";

    @Autowired
    private IHyCheckNodeService hyCheckNodeService;

    @RequiresPermissions("system:node:view")
    @GetMapping()
    public String node()
    {
        return prefix + "/node";
    }

    /**
     * 查询巡检节点列表
     */
    @ApiOperation("巡检节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckNode", value = "项目实体类hyCheckNode", required = true),
	})
    @RequiresPermissions("system:node:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCheckNode hyCheckNode)
    {
        startPage();
        List<HyCheckNode> list = hyCheckNodeService.selectHyCheckNodeList(hyCheckNode);
        return getDataTable(list);
    }
    
    /**
     * 查询巡检节点列表
     */
    @ApiOperation("巡检节点")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyCheckNode", value = "项目实体类hyCheckNode", required = true),
    })
    @RequiresPermissions("system:node:list")
    @PostMapping("/lists")
    @ResponseBody
    public List<HyCheckNode> lists(HyCheckNode hyCheckNode)
    {
    	List<HyCheckNode> list = hyCheckNodeService.selectHyCheckNodeList(hyCheckNode);
    	return list;
    }

    /**
     * 导出巡检节点列表
     */
    @ApiOperation("巡检节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckNode", value = "项目实体类hyCheckNode", required = true),
	})
    @RequiresPermissions("system:node:export")
    @Log(title = "巡检节点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCheckNode hyCheckNode)
    {
        List<HyCheckNode> list = hyCheckNodeService.selectHyCheckNodeList(hyCheckNode);
        ExcelUtil<HyCheckNode> util = new ExcelUtil<HyCheckNode>(HyCheckNode.class);
        return util.exportExcel(list, "node");
    }

    /**
     * 新增巡检节点
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存巡检节点
     */
    @ApiOperation("巡检节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckNode", value = "项目实体类hyCheckNode", required = true),
	})
    @RequiresPermissions("system:node:add")
    @Log(title = "巡检节点", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCheckNode hyCheckNode)
    {
        return toAjax(hyCheckNodeService.insertHyCheckNode(hyCheckNode));
    }

    /**
     * 修改巡检节点
     */
    @ApiOperation("巡检节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCheckNode hyCheckNode = hyCheckNodeService.selectHyCheckNodeById(id);
        mmap.put("hyCheckNode", hyCheckNode);
        return prefix + "/edit";
    }

    /**
     * 修改保存巡检节点
     */
    @ApiOperation("巡检节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCheckNode", value = "项目实体类hyCheckNode", required = true),
	})
    @RequiresPermissions("system:node:edit")
    @Log(title = "巡检节点", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCheckNode hyCheckNode)
    {
        return toAjax(hyCheckNodeService.updateHyCheckNode(hyCheckNode));
    }

    /**
     * 删除巡检节点
     */
    @ApiOperation("巡检节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:node:remove")
    @Log(title = "巡检节点", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCheckNodeService.deleteHyCheckNodeByIds(ids));
    }
}
