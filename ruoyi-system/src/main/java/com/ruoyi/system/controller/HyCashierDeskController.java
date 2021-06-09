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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.service.IHyCashierDeskService;
import com.ruoyi.system.service.IHyCollectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 收银台Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/system/cashierDesk")
@Api(tags = "收银台Controller")
public class HyCashierDeskController extends BaseController {
	private String prefix = "system/cashierDesk";

	@Autowired
	private IHyCashierDeskService hyCashierDeskService;

	@Autowired
	private IHyCollectionService hyCollectionService;

	@RequiresPermissions("system:cashierDesk:view")
	@GetMapping()
	public String cost() {
		return prefix + "/cashierDesk";
	}

	/**
	 * 查询收银台列表
	 */
	@ApiOperation("收银台")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cashierDesk:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyCost hyCost) {
		List<HyCost> relist = new ArrayList<HyCost>();
		startPage();
		List<HyCost> list = hyCashierDeskService.selectHyCashierDeskList(hyCost);
		/*for (HyCost cost : list) {

			HyCollection hyCollection = new HyCollection();
			hyCollection.setCostId(cost.getId());
			List<HyCollection> collList = hyCollectionService.selectHyCollectionList(hyCollection);
			for (int i = 0; i < collList.size(); i++) {
				HyCost reCost = new HyCost();
				reCost.setId(cost.getId());
				reCost.setCostItems(cost.getCostItems());
				reCost.setFeeDate(cost.getFeeDate());
				reCost.setAmountActually(cost.getAmountActually());
				reCost.setHyResidentialQuarters(cost.getHyResidentialQuarters());
				reCost.setHyBuilding(cost.getHyBuilding());
				reCost.setHyHouseInf(cost.getHyHouseInf());
				reCost.setHyOwnerRegistration(cost.getHyOwnerRegistration());
				relist.add(reCost);
			}

		}*/
		return getDataTable(list);
	}

	/**
	 * 修改收银台
	 */
	@ApiOperation("收银台")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyCost hyCost = hyCashierDeskService.selectHyCashierDeskById(id);
		mmap.put("hyCost", hyCost);
		return prefix + "/edit";
	}

	/**
	 * 修改保存收银台
	 */
	@ApiOperation("收银台")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cashierDesk:edit")
	@Log(title = "收银台", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyCost hyCost) {
		return toAjax(hyCashierDeskService.updateHyCashierDesk(hyCost));
	}

}
