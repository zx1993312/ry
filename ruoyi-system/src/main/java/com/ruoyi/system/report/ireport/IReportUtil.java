package com.ruoyi.system.report.ireport;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import com.ruoyi.system.annotation.ReportDataSource;
import com.ruoyi.system.report.ExportPDFController;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

public class IReportUtil {
	

	public static void exportPdfFileServer(String outFileName, Map<String, Object> parameters) {
		
				String attName = null;
				OutputStream out = null;

				try {
					// 设置jasper中的参数

					// key 参数名 ，value 参数值

					// 这里给的是数据库连接，你也可以是个集合，根据自己需求，填充jasper

					// 获取jasper文件。
					// InputStream in = IReportUtil.class.getResourceAsStream("D:/repo.jasper");
					InputStream in = new FileInputStream("D:/repo.jasper");
					System.out.println(in);
					// 填充jasper，生成打印或导出实例
					JasperPrint jasperPrint = JasperFillManager.fillReport(in, parameters);
					// 使导出转换成更具体(popular formats)的形式，PDF、HTML、XML
					byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
					// 得到响应流
					// out = response.getOutputStream(); // 网络流
					out = new FileOutputStream(outFileName);

					// 输出到响应中

					out.write(bytes);
					out.flush();
					out.close();

				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
	}
}
