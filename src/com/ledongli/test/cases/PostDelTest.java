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

	@Before
	public void setUp() throws Exception {
		networkService=new NetworkService();
		url=networkService.getServer_staging();
	}

	@After
	public void tearDown() throws Exception {
		networkService=null;
		doPostGroup=null;
		postDel=null;
		analyzeResult=null;
		postList=null;
	}

	
	//������ɾ���� ��֤ɾ���ɹ�
	@Test
	public void test() {
		
		try{
			//����
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			doPostGroup=new DoPostGroup("1000075",timeStamp);
			String postGroupResult=networkService.sendPost(url, doPostGroup.getDoPost());
			
			//��ȡ�ظ��б�
			postList=new PostList("1000075");
			String postListResult=networkService.sendPost(url, postList.getPostList());
			
			//����Post_id
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
			
			//ɾ��, ��֤����1�� json�ṹ����success��1 
			postDel=new PostDel(post_id);
			String result=networkService.sendPost(url, postDel.getPostDel());
			boolean value1=result.contains("\"status\":1");
			
			//��֤�������� ����postList �в����ڶ�Ӧpost_id
			//��ȡ�ظ��б�
			postList=new PostList("1000075");
			postListResult=networkService.sendPost(url, postList.getPostList());
			
			//��֤post_id ������
			//����Post_id
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
			assertTrue(value);
			
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
