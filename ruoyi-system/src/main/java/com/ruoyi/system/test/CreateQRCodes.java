package com.ruoyi.system.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

//生成二维码
public class CreateQRCodes {

    public static void main(String[] args) throws IOException {

        //计算二维码图片的高宽比
        //API文档规定计算图片宽高的方式，v是版本号(1~40)
        int v = 7;
        int width = 67 + 12 * (v - 1);        //计算公式
        int height = 67 + 12 * (v - 1);

        Qrcode x = new Qrcode();

        /**
         * 纠错等级分为
         * level L : 最大 7% 的错误能够被纠正；
         * level M : 最大 15% 的错误能够被纠正；
         * level Q : 最大 25% 的错误能够被纠正；
         * level H : 最大 30% 的错误能够被纠正；
         */
        x.setQrcodeErrorCorrect('L');    //设置纠错等级
        x.setQrcodeEncodeMode('B');    //N代表数字  A代表a-Z B代表其他字符
        x.setQrcodeVersion(v);        //版本号(1~40)
        String qrData = "http://39.105.185.22:8080/system/task";    //内容信息

        //缓冲区
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //绘图
        Graphics2D gs = bufferedImage.createGraphics();

        gs.setBackground(Color.WHITE);        //背景色
        gs.setColor(Color.black);
        gs.clearRect(0, 0, width, height);    //清除画板内容

        //偏移量 2或7
        int pixoff = 2;

        /**
         * 1.注意for循环里面的i，j的顺序，
         *   s[j][i]二维数组的j，i的顺序要与这个方法中的 gs.fillRect(j*3+pixoff,i*3+pixoff, 3, 3);
         *   顺序匹配，否则会出现解析图片是一串数字
         * 2.注意此判断if (d.length > 0 && d.length < 120)
         *   是否会引起字符串长度大于120导致生成代码不执行，二维码空白
         *   根据自己的字符串大小来设置此配置
         */
        //把要填充的内容转化成字节数
        byte[] d = qrData.getBytes("utf-8");    //汉字转化格式
        if (d.length > 0 && d.length < 120) {
            boolean[][] s = x.calQrcode(d);

            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j][i]) {
                        //把d中的内容填充
                        gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                    }
                }
            }
        }

        gs.dispose();            //结束写入
        bufferedImage.flush();    //结束buffered
        ImageIO.write(bufferedImage, "png", new File("E:/"+new Date().getTime()+"img.png"));    //将图片写入到指定路径下

    }
}
