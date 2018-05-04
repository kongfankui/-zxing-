package com.kfk.zxing;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

//使用zxing生成二维码
public class CreateQRCode {
	public static void main(String[] args) {
		int width = 300;
		int height = 300;
		String format = "png";
		//String content = "水牛，欢迎来到动物世界";
		//名片二维码
		String content = "BEGIN:VCARD\r\n" + 
				"VERSION:2.1\r\n" + 
				"N:孔;繁奎\r\n" + 
				"FN:孔繁奎\r\n" + 
				"ORG:土巴兔;java开发部\r\n" + 
				"TITLE:Dev\r\n" + 
				"PHOTO;JPG:http://www.baidu.com\r\n" + 
				"TEL;WORK;VOICE:159-2710-0097\r\n" + 
				"TEL;HOME;VOICE:159-2710-0097\r\n" + 
				"TEL;\r\n" + 
				"ADR;WORK;PREF:;;深圳市南山区比克科技大厦土巴兔\r\n" + 
				"ADR;HOME:;;重庆市奉节县白帝镇浣花村\r\n" + 
				"EMAIL:fankui_kong@163.com\r\n" + 
				"REV:20080424T195243Z\r\n" + 
				"END:VCARD";
		
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN,2);
		
		try {
			//new String(content.getBytes("UTF-8"),"ISO-8859-1")才支持中文
			BitMatrix bitmatrix = new MultiFormatWriter().encode(new String(content.getBytes("UTF-8"),"ISO-8859-1"), BarcodeFormat.QR_CODE, width, height);
			//路径要存在才行
			Path file = new File("D:/eclipse/1.png").toPath();
			MatrixToImageWriter.writeToPath(bitmatrix, format, file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
