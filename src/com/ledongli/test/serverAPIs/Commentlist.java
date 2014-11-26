package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Commentlist {
	
	private List<NameValuePair> commentList;

	public List<NameValuePair> getCommentList() {
		return commentList;
	}
	
	public Commentlist(String uid, String password) {
		
		commentList=new ArrayList<NameValuePair>();
		
		//����Post����
		commentList.add(new BasicNameValuePair("app","api"));
		commentList.add(new BasicNameValuePair("mod","group"));
		commentList.add(new BasicNameValuePair("act","commentList"));
		commentList.add(new BasicNameValuePair("uid",uid));
		commentList.add(new BasicNameValuePair("password",password));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
	
	
}
