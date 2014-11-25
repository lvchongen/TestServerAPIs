package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.AddUser;

public class AddUserTest {
	
	NetworkService networkService;
	String url;
	AddUser addUser;
	
	
	@Before
	public void setUp() throws Exception {
		
		networkService=new NetworkService();
		url=networkService.getServer_io_staging();
		addUser=new AddUser();
		
	}

	@After
	public void tearDown() throws Exception {
		
		networkService=null;
		addUser=null;
		
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, addUser.getAddUser());
			System.out.print(result);
			boolean value=result.contains("\"status\":\"OK\"");
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
