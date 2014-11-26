package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.entity.mime.content.FileBody;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ledongli.test.common.AnalyzeResult;
import com.ledongli.test.common.NetworkService;
import com.ledongli.test.serverAPIs.DoPostEdit;
import com.ledongli.test.serverAPIs.DoPostGroup;
import com.ledongli.test.serverAPIs.GetEditorImg;
import com.ledongli.test.serverAPIs.PostList;
import com.ledongli.test.serverAPIs.SaveEditorImg;

public class GetEditorImgTest {

	private String url;
	private NetworkService networkService;
	private GetEditorImg editorImg;
	private PostList postList;
	private DoPostGroup doPostGroup;
	private String filePath;
	private FileBody fileBody;
	private AnalyzeResult analyzeResult;
	private SaveEditorImg saveEditorImg;
	private String uid,password,weiba_id;
	
	@Before
	public void setUp() {
		//filePath="Images/LessImg.png";
		filePath="Images/OK.gif";
		networkService=new NetworkService();
		url=networkService.getServer_IP();
		uid=networkService.getUid();
		password=networkService.getPassword();
		weiba_id=networkService.getWeiba_id();
		try{
			fileBody=new FileBody(new File(filePath));
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		editorImg=null;
		postList=null;
		doPostGroup=null;
		fileBody=null;	
		Thread.sleep(10000);
	}

	
	//发送帖子， 上传照片， 获取post_id, weiba_id， 获取图片
	@Test
	public void test() {
		try{
			
			//上传图片
			fileBody=new FileBody(new File(filePath));
			saveEditorImg=new SaveEditorImg(uid,password,fileBody);
			String saveImgResult=networkService.sendPostStream(url, saveEditorImg.getSaveEditorImg());
			
			//解析图片URL
			analyzeResult=new AnalyzeResult(saveImgResult);
			String imageUrl=analyzeResult.getUrl("data");
			//System.out.print(imageUrl);
			
			//发帖
			String imagesUrl="{\"image1\":\"" + imageUrl + "\"}";
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			doPostGroup=new DoPostGroup(uid,password,weiba_id,timeStamp,imagesUrl);
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
			
			//获取帖子图片
			editorImg=new GetEditorImg(uid,password,weiba_id, post_id);
			String result=networkService.sendPost(url, editorImg.getEditorImg());
			boolean value=result.contains("\"status\":1");
			
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
	
	
	
	

}
