package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class GetUnreadCount_Message {
	
private List<NameValuePair> unReadCount;
	
	public List<NameValuePair> getUnReadCount() {
		return unReadCount;
	}

	public GetUnreadCount_Message() {
		
		unReadCount=new ArrayList<NameValuePair>();
		
		//定义Post参数
		unReadCount.add(new BasicNameValuePair("app","api"));
		unReadCount.add(new BasicNameValuePair("mod","Message"));
		unReadCount.add(new BasicNameValuePair("act","getUnreadCount"));
		unReadCount.add(new BasicNameValuePair("uid","2949163"));
		unReadCount.add(new BasicNameValuePair("password","123456"));
	}
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
}
