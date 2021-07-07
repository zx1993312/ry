package com.ruoyi.system.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HySupplier;
import com.ruoyi.system.service.IHySupplierService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商Controller
 * 
 * @author Administrator
 * @date 2021-06-11
 */
@Controller
@CrossOrigin
@RequestMapping("/system/supplier")
@Api(tags = "供应商Controller")
public class HySupplierController extends BaseController
{
    private String prefix = "system/supplier";

    @Autowired
    private IHySupplierService hySupplierService;

    @RequiresPermissions("system:supplier:view")
    @GetMapping()
    public String supplier()
    {
        return prefix + "/supplier";
    }

    /**
     * 查询供应商列表
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySupplier", value = "项目实体类hySupplier", required = true),
	})
    @RequiresPermissions("system:supplier:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HySupplier hySupplier)
    {
        startPage();
        List<HySupplier> list = hySupplierService.selectHySupplierList(hySupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商列表
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySupplier", value = "项目实体类hySupplier", required = true),
	})
    @RequiresPermissions("system:supplier:export")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HySupplier hySupplier)
    {
        List<HySupplier> list = hySupplierService.selectHySupplierList(hySupplier);
        ExcelUtil<HySupplier> util = new ExcelUtil<HySupplier>(HySupplier.class);
        return util.exportExcel(list, "supplier");
    }

    /**
     * 新增供应商
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存供应商
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySupplier", value = "项目实体类hySupplier", required = true),
	})
    @RequiresPermissions("system:supplier:add")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HySupplier hySupplier)
    {
        return toAjax(hySupplierService.insertHySupplier(hySupplier));
    }

    /**
     * 修改供应商
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HySupplier hySupplier = hySupplierService.selectHySupplierById(id);
        mmap.put("hySupplier", hySupplier);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hySupplier", value = "项目实体类hySupplier", required = true),
	})
    @RequiresPermissions("system:supplier:edit")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HySupplier hySupplier)
    {
        return toAjax(hySupplierService.updateHySupplier(hySupplier));
    }

    /**
     * 删除供应商
     */
    @ApiOperation("供应商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:supplier:remove")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hySupplierService.deleteHySupplierByIds(ids));
    }
    
    /**
     * 产品信息缩略图
     * @param imagepath
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
	@RequestMapping("/uploadFile")
	@ResponseBody
	public Map<String, Object> uploadFile(MultipartFile imagepath) throws IllegalStateException, IOException {
		System.out.println(imagepath);
		String mynewpic = null;
		// 原始图片名称
		String oldFileName = imagepath.getOriginalFilename(); // 获取上传文件的原名
		// 存储路径
		if (imagepath != null && oldFileName != null && oldFileName.length() > 0) {
			// 我这写的是绝对路径请注意，springboot 用内置tomcat 展示图片会有问题 稍后在看
			String saveFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img";
			File files = new File(saveFilePath);
			if (!files.exists()) {
				files.mkdirs();
			}
			// 新的图片名称
			String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
			// 新图片
			File newFile = new File(saveFilePath + "\\" + newFileName);
			// 将内存中的数据写入磁盘
			imagepath.transferTo(newFile);
			// 将路径名存入全局变量mynewpic
			mynewpic = newFileName;

			// 将新图片名称返回到前端
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", "成功啦");
			map.put("url", mynewpic);
			return map;
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "图片不合法");
			return map;
		}
	}
}
