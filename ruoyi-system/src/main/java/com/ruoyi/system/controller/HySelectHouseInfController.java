package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.service.IHyHouseInfService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 房屋登记Controller
 * 
 * @author Administrator
 * @date 2021-01-09
 */
@Controller
@CrossOrigin
@RequestMapping("/system/selectInf")
@Api(tags = "房屋登记Controller")
public class HySelectHouseInfController extends BaseController {
	private String prefix = "system/selectInf";

	@Autowired
	private IHyHouseInfService hyHouseInfService;

	@RequiresPermissions("system:inf:view")
	@GetMapping()
	public String registration() {
		return prefix + "/inf";
	}

	/**
	 * 查询房屋登记列表
	 */
	@ApiOperation("房屋登记")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyHouseInf", value = "项目实体类hyHouseInf", required = true), })
	@RequiresPermissions("system:inf:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyHouseInf hyHouseInf) {
		startPage();
		List<HyHouseInf> list = hyHouseInfService.selectHyHouseInfList(hyHouseInf);
		return getDataTable(list);
	}

	
	
}
