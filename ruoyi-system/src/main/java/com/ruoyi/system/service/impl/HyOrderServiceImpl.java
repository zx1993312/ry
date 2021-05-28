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

import com.ruoyi.system.mapper.HyOrderMapper;
import com.ruoyi.system.domain.HyOrder;
import com.ruoyi.system.service.IHyOrderService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import com.ruoyi.common.core.text.Convert;

/**
 * 订单Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-15
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
    
    public HyOrder selectId(HyOrder hyOrder) {
    	return hyOrderMapper.selectId(hyOrder);
    }
    
    /**
     * 查询订单列表（测试方法）
     * 
     * @param hyOrder 订单
     * @return 订单
     */
    @Override
	public List<HyOrder> selectHyOrderListTest(HyOrder hyOrder) {
		return hyOrderMapper.selectHyOrderListTest(hyOrder);
	}
    /**
     * 查询订单装态
     */
    public List<HyOrder> selectHyOrderState(HyOrder hyOrder){
    	return hyOrderMapper.selectHyOrderState(hyOrder);
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
    public int updateHyOrder(String ids,HyOrder hyOrder)
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
    	String ida [] = ids.split(",");
    	for(String id:ida) {
    		Long idd = Long.valueOf(id);
    		HyOrder hyOrder = hyOrderMapper.selectHyOrderById(idd);
    		String fileName = hyOrder.getUserPicture();
    		deleteFile(fileName);
    	}
    	
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
     * 删除上传图片
     * @return
     */
	@Override
	public boolean deleteFile(String fileName) {
		String fileName1 = "C:\\Users\\Administrator\\Desktop\\hykj\\ry\\ruoyi-admin\\src\\main\\resources\\static\\img\\"+fileName;
		File file = new File(fileName1);
		System.out.println("================file================"+file);
		//判断文件存不存在
		if(!file.exists()){
			System.out.println("删除文件失败："+fileName+"不存在！");
			return false;
		}else{
			//判断这是不是一个文件，ps：有可能是文件夹
			if(file.isFile()){
				return file.delete();
			}
		}
		return false;
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
