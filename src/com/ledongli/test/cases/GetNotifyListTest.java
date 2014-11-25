package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.GetNotifyList_Notify;

public class GetNotifyListTest {
	
	NetworkService networkService;
	String url;
	GetNotifyList_Notify getNotifyList_Notify;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		getNotifyList_Notify=new GetNotifyList_Notify();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		getNotifyList_Notify=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, getNotifyList_Notify.getNotifyList());
			boolean value=result.contains("list")&&result.contains("count");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
