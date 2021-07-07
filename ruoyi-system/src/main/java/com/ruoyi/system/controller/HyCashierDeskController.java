package com.ruoyi.system.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HouseAndCost;
import com.ruoyi.system.domain.HyBuilding;
import com.ruoyi.system.domain.HyCashierDesk;
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.domain.HyResidentialQuarters;
import com.ruoyi.system.mapper.HyBuildingMapper;
import com.ruoyi.system.mapper.HyCollectionMapper;
import com.ruoyi.system.mapper.HyCustomerMapper;
import com.ruoyi.system.mapper.HyOwnerRegistrationMapper;
import com.ruoyi.system.mapper.HyResidentialQuartersMapper;
import com.ruoyi.system.service.IHyCashierDeskService;
import com.ruoyi.system.service.IHyHouseInfService;
import com.ruoyi.system.utils.ReceivableUtil;

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
@CrossOrigin
@RequestMapping("/system/cashierDesk")
@Api(tags = "收银台Controller")
public class HyCashierDeskController extends BaseController {
	private String prefix = "system/cashierDesk";

	@Autowired
	private IHyCashierDeskService hyCashierDeskService;

	@Autowired
	private IHyHouseInfService hyHouseInfService;

	@Autowired
	private HyCustomerMapper hyCustomerMapper;

	@Autowired
	private HyBuildingMapper hyBuildingMapper;

	@Autowired
	private HyOwnerRegistrationMapper hyOwnerRegistrationMapper;

	@Autowired
	private HyResidentialQuartersMapper hyResidentialQuartersMapper;

