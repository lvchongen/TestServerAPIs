package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.entity.mime.content.FileBody;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.Image2Binary;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.SaveEditorImg;

public class SaveEditorImgTest {

	private String imgLess;
	private String imgMore;
	
	private NetworkService networkService;
	private SaveEditorImg saveEditorImg;
	private String url;
	private String uid,password;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
		imgLess="Images/LessImg.png";
		imgMore="Images/MoreImg.png";
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		saveEditorImg=null;
		Thread.sleep(10000);
	}
	
	//上传大于200K的图片，验证上传失败
	@Test
	public void testImgMore() {
		try{
			File file=new File(imgMore);
			FileBody fileBody=new FileBody(file);
			saveEditorImg=new SaveEditorImg(uid,password,fileBody);
			String result=networkService.sendPostStream(url, saveEditorImg.getSaveEditorImg());
			//System.out.print(result);
			boolean value=result.contains("413 Request Entity Too Large");
			
			if(value==false) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println();
                System.out.println("================================================================");
                System.out.println("Execute Time: "+ df.format(new Date()));
                System.out.println("Test Class: "+ this.getClass().getName());
                System.out.println("Server IP: "+ url);
                System.out.println("uid: "+uid);
                System.out.println("password: "+password);
                System.out.println("Actual Result: "+ result);
                System.out.println("================================================================");
                
            }
			
			assertTrue(value);
			
		}
		catch(Exception e){
			fail(e.getMessage());
		}
		
	}
	
	//上传小于150K的图片， 验证上传成功
	@Test
	public void testImgLess() {
		try{
			FileBody fileBody=new FileBody(new File(imgLess));
			saveEditorImg=new SaveEditorImg(uid,password,fileBody);
			String result=networkService.sendPostStream(url, saveEditorImg.getSaveEditorImg());
			//System.out.print(result);
			boolean value=result.contains("\"status\":1");
			assertTrue(value);
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}

}
