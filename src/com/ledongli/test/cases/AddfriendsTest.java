package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.AnalyzeResult;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.AddUser;
import com.ledongli.test.serverAPIs.Addfriends;

public class AddfriendsTest {
	
	private Addfriends addfriends;
	private NetworkService networkService;
	private String url;
	private AddUser addUser;
	private AnalyzeResult analyzeResult;
	
	private String uid,password;
	private int i=0;
	
	@Before
	public void setUp() throws Exception {
		
		networkService=new NetworkService();
		url=networkService.getServerIO_IP();
		addUser=new AddUser();
		uid=networkService.getUid();
		password=networkService.getPassword();
	}

	@After
	public void tearDown() throws Exception {
		addfriends=null;
		networkService=null;
		Thread.sleep(10000);
	}

	@Test
	public void testGetAddfriendsList(){
		
		try {
			String firstResultString=networkService.sendPost(url, addUser.getAddUser());
			String secondResultString=networkService.sendPost(url,addUser.getAddUser());
			
			analyzeResult=new AnalyzeResult(firstResultString);
			String first_uid=analyzeResult.getValue("uid");
			
			analyzeResult=new AnalyzeResult(secondResultString);
			String second_uid=analyzeResult.getValue("uid");
			
			int friend1=Integer.parseInt(first_uid);
			int friend2=Integer.parseInt(second_uid);
			
			int[] friend={friend1,friend2};
			addfriends=new Addfriends(uid,password,friend);
			String result=networkService.sendPost(url, addfriends.getAddfriendsList());
			
			while(i<3) {
				if(result.contains("time out")) {
					i++;
					Thread.sleep(3000);
					testGetAddfriendsList();
				}
				else {
					break;
				}
			}
			
			boolean value=result.contains("\"status\":\"OK\"");
			
            if(value==false) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println();
                System.out.println("================================================================");
                System.out.println("Execute Time: "+ df.format(new Date()));
                System.out.println("Test Class: "+ this.getClass().getName());
                System.out.println("Actual Result: "+ result);
                System.out.println("Server IP: "+ url);
                System.out.println("uid: "+uid);
                System.out.println("password: "+password);
                System.out.println("================================================================");
                
            }
			
			assertTrue(value);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
		
	}
	
//	@Test
//	public void testAddFriendsNull() {
//		try {
//			int[] friend=null;
//			addfriends=new Addfriends(friend);
//			String result=networkService.sendPost(url, addfriends.getAddfriendsList());
//			
//			System.out.print(result);
//			
//			boolean value=result.contains("\"status\":\"OK\"");
//			assertTrue(value);
//		}
//		catch(Exception e) {
//			fail(e.getMessage());
//		}
//		
//	}

	
}
