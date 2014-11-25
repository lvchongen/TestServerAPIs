package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.ListFriends;

public class ListfriendsTest {
	
	NetworkService networkService;
	String url;
	ListFriends listFriends;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_io_staging();
		listFriends=new ListFriends();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		listFriends=null;
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, listFriends.getFriendsList());
			boolean value=result.contains("\"status\":\"OK\"");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
