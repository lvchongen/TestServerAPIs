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
import com.ledongli.test.serverAPIs.DoPostGroup;
import com.ledongli.test.serverAPIs.GetReplyList;
import com.ledongli.test.serverAPIs.PostDel;
import com.ledongli.test.serverAPIs.PostList;

public class PostDelTest {

	private PostDel postDel;
	private NetworkService networkService;
	private String url;
	private DoPostGroup doPostGroup;
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
		postDel=null;
		analyzeResult=null;
		postList=null;
		Thread.sleep(10000);
	}

	
	//发帖，删帖， 验证删帖成功
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
			
			//删帖, 验证条件1， json结构返回success：1 
			postDel=new PostDel(uid,password,post_id);
			String result=networkService.sendPost(url, postDel.getPostDel());
			boolean value1=result.contains("\"status\":1");
			
			//验证条件二， 返回postList 中不存在对应post_id
			//获取回复列表
			postList=new PostList(uid,password,weiba_id);
			postListResult=networkService.sendPost(url, postList.getPostList());
			
			//验证post_id 不存在
			//解析Post_id
			analyzeResult=new AnalyzeResult(postListResult);
			firstLevel=analyzeResult.getJSON("data");
			secondLevel=firstLevel.getJSONArray("data");
			length=secondLevel.length();
			boolean value2=true;
			
			for(int i=0;i<length;i++) {
				JSONObject obj=secondLevel.getJSONObject(i);
				String post_id_temp=obj.getString("post_id");
				if(post_id_temp.equals(post_id)) {
					value2=false;
					break;
				}
				
			}
			
			boolean value=value1 && value2 ;
			
			if(value==false) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println();
                System.out.println("================================================================");
                System.out.println("Execute Time: "+ df.format(new Date()));
                System.out.println("Test Class: "+ this.getClass().getName());
                System.out.println("Server IP: "+ url);
                System.out.println("uid: "+uid);
                System.out.println("password: "+password);
                System.out.println("Actual Result: "+ secondLevel);
                System.out.println("================================================================");
                
            }
			
			assertTrue(value);
			
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
