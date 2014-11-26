package com.ledongli.test.serverAPIs;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class GetEditorImg {
	
	private List<NameValuePair> editorImg;

	public List<NameValuePair> getEditorImg() {
		return editorImg;
	}
	
	public GetEditorImg(String uid,String password,String weiba_id,String post_id) {
		
		editorImg=new ArrayList<NameValuePair>();
		
		//定义Post参数
		editorImg.add(new BasicNameValuePair("app","api"));
		editorImg.add(new BasicNameValuePair("mod","group"));
		editorImg.add(new BasicNameValuePair("act","getEditorImg"));
		editorImg.add(new BasicNameValuePair("uid",uid));
		editorImg.add(new BasicNameValuePair("password",password));
		editorImg.add(new BasicNameValuePair("weiba_id",weiba_id));
		editorImg.add(new BasicNameValuePair("post_id",post_id));
	}
	
	public String getExpectedResult() {
		
		String result="";
		
		return result;
	}
}
