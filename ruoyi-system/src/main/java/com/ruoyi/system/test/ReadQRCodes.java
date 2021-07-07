package com.ruoyi.system.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class ReadQRCodes {

    public static void main(String[] args) throws IOException {

        //图片路径
        File file = new File("E:/img.png");
        //读取图片到缓冲区
        BufferedImage bufferedImage = ImageIO.read(file);
        //QRCode解码器
        QRCodeDecoder codeDecoder = new QRCodeDecoder();

        /**
         *codeDecoder.decode(new MyQRCodeImage())
         *这里需要实现QRCodeImage接口，MyQRCodeImage.java实现接口类
         */
        //通过解析二维码获得信息
        String result = new String(codeDecoder.decode(new MyQRCodeImage(bufferedImage)), "utf-8");
        System.out.println(result);
    }
}
