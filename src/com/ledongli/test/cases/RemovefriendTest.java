package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.RemoveFriends;

public class RemovefriendTest {
	
	NetworkService networkService;
	String url;
	RemoveFriends removeFriends;
	
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
		int[] friend={1};
		removeFriends=new RemoveFriends(friend);
		try {
			String result=networkService.sendPost(url, removeFriends.getRemoveFiends());
			boolean value=result.contains("\"status\":\"OK\",");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