	@Autowired
	private HyCollectionMapper hyCollectionMapper;

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
		/*
		 * if (StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName())
		 * && StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName()) &&
		 * StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit()) &&
		 * StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName()) &&
		 * StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getMobilePhone()) &&
		 * StringUtils.isEmpty(hyCost.getHyCollection().getIsCollection())) {
		 * List<HyCost> relist = new ArrayList<HyCost>();
		 */
		startPage();
		List<HyCost> list = hyCashierDeskService.selectHyCashierDeskList(hyCost);
		for (HyCost cost : list) {
			BigDecimal calculationStandard = cost.getCalculationStandard();
			String calculationMehod = cost.getCalculationMehod();
			BigDecimal bilingArea = cost.getHyHouseInf().getBilingArea();
			BigDecimal amountReceivable = ReceivableUtil.getReceivable(calculationStandard, calculationMehod, bilingArea);
			if(cost.getHouseAndCost().getDiscount()!=null) {
				amountReceivable = amountReceivable.multiply(cost.getHouseAndCost().getDiscount());
			}
			cost.setAmountReceivable(amountReceivable.setScale(2, RoundingMode.HALF_UP));
			if (cost.getHyCollection().getAmount() == null) {
				cost.getHyCollection().setAmount(new BigDecimal(0));
			}
			/*
			 * cost.setId(Long.valueOf(String.valueOf(cost.getId()).split(cost.getHyHouseInf
			 * ().getHouseNumber())[0]));
			 */
		}
		return getDataTable(list);
		/*
		 * for (HyCost cost : list) { HyCost reCost = new HyCost(); HouseAndCost
		 * houseAndCost = new HouseAndCost(); houseAndCost.setCostId(cost.getId());
		 * List<HouseAndCost> houseList = hyCustomerMapper.selectCostIds(houseAndCost);
		 */
		/*
		 * for (int i = 0; i < houseList.size(); i++) { reCost = (HyCost)
		 * Constants.REFLECT_UTIL.convertBean(new HyCost(), cost); BigDecimal
		 * calculationStandard = reCost.getCalculationStandard(); String costItems =
		 * reCost.getCostItems(); Long houseId = houseList.get(i).getHouseId();
		 * HyHouseInf hyHouseInf = hyHouseInfService.selectHyHouseInfById(houseId);
		 * BigDecimal bilingArea = hyHouseInf.getBilingArea(); BigDecimal
		 * amountReceivable = ReceivableUtil.getReceivable(calculationStandard,
		 * costItems, bilingArea);
		 * reCost.setAmountReceivable(amountReceivable.setScale(2,RoundingMode.HALF_UP))
		 * ; reCost.setHyHouseInf(hyHouseInf); Long buildingId =
		 * hyHouseInf.getBuildingId(); HyBuilding hyBuilding =
		 * hyBuildingMapper.selectHyBuildingById(buildingId);
		 * reCost.setHyBuilding(hyBuilding); Long ownerId = hyHouseInf.getOwnerId();
		 * HyOwnerRegistration hyOwnerRegistration = hyOwnerRegistrationMapper
		 * .selectHyOwnerRegistrationById(ownerId);
		 * reCost.setHyOwnerRegistration(hyOwnerRegistration); Long quartersId =
		 * hyBuilding.getQuartersId(); HyResidentialQuarters hyResidentialQuarters =
		 * hyResidentialQuartersMapper .selectHyResidentialQuartersById(quartersId);
		 * reCost.setHyResidentialQuarters(hyResidentialQuarters); Long costId =
		 * cost.getId(); HyCollection hyCollection = new HyCollection();
		 * hyCollection.setCostId(costId); hyCollection.setHouseId(houseId);
		 * hyCollection.setOwnerId(ownerId); List<HyCollection> collList =
		 * hyCollectionMapper.selectHyCollectionList(hyCollection); if (collList.size()
		 * != 0) { reCost.setHyCollection(collList.get(0)); } else {
		 * reCost.setHyCollection(new HyCollection());
		 * reCost.getHyCollection().setAmount((long) 0); } relist.add(reCost); } }
		 * 
		 * return getDataTable(list, relist); } else if
		 * (!StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName())
		 * || !StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName()) ||
		 * !StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit()) ||
		 * !StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName()) ||
		 * hyCost.getHyOwnerRegistration().getMobilePhone() != null ||
		 * !StringUtils.isEmpty(hyCost.getHyCollection().getIsCollection())) {
		 * 
		 * String isCollection = hyCost.getHyCollection().getIsCollection(); if
		 * ("".equals(isCollection)) { List<HyCost> list =
		 * hyCashierDeskService.selectHyCashierDeskList(hyCost); return
		 * getDataTable(list); } else if ("1".equals(isCollection) &&
		 * StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName()) &&
		 * StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName()) &&
		 * StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit()) &&
		 * StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName()) &&
		 * hyCost.getHyOwnerRegistration().getMobilePhone() == null) { List<HyCost>
		 * relist = new ArrayList<HyCost>(); List<HyCost> list =
		 * hyCashierDeskService.selectHyCashierDeskListByIsCollection(hyCost); for
		 * (HyCost cost : list) { HyCost reCost = new HyCost(); HouseAndCost
		 * houseAndCost = new HouseAndCost(); houseAndCost.setCostId(cost.getId());
		 * List<HouseAndCost> houseList = hyCustomerMapper.selectCostIds(houseAndCost);
		 * for (int i = 0; i < houseList.size(); i++) { reCost = (HyCost)
		 * Constants.REFLECT_UTIL.convertBean(new HyCost(), cost); Long houseId =
		 * houseList.get(i).getHouseId(); HyHouseInf hyHouseInf =
		 * hyHouseInfService.selectHyHouseInfById(houseId);
		 * reCost.setHyHouseInf(hyHouseInf); Long buildingId =
		 * hyHouseInf.getBuildingId(); HyBuilding hyBuilding =
		 * hyBuildingMapper.selectHyBuildingById(buildingId);
		 * reCost.setHyBuilding(hyBuilding); Long ownerId = hyHouseInf.getOwnerId();
		 * HyOwnerRegistration hyOwnerRegistration = hyOwnerRegistrationMapper
		 * .selectHyOwnerRegistrationById(ownerId);
		 * reCost.setHyOwnerRegistration(hyOwnerRegistration); Long quartersId =
		 * hyBuilding.getQuartersId(); HyResidentialQuarters hyResidentialQuarters =
		 * hyResidentialQuartersMapper .selectHyResidentialQuartersById(quartersId);
		 * reCost.setHyResidentialQuarters(hyResidentialQuarters); Long costId =
		 * cost.getId(); HyCollection hyCollection = new HyCollection();
		 * hyCollection.setCostId(costId); hyCollection.setHouseId(houseId);
		 * hyCollection.setOwnerId(ownerId); reCost.setHyCollection(new HyCollection());
		 * reCost.getHyCollection().setAmount((long) 0); relist.add(reCost); } } return
		 * getDataTable(list, relist); } else if ("1".equals(isCollection)) { if
		 * (!StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName())
		 * || !StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName()) ||
		 * !StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit()) ||
		 * !StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName()) ||
		 * hyCost.getHyOwnerRegistration().getMobilePhone() != null) { List<HyCost> list
		 * = hyCashierDeskService.selectHyCashierDeskListByIsCollection(hyCost); return
		 * getDataTable(list); } } else if ("0".equals(isCollection) &&
		 * StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName()) &&
		 * StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName()) &&
		 * StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit()) &&
		 * StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName()) &&
		 * hyCost.getHyOwnerRegistration().getMobilePhone() == null) { List<HyCost>
		 * relist = new ArrayList<HyCost>(); List<HyCost> list =
		 * hyCashierDeskService.selectHyCashierDeskList(hyCost); for (HyCost cost :
		 * list) { HyCost reCost = new HyCost(); HouseAndCost houseAndCost = new
		 * HouseAndCost(); houseAndCost.setCostId(cost.getId()); List<HouseAndCost>
		 * houseList = hyCustomerMapper.selectCostIds(houseAndCost); for (int i = 0; i <
		 * houseList.size(); i++) { reCost = (HyCost)
		 * Constants.REFLECT_UTIL.convertBean(new HyCost(), cost); Long houseId =
		 * houseList.get(i).getHouseId(); HyHouseInf hyHouseInf =
		 * hyHouseInfService.selectHyHouseInfById(houseId);
		 * reCost.setHyHouseInf(hyHouseInf); Long buildingId =
		 * hyHouseInf.getBuildingId(); HyBuilding hyBuilding =
		 * hyBuildingMapper.selectHyBuildingById(buildingId);
		 * reCost.setHyBuilding(hyBuilding); Long ownerId = hyHouseInf.getOwnerId();
		 * HyOwnerRegistration hyOwnerRegistration = hyOwnerRegistrationMapper
		 * .selectHyOwnerRegistrationById(ownerId);
		 * reCost.setHyOwnerRegistration(hyOwnerRegistration); Long quartersId =
		 * hyBuilding.getQuartersId(); HyResidentialQuarters hyResidentialQuarters =
		 * hyResidentialQuartersMapper .selectHyResidentialQuartersById(quartersId);
		 * reCost.setHyResidentialQuarters(hyResidentialQuarters); Long costId =
		 * cost.getId(); HyCollection hyCollection = new HyCollection();
		 * hyCollection.setCostId(costId); hyCollection.setHouseId(houseId);
		 * hyCollection.setOwnerId(ownerId); List<HyCollection> collList =
		 * hyCollectionMapper.selectHyCollectionList(hyCollection); if (collList.size()
		 * != 0) { reCost.setHyCollection(collList.get(0)); } else {
		 * reCost.setHyCollection(new HyCollection());
		 * reCost.getHyCollection().setAmount((long) 0); } relist.add(reCost); } }
		 * return getDataTable(list, relist); } else if ("0".equals(isCollection)) { if
		 * (!StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName())
		 * || !StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName()) ||
		 * !StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit()) ||
		 * !StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName()) ||
		 * hyCost.getHyOwnerRegistration().getMobilePhone() != null) { List<HyCost> list
		 * = hyCashierDeskService.selectHyCashierDeskList(hyCost); return
		 * getDataTable(list); } } } return getDataTable(new ArrayList<>());
		 */
	}

	/**
	 * 综合收款查询收银台列表
	 */
	@ApiOperation("收银台")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cashierDesk:list")
	@PostMapping("/lists")
	@ResponseBody
	public List<HyCost> lists(HyCost hyCost) {
		startPage();
		List<HyCost> list = hyCashierDeskService.selectHyCashierDeskList(hyCost);
		for (HyCost cost : list) {
			BigDecimal calculationStandard = cost.getCalculationStandard();
			String calculationMehod = cost.getCalculationMehod();
			BigDecimal bilingArea = cost.getHyHouseInf().getBilingArea();
			BigDecimal amountReceivable = ReceivableUtil.getReceivable(calculationStandard, calculationMehod, bilingArea);
			if(cost.getHouseAndCost().getDiscount()!=null) {
				amountReceivable = amountReceivable.multiply(cost.getHouseAndCost().getDiscount());
			}
			cost.setAmountReceivable(amountReceivable.setScale(2, RoundingMode.HALF_UP));
			if (cost.getHyCollection().getAmount() == null) {
				cost.getHyCollection().setAmount(new BigDecimal(0));
			}
		}
		return list;
	}

	/**
	 * 一键催缴查询收银台列表
	 */
	@ApiOperation("收银台")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cashierDesk:list")
	@PostMapping("/listss")
	@ResponseBody
	public List<HyCost> listss(HyCost hyCost) {
		startPage();
		List<HyCost> relist = new ArrayList<HyCost>();
		List<HyCost> list = hyCashierDeskService.selectHyCashierDeskListByIsCollection(hyCost);
		for (HyCost cost : list) {
			HyCost reCost = new HyCost();
			HouseAndCost houseAndCost = new HouseAndCost();
			houseAndCost.setCostId(cost.getId());
			List<HouseAndCost> houseList = hyCustomerMapper.selectCostIds(houseAndCost);
			for (int i = 0; i < houseList.size(); i++) {
				reCost = (HyCost) Constants.REFLECT_UTIL.convertBean(new HyCost(), cost);
				Long houseId = houseList.get(i).getHouseId();
				HyHouseInf hyHouseInf = hyHouseInfService.selectHyHouseInfById(houseId);
				reCost.setHyHouseInf(hyHouseInf);
				Long buildingId = hyHouseInf.getBuildingId();
				HyBuilding hyBuilding = hyBuildingMapper.selectHyBuildingById(buildingId);
				reCost.setHyBuilding(hyBuilding);
				Long ownerId = hyHouseInf.getOwnerId();
				HyOwnerRegistration hyOwnerRegistration = hyOwnerRegistrationMapper
						.selectHyOwnerRegistrationById(ownerId);
				reCost.setHyOwnerRegistration(hyOwnerRegistration);
				Long quartersId = hyBuilding.getQuartersId();
				HyResidentialQuarters hyResidentialQuarters = hyResidentialQuartersMapper
						.selectHyResidentialQuartersById(quartersId);
				reCost.setHyResidentialQuarters(hyResidentialQuarters);
				Long costId = cost.getId();
				HyCollection hyCollection = new HyCollection();
				hyCollection.setCostId(costId);
				hyCollection.setHouseId(houseId);
				hyCollection.setOwnerId(ownerId);
				reCost.setHyCollection(new HyCollection());
				reCost.getHyCollection().setAmount(new BigDecimal(0));
				relist.add(reCost);
			}
		}
		return relist;
	}

	/**
	 * 查询应收总计未收总计已收总计列表
	 */
	@ApiOperation("收银台")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:cashierDesk:list")
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
	 * 修改收银台
	 */
	@ApiOperation("收银台")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyCost hyCost = hyCashierDeskService.selectHyCashierDeskById(id);
		BigDecimal calculationStandard = hyCost.getCalculationStandard();
		String calculationMehod = hyCost.getCalculationMehod();
		BigDecimal bilingArea = hyCost.getHyHouseInf().getBilingArea();
		BigDecimal amountReceivable = ReceivableUtil.getReceivable(calculationStandard, calculationMehod, bilingArea);
		if(hyCost.getHouseAndCost().getDiscount()!=null) {
			amountReceivable = amountReceivable.multiply(hyCost.getHouseAndCost().getDiscount());
		}
		hyCost.setAmountReceivable(amountReceivable.setScale(2, RoundingMode.HALF_UP));
		mmap.put("hyCost", hyCost);
		return prefix + "/edit";
	}

	/**
	 * 修改保存收银台
	 */
	/*
	 * @ApiOperation("收银台")
	 * 
	 * @ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value =
	 * "项目实体类hyCost", required = true), })
	 * 
	 * @RequiresPermissions("system:cashierDesk:edit")
	 * 
	 * @Log(title = "收银台", businessType = BusinessType.UPDATE)
	 * 
	 * @PostMapping("/edits") public String edits(String datas, ModelMap mmap) {
	 * List<JSONObject> list = new ArrayList<>(); JSONArray jsonArray =
	 * JSONArray.parseArray(datas); for (int i = 0; i < jsonArray.size(); i++) {
	 * list.add(jsonArray.getJSONObject(i)); }
	 * 
	 * mmap.put("list", list); return prefix + "/cashierDesk"; }
	 */
	/**
	 * 修改收银台
	 */
	@ApiOperation("收银台")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edits/{id}")
	public String edits(@PathVariable("id") String id, ModelMap mmap) {
		String[] ids = id.split(",");
		HyCost hyCost = new HyCost();
		BigDecimal amountReceivableCount = new BigDecimal(0.00);
		List<HyCost> list = new ArrayList<>();
		for (String ida : ids) {
			Long idd = Long.valueOf(ida);
			HyCost hyCostA = hyCashierDeskService.selectHyCashierDeskById(idd);
			hyCost.setHyHouseInf(new HyHouseInf());
			hyCost.getHyHouseInf().setOwnerId(hyCostA.getHyHouseInf().getOwnerId());
			hyCost.setHouseAndCost(new HouseAndCost());
			hyCost.getHouseAndCost().setHouseId(hyCostA.getHouseAndCost().getHouseId());
			hyCost.getHouseAndCost().setFeeDate(hyCostA.getHouseAndCost().getFeeDate());
			BigDecimal calculationStandard = hyCostA.getCalculationStandard();
			String calculationMehod = hyCostA.getCalculationMehod();
			String costItems = hyCostA.getCostItems();
			BigDecimal bilingArea = hyCostA.getHyHouseInf().getBilingArea();
			BigDecimal amountReceivable = ReceivableUtil.getReceivable(calculationStandard, calculationMehod, bilingArea);
			if(hyCostA.getHouseAndCost().getDiscount()!=null) {
				amountReceivable = amountReceivable.multiply(hyCostA.getHouseAndCost().getDiscount());
			}
			amountReceivableCount = amountReceivableCount.add(amountReceivable);
			HyCost hyCostB = new HyCost();
			hyCostB.setCostItems(costItems);
			hyCostB.setAmountReceivable(amountReceivable.setScale(2, RoundingMode.HALF_UP));
			list.add(hyCostB);
		}
		hyCost.setCostIds(id);
		hyCost.setAmountReceivable(amountReceivableCount.setScale(2, RoundingMode.HALF_UP));
		mmap.put("list", list);
		mmap.put("hyCost", hyCost);
		return prefix + "/edits";
	}

	/**
	 * 修改收银台
	 */
	@ApiOperation("收银台")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/editss/{id}")
	public String editss(@PathVariable("id") Long id, ModelMap mmap) {
		HyCost hyCost = hyCashierDeskService.selectHyCashierDeskById(id);
		BigDecimal calculationStandard = hyCost.getCalculationStandard();
		String calculationMehod = hyCost.getCalculationMehod();
		BigDecimal bilingArea = hyCost.getHyHouseInf().getBilingArea();
		BigDecimal amountReceivable = ReceivableUtil.getReceivable(calculationStandard, calculationMehod, bilingArea);
		if(hyCost.getHouseAndCost().getDiscount()!=null) {
			amountReceivable = amountReceivable.multiply(hyCost.getHouseAndCost().getDiscount());
		}
		hyCost.setAmountReceivable(amountReceivable.setScale(2, RoundingMode.HALF_UP));
		mmap.put("hyCost", hyCost);
		return prefix + "/editss";
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
	public AjaxResult editSave(HyCost hyCost, ModelMap mmap) {

		mmap.put("hyCost", hyCost);
		return toAjax(hyCashierDeskService.updateHyCashierDesk(hyCost));
	}

	/**
	 * 打印所有收据
	 */
	@PostMapping("/printReceipt")
	@ResponseBody
	public AjaxResult printReceipt(HttpServletResponse response) throws Exception {
		return AjaxResult.success(hyCashierDeskService.printReceipt(response));
	}

	/**
	 * 打印所有催收单
	 */
	@PostMapping("/printCollection")
	@ResponseBody
	public AjaxResult printCollection(HttpServletResponse response) throws Exception {
		return AjaxResult.success(hyCashierDeskService.printCollection(response));
	}

	/**
	 * 批量打印收据
	 */
	@ApiOperation("批量打印收据")
	@ApiImplicitParams({ @ApiImplicitParam(name = "datas", value = "datas", required = true), })
	@RequiresPermissions("system:cashierDesk:printReceiptMore")
	@Log(title = "批量打印收据", businessType = BusinessType.UPDATE)
	@PostMapping("/printReceiptMore")
	@ResponseBody
	public AjaxResult editPrintReceiptMore(String datas, ModelMap mmap) {
		try {
			return AjaxResult.success(hyCashierDeskService.printReceiptMore(datas));
		} catch (Exception e) {
			e.printStackTrace();
			return toAjax(0);
		}
	}

	/**
	 * 一键打印未支付数据
	 */
	@ApiOperation("一键打印未支付数据")
	@ApiImplicitParams({ @ApiImplicitParam(name = "datas", value = "datas", required = true), })
	@RequiresPermissions("system:cashierDesk:printReceiptSelect")
	@Log(title = "一键打印未支付数据", businessType = BusinessType.UPDATE)
	@PostMapping("/printReceiptSelect")
	@ResponseBody
	public AjaxResult printReceiptSelect(String datas, ModelMap mmap) {
		try {
			return AjaxResult.success(hyCashierDeskService.printReceiptSelect(datas));
		} catch (Exception e) {
			e.printStackTrace();
			return toAjax(0);
		}
	}

	/**
	 * 批量打印催收单
	 */
	@ApiOperation("批量打印催收单")
	@ApiImplicitParams({ @ApiImplicitParam(name = "datas", value = "datas", required = true), })
	@RequiresPermissions("system:cashierDesk:printReceiptMore")
	@Log(title = "批量打印催收单", businessType = BusinessType.UPDATE)
	@PostMapping("/printCollectionMore")
	@ResponseBody
	public AjaxResult printCollectionMore(String datas, ModelMap mmap) {
		try {
			return AjaxResult.success(hyCashierDeskService.printCollectionMore(datas));
		} catch (Exception e) {
			e.printStackTrace();
			return toAjax(0);
		}
	}

	/**
	 * 打印单条收据
	 */
	@PostMapping("/printReceiptOne")
	@ResponseBody
	public AjaxResult printReceiptOne(HyCost hyCost, HttpServletResponse response) throws Exception {
		return AjaxResult.success(hyCashierDeskService.printReceiptOne(hyCost, response));
	}

	/**
	 * 打印单条催收单
	 */
	@PostMapping("/printCollectionOne")
	@ResponseBody
	public AjaxResult printCollectionOne(HyCost hyCost, HttpServletResponse response) throws Exception {
		return AjaxResult.success(hyCashierDeskService.printCollectionOne(hyCost, response));
	}

	/**
	 * 导出收银台列表
	 */
	@ApiOperation("收银台")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCashierDesk", value = "项目实体类hyCashierDesk", required = true), })
	@RequiresPermissions("system:cashierDesk:export")
	@Log(title = "收银台", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyCost hyCost) {
		List<HyCost> relist = new ArrayList<HyCost>();
		List<HyCost> list = hyCashierDeskService.selectHyCashierDeskList(hyCost);
		for (HyCost cost : list) {
			HyCost reCost = new HyCost();
			HouseAndCost houseAndCost = new HouseAndCost();
			houseAndCost.setCostId(cost.getId());
			List<HouseAndCost> houseList = hyCustomerMapper.selectCostIds(houseAndCost);
			for (int i = 0; i < houseList.size(); i++) {
				reCost = (HyCost) Constants.REFLECT_UTIL.convertBean(new HyCost(), cost);
				Long houseId = houseList.get(i).getHouseId();
				HyHouseInf hyHouseInf = hyHouseInfService.selectHyHouseInfById(houseId);
				reCost.setHyHouseInf(hyHouseInf);
				Long buildingId = hyHouseInf.getBuildingId();
				HyBuilding hyBuilding = hyBuildingMapper.selectHyBuildingById(buildingId);
				reCost.setHyBuilding(hyBuilding);
				Long ownerId = hyHouseInf.getOwnerId();
				HyOwnerRegistration hyOwnerRegistration = hyOwnerRegistrationMapper
						.selectHyOwnerRegistrationById(ownerId);
				reCost.setHyOwnerRegistration(hyOwnerRegistration);
				Long quartersId = hyBuilding.getQuartersId();
				HyResidentialQuarters hyResidentialQuarters = hyResidentialQuartersMapper
						.selectHyResidentialQuartersById(quartersId);
				reCost.setHyResidentialQuarters(hyResidentialQuarters);
				HouseAndCost houseAndCost2 = new HouseAndCost();
				houseAndCost2.setCostId(cost.getId());
				houseAndCost2.setHouseId(houseId);
				List<HouseAndCost> houseList1 = hyCustomerMapper.selectCostIds(houseAndCost2);
				houseAndCost2 = houseList1.get(0);
				reCost.setHouseAndCost(houseAndCost2);
				Long costId = cost.getId();
				HyCollection hyCollection = new HyCollection();
				hyCollection.setCostId(costId);
				hyCollection.setHouseId(houseId);
				hyCollection.setOwnerId(ownerId);
				List<HyCollection> collList = hyCollectionMapper.selectHyCollectionList(hyCollection);
				if (collList.size() != 0) {
					reCost.setHyCollection(collList.get(0));
				} else {
					reCost.setHyCollection(new HyCollection());
					reCost.getHyCollection().setAmount(new BigDecimal(0));
				}
				relist.add(reCost);
			}
		}
		List<HyCashierDesk> cashierDeskList = new ArrayList<HyCashierDesk>();
		for (HyCost rel : relist) {
			HyCashierDesk hyCashierDesk = new HyCashierDesk();
			hyCashierDesk.setId(rel.getId());
			hyCashierDesk.setCostItems(rel.getCostItems());
			hyCashierDesk.setCommunityName(rel.getHyResidentialQuarters().getCommunityName());
			hyCashierDesk.setBuildingName(rel.getHyBuilding().getBuildingName());
			hyCashierDesk.setFeeDate(rel.getHouseAndCost().getFeeDate());
			hyCashierDesk.setIsCollection(rel.getHyCollection().getIsCollection());
			hyCashierDesk.setAmountReceivable(rel.getAmountReceivable());
			hyCashierDesk.setAmount(rel.getHyCollection().getAmount());
			cashierDeskList.add(hyCashierDesk);
		}
		ExcelUtil<HyCashierDesk> util = new ExcelUtil<HyCashierDesk>(HyCashierDesk.class);
		return util.exportExcel(cashierDeskList, "hyCashierDesk");
	}

	/**
	 * 导入费用数据
	 * 
	 * @param file
	 * @param updateSupport
	 * @return
	 * @throws Exception
	 */
	@Log(title = "用户管理", businessType = BusinessType.IMPORT)
	@RequiresPermissions("system:cashierDesk:import")
	@PostMapping("/importData")
	@ResponseBody
	public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
		ExcelUtil<HyCashierDesk> util = new ExcelUtil<HyCashierDesk>(HyCashierDesk.class);
		List<HyCashierDesk> cashierDeskList = util.importExcel(file.getInputStream());
		String operName = ShiroUtils.getSysUser().getLoginName();
		String message = hyCashierDeskService.importCashierDesk(cashierDeskList, updateSupport, operName);
		return AjaxResult.success(message);
	}

}
