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
	
	public Listfans(String uid,String password) {
		
		fansList=new ArrayList<NameValuePair>();
		
		//����Post����
		fansList.add(new BasicNameValuePair("action", "listfans"));
		fansList.add(new BasicNameValuePair("uid", uid));
		fansList.add(new BasicNameValuePair("pc", password));	
		
	}
}
