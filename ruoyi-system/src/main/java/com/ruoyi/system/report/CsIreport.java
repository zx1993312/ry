package com.ruoyi.system.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class CsIreport {
	public static void main(String[] args) throws JRException, UnsupportedEncodingException, FileNotFoundException {
		try {
			JRDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(new ArrayList<>());
			File jasperFile = ResourceUtils.getFile("D:/repo.jasper");
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(),
					jrBeanCollectionDataSource);
			JasperExportManager.exportReportToHtmlFile(jasperPrint, "D:/reportPreviewTemp.html");
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
