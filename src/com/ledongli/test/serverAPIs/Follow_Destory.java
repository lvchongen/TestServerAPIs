package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTML.Tag;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;



public class Follow_Destory {
	
	private List<NameValuePair> follow_destory;
	
	public List<NameValuePair> getFollow_destory() {
		return follow_destory;
	}

	public Follow_Destory(String uid,String password,String user_id) {
		
		follow_destory=new ArrayList<NameValuePair>();
		
		//定义Post参数
		follow_destory.add(new BasicNameValuePair("app","api"));
		follow_destory.add(new BasicNameValuePair("mod","User"));
		follow_destory.add(new BasicNameValuePair("act","follow_destroy"));
		follow_destory.add(new BasicNameValuePair("uid",uid));
		follow_destory.add(new BasicNameValuePair("password",password));
		follow_destory.add(new BasicNameValuePair("user_id",user_id));
	}
	
	public String getExpectedResult(int Tag) {
		String result=null;
		switch (Tag) {
		case 1:
			result="{\"following\":0,\"follower\":0}";
			break;

		case 2:
			result="{\"following\":0,\"follower\":0}";
			break;
		}
		
		
		return result;
	}
	
}
