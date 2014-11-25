package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class DoInBox {
	
	private List<NameValuePair> doInBox;
	
	public List<NameValuePair> getDoInBox() {
		return doInBox;
	}

	public DoInBox() {
		doInBox=new ArrayList<NameValuePair>();
		
		//定义Post参数
		doInBox.add(new BasicNameValuePair("app","api"));
		doInBox.add(new BasicNameValuePair("mod","Message"));
		doInBox.add(new BasicNameValuePair("act","doInbox"));
		doInBox.add(new BasicNameValuePair("uid","2949163"));
		doInBox.add(new BasicNameValuePair("password","123456"));
		
		//可选参数
//		doInBox.add(new BasicNameValuePair("since_id",""));
//		doInBox.add(new BasicNameValuePair("count",""));
//		doInBox.add(new BasicNameValuePair("max_id",""));
//		doInBox.add(new BasicNameValuePair("page",""));
	}
	
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
	
}
