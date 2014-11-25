package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.IOException;

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
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		urlString=networkService.getServer_staging();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		doDelete=null;
		doPost=null;
	}

	//创建新帖子并删除
	@Test
	public void test() {
		try {
			doPost=new DoPost("2949163");
			String content=networkService.sendPost(urlString, doPost.getDoPost());		
			analyzeResult=new AnalyzeResult(content);
			String list_id=analyzeResult.getValue("list_id");
			doDelete=new DoDelete(list_id);
			String result=networkService.sendPost(urlString, doDelete.getDoDelete());
			
			assertEquals("{\"status\":1}", result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	//删除不存在的帖子
	@Test
	public void testNotExist() {
		try{
			doDelete=new DoDelete("");
			String actualResult=networkService.sendPost(urlString, doDelete.getDoDelete());
			//System.out.print(actualResult);
			assertEquals("{\"status\":0}", actualResult);
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}
 	
	
}
