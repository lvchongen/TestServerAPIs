package com.ledongli.test.cases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.AnalyzeResult;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DeleteNotify;
import com.ledongli.test.serverAPIs.DoPost;

public class DeleteNotifyTest {
	
	NetworkService networkService;
	String url;
	DeleteNotify deleteNotify;
	DoPost doPost;
	AnalyzeResult analyzeResult;
	int i=0;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		
	}

	@After
	public void tearDown() throws Exception {
		doPost=null;
		//deleteNotify=null;
		analyzeResult=null;
		Thread.sleep(10000);
	}

	@Test
	public void test() {
		try {
//			doPost=new DoPost("2949163");
//			String result=networkService.sendPost(url, doPost.getDoPost());
//			//System.out.print(result);
//			analyzeResult=new AnalyzeResult(result);
//			String message_id=analyzeResult.getValue("message_id");
//			String list_id=analyzeResult.getValue("list_id");
//			
//			deleteNotify=new DeleteNotify(message_id);
//			String result1=networkService.sendPost(url, deleteNotify.getDeleteNotify());
//			System.out.print(result1);
//			boolean value1=result1.contains("1");
//			assertTrue(value1);
//			
//			String result2=networkService.sendPost(url, deleteNotify.getDeleteNotify());
//			boolean value2=result2.contains("0");
//			assertTrue(value2);
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
