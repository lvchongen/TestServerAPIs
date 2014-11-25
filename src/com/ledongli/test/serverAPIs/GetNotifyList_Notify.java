package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class GetNotifyList_Notify {
	
	private List<NameValuePair> notifyList;

	public List<NameValuePair> getNotifyList() {
		return notifyList;
	}
	
	public GetNotifyList_Notify() {
		
		notifyList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		notifyList.add(new BasicNameValuePair("app","api"));
		notifyList.add(new BasicNameValuePair("mod","Notify"));
		notifyList.add(new BasicNameValuePair("act","getNotifyList"));
		notifyList.add(new BasicNameValuePair("uid","2949163"));
		notifyList.add(new BasicNameValuePair("password","123456"));
		//可选参数
//		notifyList.add(new BasicNameValuePair("since_id",""));
//		notifyList.add(new BasicNameValuePair("max_id",""));
//		notifyList.add(new BasicNameValuePair("count",""));	
	}
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
}
