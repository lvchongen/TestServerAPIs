package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class DoPost {
	
	private List<NameValuePair> doPost;

	public List<NameValuePair> getDoPost() {
		return doPost;
	}

	public DoPost(String user_id) {
		
		doPost=new ArrayList<NameValuePair>();
		
		//定义Post参数
		doPost.add(new BasicNameValuePair("app","api"));
		doPost.add(new BasicNameValuePair("mod","Message"));
		doPost.add(new BasicNameValuePair("act","doPost"));
		doPost.add(new BasicNameValuePair("uid","2949163"));
		doPost.add(new BasicNameValuePair("password","123456"));
		doPost.add(new BasicNameValuePair("to",user_id));
		doPost.add(new BasicNameValuePair("content","This is Test"));
		doPost.add(new BasicNameValuePair("type","1"));
		doPost.add(new BasicNameValuePair("attach_ids",""));
	}
	
	public String getExpectedResult() {
			
		String result="";
			
		return result;
	}
}
