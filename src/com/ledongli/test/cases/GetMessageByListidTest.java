package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.net.NetworkInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.AnalyzeResult;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoPost;
import com.ledongli.test.serverAPIs.GetMessageByListId;

public class GetMessageByListidTest {
	
	private NetworkService networkService;
	private DoPost doPost;
	private GetMessageByListId getMessageByListId;
	private String url;
	private AnalyzeResult analyzeResult;
	
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		
	}

	@After
	public void tearDown() throws Exception {
		doPost=null;
		networkService=null;
	}

	
	//发帖后获取listID， 查询是否包含listID
	@Test
	public void test() {
		try {
			doPost=new DoPost("2949163");
			String postResult=networkService.sendPost(url, doPost.getDoPost());
			//System.out.print(postResult);
			analyzeResult=new AnalyzeResult(postResult);
			String list_id=analyzeResult.getValue("list_id");
			String message_id=analyzeResult.getValue("message_id");
			//System.out.print(message_id);
			getMessageByListId=new GetMessageByListId(list_id);
			String actualResult=networkService.sendPost(url, getMessageByListId.getMessageByListId());
			boolean result=actualResult.contains(message_id)&&actualResult.contains(list_id);
			assertTrue(result);
			
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
