package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class Padd {
	
	private List<NameValuePair> paddList;

	public List<NameValuePair> getPaddList() {
		return paddList;
	}
	
	public Padd() throws JSONException {
		
		paddList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		JSONObject poi=new JSONObject();
		poi.put("name", "");
		poi.put("category", "");
		poi.put("subCategory", "");
		poi.put("iconUrl", "");
		poi.put("location", "");
		
		paddList.add(new BasicNameValuePair("poi", poi.toString()));
		paddList.add(new BasicNameValuePair("action", "padd"));
		paddList.add(new BasicNameValuePair("uid", "1"));
		paddList.add(new BasicNameValuePair("pc", "111"));	
		
	}
}
