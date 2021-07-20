package com.ruoyi.system.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.ruoyi.system.constants.Constants;

public class GoogleCodeUtil {

	public static void creatCode(String content) {
		String format = "png"; // 二维码图片格式
		// String content = "http://39.105.185.22:8080/system/task"; // 二维码内容

		// 定义二维码参数
		HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 定义内容字符集的编码
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // 定义纠错等级
		hints.put(EncodeHintType.MARGIN, 2); // 边框空白

		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, Constants.CODE_WIDTH,
					Constants.CODE_HEIGHT);

			Path file = new File("E:/" + new Date().getTime() + "img.png").toPath();

			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			// MatrixToImageWriter.writeToStream(bitMatrix, format, stream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void readCode(String fileName) {
		try {
			MultiFormatReader formatReader = new MultiFormatReader();

			File file = new File("E:" + fileName + "/img.png");

			BufferedImage image = ImageIO.read(file); // 读取此文件识别成一个图片

			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

			// 定义二维码参数
			HashMap hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 定义内容字符集的编码

			Result result = formatReader.decode(binaryBitmap, hints);

			System.out.println("解析结果：" + result.toString());
			System.out.println("二维码格式类型：" + result.getBarcodeFormat());
			System.out.println("二维码文本内容：" + result.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String a = "11111";
		String content = "http://192.168.0.111:8081/#/qualityInspection?uuu="+a;
		creatCode(content);
	}
}
