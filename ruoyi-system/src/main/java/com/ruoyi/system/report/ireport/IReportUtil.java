package com.ruoyi.system.report.ireport;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Map;

import com.ruoyi.system.annotation.ReportDataSource;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

public class IReportUtil {
	

	public static void exportPdfFileServer(String ireportTemplate, String outFileName, Map<String, Object> parameters,
			Connection connection) {
		 ByteArrayOutputStream outPut=new ByteArrayOutputStream();
		 FileOutputStream outputStream=null;
        try {
            JasperPrint jasperPrint=JasperFillManager.fillReport(ireportTemplate,
                    parameters,connection);
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
            outputStream=new FileOutputStream(outFileName);
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
	}}
