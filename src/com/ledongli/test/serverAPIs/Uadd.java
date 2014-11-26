package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;



public class Uadd {
	
	private List<NameValuePair> uaddList;

	public List<NameValuePair> getUaddList() {
		return uaddList;
	}
	
	public Uadd(String uid,String password) throws Exception {
		
		uaddList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		JSONObject payload=new JSONObject();
		payload.put("time","");
		payload.put("atype", "");
		payload.put("i1", "");
		payload.put("i2", "");
		payload.put("i3", "");
		payload.put("f1", "");
		payload.put("f2", "");
		payload.put("f3", "");
		payload.put("t1", "");
		payload.put("isReplace", "");		
		
		uaddList.add(new BasicNameValuePair("payload", payload.toString()));
		uaddList.add(new BasicNameValuePair("action", "uadd"));
		uaddList.add(new BasicNameValuePair("uid", uid));
		uaddList.add(new BasicNameValuePair("pc", password));		
	}
	
	
}
