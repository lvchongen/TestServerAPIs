package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.User_Friends;

public class UserFriendsTest {
	
	private String url;
	private NetworkService networkService;
	private User_Friends user_Friends;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		user_Friends=null;
	}
	
	
	//测试user_id未空， 返回自己的好友
	@Test
	public void testUserIDisNull() {
		try {
			user_Friends=new User_Friends("");
			String actString=networkService.sendPost(url, user_Friends.getUser_friends());
			if(actString=="[]")
				assertTrue(true);
			else {
				boolean result=actString.contains("follow_id");
				assertTrue(result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	//测试user_id 不为空， 则返回user_id的friends
	@Test
	public void testUserIDisNotNull() {
		try{
			user_Friends=new User_Friends("2949163");
			String actString=networkService.sendPost(url, user_Friends.getUser_friends());
			if(actString=="[]")
				assertTrue(true);
			else {
				boolean result=actString.contains("follow_id");
				assertTrue(result);
			}
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	

}
