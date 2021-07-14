package com.ruoyi.system.controller;

import java.awt.print.PrinterException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
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
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.service.IHyCashierDeskService;
import com.ruoyi.system.service.IHyCollectionService;
import com.ruoyi.system.utils.ReceivableUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.jasperreports.engine.JRException;

/**
 * 收款管理 Collection managementController
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
@Controller
@CrossOrigin
@RequestMapping("/system/collection")
@Api(tags = "收款管理 Collection managementController")
public class HyCollectionController extends BaseController {
	private String prefix = "system/collection";

	@Autowired
	private IHyCollectionService hyCollectionService;
	
	@Autowired
	private IHyCashierDeskService hyCashierDeskService;

	@RequiresPermissions("system:collection:view")
	@GetMapping()
	public String collection() {
		return prefix + "/collection";
	}

	/**
	 * 查询收款管理 Collection management列表
	 */
	@ApiOperation("收款管理 Collection management")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true), })
	@RequiresPermissions("system:collection:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyCollection hyCollection) {
		startPage();
		List<HyCollection> list = hyCollectionService.selectHyCollectionList(hyCollection);
		return getDataTable(list);
	}
	
	/**
	 * 查询应收总计未收总计已收总计列表
	 */
	@ApiOperation("收款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:collection:list")
	@PostMapping("/jisuan")
	@ResponseBody
	public Map<String, Object> jisuan() {
		Map<String, Object> map = new HashMap<>();
		List<HyCost> list = hyCashierDeskService.selectHyCashierDeskList(new HyCost());
		BigDecimal amountReceivableCount = new BigDecimal(0.00);
		BigDecimal amountCount = new BigDecimal(0.00);
		for (HyCost cost : list) {
			BigDecimal calculationStandard = cost.getCalculationStandard();
			String calculationMehod = cost.getCalculationMehod();
			BigDecimal bilingArea = cost.getHyHouseInf().getBilingArea();
			BigDecimal amountReceivable = ReceivableUtil.getReceivable(calculationStandard, calculationMehod, bilingArea);
			if(cost.getHouseAndCost().getDiscount()!=null) {
				amountReceivable = amountReceivable.multiply(cost.getHouseAndCost().getDiscount());
			}
			amountReceivableCount = amountReceivableCount.add(amountReceivable);
			BigDecimal amount = cost.getHyCollection().getAmount() == null ? new BigDecimal(0)
					: cost.getHyCollection().getAmount();
			amountCount = amountCount.add(amount);
		}
		BigDecimal uncollected = amountReceivableCount.subtract(amountCount);
		map.put("amountReceivable", amountReceivableCount);
		map.put("received", amountCount);
		map.put("uncollected", uncollected);
		return map;
	}
	/**
	 * 查询应收总计未收总计已收总计列表
	 */
	@ApiOperation("收款管理")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:collection:list")
	@PostMapping("/jisuans")
	@ResponseBody
	public Map<String, Object> jisuans(HyCollection hyCollection) {
		Map<String, Object> map = new HashMap<>();
		List<HyCollection> list = hyCollectionService.selectHyCollectionList(hyCollection);
		BigDecimal amountCount = new BigDecimal(0.00);
		for (HyCollection collection : list) {
			BigDecimal amount = collection.getAmount();
			amountCount = amountCount.add(amount);
		}
		map.put("received", amountCount);
		return map;
	}

	/**
	 * 导出收款管理 Collection management列表
	 */
	@ApiOperation("收款管理 Collection management")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true), })
	@RequiresPermissions("system:collection:export")
	@Log(title = "收款管理 Collection management", businessType = BusinessType.EXPORT)
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
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存收款管理 Collection management
	 */
	@ApiOperation("收款管理 Collection management")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true), })
	@RequiresPermissions("system:collection:add")
	@Log(title = "收款管理 Collection management", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyCollection hyCollection, HttpServletResponse response)
			throws InvalidPasswordException, JRException, IOException, PrinterException {
		return AjaxResult.success(hyCollectionService.insertHyCollection(hyCollection, response));
	}
	
	/**
	 * 新增保存收款管理 Collection management
	 */
	@ApiOperation("收款管理 Collection management")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true), })
	@RequiresPermissions("system:collection:add")
	@Log(title = "收款管理 Collection management", businessType = BusinessType.INSERT)
	@PostMapping("/addApp")
	@ResponseBody
	public AjaxResult addApp(HyCollection hyCollection)
	{
		return toAjax(hyCollectionService.insertHyCollection(hyCollection));
	}

	/**
	 * 批量新增保存收款管理 Collection management
	 */
	@ApiOperation("收款管理 Collection management")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true), })
	@RequiresPermissions("system:collection:add")
	@Log(title = "收款管理 Collection management", businessType = BusinessType.INSERT)
	@PostMapping("/adds")
	@ResponseBody
	public AjaxResult adds(HyCollection hyCollection) {
		return AjaxResult.success(hyCollectionService.insertHyCollectionByCostIds(hyCollection));
	}

	/**
	 * 新增保存收款管理 Collection management
	 */
	@ApiOperation("收款管理 Collection management")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true), })
	@RequiresPermissions("system:collection:add")
	@Log(title = "收款管理 Collection management", businessType = BusinessType.INSERT)
	@PostMapping("/addss")
	@ResponseBody
	public AjaxResult addss(HyCollection hyCollection, HttpServletResponse response)
			throws InvalidPasswordException, JRException, IOException, PrinterException {
		return AjaxResult.success(hyCollectionService.insertHyCollectionBuFen(hyCollection, response));
	}

	/**
	 * 修改收款管理 Collection management
	 */
	@ApiOperation("收款管理 Collection management")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyCollection hyCollection = hyCollectionService.selectHyCollectionById(id);
		mmap.put("hyCollection", hyCollection);
		return prefix + "/edit";
	}

	/**
	 * 修改保存收款管理 Collection management
	 */
	@ApiOperation("收款管理 Collection management")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCollection", value = "项目实体类hyCollection", required = true), })
	@RequiresPermissions("system:collection:edit")
	@Log(title = "收款管理 Collection management", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyCollection hyCollection) {
		return toAjax(hyCollectionService.updateHyCollection(hyCollection));
	}

	/**
	 * 删除收款管理 Collection management
	 */
	@ApiOperation("收款管理 Collection management")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:collection:remove")
	@Log(title = "收款管理 Collection management", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyCollectionService.deleteHyCollectionByIds(ids));
	}

	/**
	 * 删除收款管理修改中间表数据
	 */
	@ApiOperation("删除收款管理修改中间表数据")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:collection:removeAndUpdate")
	@Log(title = "删除收款管理修改中间表数据", businessType = BusinessType.DELETE)
	@PostMapping("/removeAndUpdate")
	@ResponseBody
	public AjaxResult removeAndUpdate(String ids) {
		return toAjax(hyCollectionService.deleteHyCollectionAndUpdate(ids));
	}
}