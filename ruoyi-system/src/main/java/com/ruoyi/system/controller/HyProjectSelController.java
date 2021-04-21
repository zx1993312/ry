package com.ruoyi.system.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.HyProjectSel;
import com.ruoyi.system.service.IHyProjectSelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 项目收费比例查询Controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/system/projectSel")
@Api(tags = "项目收费比例查询Controller")
public class HyProjectSelController extends BaseController {
	private String prefix = "system/projectSel";

	@Autowired
	private IHyProjectSelService hyProjectSelService;

	@RequiresPermissions("system:projectSel:view")
	@GetMapping()
	public String cost() {
		return prefix +  "/project";
	}

	/**
	 * 查询项目收费比例列表
	 */
	@ApiOperation("费用项目")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyCost", value = "项目实体类hyCost", required = true), })
	@RequiresPermissions("system:projectSel:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyProjectSel hyProjectSel) {
		startPage();
		hyProjectSel.setDataTypeName("hy_delivery_status");
		List<HyProjectSel> list = hyProjectSelService.selectProjectSelList(hyProjectSel);
		return getDataTable(list);
	}

}
