package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class PostList {
	
	private List<NameValuePair> postList;

	public List<NameValuePair> getPostList() {
		return postList;
	}
	
	public PostList(String uid,String password,String weiba_id) {
		
		postList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		postList.add(new BasicNameValuePair("app","api"));
		postList.add(new BasicNameValuePair("mod","group"));
		postList.add(new BasicNameValuePair("act","postList"));
		postList.add(new BasicNameValuePair("uid",uid));
		postList.add(new BasicNameValuePair("password",password));
		postList.add(new BasicNameValuePair("weiba_id",weiba_id));
		postList.add(new BasicNameValuePair("page","1"));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
