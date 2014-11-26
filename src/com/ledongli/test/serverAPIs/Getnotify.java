package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Getnotify {
	private List<NameValuePair> notifyList;

	public List<NameValuePair> getNotiList() {
		return notifyList;
	}
	
	public Getnotify(String uid,String password) {
		notifyList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		notifyList.add(new BasicNameValuePair("action", "getnotify"));
		notifyList.add(new BasicNameValuePair("uid", uid));
		notifyList.add(new BasicNameValuePair("pc", password));	
	}
}
