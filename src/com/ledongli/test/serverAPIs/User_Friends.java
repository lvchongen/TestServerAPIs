package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class User_Friends {
	
	private List<NameValuePair> user_friends;
	
	public List<NameValuePair> getUser_friends() {
		return user_friends;
	}

	public User_Friends(String uid,String password,String user_id) {
		user_friends=new ArrayList<NameValuePair>();
		
		//定义Post参数
		user_friends.add(new BasicNameValuePair("app","api"));
		user_friends.add(new BasicNameValuePair("mod","User"));
		user_friends.add(new BasicNameValuePair("act","user_friends"));
		user_friends.add(new BasicNameValuePair("uid",uid));
		user_friends.add(new BasicNameValuePair("password",password));
		user_friends.add(new BasicNameValuePair("user_id",user_id));
	}
	
	public String getExpectedResult() {
		
		String result="";
		return result;
	}
}
