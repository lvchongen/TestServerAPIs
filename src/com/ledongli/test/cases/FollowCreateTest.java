package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Follow_Create;

public class FollowCreateTest {
	
	
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
		follow_Create=null;
		networkService=null;
	}

	//测试关注其他用户
	@Test
	public void testFollowOtherPeople() {
		try {
			follow_Create=new Follow_Create("2");
			String actualResult=networkService.sendPost(url, follow_Create.getFollow_create());
			String expectResult=follow_Create.getExpectedResult(1);
			System.out.print(actualResult);
			assertEquals(expectResult, actualResult);
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
		
	}
	
	//测试关注自己
	@Test
	public void testFollowMyself() {
		try{
			follow_Create=new Follow_Create("2949163");
			String actualResult=networkService.sendPost(url, follow_Create.getFollow_create());
			String expectResult=follow_Create.getExpectedResult(2);
			System.out.print(actualResult);
			assertEquals(expectResult, actualResult);
			
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	

}
