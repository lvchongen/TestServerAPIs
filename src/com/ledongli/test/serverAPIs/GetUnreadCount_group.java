package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class GetUnreadCount_group {
	
	private List<NameValuePair> unreadCount;

	public List<NameValuePair> getUnreadCount() {
		return unreadCount;
	}
	
	public GetUnreadCount_group(String uid,String password) {
		
		unreadCount=new ArrayList<NameValuePair>();
		
		//定义Post参数
		unreadCount.add(new BasicNameValuePair("app","api"));
		unreadCount.add(new BasicNameValuePair("mod","group"));
		unreadCount.add(new BasicNameValuePair("act","getUnreadCount"));
		unreadCount.add(new BasicNameValuePair("uid",uid));
		unreadCount.add(new BasicNameValuePair("password",password));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
