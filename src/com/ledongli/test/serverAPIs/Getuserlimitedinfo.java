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
	
	public Getuserlimitedinfo(String uid,String password,String targetUid) {
		userlimitList=new ArrayList<NameValuePair>();
		
		//����Post����
		userlimitList.add(new BasicNameValuePair("targetUid", targetUid));
		userlimitList.add(new BasicNameValuePair("action", "getuserlimitedinfo"));
		userlimitList.add(new BasicNameValuePair("uid", uid));
		userlimitList.add(new BasicNameValuePair("pc", password));
	}
}
