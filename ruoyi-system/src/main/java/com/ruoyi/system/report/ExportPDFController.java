package com.ruoyi.system.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.common.core.controller.BaseController;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
@Controller
@RequestMapping("/exportPDF")
public class ExportPDFController extends BaseController {

	@RequestMapping("/ePDF")
	public void exportPDF(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {

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
