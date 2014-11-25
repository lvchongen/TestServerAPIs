package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class DoDelete {
	
	private List<NameValuePair> doDelete;
	
	

	public List<NameValuePair> getDoDelete() {
		return doDelete;
	}
	
	public DoDelete(String idsString) {
		
		doDelete=new ArrayList<NameValuePair>();
		
		//定义Post参数
		doDelete.add(new BasicNameValuePair("app","api"));
		doDelete.add(new BasicNameValuePair("mod","Message"));
		doDelete.add(new BasicNameValuePair("act","doDelete"));
		doDelete.add(new BasicNameValuePair("uid","2949163"));
		doDelete.add(new BasicNameValuePair("password","123456"));
		doDelete.add(new BasicNameValuePair("ids",idsString));
	}
	
	public String getExpectedResult() {
			
			String result="";
			
			return result;
	}
	
	
}
