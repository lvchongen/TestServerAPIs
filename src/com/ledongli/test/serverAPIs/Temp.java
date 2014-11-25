package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Temp {
	
	private List<NameValuePair> addReply;

	public List<NameValuePair> getAddReply() {
		return addReply;
	}
	
	public Temp() {
		
		addReply=new ArrayList<NameValuePair>(); 
		
		//定义Post参数
		addReply.add(new BasicNameValuePair("app","api"));
		addReply.add(new BasicNameValuePair("mod","group"));
		addReply.add(new BasicNameValuePair("act","addReply"));
		addReply.add(new BasicNameValuePair("uid","1"));
		addReply.add(new BasicNameValuePair("password","111"));
		addReply.add(new BasicNameValuePair("weiba_id",""));
		addReply.add(new BasicNameValuePair("post_id",""));
		addReply.add(new BasicNameValuePair("post_uid",""));
		addReply.add(new BasicNameValuePair("to_reply_id",""));
		addReply.add(new BasicNameValuePair("to_uid",""));
		addReply.add(new BasicNameValuePair("content",""));
		addReply.add(new BasicNameValuePair("imageUrls",""));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
