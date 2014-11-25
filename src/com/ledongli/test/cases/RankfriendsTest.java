package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Rankfriends;

public class RankfriendsTest {
	
	NetworkService networkService;
	String url;
	Rankfriends rankfriends;
	
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
		long unixTime = System.currentTimeMillis() / 1000L;
		String unixTimeString=String.valueOf(unixTime);
		rankfriends=new Rankfriends(Double.valueOf(unixTimeString));
		
		try {
			String result=networkService.sendPost(url, rankfriends.getRanklList());
			boolean value=result.contains("\"status\":\"OK\"");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
