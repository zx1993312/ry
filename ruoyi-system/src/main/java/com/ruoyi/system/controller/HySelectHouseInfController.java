package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.service.IHyOwnerRegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 业主资料登记Controller
 * 
 * @author Administrator
 * @date 2021-01-09
 */
@Controller
@RequestMapping("/system/selectInf")
@Api(tags = "业主资料登记Controller")
public class HySelectHouseInfController extends BaseController {
	private String prefix = "system/selectInf";

	@Autowired
	private IHyOwnerRegistrationService hyOwnerRegistrationService;

	@RequiresPermissions("system:registration:view")
	@GetMapping()
	public String registration() {
		return prefix + "/inf";
	}

	/**
	 * 查询业主资料登记列表
	 */
	@ApiOperation("业主资料登记")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyOwnerRegistration", value = "项目实体类hyOwnerRegistration", required = true), })
	@RequiresPermissions("system:registration:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyOwnerRegistration hyOwnerRegistration) {
		startPage();
		List<HyOwnerRegistration> list = hyOwnerRegistrationService.selectHyOwnerRegistrationList(hyOwnerRegistration);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyOwnerRegistration hor : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hor);
			reList.add(map);
		}
		return getDataTable(reList);
	}

	
	
}
