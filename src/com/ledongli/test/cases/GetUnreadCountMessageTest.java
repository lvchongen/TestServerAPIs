package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.GetUnreadCount_Message;

public class GetUnreadCountMessageTest {
	
	private GetUnreadCount_Message getUnreadCount_Message;
	private NetworkService networkService;
	private String url;
	private String uid,password;
	private int i=0;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
		getUnreadCount_Message=new GetUnreadCount_Message(uid,password);
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		getUnreadCount_Message=null;
		Thread.sleep(10000);
	}

	@Test
	public void test() {
		try {
			String actualString=networkService.sendPost(url, getUnreadCount_Message.getUnReadCount());
			while(i<3) {
		        if(actualString.contains("time out")) {
		          i++;
		          Thread.sleep(3000);
		          test();
		        }
		        else {
		          break;
		        }
		      }
			boolean result1=actualString.contains("unread_comment");
			boolean result2=actualString.contains(("new_applicant_count"));
			boolean result=result1&&result2;
			
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
		}
	}

}
