package com.ruoyi.system.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReadQRCode {

    public static void main(String[] args) {

        try {
            MultiFormatReader formatReader = new MultiFormatReader();

            File file = new File("E:/img.png");

            BufferedImage image = ImageIO.read(file);    //读取此文件识别成一个图片

            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

            //定义二维码参数
            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");    //定义内容字符集的编码


            Result result = formatReader.decode(binaryBitmap,hints);

            System.out.println("解析结果：" + result.toString());
            System.out.println("二维码格式类型：" + result.getBarcodeFormat());
            System.out.println("二维码文本内容：" + result.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
