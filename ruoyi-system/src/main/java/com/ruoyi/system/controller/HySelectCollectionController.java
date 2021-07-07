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
import com.ruoyi.system.domain.HyCollection;
import com.ruoyi.system.service.IHyCollectionService;

/**
 * 查询收款Controller
 * 
 * @author Administrator
 * @date 2021-05-29
 */
@Controller
@CrossOrigin
@RequestMapping("/system/selectCollection")
public class HySelectCollectionController extends BaseController {

	@Autowired
	private IHyCollectionService hyCollectionService;

	private String prefix = "system/selectCollection";

	@RequiresPermissions("system:user:view")
	@GetMapping()
	public String user() {
		return prefix + "/selectCollection";
	}

	@RequiresPermissions("system:user:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyCollection hyCollection) {
		startPage();
		hyCollection.setIsRefund("1");
		List<HyCollection> list = hyCollectionService.selectHyCollectionList(hyCollection);
		return getDataTable(list);
	}
}
