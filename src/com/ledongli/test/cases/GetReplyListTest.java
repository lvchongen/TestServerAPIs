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
import com.ledongli.test.serverAPIs.AddReply;
import com.ledongli.test.serverAPIs.DoPostGroup;
import com.ledongli.test.serverAPIs.GetReplyList;
import com.ledongli.test.serverAPIs.PostList;

public class GetReplyListTest {

	private NetworkService networkService;
	private String url;
	private DoPostGroup doPostGroup;
	private GetReplyList replyList;
	private AnalyzeResult analyzeResult;
	private PostList postList;
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
		doPostGroup=null;
		replyList=null;
		analyzeResult=null;
		postList=null;
		Thread.sleep(10000);
	}
	
	
	//发帖，获取回复， 验证回复数字为0
	@Test
	public void testReplyNull() {
		try {
			//发帖
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			doPostGroup=new DoPostGroup(uid,password,weiba_id,timeStamp);
			String postGroupResult=networkService.sendPost(url, doPostGroup.getDoPost());
			
			//获取回复列表
			postList=new PostList(uid,password,weiba_id);
			String postListResult=networkService.sendPost(url, postList.getPostList());
			
			//解析Post_id
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
			
			//获取回复列表
			replyList=new GetReplyList(uid,password,post_id, weiba_id);
			String result=networkService.sendPost(url, replyList.getReplyList());
			boolean value=result.contains("\"status\":1") && result.contains("\"reply_count\":\"0\"");
			
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
	
	//发帖， 回复， 获取回复数字为1， 因回复会返回"too frequent"， 暂未实现该case
	public void testReplyNotNull() {
		
	}

}
