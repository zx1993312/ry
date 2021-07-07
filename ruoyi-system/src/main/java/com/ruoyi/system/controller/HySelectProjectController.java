package com.ruoyi.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.common.core.controller.BaseController;

import io.swagger.annotations.Api;

/**
 * 项目列表Controller
 * 
 * @author Administrator
 * @date 2021-01-04
 */
@Controller
@CrossOrigin
@RequestMapping("/system/selectProject")
@Api(tags = "航宇物业，项目列表controller")
public class HySelectProjectController extends BaseController {
	private String prefix = "system/selectProject";


	@RequiresPermissions("system:project:view")
	@GetMapping()
	public String project() {
		return prefix + "/project";
	}

}
