package com.ledongli.test.cases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.AnalyzeResult;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoDetail;
import com.ledongli.test.serverAPIs.DoPost;

public class DoDetailTest {

	private NetworkService networkService;
	private String url;
	private DoDetail doDetail;
	private DoPost doPost;
	private AnalyzeResult analyzeResult;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		
	}

	@After
	public void tearDown() throws Exception {
		networkService = null;
		doDetail=null;
		doPost=null;
	}

	
	//发送私信， 再获取私信的内容
	@Test
	public void test() {
		try{
			doPost=new DoPost("2949163");
			String postResult=networkService.sendPost(url, doPost.getDoPost());
			//System.out.print(postResult);
			analyzeResult=new AnalyzeResult(postResult);
			String list_id=analyzeResult.getValue("list_id");
			String message_id=analyzeResult.getValue("message_id");
			//System.out.print(list_id);
			//System.out.print(message_id);
			
			doDetail=new DoDetail(list_id);
			String actualResult=networkService.sendPost(url, doDetail.getDoDetail());
			boolean result=actualResult.contains(list_id)&&actualResult.contains(message_id);
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
