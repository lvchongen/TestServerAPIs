package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class DoSetIsRead {
	
	private List<NameValuePair> doSetIsRead;

	public List<NameValuePair> getDoSetIsRead() {
		return doSetIsRead;
	}
	
	public DoSetIsRead(String uid,String password) {
		
		doSetIsRead=new ArrayList<NameValuePair>();
		
		//����Post����
		doSetIsRead.add(new BasicNameValuePair("app","api"));
		doSetIsRead.add(new BasicNameValuePair("mod","Message"));
		doSetIsRead.add(new BasicNameValuePair("act","doSetIsRead"));
		doSetIsRead.add(new BasicNameValuePair("uid",uid));
		doSetIsRead.add(new BasicNameValuePair("password",password));
		doSetIsRead.add(new BasicNameValuePair("ids","2783"));
	}
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
}
