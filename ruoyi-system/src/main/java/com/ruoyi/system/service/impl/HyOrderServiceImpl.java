package com.ruoyi.system.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.HyOrder;
import com.ruoyi.system.mapper.HyOrderMapper;
import com.ruoyi.system.service.IHyOrderService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * 订单Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-15
 */
@Service
public class HyOrderServiceImpl implements IHyOrderService 
{
    @Autowired
    private HyOrderMapper hyOrderMapper;

    /**
     * 查询订单
     * 
     * @param id 订单ID
     * @return 订单
     */
    @Override
    public HyOrder selectHyOrderById(Long id)
    {
        return hyOrderMapper.selectHyOrderById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param hyOrder 订单
     * @return 订单
     */
    @Override
    public List<HyOrder> selectHyOrderList(HyOrder hyOrder)
    {
        return hyOrderMapper.selectHyOrderList(hyOrder);
    }
    
    /**
     * 查询订单待付款列表
     * 
     * @param hyOrder 订单
     * @return 订单
     */
    @Override
    public List<HyOrder> selectHyOrderListByObligation(HyOrder hyOrder)
    {
    	return hyOrderMapper.selectHyOrderListByObligation(hyOrder);
    }
    
    /**
     * 查询订单待发货列表
     * 
     * @param hyOrder 订单
     * @return 订单
     */
    @Override
    public List<HyOrder> selectHyOrderListBySend(HyOrder hyOrder)
    {
    	return hyOrderMapper.selectHyOrderListBySend(hyOrder);
    }
    
    /**
     * 查询订单待收货列表
     * 
     * @param hyOrder 订单
     * @return 订单
     */
    @Override
    public List<HyOrder> selectHyOrderListByCollect(HyOrder hyOrder)
    {
    	return hyOrderMapper.selectHyOrderListByCollect(hyOrder);
    }
    
    /**
     * 查询订单已完成列表
     * 
     * @param hyOrder 订单
     * @return 订单
     */
    @Override
    public List<HyOrder> selectHyOrderListByFinished(HyOrder hyOrder)
    {
    	return hyOrderMapper.selectHyOrderListByFinished(hyOrder);
    }
    
    /**
     * 查询订单已完成列表
     * 
     * @param hyOrder 订单
     * @return 订单
     */
    @Override
    public List<HyOrder> selectHyOrderListByRefunded(HyOrder hyOrder)
    {
    	return hyOrderMapper.selectHyOrderListByRefunded(hyOrder);
    }

    /**
     * 新增订单
     * 
     * @param hyOrder 订单
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyOrder(HyOrder hyOrder)
    {
        hyOrder.setCreateTime(DateUtils.getNowDate());
        return hyOrderMapper.insertHyOrder(hyOrder);
    }

    /**
     * 修改订单
     * 
     * @param hyOrder 订单
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyOrder(HyOrder hyOrder)
    {
        return hyOrderMapper.updateHyOrder(hyOrder);
    }

    /**
     * 删除订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyOrderByIds(String ids)
    {
        return hyOrderMapper.deleteHyOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyOrderById(Long id)
    {
        return hyOrderMapper.deleteHyOrderById(id);
    }
	/**
	 * 导出PDF
	 */
	@Override
	public int downloadPDF(HttpServletResponse response) throws Exception{
		//1、获取模版文件
	    File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
	    File templateFile = new File(rootFile,"/pdf_template/order_db.jasper");
	    //2、准备数据库连接
	    Map params = new HashMap();
	    JasperPrint jasperPrint =JasperFillManager.fillReport(new FileInputStream(templateFile),params,getCon());
	   /* ServletOutputStream outputStream = response.getOutputStream();
	    String filename="订单报表.pdf";
	    response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
	    response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes(),"ISO8859-1"));
	    JasperExportManager.exportReportToPdfStream(jasperPrint,outputStream);*/
	    JasperExportManager.exportReportToPdfStream(jasperPrint,new FileOutputStream("d:\\订单报表.pdf"));
	    return 1;
	}
	private Connection getCon() throws Exception{
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://39.105.185.22:3306/hy_database?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8","root","hangyu123.root");
	    return connection;
	}

}
