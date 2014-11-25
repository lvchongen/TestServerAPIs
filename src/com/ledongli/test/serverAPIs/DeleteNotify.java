package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class DeleteNotify {
	
	private List<NameValuePair> deleteNotify;

	public List<NameValuePair> getDeleteNotify() {
		return deleteNotify;
	}
	
	public DeleteNotify(String message_id) {
		
		deleteNotify=new ArrayList<NameValuePair>();
		
		//定义Post参数
		deleteNotify.add(new BasicNameValuePair("app","api"));
		deleteNotify.add(new BasicNameValuePair("mod","Notify"));
		deleteNotify.add(new BasicNameValuePair("act","deleteNotify"));
		deleteNotify.add(new BasicNameValuePair("uid","2949163"));
		deleteNotify.add(new BasicNameValuePair("password","123456"));
		deleteNotify.add(new BasicNameValuePair("id",message_id));
	}
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
}
