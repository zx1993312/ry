package com.ruoyi.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.common.core.controller.BaseController;

import io.swagger.annotations.Api;

/**
 * 商家Controller
 * 
 * @author Administrator
 * @date 2021-03-05
 */
@Controller
@CrossOrigin
@RequestMapping("/system/map")
@Api(tags = "商家Controller")
public class HyMapController extends BaseController {
	private String prefix = "system/baiduMap";

	@RequiresPermissions("system:business:view")
	@GetMapping()
	public String business() {
		return prefix + "/map";
	}
}
