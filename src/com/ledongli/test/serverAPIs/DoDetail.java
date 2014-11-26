package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class DoDetail {
	
	private List<NameValuePair> doDetail;

	public List<NameValuePair> getDoDetail() {
		return doDetail;
	}
	
	public DoDetail(String uid,String password,String list_id) {
		doDetail=new ArrayList<NameValuePair>();
		
		//定义Post参数
		doDetail.add(new BasicNameValuePair("app","api"));
		doDetail.add(new BasicNameValuePair("mod","Message"));
		doDetail.add(new BasicNameValuePair("act","doDetail"));
		doDetail.add(new BasicNameValuePair("uid",uid));
		doDetail.add(new BasicNameValuePair("password",password));
		doDetail.add(new BasicNameValuePair("id",list_id));
	}
	
		public String getExpectedResult() {
				
				String result="";
				
				return result;
		}
}
