package com.ledongli.test.cases;

import static org.junit.Assert.*;

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
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		postList=null;
	}
	
	//获取圈子帖子列表
	@Test
	public void test() {
		try{
			postList=new PostList("1000075");
			String actualResult=networkService.sendPost(url, postList.getPostList());
			System.out.print(actualResult);
			boolean result=actualResult.contains("\"status\":1");
			assertTrue(result);
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
		
	}

}
