package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Follow_destory_reverse {
	
	private List<NameValuePair> follow_destory_reverse;

	public List<NameValuePair> getFollow_destory_reverse() {
		return follow_destory_reverse;
	}
	
	public Follow_destory_reverse() {
		
		follow_destory_reverse=new ArrayList<NameValuePair>();
		
		//定义Post参数
		follow_destory_reverse.add(new BasicNameValuePair("app","api"));
		follow_destory_reverse.add(new BasicNameValuePair("mod","user"));
		follow_destory_reverse.add(new BasicNameValuePair("act","follow_destroy_reverse"));
		follow_destory_reverse.add(new BasicNameValuePair("uid","1"));
		follow_destory_reverse.add(new BasicNameValuePair("password","111"));
		follow_destory_reverse.add(new BasicNameValuePair("user_id",""));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
