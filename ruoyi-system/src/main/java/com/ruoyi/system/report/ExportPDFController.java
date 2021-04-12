package com.ruoyi.system.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.common.core.controller.BaseController;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
@Controller
@RequestMapping("/system/exportPDF")
public class ExportPDFController extends BaseController {
	
	@PostMapping("/ePDF")
	public void exportPDF(String outFileName,HttpServletResponse response) throws Exception {
		//1、获取模版文件
	    File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
	    File templateFile = new File(rootFile,"/pdf_template/hy_order.jasper");
	    //2、准备数据库连接
	    Map params = new HashMap();
	    JasperPrint jasperPrint =JasperFillManager.fillReport(new FileInputStream(templateFile),params,getCon());
	    /*ServletOutputStream outputStream = response.getOutputStream();
	    String filename="订单列表数据.pdf";
	    response.setContentType("application/pdf");
	    response.setHeader("content-disposition", "attachment;filename="+new String(filename.getBytes(),"iso8859-1"));*/
	    //JasperExportManager.exportReportToPdfStream(jasperPrint,new FileOutputStream("d:\\pdfWorkSpace\\订单表.pdf"));
	    JasperExportManager.exportReportToPdfStream(jasperPrint,new FileOutputStream("d:\\pdfWorkSpace\\订单表.pdf"));
	}
	
	private Connection getCon() throws Exception{
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.103:3306/hy_database?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8","root","root");
	    return connection;
	}
}
