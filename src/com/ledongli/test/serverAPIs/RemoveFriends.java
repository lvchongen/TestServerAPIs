package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class RemoveFriends {
	private List<NameValuePair> removeFiends;

	public List<NameValuePair> getRemoveFiends() {
		return removeFiends;
	}
	
	public RemoveFriends(int[] friends) {
		
		removeFiends=new ArrayList<NameValuePair>();
		
		//定义Post参数
		
		removeFiends.add(new BasicNameValuePair("friends", Arrays.toString(friends)));
		removeFiends.add(new BasicNameValuePair("action", "removefriends"));
		removeFiends.add(new BasicNameValuePair("uid", "2949163"));
		removeFiends.add(new BasicNameValuePair("pc", "123456"));
	}
}
