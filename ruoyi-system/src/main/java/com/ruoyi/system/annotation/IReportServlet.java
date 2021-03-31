package com.ruoyi.system.annotation;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

public class IReportServlet extends HttpServlet{

	 public static void main(String[] args) {
	        Map parameters=new HashMap();
	        ByteArrayOutputStream outPut=new ByteArrayOutputStream();
	        FileOutputStream outputStream=null;
	        File file=new File("C:/Users/Administrator/Desktop/repo.pdf");
	        String reportModelFile="C:/Users/Administrator/Desktop/repo.jasper";
	        
	        try {
	            JasperPrint jasperPrint=JasperFillManager.fillReport(reportModelFile,
	                    parameters,new ReportDataSource("男"));
	            JRAbstractExporter exporter=new JRPdfExporter();
	            //创建jasperPrint
	            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	            //生成输出流
	            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outPut);
	            //屏蔽copy功能
	            exporter.setParameter(JRPdfExporterParameter.IS_ENCRYPTED,Boolean.TRUE);
	            //加密
	            exporter.setParameter(JRPdfExporterParameter.IS_128_BIT_KEY,Boolean.TRUE);
	            exporter.exportReport();
	            outputStream=new FileOutputStream(file);
	            outputStream.write(outPut.toByteArray());
	        } catch (JRException e) {
	            e.printStackTrace();
	        }catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            try {
	                outPut.flush();
	                outPut.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }


}
