package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HouseAndCost;
import com.ruoyi.system.domain.HyBuilding;
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.domain.HyMeter;
import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.domain.HyResidentialQuarters;
import com.ruoyi.system.mapper.HyBuildingMapper;
import com.ruoyi.system.mapper.HyCollectionMapper;
import com.ruoyi.system.mapper.HyCustomerMapper;
import com.ruoyi.system.mapper.HyOwnerRegistrationMapper;
import com.ruoyi.system.mapper.HyResidentialQuartersMapper;
import com.ruoyi.system.service.IHyCashierDeskService;
import com.ruoyi.system.service.IHyHouseInfService;

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
		if (StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName())
				&& StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName())
				&& StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit())
				&& StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName())
				&& hyCost.getHyOwnerRegistration().getMobilePhone() == null
				&& StringUtils.isEmpty(hyCost.getHyCollection().getIsCollection())) {
		List<HyCost> relist = new ArrayList<HyCost>();
		startPage();
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
					reCost.getHyCollection().setAmount((long) 0);
				}
				relist.add(reCost);
			}
		}
		return getDataTable(relist);
		}else if (!StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName())
				|| !StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName())
				|| !StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit())
				|| !StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName())
				|| hyCost.getHyOwnerRegistration().getMobilePhone() != null
				|| !StringUtils.isEmpty(hyCost.getHyCollection().getIsCollection())) {
			
			String isCollection = hyCost.getHyCollection().getIsCollection();
			if("".equals(isCollection)){
				startPage();
				List<HyCost> list = hyCashierDeskService.selectHyCashierDeskList(hyCost);
				return getDataTable(list);
			}else if("1".equals(isCollection)
					&& StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName())
					&& StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName())
					&& StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit())
					&& StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName())
					&& hyCost.getHyOwnerRegistration().getMobilePhone() == null) {
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
						reCost.getHyCollection().setAmount((long) 0);
						relist.add(reCost);
					}
				}
				return getDataTable(relist);
			}else if("1".equals(isCollection)) {
				if(!StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName())
						|| !StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName())
						|| !StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit())
						|| !StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName())
						|| hyCost.getHyOwnerRegistration().getMobilePhone() != null) {
					startPage();
					List<HyCost> list = hyCashierDeskService.selectHyCashierDeskListByIsCollection(hyCost);
					return getDataTable(list);
				}
			}else if("0".equals(isCollection)
					&& StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName())
					&& StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName())
					&& StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit())
					&& StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName())
					&& hyCost.getHyOwnerRegistration().getMobilePhone() == null) {
				startPage();
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
							reCost.getHyCollection().setAmount((long) 0);
						}
						relist.add(reCost);
					}
				}
				return getDataTable(relist);
			}else if("0".equals(isCollection)) {
				if(!StringUtils.isEmpty(hyCost.getHyResidentialQuarters().getCommunityName())
						|| !StringUtils.isEmpty(hyCost.getHyBuilding().getBuildingName())
						|| !StringUtils.isEmpty(hyCost.getHyHouseInf().getUnit())
						|| !StringUtils.isEmpty(hyCost.getHyOwnerRegistration().getOwnerName())
						|| hyCost.getHyOwnerRegistration().getMobilePhone() != null) {
				startPage();
				List<HyCost> list = hyCashierDeskService.selectHyCashierDeskList(hyCost);
				return getDataTable(list);
				}
			}
		}
		startPage();
		List<HyCost> list = hyCashierDeskService.selectHyCashierDeskList(hyCost);
		return getDataTable(list);
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
		List<HyCost> list = hyCashierDeskService.selectHyCashierDeskListByIsCollection(hyCost);
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
				reCost.getHyCollection().setAmount((long) 0);
				relist.add(reCost);
			}
		}
		return relist;
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
	@PostMapping("/edits")
	@ResponseBody
	public AjaxResult editSave(String datas, ModelMap mmap) {
		List<JSONObject> list = new ArrayList<>();
		JSONArray jsonArray = JSONArray.parseArray(datas);
		for (int i = 0; i < jsonArray.size(); i++) {
			list.add(jsonArray.getJSONObject(i));
		}

		mmap.put("list", list);
		return toAjax(1);
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
		return toAjax(hyCashierDeskService.printReceipt(response));
	}

	/**
	 * 打印所有催收单
	 */
	@PostMapping("/printCollection")
	@ResponseBody
	public AjaxResult printCollection(HttpServletResponse response) throws Exception {
		return toAjax(hyCashierDeskService.printCollection(response));
	}
	
	/**
	 * 打印单条收据
	 */
	@PostMapping("/printReceiptOne")
	@ResponseBody
	public AjaxResult printReceiptOne(HyCost hyCost,HttpServletResponse response) throws Exception {
		return toAjax(hyCashierDeskService.printReceiptOne(hyCost,response));
	}
	
	/**
	 * 打印单条催收单
	 */
	@PostMapping("/printCollectionOne")
	@ResponseBody
	public AjaxResult printCollectionOne(HyCost hyCost,HttpServletResponse response) throws Exception {
		return toAjax(hyCashierDeskService.printCollectionOne(hyCost,response));
	}
	
	/**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<HyCollection> util = new ExcelUtil<HyCollection>(HyCollection.class);
        List<HyCollection> userList = util.importExcel(file.getInputStream());
        String message = importUser(userList, updateSupport);
        return AjaxResult.success(message);
    }

	private String importUser(List<HyCollection> userList, boolean updateSupport) {
		if (StringUtils.isNull(userList) || userList.size() == 0) {
			throw new BusinessException("导入抄表数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (HyCollection hyMeter : userList) {
			/*List<HyMeter> dataList = this.selectHyMeter(hyMeter);
			
			//判断这些是否为空
			if (StringUtils.isNull(hyMeter.getMeterSerialNum()) || StringUtils.isNull(hyMeter.getMeterName())
					|| StringUtils.isNull(hyMeter.getMeterType())
					|| StringUtils.isNull(hyMeter.getInitialRead())|| StringUtils.isNull(hyMeter.getAbnormalPrompt()))
					 {
				failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
				throw new BusinessException(failureMsg.toString());
			}
			
			//查询数据是否存在
			if (dataList == null || dataList.size() == 0) {
				this.insertHyMeter(hyMeter);
				successNum++;
				successMsg.append("<br/>" + successNum + "、表计序号 " + hyMeter.getMeterSerialNum() + " 导入成功");
			} else if (updateSupport) {
				hyMeter.setId(dataList.get(0).getId());
				this.updateHyMeter(hyMeter);
				successNum++;
				successMsg.append("<br/>" + successNum + "、表计序号" + hyMeter.getMeterSerialNum() + " 更新成功");
			} else {
				failureNum++;
				failureMsg.append("<br/>" + failureNum + "、表计序号" + hyMeter.getMeterSerialNum() + " 已存在");
			}*/
		}
		if (failureNum > 0) {
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		} else {
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		
		return  successMsg.toString();
	}
}
