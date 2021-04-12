package com.ruoyi.system.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.ResourceUtils;

import com.ruoyi.system.report.ireport.GenPDF;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Test {
	
	public static void main(String[] args) throws Exception{
		/*GenPDF genPDF = new GenPDF();
		genPDF.genPDF("C000101");*/
		File rootFile = new File(ResourceUtils.getURL("classpath:").getPath());
	    File filePath = new File(rootFile,"/pdf_template/test01.jasper");
		FileInputStream inputStream = new FileInputStream(filePath);
		Map params = new HashMap();
		
		params.put("NameP", "张三");
		params.put("PhoneP", "15800000000");
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params,new JREmptyDataSource());
		JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream("d:\\pdfWorkSpace\\test01.pdf"));
		
		
	}
	
}
