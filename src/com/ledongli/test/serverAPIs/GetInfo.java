package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class GetInfo {
	private List<NameValuePair> getInfoList;

	public List<NameValuePair> getGetInfoList() {
		return getInfoList;
	}
	
	public GetInfo(String uid,String password) {
		getInfoList=new ArrayList<NameValuePair>();
		
		//����Post����
		getInfoList.add(new BasicNameValuePair("action", "getinfo"));
		getInfoList.add(new BasicNameValuePair("uid", uid));
		getInfoList.add(new BasicNameValuePair("pc", password));
	}
}
