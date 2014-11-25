package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class PostDetail {
	
	private List<NameValuePair> postDetail;

	public List<NameValuePair> getPostDetail() {
		return postDetail;
	}
	
	public PostDetail() {
		
		postDetail=new ArrayList<NameValuePair>();
		
		//定义Post参数
		postDetail.add(new BasicNameValuePair("app","api"));
		postDetail.add(new BasicNameValuePair("mod","group"));
		postDetail.add(new BasicNameValuePair("act","postDetail"));
		postDetail.add(new BasicNameValuePair("uid","1"));
		postDetail.add(new BasicNameValuePair("password","111"));
		postDetail.add(new BasicNameValuePair("post_id",""));
		postDetail.add(new BasicNameValuePair("weiba_id",""));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
	
}
