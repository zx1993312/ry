package com.ruoyi.system.utils;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;

import com.ruoyi.system.enums.PaperEnum;

public class HyPrintPDFUtil {

	private static double width = 0.0;
	private static double height = 0.0;

	public static void printPDF(String pdfPath, String paperName)
			throws InvalidPasswordException, IOException, PrinterException {

		File file = new File(pdfPath);

		// 读取pdf文件
		PDDocument document = PDDocument.load(file);

		// 创建打印任务
		PrinterJob job = PrinterJob.getPrinterJob();
		
		job.setPageable(new PDFPageable(document));

		Paper paper = new Paper();
		setPaper(paperName);
		paper.setSize(width, height); // 598, 842设置打印纸张大小
		paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight()); // no margins

		PageFormat pageFormat = new PageFormat();
		pageFormat.setPaper(paper);

		Book book = new Book();
		book.append(new PDFPrintable(document, Scaling.ACTUAL_SIZE), pageFormat, 1);
		job.setPageable(book);
		job.print();
	}

	public static void setPaper(String paperName) {
		switch (paperName) {
		case "A4":
			width = PaperEnum.A4.getWidth();
			height = PaperEnum.A4.getHeight();
			break;
		default:
			break;
		}
	}
}
