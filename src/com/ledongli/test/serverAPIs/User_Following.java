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

	public User_Following() {
		
		user_following=new ArrayList<NameValuePair>();
		
		//定义Post参数
		user_following.add(new BasicNameValuePair("app","api"));
		user_following.add(new BasicNameValuePair("mod","User"));
		user_following.add(new BasicNameValuePair("act","user_following"));
		user_following.add(new BasicNameValuePair("uid","2949163"));
		user_following.add(new BasicNameValuePair("password","123456"));
		user_following.add(new BasicNameValuePair("user_id","2949163"));
	}
	
	public String getExpectedResult() {
		String result="";
		return result;
	}
}
