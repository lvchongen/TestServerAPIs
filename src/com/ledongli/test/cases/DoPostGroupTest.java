package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoPostGroup;

public class DoPostGroupTest {
	
	NetworkService networkService;
	String url;
	DoPostGroup doPostGroup;
	
	@Before
	public void setUp() throws Exception {
		networkService= new NetworkService();
		url=networkService.getServer_staging();
		doPostGroup=new DoPostGroup();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		doPostGroup=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, doPostGroup.getDoPost());
			System.out.print(result);
			boolean value=result.contains("\"status\":1")&&result.contains("\"data\":\"success\"");
			assertTrue(value);
				
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
