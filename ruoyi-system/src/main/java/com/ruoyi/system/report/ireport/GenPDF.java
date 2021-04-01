package com.ruoyi.system.report.ireport;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ruoyi.system.annotation.JDBCConnection;

public class GenPDF {

	private static final String JASPER_PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\templates\\system\\WebRoot\\";
	
	public static final String OUT_PATH = "D:/";
	
	public void genPDF(String CLASSNO) {
		long start_time = new Date().getTime();
		
		
		
		Map<String, Object> parameters = new HashMap<>();
		
		parameters.put("CLASSNO", CLASSNO);
		
		try {
			
			String outFileName = OUT_PATH+CLASSNO+"_"+start_time+".pdf";
			
			String ireportTemplate = JASPER_PATH+"repo.jasper";
			
			IReportUtil.exportPdfFileServer(ireportTemplate,outFileName,parameters);
			
			long end_time = new Date().getTime();
			
			System.out.println("生成pdf完成，文件目录："+outFileName+"。耗时:"+(end_time-start_time));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
