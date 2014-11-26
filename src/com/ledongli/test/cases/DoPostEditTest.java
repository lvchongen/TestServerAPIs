package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.AnalyzeResult;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoPostEdit;
import com.ledongli.test.serverAPIs.DoPostGroup;
import com.ledongli.test.serverAPIs.PostList;

public class DoPostEditTest {

	private NetworkService networkService;
	private DoPostGroup doPostGroup;
	private DoPostEdit doPostEdit;
	private PostList postList;
	private String url;
	private AnalyzeResult analyzeResult;
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
		doPostEdit=null;
		doPostGroup=null;
		Thread.sleep(10000);
	}

	//发帖后， 获取post_id, 修改帖子， 验证结果
	@Test
	public void test() {
		try{
			//发帖
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			doPostGroup=new DoPostGroup(uid,password,weiba_id,timeStamp);
			String postGroupResult=networkService.sendPost(url, doPostGroup.getDoPost());
			
			//获取回复列表
			postList=new PostList(uid,password,weiba_id);
			String postListResult=networkService.sendPost(url, postList.getPostList());
			
			//解析结果
			analyzeResult=new AnalyzeResult(postListResult);
			JSONObject firstLevel=analyzeResult.getJSON("data");
			JSONArray secondLevel=firstLevel.getJSONArray("data");
			int length=secondLevel.length();
			String post_id=null;
			
			for(int i=0;i<length;i++) {
				JSONObject obj=secondLevel.getJSONObject(i);
				String post_uid=obj.getString("post_uid");
				String title=obj.getString("title");
				if(post_uid.equals(uid) && title.equals(timeStamp)) {
					post_id=obj.getString("post_id");
					break;
				}
				
			}
			
			doPostEdit= new DoPostEdit(uid,password,weiba_id, post_id);
			String actualResult=networkService.sendPost(url, doPostEdit.getDoPostEdit());
			boolean value=actualResult.contains("{\"status\":1,\"data\":\"success\"}");
			
			if(value==false) {
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
			
			assertTrue(value);
			
			
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
