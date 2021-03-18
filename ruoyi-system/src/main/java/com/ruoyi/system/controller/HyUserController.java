package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyUser;
import com.ruoyi.system.service.IHyUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author Administrator
 * @date 2021-03-09
 */
@Controller
@RequestMapping("/system/hyUser")
@Api(tags = "用户Controller")
public class HyUserController extends BaseController
{
    private String prefix = "system/hyUser";

    @Autowired
    private IHyUserService hyUserService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/hyUser";
    }

    /**
     * 查询用户列表
     */
    @ApiOperation("用户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyUser", value = "项目实体类hyUser", required = true),
	})
    @RequiresPermissions("system:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyUser hyUser)
    {
        startPage();
        List<HyUser> list = hyUserService.selectHyUserList(hyUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @ApiOperation("用户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyUser", value = "项目实体类hyUser", required = true),
	})
    @RequiresPermissions("system:user:export")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyUser hyUser)
    {
        List<HyUser> list = hyUserService.selectHyUserList(hyUser);
        ExcelUtil<HyUser> util = new ExcelUtil<HyUser>(HyUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @ApiOperation("用户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyUser", value = "项目实体类hyUser", required = true),
	})
    @RequiresPermissions("system:user:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyUser hyUser)
    {
        return toAjax(hyUserService.insertHyUser(hyUser));
    }

    /**
     * 修改用户
     */
    @ApiOperation("用户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyUser hyUser = hyUserService.selectHyUserById(id);
        mmap.put("hyUser", hyUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @ApiOperation("用户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyUser", value = "项目实体类hyUser", required = true),
	})
    @RequiresPermissions("system:user:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyUser hyUser)
    {
        return toAjax(hyUserService.updateHyUser(hyUser));
    }

    /**
     * 删除用户
     */
    @ApiOperation("用户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:user:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyUserService.deleteHyUserByIds(ids));
    }
}
