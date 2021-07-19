package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.ruoyi.system.domain.HouseAndCost;
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyCustomer;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.domain.ReHyCustomer;
import com.ruoyi.system.mapper.HyCollectionMapper;
import com.ruoyi.system.mapper.HyCostMapper;
import com.ruoyi.system.service.CustomerService;
import com.ruoyi.system.service.impl.HyHouseInfServiceImpl;
import com.ruoyi.system.utils.ReflectUtil;

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
@CrossOrigin
@RequestMapping("/system/customer")
public class CustomerController extends BaseController {

	private String prefix = "system/customerStandardSetting";

	@Autowired
	private CustomerService customerService;

	@Autowired
	private HyHouseInfServiceImpl hyhouseInfServiceImpl;

	@Autowired
	private HyCostMapper hyCostMapper;

	@Autowired
	private HyCollectionMapper hyCollectionMapper;

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
				ReHyCustomer reHyCustomer = (ReHyCustomer) ReflectUtil.convertBean(new ReHyCustomer(), hyCustomer);

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

	@RequiresPermissions("system:registration:list")
	@PostMapping("/houseOrCostId")
	@ResponseBody
	public List<HyHouseInf> selectCostIds(HouseAndCost houseAndCost) {
		List<HyHouseInf> relist = new ArrayList<HyHouseInf>();
		List<HouseAndCost> houseAndCostList = customerService.selectCostIds(houseAndCost);
		for (HouseAndCost list : houseAndCostList) {
			HyHouseInf hyHouseInf = hyhouseInfServiceImpl.selectHyHouseInfById(list.getHouseId());
			relist.add(hyHouseInf);
		}
		return relist;
	}

	@RequiresPermissions("system:registration:list")
	@PostMapping("/houseOrCostList")
	@ResponseBody
	public List<HyCost> houseOrCostList(HouseAndCost houseAndCost) {
		List<HyCost> relist = new ArrayList<HyCost>();
		List<HouseAndCost> houseAndCostList = customerService.selectCostIds(houseAndCost);
		for (HouseAndCost houseAndcost : houseAndCostList) {
			HyCollection hyCollection = new HyCollection();
			hyCollection.setCostId(houseAndcost.getCostId());
			hyCollection.setHouseId(houseAndcost.getHouseId());
			List<HyCollection> collectionList = hyCollectionMapper.selectHyCollectionList(hyCollection);
			if (collectionList.size() != 0) {
				for (HyCollection collection : collectionList) {
					HyCost hyCost = hyCostMapper.selectHyCostById(collection.getCostId());
					relist.add(hyCost);
				}
			}
		}
		return relist;
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
				ReHyCustomer reHyCustomer = (ReHyCustomer) ReflectUtil.convertBean(new ReHyCustomer(), hyCustomer);

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
			@RequestParam(value = "transferTenants", required = false) Integer transferTenants) {

		int result = customerService.updateHyCost(houseNumber, costItems, expenseType, standardName, billingCycle,
				calculationMehod, transferTenants);
		return toAjax(result);
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
	public AjaxResult remove(String costItems) {
		return toAjax(customerService.deleteHyCustomer(costItems));
	}

}
