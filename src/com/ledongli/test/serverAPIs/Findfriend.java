package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Findfriend {
	private List<NameValuePair> findFriend;

	public List<NameValuePair> getFindFriend() {
		return findFriend;
	}
	
	public Findfriend(String name) {
			
		findFriend=new ArrayList<NameValuePair>();
		
		//定义Post参数
		findFriend.add(new BasicNameValuePair("name", name));
		findFriend.add(new BasicNameValuePair("action", "findfriend"));
		findFriend.add(new BasicNameValuePair("uid", "2949163"));
		findFriend.add(new BasicNameValuePair("pc", "123456"));
	}
}
