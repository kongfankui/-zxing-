package com.kfk.zxing;

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

//使用zxing解析二维码
public class ReadQRCode {

	public static void main(String[] args) {
		MultiFormatReader formatReader = new MultiFormatReader();
		
		File file = new File("D:/eclipse/1.png");
		
		try {
			BufferedImage image = ImageIO.read(file);
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			
			HashMap hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			
			Result result = formatReader.decode(binaryBitmap,hints);
			
			System.out.println("解析结果：" + result.toString());
			System.out.println("二维码解析格式：" + result.getBarcodeFormat());
			System.out.println("二维码文本内容：" + result.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
