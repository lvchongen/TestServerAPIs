package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Listfans;

public class ListfansTest {
	
	NetworkService networkService;
	String url;
	Listfans listfans;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_io_staging();
		listfans=new Listfans();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		listfans=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, listfans.getFansList());
			boolean value=result.contains("\"status\":\"OK\"");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
