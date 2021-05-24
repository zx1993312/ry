package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyCustomer;
import com.ruoyi.system.domain.ReHyCustomer;
import com.ruoyi.system.service.CustomerService;

@Controller
@RequestMapping("/system/customer")
public class CustomerController extends BaseController {

	private String prefix = "system/customerStandardSetting";
	
	@Autowired
	private CustomerService customerService;

	/**
	 * 查询费用项目列表
	 */
	@RequiresPermissions("system:getCharges:list")
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
				relist.add(reHyCustomer);
			}
		}
		return getDataTable(relist);
	}
}
