package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class DoPostEdit {
	
	private List<NameValuePair> doPostEdit;

	public List<NameValuePair> getDoPostEdit() {
		return doPostEdit;
	}
	
	public DoPostEdit(String uid,String password,String weiba_id, String post_id) {
		
		doPostEdit=new ArrayList<NameValuePair>();
		
		//定义Post参数
		doPostEdit.add(new BasicNameValuePair("app","api"));
		doPostEdit.add(new BasicNameValuePair("mod","group"));
		doPostEdit.add(new BasicNameValuePair("act","doPostEdit"));
		doPostEdit.add(new BasicNameValuePair("uid",uid));
		doPostEdit.add(new BasicNameValuePair("password",password));
		doPostEdit.add(new BasicNameValuePair("weiba_id",weiba_id));
		doPostEdit.add(new BasicNameValuePair("post_id",post_id));
		doPostEdit.add(new BasicNameValuePair("content","This is for editing test"));
		doPostEdit.add(new BasicNameValuePair("title","This is for editing test"));
		doPostEdit.add(new BasicNameValuePair("imgUrls",""));
	}
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
}
