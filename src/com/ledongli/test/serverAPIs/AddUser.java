package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class AddUser {
	
	private List<NameValuePair> addUser;

	public List<NameValuePair> getAddUser() {
		return addUser;
	}
	
	public AddUser() throws Exception {
		
		addUser=new ArrayList<NameValuePair>();
		
		//定义Post参数
		JSONObject user=new JSONObject();
		user.put("pc","123456");
		user.put("IOS_APN_token", "bba5d957b38b92f91bcb45adfde23064af3239217caa518ec2ccc97166967897");
		addUser.add(new BasicNameValuePair("user",user.toString()));
		addUser.add(new BasicNameValuePair("action","adduser"));		
	}
	
	
}
