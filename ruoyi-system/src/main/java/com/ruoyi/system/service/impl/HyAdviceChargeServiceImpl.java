package com.ruoyi.system.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ruoyi.system.domain.HyHouseInf;
import com.ruoyi.system.mapper.HyAdviceChargeMapper;
import com.ruoyi.system.service.IHyAdviceChargeService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
/**
 * 缴费通知Service业务层处理
 * 
 * @author 
 * @date 2021-03-19
 */
@Service
public class HyAdviceChargeServiceImpl implements IHyAdviceChargeService {
	@Autowired
	private HyAdviceChargeMapper hyAdviceChargeMapper;

	/**
	 * 查询缴费通知列表
	 * 
	 * @param hyHouseInf 缴费通知
	 * @return 缴费通知
	 */
	@Override
	public List<HyHouseInf> selectHyAdviceChargeList(HyHouseInf hyHouseInf) {
		return hyAdviceChargeMapper.selectHyAdviceChargeList(hyHouseInf);
	}
	/**
	 * 导出PDF
	 */
	@Override
	public int downloadPDF(String warm,HttpServletResponse response) throws Exception{
		//1、获取模版文件
	    File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
	    File templateFile = new File(rootFile,"/pdf_template/advicecharge_db.jasper");
	    //2、准备数据库连接
	    Map params = new HashMap();
	    params.put("warm", warm);
	    JasperPrint jasperPrint =JasperFillManager.fillReport(new FileInputStream(templateFile),params,getCon());
	    /*ServletOutputStream outputStream = response.getOutputStream();
	    String filename="缴费通知单.pdf";
	    //response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
	    response.setContentType("application/pdf");
	    response.setHeader("content-disposition", "attachment;filename="+new String(filename.getBytes(),"ISO8859-1"));
	    JasperExportManager.exportReportToPdfStream(jasperPrint,outputStream);*/
	    JasperExportManager.exportReportToPdfStream(jasperPrint,new FileOutputStream("d:\\缴费通知单.pdf"));
	    return 1;
	}
	private Connection getCon() throws Exception{
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://39.105.185.22:3306/hy_database?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8","root","hangyu123.root");
	    return connection;
	}
}
