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
	
	public ListFriends(String uid,String password) {
		friendsList=new ArrayList<NameValuePair>();
		
		//����Post����
		friendsList.add(new BasicNameValuePair("action", "listfriends"));
		friendsList.add(new BasicNameValuePair("uid", uid));
		friendsList.add(new BasicNameValuePair("pc", password));	
	}
}
