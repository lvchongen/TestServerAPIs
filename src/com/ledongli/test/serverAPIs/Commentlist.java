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
	
	public Commentlist() {
		
		commentList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		commentList.add(new BasicNameValuePair("app","api"));
		commentList.add(new BasicNameValuePair("mod","group"));
		commentList.add(new BasicNameValuePair("act","commentList"));
		commentList.add(new BasicNameValuePair("uid","2949163"));
		commentList.add(new BasicNameValuePair("password","123456"));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
	
	
}
