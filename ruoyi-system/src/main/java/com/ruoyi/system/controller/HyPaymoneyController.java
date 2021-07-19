package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.service.IHyCollectionService;
import com.ruoyi.system.utils.ReflectUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 交款管理 Collection managementController
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Controller
@CrossOrigin
@RequestMapping("/system/paymoney")
@Api(tags = "航宇物业，交款管理 controller")
public class HyPaymoneyController extends BaseController {
	private String prefix = "system/paymoney";

	@Autowired
	private IHyCollectionService hyCollectionService;

	@RequiresPermissions("system:paymoney:view")
	@GetMapping()
	public String paymoney() {
		return prefix + "/paymoney";
	}

	/**
	 * 查询交款管理 Collection management列表
	 */
	@RequiresPermissions("system:paymoney:list")
	@ApiOperation("查询交款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyCollection hyCollection) {
		startPage();
		List<HyCollection> list = hyCollectionService.selectHyCollectionList(hyCollection);
		List<Map<String, Object>> reList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		for (HyCollection hc : list) {
			map = ReflectUtil.convertMap(hc);
			reList.add(map);
		}
		return getDataTable(list,  reList);
	}
	
	/**
	 * 查询交款管理 Collection management列表
	 */
	@RequiresPermissions("system:paymoney:list")
	@ApiOperation("查询交款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	@PostMapping("/lists")
	@ResponseBody
	public TableDataInfo lists(HyCollection hyCollection) {
		startPage();
		List<HyCollection> list = hyCollectionService.selectHyPaymoneyList(hyCollection);
		List<Map<String, Object>> reList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		for (HyCollection hc : list) {
			map = ReflectUtil.convertMap(hc);
			reList.add(map);
		}
		return getDataTable(list,  reList);
	}

	/**
	 * 导出交款管理 Collection management列表
	 */
	@RequiresPermissions("system:paymoney:export")
	@Log(title = "交款管理", businessType = BusinessType.EXPORT)
	@ApiOperation("导出交款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyCollection hyCollection) {
		List<HyCollection> list = hyCollectionService.selectHyCollectionList(hyCollection);
		ExcelUtil<HyCollection> util = new ExcelUtil<HyCollection>(HyCollection.class);
		return util.exportExcel(list, "collection");
	}

	/**
	 * 新增交款管理 Collection management
	 */
	@GetMapping("/add")
	@ApiOperation("新增交款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	public String add() {
		return prefix + "/add";
	}


	/**
	 * 修改交款管理 Collection management
	 */
	@ApiOperation("修改交款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyCollection hyCollection = hyCollectionService.selectHyCollectionById(id);
		mmap.put("hyCollection", hyCollection);
		return prefix + "/edit";
	}
	
	/**
	 * 修改交款管理 Collection management
	 */
	@ApiOperation("修改交款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	@GetMapping("/edits/{id}")
	public String edits(@PathVariable("id") Long id, ModelMap mmap) {
		HyCollection hyCollection = hyCollectionService.selectHyCollectionById(id);
		mmap.put("hyCollection", hyCollection);
		return prefix + "/edits";
	}

	/**
	 * 修改保存交款管理 Collection management
	 */
	@RequiresPermissions("system:paymoney:edit")
	@Log(title = "交款管理", businessType = BusinessType.UPDATE)
	@ApiOperation("修改保存交款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类", required = true), })
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyCollection hyCollection) {
		return toAjax(hyCollectionService.updateHyCollection(hyCollection));
	}

	/**
	 * 删除交款管理 Collection management
	 */
	@RequiresPermissions("system:paymoney:remove")
	@Log(title = "交款管理", businessType = BusinessType.DELETE)
	@ApiOperation("删除交款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyCollectionService.deleteHyCollectionByIds(ids));
	}

	/**
	 * 导出PDF
	 */
	 @PostMapping("/exportPDF")
	 @ResponseBody
	public AjaxResult downloadPDF(HyCollection hyCollection,HttpServletResponse response) throws Exception
	{
		 return toAjax(hyCollectionService.downloadPDF(hyCollection,response));
	}
}
