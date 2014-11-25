package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Listfans {
	private List<NameValuePair> fansList;

	public List<NameValuePair> getFansList() {
		return fansList;
	}
	
	public Listfans() {
		
		fansList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		fansList.add(new BasicNameValuePair("action", "listfans"));
		fansList.add(new BasicNameValuePair("uid", "2949163"));
		fansList.add(new BasicNameValuePair("pc", "123456"));	
		
	}
}
