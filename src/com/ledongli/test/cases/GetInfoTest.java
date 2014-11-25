package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.GetInfo;

public class GetInfoTest {
	
	NetworkService networkService;
	String url;
	GetInfo getInfo;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_io_staging();
		getInfo=new GetInfo();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		getInfo=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, getInfo.getGetInfoList());
			boolean value=result.contains("\"status\":\"OK\"");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
