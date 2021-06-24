package com.ruoyi.system.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IoUtil {
	public static byte[] readPdfFile(String fileName) throws Exception {
		InputStream in = null;
		byte[] bytesRel = new byte[1024];
		try {
			// 读取Constants.PDF_CREATE_AND_SIGN.PDF_FILE_PATH路径下文件名位fileName的文件
			File f = new File(fileName);
			in = new FileInputStream(f);
			// in.available 只适合于读取本地文件时判断流中字节数，不适合网络中的流数据大小判定
			bytesRel = new byte[in.available()];
			in.read(bytesRel);
		} catch (IOException e) {
			log.error("读取文件{}失败！" + fileName);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.error("输入流关闭失败！原因：{}", e.getMessage());
				}
			}
		}
		return bytesRel;
	}

	public static void writePdfFile(byte[] pdfByte, String fileName) throws Exception {
		OutputStream os = null;
		try {
			os = new FileOutputStream(fileName);
			os.write(pdfByte);
			os.flush();
		} catch (IOException e) {
			log.error("写入文件{}失败！" + fileName);
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				log.error("输入流关闭失败！原因：{}", e.getMessage());
			}
		}
	}
}
