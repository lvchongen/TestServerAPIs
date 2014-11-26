package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Follow_destory_reverse {
	
	private List<NameValuePair> follow_destory_reverse;

	public List<NameValuePair> getFollow_destory_reverse() {
		return follow_destory_reverse;
	}
	
	public Follow_destory_reverse(String uid,String password,String user_id) {
		
		follow_destory_reverse=new ArrayList<NameValuePair>();
		
		//����Post����
		follow_destory_reverse.add(new BasicNameValuePair("app","api"));
		follow_destory_reverse.add(new BasicNameValuePair("mod","user"));
		follow_destory_reverse.add(new BasicNameValuePair("act","follow_destroy_reverse"));
		follow_destory_reverse.add(new BasicNameValuePair("uid",uid));
		follow_destory_reverse.add(new BasicNameValuePair("password",password));
		follow_destory_reverse.add(new BasicNameValuePair("user_id",user_id));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
