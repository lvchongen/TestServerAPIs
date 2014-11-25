package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Getuserlimitedinfo;

public class GetuserlimitedinfoTest {
	
	NetworkService networkService;
	String url;
	Getuserlimitedinfo getuserlimitedinfo;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_io_staging();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		
	}

	@Test
	public void test() {
		String targetUid="1";
		getuserlimitedinfo=new Getuserlimitedinfo(targetUid);
		try {
			String result=networkService.sendPost(url, getuserlimitedinfo.getUserlimitList());
			boolean value=result.contains("\"status\":\"OK\"");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}

}
