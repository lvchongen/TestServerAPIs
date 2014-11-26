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
	
	public Padd(String uid,String password) throws JSONException {
		
		paddList=new ArrayList<NameValuePair>();
		
		//����Post����
		JSONObject poi=new JSONObject();
		poi.put("name", "");
		poi.put("category", "");
		poi.put("subCategory", "");
		poi.put("iconUrl", "");
		poi.put("location", "");
		
		paddList.add(new BasicNameValuePair("poi", poi.toString()));
		paddList.add(new BasicNameValuePair("action", "padd"));
		paddList.add(new BasicNameValuePair("uid", uid));
		paddList.add(new BasicNameValuePair("pc", password));	
		
	}
}
