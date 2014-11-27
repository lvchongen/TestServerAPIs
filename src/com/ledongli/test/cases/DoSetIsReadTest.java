package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.AnalyzeResult;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoReplay;
import com.ledongli.test.serverAPIs.DoSetIsRead;

public class DoSetIsReadTest {
	
	private NetworkService networkService;
	private String url;
	private DoSetIsRead doSetIsRead;
	private String uid,password;
	private int i=0;
	
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
		doSetIsRead=new DoSetIsRead(uid,password);
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		doSetIsRead=null;
		Thread.sleep(10000);
	}

	@Test
	public void test() {
		try {
			String actualString=networkService.sendPost(url, doSetIsRead.getDoSetIsRead());
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
//			System.out.print(actualString);
			boolean result=false;
			if(actualString.contains("{\"status\":1}"))
				result=true;
			
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
