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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyPicture;
import com.ruoyi.system.domain.HyProduct;
import com.ruoyi.system.service.IHyProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品Controller
 * 
 * @author Administrator
 * @date 2021-03-06
 */
@Controller
@RequestMapping("/system/product")
@Api(tags = "产品Controller")
public class HyProductController extends BaseController
{
    private String prefix = "system/product";

    @Autowired
    private IHyProductService hyProductService;

    @RequiresPermissions("system:product:view")
    @GetMapping()
    public String product()
    {
        return prefix + "/product";
    }

    /**
     * 查询产品列表
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
	})
    @RequiresPermissions("system:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyProduct hyProduct)
    {
        startPage();
        List<HyProduct> list = hyProductService.selectHyProductList(hyProduct);
        System.out.println("===================list=================="+list);
        return getDataTable(list);
    }

    /**
     * 导出产品列表
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
	})
    @RequiresPermissions("system:product:export")
    @Log(title = "产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyProduct hyProduct)
    {
        List<HyProduct> list = hyProductService.selectHyProductList(hyProduct);
        ExcelUtil<HyProduct> util = new ExcelUtil<HyProduct>(HyProduct.class);
        return util.exportExcel(list, "product");
    }

    /**
     * 新增产品
     */
    @GetMapping("/add")
    public String add ()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
	})
    @RequiresPermissions("system:product:add")
    @Log(title = "产品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyProduct hyProduct)
    {
    	System.out.println("===================hyProduct==================="+hyProduct);
        return toAjax(hyProductService.insertHyProduct(hyProduct));
    }

    /**
     * 修改产品
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyProduct hyProduct = hyProductService.selectHyProductById(id);
        System.out.println("==============hyProduct============"+hyProduct);
        mmap.put("hyProduct", hyProduct);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
	})
    @RequiresPermissions("system:product:edit")
    @Log(title = "产品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyProduct hyProduct)
    {
    	String fileName = hyProduct.getFileName();
    	boolean b = hyProductService.deleteFile(fileName);
    	if(b) {
    		return toAjax(hyProductService.updateHyProduct(hyProduct));
    	}
        return toAjax(false);
    }

    /**
     * 删除产品
     */
    @ApiOperation("产品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:product:remove")
    @Log(title = "产品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyProductService.deleteHyProductByIds(ids));
    }
    /**
     * 上传图片地址
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
			String saveFilePath = "C:\\Users\\Administrator\\Desktop\\hykj\\ry\\ruoyi-admin\\src\\main\\resources\\static\\img";
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
