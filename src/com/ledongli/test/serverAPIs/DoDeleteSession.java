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
	
	public DoDeleteSession(String uid,String password,String ids) {
		
		doDeleteSession=new ArrayList<NameValuePair>();
		
		//����Post����
		doDeleteSession.add(new BasicNameValuePair("app","api"));
		doDeleteSession.add(new BasicNameValuePair("mod","Message"));
		doDeleteSession.add(new BasicNameValuePair("act","doDeleteSession"));
		doDeleteSession.add(new BasicNameValuePair("uid",uid));
		doDeleteSession.add(new BasicNameValuePair("password",password));
		//doDeleteSession.add(new BasicNameValuePair("ids","2783"));
		doDeleteSession.add(new BasicNameValuePair("ids",ids));
	}
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
	
	
}
