package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Follow_Create;
import com.ledongli.test.serverAPIs.User_Followers;

public class UserFollowersTest {
	
	private User_Followers user_Followers;
	private NetworkService networkService;
	private String url;
	private Follow_Create follow_Create;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
	}

	@After
	public void tearDown() throws Exception {
		user_Followers=null;
	}

	//测试查看uid为空时应查看自己
	@Test
	public void testUidNull() {
		String uid="";
		user_Followers=new User_Followers("");
		String actualResult;
		try {
			actualResult = networkService.sendPost(url, user_Followers.getUser_followers());
			//System.out.print(actualResult);
			boolean exist1=actualResult.contains("[")&&actualResult.contains("]");
			boolean exist2=actualResult.contains("follow_id");
			boolean result=exist1||exist2;
			assertTrue(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	//测试查看某个uid
	@Test
	public void testUidIsnotNull() {
		String uid="2950358";
		user_Followers=new User_Followers(uid);
		String actualResult;
		try{
			actualResult = networkService.sendPost(url, user_Followers.getUser_followers());
			//System.out.print(actualResult);
			boolean exist1=actualResult.contains("[")&&actualResult.contains("]");
			boolean exist2=actualResult.contains("follow_id");
			boolean result=exist1||exist2;
			assertTrue(result);

		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	//测试follow某个uid后查看返回是否包含follower的uid
	@Test
	public void testAfterFollowing() {
		String uid1="2951962";
		String uid2="2949163";
		
		try {
			//A 关注 B
			follow_Create=new Follow_Create(uid1);
			String result1= networkService.sendPost(url, follow_Create.getFollow_create());
			//System.out.print(result1);
			
			//B 关注 A
			follow_Create=null;
			follow_Create=new Follow_Create(uid1,"123456",uid2);
			String result2=networkService.sendPost(url, follow_Create.getFollow_create());
			//System.out.print(result2);
			
			user_Followers=new User_Followers("");
			String actualResult=networkService.sendPost(url, user_Followers.getUser_followers());
			System.out.print(actualResult);
			boolean result=actualResult.contains(uid1);
			assertTrue(result);
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}

}
