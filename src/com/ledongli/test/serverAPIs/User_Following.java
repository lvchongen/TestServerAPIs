package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class User_Following {
	
	private List<NameValuePair> user_following;
	
	public List<NameValuePair> getUser_following() {
		return user_following;
	}

	public User_Following(String uid,String password, String user_id) {
		
		user_following=new ArrayList<NameValuePair>();
		
		//定义Post参数
		user_following.add(new BasicNameValuePair("app","api"));
		user_following.add(new BasicNameValuePair("mod","User"));
		user_following.add(new BasicNameValuePair("act","user_following"));
		user_following.add(new BasicNameValuePair("uid",uid));
		user_following.add(new BasicNameValuePair("password",password));
		user_following.add(new BasicNameValuePair("user_id",user_id));
	}
	
	public String getExpectedResult() {
		String result="";
		return result;
	}
}
