package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Atmelist {
	
	private List<NameValuePair> atmelist;

	public List<NameValuePair> getAtmelist() {
		return atmelist;
	}
	
	public Atmelist(String uid, String password) {
		
		atmelist=new ArrayList<NameValuePair>();
		
		//定义Post参数
		atmelist.add(new BasicNameValuePair("app","api"));
		atmelist.add(new BasicNameValuePair("mod","group"));
		atmelist.add(new BasicNameValuePair("act","atmelist"));
		atmelist.add(new BasicNameValuePair("uid",uid));
		atmelist.add(new BasicNameValuePair("password",password));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
