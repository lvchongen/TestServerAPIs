package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Follow_Create;

public class FollowCreateTest {
	
	
	private NetworkService networkService;
	private String url;
	private String uid,password;
	
	private Follow_Create follow_Create;
	@Before
	public void setUp() throws Exception {
		
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
	}

	@After
	public void tearDown() throws Exception {
		follow_Create=null;
		networkService=null;
		Thread.sleep(10000);
	}

	//���Թ�ע�����û�
	@Test
	public void testFollowOtherPeople() {
		try {
			follow_Create=new Follow_Create(uid,password,"1");
			String actualResult=networkService.sendPost(url, follow_Create.getFollow_create());
			String expectResult=follow_Create.getExpectedResult(1);
			
			boolean value=actualResult.contains("\"following\":1");
			
			if(value==false) {
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
			
			assertTrue(value);
			
			
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
		
	}
	
	//���Թ�ע�Լ�
	@Test
	public void testFollowMyself() {
		try{
			follow_Create=new Follow_Create(uid,password,uid);
			String actualResult=networkService.sendPost(url, follow_Create.getFollow_create());
			String expectResult=follow_Create.getExpectedResult(2);
			//System.out.print(actualResult);
			
			boolean value=actualResult.equals(expectResult);
			
			if(value==false) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println();
                System.out.println("================================================================");
                System.out.println("Execute Time: "+ df.format(new Date()));
                System.out.println("Test Class: "+ this.getClass().getName());
                System.out.println("Actual Result: "+ actualResult);
                System.out.println("================================================================");
                
            }
			
			assertTrue(value);
			
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	

}
