package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.AnalyzeResult;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoDeleteSession;
import com.ledongli.test.serverAPIs.DoPost;

public class DoDeleteSessionTest {

	private String url;
	private DoDeleteSession doDeleteSession;
	private NetworkService networkService;
	private DoPost doPost;
	private AnalyzeResult analyzeResult;
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
		doDeleteSession=null;
		Thread.sleep(10000);
	}
	
	
	//测试删除不存在的session
	@Test
	public void testNotExistSession() {
		try {
			doDeleteSession=new DoDeleteSession(uid,password,"2783");
			String actualResult=networkService.sendPost(url, doDeleteSession.getDoDeleteSession());
			boolean value=actualResult.contains("\"status\":0");
			
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
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}
	
	//发消息后，删除私信
	@Test
	public void testExistSession() {
		try {
			doPost=new DoPost(uid,password,uid);
			String postResult=networkService.sendPost(url, doPost.getDoPost());
			analyzeResult=new AnalyzeResult(postResult);
			String list_id=analyzeResult.getValue("list_id");
			String message_id=analyzeResult.getValue("message_id");
			
			doDeleteSession=new DoDeleteSession(uid,password,message_id);
			String actualResult=networkService.sendPost(url, doDeleteSession.getDoDeleteSession());
			boolean value=actualResult.contains("{\"status\":1}");
			
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
