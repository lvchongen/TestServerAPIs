package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoInBox;

public class DoInBoxTest {
	
	private String url;
	private NetworkService networkService;
	private DoInBox doInBox;
	private String uid,password;
	private int i=0;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
		doInBox=new DoInBox(uid,password);
		
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		doInBox=null;
		Thread.sleep(10000);
	}

	@Test
	public void test() {
		try {
			String actualString=networkService.sendPost(url, doInBox.getDoInBox());
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
			
			if(actualString!=null) {
				//System.out.print(actualString);
				boolean result1=actualString.contains("list_id");
				boolean result2=actualString.contains("member_uid");
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
			}
			if(actualString==null)
				assertTrue(true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
