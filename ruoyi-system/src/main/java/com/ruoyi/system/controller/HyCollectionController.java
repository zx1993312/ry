package com.ruoyi.system.controller;

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
 * @date 2021-01-04
 */
@Controller
@RequestMapping("/system/collection")
@Api(tags = "航宇物业，收款管理 controller")
public class HyCollectionController extends BaseController {
	private String prefix = "system/collection";

	@Autowired
	private IHyCollectionService hyCollectionService;

	@RequiresPermissions("system:collection:view")
	@GetMapping()
	public String collection() {
		return prefix + "/collection";
	}

	/**
	 * 查询收款管理 Collection management列表
	 */
	@RequiresPermissions("system:collection:list")
	@ApiOperation("查询收款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyCollection hyCollection) {
		startPage();
		List<HyCollection> list = hyCollectionService.selectHyCollectionList(hyCollection);
		return getDataTable(list);
	}

	/**
	 * 导出收款管理 Collection management列表
	 */
	@RequiresPermissions("system:collection:export")
	@Log(title = "收款管理 Collection management", businessType = BusinessType.EXPORT)
	@ApiOperation("导出收款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyCollection hyCollection) {
		List<HyCollection> list = hyCollectionService.selectHyCollectionList(hyCollection);
		ExcelUtil<HyCollection> util = new ExcelUtil<HyCollection>(HyCollection.class);
		return util.exportExcel(list, "collection");
	}

	/**
	 * 新增收款管理 Collection management
	 */
	@GetMapping("/add")
	@ApiOperation("新增收款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存收款管理 Collection management
	 */
	@RequiresPermissions("system:collection:add")
	@Log(title = "收款管理 Collection management", businessType = BusinessType.INSERT)
	@ApiOperation("新增保存收款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyCollection hyCollection) {
		return toAjax(hyCollectionService.insertHyCollection(hyCollection));
	}

	/**
	 * 修改收款管理 Collection management
	 */
	@ApiOperation("修改收款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyCollection hyCollection = hyCollectionService.selectHyCollectionById(id);
		mmap.put("hyCollection", hyCollection);
		return prefix + "/edit";
	}

	/**
	 * 修改保存收款管理 Collection management
	 */
	@RequiresPermissions("system:collection:edit")
	@Log(title = "收款管理 Collection management", businessType = BusinessType.UPDATE)
	@ApiOperation("修改保存收款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyCollection hyCollection) {
		return toAjax(hyCollectionService.updateHyCollection(hyCollection));
	}

	/**
	 * 删除收款管理 Collection management
	 */
	@RequiresPermissions("system:collection:remove")
	@Log(title = "收款管理 Collection management", businessType = BusinessType.DELETE)
	@ApiOperation("删除收款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyCollectionService.deleteHyCollectionByIds(ids));
	}
}
