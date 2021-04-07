package com.ruoyi.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.HyOrder;
import com.ruoyi.system.domain.HyProduct;
import com.ruoyi.system.service.IHyOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 个人中心Controller
 * 
 * @author Administrator
 * @date 2021-03-24
 */
@Controller
@RequestMapping("/system/productDetailsMC")
@Api(tags = "个人中心Controller")
public class HyMyCenterController extends BaseController {
	private String prefix = "system/productDetails";

	@Autowired
	private IHyOrderService hyOrderService;

	@RequiresPermissions("system:set:view")
	@GetMapping()
	public String set() {
		return prefix + "/myCenter";
	}

	@ApiOperation("查询订单设置列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyOrder", value = "项目实体类", required = true), })
	@RequestMapping("/list")
	public String list(HyOrder hyOrder, ModelMap mmap,HttpServletRequest request) {
		List<HyOrder> list = hyOrderService.selectHyOrderListTest(hyOrder);
		mmap.put("list", list);

		String state = request.getParameter("state");
		
		return prefix + "/myCenter";

	}

}
