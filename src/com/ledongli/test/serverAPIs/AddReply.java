package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class AddReply {
	
	private List<NameValuePair> addReply;

	public List<NameValuePair> getAddReply() {
		return addReply;
	}
	
	public AddReply(String weiba_id, String post_id, String post_uid,String content) {
		
		addReply=new ArrayList<NameValuePair>(); 
		
		//定义Post参数
		addReply.add(new BasicNameValuePair("app","api"));
		addReply.add(new BasicNameValuePair("mod","group"));
		addReply.add(new BasicNameValuePair("act","addReply"));
		addReply.add(new BasicNameValuePair("uid","2949163"));
		addReply.add(new BasicNameValuePair("password","123456"));
		addReply.add(new BasicNameValuePair("weiba_id",weiba_id));
		addReply.add(new BasicNameValuePair("post_id",post_id));
		addReply.add(new BasicNameValuePair("post_uid",post_uid));
		addReply.add(new BasicNameValuePair("to_reply_id","0"));
		addReply.add(new BasicNameValuePair("to_uid","0"));
		addReply.add(new BasicNameValuePair("content",content));
		//addReply.add(new BasicNameValuePair("imageUrls",""));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
