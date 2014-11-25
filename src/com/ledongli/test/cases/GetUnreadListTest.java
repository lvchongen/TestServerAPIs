package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.GetUnreadList;

public class GetUnreadListTest {
	
	NetworkService networkService;
	String url;
	GetUnreadList getUnreadList;
	
	@Before
	public void setUp() throws Exception {
		
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		getUnreadList=new GetUnreadList();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		getUnreadList=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, getUnreadList.getUnreadList());
			boolean value=result.contains("list")&&result.contains("count");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
