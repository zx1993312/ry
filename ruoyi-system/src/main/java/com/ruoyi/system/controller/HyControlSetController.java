package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.constants.Constants;
import com.ruoyi.system.domain.HyControlSet;
import com.ruoyi.system.service.IHyControlSetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 管控模型设置Controller
 * 
 * @author Administrator
 * @date 2021-01-07
 */
@Controller
@RequestMapping("/system/control")
@Api(tags = "管控模型设置Controller")
public class HyControlSetController extends BaseController {
	private String prefix = "system/control";

	@Autowired
	private IHyControlSetService hyControlSetService;

	@RequiresPermissions("system:control:view")
	@GetMapping()
	public String set() {
		return prefix + "/control";
	}

	/**
	 * 查询管控模型设置列表
	 */
	@ApiOperation("管控模型设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyControlSet", value = "项目实体类hyControlSet", required = true), })
	@RequiresPermissions("system:control:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(HyControlSet hyControlSet) {
		startPage();
		List<HyControlSet> list = hyControlSetService.selectHyControlSetList(hyControlSet);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyControlSet hcs : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hcs);
			reList.add(map);
		}
		return getDataTable(list,  reList);
	}

	/**
	 * 导出管控模型设置列表
	 */
	@ApiOperation("管控模型设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyControlSet", value = "项目实体类hyControlSet", required = true), })
	@RequiresPermissions("system:control:export")
	@Log(title = "管控模型设置", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(HyControlSet hyControlSet) {
		List<HyControlSet> list = hyControlSetService.selectHyControlSetList(hyControlSet);
		ExcelUtil<HyControlSet> util = new ExcelUtil<HyControlSet>(HyControlSet.class);
		return util.exportExcel(list, "control");
	}

	/**
	 * 新增管控模型设置
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存管控模型设置
	 */
	@ApiOperation("管控模型设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyControlSet", value = "项目实体类hyControlSet", required = true), })
	@RequiresPermissions("system:control:add")
	@Log(title = "管控模型设置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(HyControlSet hyControlSet) {
		return toAjax(hyControlSetService.insertHyControlSet(hyControlSet));
	}

	/**
	 * 修改管控模型设置
	 */
	@ApiOperation("管控模型设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "主键id", required = true), })
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		HyControlSet hyControlSet = hyControlSetService.selectHyControlSetById(id);
		mmap.put("hyControlSet", hyControlSet);
		List<HyControlSet> list = hyControlSetService.selectHyControlSetList(hyControlSet);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyControlSet hcs : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hcs);
			reList.add(map);
		}

		return prefix + "/edit";
	}

	/**
	 * 修改保存管控模型设置
	 */
	@ApiOperation("管控模型设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "hyControlSet", value = "项目实体类hyControlSet", required = true), })
	@RequiresPermissions("system:control:edit")
	@Log(title = "管控模型设置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(HyControlSet hyControlSet) {
		List<HyControlSet> list = hyControlSetService.selectHyControlSetList(hyControlSet);
		List<Map<String, Object>> reList = new ArrayList<>();
		for (HyControlSet hcs : list) {
			Map<String, Object> map = new HashMap<>();
			map = Constants.REFLECT_UTIL.convertMap(hcs);
			reList.add(map);
		}
		return toAjax(hyControlSetService.updateHyControlSet(hyControlSet));
	}

	/**
	 * 删除管控模型设置
	 */
	@ApiOperation("管控模型设置")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "ids", required = true), })
	@RequiresPermissions("system:control:remove")
	@Log(title = "管控模型设置", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(hyControlSetService.deleteHyControlSetByIds(ids));
	}
	/**
	 * 导入房屋数据
	 * @param file
	 * @param updateSupport
	 * @return
	 * @throws Exception
	 */
	@Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:registration:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<HyControlSet> util = new ExcelUtil<HyControlSet>(HyControlSet.class);
        List<HyControlSet> userList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = hyControlSetService.importOwnerRegistration(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }
	@RequiresPermissions("system:set:view")
	 @GetMapping("/importTemplate")
	 @ResponseBody
	 public AjaxResult importTemplate() {
	  ExcelUtil<HyControlSet> util = new ExcelUtil<HyControlSet>(HyControlSet.class);
	  return util.importTemplateExcel("管控模型设置");
	 }
}
