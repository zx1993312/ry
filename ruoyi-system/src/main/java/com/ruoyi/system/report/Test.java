package com.ruoyi.system.report;

import java.io.File;

import com.ruoyi.system.report.ireport.GenPDF;

public class Test {
	
	public static void main(String[] args) {
		/*GenPDF genPDF = new GenPDF();
		genPDF.genPDF("C000101");*/
		/*String saveFilePath = getClass().getClassLoader().getResource("文件名").getPath()+"img";
		System.out.println(saveFilePath);*/
		/*File directory = new File("img");//参数为空
		String courseFile = directory.getCanonicalPath();//标准的路径 ;
		String author =directory.getAbsolutePath();//绝对路径;
		 */		
		String property = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img";
		System.out.println(property);
	}
	
}
