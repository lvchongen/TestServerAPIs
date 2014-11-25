package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class DelReply {
	
	private List<NameValuePair> delReply;

	public List<NameValuePair> getDelReply() {
		return delReply;
	}
	
	public DelReply(String reply_id) {
		
		delReply=new ArrayList<NameValuePair>();
		
		//定义Post参数
		delReply.add(new BasicNameValuePair("app","api"));
		delReply.add(new BasicNameValuePair("mod","group"));
		delReply.add(new BasicNameValuePair("act","delReply"));
		delReply.add(new BasicNameValuePair("uid","2949163"));
		delReply.add(new BasicNameValuePair("password","123456"));
		delReply.add(new BasicNameValuePair("widget_appname","weiba"));
		delReply.add(new BasicNameValuePair("reply_id",reply_id));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
	
}
