package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class PostDel {
	
	private List<NameValuePair> postDel;

	public List<NameValuePair> getPostDel() {
		return postDel;
	}
	
	public PostDel() {
		
		postDel=new ArrayList<NameValuePair>();
		
		//定义Post参数
		postDel.add(new BasicNameValuePair("app","api"));
		postDel.add(new BasicNameValuePair("mod","group"));
		postDel.add(new BasicNameValuePair("act","postDel"));
		postDel.add(new BasicNameValuePair("uid","1"));
		postDel.add(new BasicNameValuePair("password","111"));
		postDel.add(new BasicNameValuePair("post_id",""));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
