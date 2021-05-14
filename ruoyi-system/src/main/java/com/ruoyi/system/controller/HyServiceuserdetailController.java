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
import com.ruoyi.system.domain.HyServiceregistration;
import com.ruoyi.system.service.IHyServiceregistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备维修登记Controller
 * 
 * @author Administrator
 * @date 2021-05-13
 */
@Controller
@RequestMapping("/system/serviceuserdetail")
@Api(tags = "设备维修登记Controller")
public class HyServiceuserdetailController extends BaseController
{
    private String prefix = "system/serviceuserdetail";

    @Autowired
    private IHyServiceregistrationService hyServiceregistrationService;

    @RequiresPermissions("system:serviceregistration:view")
    @GetMapping()
    public String serviceregistration()
    {
        return prefix + "/serviceuserdetail";
    }

}
