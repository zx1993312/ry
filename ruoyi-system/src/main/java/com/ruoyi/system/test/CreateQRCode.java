package com.ruoyi.system.test;

import java.io.File;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

//生成二维码
public class CreateQRCode {

	public static void main(String[] args) {
		int width = 300; // 二维码宽度
		int height = 300; // 二维码高度
		String format = "png"; // 二维码图片格式
		// String content = "www.baidu.com"; //二维码内容
		String content = "http://39.105.185.22:8080/system/task"; // 二维码内容

		// 定义二维码参数
		HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 定义内容字符集的编码
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // 定义纠错等级
		hints.put(EncodeHintType.MARGIN, 2); // 边框空白

		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);

			Path file = new File("E:/" + new Date().getTime() + "img.png").toPath();

			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			// MatrixToImageWriter.writeToStream(bitMatrix, format, stream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
