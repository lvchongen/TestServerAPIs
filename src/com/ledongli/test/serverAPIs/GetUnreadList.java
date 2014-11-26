package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class GetUnreadList {
	
	private List<NameValuePair> unreadList;

	public List<NameValuePair> getUnreadList() {
		return unreadList;
	}
	
	public GetUnreadList(String uid,String password) {
		
		unreadList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		unreadList.add(new BasicNameValuePair("app","api"));
		unreadList.add(new BasicNameValuePair("mod","Notify"));
		unreadList.add(new BasicNameValuePair("act","getUnreadList"));
		unreadList.add(new BasicNameValuePair("uid",uid));
		unreadList.add(new BasicNameValuePair("password",password));
		//可选参数
//		unreadList.add(new BasicNameValuePair("since_id",""));
//		unreadList.add(new BasicNameValuePair("max_id",""));
//		unreadList.add(new BasicNameValuePair("count",""));
	}
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
	
}
