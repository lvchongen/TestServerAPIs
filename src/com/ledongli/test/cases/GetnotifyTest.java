package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Getnotify;

public class GetnotifyTest {
	
	NetworkService networkService;
	String url;
	Getnotify getnotify;
	
	@Before
	public void setUp() throws Exception {
		getnotify=new Getnotify();
		networkService=new NetworkService();
		url=networkService.getServer_io_staging();
	}

	@After
	public void tearDown() throws Exception {
		getnotify=null;
		networkService=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, getnotify.getNotiList());
			boolean value=result.contains("\"status\":\"OK\"");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

}
