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

	public User_Friends(String user_id) {
		user_friends=new ArrayList<NameValuePair>();
		
		//����Post����
		user_friends.add(new BasicNameValuePair("app","api"));
		user_friends.add(new BasicNameValuePair("mod","User"));
		user_friends.add(new BasicNameValuePair("act","user_friends"));
		user_friends.add(new BasicNameValuePair("uid","2949163"));
		user_friends.add(new BasicNameValuePair("password","123456"));
		user_friends.add(new BasicNameValuePair("user_id",user_id));
	}
	
	public String getExpectedResult() {
		
		String result="";
		return result;
	}
}
