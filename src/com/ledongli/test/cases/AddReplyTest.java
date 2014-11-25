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
import com.ledongli.test.serverAPIs.PostList;

public class AddReplyTest {

	private NetworkService networkService;
	private String url;
	private DoPostGroup doPostGroup;
	private AddReply addReply;
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
		addReply=null;
		analyzeResult=null;
		postList=null;
	}
	
	//验证发帖后， 回复楼主
	@Test
	public void testReplyOwner() {
		
		try{
			
			//发帖
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			doPostGroup=new DoPostGroup("1000075",timeStamp);
			String postGroupResult=networkService.sendPost(url, doPostGroup.getDoPost());
			
			//获取回复列表
			postList=new PostList("1000075");
			String postListResult=networkService.sendPost(url, postList.getPostList());
			
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
			
			String weiba_id="1000075";
			String content="This is testing for replying";
			String post_uid="2949163";
			
			addReply=new AddReply(weiba_id, post_id, post_uid, content);
			String result=networkService.sendPost(url, addReply.getAddReply());
			System.out.print(result);
			boolean value=result.contains("\\u8bc4\\u8bba\\u6210\\u529f");
			assertTrue(value);
			
			
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}

}
