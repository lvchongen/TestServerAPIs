package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class ListFriends {
	private List<NameValuePair> friendsList;

	public List<NameValuePair> getFriendsList() {
		return friendsList;
	}
	
	public ListFriends() {
		friendsList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		friendsList.add(new BasicNameValuePair("action", "listfriends"));
		friendsList.add(new BasicNameValuePair("uid", "2949163"));
		friendsList.add(new BasicNameValuePair("pc", "123456"));	
	}
}
