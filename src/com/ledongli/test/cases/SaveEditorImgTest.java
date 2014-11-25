package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.File;

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
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		imgLess="Images/LessImg.png";
		imgMore="Images/MoreImg.png";
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		saveEditorImg=null;
	}
	
	//�ϴ�����200K��ͼƬ����֤�ϴ�ʧ��
	@Test
	public void testImgMore() {
		try{
			File file=new File(imgMore);
			FileBody fileBody=new FileBody(file);
			saveEditorImg=new SaveEditorImg(fileBody);
			String result=networkService.sendPostStream(url, saveEditorImg.getSaveEditorImg());
			//System.out.print(result);
			boolean value=result.contains("413 Request Entity Too Large");
			assertTrue(value);
			
		}
		catch(Exception e){
			fail(e.getMessage());
		}
		
	}
	
	//�ϴ�С��150K��ͼƬ�� ��֤�ϴ��ɹ�
	@Test
	public void testImgLess() {
		try{
			FileBody fileBody=new FileBody(new File(imgLess));
			saveEditorImg=new SaveEditorImg(fileBody);
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