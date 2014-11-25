package com.ledongli.test.common;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.ResponseHandlerInterface;


public class NetworkService {
	
	private CloseableHttpClient httpclient;
	private HttpPost httpPost;
	private CloseableHttpResponse response;
	private HttpEntity entity;
	private String result;
	
	public NetworkService() {
		httpclient = HttpClients.createDefault();
	}
	
	//迁移服务器后地址
	//private String server_staging="http://121.40.189.41/xq/index.php";
	//http://121.40.189.41/xq/index.php?act=getHots&mod=Group&v=3.1%20android&vc=310%20android
	
	//定义测试服务器
	private String server_staging="http://social.api.ledongli.cn:8090/staging/index.php";
		
	public String getServer_staging() {
		return server_staging;
	}
		
		
	private String server_xq_test="http://social.api.ledongli.cn:8090/xq_test/index.php";
		
	public String getServer_xq_test() {
		return server_xq_test;
	}
	
	private String server_io_staging="http://core.api.ledongli.cn/staging/io.ashx?";
	
	public String getServer_io_staging() {
		return server_io_staging;
	}

	public String sendPost(String url, List<NameValuePair> content) throws IOException{
		
		httpPost=new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(content));
		try {
			response=httpclient.execute(httpPost);
			entity=response.getEntity();
			String charset = "UTF-8"; 
			result=EntityUtils.toString(entity,charset);
		} 
		catch (Exception e) {
			
			result=e.getMessage();
			
		} 	
		
		return result;
		
	}
	
	public String sendPostStream(String url, HttpEntity entity) throws IOException{
		
		httpPost=new HttpPost(url);
		httpPost.setEntity(entity);
		try {
			response=httpclient.execute(httpPost);
			entity=response.getEntity();
			String charset = "UTF-8"; 
			result=EntityUtils.toString(entity,charset);
		} 
		catch (Exception e) {
			
			result=e.getMessage();
			
		} 	
		
		return result;
		
	}
	
}
