package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class DoDeleteSession {
	
	private List<NameValuePair> doDeleteSession;

	public List<NameValuePair> getDoDeleteSession() {
		return doDeleteSession;
	}
	
	public DoDeleteSession(String ids) {
		
		doDeleteSession=new ArrayList<NameValuePair>();
		
		//定义Post参数
		doDeleteSession.add(new BasicNameValuePair("app","api"));
		doDeleteSession.add(new BasicNameValuePair("mod","Message"));
		doDeleteSession.add(new BasicNameValuePair("act","doDeleteSession"));
		doDeleteSession.add(new BasicNameValuePair("uid","2949163"));
		doDeleteSession.add(new BasicNameValuePair("password","123456"));
		//doDeleteSession.add(new BasicNameValuePair("ids","2783"));
		doDeleteSession.add(new BasicNameValuePair("ids",ids));
	}
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
	
	
}
