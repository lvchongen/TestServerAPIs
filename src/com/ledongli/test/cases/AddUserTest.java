package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.AddUser;

public class AddUserTest {
	
	NetworkService networkService;
	String url;
	AddUser addUser;
	int i=0;
	
	
	@Before
	public void setUp() throws Exception {
		
		networkService=new NetworkService();
		url=networkService.getServerIO_IP();
		addUser=new AddUser();
		
	}

	@After
	public void tearDown() throws Exception {
		
		networkService=null;
		addUser=null;
		Thread.sleep(10000);
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, addUser.getAddUser());
			
			while(i<3) {
		        if(result.contains("time out")) {
		          i++;
		          Thread.sleep(3000);
		          test();
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
				System.out.print("IOS_APN_token: "+addUser.getIOS_APN_token());
                System.out.println();
				System.out.println("================================================================");
				
			}
			
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
