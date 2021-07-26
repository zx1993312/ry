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
import com.ruoyi.system.domain.HyCommunityIntroduction;
import com.ruoyi.system.domain.HyIntroductionpictures;
import com.ruoyi.system.service.IHyCommunityIntroductionService;
import com.ruoyi.system.service.IHyIntroductionpicturesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社区简介Controller
 * 
 * @author Administrator
 * @date 2021-03-12
 */
@Controller
@CrossOrigin
@RequestMapping("/system/introduction")
@Api(tags = "社区简介Controller")
public class HyCommunityIntroductionController extends BaseController
{
    private String prefix = "system/introduction";

    @Autowired
    private IHyCommunityIntroductionService hyCommunityIntroductionService;
    
    @Autowired
    private IHyIntroductionpicturesService hyIntroductionpicturesService;

    @RequiresPermissions("system:introduction:view")
    @GetMapping()
    public String introduction()
    {
        return prefix + "/introduction";
    }

    /**
     * 查询社区简介列表
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityIntroduction", value = "项目实体类hyCommunityIntroduction", required = true),
	})
    @RequiresPermissions("system:introduction:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyCommunityIntroduction hyCommunityIntroduction)
    {
        startPage();
        List<HyCommunityIntroduction> list = hyCommunityIntroductionService.selectHyCommunityIntroductionList(hyCommunityIntroduction);
        return getDataTable(list);
    }
    
    /**
     * 查询社区简介列表App
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyCommunityIntroduction", value = "项目实体类hyCommunityIntroduction", required = true),
    })
    @RequiresPermissions("system:introduction:list")
    @PostMapping("/listApp")
    @ResponseBody
    public List<HyCommunityIntroduction> listApp(HyCommunityIntroduction hyCommunityIntroduction)
    {
    	List<HyCommunityIntroduction> list = hyCommunityIntroductionService.selectHyCommunityIntroductionList(hyCommunityIntroduction);
    	return list;
    }

    /**
     * 导出社区简介列表
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityIntroduction", value = "项目实体类hyCommunityIntroduction", required = true),
	})
    @RequiresPermissions("system:introduction:export")
    @Log(title = "社区简介", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyCommunityIntroduction hyCommunityIntroduction)
    {
        List<HyCommunityIntroduction> list = hyCommunityIntroductionService.selectHyCommunityIntroductionList(hyCommunityIntroduction);
        ExcelUtil<HyCommunityIntroduction> util = new ExcelUtil<HyCommunityIntroduction>(HyCommunityIntroduction.class);
        return util.exportExcel(list, "introduction");
    }

    /**
     * 新增社区简介
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社区简介
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityIntroduction", value = "项目实体类hyCommunityIntroduction", required = true),
	})
    @RequiresPermissions("system:introduction:add")
    @Log(title = "社区简介", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyCommunityIntroduction hyCommunityIntroduction)
    {
        return toAjax(hyCommunityIntroductionService.insertHyCommunityIntroduction(hyCommunityIntroduction));
        
    }

    /**
     * 修改社区简介
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyCommunityIntroduction hyCommunityIntroduction = hyCommunityIntroductionService.selectHyCommunityIntroductionById(id);
        HyIntroductionpictures hyIntroductionpictures = new HyIntroductionpictures();
        hyIntroductionpictures.setIntroductionId(id);
        List<HyIntroductionpictures> list = hyIntroductionpicturesService.selectHyIntroductionpicturesList(hyIntroductionpictures);
        mmap.put("list", list);
        mmap.put("hyCommunityIntroduction", hyCommunityIntroduction);
        return prefix + "/edit";
    }
    
    /**
     * 社区简介详情App
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/editApp")
    @ResponseBody
    public List<HyCommunityIntroduction> editApp(HyCommunityIntroduction hyCommunityIntroduction)
    {
    	List<HyCommunityIntroduction> list = hyCommunityIntroductionService.selectHyCommunityIntroductionList(hyCommunityIntroduction);
    	return list;
    }

    /**
     * 修改保存社区简介
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyCommunityIntroduction", value = "项目实体类hyCommunityIntroduction", required = true),
	})
    @RequiresPermissions("system:introduction:edit")
    @Log(title = "社区简介", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyCommunityIntroduction hyCommunityIntroduction)
    {
        return toAjax(hyCommunityIntroductionService.updateHyCommunityIntroduction(hyCommunityIntroduction));
    }

    /**
     * 删除社区简介
     */
    @ApiOperation("社区简介")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:introduction:remove")
    @Log(title = "社区简介", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyCommunityIntroductionService.deleteHyCommunityIntroductionByIds(ids));
    }
    
    /**
	 * 上传物业简介多图
	 * @param imagepath
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/uploadFile2")
	@ResponseBody
	public Map<String, Object> uploadFile2(MultipartFile imagepaths) throws IllegalStateException, IOException {
		System.out.println(imagepaths);
		String mynewpic = null;
		// 原始图片名称
		String oldFileName = imagepaths.getOriginalFilename(); // 获取上传文件的原名
		// 存储路径
		if (imagepaths != null && oldFileName != null && oldFileName.length() > 0) {
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
			imagepaths.transferTo(newFile);
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
