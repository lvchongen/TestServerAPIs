package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.ledongli.test.common.NetworkService;

public class Addfriends {
	private List<NameValuePair> addfriendsList;

	public List<NameValuePair> getAddfriendsList() {
		return addfriendsList;
	}
	
	public Addfriends(int[] friends) {
		
		addfriendsList=new ArrayList<NameValuePair>();
		
		//定义Post参数
		//System.out.print(Arrays.toString(friends));
		
		addfriendsList.add(new BasicNameValuePair("friends",Arrays.toString(friends)));
		addfriendsList.add(new BasicNameValuePair("action", "addfriends"));
		addfriendsList.add(new BasicNameValuePair("uid", "2949163"));
		addfriendsList.add(new BasicNameValuePair("pc", "123456"));	
		
	}
	
	public String getResult() {
		String result=null;
		//Get expected result
		
		return result;
	}
}
