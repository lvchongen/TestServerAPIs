package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Findfriend;

public class FindfriendTest {
	
	NetworkService networkService;
	String url;
	Findfriend findfriend;
	
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
		String name="dljt121313";
		findfriend=new Findfriend(name);
		try {
			String result=networkService.sendPost(url, findfriend.getFindFriend());
			boolean value=result.contains("\"status\":\"OK\"");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
