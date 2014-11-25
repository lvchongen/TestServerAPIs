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
	
	public DelReply() {
		
		delReply=new ArrayList<NameValuePair>();
		
		//定义Post参数
		delReply.add(new BasicNameValuePair("app","api"));
		delReply.add(new BasicNameValuePair("mod","group"));
		delReply.add(new BasicNameValuePair("act","delReply"));
		delReply.add(new BasicNameValuePair("uid","1"));
		delReply.add(new BasicNameValuePair("password","111"));
		delReply.add(new BasicNameValuePair("widget_appname",""));
		delReply.add(new BasicNameValuePair("reply_id",""));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
	
}
