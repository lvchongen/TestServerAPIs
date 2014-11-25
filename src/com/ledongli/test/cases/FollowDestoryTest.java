package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

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
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
		
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		follow_Destory=null;
	}
	
	//��ע�û�uid5�� Ȼ��ȡ����ע
	@Test
	public void testDestoryOtherPeople() {
		try {
			follow_Create=new Follow_Create("5");
			follow_Destory=new Follow_Destory("5");
			
			String temp=networkService.sendPost(url, follow_Create.getFollow_create());
			//System.out.print(temp);
			String actualResult=networkService.sendPost(url, follow_Destory.getFollow_destory());
			String expectResult=follow_Destory.getExpectedResult(1);
			//System.out.print(actualResult);
			assertEquals(expectResult, actualResult);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	//��ע�Լ��� Ȼ��ȡ����ע
	@Test
	public void testDestoryMyself() {
		try{
			follow_Create=new Follow_Create("2949163");
			follow_Destory=new Follow_Destory("2949163");
			String actualResult=networkService.sendPost(url, follow_Destory.getFollow_destory());
			System.out.print(actualResult);
			String expectedResult=follow_Destory.getExpectedResult(2);
			assertEquals(expectedResult, actualResult);
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
