package com.ledongli.test.common;

import java.io.File;
import java.io.FileInputStream;

public class Image2Binary {
	
	private String url;
	
	public Image2Binary(String _url) {
		url=_url;
	}
	
	public byte[] getBinary() {
		File file=new File(url);
		FileInputStream fis;  
        try  
        {  
            fis = new FileInputStream(file);  
            byte[] b;  
            b = new byte[fis.available()];  
            StringBuilder str = new StringBuilder();
//            fis.read(b);  
//            for (byte bs : b)  
//            {  
//                str.append(Integer.toBinaryString(bs));// 转换为二进制  
//            }  
//            return str;
            return b;
        }
        catch(Exception e) {
        	return null;
        }
	}
}
