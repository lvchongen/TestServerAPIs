package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SetRead {
	
	private List<NameValuePair> setRead;

	public List<NameValuePair> getSetRead() {
		return setRead;
	}
	
	public SetRead() {
		
		setRead=new ArrayList<NameValuePair>();
		
		//定义Post参数
		setRead.add(new BasicNameValuePair("app","api"));
		setRead.add(new BasicNameValuePair("mod","Notify"));
		setRead.add(new BasicNameValuePair("act","setRead"));
		setRead.add(new BasicNameValuePair("uid","2949163"));
		setRead.add(new BasicNameValuePair("password","123456"));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
