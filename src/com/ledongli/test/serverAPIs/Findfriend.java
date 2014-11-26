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
	
	public Findfriend(String uid,String password,String name) {
			
		findFriend=new ArrayList<NameValuePair>();
		
		//����Post����
		findFriend.add(new BasicNameValuePair("name", name));
		findFriend.add(new BasicNameValuePair("action", "findfriend"));
		findFriend.add(new BasicNameValuePair("uid", uid));
		findFriend.add(new BasicNameValuePair("pc", password));
	}
}
