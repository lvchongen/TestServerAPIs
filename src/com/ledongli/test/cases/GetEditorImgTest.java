package com.ledongli.test.cases;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

	@Before
	public void setUp() {
		//filePath="Images/LessImg.png";
		filePath="Images/OK.gif";
		networkService=new NetworkService();
		url=networkService.getServer_staging();
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
	}

	
	//�������ӣ� �ϴ���Ƭ�� ��ȡpost_id, weiba_id�� ��ȡͼƬ
	@Test
	public void test() {
		try{
			
			//�ϴ�ͼƬ
			fileBody=new FileBody(new File(filePath));
			saveEditorImg=new SaveEditorImg(fileBody);
			String saveImgResult=networkService.sendPostStream(url, saveEditorImg.getSaveEditorImg());
			
			//����ͼƬURL
			analyzeResult=new AnalyzeResult(saveImgResult);
			String imageUrl=analyzeResult.getUrl("data");
			//System.out.print(imageUrl);
			
			//����
			String imagesUrl="{\"image1\":\"" + imageUrl + "\"}";
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			doPostGroup=new DoPostGroup("1000075",timeStamp,imagesUrl);
			String postGroupResult=networkService.sendPost(url, doPostGroup.getDoPost());
			
			//��ȡ�ظ��б�
			postList=new PostList("1000075");
			String postListResult=networkService.sendPost(url, postList.getPostList());
			
			//�������
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
			
			//��ȡ����ͼƬ
			editorImg=new GetEditorImg("1000075", post_id);
			String result=networkService.sendPost(url, editorImg.getEditorImg());
			System.out.print(result);
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	
	

}
