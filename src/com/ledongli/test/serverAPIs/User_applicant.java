package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class User_applicant {
	
	private List<NameValuePair> user_applicant;

	public List<NameValuePair> getUser_application() {
		return user_applicant;
	}
	
	public User_applicant(String uid,String password) {
		
		user_applicant=new ArrayList<NameValuePair>();
		
		//����Post����
		user_applicant.add(new BasicNameValuePair("app","api"));
		user_applicant.add(new BasicNameValuePair("mod","user"));
		user_applicant.add(new BasicNameValuePair("act","user_applicant"));
		user_applicant.add(new BasicNameValuePair("uid",uid));
		user_applicant.add(new BasicNameValuePair("password",password));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
