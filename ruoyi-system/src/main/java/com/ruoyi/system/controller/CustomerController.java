package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyCustomer;
import com.ruoyi.system.domain.ReHyCustomer;
import com.ruoyi.system.service.CustomerService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 客户标准单项设置
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/system/customer")
public class CustomerController extends BaseController {

	private String prefix = "system/customerStandardSetting";

	@Autowired
	private CustomerService customerService;

	/**
	 * 查询客户标准单项设置列表
	 */
	@RequiresPermissions("system:customer:list")
	@RequestMapping("/list")
	@ResponseBody
	public TableDataInfo list() {
		List<ReHyCustomer> relist = new ArrayList<ReHyCustomer>();
		startPage();
		List<HyCustomer> list = customerService.selectHyCustomerList();
		for (HyCustomer hyCustomer : list) {
			List<HyCost> hyCostList = customerService.selectHyCost(hyCustomer.getId());
			for (int i = 0; i < hyCostList.size(); i++) {
				ReHyCustomer reHyCustomer = (ReHyCustomer) Constants.REFLECT_UTIL.convertBean(new ReHyCustomer(),
						hyCustomer);

				reHyCustomer.setMeterName(hyCustomer.getHyMeter().getMeterName());
				reHyCustomer.setBuildingName(hyCustomer.getHyBuilding().getBuildingName());
				reHyCustomer.setOwnerName(hyCustomer.getHyOwnerRegistration().getOwnerName());
				reHyCustomer.setParkingNumber(hyCustomer.getHyParkingInf().getParkingNumber());
				reHyCustomer.setCostItems(hyCostList.get(i).getCostItems());
				reHyCustomer.setExpenseType(hyCostList.get(i).getExpenseType());
				reHyCustomer.setStandardName(hyCostList.get(i).getStandardName());
				reHyCustomer.setBillingCycle(hyCostList.get(i).getBillingCycle());
				reHyCustomer.setCalculationMehod(hyCostList.get(i).getCalculationMehod());
				reHyCustomer.setTransferTenants(hyCostList.get(i).getTransferTenants());
				relist.add(reHyCustomer);
			}
		}
		return getDataTable(relist);
	}

	/**
	 * 导出年度保养计划列表
	 */
	@ApiOperation("年度保养计划")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyAnnualplan", value = "项目实体类hyAnnualplan", required = true), })
	@RequiresPermissions("system:customer:export")
	@Log(title = "年度保养计划", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export() {
		List<ReHyCustomer> relist = new ArrayList<ReHyCustomer>();

		List<HyCustomer> list = customerService.selectHyCustomerList();
		for (HyCustomer hyCustomer : list) {
			List<HyCost> hyCostList = customerService.selectHyCost(hyCustomer.getId());
			for (int i = 0; i < hyCostList.size(); i++) {
				ReHyCustomer reHyCustomer = (ReHyCustomer) Constants.REFLECT_UTIL.convertBean(new ReHyCustomer(),
						hyCustomer);

				reHyCustomer.setMeterName(hyCustomer.getHyMeter().getMeterName());
				reHyCustomer.setBuildingName(hyCustomer.getHyBuilding().getBuildingName());
				reHyCustomer.setOwnerName(hyCustomer.getHyOwnerRegistration().getOwnerName());
				reHyCustomer.setParkingNumber(hyCustomer.getHyParkingInf().getParkingNumber());
				reHyCustomer.setCostItems(hyCostList.get(i).getCostItems());
				reHyCustomer.setExpenseType(hyCostList.get(i).getExpenseType());
				reHyCustomer.setStandardName(hyCostList.get(i).getStandardName());
				reHyCustomer.setBillingCycle(hyCostList.get(i).getBillingCycle());
				reHyCustomer.setCalculationMehod(hyCostList.get(i).getCalculationMehod());
				reHyCustomer.setTransferTenants(hyCostList.get(i).getTransferTenants());
				relist.add(reHyCustomer);
			}
		}
		ExcelUtil<ReHyCustomer> util = new ExcelUtil<ReHyCustomer>(ReHyCustomer.class);
		return util.exportExcel(relist, "custome");
	}

	/**
	 * 新增客户标准单项设置
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增客户标准单项设置
	 */
	@ApiOperation("客户标准单项设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyAnnualplan", value = "项目实体类hyAnnualplan", required = true), })
	@RequiresPermissions("system:customer:add")
	@Log(title = "年度保养计划", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestParam("buildingName") String buildingName,
			@RequestParam("ownerName") String ownerName, @RequestParam("houseNumber") String houseNumber,
			@RequestParam("houseName") String houseName, @RequestParam("deliveryStatus") String deliveryStatus,
			@RequestParam("parkingNumber") String parkingNumber, @RequestParam("meterName") String meterName,
			@RequestParam("costItems") String costItems, @RequestParam("expenseType") String expenseType,
			@RequestParam("standardName") String standardName, @RequestParam("billingCycle") String billingCycle,
			@RequestParam("calculationMehod") String calculationMehod,
			@RequestParam("transferTenants") String transferTenants) {
		System.out.println("新增客户标准单项设置");
		return null/* toAjax(hyAnnualplanService.insertHyAnnualplan(hyAnnualplan)) */;
	}

	/**
	 * 修改客户标准单项设置
	 */
	@ApiOperation("客户标准单项设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		System.out.println("修改客户标准单项设置");
		/*
		 * HyAnnualplan hyAnnualplan = hyAnnualplanService.selectHyAnnualplanById(id);
		 * mmap.put("hyAnnualplan", hyAnnualplan);
		 */
		return prefix + "/edit";
	}

	/**
	 * 修改保存客户标准单项设置
	 */
	@ApiOperation("客户标准单项设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyAnnualplan", value = "项目实体类hyAnnualplan", required = true), })
	@RequiresPermissions("system:customer:edit")
	@Log(title = "客户标准单项设置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave() {
		System.out.println("保存修改客户标准单项设置");
		return null;/* toAjax(hyAnnualplanService.updateHyAnnualplan(hyAnnualplan)); */
	}

	/**
	 * 删除年度保养计划
	 */
	@ApiOperation("客户标准单项设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:customer:remove")
	@Log(title = "客户标准单项设置", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return null;/* toAjax(hyAnnualplanService.deleteHyAnnualplanByIds(ids)); */
	}
}
