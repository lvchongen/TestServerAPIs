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
import com.ledongli.test.serverAPIs.DoPost;
import com.ledongli.test.serverAPIs.GetMessageByListId;

public class GetMessageByListidTest {
	
	private NetworkService networkService;
	private DoPost doPost;
	private GetMessageByListId getMessageByListId;
	private String url;
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
		doPost=null;
		networkService=null;
		Thread.sleep(10000);
	}

	
	//发帖后获取listID， 查询是否包含listID
	@Test
	public void test() {
		try {
			doPost=new DoPost(uid,password,uid);
			String postResult=networkService.sendPost(url, doPost.getDoPost());
			//System.out.print(postResult);
			analyzeResult=new AnalyzeResult(postResult);
			String list_id=analyzeResult.getValue("list_id");
			String message_id=analyzeResult.getValue("message_id");
			//System.out.print(message_id);
			getMessageByListId=new GetMessageByListId(uid,password,list_id);
			String actualResult=networkService.sendPost(url, getMessageByListId.getMessageByListId());
			boolean result=actualResult.contains(message_id)&&actualResult.contains(list_id);
			
			if(result==false) {
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
			
			assertTrue(result);
			
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
