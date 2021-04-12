package com.ruoyi.system.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ruoyi.common.utils.file.FileUtils;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ExportPDFService {

	public void exportPDF(HttpServletResponse response) throws Exception{
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
	}
	private Connection getCon() throws Exception{
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.103:3306/hy_database?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8","root","root");
	    return connection;
	}
}
