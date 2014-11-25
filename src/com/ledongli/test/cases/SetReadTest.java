package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.SetRead;

public class SetReadTest {
	
	NetworkService networkService;
	String url;
	SetRead setRead;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		setRead=new SetRead();
		url=networkService.getServer_staging();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		setRead=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, setRead.getSetRead());
			boolean value=result.contains("\"status\":1");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}

}
