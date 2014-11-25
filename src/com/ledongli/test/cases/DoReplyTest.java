package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoReplay;

public class DoReplyTest {
	
	private NetworkService networkService;
	private String url;
	private DoReplay doReply;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		doReply=null;
		
	}

	@Test
	public void test() {
		try {
			doReply=new DoReplay("2949163");
			String actualString=networkService.sendPost(url, doReply.getDoReplay());
			boolean result=actualString.contains("\\u79c1\\u4fe1\\u53d1\\u9001\\u6210\\u529f");
			assertTrue(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	
	 
}
