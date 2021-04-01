package com.ruoyi.system.report;

import java.io.File;

import com.ruoyi.system.report.ireport.GenPDF;

public class Test {
	
	public static void main(String[] args) {
		GenPDF genPDF = new GenPDF();
		genPDF.genPDF("C000101");
	}
	
}
