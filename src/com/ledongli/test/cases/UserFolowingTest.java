package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.User_Following;

public class UserFolowingTest {
	
	private String url;
	private NetworkService networkService;
	private User_Following user_Following;
	private String uid,password;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
		user_Following=new User_Following(uid,password,"");	
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		user_Following=null;
		Thread.sleep(10000);
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
				
				if(result==false) {
	                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                System.out.println();
	                System.out.println("================================================================");
	                System.out.println("Execute Time: "+ df.format(new Date()));
	                System.out.println("Test Class: "+ this.getClass().getName());
	                System.out.println("Server IP: "+ url);
	                System.out.println("uid: "+uid);
	                System.out.println("password: "+password);
	                System.out.println("Actual Result: "+ actualString);
	                System.out.println("================================================================");
	                
	            }
				
				assertTrue(result);
				
			}
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
