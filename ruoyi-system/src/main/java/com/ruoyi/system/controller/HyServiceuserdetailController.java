package com.ruoyi.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.common.core.controller.BaseController;

import io.swagger.annotations.Api;

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

//    @Autowired
//    private IHyServiceregistrationService hyServiceregistrationService;

    @RequiresPermissions("system:serviceregistration:view")
    @GetMapping()
    public String serviceregistration()
    {
        return prefix + "/serviceuserdetail";
    }

}
