package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.GetUnreadCount_Notify;

public class GetUnreadCountNotifyTest {
	
	private NetworkService networkService;
	private String url;
	private GetUnreadCount_Notify getUnreadCount_Notify;
	private String uid,password;
	
	@Before
	public void setUp() {
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
		getUnreadCount_Notify=new GetUnreadCount_Notify(uid,password);
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		getUnreadCount_Notify=null;
		Thread.sleep(10000);
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, getUnreadCount_Notify.getUnreadCount());
			
			boolean value=result.contains("\"status\":1")&&result.contains("count");
			
			if(value==false) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println();
                System.out.println("================================================================");
                System.out.println("Execute Time: "+ df.format(new Date()));
                System.out.println("Test Class: "+ this.getClass().getName());
                System.out.println("Server IP: "+ url);
                System.out.println("uid: "+uid);
                System.out.println("password: "+password);
                System.out.println("Actual Result: "+ result);
                System.out.println("================================================================");
                
            }
			
			assertTrue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
