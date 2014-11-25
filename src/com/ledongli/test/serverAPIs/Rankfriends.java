package com.ledongli.test.serverAPIs;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Rankfriends {
	private List<NameValuePair> ranklList;

	public List<NameValuePair> getRanklList() {
		return ranklList;
	}
	
	public Rankfriends(Double date) {
		ranklList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		ranklList.add(new BasicNameValuePair("date", date.toString()));
		ranklList.add(new BasicNameValuePair("action", "rankfriends"));
		ranklList.add(new BasicNameValuePair("uid", "2949206"));
		ranklList.add(new BasicNameValuePair("pc", "123456"));
	}
}
