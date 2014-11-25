package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	
	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		doPostGroup=null;
		replyList=null;
		analyzeResult=null;
		postList=null;
	}
	
	
	//发帖，获取回复， 验证回复数字为0
	@Test
	public void testReplyNull() {
		try {
			//发帖
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			doPostGroup=new DoPostGroup("1000075",timeStamp);
			String postGroupResult=networkService.sendPost(url, doPostGroup.getDoPost());
			
			//获取回复列表
			postList=new PostList("1000075");
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
				if(post_uid.equals("2949163") && title.equals(timeStamp)) {
					post_id=obj.getString("post_id");
					break;
				}
				
			}
			
			//获取回复列表
			replyList=new GetReplyList(post_id, "1000075");
			String result=networkService.sendPost(url, replyList.getReplyList());
			System.out.print(result);
			boolean value=result.contains("\"status\":1") && result.contains("\"reply_count\":\"0\"");
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
