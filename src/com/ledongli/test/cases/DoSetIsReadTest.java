package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.AnalyzeResult;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoReplay;
import com.ledongli.test.serverAPIs.DoSetIsRead;

public class DoSetIsReadTest {
	
	private NetworkService networkService;
	private String url;
	private DoSetIsRead doSetIsRead;
	
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		doSetIsRead=new DoSetIsRead();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		doSetIsRead=null;
	}

	@Test
	public void test() {
		try {
			String actualString=networkService.sendPost(url, doSetIsRead.getDoSetIsRead());
			System.out.print(actualString);
			boolean result=false;
			if(actualString.contains("{\"status\":1}"))
				result=true;
			
			assertTrue(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
	
	
}
