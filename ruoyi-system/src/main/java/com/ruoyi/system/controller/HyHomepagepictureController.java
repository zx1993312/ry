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
import com.ruoyi.system.domain.HyHomepagepicture;
import com.ruoyi.system.service.IHyHomepagepictureService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 首页轮播图Controller
 * 
 * @author Administrator
 * @date 2021-07-21
 */
@Controller
@RequestMapping("/system/homepagepicture")
@Api(tags = "首页轮播图Controller")
public class HyHomepagepictureController extends BaseController
{
    private String prefix = "system/homepagepicture";

    @Autowired
    private IHyHomepagepictureService hyHomepagepictureService;

    @RequiresPermissions("system:homepagepicture:view")
    @GetMapping()
    public String homepagepicture()
    {
        return prefix + "/homepagepicture";
    }

    /**
     * 查询首页轮播图列表
     */
    @ApiOperation("首页轮播图")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyHomepagepicture", value = "项目实体类hyHomepagepicture", required = true),
	})
    @RequiresPermissions("system:homepagepicture:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyHomepagepicture hyHomepagepicture)
    {
        startPage();
        List<HyHomepagepicture> list = hyHomepagepictureService.selectHyHomepagepictureList(hyHomepagepicture);
        return getDataTable(list);
    }
    
    /**
     * 查询首页轮播图列表App
     */
    @ApiOperation("首页轮播图")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyHomepagepicture", value = "项目实体类hyHomepagepicture", required = true),
    })
    @RequiresPermissions("system:homepagepicture:list")
    @PostMapping("/listByState")
    @ResponseBody
    public List<HyHomepagepicture> listByState(HyHomepagepicture hyHomepagepicture)
    {
    	List<HyHomepagepicture> list = hyHomepagepictureService.selectHyHomepagepictureListByState(hyHomepagepicture);
    	return list;
    }

    /**
     * 导出首页轮播图列表
     */
    @ApiOperation("首页轮播图")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyHomepagepicture", value = "项目实体类hyHomepagepicture", required = true),
	})
    @RequiresPermissions("system:homepagepicture:export")
    @Log(title = "首页轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyHomepagepicture hyHomepagepicture)
    {
        List<HyHomepagepicture> list = hyHomepagepictureService.selectHyHomepagepictureList(hyHomepagepicture);
        ExcelUtil<HyHomepagepicture> util = new ExcelUtil<HyHomepagepicture>(HyHomepagepicture.class);
        return util.exportExcel(list, "homepagepicture");
    }

    /**
     * 新增首页轮播图
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首页轮播图
     */
    @ApiOperation("首页轮播图")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyHomepagepicture", value = "项目实体类hyHomepagepicture", required = true),
	})
    @RequiresPermissions("system:homepagepicture:add")
    @Log(title = "首页轮播图", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyHomepagepicture hyHomepagepicture)
    {
        return toAjax(hyHomepagepictureService.insertHyHomepagepicture(hyHomepagepicture));
    }

    /**
     * 修改首页轮播图
     */
    @ApiOperation("首页轮播图")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyHomepagepicture hyHomepagepicture = hyHomepagepictureService.selectHyHomepagepictureById(id);
        mmap.put("hyHomepagepicture", hyHomepagepicture);
        return prefix + "/edit";
    }

    /**
     * 修改保存首页轮播图
     */
    @ApiOperation("首页轮播图")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyHomepagepicture", value = "项目实体类hyHomepagepicture", required = true),
	})
    @RequiresPermissions("system:homepagepicture:edit")
    @Log(title = "首页轮播图", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyHomepagepicture hyHomepagepicture)
    {
        return toAjax(hyHomepagepictureService.updateHyHomepagepicture(hyHomepagepicture));
    }

    /**
     * 删除首页轮播图
     */
    @ApiOperation("首页轮播图")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:homepagepicture:remove")
    @Log(title = "首页轮播图", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyHomepagepictureService.deleteHyHomepagepictureByIds(ids));
    }
    /**
     * 首页轮播图
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
