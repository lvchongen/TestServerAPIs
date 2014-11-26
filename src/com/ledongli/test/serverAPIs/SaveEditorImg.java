package com.ledongli.test.serverAPIs;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.message.BasicNameValuePair;

import com.ledongli.test.common.AndroidRequestParams;
import com.loopj.android.http.RequestParams;

public class SaveEditorImg {
	
	private HttpEntity httpEntity;
	
	public HttpEntity getSaveEditorImg() {
		return httpEntity;
	}
	
	public SaveEditorImg(String uid,String password,FileBody fileBody) {
		
		MultipartEntityBuilder builder=MultipartEntityBuilder.create();
		builder.addTextBody("app","api");
		builder.addTextBody("mod","group");
		builder.addTextBody("act","saveEditorImg");
		builder.addTextBody("uid",uid);
		builder.addTextBody("password",password);
		builder.addPart("imgFile", fileBody);
		
		httpEntity=builder.build();
		
	}
	
	
}
