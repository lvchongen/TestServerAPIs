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
import com.ledongli.test.serverAPIs.DoDelete;
import com.ledongli.test.serverAPIs.DoPost;

public class DoDeleteTest {
	
	private NetworkService networkService;
	private DoDelete doDelete;
	private DoPost doPost;
	private String urlString;
	private AnalyzeResult analyzeResult;
	private String uid,password;
	private int i=0;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		urlString=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		doDelete=null;
		doPost=null;
		Thread.sleep(10000);
	}

	//���������Ӳ�ɾ��
	@Test
	public void test()  {
		try {
				doPost=new DoPost(uid,password,uid);
				String content=networkService.sendPost(urlString, doPost.getDoPost());		
				analyzeResult=new AnalyzeResult(content);
				String list_id=analyzeResult.getValue("list_id");
				doDelete=new DoDelete(uid,password,list_id);
				String result=networkService.sendPost(urlString, doDelete.getDoDelete());
				
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
				
				boolean value=result.contains("{\"status\":1}");
				
				if(value==false) {
	                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                System.out.println();
	                System.out.println("================================================================");
	                System.out.println("Execute Time: "+ df.format(new Date()));
	                System.out.println("Test Class: "+ this.getClass().getName());
	                System.out.println("Actual Result: "+ result);
	                System.out.println("================================================================");
	                
	            }
				
				assertTrue(value);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	//ɾ�������ڵ�����
	@Test
	public void testNotExist() {
		try{
			doDelete=new DoDelete(uid,password,"");
			String actualResult=networkService.sendPost(urlString, doDelete.getDoDelete());
			
			while(i<3) {
		        if(actualResult.contains("time out")) {
		          i++;
		          Thread.sleep(3000);
		          testNotExist();
		        }
		        else {
		          break;
		        }
		      }
			
			boolean value=actualResult.equals("{\"status\":0}");
			
			if(value==false) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println();
                System.out.println("================================================================");
                System.out.println("Execute Time: "+ df.format(new Date()));
                System.out.println("Test Class: "+ this.getClass().getName());
                System.out.println("Server IP: "+ urlString);
                System.out.println("uid: "+uid);
                System.out.println("password: "+password);
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
