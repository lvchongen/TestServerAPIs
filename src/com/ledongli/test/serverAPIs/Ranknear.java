package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Ranknear {
	private List<NameValuePair> ranknearList;

	public List<NameValuePair> getRanknearList() {
		return ranknearList;
	}
	
	public Ranknear(Double date) {
		ranknearList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		ranknearList.add(new BasicNameValuePair("date", date.toString()));
		ranknearList.add(new BasicNameValuePair("lat", "0"));
		ranknearList.add(new BasicNameValuePair("lon", "0"));
		ranknearList.add(new BasicNameValuePair("action", "ranknear"));
		ranknearList.add(new BasicNameValuePair("uid", "2949206"));
		ranknearList.add(new BasicNameValuePair("pc", "123456"));	
	}
}
