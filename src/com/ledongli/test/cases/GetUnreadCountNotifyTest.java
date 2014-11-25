package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.GetUnreadCount_Notify;

public class GetUnreadCountNotifyTest {
	
	NetworkService networkService;
	String url;
	GetUnreadCount_Notify getUnreadCount_Notify;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		getUnreadCount_Notify=new GetUnreadCount_Notify();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		getUnreadCount_Notify=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, getUnreadCount_Notify.getUnreadCount());
			boolean value=result.contains("\"status\":1")&&result.contains("count");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
