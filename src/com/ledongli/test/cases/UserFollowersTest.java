package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private String uid,password, uid_2, password_2;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
		uid_2=networkService.getUid_2();
		password_2=networkService.getPassword_2();
	}

	@After
	public void tearDown() throws Exception {
		user_Followers=null;
		Thread.sleep(10000);
	}

	//测试查看user_id为空时应查看自己
	@Test
	public void testUidNull() {
		String user_id="";
		user_Followers=new User_Followers(uid,password,user_id);
		String actualResult;
		try {
			actualResult = networkService.sendPost(url, user_Followers.getUser_followers());
			//System.out.print(actualResult);
			boolean exist1=actualResult.contains("[")&&actualResult.contains("]");
			boolean exist2=actualResult.contains("follow_id");
			boolean result=exist1||exist2;
			
			if(result==false) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println();
                System.out.println("================================================================");
                System.out.println("Execute Time: "+ df.format(new Date()));
                System.out.println("Test Class: "+ this.getClass().getName());
                System.out.println("Server IP: "+ url);
                System.out.println("uid: "+uid);
                System.out.println("password: "+password);
                System.out.println("Actual Result: "+ actualResult);
                System.out.println("================================================================");
                
            }
			
			assertTrue(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	//测试查看某个uid
	@Test
	public void testUidIsnotNull() {
		String user_id="1";
		user_Followers=new User_Followers(uid,password,user_id);
		String actualResult;
		try{
			actualResult = networkService.sendPost(url, user_Followers.getUser_followers());
			//system.out.print(actualResult);
			boolean exist1=actualResult.contains("[")&&actualResult.contains("]");
			boolean exist2=actualResult.contains("follow_id");
			boolean result=exist1||exist2;
			
			if(result==false) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println();
                System.out.println("================================================================");
                System.out.println("Execute Time: "+ df.format(new Date()));
                System.out.println("Test Class: "+ this.getClass().getName());
                System.out.println("Actual Result: "+ actualResult);
                System.out.println("================================================================");
                
            }
			
			assertTrue(result);

		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	//测试follow某个uid后查看返回是否包含follower的uid
	@Test
	public void testAfterFollowing() {
		String uid1=uid;
		String uid2=uid_2;
		
		try {
			//A 关注 B
			follow_Create=new Follow_Create(uid2,password_2,uid1);
			String result1= networkService.sendPost(url, follow_Create.getFollow_create());
			//System.out.print(result1);
			
			//B 关注 A
			follow_Create=null;
			follow_Create=new Follow_Create(uid1,password,uid2);
			String result2=networkService.sendPost(url, follow_Create.getFollow_create());
			//System.out.print(result2);
			
			user_Followers=new User_Followers(uid1,password,"");
			String actualResult=networkService.sendPost(url, user_Followers.getUser_followers());
			//System.out.print(actualResult);
			boolean result=actualResult.contains(uid2);
			assertTrue(result);
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}

}
