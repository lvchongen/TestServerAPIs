package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoReplay;

public class DoReplyTest {
	
	private NetworkService networkService;
	private String url;
	private DoReplay doReply;
	private String uid,password;
	
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
		doReply=null;
		Thread.sleep(10000);
	}

	@Test
	public void test() {
		try {
			doReply=new DoReplay(uid,password,uid);
			String actualString=networkService.sendPost(url, doReply.getDoReplay());
			boolean result=actualString.contains("\\u79c1\\u4fe1\\u53d1\\u9001\\u6210\\u529f");
			
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	
	 
}
