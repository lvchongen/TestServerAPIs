package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sound.sampled.Port;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.PostList;

public class PostListTest {

	private PostList postList;
	private String url;
	private NetworkService networkService;
	private String uid,password,weiba_id;
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
		weiba_id=networkService.getWeiba_id();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		postList=null;
		Thread.sleep(10000);
	}
	
	//获取圈子帖子列表
	@Test
	public void test() {
		try{
			postList=new PostList(uid,password,weiba_id);
			String actualResult=networkService.sendPost(url, postList.getPostList());
			boolean result=actualResult.contains("\"status\":1");
			
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
