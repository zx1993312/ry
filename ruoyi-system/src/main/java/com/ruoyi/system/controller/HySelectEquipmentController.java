package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyEquipment;
import com.ruoyi.system.service.IHyEquipmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 设备类别Controller
 * 
 * @author Administrator
 * @date 2021-05-08
 */
@Controller
@CrossOrigin
@RequestMapping("/system/selectEquipment")
@Api(tags = "设备类别Controller")
public class HySelectEquipmentController extends BaseController
{
    private String prefix = "system/selectEquipment";

    @Autowired
    private IHyEquipmentService hyEquipmentService;

    @RequiresPermissions("system:equipment:view")
    @GetMapping()
    public String equipment()
    {
        return prefix + "/equipment";
    }

    /**
     * 查询设备类别列表
     */
    @ApiOperation("设备类别")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEquipment", value = "项目实体类hyEquipment", required = true),
	})
    @RequiresPermissions("system:equipment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyEquipment hyEquipment)
    {
        startPage();
        List<HyEquipment> list = hyEquipmentService.selectHyEquipmentList(hyEquipment);
        return getDataTable(list);
    }
    
    /**
     * 查询设备类别列表树
     */
    @ApiOperation("设备类别")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyEquipment", value = "项目实体类hyEquipment", required = true),
    })
    @RequiresPermissions("system:equipment:list")
    @GetMapping("/equipmentList")
    @ResponseBody
    public List<Ztree> treeData() {
		List<Ztree> hyEquipment = hyEquipmentService.selectHyEquipmentListTree(new HyEquipment());
		return hyEquipment;
	}

    /**
     * 导出设备类别列表
     */
    @ApiOperation("设备类别")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyEquipment", value = "项目实体类hyEquipment", required = true),
	})
    @RequiresPermissions("system:equipment:export")
    @Log(title = "设备类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyEquipment hyEquipment)
    {
        List<HyEquipment> list = hyEquipmentService.selectHyEquipmentList(hyEquipment);
        ExcelUtil<HyEquipment> util = new ExcelUtil<HyEquipment>(HyEquipment.class);
        return util.exportExcel(list, "equipment");
    }

}
