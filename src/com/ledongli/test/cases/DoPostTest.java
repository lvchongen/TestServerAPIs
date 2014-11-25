package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoPost;

public class DoPostTest {
	
	private NetworkService networkService;
	private String url;
	private DoPost doPost;
	
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

	@Test
	public void test() {
		
		try {
			doPost=new DoPost("2949163");
			String actString=networkService.sendPost(url, doPost.getDoPost());
			System.out.print(actString);
			boolean result=actString.contains("\\u53d1\\u9001\\u6210\\u529f");
			assertTrue(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			
		}
	}

}
