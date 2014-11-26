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
	
	public Rankfriends(String uid,String password,Double date) {
		ranklList=new ArrayList<NameValuePair>();
		
		//����Post����
		ranklList.add(new BasicNameValuePair("date", date.toString()));
		ranklList.add(new BasicNameValuePair("action", "rankfriends"));
		ranklList.add(new BasicNameValuePair("uid", uid));
		ranklList.add(new BasicNameValuePair("pc", password));
	}
}
