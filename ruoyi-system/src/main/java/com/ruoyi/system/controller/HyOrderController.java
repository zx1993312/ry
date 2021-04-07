package com.ruoyi.system.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.system.domain.HyOrder;
import com.ruoyi.system.service.IHyOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author Administrator
 * @date 2021-03-15
 */
@Controller
@RequestMapping("/system/order")
@Api(tags = "订单Controller")
public class HyOrderController extends BaseController
{
    private String prefix = "system/order";

    @Autowired
    private IHyOrderService hyOrderService;

    @RequiresPermissions("system:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询订单列表
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyOrder", value = "项目实体类hyOrder", required = true),
	})
    @RequiresPermissions("system:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HyOrder hyOrder)
    {
        startPage();
        List<HyOrder> list = hyOrderService.selectHyOrderList(hyOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyOrder", value = "项目实体类hyOrder", required = true),
	})
    @RequiresPermissions("system:order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyOrder hyOrder)
    {
        List<HyOrder> list = hyOrderService.selectHyOrderList(hyOrder);
        ExcelUtil<HyOrder> util = new ExcelUtil<HyOrder>(HyOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyOrder", value = "项目实体类hyOrder", required = true),
	})
    @RequiresPermissions("system:order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyOrder hyOrder)
    {
        return toAjax(hyOrderService.insertHyOrder(hyOrder));
    }

    /**
     * 修改订单
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyOrder hyOrder = hyOrderService.selectHyOrderById(id);
        mmap.put("hyOrder", hyOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyOrder", value = "项目实体类hyOrder", required = true),
	})
    @RequiresPermissions("system:order:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyOrder hyOrder)
    {	
    	if(hyOrder.getUserPicture()!=null&&!"".equals(hyOrder.getUserPicture())) {
    		String fileName = hyOrder.getFileName();
        	hyOrderService.deleteFile(fileName);
    	}
    	
    	return toAjax(hyOrderService.updateHyOrder(hyOrder));
    }

    /**
     * 删除订单
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:order:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyOrderService.deleteHyOrderByIds(ids));
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
	public Map<String, Object> uploadFile(MultipartFile imagepath,HttpServletRequest request) throws IllegalStateException, IOException {
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
	/**
	 * 导出PDF
	 */
	 @ApiOperation("订单")
	 @ApiImplicitParams({ 
	 @ApiImplicitParam(name = "hyOrder", value = "项目实体类hyOrder", required = true),
	 })
	 @Log(title = "订单", businessType = BusinessType.EXPORT)
	 @PostMapping("/downloadPDF")
	 @ResponseBody
	public void downloadPDF(HttpServletResponse response) throws Exception
	{
		 hyOrderService.downloadPDF(response);
	}
	
}
