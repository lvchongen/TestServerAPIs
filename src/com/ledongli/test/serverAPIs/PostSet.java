package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class PostSet {
	
	private List<NameValuePair> postSet;

	public List<NameValuePair> getPostSet() {
		return postSet;
	}
	
	public PostSet() {
		
		postSet=new ArrayList<NameValuePair>();
		
		//定义Post参数
		postSet.add(new BasicNameValuePair("app","api"));
		postSet.add(new BasicNameValuePair("mod","group"));
		postSet.add(new BasicNameValuePair("act","postSet"));
		postSet.add(new BasicNameValuePair("uid","1"));
		postSet.add(new BasicNameValuePair("password","111"));
		postSet.add(new BasicNameValuePair("post_id",""));
		postSet.add(new BasicNameValuePair("currentValue",""));
		postSet.add(new BasicNameValuePair("targetValue",""));
		postSet.add(new BasicNameValuePair("type",""));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
