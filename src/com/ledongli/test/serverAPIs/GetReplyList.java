package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class GetReplyList {
	
	private List<NameValuePair> replyList;

	public List<NameValuePair> getReplyList() {
		return replyList;
	}
	
	public GetReplyList() {
		
		replyList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		replyList.add(new BasicNameValuePair("app","api"));
		replyList.add(new BasicNameValuePair("mod","group"));
		replyList.add(new BasicNameValuePair("act","getReplyList"));
		replyList.add(new BasicNameValuePair("uid","1"));
		replyList.add(new BasicNameValuePair("password","111"));
		replyList.add(new BasicNameValuePair("post_id",""));
		replyList.add(new BasicNameValuePair("weiba_id",""));
		replyList.add(new BasicNameValuePair("page",""));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
