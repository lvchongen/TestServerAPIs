package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.AnalyzeResult;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoDetail;
import com.ledongli.test.serverAPIs.DoPost;

public class DoDetailTest {

	private NetworkService networkService;
	private String url;
	private DoDetail doDetail;
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
		networkService = null;
		doDetail=null;
		doPost=null;
		Thread.sleep(10000);
	}

	
	//发送私信， 再获取私信的内容
	@Test
	public void test() {
		try{
			doPost=new DoPost(uid,password,uid);
			String postResult=networkService.sendPost(url, doPost.getDoPost());
			//System.out.print(postResult);
			analyzeResult=new AnalyzeResult(postResult);
			String list_id=analyzeResult.getValue("list_id");
			String message_id=analyzeResult.getValue("message_id");
			//System.out.print(list_id);
			//System.out.print(message_id);
			
			doDetail=new DoDetail(uid,password,list_id);
			String result=networkService.sendPost(url, doDetail.getDoDetail());
			//System.out.print(result);
			boolean value=result.contains(list_id)&&result.contains(uid);
			
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
