package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class User_Followers {
	
	private List<NameValuePair> user_followers;
	
	public List<NameValuePair> getUser_followers() {
		return user_followers;
	}

	public User_Followers(String uid,String password,String user_id) {
		
		user_followers=new ArrayList<NameValuePair>();
		user_followers.add(new BasicNameValuePair("app","api"));
		user_followers.add(new BasicNameValuePair("mod","User"));
		user_followers.add(new BasicNameValuePair("act","user_followers"));
		user_followers.add(new BasicNameValuePair("uid",uid));
		user_followers.add(new BasicNameValuePair("password",password));
		user_followers.add(new BasicNameValuePair("user_id",user_id));
	}
	
	public String getExpectedResult(int Tag) {
		String result=null;
		switch (Tag) {
		case 1:
			
			break;

		default:
			break;
		}
		return result;
	}
	
	
}
