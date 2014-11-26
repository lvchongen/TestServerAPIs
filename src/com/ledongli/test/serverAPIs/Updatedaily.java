package com.ledongli.test.serverAPIs;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class Updatedaily {
	private List<NameValuePair> updateList;

	public List<NameValuePair> getUpdateList() {
		return updateList;
	}
	
	public Updatedaily(String uid,String password) throws Exception {
		updateList=new ArrayList<NameValuePair>();
		
		//����Post����
		JSONObject stat=new JSONObject();
		stat.put("date", "");
		stat.put("score", "");
		stat.put("steps", "");
		stat.put("energy", "");
		stat.put("report", "");
		stat.put("lat", "");
		stat.put("lon", "");
		stat.put("location", "");
		
		updateList.add(new BasicNameValuePair("stat", stat.toString()));
		updateList.add(new BasicNameValuePair("action", "updatedaily"));
		updateList.add(new BasicNameValuePair("uid", uid));
		updateList.add(new BasicNameValuePair("pc", password));
		
		
		
	}
}
