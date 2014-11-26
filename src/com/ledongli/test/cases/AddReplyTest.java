package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.rmi.server.UID;
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
import com.ledongli.test.serverAPIs.PostList;

public class AddReplyTest {

	private NetworkService networkService;
	private String url;
	private DoPostGroup doPostGroup;
	private AddReply addReply;
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
		addReply=null;
		analyzeResult=null;
		postList=null;
		Thread.sleep(10000);
	}
	
	//验证发帖后， 回复楼主
	@Test
	public void testReplyOwner() {
		
		try{
			
			//发帖
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			doPostGroup=new DoPostGroup(uid,password,weiba_id,timeStamp);
			String postGroupResult=networkService.sendPost(url, doPostGroup.getDoPost());
			
			//获取回复列表
			postList=new PostList(uid,password,weiba_id);
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
				if(post_uid.equals(uid) && title.equals(timeStamp)) {
					post_id=obj.getString("post_id");
					break;
				}
				
			}
			
			
			String content="This is testing for replying"+timeStamp;
			String post_uid=uid;
			
			addReply=new AddReply(uid,password,weiba_id, post_id, post_uid, content);
			String result=networkService.sendPost(url, addReply.getAddReply());
			//System.out.print(result);
			boolean value1=result.contains("\\u8bc4\\u8bba\\u6210\\u529f");
			boolean value2=result.contains("too frequent");
			boolean value=value1 || value2;
			
            if(value==false) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println();
                System.out.println("================================================================");
                System.out.println("Execute Time: "+ df.format(new Date()));
                System.out.println("Test Class: "+ this.getClass().getName());
                System.out.println("Actual Result: "+ result);
                System.out.println("Server IP: "+ url);
                System.out.println("uid: "+uid);
                System.out.println("password: "+password);
                System.out.println("================================================================");
                
            }
			
			assertTrue(value);
			
			
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}

}
