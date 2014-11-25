package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Getuserlimitedinfo {
	private List<NameValuePair> userlimitList;

	public List<NameValuePair> getUserlimitList() {
		return userlimitList;
	}
	
	public Getuserlimitedinfo(String targetUid) {
		userlimitList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		userlimitList.add(new BasicNameValuePair("targetUid", targetUid));
		userlimitList.add(new BasicNameValuePair("action", "getuserlimitedinfo"));
		userlimitList.add(new BasicNameValuePair("uid", "2949206"));
		userlimitList.add(new BasicNameValuePair("pc", "123456"));
	}
}
