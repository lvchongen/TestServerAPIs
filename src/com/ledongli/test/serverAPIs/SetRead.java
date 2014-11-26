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
	
	public SetRead(String uid,String password) {
		
		setRead=new ArrayList<NameValuePair>();
		
		//����Post����
		setRead.add(new BasicNameValuePair("app","api"));
		setRead.add(new BasicNameValuePair("mod","Notify"));
		setRead.add(new BasicNameValuePair("act","setRead"));
		setRead.add(new BasicNameValuePair("uid",uid));
		setRead.add(new BasicNameValuePair("password",password));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
