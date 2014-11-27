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
import com.ledongli.test.serverAPIs.Follow_Destory;

public class FollowDestoryTest {
	
	private NetworkService networkService;
	private String url;
	private Follow_Destory follow_Destory;
	private Follow_Create follow_Create;
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
		follow_Destory=null;
		Thread.sleep(10000);
	}
	
	//关注用户uid5， 然后取消关注
	@Test
	public void testDestoryOtherPeople() {
		try {
			follow_Create=new Follow_Create(uid,password,"5");
			follow_Destory=new Follow_Destory(uid,password,"5");
			
			String temp=networkService.sendPost(url, follow_Create.getFollow_create());
			//System.out.print(temp);
			String actualResult=networkService.sendPost(url, follow_Destory.getFollow_destory());
			while(i<3) {
		        if(actualResult.contains("time out")) {
		          i++;
		          Thread.sleep(3000);
		          testDestoryOtherPeople();
		        }
		        else {
		          break;
		        }
		      }
			String expectResult=follow_Destory.getExpectedResult(1);
			//System.out.print(actualResult);
			boolean value=actualResult.equals(expectResult);
			
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
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
//	//关注自己， 然后取消关注
//	@Test
//	public void testDestoryMyself() {
//		try{
//			follow_Create=new Follow_Create("2949163");
//			follow_Destory=new Follow_Destory("2949163");
//			String actualResult=networkService.sendPost(url, follow_Destory.getFollow_destory());
//			System.out.print(actualResult);
//			String expectedResult=follow_Destory.getExpectedResult(2);
//			assertEquals(expectedResult, actualResult);
//		}
//		catch(Exception e) {
//			fail(e.getMessage());
//		}
//	}

}
