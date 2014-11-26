package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.Getnotify;

public class GetnotifyTest {
	
	private NetworkService networkService;
	private String url;
	private Getnotify getnotify;
	private String uid,password;
	
	@Before
	public void setUp() throws Exception {
		
		networkService=new NetworkService();
		url=networkService.getServerIO_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
		getnotify=new Getnotify(uid,password);
	}

	@After
	public void tearDown() throws Exception {
		getnotify=null;
		networkService=null;
		Thread.sleep(10000);
	}

	@Test
	public void test() {
		try {
			String result=networkService.sendPost(url, getnotify.getNotiList());
			boolean value=result.contains("\"status\":\"OK\"");
			
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
			e.getMessage();
		}
	}

}
