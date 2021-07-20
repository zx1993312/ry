package com.ruoyi.system.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HyDeatilPicture;
import com.ruoyi.system.domain.HyProduct;
import com.ruoyi.system.service.IHyDeatilPictureService;
import com.ruoyi.system.service.IHyProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 商品Controller
 * 
 * @author Administrator
 * @date 2021-03-06
 */
@Controller
@CrossOrigin
@RequestMapping("/system/product")
@Api(tags = "商品Controller")
public class HyProductController extends BaseController
{
    private String prefix = "system/product";

    @Autowired
    private IHyProductService hyProductService;
    
    @Autowired
    private IHyDeatilPictureService hyDeatilPictureService;

    @RequiresPermissions("system:product:view")
    @GetMapping()
    public String product()
    {
        return prefix + "/product";
    }

    /**
     * 查询商品列表
     */
    @ApiOperation("商品")
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
        return getDataTable(list);
    }
    
    /**
     * 查询商品列表App
     */
    @ApiOperation("商品")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
    })
    @RequiresPermissions("system:product:list")
    @PostMapping("/listApp")
    @ResponseBody
    public List<HyProduct> listApp(HyProduct hyProduct)
    {
    	List<HyProduct> list = hyProductService.selectHyProductList(hyProduct);
    	return list;
    }
    


    /**
     * 导出商品列表
     */
    @ApiOperation("商品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
	})
    @RequiresPermissions("system:product:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HyProduct hyProduct)
    {
        List<HyProduct> list = hyProductService.selectHyProductList(hyProduct);
        ExcelUtil<HyProduct> util = new ExcelUtil<HyProduct>(HyProduct.class);
        return util.exportExcel(list, "product");
    }

    /**
     * 新增商品
     */
    @GetMapping("/add")
    public String add ()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品
     */
    @ApiOperation("商品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
	})
    @RequiresPermissions("system:product:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HyProduct hyProduct)
    {
        return toAjax(hyProductService.insertHyProduct(hyProduct));
    }

    /**
     * 修改商品
     */
    @ApiOperation("商品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "主键id", required = true),
	})
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HyProduct hyProduct = hyProductService.selectHyProductById(id);
        HyDeatilPicture hyDeatilPicture = new HyDeatilPicture();
        hyDeatilPicture.setProductId(id);
        List<HyDeatilPicture> list  = hyDeatilPictureService.selectHyDeatilPictureList(hyDeatilPicture);
        mmap.put("hyProduct", hyProduct);
        mmap.put("list", list);
        return prefix + "/edit";
    }
    
    /**
     * 修改商品App
     */
    @ApiOperation("商品")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/editApp")
    @ResponseBody
    public List<Map<String, Object>> editApp(HyProduct hyProduct)
    {
    	List<Map<String, Object>> productList = new ArrayList<Map<String, Object>>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	hyProduct = hyProductService.selectHyProductList(hyProduct).get(0);
    	HyDeatilPicture hyDeatilPicture = new HyDeatilPicture();
    	hyDeatilPicture.setProductId(hyProduct.getId());
    	List<HyDeatilPicture> deatilPictureList  = hyDeatilPictureService.selectHyDeatilPictureList(hyDeatilPicture);
    	map.put("hyProduct", hyProduct);
    	map.put("deatilPictureList", deatilPictureList);
    	productList.add(map);
    	return productList;
    }
    
    /**
     * 统计App
     */
    @ApiOperation("商品")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/statistics")
    @ResponseBody
    public List<Map<String, Object>> statistics()
    {
    	List<Map<String, Object>> productList = new ArrayList<Map<String, Object>>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	List<HyProduct> list = hyProductService.selectHyProductList(new HyProduct());
    	BigDecimal currentPriceCount = new BigDecimal(0.00);
    	Long soldNumberCount = Long.valueOf(0);
    	for(HyProduct product : list) {
    		Long soldNumber = product.getSoldNumber();
    		BigDecimal currentPrice = product.getCurrentPrice();
    		currentPriceCount = currentPriceCount.add(currentPrice.multiply(new BigDecimal(soldNumber)));
    		soldNumberCount = soldNumberCount+soldNumber;
    	}
    	map.put("currentPriceCount", currentPriceCount);
    	map.put("soldNumberCount", soldNumberCount);
    	productList.add(map);
    	return productList;
    }

    /**
     * 修改保存商品
     */
    @ApiOperation("商品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
	})
    @RequiresPermissions("system:product:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HyProduct hyProduct)
    {
    	if(hyProduct.getHyPicture().getPictureAddress()!=null&&!"".equals(hyProduct.getHyPicture().getPictureAddress())) {
    		String fileName = hyProduct.getFileName();
        	hyProductService.deleteFile(fileName);
    	}
    	
    	return toAjax(hyProductService.updateHyProduct(hyProduct));
    }
    
    /**
     * 支付修改商品已售库存数量
     */
    @ApiOperation("商品")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
    })
    @RequiresPermissions("system:product:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/editAppByPay")
    @ResponseBody
    public AjaxResult editAppByPay(HyProduct hyProduct)
    {
    	String[] ids = hyProduct.getIds().split(",");
    	String[] numbers = hyProduct.getNumbers().split(",");
    	for(int i=0;i<ids.length;i++) {
    		String id = ids[i];
    		hyProduct.setId(Long.valueOf(id));
    		String number = numbers[i];
    		HyProduct product = hyProductService.selectHyProductById(Long.valueOf(id));
    		Long soldNumber = product.getSoldNumber();
    		Long stockNumber = product.getStockNumber();
    		soldNumber = soldNumber + Long.valueOf(number);
    		stockNumber = stockNumber - Long.valueOf(number);
    		hyProduct.setSoldNumber(soldNumber);
    		hyProduct.setStockNumber(stockNumber);
    		hyProductService.updateHyProduct(hyProduct);
		}
    	return toAjax(1);
    }
    
    /**
     * 退款修改商品已售库存数量
     */
    @ApiOperation("商品")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyProduct", value = "项目实体类hyProduct", required = true),
    })
    @RequiresPermissions("system:product:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/editAppByRefund")
    @ResponseBody
    public AjaxResult editAppByRefund(HyProduct hyProduct)
    {
    	String[] ids = hyProduct.getIds().split(",");
    	String[] numbers = hyProduct.getNumbers().split(",");
    	for(int i=0;i<ids.length;i++) {
    		String id = ids[i];
    		hyProduct.setId(Long.valueOf(id));
    		String number = numbers[i];
    		HyProduct product = hyProductService.selectHyProductById(Long.valueOf(id));
    		Long soldNumber = product.getSoldNumber();
    		Long stockNumber = product.getStockNumber();
    		soldNumber = soldNumber - Long.valueOf(number);
    		stockNumber = stockNumber + Long.valueOf(number);
    		hyProduct.setSoldNumber(soldNumber);
    		hyProduct.setStockNumber(stockNumber);
    		hyProductService.updateHyProduct(hyProduct);
    	}
    	return toAjax(1);
    }

    /**
     * 删除商品
     */
    @ApiOperation("商品")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "ids", value = "ids", required = true),
	})
    @RequiresPermissions("system:product:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hyProductService.deleteHyProductByIds(ids));
    }
    /**
     * 商品信息缩略图
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
	/**
	 * 上传商品多图
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
