package com.hx.hkTest.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;

@SuppressWarnings("restriction")
public class StringUtil{
	
	public static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

	/**
	 * 功能描述：将二进制转换为图片
	 * @author: xiahui
	 * @param base64String: 图片的二进制数据
	 * @param filePath： 图片最终写入的路径
	 * @date: 2019年10月26日 下午4:31:11
	 */
    public static void base64StringToImage( String base64String, String filePath) {
    	ByteArrayInputStream bais = null;
        try {
            byte[] bytes = decoder.decodeBuffer(base64String);
            bais = new ByteArrayInputStream(bytes);
            BufferedImage bi = ImageIO.read(bais);
            File file = new File(filePath);
            ImageIO.write(bi, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        	if(null != bais) {
        		try {
					bais.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
    }
}
