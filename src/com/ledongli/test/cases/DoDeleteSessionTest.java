package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.net.NetworkInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.AnalyzeResult;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoDeleteSession;
import com.ledongli.test.serverAPIs.DoPost;

public class DoDeleteSessionTest {

	private String url;
	private DoDeleteSession doDeleteSession;
	private NetworkService networkService;
	private DoPost doPost;
	private AnalyzeResult analyzeResult;

	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		doDeleteSession=null;
	}
	
	
	//测试删除不存在的session
	@Test
	public void testNotExistSession() {
		try {
			doDeleteSession=new DoDeleteSession("2783");
			String actualResult=networkService.sendPost(url, doDeleteSession.getDoDeleteSession());
			System.out.print(actualResult);
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}
	
	//发消息后，删除私信
	@Test
	public void testExistSession() {
		try {
			doPost=new DoPost("2949163");
			String postResult=networkService.sendPost(url, doPost.getDoPost());
			analyzeResult=new AnalyzeResult(postResult);
			String list_id=analyzeResult.getValue("list_id");
			String message_id=analyzeResult.getValue("message_id");
			
			doDeleteSession=new DoDeleteSession(message_id);
			String actualResult=networkService.sendPost(url, doDeleteSession.getDoDeleteSession());
			assertEquals("{\"status\":1}", actualResult);
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
