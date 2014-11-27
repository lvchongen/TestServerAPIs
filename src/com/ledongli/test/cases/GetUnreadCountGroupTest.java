package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.GetUnreadCount_group;

public class GetUnreadCountGroupTest {

	private NetworkService networkService;
	private String url;
	private GetUnreadCount_group count_group;
	private String uid,password;
	private int i=0;

	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
		count_group=new GetUnreadCount_group(uid,password);
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		count_group=null;
		Thread.sleep(10000);
	}

	@Test
	public void test() {
		
		try {
			String result=networkService.sendPost(url, count_group.getUnreadCount());
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
			boolean value=result.contains("\"status\":1") && result.contains("unread_comment") && result.contains("new_applicant_count");
			
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
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
