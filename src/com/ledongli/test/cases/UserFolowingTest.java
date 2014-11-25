package com.ledongli.test.cases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.User_Following;

public class UserFolowingTest {
	
	private String url;
	private NetworkService networkService;
	private User_Following user_Following;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		user_Following=new User_Following();	
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		user_Following=null;
	}

	@Test
	public void test() {
		try {
			String actualString=networkService.sendPost(url, user_Following.getUser_following());
			if(actualString=="[]") {
				assertTrue(true);
			}
			else {
				boolean result=actualString.contains("follow_id");
				assertTrue(result);
				
			}
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
