package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class GetUnreadCount_Notify {
	
	private List<NameValuePair> unreadCount;

	public List<NameValuePair> getUnreadCount() {
		return unreadCount;
	}
	
	public GetUnreadCount_Notify() {
		unreadCount=new ArrayList<NameValuePair>();
		
		//定义Post参数
		unreadCount.add(new BasicNameValuePair("app","api"));
		unreadCount.add(new BasicNameValuePair("mod","Notify"));
		unreadCount.add(new BasicNameValuePair("act","getUnreadCount"));
		unreadCount.add(new BasicNameValuePair("uid","2949163"));
		unreadCount.add(new BasicNameValuePair("password","123456"));
		
		
		
	}
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
	
}
