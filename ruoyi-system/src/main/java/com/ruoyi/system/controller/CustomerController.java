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

	@RequiresPermissions("system:registration:list")
	@PostMapping("/lists")
	@ResponseBody
	public List<HyCost> lists(@RequestParam("id") Long id) {
		return customerService.selectCostList(id);
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
	public AjaxResult addSave(@RequestParam(value = "buildingName", required = false) String buildingName,
			@RequestParam(value = "ownerName", required = false) String ownerName,
			@RequestParam(value = "houseNumber", required = false) String houseNumber,
			@RequestParam(value = "houseName", required = false) String houseName,
			@RequestParam(value = "deliveryStatus", required = false) String deliveryStatus,
			@RequestParam(value = "parkingNumber", required = false) String parkingNumber,
			@RequestParam(value = "meterName", required = false) String meterName,
			@RequestParam(value = "costItems", required = false) String costItems,
			@RequestParam(value = "expenseType", required = false) String expenseType,
			@RequestParam(value = "standardName1", required = false) String standardName,
			@RequestParam(value = "billingCycle", required = false) String billingCycle,
			@RequestParam(value = "calculationMehod", required = false) String calculationMehod,
			@RequestParam(value = "transferTenants", required = false) Integer transferTenants,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "ownerId", required = false) String ownerId,
			@RequestParam(value = "parkingId", required = false) Integer parkingId,
			@RequestParam(value = "meterId", required = false) Integer meterId) {

		/*
		 * 1.修改房屋表buliding_id 2.修改房屋表owner_id 3.修改房屋表delivery_status 4.修改车位表house_id
		 * 5.修改车位表owner_id 6.修改抄表表house_id 7.修改中间表house_and_cost表中house_id与cost_id
		 */
		// customerService.updateHouseInf();
		System.out.println("buildingName是hy_building表里的数据,存的是名称");

		System.out.println("ownerName是hy_owner_registration表里的数据,存的是名称");

		System.out.println("houseNumber是hy_house_inf表里的数据,存的是名称");
		System.out.println("houseName是hy_house_inf表里的数据,存的是名称");
		System.out.println("deliveryStatus是hy_house_inf表里的数据,存的是数字");
		System.out.println("parkingNumber是hy_parking_inf表里的数据,存的是名称");

		System.out.println("meterName是hy_meter表里的数据,存的是名称");

		System.out.println("costItems是hy_cost表里的数据,存的是名称");
		System.out.println("expenseType是hy_cost表里的数据,存的是名称");
		System.out.println("standardName是hy_cost表里的数据,存的是名称");
		System.out.println("billingCycle是hy_cost表里的数据,存的是数字");
		System.out.println("calculationMehod是hy_cost表里的数据,存的是数字");
		System.out.println("transferTenants是hy_cost表里的数据,存的是数字");
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
