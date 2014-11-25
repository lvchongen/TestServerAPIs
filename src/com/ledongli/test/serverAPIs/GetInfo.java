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
	
	public GetInfo() {
		getInfoList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		getInfoList.add(new BasicNameValuePair("action", "getinfo"));
		getInfoList.add(new BasicNameValuePair("uid", "2949206"));
		getInfoList.add(new BasicNameValuePair("pc", "123456"));
	}
}
