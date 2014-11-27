package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.User_Friends;

public class UserFriendsTest {
	
	private String url;
	private NetworkService networkService;
	private User_Friends user_Friends;
	private String uid,password;
	private int i=0;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		user_Friends=null;
		Thread.sleep(10000);
	}
	
	
	//测试user_id未空， 返回自己的好友
	@Test
	public void testUserIDisNull() {
		try {
			user_Friends=new User_Friends(uid,password,"");
			String actString=networkService.sendPost(url, user_Friends.getUser_friends());
			while(i<3) {
		        if(actString.contains("time out")) {
		          i++;
		          Thread.sleep(3000);
		          testUserIDisNull();
		        }
		        else {
		          break;
		        }
		      }
			//System.out.print(actString);
			if(actString=="[]")
				assertTrue(true);
			else {
				boolean result=actString.contains("follow_id");
				
				if(result==false) {
	                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                System.out.println();
	                System.out.println("================================================================");
	                System.out.println("Execute Time: "+ df.format(new Date()));
	                System.out.println("Test Class: "+ this.getClass().getName());
	                System.out.println("Server IP: "+ url);
	                System.out.println("uid: "+uid);
	                System.out.println("password: "+password);
	                System.out.println("Actual Result: "+ actString);
	                System.out.println("================================================================");
	                
	            }
				
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
			user_Friends=new User_Friends(uid,password,uid);
			String actString=networkService.sendPost(url, user_Friends.getUser_friends());
			while(i<3) {
		        if(actString.contains("time out")) {
		          i++;
		          Thread.sleep(3000);
		          testUserIDisNotNull();
		        }
		        else {
		          break;
		        }
		      }
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
