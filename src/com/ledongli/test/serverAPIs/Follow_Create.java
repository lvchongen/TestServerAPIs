package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Follow_Create {
	//关注一个用户 follow_create
		private List<NameValuePair> follow_create;
		public Follow_Create(String uid,String password,String user_id) {
			follow_create=new ArrayList<NameValuePair>();
			
			//定义Post参数
			follow_create.add(new BasicNameValuePair("app","api"));
			follow_create.add(new BasicNameValuePair("mod","User"));
			follow_create.add(new BasicNameValuePair("act","follow_create"));
			follow_create.add(new BasicNameValuePair("uid",uid));
			follow_create.add(new BasicNameValuePair("password",password));
			follow_create.add(new BasicNameValuePair("user_id",user_id));

		}
		
//		public Follow_Create(String uid,String password,String user_id) {
//			follow_create=new ArrayList<NameValuePair>();
//			
//			follow_create.add(new BasicNameValuePair("app","api"));
//			follow_create.add(new BasicNameValuePair("mod","User"));
//			follow_create.add(new BasicNameValuePair("act","follow_create"));
//			follow_create.add(new BasicNameValuePair("uid",uid));
//			follow_create.add(new BasicNameValuePair("password",password));
//			follow_create.add(new BasicNameValuePair("user_id",user_id));
//		}
		
		public List<NameValuePair> getFollow_create() {
			
			return follow_create;
		}
		
		public String getExpectedResult(int Tag) {
			String result=null;
			switch (Tag) {
			case 1:
				result="{\"following\":1,\"follower\":0}";
				break;

			case 2:
				result="{\"following\":0,\"follower\":0}";
				break;
			}
			
			return result;
		}		
}
