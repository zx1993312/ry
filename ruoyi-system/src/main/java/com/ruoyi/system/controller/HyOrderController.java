package com.ruoyi.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HyOrder;
import com.ruoyi.system.domain.OrderAndProduct;
import com.ruoyi.system.mapper.OrderAndProductMapper;
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
 * @date 2021-07-15
 */
@Controller
@CrossOrigin
@RequestMapping("/system/order")
@Api(tags = "订单Controller")
public class HyOrderController extends BaseController
{
    private String prefix = "system/order";

    @Autowired
    private IHyOrderService hyOrderService;
    
    @Autowired
    private OrderAndProductMapper orderAndProductMapper;

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
     * 查询订单待付款列表App
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyOrder", value = "项目实体类hyOrder", required = true),
    })
    @RequiresPermissions("system:order:list")
    @PostMapping("/listByObligation")
    @ResponseBody
    public List<HyOrder> listByObligation(HyOrder hyOrder)
    {
    	List<HyOrder> list = hyOrderService.selectHyOrderListByObligation(hyOrder);
    	return list;
    }
    
    /**
     * 查询订单待发货列表App
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyOrder", value = "项目实体类hyOrder", required = true),
    })
    @RequiresPermissions("system:order:list")
    @PostMapping("/listBySend")
    @ResponseBody
    public List<HyOrder> listBySend(HyOrder hyOrder)
    {
    	List<HyOrder> list = hyOrderService.selectHyOrderListBySend(hyOrder);
    	return list;
    }
    
    /**
     * 查询订单待收货列表App
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyOrder", value = "项目实体类hyOrder", required = true),
    })
    @RequiresPermissions("system:order:list")
    @PostMapping("/listByCollect")
    @ResponseBody
    public List<HyOrder> listByCollect(HyOrder hyOrder)
    {
    	List<HyOrder> list = hyOrderService.selectHyOrderListByCollect(hyOrder);
    	return list;
    }
    
    /**
     * 查询订单已完成列表App
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyOrder", value = "项目实体类hyOrder", required = true),
    })
    @RequiresPermissions("system:order:list")
    @PostMapping("/listByFinished")
    @ResponseBody
    public List<HyOrder> listByFinished(HyOrder hyOrder)
    {
    	List<HyOrder> list = hyOrderService.selectHyOrderListByFinished(hyOrder);
    	return list;
    }
    
    /**
     * 查询订单已退款列表App
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyOrder", value = "项目实体类hyOrder", required = true),
    })
    @RequiresPermissions("system:order:list")
    @PostMapping("/listByRefunded")
    @ResponseBody
    public List<HyOrder> listByRefunded(HyOrder hyOrder)
    {
    	List<HyOrder> list = hyOrderService.selectHyOrderListByRefunded(hyOrder);
    	return list;
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
     * 购物车结算生成订单
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "hyOrder", value = "项目实体类hyOrder", required = true),
    })
    @RequiresPermissions("system:order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping("/addApp")
    @ResponseBody
    public AjaxResult addApp(HyOrder hyOrder)
    {
    	int row = hyOrderService.insertHyOrder(hyOrder);
    	if(row>0) {
    		String[] productIds = hyOrder.getProductIds().split(",");
    		List<HyOrder> list = hyOrderService.selectHyOrderList(hyOrder);
    		hyOrder = list.get(0);
    		Long orderId = hyOrder.getId();
    		String[] numbers = hyOrder.getNumbers().split(",");
    		for(int i=0;i<productIds.length;i++) {
    			OrderAndProduct orderAndProduct = new OrderAndProduct();
    			String number = numbers[i];
    			String productId = productIds[i];
    			orderAndProduct.setOrderId(orderId);
    			orderAndProduct.setProductId(Long.valueOf(productId));
    			orderAndProduct.setNumber(Integer.valueOf(number));
    			orderAndProductMapper.insertOrderAndProduct(orderAndProduct);
    		}
    		return toAjax(1);
    	}
    	return toAjax(0);
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
     * 查看订单
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
    	HyOrder hyOrder = hyOrderService.selectHyOrderById(id);
    	mmap.put("hyOrder", hyOrder);
    	return prefix + "/detail";
    }
    
    /**
     * 查看订单App
     */
    @ApiOperation("订单")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "主键id", required = true),
    })
    @GetMapping("/detailApp")
    @ResponseBody
    public List<HyOrder> detailApp(HyOrder hyOrder)
    {
    	List<HyOrder> list = hyOrderService.selectHyOrderList(hyOrder);
    	return list;
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
	 * 导出PDF
	 */
	 @PostMapping("/exportPDF")
	 @ResponseBody
	public AjaxResult downloadPDF(HttpServletResponse response) throws Exception
	{
		 return toAjax(hyOrderService.downloadPDF(response));
	}
	
}
