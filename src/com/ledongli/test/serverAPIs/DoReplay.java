package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class DoReplay {
	
	private List<NameValuePair> doReply;

	public List<NameValuePair> getDoReplay() {
		return doReply;
	}
	
	public DoReplay(String uid,String password,String id) {
		doReply=new ArrayList<NameValuePair>();
		
		//����Post����
		doReply.add(new BasicNameValuePair("app","api"));
		doReply.add(new BasicNameValuePair("mod","Message"));
		doReply.add(new BasicNameValuePair("act","doReply"));
		doReply.add(new BasicNameValuePair("uid",uid));
		doReply.add(new BasicNameValuePair("password",password));
		doReply.add(new BasicNameValuePair("to",id));
		doReply.add(new BasicNameValuePair("id","236"));
		doReply.add(new BasicNameValuePair("reply_content","This is a replay"));
		//doReply.add(new BasicNameValuePair("attach_ids",""));
	}
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
}
