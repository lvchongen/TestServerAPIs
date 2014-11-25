package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Atmelist;

public class AtmelistTest {
	
	NetworkService networkService;
	String url;
	Atmelist atmelist;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		atmelist=new Atmelist();
		url=networkService.getServer_staging();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		atmelist=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, atmelist.getAtmelist());
			boolean value=result.contains("\"status\":1");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
