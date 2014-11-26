package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.message.BasicNameValuePair;

public class DoPostGroup {
	
	private List<NameValuePair> doPost;

	public List<NameValuePair> getDoPost() {
		return doPost;
	}
	
	
	//发帖
	public DoPostGroup(String uid,String password,String weiba_id) {
		doPost=new ArrayList<NameValuePair>();
		
		//定义Post参数
		doPost.add(new BasicNameValuePair("app","api"));
		doPost.add(new BasicNameValuePair("mod","group"));
		doPost.add(new BasicNameValuePair("act","doPost"));
		doPost.add(new BasicNameValuePair("uid",uid));
		doPost.add(new BasicNameValuePair("password",password));
		doPost.add(new BasicNameValuePair("weiba_id",weiba_id));
		doPost.add(new BasicNameValuePair("content","This is Test"));
		doPost.add(new BasicNameValuePair("title","Test Title"));
		
		//可选参数
		//doPost.add(new BasicNameValuePair("imgUrls",""));
	}
	
	public DoPostGroup(String uid,String password,String weiba_id, String title) {
		doPost=new ArrayList<NameValuePair>();
		
		doPost.add(new BasicNameValuePair("app","api"));
		doPost.add(new BasicNameValuePair("mod","group"));
		doPost.add(new BasicNameValuePair("act","doPost"));
		doPost.add(new BasicNameValuePair("uid",uid));
		doPost.add(new BasicNameValuePair("password",password));
		doPost.add(new BasicNameValuePair("weiba_id",weiba_id));
		doPost.add(new BasicNameValuePair("content","This is Test"));
		doPost.add(new BasicNameValuePair("title",title));
	}
	
	public DoPostGroup(String uid,String password,String weiba_id, String title, String images) {
		
		doPost=new ArrayList<NameValuePair>();
		
		doPost.add(new BasicNameValuePair("app","api"));
		doPost.add(new BasicNameValuePair("mod","group"));
		doPost.add(new BasicNameValuePair("act","doPost"));
		doPost.add(new BasicNameValuePair("uid",uid));
		doPost.add(new BasicNameValuePair("password",password));
		doPost.add(new BasicNameValuePair("weiba_id",weiba_id));
		doPost.add(new BasicNameValuePair("content","This is Test"));
		doPost.add(new BasicNameValuePair("title",title));
		doPost.add(new BasicNameValuePair("imgUrls", images));
	}
}
