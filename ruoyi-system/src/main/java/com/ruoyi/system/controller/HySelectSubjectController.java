package com.ruoyi.system.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ruoyi.system.domain.HyChargeSubjectSet;
import com.ruoyi.system.service.IHyChargeSubjectSetService;
import com.ruoyi.system.utils.ReflectUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 收费科目设置Controller
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Controller
@CrossOrigin
@RequestMapping("/system/selectSubject")
@Api(tags = "收费科目设置Controller")
public class HySelectSubjectController extends BaseController{
	private String prefix = "system/selectSubject";

	@Autowired
	private IHyChargeSubjectSetService hyChargeSubjectSetService;

	@RequiresPermissions("system:subject:view")
	@GetMapping()
	public String set() {
		return prefix + "/subject";
	}

	/**
	 * 查询收费科目设置列表
	 */
	@ApiOperation("收费科目设置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hyChargeSubjectSet", value = "项目实体类hyChargeSubjectSet", required = true), })
	@RequiresPermissions("system:subject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyChargeSubjectSet hyChargeSubjectSet) {
		startPage();
		List<HyChargeSubjectSet> list = hyChargeSubjectSetService.selectHyChargeSubjectSetList(hyChargeSubjectSet);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyChargeSubjectSet hcs : list) {
			Map<String, Object> map = new HashMap<>();
			map = ReflectUtil.convertMap(hcs);
			reList.add(map);
		}
		return getDataTable(list,  reList);
	}

}
